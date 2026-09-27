package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.Simbolo.Categoria;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.Simbolo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;

public class Parametro extends Nodo {

    private final Tipo tipo;
    private final String nombre;
    private final ModoPaso modo;
    private Simbolo simbolo;

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

    public void validarTipo(ContextoSemantico ctx) {
        ctx.resolverTipo(tipo, this, true);
    }

    public void declarar(ContextoSemantico ctx) {
        Tipo resuelto = ctx.resolverTipo(tipo, this, false);
        simbolo = new Simbolo(nombre, Categoria.PARAMETRO, resuelto, this);
        if (!ctx.tabla().declarar(simbolo)) {
            ctx.error(this, "El parámetro '" + nombre + "' está repetido");
        }
    }

    public void asignarDesplazamiento(ContextoC3D ctx) {
        simbolo.setDesplazamiento(ctx.reservar());
    }
}
