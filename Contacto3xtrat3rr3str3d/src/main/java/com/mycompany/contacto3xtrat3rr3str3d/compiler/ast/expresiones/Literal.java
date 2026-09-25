package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

/**
 * Valor constante. El valor es Integer, Double, String, Character, Boolean o null (nulo).
 */
public class Literal extends Expresion {

    private final Object valor;

    public Literal(Ubicacion ubicacion, Tipo tipo, Object valor) {
        super(ubicacion);
        this.valor = valor;
        setTipo(tipo);
    }

    public Object getValor() {
        return valor;
    }

    @Override
    public Tipo analizar(ContextoSemantico ctx) {
        return getTipo();
    }

    @Override
    public Object valorConstante() {
        return valor;
    }
}
