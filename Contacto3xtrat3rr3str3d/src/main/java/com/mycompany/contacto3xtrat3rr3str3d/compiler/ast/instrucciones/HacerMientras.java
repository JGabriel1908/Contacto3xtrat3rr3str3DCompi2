package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.Cuarteta.Operador;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

public class HacerMientras extends Instruccion {

    private final Instruccion cuerpo;
    private final Expresion condicion;

    public HacerMientras(Ubicacion ubicacion, Instruccion cuerpo, Expresion condicion) {
        super(ubicacion);
        this.cuerpo = cuerpo;
        this.condicion = condicion;
    }

    @Override
    public void analizar(ContextoSemantico ctx) {
        ctx.entrarCiclo();
        ctx.analizarCuerpo(cuerpo, "hacer");
        ctx.salirCiclo();
        ctx.verificarCondicion(condicion);
    }

    @Override
    public boolean siempreRetorna() {
        return cuerpo.siempreRetorna();
    }

    @Override
    public void generar(ContextoC3D ctx) {
        String inicio = ctx.etiqueta();
        String evaluar = ctx.etiqueta();
        String fin = ctx.etiqueta();
        ctx.colocar(inicio);
        ctx.entrarCiclo(fin, evaluar);
        ctx.generar(cuerpo);
        ctx.salirCiclo();
        ctx.colocar(evaluar);
        ctx.saltarSi(Operador.SI_DIFERENTE, condicion.generar(ctx), "0", inicio);
        ctx.colocar(fin);
    }
}
