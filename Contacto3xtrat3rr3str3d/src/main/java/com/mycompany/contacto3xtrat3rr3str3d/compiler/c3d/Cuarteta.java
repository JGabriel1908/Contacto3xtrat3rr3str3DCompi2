package com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d;


public record Cuarteta(Operador operador, String arg1, String arg2, String resultado) {

    public enum Operador {
        ASIGNACION(""),
        SUMA("+"),
        RESTA("-"),
        MULTIPLICACION("*"),
        DIVISION("/"),
        MODULO("%"),
        MENOR("<"),
        MAYOR(">"),
        MENOR_IGUAL("<="),
        MAYOR_IGUAL(">="),
        IGUAL("=="),
        DIFERENTE("!="),
        NEGATIVO("-"),
        NOT("!"),
        TRUNCAR("(int)"),
        CARGAR_STACK(""),
        GUARDAR_STACK(""),
        CARGAR_HEAP(""),
        GUARDAR_HEAP(""),
        ETIQUETA(""),
        SALTO(""),
        SI_IGUAL("=="),
        SI_DIFERENTE("!="),
        SI_MENOR("<"),
        SI_MAYOR(">"),
        SI_MENOR_IGUAL("<="),
        SI_MAYOR_IGUAL(">="),
        LLAMADA(""),
        RETORNO(""),
        IMPRIMIR_ENTERO(""),
        IMPRIMIR_CARACTER(""),
        LEER_CARACTER("");

        private final String simbolo;

        Operador(String simbolo) {
            this.simbolo = simbolo;
        }

        public String getSimbolo() {
            return simbolo;
        }
    }

    public Cuarteta reemplazar(String buscado, String valor) {
        return new Cuarteta(operador, cambiar(arg1, buscado, valor), cambiar(arg2, buscado, valor),
                cambiar(resultado, buscado, valor));
    }

    private static String cambiar(String texto, String buscado, String valor) {
        return buscado.equals(texto) ? valor : texto;
    }
}
