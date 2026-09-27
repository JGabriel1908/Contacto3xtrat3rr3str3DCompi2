package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.Nativas;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;

public class Leer extends Expresion {

    public Leer(Ubicacion ubicacion) {
        super(ubicacion);
        setTipo(Tipo.CADENA);
    }

    @Override
    public Tipo analizar(ContextoSemantico ctx) {
        return resultado(Tipo.CADENA);
    }

    @Override
    public String generar(ContextoC3D ctx) {
        return ctx.convertirLectura(ctx.llamar(Nativas.LEER_CADENA, List.of()), getTipo());
    }
}
