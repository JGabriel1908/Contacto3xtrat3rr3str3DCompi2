package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.Direccion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ErrorGeneracion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.ArrayList;
import java.util.List;

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

    /** Un elemento estructura se guarda dentro del arreglo: su valor es su dirección. */
    @Override
    public String generar(ContextoC3D ctx) {
        String posicion = posicion(ctx);
        return getTipo().es(Tipo.Base.ESTRUCTURA) ? posicion : ctx.cargar(Direccion.HEAP, posicion);
    }

    @Override
    public Direccion direccion(ContextoC3D ctx) {
        return new Direccion(Direccion.HEAP, posicion(ctx));
    }

    /** a[i][j] llega como AccesoIndice(AccesoIndice(a, i), j): se juntan todos los índices del arreglo. */
    private String posicion(ContextoC3D ctx) {
        List<Expresion> indices = new ArrayList<>();
        Expresion base = this;
        while (base instanceof AccesoIndice acceso) {
            indices.add(0, acceso.indice);
            base = acceso.arreglo;
        }
        if (indices.size() != base.getTipo().getDimensiones()) {
            throw new ErrorGeneracion(this, "Se deben indicar todas las dimensiones del arreglo");
        }
        String arreglo = base.generar(ctx);
        List<String> valores = new ArrayList<>();
        for (Expresion i : indices) valores.add(i.generar(ctx));
        return ctx.elemento(arreglo, valores, base.getTipo());
    }
}
