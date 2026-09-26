package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.Lenguaje;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;

public class Import extends Nodo {

    private final String ruta;
    private final Lenguaje lenguajeDestino;

    public Import(Ubicacion ubicacion, String ruta, Lenguaje lenguajeDestino) {
        super(ubicacion);
        this.ruta = ruta;
        this.lenguajeDestino = lenguajeDestino;
    }

    public String getRuta() {
        return ruta;
    }

    public Lenguaje getLenguajeDestino() {
        return lenguajeDestino;
    }
}
