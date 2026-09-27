package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

public class Este extends Expresion {

    public Este(Ubicacion ubicacion) {
        super(ubicacion);
    }

    @Override
    public Tipo analizar(ContextoSemantico ctx) {
        if (ctx.getClaseActual() == null) {
            ctx.error(this, "'this' solo puede usarse dentro de una clase");
            return resultado(Tipo.ERROR);
        }
        return resultado(Tipo.clase(ctx.getClaseActual().getNombre()));
    }

    @Override
    public String generar(ContextoC3D ctx) {
        return ctx.este();
    }
}
