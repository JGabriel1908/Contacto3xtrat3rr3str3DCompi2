package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;

public class Imprimir extends Instruccion {

    private final List<Expresion> valores;
    private final boolean saltoLinea;

    public Imprimir(Ubicacion ubicacion, List<Expresion> valores, boolean saltoLinea) {
        super(ubicacion);
        this.valores = List.copyOf(valores);
        this.saltoLinea = saltoLinea;
    }

    @Override
    public void analizar(ContextoSemantico ctx) {
        for (Expresion e : valores) {
            Tipo t = e.analizar(ctx);
            if (!t.esPrimitivo() && !t.esError()) {
                ctx.error(e, "No se puede imprimir un valor de tipo " + ctx.nombreTipo(this, t));
            }
        }
    }

    @Override
    public void generar(ContextoC3D ctx) {
        for (Expresion e : valores) ctx.imprimir(e.generar(ctx), e.getTipo(), getLenguaje());
        if (saltoLinea) ctx.saltoDeLinea();
    }
}
