package com.mycompany.contacto3xtrat3rr3str3d.compiler;

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
