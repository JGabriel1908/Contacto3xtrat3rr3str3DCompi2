package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.Lenguaje;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;

/** import carpeta.Objeto.z  ->  ruta "carpeta/Objeto.z" */
public class Import extends Nodo {

    private final String ruta;
    private final Lenguaje lenguajeDestino;

    public Import(Ubicacion ubicacion, String ruta, Lenguaje lenguajeDestino) {
        super(ubicacion);
        this.ruta = ruta;
        this.lenguajeDestino = lenguajeDestino;
    }

    /** Ruta relativa a la carpeta del archivo .pig, con '/' como separador. */
    public String getRuta() {
        return ruta;
    }

    /** Lenguaje según la extensión; null si la extensión no es válida. */
    public Lenguaje getLenguajeDestino() {
        return lenguajeDestino;
    }
}
