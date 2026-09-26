package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.Lenguaje;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

public class Romper extends Instruccion {

    public Romper(Ubicacion ubicacion) {
        super(ubicacion);
    }

    @Override
    public void analizar(ContextoSemantico ctx) {
        if (!ctx.enCiclo() && !ctx.enSeleccion()) {
            ctx.error(this, "'" + ctx.palabra(this, "romper", "break", "interrumpe") + "' solo puede usarse dentro de un ciclo"
                    + (getLenguaje() == Lenguaje.PIG_LATIN ? "" : " o una selección"));
        }
    }
}
