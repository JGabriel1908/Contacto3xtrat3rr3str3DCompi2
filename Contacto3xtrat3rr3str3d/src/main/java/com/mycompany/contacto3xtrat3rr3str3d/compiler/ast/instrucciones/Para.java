package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;

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

    @Override
    public void generar(ContextoC3D ctx) {
        inicio.forEach(ctx::generar);
        String ciclo = ctx.etiqueta();
        String actualizar = ctx.etiqueta();
        String fin = ctx.etiqueta();
        ctx.colocar(ciclo);
        if (condicion != null) ctx.saltarSiFalso(condicion.generar(ctx), fin);
        ctx.entrarCiclo(fin, actualizar);
        ctx.generar(cuerpo);
        ctx.salirCiclo();
        ctx.colocar(actualizar);
        for (Expresion e : actualizacion) {
            e.generar(ctx);
            ctx.finInstruccion();
        }
        ctx.saltar(ciclo);
        ctx.colocar(fin);
    }
}
