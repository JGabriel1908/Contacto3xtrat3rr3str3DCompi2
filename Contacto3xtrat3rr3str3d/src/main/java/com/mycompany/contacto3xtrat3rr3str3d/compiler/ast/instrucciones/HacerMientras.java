package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

/** hacer-mientras / do-while / facere-dum */
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
}
