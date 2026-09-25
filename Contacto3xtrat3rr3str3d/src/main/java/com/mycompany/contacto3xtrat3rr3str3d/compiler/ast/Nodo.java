package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.Lenguaje;

/**
 * Nodo base del AST común a los tres lenguajes.
 */
public abstract class Nodo {

    private final Ubicacion ubicacion;

    protected Nodo(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    /** Lenguaje del archivo del que proviene el nodo. */
    public Lenguaje getLenguaje() {
        return ubicacion.lenguaje();
    }
}
