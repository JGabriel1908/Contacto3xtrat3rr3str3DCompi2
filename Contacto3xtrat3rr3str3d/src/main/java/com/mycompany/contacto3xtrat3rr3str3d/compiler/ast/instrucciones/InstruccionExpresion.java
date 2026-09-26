package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Asignacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Incremento;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.LlamadaFuncion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.LlamadaMetodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.NuevoObjeto;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

public class InstruccionExpresion extends Instruccion {

    private final Expresion expresion;

    public InstruccionExpresion(Ubicacion ubicacion, Expresion expresion) {
        super(ubicacion);
        this.expresion = expresion;
    }

    @Override
    public void analizar(ContextoSemantico ctx) {
        Tipo tipo = expresion.analizar(ctx);
        boolean valida = expresion instanceof Asignacion || expresion instanceof Incremento
                || expresion instanceof LlamadaFuncion || expresion instanceof LlamadaMetodo
                || expresion instanceof NuevoObjeto;
        if (!valida && !tipo.esError()) {
            ctx.error(expresion, "Esta expresión no es una instrucción válida (se esperaba una asignación o una llamada)");
        }
    }
}
