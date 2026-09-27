package com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;

public class ErrorGeneracion extends RuntimeException {

    private final transient Nodo nodo;

    public ErrorGeneracion(Nodo nodo, String mensaje) {
        super(mensaje);
        this.nodo = nodo;
    }

    public Nodo getNodo() {
        return nodo;
    }
}
