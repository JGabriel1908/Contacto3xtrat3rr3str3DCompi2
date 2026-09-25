package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

public abstract class Instruccion extends Nodo {

    protected Instruccion(Ubicacion ubicacion) {
        super(ubicacion);
    }

    /** Análisis semántico de la instrucción. */
    public abstract void analizar(ContextoSemantico ctx);

    /** ¿La instrucción termina siempre con un retornar? (para validar funciones con tipo). */
    public boolean siempreRetorna() {
        return false;
    }
}
