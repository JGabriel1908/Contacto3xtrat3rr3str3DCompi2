package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

public class Continuar extends Instruccion {

    public Continuar(Ubicacion ubicacion) {
        super(ubicacion);
    }

    @Override
    public void analizar(ContextoSemantico ctx) {
        if (!ctx.enCiclo()) {
            ctx.error(this, "'" + ctx.palabra(this, "continuar", "continue", "perge") + "' solo puede usarse dentro de un ciclo");
        }
    }

    @Override
    public void generar(ContextoC3D ctx) {
        ctx.saltar(ctx.continuacionActual());
    }
}
