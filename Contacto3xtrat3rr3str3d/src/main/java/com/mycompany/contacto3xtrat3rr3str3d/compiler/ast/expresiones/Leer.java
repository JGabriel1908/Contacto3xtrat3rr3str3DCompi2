package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

/** leer() / readln(): devuelve la línea leída como cadena. */
public class Leer extends Expresion {

    public Leer(Ubicacion ubicacion) {
        super(ubicacion);
        setTipo(Tipo.CADENA);
    }

    /** Como expresión suelta devuelve cadena; al asignarse se convierte al tipo del destino. */
    @Override
    public Tipo analizar(ContextoSemantico ctx) {
        return resultado(Tipo.CADENA);
    }
}
