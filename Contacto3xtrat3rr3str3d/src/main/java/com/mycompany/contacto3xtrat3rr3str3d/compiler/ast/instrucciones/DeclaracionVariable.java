package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.Simbolo.Categoria;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.Simbolo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;


public class DeclaracionVariable extends Instruccion {

    private final Tipo tipo;
    private final String nombre;
    private final List<Expresion> dimensiones;
    private final Expresion valorInicial;

    public DeclaracionVariable(Ubicacion ubicacion, Tipo tipo, String nombre,
                               List<Expresion> dimensiones, Expresion valorInicial) {
        super(ubicacion);
        this.tipo = tipo;
        this.nombre = nombre;
        this.dimensiones = List.copyOf(dimensiones);
        this.valorInicial = valorInicial;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Expresion> getDimensiones() {
        return dimensiones;
    }

    @Override
    public void analizar(ContextoSemantico ctx) {
        Tipo resuelto = ctx.resolverTipo(tipo, this, true);
        if (resuelto.getBase() == Tipo.Base.VACIO) {
            ctx.error(this, "Una variable no puede ser de tipo " + ctx.nombreTipo(this, resuelto));
            resuelto = Tipo.ERROR;
        }
        for (Expresion dim : dimensiones) {
            if (!dim.analizar(ctx).esEntero()) ctx.error(dim, "El tamaño de un arreglo debe ser entero");
        }
        if (valorInicial != null) ctx.verificarValor(resuelto, valorInicial, dimensiones);
        if (!ctx.tabla().declarar(new Simbolo(nombre, Categoria.VARIABLE, resuelto, this))) {
            ctx.error(this, "La variable '" + nombre + "' ya fue declarada en este ámbito");
        }
    }
}
