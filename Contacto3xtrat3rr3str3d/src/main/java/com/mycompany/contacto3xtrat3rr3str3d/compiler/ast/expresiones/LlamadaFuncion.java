package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.Lenguaje;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefFuncion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefMetodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.ArrayList;
import java.util.List;

public class LlamadaFuncion extends Expresion {

    private final String nombre;
    private final List<Expresion> argumentos;

    public LlamadaFuncion(Ubicacion ubicacion, String nombre, List<Expresion> argumentos) {
        super(ubicacion);
        this.nombre = nombre;
        this.argumentos = List.copyOf(argumentos);
    }

    public String getNombre() {
        return nombre;
    }

    private Nodo declaracion;

    public Nodo getDeclaracion() {
        return declaracion;
    }

    @Override
    public Tipo analizar(ContextoSemantico ctx) {
        List<Tipo> tipos = ctx.tiposArgumentos(argumentos);

        if (ctx.getClaseActual() != null) {
            //En el zetariano una llamada sin objeto es una llamada en la clase actual
            DefMetodo metodo = ctx.resolverMetodo(ctx.getClaseActual(), nombre, tipos, this);
            if (metodo == null) return resultado(Tipo.ERROR);
            declaracion = metodo;
            return resultado(metodo.getTipoRetorno());
        }

        DefFuncion funcion = ctx.tabla().buscarFuncion(nombre);
        if (funcion == null) {
            String extra = getLenguaje() == Lenguaje.PIG_LATIN ? " (debe estar definida en un archivo .y importado)" : "";
            ctx.error(this, "La función '" + nombre + "' no existe" + extra, nombre.length());
            return resultado(Tipo.ERROR);
        }
        declaracion = funcion;
        ctx.verificarArgumentosFuncion(funcion, argumentos, tipos, this);
        return resultado(funcion.getTipoRetorno());
    }

    /** Dentro de una clase la llamada es a un método del mismo objeto: se pasa this como primer argumento. */
    @Override
    public String generar(ContextoC3D ctx) {
        List<String> valores = new ArrayList<>();
        if (declaracion instanceof DefMetodo) valores.add(ctx.este());
        for (Expresion a : argumentos) valores.add(a.generar(ctx));
        return ctx.llamar(ctx.nombre(declaracion), valores);
    }
}
