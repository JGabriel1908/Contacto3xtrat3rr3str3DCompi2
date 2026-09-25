package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;

/** Caso de un elegir/switch. Sin romper/break continúa con el siguiente caso. */
public class Caso extends Nodo {

    private final Expresion valor;
    private final List<Instruccion> instrucciones;

    public Caso(Ubicacion ubicacion, Expresion valor, List<Instruccion> instrucciones) {
        super(ubicacion);
        this.valor = valor;
        this.instrucciones = List.copyOf(instrucciones);
    }

    /** null para el caso por defecto (siempre / default). */
    public Expresion getValor() {
        return valor;
    }

    public boolean esPorDefecto() {
        return valor == null;
    }

    public List<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    /** Cada caso tiene su propio ámbito. */
    public void analizar(ContextoSemantico ctx) {
        ctx.tabla().abrir("caso");
        instrucciones.forEach(i -> i.analizar(ctx));
        ctx.tabla().cerrar();
    }
}
