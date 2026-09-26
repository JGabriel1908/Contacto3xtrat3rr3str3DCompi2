package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;

public class NuevoArreglo extends Expresion {

    private final Tipo tipoElemento;
    private final List<Expresion> tamanos;
    private final int dimensiones;
    private final InicializadorLista inicializador;

    public NuevoArreglo(Ubicacion ubicacion, Tipo tipoElemento, List<Expresion> tamanos,
                        int dimensiones, InicializadorLista inicializador) {
        super(ubicacion);
        this.tipoElemento = tipoElemento;
        this.tamanos = List.copyOf(tamanos);
        this.dimensiones = dimensiones;
        this.inicializador = inicializador;
    }

    public int getDimensiones() {
        return dimensiones;
    }

    @Override
    public Tipo analizar(ContextoSemantico ctx) {
        Tipo base = ctx.resolverTipo(tipoElemento, this, true);
        for (Expresion tam : tamanos) {
            if (!tam.analizar(ctx).esEntero()) ctx.error(tam, "El tamaño de un arreglo debe ser entero");
        }
        Tipo tipo = base.esError() ? Tipo.ERROR : base.arreglo(dimensiones);
        if (inicializador != null) ctx.verificarLista(tipo, inicializador, List.of(), 0);
        return resultado(tipo);
    }
}
