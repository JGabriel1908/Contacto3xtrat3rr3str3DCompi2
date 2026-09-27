package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Bloque;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoClase;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;

public class DefMetodo extends Nodo {

    private final Modificador modificador;
    private final Tipo tipoRetorno;
    private final String nombre;
    private final List<Parametro> parametros;
    private final Bloque cuerpo;

    public DefMetodo(Ubicacion ubicacion, Modificador modificador, Tipo tipoRetorno, String nombre,
                     List<Parametro> parametros, Bloque cuerpo) {
        super(ubicacion);
        this.modificador = modificador;
        this.tipoRetorno = tipoRetorno;
        this.nombre = nombre;
        this.parametros = List.copyOf(parametros);
        this.cuerpo = cuerpo;
    }

    public Tipo getTipoRetorno() {
        return tipoRetorno;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Parametro> getParametros() {
        return parametros;
    }

    public void validarFirma(ContextoSemantico ctx, InfoClase clase) {
        ctx.resolverTipo(tipoRetorno, this, true);
        parametros.forEach(p -> p.validarTipo(ctx));
        List<Tipo> firma = ContextoSemantico.firma(parametros);
        String texto = nombre + ctx.tiposTexto(firma, this);
        boolean repetido = clase.getMetodos(nombre).stream()
                .anyMatch(otro -> ContextoSemantico.firma(otro.getParametros()).equals(firma));
        if (repetido) {
            ctx.error(this, "Ya existe un método " + texto + " en la clase " + clase.getNombre());
            return;
        }
        clase.agregarMetodo(this);
    }

    public void analizar(ContextoSemantico ctx) {
        ctx.analizarFuncion(nombre, parametros, ctx.resolverTipo(tipoRetorno, this, false), cuerpo, this,
                "El método '" + nombre + "'");
    }

    /** Marco: [0] retorno, [1] this, luego parámetros y variables locales. */
    public void generar(ContextoC3D ctx) {
        ctx.iniciarFuncion(2);
        parametros.forEach(p -> p.asignarDesplazamiento(ctx));
        cuerpo.getInstrucciones().forEach(ctx::generar);
        ctx.terminarFuncion(ctx.nombre(this));
    }
}
