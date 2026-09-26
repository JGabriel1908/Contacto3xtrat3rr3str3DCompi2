package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;


public abstract class Expresion extends Nodo {

    private Tipo tipo;

    protected Expresion(Ubicacion ubicacion) {
        super(ubicacion);
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public abstract Tipo analizar(ContextoSemantico ctx);

    protected Tipo resultado(Tipo tipo) {
        setTipo(tipo);
        return tipo;
    }

    public Object valorConstante() {
        return null;
    }

    public boolean esAsignable() {
        return false;
    }
}
