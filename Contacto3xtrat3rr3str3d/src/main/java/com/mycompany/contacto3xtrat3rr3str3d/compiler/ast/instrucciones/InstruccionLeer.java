package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.Nativas;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;


public class InstruccionLeer extends Instruccion {

    private final Expresion destino;

    public InstruccionLeer(Ubicacion ubicacion, Expresion destino) {
        super(ubicacion);
        this.destino = destino;
    }

    @Override
    public void analizar(ContextoSemantico ctx) {
        if (destino == null) return;
        Tipo tipo = destino.analizar(ctx);
        if (ctx.verificarAsignable(destino) && !tipo.esPrimitivo() && !tipo.esError()) {
            ctx.error(destino, "Solo se puede leer en variables de tipo primitivo (se obtuvo "
                    + ctx.nombreTipo(this, tipo) + ")");
        }
    }

    @Override
    public void generar(ContextoC3D ctx) {
        String cadena = ctx.llamar(Nativas.LEER_CADENA, List.of());
        if (destino == null) return;
        String valor = ctx.convertirLectura(cadena, destino.getTipo());
        ctx.guardar(destino.direccion(ctx), valor);
    }
}
