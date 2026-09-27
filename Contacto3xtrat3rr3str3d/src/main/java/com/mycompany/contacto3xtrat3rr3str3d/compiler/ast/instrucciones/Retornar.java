package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.Cuarteta.Operador;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;

public class Retornar extends Instruccion {

    private final Expresion valor;

    public Retornar(Ubicacion ubicacion, Expresion valor) {
        super(ubicacion);
        this.valor = valor;
    }

    public Expresion getValor() {
        return valor;
    }

    @Override
    public void analizar(ContextoSemantico ctx) {
        Tipo retorno = ctx.getRetornoActual();
        if (retorno == null) {
            ctx.error(this, "'retornar' solo puede usarse dentro de una función");
            if (valor != null) valor.analizar(ctx);
            return;
        }
        boolean sinRetorno = retorno.getBase() == Tipo.Base.VACIO;
        if (valor == null) {
            if (!sinRetorno && !retorno.esError()) {
                ctx.error(this, "Se debe retornar un valor de tipo " + ctx.nombreTipo(this, retorno));
            }
        } else if (sinRetorno) {
            valor.analizar(ctx);
            ctx.error(this, "Una función sin tipo de retorno no puede retornar un valor");
        } else {
            ctx.verificarValor(retorno, valor, List.of());
        }
    }

    @Override
    public boolean siempreRetorna() {
        return true;
    }

    @Override
    public void generar(ContextoC3D ctx) {
        if (valor != null) ctx.guardarLocal(0, valor.generar(ctx));
        ctx.emitir(Operador.RETORNO, null, null, null);
    }
}
