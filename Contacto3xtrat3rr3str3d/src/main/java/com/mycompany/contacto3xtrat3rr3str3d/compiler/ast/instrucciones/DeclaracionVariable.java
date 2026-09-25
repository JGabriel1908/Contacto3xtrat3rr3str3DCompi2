package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.Simbolo.Categoria;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.Simbolo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;

/**
 * Declaración de una variable o arreglo.
 * Ejemplos: entero x = 5 / int[] a = {1, 2} / series v[3] : numerus / esto o : novus Persona()
 */
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

    /** Tamaños declarados de cada dimensión (vacío si no es arreglo o no se indicó tamaño). */
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
        // El valor se analiza antes de declarar la variable: "entero x = x" es un error
        if (valorInicial != null) ctx.verificarValor(resuelto, valorInicial, dimensiones);
        if (!ctx.tabla().declarar(new Simbolo(nombre, Categoria.VARIABLE, resuelto, this))) {
            ctx.error(this, "La variable '" + nombre + "' ya fue declarada en este ámbito");
        }
    }
}
