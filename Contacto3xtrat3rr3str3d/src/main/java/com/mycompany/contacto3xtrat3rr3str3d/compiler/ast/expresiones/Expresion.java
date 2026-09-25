package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

/**
 * Expresión. El análisis semántico anota su tipo resultante con {@link #setTipo}.
 */
public abstract class Expresion extends Nodo {

    private Tipo tipo;

    protected Expresion(Ubicacion ubicacion) {
        super(ubicacion);
    }

    /** null hasta que el análisis semántico lo calcula. */
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /** Análisis semántico: calcula, anota y devuelve el tipo de la expresión. */
    public abstract Tipo analizar(ContextoSemantico ctx);

    /** Anota el tipo calculado y lo devuelve. */
    protected Tipo resultado(Tipo tipo) {
        setTipo(tipo);
        return tipo;
    }

    /** Valor constante (Integer, Double, String, Character, Boolean) o null si no es constante. */
    public Object valorConstante() {
        return null;
    }

    /** ¿Puede recibir un valor? Solo variables, elementos de arreglo, campos y atributos. */
    public boolean esAsignable() {
        return false;
    }
}
