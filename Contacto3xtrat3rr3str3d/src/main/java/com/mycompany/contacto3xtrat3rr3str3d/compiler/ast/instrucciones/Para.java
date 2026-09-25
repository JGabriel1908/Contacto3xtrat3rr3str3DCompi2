package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;

/** para / for / per */
public class Para extends Instruccion {

    private final List<Instruccion> inicio;
    private final Expresion condicion;
    private final List<Expresion> actualizacion;
    private final Instruccion cuerpo;

    public Para(Ubicacion ubicacion, List<Instruccion> inicio, Expresion condicion,
                List<Expresion> actualizacion, Instruccion cuerpo) {
        super(ubicacion);
        this.inicio = List.copyOf(inicio);
        this.condicion = condicion;
        this.actualizacion = List.copyOf(actualizacion);
        this.cuerpo = cuerpo;
    }

    @Override
    public void analizar(ContextoSemantico ctx) {
        ctx.tabla().abrir("para");
        inicio.forEach(i -> i.analizar(ctx));
        if (condicion != null) ctx.verificarCondicion(condicion);
        actualizacion.forEach(e -> e.analizar(ctx));
        ctx.entrarCiclo();
        ctx.analizarCuerpo(cuerpo, "cuerpo");
        ctx.salirCiclo();
        ctx.tabla().cerrar();
    }
}
