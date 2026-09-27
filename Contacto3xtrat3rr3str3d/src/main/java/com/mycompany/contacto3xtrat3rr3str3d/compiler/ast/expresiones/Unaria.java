package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.Cuarteta.Operador;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.TablaCompatibilidad;

public class Unaria extends Expresion {

    private final OperadorUnario operador;
    private final Expresion operando;

    public Unaria(Ubicacion ubicacion, OperadorUnario operador, Expresion operando) {
        super(ubicacion);
        this.operador = operador;
        this.operando = operando;
    }

    @Override
    public Tipo analizar(ContextoSemantico ctx) {
        Tipo t = operando.analizar(ctx);
        TablaCompatibilidad c = ctx.compat(this);
        Tipo r = c.unaria(operador, t);
        if (r == null) {
            ctx.error(this, "El operador '" + operador + "' no se puede aplicar a " + c.nombre(t));
            r = Tipo.ERROR;
        }
        return resultado(r);
    }

    @Override
    public Object valorConstante() {
        if (operador == OperadorUnario.NEGATIVO && operando.valorConstante() instanceof Integer v) return -v;
        return null;
    }

    @Override
    public String generar(ContextoC3D ctx) {
        String v = operando.generar(ctx);
        return switch (operador) {
            case NEGATIVO -> ctx.unaria(Operador.NEGATIVO, v);
            case NOT -> ctx.unaria(Operador.NOT, v);
            case POSITIVO -> v;
        };
    }
}
