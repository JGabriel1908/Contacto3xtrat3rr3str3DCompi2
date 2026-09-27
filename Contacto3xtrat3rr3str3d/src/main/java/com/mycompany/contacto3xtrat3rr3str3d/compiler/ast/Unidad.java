package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

public abstract class Unidad extends Nodo {

    protected Unidad(Ubicacion ubicacion) {
        super(ubicacion);
    }

    public String getArchivo() {
        return getUbicacion().archivo();
    }

    public abstract void analizar(ContextoSemantico ctx);

    /** Asigna los nombres en C de sus funciones, antes de generar cualquier código. */
    public void nombrar(ContextoC3D ctx) {
    }

    public abstract void generar(ContextoC3D ctx);
}
