package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoEstructura;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.Simbolo.Categoria;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.Simbolo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;

public class Campo extends Nodo {

    private final Tipo tipo;
    private final String nombre;
    private final List<Expresion> dimensiones;

    public Campo(Ubicacion ubicacion, Tipo tipo, String nombre, List<Expresion> dimensiones) {
        super(ubicacion);
        this.tipo = tipo;
        this.nombre = nombre;
        this.dimensiones = List.copyOf(dimensiones);
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Expresion> getDimensiones() {
        return dimensiones;
    }

    public void validar(ContextoSemantico ctx, InfoEstructura estructura) {
        Tipo resuelto = ctx.resolverTipo(tipo, this, true);
        for (Expresion dim : dimensiones) {
            Integer valor = dim.valorConstante() instanceof Integer i ? i : null;
            if (valor == null) {
                ctx.error(dim, "El tamaño de un arreglo dentro de una estructura debe ser una constante entera");
            } else if (valor <= 0) {
                ctx.error(dim, "El tamaño de un arreglo debe ser mayor que cero");
            }
        }
        Simbolo s = new Simbolo(nombre, Categoria.CAMPO, resuelto, this);
        if (!estructura.agregarCampo(s)) {
            ctx.error(this, "El campo '" + nombre + "' ya existe en la estructura " + estructura.getNombre());
        }
    }
}
