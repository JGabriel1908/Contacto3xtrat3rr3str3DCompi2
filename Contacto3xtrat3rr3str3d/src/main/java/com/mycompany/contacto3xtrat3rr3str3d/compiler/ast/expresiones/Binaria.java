package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.TablaCompatibilidad;

public class Binaria extends Expresion {

    private final OperadorBinario operador;
    private final Expresion izquierda;
    private final Expresion derecha;

    public Binaria(Ubicacion ubicacion, OperadorBinario operador, Expresion izquierda, Expresion derecha) {
        super(ubicacion);
        this.operador = operador;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    @Override
    public Tipo analizar(ContextoSemantico ctx) {
        Tipo a = izquierda.analizar(ctx);
        Tipo b = derecha.analizar(ctx);
        TablaCompatibilidad c = ctx.compat(this);
        Tipo r = c.binaria(operador, a, b);
        if (r == null) {
            ctx.error(this, "El operador '" + operador + "' no se puede aplicar a " + c.nombre(a) + " y " + c.nombre(b));
            r = Tipo.ERROR;
        }
        return resultado(r);
    }

    @Override
    public Object valorConstante() {
        if (izquierda.valorConstante() instanceof Integer x && derecha.valorConstante() instanceof Integer y) {
            return switch (operador) {
                case SUMA -> x + y;
                case RESTA -> x - y;
                case MULTIPLICACION -> x * y;
                case DIVISION -> y == 0 ? null : x / y;
                case MODULO -> y == 0 ? null : x % y;
                default -> null;
            };
        }
        return null;
    }
}
