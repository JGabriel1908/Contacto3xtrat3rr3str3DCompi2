package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.Direccion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.TablaCompatibilidad;
import java.util.List;

public class Asignacion extends Expresion {

    private final Expresion destino;
    private final OperadorBinario operadorCompuesto;
    private final Expresion valor;

    public Asignacion(Ubicacion ubicacion, Expresion destino, OperadorBinario operadorCompuesto, Expresion valor) {
        super(ubicacion);
        this.destino = destino;
        this.operadorCompuesto = operadorCompuesto;
        this.valor = valor;
    }

    public Expresion getValor() {
        return valor;
    }

    @Override
    public Tipo analizar(ContextoSemantico ctx) {
        Tipo tipoDestino = destino.analizar(ctx);
        ctx.verificarAsignable(destino);
        if (operadorCompuesto == null) {
            ctx.verificarValor(tipoDestino, valor, ctx.dimensionesDe(destino));
        } else {
            Tipo tipoValor = valor.analizar(ctx);
            TablaCompatibilidad c = ctx.compat(this);
            Tipo r = c.binaria(operadorCompuesto, tipoDestino, tipoValor);
            if (r == null) {
                ctx.error(this, "El operador '" + operadorCompuesto + "=' no se puede aplicar a "
                        + c.nombre(tipoDestino) + " y " + c.nombre(tipoValor));
            } else if (!c.asignable(tipoDestino, r)) {
                ctx.error(this, "El resultado de tipo " + c.nombre(r) + " no se puede guardar en " + c.nombre(tipoDestino));
            }
        }
        return resultado(tipoDestino);
    }

    /**
     * Las estructuras (y los arreglos guardados dentro de una estructura) se asignan por valor:
     * se copian o se llenan en su bloque. Lo demás se guarda directamente en la posición del destino.
     */
    @Override
    public String generar(ContextoC3D ctx) {
        Tipo tipo = destino.getTipo();
        if (operadorCompuesto != null) {
            Direccion d = destino.direccion(ctx);
            String actual = ctx.leer(d);
            String v = valor.generar(ctx);
            Tipo tipoResultado = TablaCompatibilidad.para(getLenguaje()).binaria(operadorCompuesto, tipo, valor.getTipo());
            String r = ctx.binaria(operadorCompuesto, actual, tipo, v, valor.getTipo(), tipoResultado, getLenguaje());
            ctx.guardar(d, r);
            ctx.mantener(r);
            return r;
        }
        boolean enLinea = destino instanceof AccesoCampo campo && campo.esEnLinea();
        if (tipo.es(Tipo.Base.ESTRUCTURA) || (tipo.esArreglo() && enLinea)) {
            String bloque = destino.generar(ctx);
            List<Integer> dimensiones = enLinea ? ((AccesoCampo) destino).dimensiones(ctx) : List.of();
            int tamano = enLinea ? ((AccesoCampo) destino).tamanoEnLinea(ctx) : ctx.tamanoElemento(tipo);
            if (valor instanceof InicializadorLista lista) {
                ctx.llenar(tipo, lista, bloque, dimensiones);
            } else {
                ctx.copiar(bloque, valor.generar(ctx), tamano);
            }
            return bloque;
        }
        Direccion d = destino.direccion(ctx);
        String v = valor instanceof InicializadorLista lista
                ? ctx.crearDesdeLista(tipo, lista, List.of())
                : valor.generar(ctx);
        ctx.guardar(d, v);
        ctx.mantener(v);
        return v;
    }
}
