package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.Lenguaje;

/**
 *Sera para los tres lenguajes
 */
public abstract class Nodo {

    private final Ubicacion ubicacion;

    protected Nodo(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public Lenguaje getLenguaje() {
        return ubicacion.lenguaje();
    }
}
