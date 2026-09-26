package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.Simbolo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

public class Identificador extends Expresion {

    private final String nombre;

    public Identificador(Ubicacion ubicacion, String nombre) {
        super(ubicacion);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    private Simbolo simbolo;

    public Simbolo getSimbolo() {
        return simbolo;
    }

    @Override
    public Tipo analizar(ContextoSemantico ctx) {
        Simbolo s = ctx.tabla().buscar(nombre);
        // Dentro de una clase, un nombre libre puede ser un atributo (this implícito)
        if (s == null && ctx.getClaseActual() != null) s = ctx.getClaseActual().getAtributo(nombre);
        if (s == null) {
            ctx.error(this, "La variable '" + nombre + "' no ha sido declarada", nombre.length());
            return resultado(Tipo.ERROR);
        }
        simbolo = s;
        return resultado(s.getTipo());
    }

    @Override
    public boolean esAsignable() {
        return simbolo == null || simbolo.esValor();
    }
}
