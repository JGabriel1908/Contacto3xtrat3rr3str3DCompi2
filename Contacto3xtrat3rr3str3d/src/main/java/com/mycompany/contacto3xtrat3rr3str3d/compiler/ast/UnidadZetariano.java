package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefClase;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

/** Archivo .z: una única clase. */
public class UnidadZetariano extends Unidad {

    private final DefClase clase;

    public UnidadZetariano(Ubicacion ubicacion, DefClase clase) {
        super(ubicacion);
        this.clase = clase;
    }

    public DefClase getClase() {
        return clase;
    }

    /** Pasada 1: registra la clase. */
    public void registrar(ContextoSemantico ctx) {
        clase.registrar(ctx, getArchivo());
    }

    /** Pasada 2: atributos, constructores y métodos. */
    public void validarDeclaraciones(ContextoSemantico ctx) {
        clase.validarMiembros(ctx);
    }

    @Override
    public void analizar(ContextoSemantico ctx) {
        clase.analizar(ctx);
    }
}
