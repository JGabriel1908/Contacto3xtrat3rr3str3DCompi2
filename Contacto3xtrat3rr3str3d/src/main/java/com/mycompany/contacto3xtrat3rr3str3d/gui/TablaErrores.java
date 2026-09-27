package com.mycompany.contacto3xtrat3rr3str3d.gui;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ErrorCompilacion;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TablaErrores extends AbstractTableModel {

    private static final String[] COLUMNAS = {"#", "Tipo", "Descripción", "Archivo", "Línea", "Columna"};

    private List<ErrorCompilacion> errores = new ArrayList<>();

    public void setErrores(List<ErrorCompilacion> errores) {
        this.errores = new ArrayList<>(errores);
        fireTableDataChanged();
    }

    public ErrorCompilacion getError(int fila) {
        return errores.get(fila);
    }

    @Override
    public int getRowCount() {
        return errores.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNAS.length;
    }

    @Override
    public String getColumnName(int columna) {
        return COLUMNAS[columna];
    }

    @Override
    public Class<?> getColumnClass(int columna) {
        return switch (columna) {
            case 0, 4, 5 -> Integer.class;
            default -> String.class;
        };
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        ErrorCompilacion e = errores.get(fila);
        return switch (columna) {
            case 0 -> fila + 1;
            case 1 -> e.tipo().toString();
            case 2 -> e.descripcion();
            case 3 -> new File(e.archivo()).getName();
            case 4 -> e.linea();
            default -> e.columna() + 1;
        };
    }
}
