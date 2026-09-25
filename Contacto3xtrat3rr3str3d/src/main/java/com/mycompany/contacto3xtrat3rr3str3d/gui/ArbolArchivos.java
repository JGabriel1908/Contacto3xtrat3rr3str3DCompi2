package com.mycompany.contacto3xtrat3rr3str3d.gui;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.Lenguaje;
import com.mycompany.contacto3xtrat3rr3str3d.utils.Archivos;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 * Explorador del árbol de trabajo. Doble clic abre un archivo; clic derecho permite
 * renombrar, eliminar o actualizar.
 */
public class ArbolArchivos extends JPanel {

    /** Operaciones que resuelve la ventana principal. */
    public interface Acciones {
        void abrir(File archivo);

        void renombrado(File antes, File despues);

        void eliminado(File archivo);
    }

    private final Acciones acciones;
    private final DefaultTreeModel modelo = new DefaultTreeModel(null, true);
    private final JTree arbol = new JTree(modelo);
    private final CardLayout tarjetas = new CardLayout();
    private final JPanel contenido = new JPanel(tarjetas);
    private File raiz;

    public ArbolArchivos(Acciones acciones) {
        super(new BorderLayout());
        this.acciones = acciones;

        arbol.setRootVisible(true);
        arbol.setShowsRootHandles(true);
        arbol.setCellRenderer(new Renderizador());
        arbol.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (mostrarMenu(e)) return;
                if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
                    File f = getSeleccionado();
                    if (f != null && f.isFile()) acciones.abrir(f);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mostrarMenu(e);
            }
        });

        JPanel vacio = new JPanel(new GridBagLayout());
        vacio.add(new JLabel("No hay carpeta abierta"));
        contenido.add(vacio, "vacio");
        contenido.add(new JScrollPane(arbol), "arbol");

        JLabel titulo = new JLabel("Archivos");
        titulo.setBorder(BorderFactory.createEmptyBorder(4, 6, 4, 6));
        add(titulo, BorderLayout.NORTH);
        add(contenido, BorderLayout.CENTER);
        tarjetas.show(contenido, "vacio");
    }

    // ------------------------------------------------------------------ carpeta raíz

    public File getRaiz() {
        return raiz;
    }

    public void setRaiz(File carpeta) {
        this.raiz = carpeta;
        if (carpeta == null) {
            modelo.setRoot(null);
            tarjetas.show(contenido, "vacio");
            return;
        }
        modelo.setRoot(construir(carpeta));
        arbol.expandRow(0);
        tarjetas.show(contenido, "arbol");
    }

    /** Vuelve a leer el disco conservando las carpetas expandidas. */
    public void actualizar() {
        if (raiz == null) return;
        Set<File> expandidas = new HashSet<>();
        DefaultMutableTreeNode nodoRaiz = (DefaultMutableTreeNode) modelo.getRoot();
        if (nodoRaiz != null) {
            Enumeration<TreePath> rutas = arbol.getExpandedDescendants(new TreePath(nodoRaiz));
            if (rutas != null) {
                for (TreePath p : Collections.list(rutas)) expandidas.add(archivoDe(p.getLastPathComponent()));
            }
        }
        TreePath seleccion = arbol.getSelectionPath();
        File seleccionado = seleccion == null ? null : archivoDe(seleccion.getLastPathComponent());

        DefaultMutableTreeNode nuevo = construir(raiz);
        modelo.setRoot(nuevo);
        for (Object o : Collections.list(nuevo.preorderEnumeration())) {
            DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) o;
            if (nodo == nuevo || expandidas.contains(archivoDe(nodo))) {
                arbol.expandPath(new TreePath(nodo.getPath()));
            }
        }
        if (seleccionado != null) seleccionar(seleccionado);
    }

    public void seleccionar(File archivo) {
        DefaultMutableTreeNode nodoRaiz = (DefaultMutableTreeNode) modelo.getRoot();
        if (nodoRaiz == null) return;
        for (Object o : Collections.list(nodoRaiz.preorderEnumeration())) {
            DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) o;
            if (Archivos.mismoArchivo(archivoDe(nodo), archivo)) {
                TreePath ruta = new TreePath(nodo.getPath());
                arbol.setSelectionPath(ruta);
                arbol.scrollPathToVisible(ruta);
                return;
            }
        }
    }

    private DefaultMutableTreeNode construir(File archivo) {
        DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(archivo, archivo.isDirectory());
        if (archivo.isDirectory()) {
            File[] hijos = archivo.listFiles(f -> !f.getName().startsWith("."));
            if (hijos != null) {
                Arrays.sort(hijos, Comparator.comparing((File f) -> !f.isDirectory())
                        .thenComparing(f -> f.getName().toLowerCase()));
                for (File hijo : hijos) nodo.add(construir(hijo));
            }
        }
        return nodo;
    }

    private static File archivoDe(Object nodo) {
        return (File) ((DefaultMutableTreeNode) nodo).getUserObject();
    }

    public File getSeleccionado() {
        TreePath ruta = arbol.getSelectionPath();
        return ruta == null ? null : archivoDe(ruta.getLastPathComponent());
    }

    /** Carpeta donde se crean los archivos nuevos: la seleccionada, la del archivo seleccionado o la raíz. */
    private File carpetaDestino() {
        File seleccionado = getSeleccionado();
        if (seleccionado == null) return raiz;
        return seleccionado.isDirectory() ? seleccionado : seleccionado.getParentFile();
    }

    // ------------------------------------------------------------------ operaciones

    public void nuevoArchivo() {
        String nombre = pedirNombre("Nombre del archivo (ej. main.pig, Funciones.y, Persona.z):", "");
        if (nombre == null) return;
        File nuevo = new File(carpetaDestino(), nombre);
        if (nuevo.exists()) {
            error("Ya existe un archivo llamado " + nombre);
            return;
        }
        try {
            Lenguaje lenguaje = Lenguaje.desdeNombre(nombre);
            String base = nombre.contains(".") ? nombre.substring(0, nombre.lastIndexOf('.')) : nombre;
            Archivos.escribir(nuevo, lenguaje == null ? "" : lenguaje.plantilla(base));
            actualizar();
            seleccionar(nuevo);
            acciones.abrir(nuevo);
        } catch (IOException e) {
            error("No se pudo crear el archivo: " + e.getMessage());
        }
    }

    public void nuevaCarpeta() {
        String nombre = pedirNombre("Nombre de la carpeta:", "");
        if (nombre == null) return;
        File nueva = new File(carpetaDestino(), nombre);
        if (nueva.exists()) {
            error("Ya existe " + nombre);
            return;
        }
        if (!nueva.mkdirs()) {
            error("No se pudo crear la carpeta");
            return;
        }
        actualizar();
        seleccionar(nueva);
    }

    private void renombrar() {
        File actual = getSeleccionado();
        if (actual == null || Archivos.mismoArchivo(actual, raiz)) return;
        String nombre = pedirNombre("Nuevo nombre:", actual.getName());
        if (nombre == null || nombre.equals(actual.getName())) return;
        File destino = new File(actual.getParentFile(), nombre);
        if (destino.exists()) {
            error("Ya existe " + nombre);
            return;
        }
        try {
            Archivos.mover(actual, destino);
            acciones.renombrado(actual, destino);
            actualizar();
            seleccionar(destino);
        } catch (IOException e) {
            error("No se pudo renombrar: " + e.getMessage());
        }
    }

    private void eliminar() {
        File actual = getSeleccionado();
        if (actual == null || Archivos.mismoArchivo(actual, raiz)) return;
        int r = JOptionPane.showConfirmDialog(this, "¿Eliminar " + actual.getName() + "?", "Eliminar",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (r != JOptionPane.YES_OPTION) return;
        try {
            Archivos.eliminar(actual);
            acciones.eliminado(actual);
            actualizar();
        } catch (IOException e) {
            error("No se pudo eliminar: " + e.getMessage());
        }
    }

    private String pedirNombre(String mensaje, String inicial) {
        String nombre = (String) JOptionPane.showInputDialog(this, mensaje, "Archivos",
                JOptionPane.PLAIN_MESSAGE, null, null, inicial);
        if (nombre == null) return null;
        nombre = nombre.strip();
        if (nombre.isEmpty() || nombre.contains("/") || nombre.contains("\\")) {
            error("Nombre no válido");
            return null;
        }
        return nombre;
    }

    private void error(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Archivos", JOptionPane.ERROR_MESSAGE);
    }

    private boolean mostrarMenu(MouseEvent e) {
        if (!e.isPopupTrigger()) return false;
        TreePath ruta = arbol.getPathForLocation(e.getX(), e.getY());
        if (ruta != null) arbol.setSelectionPath(ruta);
        File seleccionado = getSeleccionado();
        boolean editable = seleccionado != null && !Archivos.mismoArchivo(seleccionado, raiz);

        JPopupMenu menu = new JPopupMenu();
        elemento(menu, "Renombrar", this::renombrar).setEnabled(editable);
        elemento(menu, "Eliminar", this::eliminar).setEnabled(editable);
        menu.addSeparator();
        elemento(menu, "Actualizar", this::actualizar);
        menu.show(arbol, e.getX(), e.getY());
        return true;
    }

    private static JMenuItem elemento(JPopupMenu menu, String texto, Runnable accion) {
        JMenuItem item = new JMenuItem(texto);
        item.addActionListener(e -> accion.run());
        menu.add(item);
        return item;
    }

    /** Muestra solo el nombre del archivo, con icono de carpeta o de archivo. */
    private static final class Renderizador extends DefaultTreeCellRenderer {
        @Override
        public Component getTreeCellRendererComponent(JTree arbol, Object valor, boolean seleccionado,
                                                      boolean expandido, boolean hoja, int fila, boolean foco) {
            super.getTreeCellRendererComponent(arbol, valor, seleccionado, expandido, hoja, fila, foco);
            if (valor instanceof DefaultMutableTreeNode nodo && nodo.getUserObject() instanceof File f) {
                setText(f.getName().isEmpty() ? f.getPath() : f.getName());
                if (f.isDirectory()) {
                    setIcon(expandido ? getOpenIcon() : getClosedIcon());
                } else {
                    setIcon(getLeafIcon());
                }
            }
            return this;
        }
    }
}
