package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefEstructura;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefFuncion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoEstructura;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;

/** Archivo .y: estructuras globales y funciones. */
public class UnidadY extends Unidad {

    private final List<DefEstructura> estructuras;
    private final List<DefFuncion> funciones;

    public UnidadY(Ubicacion ubicacion, List<DefEstructura> estructuras, List<DefFuncion> funciones) {
        super(ubicacion);
        this.estructuras = List.copyOf(estructuras);
        this.funciones = List.copyOf(funciones);
    }

    /** Pasada 1: registra las estructuras globales. */
    public void registrarEstructuras(ContextoSemantico ctx) {
        for (DefEstructura e : estructuras) {
            InfoEstructura info = e.registrar(ctx);
            if (info != null) ctx.agregarEstructuraGlobal(info);
        }
    }

    /** Pasada 1: registra las funciones. */
    public void registrarFunciones(ContextoSemantico ctx) {
        funciones.forEach(f -> f.registrar(ctx));
    }

    /** Pasada 2: valida los campos de las estructuras que se pudieron registrar. */
    public void validarEstructuras(ContextoSemantico ctx) {
        for (DefEstructura e : estructuras) {
            InfoEstructura info = ctx.tabla().buscarEstructura(e.getNombre());
            if (info != null && info.getDefinicion() == e) e.validarCampos(ctx, info);
        }
    }

    /** Pasada 2: firmas de las funciones (las repetidas ya se reportaron en la pasada 1). */
    public void validarFunciones(ContextoSemantico ctx) {
        for (DefFuncion f : funciones) {
            if (ctx.tabla().buscarFuncion(f.getNombre()) == f) f.validarFirma(ctx);
        }
    }

    @Override
    public void analizar(ContextoSemantico ctx) {
        funciones.forEach(f -> f.analizar(ctx));
    }
}
