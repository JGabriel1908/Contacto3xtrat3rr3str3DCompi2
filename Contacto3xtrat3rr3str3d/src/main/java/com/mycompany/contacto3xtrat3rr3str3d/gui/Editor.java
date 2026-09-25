package com.mycompany.contacto3xtrat3rr3str3d.gui;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.AnalizadorSintactico;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ErrorCompilacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.Lenguaje;
import com.mycompany.contacto3xtrat3rr3str3d.gui.resaltado.Resaltador;
import com.mycompany.contacto3xtrat3rr3str3d.gui.resaltado.Tema;
import com.mycompany.contacto3xtrat3rr3str3d.utils.Archivos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.ToolTipManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.LayeredHighlighter;
import javax.swing.text.Position;
import javax.swing.text.View;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

/**
 * Pestaña de edición de un archivo: texto con coloreado, números de línea, deshacer/rehacer,
 * indentación automática y marcado de errores léxicos/sintácticos mientras se escribe.
 */
public class Editor extends JPanel {

    private static final String SANGRIA = "    ";
    private static final int ESPERA_ANALISIS_MS = 500;
    private static final Highlighter.HighlightPainter PINTOR_ERROR = new PintorOndulado(Tema.ERROR);

    private record Marca(Object etiqueta, ErrorCompilacion error) {
    }

    private File archivo;
    private Lenguaje lenguaje;
    private final JTextPane texto;
    private final NumerosLinea numeros;
    private final Resaltador resaltador;
    private final UndoManager historial = new UndoManager();
    private final Timer temporizadorAnalisis;
    private final List<Marca> marcas = new ArrayList<>();
    private boolean modificado;
    private Runnable alCambiarEstado = () -> {
    };
    private Runnable alMoverCursor = () -> {
    };

    public Editor(File archivo, String contenido, int tamanoFuente) {
        super(new BorderLayout());
        this.archivo = archivo;
        this.lenguaje = Lenguaje.desdeArchivo(archivo);

        texto = new JTextPane() {
            // Sin ajuste de línea: la vista crece horizontalmente y aparece la barra de desplazamiento
            @Override
            public boolean getScrollableTracksViewportWidth() {
                Container padre = getParent();
                return padre == null || getUI().getPreferredSize(this).width <= padre.getWidth();
            }

            @Override
            public String getToolTipText(MouseEvent evento) {
                return mensajeErrorEn(viewToModel2D(evento.getPoint()));
            }
        };
        ToolTipManager.sharedInstance().registerComponent(texto);
        texto.setHighlighter(new ResaltadorLineaActual());
        texto.setBackground(Tema.FONDO);
        texto.setForeground(Tema.TEXTO);
        texto.setCaretColor(Color.WHITE);
        texto.setSelectionColor(Tema.SELECCION);
        texto.setSelectedTextColor(null);
        texto.setFocusTraversalKeysEnabled(false);
        texto.setBorder(BorderFactory.createEmptyBorder(2, 6, 2, 6));
        texto.setFont(Tema.fuenteEditor(tamanoFuente));
        texto.setText(contenido);
        texto.setCaretPosition(0);

        resaltador = new Resaltador(texto);
        numeros = new NumerosLinea(texto);

        JScrollPane scroll = new JScrollPane(texto);
        scroll.setRowHeaderView(numeros);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.getViewport().setBackground(Tema.FONDO);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.getHorizontalScrollBar().setUnitIncrement(16);
        add(scroll, BorderLayout.CENTER);

        temporizadorAnalisis = new Timer(ESPERA_ANALISIS_MS, e -> analizarEnVivo());
        temporizadorAnalisis.setRepeats(false);

        // Los oyentes se agregan después de cargar el contenido para no marcarlo como modificado
        texto.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                alEditar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                alEditar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        texto.getDocument().addUndoableEditListener(e -> {
            // Los cambios de estilo del coloreado no se deshacen
            if (e.getEdit() instanceof AbstractDocument.DefaultDocumentEvent evento
                    && evento.getType() == DocumentEvent.EventType.CHANGE) {
                return;
            }
            historial.addEdit(e.getEdit());
        });
        texto.addCaretListener(e -> {
            texto.repaint();
            alMoverCursor.run();
        });
        configurarTeclas();

        resaltador.setLenguaje(lenguaje);
        analizarEnVivo();
    }

    // ------------------------------------------------------------------ estado

    public File getArchivo() {
        return archivo;
    }

    public String getNombre() {
        return archivo.getName();
    }

    public Lenguaje getLenguaje() {
        return lenguaje;
    }

    public String getTexto() {
        return texto.getText();
    }

    public boolean isModificado() {
        return modificado;
    }

    public void setAlCambiarEstado(Runnable accion) {
        this.alCambiarEstado = accion;
    }

    public void setAlMoverCursor(Runnable accion) {
        this.alMoverCursor = accion;
    }

    /** Cambia el archivo asociado (guardar como / renombrar) y actualiza el lenguaje. */
    public void setArchivo(File nuevo) {
        this.archivo = nuevo;
        Lenguaje nuevoLenguaje = Lenguaje.desdeArchivo(nuevo);
        if (nuevoLenguaje != lenguaje) {
            lenguaje = nuevoLenguaje;
            resaltador.setLenguaje(lenguaje);
            analizarEnVivo();
        }
        alCambiarEstado.run();
    }

    public void guardar() throws IOException {
        Archivos.escribir(archivo, getTexto());
        setModificado(false);
    }

    private void setModificado(boolean valor) {
        if (modificado != valor) {
            modificado = valor;
            alCambiarEstado.run();
        }
    }

    private void alEditar() {
        setModificado(true);
        temporizadorAnalisis.restart();
    }

    // ------------------------------------------------------------------ acciones

    public void deshacer() {
        try {
            if (historial.canUndo()) historial.undo();
        } catch (CannotUndoException ignorada) {
            // Nada que deshacer
        }
    }

    public void rehacer() {
        try {
            if (historial.canRedo()) historial.redo();
        } catch (CannotRedoException ignorada) {
            // Nada que rehacer
        }
    }

    public void enfocar() {
        texto.requestFocusInWindow();
    }

    public int getLinea() {
        return texto.getDocument().getDefaultRootElement().getElementIndex(texto.getCaretPosition()) + 1;
    }

    public int getColumna() {
        Element raiz = texto.getDocument().getDefaultRootElement();
        int pos = texto.getCaretPosition();
        return pos - raiz.getElement(raiz.getElementIndex(pos)).getStartOffset() + 1;
    }

    /** Mueve el cursor a una línea (base 1) y columna (base 0). */
    public void irA(int linea, int columna) {
        Element raiz = texto.getDocument().getDefaultRootElement();
        Element elemento = raiz.getElement(Math.max(0, Math.min(linea - 1, raiz.getElementCount() - 1)));
        int largo = elemento.getEndOffset() - elemento.getStartOffset() - 1;
        int pos = elemento.getStartOffset() + Math.max(0, Math.min(columna, largo));
        texto.setCaretPosition(Math.min(pos, texto.getDocument().getLength()));
        try {
            Rectangle2D r = texto.modelToView2D(texto.getCaretPosition());
            if (r != null) {
                Rectangle visible = r.getBounds();
                visible.grow(0, texto.getVisibleRect().height / 3);
                texto.scrollRectToVisible(visible);
            }
        } catch (BadLocationException ignorada) {
            // Posición fuera del documento
        }
        enfocar();
    }

    // ------------------------------------------------------------------ errores

    private void analizarEnVivo() {
        temporizadorAnalisis.stop();
        if (lenguaje == null) {
            marcarErrores(List.of());
            return;
        }
        marcarErrores(AnalizadorSintactico.analizar(getTexto(), lenguaje, archivo.getPath()).errores());
    }

    /** Subraya los errores en el texto y los marca en el margen. */
    public void marcarErrores(List<ErrorCompilacion> errores) {
        Highlighter resaltador = texto.getHighlighter();
        for (Marca m : marcas) resaltador.removeHighlight(m.etiqueta());
        marcas.clear();

        Set<Integer> lineas = new HashSet<>();
        for (ErrorCompilacion error : errores) {
            int[] rango = rango(error);
            if (rango == null) continue;
            try {
                marcas.add(new Marca(resaltador.addHighlight(rango[0], rango[1], PINTOR_ERROR), error));
                lineas.add(error.linea());
            } catch (BadLocationException ignorada) {
                // El texto cambió mientras se analizaba
            }
        }
        numeros.setLineasError(lineas);
    }

    private int[] rango(ErrorCompilacion error) {
        Document doc = texto.getDocument();
        int n = doc.getLength();
        if (n == 0) return null;
        Element raiz = doc.getDefaultRootElement();
        Element linea = raiz.getElement(Math.max(0, Math.min(error.linea() - 1, raiz.getElementCount() - 1)));
        int inicioLinea = linea.getStartOffset();
        int finLinea = Math.min(linea.getEndOffset() - 1, n);
        int inicio = Math.min(inicioLinea + Math.max(0, error.columna()), finLinea);
        int fin = Math.min(inicio + Math.max(1, error.longitud()), finLinea);
        if (fin <= inicio) {
            // Error al final de la línea: se marca el último carácter
            if (inicio > inicioLinea) {
                inicio--;
                fin = inicio + 1;
            } else {
                fin = Math.min(inicio + 1, n);
            }
        }
        return new int[]{inicio, fin};
    }

    private String mensajeErrorEn(int posicion) {
        for (Marca m : marcas) {
            Highlighter.Highlight h = (Highlighter.Highlight) m.etiqueta();
            if (posicion >= h.getStartOffset() && posicion <= h.getEndOffset()) {
                return "Error " + m.error().tipo().toString().toLowerCase() + ": " + m.error().descripcion();
            }
        }
        return null;
    }

    // ------------------------------------------------------------------ teclado

    private void configurarTeclas() {
        registrar(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0), "indentar", this::indentar);
        registrar(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "nuevaLinea", this::nuevaLinea);
    }

    private void registrar(KeyStroke tecla, String nombre, Runnable accion) {
        texto.getInputMap().put(tecla, nombre);
        texto.getActionMap().put(nombre, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accion.run();
            }
        });
    }

    /** Tab: inserta espacios hasta el siguiente múltiplo de 4. */
    private void indentar() {
        int columna = getColumna() - 1;
        texto.replaceSelection(" ".repeat(SANGRIA.length() - columna % SANGRIA.length()));
    }

    /** Enter: conserva la indentación y la aumenta si la línea abre un bloque. */
    private void nuevaLinea() {
        try {
            Document doc = texto.getDocument();
            int pos = texto.getSelectionStart();
            Element linea = doc.getDefaultRootElement().getElement(doc.getDefaultRootElement().getElementIndex(pos));
            String antes = doc.getText(linea.getStartOffset(), pos - linea.getStartOffset());

            int espacios = 0;
            while (espacios < antes.length() && (antes.charAt(espacios) == ' ' || antes.charAt(espacios) == '\t')) {
                espacios++;
            }
            String sangria = antes.substring(0, espacios);
            String codigo = antes;
            int comentario = codigo.indexOf("//");
            if (comentario >= 0) codigo = codigo.substring(0, comentario);
            codigo = codigo.strip();

            boolean abreBloque = lenguaje == Lenguaje.Y
                    ? codigo.endsWith(":") || codigo.endsWith("entonces") || codigo.endsWith("hacer")
                            || codigo.equals("contrario")
                    : codigo.endsWith("{");

            int finSeleccion = texto.getSelectionEnd();
            boolean cierraDespues = finSeleccion < doc.getLength() && doc.getText(finSeleccion, 1).equals("}");

            if (abreBloque && cierraDespues) {
                // Entre llaves: {|}  ->  {\n    |\n}
                texto.replaceSelection("\n" + sangria + SANGRIA + "\n" + sangria);
                texto.setCaretPosition(pos + 1 + sangria.length() + SANGRIA.length());
            } else {
                texto.replaceSelection("\n" + sangria + (abreBloque ? SANGRIA : ""));
            }
        } catch (BadLocationException e) {
            texto.replaceSelection("\n");
        }
    }

    // ------------------------------------------------------------------ pintado

    /** Pinta el fondo de la línea del cursor antes que el texto y las selecciones. */
    private final class ResaltadorLineaActual extends DefaultHighlighter {
        @Override
        public void paint(Graphics g) {
            try {
                Rectangle2D r = texto.modelToView2D(texto.getCaretPosition());
                if (r != null) {
                    g.setColor(Tema.LINEA_ACTUAL);
                    g.fillRect(0, (int) r.getY(), texto.getWidth(), (int) Math.ceil(r.getHeight()));
                }
            } catch (BadLocationException ignorada) {
                // Cursor fuera del documento
            }
            super.paint(g);
        }
    }

    /** Subrayado ondulado para los errores. */
    private static final class PintorOndulado extends LayeredHighlighter.LayerPainter {
        private final Color color;

        PintorOndulado(Color color) {
            this.color = color;
        }

        @Override
        public void paint(Graphics g, int p0, int p1, Shape limites, JTextComponent c) {
            // Solo se usa paintLayer
        }

        @Override
        public Shape paintLayer(Graphics g, int p0, int p1, Shape limites, JTextComponent c, View vista) {
            Rectangle r;
            try {
                if (p0 == vista.getStartOffset() && p1 == vista.getEndOffset()) {
                    r = limites.getBounds();
                } else {
                    r = vista.modelToView(p0, Position.Bias.Forward, p1, Position.Bias.Backward, limites).getBounds();
                }
            } catch (BadLocationException e) {
                return null;
            }
            g.setColor(color);
            int y = r.y + r.height - 2;
            int fin = r.x + Math.max(r.width, 6);
            for (int x = r.x; x < fin; x += 4) {
                g.drawLine(x, y, x + 2, y - 2);
                g.drawLine(x + 2, y - 2, x + 4, y);
            }
            return r;
        }
    }
}
