package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;

public class Caso extends Nodo {

    private final Expresion valor;
    private final List<Instruccion> instrucciones;

    public Caso(Ubicacion ubicacion, Expresion valor, List<Instruccion> instrucciones) {
        super(ubicacion);
        this.valor = valor;
        this.instrucciones = List.copyOf(instrucciones);
    }

    public Expresion getValor() {
        return valor;
    }

    public boolean esPorDefecto() {
        return valor == null;
    }

    public List<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    public void analizar(ContextoSemantico ctx) {
        ctx.tabla().abrir("caso");
        instrucciones.forEach(i -> i.analizar(ctx));
        ctx.tabla().cerrar();
    }

    public void generar(ContextoC3D ctx) {
        instrucciones.forEach(ctx::generar);
    }
}
