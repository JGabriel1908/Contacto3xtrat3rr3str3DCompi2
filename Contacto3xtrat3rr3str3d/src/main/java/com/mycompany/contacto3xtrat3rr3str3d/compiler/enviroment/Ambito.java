package com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Un nivel de la tabla de símbolos (global, clase, función, bloque...).
 */
public class Ambito {

    private final String nombre;
    private final Ambito padre;
    private final Map<String, Simbolo> simbolos = new LinkedHashMap<>();
    private final Map<String, InfoEstructura> estructuras = new LinkedHashMap<>();

    public Ambito(String nombre, Ambito padre) {
        this.nombre = nombre;
        this.padre = padre;
    }

    public Ambito getPadre() {
        return padre;
    }

    public Simbolo buscarLocal(String nombre) {
        return simbolos.get(nombre);
    }

    public boolean declarar(Simbolo simbolo) {
        return simbolos.putIfAbsent(simbolo.getNombre(), simbolo) == null;
    }

    public InfoEstructura buscarEstructuraLocal(String nombre) {
        return estructuras.get(nombre);
    }

    public boolean declararEstructura(InfoEstructura estructura) {
        return estructuras.putIfAbsent(estructura.getNombre(), estructura) == null;
    }
}
