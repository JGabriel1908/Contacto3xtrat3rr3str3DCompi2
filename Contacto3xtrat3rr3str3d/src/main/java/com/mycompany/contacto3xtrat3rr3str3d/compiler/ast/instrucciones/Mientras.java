package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

public class Mientras extends Instruccion {

    private final Expresion condicion;
    private final Instruccion cuerpo;

    public Mientras(Ubicacion ubicacion, Expresion condicion, Instruccion cuerpo) {
        super(ubicacion);
        this.condicion = condicion;
        this.cuerpo = cuerpo;
    }

    @Override
    public void analizar(ContextoSemantico ctx) {
        ctx.verificarCondicion(condicion);
        ctx.entrarCiclo();
        ctx.analizarCuerpo(cuerpo, "mientras");
        ctx.salirCiclo();
    }

    @Override
    public void generar(ContextoC3D ctx) {
        String inicio = ctx.etiqueta();
        String fin = ctx.etiqueta();
        ctx.colocar(inicio);
        ctx.saltarSiFalso(condicion.generar(ctx), fin);
        ctx.entrarCiclo(fin, inicio);
        ctx.generar(cuerpo);
        ctx.salirCiclo();
        ctx.saltar(inicio);
        ctx.colocar(fin);
    }
}
