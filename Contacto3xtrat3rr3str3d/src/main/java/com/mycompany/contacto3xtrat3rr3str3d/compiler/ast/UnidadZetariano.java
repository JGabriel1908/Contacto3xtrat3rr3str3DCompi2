package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefClase;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

public class UnidadZetariano extends Unidad {

    private final DefClase clase;

    public UnidadZetariano(Ubicacion ubicacion, DefClase clase) {
        super(ubicacion);
        this.clase = clase;
    }

    public DefClase getClase() {
        return clase;
    }

    public void registrar(ContextoSemantico ctx) {
        clase.registrar(ctx, getArchivo());
    }

    public void validarDeclaraciones(ContextoSemantico ctx) {
        clase.validarMiembros(ctx);
    }

    @Override
    public void analizar(ContextoSemantico ctx) {
        clase.analizar(ctx);
    }

    @Override
    public void nombrar(ContextoC3D ctx) {
        clase.nombrar(ctx);
    }

    @Override
    public void generar(ContextoC3D ctx) {
        clase.generar(ctx);
    }
}
