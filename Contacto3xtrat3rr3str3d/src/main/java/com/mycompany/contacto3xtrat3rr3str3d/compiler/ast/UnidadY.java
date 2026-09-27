package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefEstructura;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefFuncion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoEstructura;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;

public class UnidadY extends Unidad {

    private final List<DefEstructura> estructuras;
    private final List<DefFuncion> funciones;

    public UnidadY(Ubicacion ubicacion, List<DefEstructura> estructuras, List<DefFuncion> funciones) {
        super(ubicacion);
        this.estructuras = List.copyOf(estructuras);
        this.funciones = List.copyOf(funciones);
    }

    public void registrarEstructuras(ContextoSemantico ctx) {
        for (DefEstructura e : estructuras) {
            InfoEstructura info = e.registrar(ctx);
            if (info != null) ctx.agregarEstructuraGlobal(info);
        }
    }

    public void registrarFunciones(ContextoSemantico ctx) {
        funciones.forEach(f -> f.registrar(ctx));
    }

    public void validarEstructuras(ContextoSemantico ctx) {
        for (DefEstructura e : estructuras) {
            InfoEstructura info = ctx.tabla().buscarEstructura(e.getNombre());
            if (info != null && info.getDefinicion() == e) e.validarCampos(ctx, info);
        }
    }

    public void validarFunciones(ContextoSemantico ctx) {
        for (DefFuncion f : funciones) {
            if (ctx.tabla().buscarFuncion(f.getNombre()) == f) f.validarFirma(ctx);
        }
    }

    @Override
    public void analizar(ContextoSemantico ctx) {
        funciones.forEach(f -> f.analizar(ctx));
    }

    @Override
    public void nombrar(ContextoC3D ctx) {
        funciones.forEach(f -> ctx.nombrar(f, "f_" + f.getNombre()));
    }

    @Override
    public void generar(ContextoC3D ctx) {
        funciones.forEach(f -> f.generar(ctx));
    }
}
