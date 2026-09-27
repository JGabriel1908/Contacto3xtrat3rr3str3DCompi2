package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.Cuarteta.Operador;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.Nativas;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.TablaCompatibilidad;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Seleccion extends Instruccion {

    private final Expresion valor;
    private final List<Caso> casos;

    public Seleccion(Ubicacion ubicacion, Expresion valor, List<Caso> casos) {
        super(ubicacion);
        this.valor = valor;
        this.casos = List.copyOf(casos);
    }

    public Expresion getValor() {
        return valor;
    }

    @Override
    public void analizar(ContextoSemantico ctx) {
        Tipo tipo = valor.analizar(ctx);
        boolean permitido = tipo.esError() || tipo.es(Tipo.Base.ENTERO) || tipo.es(Tipo.Base.CARACTER)
                || tipo.es(Tipo.Base.CADENA);
        if (!permitido) {
            ctx.error(valor, "No se puede seleccionar sobre un valor de tipo " + ctx.nombreTipo(this, tipo));
        }
        TablaCompatibilidad c = ctx.compat(this);
        Set<Object> valores = new HashSet<>();
        boolean hayDefecto = false;
        ctx.entrarSeleccion();
        for (Caso caso : casos) {
            if (caso.esPorDefecto()) {
                if (hayDefecto) ctx.error(caso, "Solo puede haber un caso por defecto");
                hayDefecto = true;
            } else {
                Expresion valorCaso = caso.getValor();
                Tipo tipoCaso = valorCaso.analizar(ctx);
                Object constante = valorCaso.valorConstante();
                if (constante == null) {
                    ctx.error(valorCaso, "El valor de un caso debe ser una constante");
                } else if (!valores.add(constante)) {
                    ctx.error(valorCaso, "El caso " + constante + " está repetido");
                }
                if (!c.asignable(tipo, tipoCaso) && !c.asignable(tipoCaso, tipo)) {
                    ctx.error(valorCaso, "Un caso de tipo " + c.nombre(tipoCaso)
                            + " no corresponde con un valor de tipo " + c.nombre(tipo));
                }
            }
            caso.analizar(ctx);
        }
        ctx.salirSeleccion();
    }

    /** Primero se compara el valor con cada caso; los cuerpos van seguidos para que sin romper continúe al siguiente. */
    @Override
    public void generar(ContextoC3D ctx) {
        String v = valor.generar(ctx);
        String fin = ctx.etiqueta();
        String defecto = fin;
        List<String> etiquetas = new ArrayList<>();
        for (Caso caso : casos) {
            String e = ctx.etiqueta();
            etiquetas.add(e);
            if (caso.esPorDefecto()) {
                defecto = e;
                continue;
            }
            String c = caso.getValor().generar(ctx);
            if (valor.getTipo().es(Tipo.Base.CADENA)) {
                String iguales = ctx.llamar(Nativas.COMPARAR_CADENAS, List.of(ctx.copia(v), c));
                ctx.saltarSi(Operador.SI_IGUAL, iguales, "1", e);
            } else {
                ctx.usar(c);
                ctx.emitir(Operador.SI_IGUAL, v, c, e);
            }
        }
        ctx.saltar(defecto);
        ctx.entrarSeleccion(fin);
        for (int i = 0; i < casos.size(); i++) {
            ctx.colocar(etiquetas.get(i));
            casos.get(i).generar(ctx);
        }
        ctx.salirSeleccion();
        ctx.colocar(fin);
    }
}
