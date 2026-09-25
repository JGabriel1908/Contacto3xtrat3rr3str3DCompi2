package com.mycompany.contacto3xtrat3rr3str3d.gui.resaltado;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.Lenguaje;
import java.awt.Font;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;

/**
 * Coloreado de código en tiempo real.
 *
 * Cada vez que el documento cambia (con una pequeña espera para no recalcular en cada tecla)
 * se vuelve a ejecutar el lexer del lenguaje sobre todo el texto y se aplica el estilo de la
 * categoría de cada token directamente sobre el StyledDocument.
 */
public class Resaltador {

    private static final int ESPERA_MS = 80;

    private final JTextPane texto;
    private final Timer temporizador;
    private final Map<Categoria, AttributeSet> estilos = new EnumMap<>(Categoria.class);
    private Lenguaje lenguaje;
    private Categoria[] categorias;

    public Resaltador(JTextPane texto) {
        this.texto = texto;
        this.temporizador = new Timer(ESPERA_MS, e -> resaltar());
        this.temporizador.setRepeats(false);
        setFuente(texto.getFont());
        texto.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                temporizador.restart();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                temporizador.restart();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Cambios de estilo: los provoca el propio resaltador
            }
        });
    }

    public void setLenguaje(Lenguaje lenguaje) {
        this.lenguaje = lenguaje;
        this.categorias = lenguaje == null ? null : ClasificadorTokens.categorias(lenguaje);
        resaltar();
    }

    public void setFuente(Font fuente) {
        for (Categoria c : Categoria.values()) {
            estilos.put(c, Tema.estilo(c, fuente));
        }
        resaltar();
    }

    public void resaltar() {
        temporizador.stop();
        StyledDocument doc = texto.getStyledDocument();
        String contenido;
        try {
            contenido = doc.getText(0, doc.getLength());
        } catch (BadLocationException e) {
            return;
        }
        doc.setCharacterAttributes(0, contenido.length(), estilos.get(Categoria.NORMAL), true);
        if (lenguaje == null || contenido.isEmpty()) return;

        Lexer lexer = lenguaje.crearLexer(CharStreams.fromString(contenido));
        lexer.removeErrorListeners();
        List<? extends Token> tokens = lexer.getAllTokens();
        int[] mapa = mapaPosiciones(contenido);

        for (int i = 0; i < tokens.size(); i++) {
            Token t = tokens.get(i);
            int tipo = t.getType();
            if (tipo <= 0 || tipo >= categorias.length) continue;
            Categoria categoria = categorias[tipo];
            if (categoria == Categoria.NORMAL) continue;
            if (categoria == Categoria.IDENTIFICADOR && siguienteEsParentesis(tokens, i)) {
                categoria = Categoria.LLAMADA;
            }
            int inicio = t.getStartIndex();
            int fin = t.getStopIndex() + 1;
            if (inicio < 0 || fin <= inicio) continue;
            if (mapa != null) {
                inicio = mapa[inicio];
                fin = mapa[fin];
            }
            doc.setCharacterAttributes(inicio, fin - inicio, estilos.get(categoria), true);
        }
    }

    private static boolean siguienteEsParentesis(List<? extends Token> tokens, int i) {
        for (int j = i + 1; j < tokens.size(); j++) {
            Token t = tokens.get(j);
            if (t.getChannel() != Token.DEFAULT_CHANNEL) continue;
            return "(".equals(t.getText());
        }
        return false;
    }

    /**
     * ANTLR indexa por code points y Swing por caracteres UTF-16. Solo difieren si el texto
     * tiene caracteres fuera del plano básico (p. ej. emojis); en ese caso se construye un mapa.
     */
    private static int[] mapaPosiciones(String s) {
        int puntos = s.codePointCount(0, s.length());
        if (puntos == s.length()) return null;
        int[] mapa = new int[puntos + 1];
        int indice = 0;
        for (int cp = 0; cp < puntos; cp++) {
            mapa[cp] = indice;
            indice += Character.charCount(s.codePointAt(indice));
        }
        mapa[puntos] = indice;
        return mapa;
    }
}
