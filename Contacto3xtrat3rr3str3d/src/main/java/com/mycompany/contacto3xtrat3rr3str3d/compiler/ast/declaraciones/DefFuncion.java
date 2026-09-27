package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Bloque;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;

//Funcion global de Y
public class DefFuncion extends Nodo {

    private final String nombre;
    private final List<Parametro> parametros;
    private final Tipo tipoRetorno;
    private final Bloque cuerpo;

    public DefFuncion(Ubicacion ubicacion, String nombre, List<Parametro> parametros, Tipo tipoRetorno, Bloque cuerpo) {
        super(ubicacion);
        this.nombre = nombre;
        this.parametros = List.copyOf(parametros);
        this.tipoRetorno = tipoRetorno;
        this.cuerpo = cuerpo;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Parametro> getParametros() {
        return parametros;
    }

    public Tipo getTipoRetorno() {
        return tipoRetorno;
    }

    public void registrar(ContextoSemantico ctx) {
        DefFuncion previa = ctx.tabla().buscarFuncion(nombre);
        if (previa != null) {
            ctx.error(this, "La función '" + nombre + "' ya fue definida en " + previa.getUbicacion());
            return;
        }
        ctx.tabla().registrarFuncion(this);
    }

    public void validarFirma(ContextoSemantico ctx) {
        parametros.forEach(p -> p.validarTipo(ctx));
        ctx.resolverTipo(tipoRetorno, this, true);
    }

    public void analizar(ContextoSemantico ctx) {
        ctx.analizarFuncion(nombre, parametros, ctx.resolverTipo(tipoRetorno, this, false), cuerpo, this,
                "La función '" + nombre + "'");
    }

    /** Marco: [0] retorno, luego parámetros y variables locales. */
    public void generar(ContextoC3D ctx) {
        ctx.iniciarFuncion(1);
        parametros.forEach(p -> p.asignarDesplazamiento(ctx));
        cuerpo.getInstrucciones().forEach(ctx::generar);
        ctx.terminarFuncion(ctx.nombre(this));
    }
}
