package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

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

    @Override
    public String generar(ContextoC3D ctx) {
        return switch (getTipo().getBase()) {
            case CADENA -> ctx.cadena((String) valor);
            case CARACTER -> String.valueOf((int) (Character) valor);
            case BOOLEANO -> (Boolean) valor ? "1" : "0";
            case NULO -> "0";
            default -> String.valueOf(valor);
        };
    }
}
