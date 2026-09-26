package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

public enum OperadorBinario {
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
    AND("&&"),
    OR("||");

    private final String simbolo;

    OperadorBinario(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public static OperadorBinario desdeSimbolo(String simbolo) {
        if (simbolo.equals("=")) return IGUAL;
        for (OperadorBinario op : values()) {
            if (op.simbolo.equals(simbolo)) return op;
        }
        throw new IllegalArgumentException("Operador binario desconocido: " + simbolo);
    }

    public static OperadorBinario desdeAsignacionCompuesta(String simbolo) {
        return desdeSimbolo(simbolo.substring(0, simbolo.length() - 1));
    }

    @Override
    public String toString() {
        return simbolo;
    }
}
