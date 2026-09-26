package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

public class AccesoIndice extends Expresion {

    private final Expresion arreglo;
    private final Expresion indice;

    public AccesoIndice(Ubicacion ubicacion, Expresion arreglo, Expresion indice) {
        super(ubicacion);
        this.arreglo = arreglo;
        this.indice = indice;
    }

    @Override
    public Tipo analizar(ContextoSemantico ctx) {
        Tipo tipoArreglo = arreglo.analizar(ctx);
        Tipo tipoIndice = indice.analizar(ctx);
        if (!tipoIndice.esEntero()) ctx.error(indice, "El índice de un arreglo debe ser entero");
        if (tipoArreglo.esError()) return resultado(Tipo.ERROR);
        if (!tipoArreglo.esArreglo()) {
            ctx.error(this, "No se puede usar [] sobre un valor de tipo " + ctx.nombreTipo(this, tipoArreglo)
                    + " porque no es un arreglo");
            return resultado(Tipo.ERROR);
        }
        return resultado(tipoArreglo.elemento());
    }

    @Override
    public boolean esAsignable() {
        return true;
    }
}
