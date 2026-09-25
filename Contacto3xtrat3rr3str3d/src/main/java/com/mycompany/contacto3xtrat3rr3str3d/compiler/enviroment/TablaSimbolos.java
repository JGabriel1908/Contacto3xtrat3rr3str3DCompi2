package com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefFuncion;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Tabla de símbolos: pila de ámbitos anidados más los registros globales de
 * funciones (.y) y clases (.z).
 */
public class TablaSimbolos {

    private final Ambito global = new Ambito("global", null);
    private Ambito actual = global;
    private final Map<String, DefFuncion> funciones = new LinkedHashMap<>();
    private final Map<String, InfoClase> clases = new LinkedHashMap<>();

    // ------------------------------------------------------------------ ámbitos

    public void abrir(String nombre) {
        actual = new Ambito(nombre, actual);
    }

    public void cerrar() {
        if (actual.getPadre() != null) actual = actual.getPadre();
    }

    /** Declara en el ámbito actual; devuelve false si el nombre ya existe en él. */
    public boolean declarar(Simbolo simbolo) {
        return actual.declarar(simbolo);
    }

    /** Busca desde el ámbito actual hacia el global. */
    public Simbolo buscar(String nombre) {
        for (Ambito a = actual; a != null; a = a.getPadre()) {
            Simbolo s = a.buscarLocal(nombre);
            if (s != null) return s;
        }
        return null;
    }

    // ------------------------------------------------------------------ estructuras

    public boolean declararEstructura(InfoEstructura estructura) {
        return actual.declararEstructura(estructura);
    }

    public InfoEstructura buscarEstructura(String nombre) {
        for (Ambito a = actual; a != null; a = a.getPadre()) {
            InfoEstructura e = a.buscarEstructuraLocal(nombre);
            if (e != null) return e;
        }
        return null;
    }

    // ------------------------------------------------------------------ funciones y clases

    public boolean registrarFuncion(DefFuncion funcion) {
        return funciones.putIfAbsent(funcion.getNombre(), funcion) == null;
    }

    public DefFuncion buscarFuncion(String nombre) {
        return funciones.get(nombre);
    }

    public boolean registrarClase(InfoClase clase) {
        return clases.putIfAbsent(clase.getNombre(), clase) == null;
    }

    public InfoClase buscarClase(String nombre) {
        return clases.get(nombre);
    }

    // ------------------------------------------------------------------ reporte

}
