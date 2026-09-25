package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

/**
 * Contenido de un archivo fuente (.y, .z o .pig).
 */
public abstract class Unidad extends Nodo {

    protected Unidad(Ubicacion ubicacion) {
        super(ubicacion);
    }

    public String getArchivo() {
        return getUbicacion().archivo();
    }

    /** Pasada 3 del análisis semántico: analiza los cuerpos del archivo. */
    public abstract void analizar(ContextoSemantico ctx);
}
