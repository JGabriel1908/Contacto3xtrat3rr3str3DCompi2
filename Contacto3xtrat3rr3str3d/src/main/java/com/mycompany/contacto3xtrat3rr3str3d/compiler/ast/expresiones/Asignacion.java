package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.TablaCompatibilidad;

public class Asignacion extends Expresion {

    private final Expresion destino;
    private final OperadorBinario operadorCompuesto;
    private final Expresion valor;

    public Asignacion(Ubicacion ubicacion, Expresion destino, OperadorBinario operadorCompuesto, Expresion valor) {
        super(ubicacion);
        this.destino = destino;
        this.operadorCompuesto = operadorCompuesto;
        this.valor = valor;
    }

    public Expresion getValor() {
        return valor;
    }

    @Override
    public Tipo analizar(ContextoSemantico ctx) {
        Tipo tipoDestino = destino.analizar(ctx);
        ctx.verificarAsignable(destino);
        if (operadorCompuesto == null) {
            ctx.verificarValor(tipoDestino, valor, ctx.dimensionesDe(destino));
        } else {
            Tipo tipoValor = valor.analizar(ctx);
            TablaCompatibilidad c = ctx.compat(this);
            Tipo r = c.binaria(operadorCompuesto, tipoDestino, tipoValor);
            if (r == null) {
                ctx.error(this, "El operador '" + operadorCompuesto + "=' no se puede aplicar a "
                        + c.nombre(tipoDestino) + " y " + c.nombre(tipoValor));
            } else if (!c.asignable(tipoDestino, r)) {
                ctx.error(this, "El resultado de tipo " + c.nombre(r) + " no se puede guardar en " + c.nombre(tipoDestino));
            }
        }
        return resultado(tipoDestino);
    }
}
