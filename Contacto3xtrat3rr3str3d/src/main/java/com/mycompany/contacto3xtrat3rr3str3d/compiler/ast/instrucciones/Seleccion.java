package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.TablaCompatibilidad;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** elegir / switch */
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
}
