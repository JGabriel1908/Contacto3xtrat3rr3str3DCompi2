package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.Simbolo.Categoria;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.Simbolo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

public class Parametro extends Nodo {

    private final Tipo tipo;
    private final String nombre;
    private final ModoPaso modo;

    public Parametro(Ubicacion ubicacion, Tipo tipo, String nombre, ModoPaso modo) {
        super(ubicacion);
        this.tipo = tipo;
        this.nombre = nombre;
        this.modo = modo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public ModoPaso getModo() {
        return modo;
    }

    /** Pasada 2: verifica que el tipo exista. */
    public void validarTipo(ContextoSemantico ctx) {
        ctx.resolverTipo(tipo, this, true);
    }

    /** Pasada 3: declara el parámetro en el ámbito de la función. */
    public void declarar(ContextoSemantico ctx) {
        Tipo resuelto = ctx.resolverTipo(tipo, this, false);
        if (!ctx.tabla().declarar(new Simbolo(nombre, Categoria.PARAMETRO, resuelto, this))) {
            ctx.error(this, "El parámetro '" + nombre + "' está repetido");
        }
    }
}
