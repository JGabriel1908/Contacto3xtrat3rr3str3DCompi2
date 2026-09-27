package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.Cuarteta.Operador;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.Direccion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoClase;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoEstructura;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.Simbolo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;

public class AccesoCampo extends Expresion {

    private final Expresion objeto;
    private final String campo;

    public AccesoCampo(Ubicacion ubicacion, Expresion objeto, String campo) {
        super(ubicacion);
        this.objeto = objeto;
        this.campo = campo;
    }

    public String getCampo() {
        return campo;
    }

    @Override
    public Tipo analizar(ContextoSemantico ctx) {
        Tipo tipoObjeto = objeto.analizar(ctx);
        if (tipoObjeto.esError()) return resultado(Tipo.ERROR);
        if (tipoObjeto.es(Tipo.Base.ESTRUCTURA)) {
            InfoEstructura info = ctx.tabla().buscarEstructura(tipoObjeto.getNombre());
            Simbolo s = info == null ? null : info.getCampo(campo);
            if (s == null) {
                ctx.error(this, "La estructura " + tipoObjeto.getNombre() + " no tiene un campo '" + campo + "'");
                return resultado(Tipo.ERROR);
            }
            return resultado(s.getTipo());
        }
        if (tipoObjeto.es(Tipo.Base.CLASE)) {
            InfoClase info = ctx.tabla().buscarClase(tipoObjeto.getNombre());
            Simbolo s = info == null ? null : info.getAtributo(campo);
            if (s == null) {
                ctx.error(this, "La clase " + tipoObjeto.getNombre() + " no tiene un atributo '" + campo + "'");
                return resultado(Tipo.ERROR);
            }
            return resultado(s.getTipo());
        }
        ctx.error(this, "No se puede acceder a '." + campo + "' en un valor de tipo " + ctx.nombreTipo(this, tipoObjeto));
        return resultado(Tipo.ERROR);
    }

    @Override
    public boolean esAsignable() {
        return true;
    }

    /** Una estructura o arreglo guardado dentro de una estructura: su valor es su dirección. */
    public boolean esEnLinea() {
        return objeto.getTipo().es(Tipo.Base.ESTRUCTURA) && (getTipo().esArreglo() || getTipo().es(Tipo.Base.ESTRUCTURA));
    }

    @Override
    public String generar(ContextoC3D ctx) {
        String posicion = posicion(ctx);
        return esEnLinea() ? posicion : ctx.cargar(Direccion.HEAP, posicion);
    }

    @Override
    public Direccion direccion(ContextoC3D ctx) {
        return new Direccion(Direccion.HEAP, posicion(ctx));
    }

    private String posicion(ContextoC3D ctx) {
        String base = objeto.generar(ctx);
        Tipo tipoObjeto = objeto.getTipo();
        int desplazamiento = tipoObjeto.es(Tipo.Base.CLASE)
                ? ctx.tabla().buscarClase(tipoObjeto.getNombre()).getAtributo(campo).getDesplazamiento()
                : ctx.desplazamientoCampo(ctx.estructura(tipoObjeto), campo);
        return ctx.operar(Operador.SUMA, base, String.valueOf(desplazamiento));
    }

    public int tamanoEnLinea(ContextoC3D ctx) {
        return ctx.tamanoCampo(ctx.estructura(objeto.getTipo()).getCampo(campo));
    }

    public List<Integer> dimensiones(ContextoC3D ctx) {
        return ctx.dimensionesCampo(ctx.estructura(objeto.getTipo()).getCampo(campo));
    }
}
