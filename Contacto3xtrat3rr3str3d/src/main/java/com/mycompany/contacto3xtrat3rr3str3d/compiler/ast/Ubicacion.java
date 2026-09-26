package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.Lenguaje;
import java.io.File;

/**
 * Posición de un nodo en el código fuente.
 *
 * @param linea   
 * @param columna 
 */
public record Ubicacion(String archivo, Lenguaje lenguaje, int linea, int columna) {

    @Override
    public String toString() {
        return new File(archivo).getName() + ":" + linea + ":" + (columna + 1);
    }
}
