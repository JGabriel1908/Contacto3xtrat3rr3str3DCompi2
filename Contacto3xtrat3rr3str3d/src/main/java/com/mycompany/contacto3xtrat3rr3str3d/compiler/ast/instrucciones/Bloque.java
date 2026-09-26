package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;

public class Bloque extends Instruccion {

    private final List<Instruccion> instrucciones;

    public Bloque(Ubicacion ubicacion, List<Instruccion> instrucciones) {
        super(ubicacion);
        this.instrucciones = List.copyOf(instrucciones);
    }

    public List<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    @Override
    public void analizar(ContextoSemantico ctx) {
        ctx.tabla().abrir("bloque");
        instrucciones.forEach(i -> i.analizar(ctx));
        ctx.tabla().cerrar();
    }

    @Override
    public boolean siempreRetorna() {
        return instrucciones.stream().anyMatch(Instruccion::siempreRetorna);
    }
}
