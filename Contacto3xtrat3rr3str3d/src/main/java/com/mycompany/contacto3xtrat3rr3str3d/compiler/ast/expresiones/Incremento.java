package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.Cuarteta.Operador;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.Direccion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.TablaCompatibilidad;

public class Incremento extends Expresion {

    private final Expresion destino;
    private final boolean incrementa;
    private final boolean prefijo;

    public Incremento(Ubicacion ubicacion, Expresion destino, boolean incrementa, boolean prefijo) {
        super(ubicacion);
        this.destino = destino;
        this.incrementa = incrementa;
        this.prefijo = prefijo;
    }

    @Override
    public Tipo analizar(ContextoSemantico ctx) {
        Tipo t = destino.analizar(ctx);
        if (ctx.verificarAsignable(destino) && TablaCompatibilidad.rango(t) == 0 && !t.esError()) {
            ctx.error(this, "'" + (incrementa ? "++" : "--") + "' solo se puede aplicar a variables numéricas (se obtuvo "
                    + ctx.nombreTipo(this, t) + ")");
        }
        return resultado(t);
    }

    @Override
    public String generar(ContextoC3D ctx) {
        Direccion d = destino.direccion(ctx);
        String anterior = ctx.leer(d);
        String nuevo = ctx.temporal();
        ctx.emitir(incrementa ? Operador.SUMA : Operador.RESTA, anterior, "1", nuevo);
        ctx.guardar(d, nuevo);
        if (!prefijo) return anterior;
        ctx.mantener(nuevo);
        return nuevo;
    }
}
