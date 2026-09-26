package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

public class Leer extends Expresion {

    public Leer(Ubicacion ubicacion) {
        super(ubicacion);
        setTipo(Tipo.CADENA);
    }

    @Override
    public Tipo analizar(ContextoSemantico ctx) {
        return resultado(Tipo.CADENA);
    }
}
