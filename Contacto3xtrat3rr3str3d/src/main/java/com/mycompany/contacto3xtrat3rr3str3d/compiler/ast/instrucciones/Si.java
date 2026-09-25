package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

/**
 * Condicional. Las cadenas sino/else if/aliter se representan anidando otro Si en {@code sino}.
 */
public class Si extends Instruccion {

    private final Expresion condicion;
    private final Instruccion entonces;
    private final Instruccion sino;

    public Si(Ubicacion ubicacion, Expresion condicion, Instruccion entonces, Instruccion sino) {
        super(ubicacion);
        this.condicion = condicion;
        this.entonces = entonces;
        this.sino = sino;
    }

    @Override
    public void analizar(ContextoSemantico ctx) {
        ctx.verificarCondicion(condicion);
        ctx.analizarCuerpo(entonces, "si");
        if (sino != null) ctx.analizarCuerpo(sino, "sino");
    }

    @Override
    public boolean siempreRetorna() {
        return sino != null && entonces.siempreRetorna() && sino.siempreRetorna();
    }
}
