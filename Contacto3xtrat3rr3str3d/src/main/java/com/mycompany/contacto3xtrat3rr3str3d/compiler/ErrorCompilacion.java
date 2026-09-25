package com.mycompany.contacto3xtrat3rr3str3d.compiler;

/**
 * Error encontrado en cualquier fase del análisis.
 *
 * @param linea    línea (base 1)
 * @param columna  columna (base 0)
 * @param longitud cantidad de caracteres a marcar en el editor
 */
public record ErrorCompilacion(TipoError tipo, String descripcion, String archivo,
                               int linea, int columna, int longitud) {

    public enum TipoError {
        LEXICO("Léxico"),
        SINTACTICO("Sintáctico"),
        SEMANTICO("Semántico");

        private final String nombre;

        TipoError(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }
}
