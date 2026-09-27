package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.Cuarteta.Operador;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.TablaCompatibilidad;

public class Ternario extends Expresion {

    private final Expresion condicion;
    private final Expresion siVerdadero;
    private final Expresion siFalso;

    public Ternario(Ubicacion ubicacion, Expresion condicion, Expresion siVerdadero, Expresion siFalso) {
        super(ubicacion);
        this.condicion = condicion;
        this.siVerdadero = siVerdadero;
        this.siFalso = siFalso;
    }

    @Override
    public Tipo analizar(ContextoSemantico ctx) {
        ctx.verificarCondicion(condicion);
        Tipo a = siVerdadero.analizar(ctx);
        Tipo b = siFalso.analizar(ctx);
        TablaCompatibilidad c = ctx.compat(this);
        if (c.asignable(a, b)) return resultado(a);
        if (c.asignable(b, a)) return resultado(b);
        ctx.error(this, "Las dos opciones del operador ternario deben ser compatibles (" + c.nombre(a) + " y "
                + c.nombre(b) + ")");
        return resultado(Tipo.ERROR);
    }

    @Override
    public String generar(ContextoC3D ctx) {
        String resultado = ctx.temporal();
        String falso = ctx.etiqueta();
        String fin = ctx.etiqueta();
        ctx.saltarSiFalso(condicion.generar(ctx), falso);
        String a = siVerdadero.generar(ctx);
        ctx.usar(a);
        ctx.emitir(Operador.ASIGNACION, a, null, resultado);
        ctx.saltar(fin);
        ctx.colocar(falso);
        String b = siFalso.generar(ctx);
        ctx.usar(b);
        ctx.emitir(Operador.ASIGNACION, b, null, resultado);
        ctx.colocar(fin);
        return resultado;
    }
}
