package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefMetodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoClase;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.ArrayList;
import java.util.List;

public class LlamadaMetodo extends Expresion {

    private final Expresion objeto;
    private final String metodo;
    private final List<Expresion> argumentos;

    public LlamadaMetodo(Ubicacion ubicacion, Expresion objeto, String metodo, List<Expresion> argumentos) {
        super(ubicacion);
        this.objeto = objeto;
        this.metodo = metodo;
        this.argumentos = List.copyOf(argumentos);
    }

    private DefMetodo declaracion;

    public DefMetodo getDeclaracion() {
        return declaracion;
    }

    @Override
    public Tipo analizar(ContextoSemantico ctx) {
        Tipo tipoObjeto = objeto.analizar(ctx);
        List<Tipo> tipos = ctx.tiposArgumentos(argumentos);
        if (tipoObjeto.esError()) return resultado(Tipo.ERROR);
        if (!tipoObjeto.es(Tipo.Base.CLASE)) {
            ctx.error(this, "Solo se pueden invocar métodos sobre objetos (se obtuvo " + ctx.nombreTipo(this, tipoObjeto) + ")");
            return resultado(Tipo.ERROR);
        }
        InfoClase info = ctx.tabla().buscarClase(tipoObjeto.getNombre());
        if (info == null) return resultado(Tipo.ERROR);
        DefMetodo elegido = ctx.resolverMetodo(info, metodo, tipos, this);
        if (elegido == null) return resultado(Tipo.ERROR);
        declaracion = elegido;
        return resultado(elegido.getTipoRetorno());
    }

    @Override
    public String generar(ContextoC3D ctx) {
        List<String> valores = new ArrayList<>();
        valores.add(objeto.generar(ctx));
        for (Expresion a : argumentos) valores.add(a.generar(ctx));
        return ctx.llamar(ctx.nombre(declaracion), valores);
    }
}
