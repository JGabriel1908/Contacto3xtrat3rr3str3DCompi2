package com.mycompany.contacto3xtrat3rr3str3d.gui;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.CargadorProyecto;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ErrorCompilacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.Lenguaje;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Programa;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ErrorGeneracion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.GeneradorC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.TablaSimbolos;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.AnalizadorSemantico;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.TablaCompatibilidad;
import com.mycompany.contacto3xtrat3rr3str3d.gui.resaltado.Tema;
import com.mycompany.contacto3xtrat3rr3str3d.utils.Archivos;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Ventana principal de la IDE.
 */
public class Ide extends JFrame {

    private static final String TITULO = "Contacto 3xtrat3rr3str3D";
    private static final String CLAVE_CARPETA = "ultimaCarpeta";
    private static final String CLAVE_DIRECTORIO = "ultimoDirectorio";
    private static final int TAMANO_FUENTE = 14;

    private final Preferences preferencias = Preferences.userNodeForPackage(Ide.class);
    private final ArbolArchivos arbol;
    private final JTabbedPane pestanas = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
    private final CardLayout tarjetasCentro = new CardLayout();
    private final JPanel centro = new JPanel(tarjetasCentro);
    private final TablaErrores modeloErrores = new TablaErrores();
    private final JTable tablaErrores = new JTable(modeloErrores);
    private final JLabel estado = new JLabel(" ");

    public Ide() {
        super(TITULO);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                salir();
            }

            @Override
            public void windowActivated(WindowEvent e) {
                revisarCambiosExternos();
            }
        });
        setSize(1200, 780);
        setMinimumSize(new Dimension(800, 500));
        setLocationRelativeTo(null);

        arbol = new ArbolArchivos(new ArbolArchivos.Acciones() {
            @Override
            public void abrir(File archivo) {
                abrirArchivo(archivo);
            }

            @Override
            public void renombrado(File antes, File despues) {
                archivoRenombrado(antes, despues);
            }

            @Override
            public void eliminado(File archivo) {
                archivoEliminado(archivo);
            }
        });

        setJMenuBar(crearMenu());

        JLabel bienvenida = new JLabel("Abre un archivo o una carpeta desde el menú Archivo.", SwingConstants.CENTER);
        JPanel panelBienvenida = new JPanel(new GridBagLayout());
        panelBienvenida.add(bienvenida);
        centro.add(panelBienvenida, "bienvenida");
        centro.add(pestanas, "editores");
        pestanas.addChangeListener(e -> actualizarEstado());

        // Tamaño fijo para que un archivo largo no aplaste el panel de errores
        centro.setPreferredSize(new Dimension(600, 400));
        JSplitPane vertical = new JSplitPane(JSplitPane.VERTICAL_SPLIT, centro, crearPanelErrores());
        vertical.setResizeWeight(1.0);
        arbol.setPreferredSize(new Dimension(230, 0));
        JSplitPane horizontal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, arbol, vertical);

        estado.setBorder(BorderFactory.createEmptyBorder(2, 8, 2, 8));
        JPanel contenido = new JPanel(new BorderLayout());
        contenido.add(horizontal, BorderLayout.CENTER);
        contenido.add(estado, BorderLayout.SOUTH);
        setContentPane(contenido);

        String ultima = preferencias.get(CLAVE_CARPETA, null);
        if (ultima != null && new File(ultima).isDirectory()) arbol.setRaiz(new File(ultima));
        actualizarEstado();
    }

    //Interfaz
    private JMenuBar crearMenu() {
        JMenuBar barra = new JMenuBar();

        JMenu archivo = new JMenu("Archivo");
        archivo.add(item("Nuevo archivo", this::nuevoArchivo));
        archivo.add(item("Nueva carpeta", this::nuevaCarpeta));
        archivo.addSeparator();
        archivo.add(item("Abrir archivo", this::abrirArchivo));
        archivo.add(item("Abrir carpeta", this::abrirCarpeta));
        archivo.addSeparator();
        archivo.add(item("Guardar", this::guardar));
        archivo.add(item("Guardar como", this::guardarComo));
        archivo.add(item("Guardar todo", this::guardarTodo));
        archivo.addSeparator();
        archivo.add(item("Descargar archivo", this::descargarArchivo));
        archivo.add(item("Descargar carpeta (.zip)", this::descargarCarpeta));
        archivo.addSeparator();
        archivo.add(item("Salir", this::salir));
        barra.add(archivo);

        JMenu editar = new JMenu("Editar");
        editar.add(item("Deshacer", () -> conEditor(Editor::deshacer)));
        editar.add(item("Rehacer", () -> conEditor(Editor::rehacer)));
        barra.add(editar);

        JMenu compilar = new JMenu("Compilar");
        compilar.add(item("Analizar", this::analizar));
        compilar.add(item("Traducir", this::traducir));
        barra.add(compilar);

        JMenu ayuda = new JMenu("Ayuda");
        ayuda.add(item("Tabla de compatibilidad de tipos", this::mostrarTablaCompatibilidad));
        ayuda.add(item("Acerca de", this::acercaDe));
        barra.add(ayuda);
        return barra;
    }

    private JComponent crearPanelErrores() {
        tablaErrores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaErrores.setFillsViewportHeight(true);
        int[] anchos = {35, 85, 560, 130, 55, 65};
        for (int i = 0; i < anchos.length; i++) {
            tablaErrores.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        tablaErrores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tablaErrores.rowAtPoint(e.getPoint());
                if (e.getClickCount() == 2 && fila >= 0) irAError(modeloErrores.getError(fila));
            }
        });
        JTabbedPane panel = new JTabbedPane();
        panel.addTab("Errores", new JScrollPane(tablaErrores));
        panel.setPreferredSize(new Dimension(0, 190));
        return panel;
    }

    private static JMenuItem item(String texto, Runnable accion) {
        JMenuItem item = new JMenuItem(texto);
        item.addActionListener(e -> accion.run());
        return item;
    }

    //Creo pestaas
    private Editor editorActual() {
        return pestanas.getSelectedComponent() instanceof Editor e ? e : null;
    }

    private List<Editor> editores() {
        List<Editor> lista = new ArrayList<>();
        for (int i = 0; i < pestanas.getTabCount(); i++) {
            if (pestanas.getComponentAt(i) instanceof Editor e) lista.add(e);
        }
        return lista;
    }

    private Editor buscarEditor(File archivo) {
        for (Editor e : editores()) {
            if (Archivos.mismoArchivo(e.getArchivo(), archivo)) return e;
        }
        return null;
    }

    private void conEditor(java.util.function.Consumer<Editor> accion) {
        Editor e = editorActual();
        if (e != null) accion.accept(e);
    }

    public void abrirArchivo(File archivo) {
        archivo = archivo.getAbsoluteFile();
        Editor existente = buscarEditor(archivo);
        if (existente != null) {
            pestanas.setSelectedComponent(existente);
            if (!existente.isModificado() && existente.cambioEnDisco() && archivo.isFile()) {
                try {
                    existente.recargar();
                } catch (IOException ex) {
                    error("No se pudo recargar " + archivo.getName() + ": " + ex.getMessage());
                }
            }
            return;
        }
        Archivos.Contenido contenido;
        try {
            contenido = Archivos.abrir(archivo);
        } catch (IOException ex) {
            error("No se pudo abrir " + archivo.getName() + ": " + ex.getMessage());
            return;
        }
        Editor editor = new Editor(archivo, contenido, TAMANO_FUENTE);
        editor.setAlCambiarEstado(() -> actualizarPestana(editor));
        editor.setAlMoverCursor(this::actualizarEstado);
        pestanas.addTab(archivo.getName(), editor);
        int indice = pestanas.indexOfComponent(editor);
        pestanas.setTabComponentAt(indice, new PestanaCerrable(editor));
        actualizarPestana(editor);
        pestanas.setSelectedIndex(indice);
        tarjetasCentro.show(centro, "editores");
        editor.enfocar();
        recordarDirectorio(archivo);
        if (arbol.getRaiz() == null) {
            abrirEnArbol(archivo.getParentFile());
        } else if (Archivos.contiene(arbol.getRaiz(), archivo)) {
            arbol.seleccionar(archivo);
        }
    }

    private void revisarCambiosExternos() {
        for (Editor e : editores()) {
            if (e.isModificado() || !e.cambioEnDisco() || !e.getArchivo().isFile()) continue;
            try {
                e.recargar();
            } catch (IOException ignorada) {
                // se conserva el texto del editor
            }
        }
        arbol.actualizar();
    }

    private void actualizarPestana(Editor editor) {
        int indice = pestanas.indexOfComponent(editor);
        if (indice < 0) return;
        if (pestanas.getTabComponentAt(indice) instanceof PestanaCerrable p) p.actualizar();
        pestanas.setToolTipTextAt(indice, editor.getArchivo().getPath());
        actualizarEstado();
    }

    private boolean cerrar(Editor editor) {
        if (editor.isModificado()) {
            pestanas.setSelectedComponent(editor);
            int r = JOptionPane.showConfirmDialog(this,
                    "¿Guardar los cambios de " + editor.getNombre() + "?", "Cambios sin guardar",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (r == JOptionPane.YES_OPTION) {
                if (!guardar(editor)) return false;
            } else if (r != JOptionPane.NO_OPTION) {
                return false;
            }
        }
        pestanas.remove(editor);
        if (pestanas.getTabCount() == 0) tarjetasCentro.show(centro, "bienvenida");
        actualizarEstado();
        return true;
    }

    private void actualizarEstado() {
        Editor e = editorActual();
        if (e == null) {
            estado.setText(" ");
            setTitle(TITULO);
            return;
        }
        Lenguaje l = e.getLenguaje();
        estado.setText((l == null ? "Texto" : l.getNombre()) + "   |   Línea " + e.getLinea() + ", columna " + e.getColumna());
        setTitle(e.getNombre() + " - " + TITULO);
    }


    private void nuevoArchivo() {
        if (arbol.getRaiz() != null) {
            arbol.nuevoArchivo();
            return;
        }
        JFileChooser selector = selector("Nuevo archivo");
        selector.setFileFilter(filtroProyecto());
        if (selector.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;
        File archivo = selector.getSelectedFile();
        if (archivo.exists() && !confirmarSobrescribir(archivo)) return;
        try {
            Lenguaje lenguaje = Lenguaje.desdeArchivo(archivo);
            String nombre = archivo.getName();
            String base = nombre.contains(".") ? nombre.substring(0, nombre.lastIndexOf('.')) : nombre;
            Archivos.escribir(archivo, lenguaje == null ? "" : lenguaje.plantilla(base));
            abrirArchivo(archivo);
        } catch (IOException ex) {
            error("No se pudo crear el archivo: " + ex.getMessage());
        }
    }

    private void nuevaCarpeta() {
        if (arbol.getRaiz() == null) {
            info("Primero abre una carpeta.");
            return;
        }
        arbol.nuevaCarpeta();
    }

    private void abrirArchivo() {
        JFileChooser selector = selector("Abrir archivo");
        selector.setFileFilter(filtroProyecto());
        selector.setMultiSelectionEnabled(true);
        if (selector.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) return;
        for (File f : selector.getSelectedFiles()) abrirArchivo(f);
    }

    private void abrirCarpeta() {
        JFileChooser selector = selector("Abrir carpeta");
        selector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (selector.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) return;
        File carpeta = selector.getSelectedFile();
        if (!carpeta.isDirectory()) {
            error("La carpeta " + carpeta.getPath() + " no existe.");
            return;
        }
        abrirEnArbol(carpeta);
    }

    private void abrirEnArbol(File carpeta) {
        carpeta = carpeta.getAbsoluteFile();
        arbol.setRaiz(carpeta);
        preferencias.put(CLAVE_CARPETA, carpeta.getPath());
        preferencias.put(CLAVE_DIRECTORIO, carpeta.getPath());
    }

    private void guardar() {
        Editor e = editorActual();
        if (e != null) guardar(e);
    }

    private boolean guardar(Editor editor) {
        if (editor.cambioEnDisco() && editor.getArchivo().exists()) {
            int r = JOptionPane.showConfirmDialog(this,
                    editor.getNombre() + " se modificó fuera de la IDE. ¿Reemplazarlo con el texto del editor?",
                    "Archivo modificado", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (r != JOptionPane.YES_OPTION) return false;
        }
        try {
            editor.guardar();
            arbol.actualizar();
            estado.setText("Guardado: " + editor.getArchivo().getPath());
            return true;
        } catch (IOException ex) {
            error("No se pudo guardar " + editor.getNombre() + ": " + ex.getMessage());
            return false;
        }
    }

    private void guardarComo() {
        Editor editor = editorActual();
        if (editor == null) return;
        JFileChooser selector = selector("Guardar como");
        selector.setFileFilter(filtroProyecto());
        selector.setSelectedFile(editor.getArchivo());
        if (selector.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;
        File destino = Archivos.conExtension(selector.getSelectedFile().getAbsoluteFile(),
                Archivos.extension(editor.getArchivo()));
        if (Archivos.mismoArchivo(destino, editor.getArchivo())) {
            guardar(editor);
            return;
        }
        if (destino.isDirectory()) {
            error("Ya existe una carpeta llamada " + destino.getName() + ".");
            return;
        }
        if (destino.exists() && !confirmarSobrescribir(destino)) return;
        Editor otro = buscarEditor(destino);
        if (otro != null && !cerrarSinGuardar(otro)) return;
        File anterior = editor.getArchivo();
        editor.setArchivo(destino);
        try {
            editor.guardar();
        } catch (IOException ex) {
            editor.setArchivo(anterior);
            error("No se pudo guardar " + destino.getName() + ": " + ex.getMessage());
            return;
        }
        recordarDirectorio(destino);
        arbol.actualizar();
        if (arbol.getRaiz() != null && Archivos.contiene(arbol.getRaiz(), destino)) arbol.seleccionar(destino);
        estado.setText("Guardado: " + destino.getPath());
    }

    private boolean cerrarSinGuardar(Editor editor) {
        if (editor.isModificado()) {
            int r = JOptionPane.showConfirmDialog(this, editor.getNombre()
                    + " está abierto con cambios sin guardar que se perderán. ¿Continuar?",
                    "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (r != JOptionPane.YES_OPTION) return false;
        }
        pestanas.remove(editor);
        return true;
    }

    private void guardarTodo() {
        int guardados = 0;
        for (Editor e : editores()) {
            if (!e.isModificado()) continue;
            if (!guardar(e)) return;
            guardados++;
        }
        estado.setText(guardados == 0 ? "No hay cambios por guardar" : "Se guardaron " + guardados + " archivo(s)");
    }

    private void descargarArchivo() {
        File seleccion = arbol.getSeleccionado();
        if (seleccion != null && seleccion.isFile()) {
            descargar(seleccion);
        } else if (editorActual() != null) {
            descargar(editorActual().getArchivo());
        } else {
            info("Selecciona un archivo en el explorador o abre uno.");
        }
    }

    private void descargarCarpeta() {
        File seleccion = arbol.getSeleccionado();
        File carpeta = seleccion != null && seleccion.isDirectory() ? seleccion : arbol.getRaiz();
        if (carpeta == null) {
            info("No hay ninguna carpeta abierta.");
            return;
        }
        descargar(carpeta);
    }

    private void descargar(File origen) {
        boolean esCarpeta = origen.isDirectory();
        JFileChooser selector = selector(esCarpeta ? "Descargar carpeta" : "Descargar archivo");
        selector.setSelectedFile(new File(selector.getCurrentDirectory(),
                esCarpeta ? origen.getName() + ".zip" : origen.getName()));
        if (selector.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;
        File destino = selector.getSelectedFile();
        if (esCarpeta && !destino.getName().toLowerCase().endsWith(".zip")) {
            destino = new File(destino.getParentFile(), destino.getName() + ".zip");
        }
        if (Archivos.mismoArchivo(origen, destino)) return;
        if (destino.exists() && !confirmarSobrescribir(destino)) return;
        try {
            if (esCarpeta) {
                Archivos.comprimir(origen, destino);
            } else {
                Editor abierto = buscarEditor(origen);
                if (abierto != null) {
                    Archivos.escribir(destino, abierto.getTexto());
                } else {
                    Archivos.copiar(origen, destino);
                }
            }
            recordarDirectorio(destino);
            info("Se guardó en " + destino.getPath());
        } catch (IOException ex) {
            error("No se pudo descargar: " + ex.getMessage());
        }
    }

    private void archivoRenombrado(File antes, File despues) {
        Path base = antes.toPath().toAbsolutePath().normalize();
        for (Editor e : editores()) {
            Path ruta = e.getArchivo().toPath().toAbsolutePath().normalize();
            if (ruta.startsWith(base)) {
                e.setArchivo(despues.toPath().resolve(base.relativize(ruta)).toFile());
            }
        }
    }

    private void archivoEliminado(File archivo) {
        for (Editor e : editores()) {
            if (Archivos.contiene(archivo, e.getArchivo())) pestanas.remove(e);
        }
        if (pestanas.getTabCount() == 0) tarjetasCentro.show(centro, "bienvenida");
        actualizarEstado();
    }

    private void salir() {
        for (Editor e : editores()) {
            if (!cerrar(e)) return;
        }
        dispose();
        System.exit(0);
    }

    //Parte de analisis
    private record Analisis(Nodo raiz, TablaSimbolos tabla, List<ErrorCompilacion> errores) {
    }

    private void analizar() {
        Editor editor = editorActual();
        if (editor == null) {
            info("Abre un archivo para analizarlo.");
            return;
        }
        if (editor.getLenguaje() == null) {
            info("El archivo no es .pig, .y ni .z.");
            return;
        }
        if (analizar(editor).errores().isEmpty()) {
            info("El análisis de " + editor.getNombre() + " terminó sin errores.");
        }
    }

    private Analisis analizar(Editor editor) {
        CargadorProyecto.LectorArchivos lector = archivo -> {
            Editor abierto = buscarEditor(archivo);
            return abierto != null ? abierto.getTexto() : Archivos.leer(archivo);
        };
        File principal = archivoPrincipal(editor.getArchivo(), lector);
        CargadorProyecto.Resultado resultado = principal != null
                ? CargadorProyecto.cargarProyecto(principal, lector)
                : CargadorProyecto.cargarArchivo(editor.getArchivo(), lector);

        List<ErrorCompilacion> errores = new ArrayList<>(resultado.errores());
        TablaSimbolos tabla = null;
        if (resultado.exitoso()) {
            AnalizadorSemantico.Resultado semantico = AnalizadorSemantico.analizar(resultado.raiz());
            errores.addAll(semantico.errores());
            tabla = semantico.tabla();
        }

        modeloErrores.setErrores(errores);
        for (Editor e : editores()) {
            e.marcarErrores(errores.stream()
                    .filter(err -> Archivos.mismoArchivo(new File(err.archivo()), e.getArchivo()))
                    .toList());
        }
        return new Analisis(resultado.raiz(), tabla, errores);
    }

    private File archivoPrincipal(File archivo, CargadorProyecto.LectorArchivos lector) {
        if (Lenguaje.desdeArchivo(archivo) == Lenguaje.PIG_LATIN) return archivo;
        Path buscado = archivo.toPath().toAbsolutePath().normalize();
        for (File carpeta = archivo.getAbsoluteFile().getParentFile(); carpeta != null; carpeta = carpeta.getParentFile()) {
            File[] pigs = carpeta.listFiles((d, n) -> n.endsWith(".pig"));
            if (pigs != null) {
                for (File pig : pigs) {
                    try {
                        for (String linea : lector.leer(pig).split("\\R")) {
                            String l = linea.strip();
                            if (!l.startsWith("import ")) continue;
                            String ruta = l.substring(7).replace(";", "").strip();
                            int punto = ruta.lastIndexOf('.');
                            if (punto < 0) continue;
                            String relativa = ruta.substring(0, punto).replace('.', '/') + ruta.substring(punto);
                            if (carpeta.toPath().toAbsolutePath().resolve(relativa).normalize().equals(buscado)) return pig;
                        }
                    } catch (IOException ignorada) {
                        // se prueba con el siguiente
                    }
                }
            }
            if (arbol.getRaiz() != null && Archivos.mismoArchivo(carpeta, arbol.getRaiz())) break;
        }
        return null;
    }

    private void traducir() {
        Editor editor = editorActual();
        CargadorProyecto.LectorArchivos lector = archivo -> {
            Editor abierto = buscarEditor(archivo);
            return abierto != null ? abierto.getTexto() : Archivos.leer(archivo);
        };
        File principal = editor == null || editor.getLenguaje() == null ? null : archivoPrincipal(editor.getArchivo(), lector);
        if (principal == null) {
            info("Abre el archivo .pig principal del proyecto (o un archivo que importe) para traducirlo.");
            return;
        }
        Analisis analisis = analizar(editor);
        if (!analisis.errores().isEmpty()) {
            error("No se puede traducir: el proyecto tiene " + analisis.errores().size() + " error(es).");
            return;
        }
        File salida = new File(principal.getAbsoluteFile().getParentFile(), "main.c");
        try {
            String codigo = GeneradorC3D.generar((Programa) analisis.raiz(), analisis.tabla());
            Archivos.escribir(salida, codigo);
        } catch (ErrorGeneracion ex) {
            error("No se pudo traducir " + ex.getNodo().getUbicacion() + ": " + ex.getMessage());
            return;
        } catch (IOException ex) {
            error("No se pudo guardar main.c: " + ex.getMessage());
            return;
        }
        Editor anterior = buscarEditor(salida);
        if (anterior != null) pestanas.remove(anterior);
        abrirArchivo(salida);
        arbol.actualizar();
        info("La traducción terminó correctamente. Se generó " + salida.getName() + ".");
    }

    private void irAError(ErrorCompilacion error) {
        File archivo = new File(error.archivo());
        if (buscarEditor(archivo) == null && archivo.isFile()) abrirArchivo(archivo);
        Editor editor = buscarEditor(archivo);
        if (editor == null) return;
        pestanas.setSelectedComponent(editor);
        editor.irA(error.linea(), error.columna());
    }

    private void mostrarTablaCompatibilidad() {
        StringBuilder sb = new StringBuilder();
        for (Lenguaje l : Lenguaje.values()) sb.append(TablaCompatibilidad.para(l).documentar()).append('\n');
        JTextArea area = new JTextArea(sb.toString());
        area.setEditable(false);
        area.setFont(Tema.fuenteEditor(13));
        area.setCaretPosition(0);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(720, 500));
        JOptionPane.showMessageDialog(this, scroll, "Tabla de compatibilidad de tipos", JOptionPane.PLAIN_MESSAGE);
    }

    private JFileChooser selector(String titulo) {
        JFileChooser selector = new JFileChooser(preferencias.get(CLAVE_DIRECTORIO, System.getProperty("user.home")));
        selector.setDialogTitle(titulo);
        return selector;
    }

    private static FileNameExtensionFilter filtroProyecto() {
        return new FileNameExtensionFilter("Archivos .pig, .y, .z", "pig", "y", "z");
    }

    private void recordarDirectorio(File archivo) {
        File carpeta = archivo.isDirectory() ? archivo : archivo.getParentFile();
        if (carpeta != null) preferencias.put(CLAVE_DIRECTORIO, carpeta.getAbsolutePath());
    }

    private boolean confirmarSobrescribir(File archivo) {
        return JOptionPane.showConfirmDialog(this, archivo.getName() + " ya existe. ¿Reemplazarlo?",
                "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    private void error(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void info(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, TITULO, JOptionPane.INFORMATION_MESSAGE);
    }

    private void acercaDe() {
        info(TITULO + "\nOrganización de Lenguajes y Compiladores 2 - Proyecto 1");
    }

    private final class PestanaCerrable extends JPanel {
        private final Editor editor;
        private final JLabel titulo = new JLabel();

        PestanaCerrable(Editor editor) {
            super(new FlowLayout(FlowLayout.LEFT, 4, 0));
            this.editor = editor;
            setOpaque(false);
            JButton cerrar = new JButton("x");
            cerrar.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));
            cerrar.setContentAreaFilled(false);
            cerrar.setFocusable(false);
            cerrar.addActionListener(e -> cerrar(editor));
            add(titulo);
            add(cerrar);
        }

        void actualizar() {
            titulo.setText(editor.getNombre() + (editor.isModificado() ? " *" : ""));
        }
    }
}
