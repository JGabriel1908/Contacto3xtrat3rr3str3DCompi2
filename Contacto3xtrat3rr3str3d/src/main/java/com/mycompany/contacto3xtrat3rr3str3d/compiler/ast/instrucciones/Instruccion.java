package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

public abstract class Instruccion extends Nodo {

    protected Instruccion(Ubicacion ubicacion) {
        super(ubicacion);
    }

    public abstract void analizar(ContextoSemantico ctx);

    public boolean siempreRetorna() {
        return false;
    }
}
