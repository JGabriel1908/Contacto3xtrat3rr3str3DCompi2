package com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefEstructura;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/** Estructura registrada con sus campos en orden de declaración. */
public class InfoEstructura {

    private final DefEstructura definicion;
    private final Map<String, Simbolo> campos = new LinkedHashMap<>();

    public InfoEstructura(DefEstructura definicion) {
        this.definicion = definicion;
    }

    public String getNombre() {
        return definicion.getNombre();
    }

    public DefEstructura getDefinicion() {
        return definicion;
    }

    public Map<String, Simbolo> getCampos() {
        return Collections.unmodifiableMap(campos);
    }

    public Simbolo getCampo(String nombre) {
        return campos.get(nombre);
    }

    public boolean agregarCampo(Simbolo campo) {
        return campos.putIfAbsent(campo.getNombre(), campo) == null;
    }
}
