package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.InicializadorLista;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.Simbolo.Categoria;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.Simbolo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.ArrayList;
import java.util.List;


public class DeclaracionVariable extends Instruccion {

    private final Tipo tipo;
    private final String nombre;
    private final List<Expresion> dimensiones;
    private final Expresion valorInicial;
    private Simbolo simbolo;

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
        simbolo = new Simbolo(nombre, Categoria.VARIABLE, resuelto, this);
        if (!ctx.tabla().declarar(simbolo)) {
            ctx.error(this, "La variable '" + nombre + "' ya fue declarada en este ámbito");
        }
    }

    /**
     * La variable ocupa una posición del marco. Las estructuras (Y?, Pig Latin) se guardan por valor:
     * se reserva su bloque y se llena o se copia. Los arreglos con tamaño se reservan al declararse.
     */
    @Override
    public void generar(ContextoC3D ctx) {
        int posicion = ctx.reservar();
        simbolo.setDesplazamiento(posicion);
        Tipo t = simbolo.getTipo();
        String valor;
        if (valorInicial instanceof InicializadorLista lista) {
            if (t.esArreglo()) {
                valor = ctx.crearDesdeLista(t, lista, dimensiones);
            } else {
                valor = ctx.nuevaEstructura(t);
                ctx.llenar(t, lista, valor, List.of());
            }
        } else if (t.es(Tipo.Base.ESTRUCTURA)) {
            valor = ctx.nuevaEstructura(t);
            if (valorInicial != null) ctx.copiar(valor, valorInicial.generar(ctx), ctx.tamanoElemento(t));
        } else if (valorInicial != null) {
            valor = valorInicial.generar(ctx);
        } else if (t.esArreglo() && !dimensiones.isEmpty()) {
            List<String> tamanos = new ArrayList<>();
            for (Expresion d : dimensiones) tamanos.add(d.generar(ctx));
            valor = ctx.nuevoArreglo(t, tamanos);
        } else {
            valor = "0";
        }
        ctx.guardarLocal(posicion, valor);
    }
}
