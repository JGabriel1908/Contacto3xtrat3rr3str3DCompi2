package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.TablaCompatibilidad;

/** x++, x--, ++x, --x */
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
}
