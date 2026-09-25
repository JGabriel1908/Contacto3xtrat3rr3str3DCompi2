package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

public enum OperadorUnario {
    NEGATIVO("-"),
    POSITIVO("+"),
    NOT("!");

    private final String simbolo;

    OperadorUnario(String simbolo) {
        this.simbolo = simbolo;
    }

    public static OperadorUnario desdeSimbolo(String simbolo) {
        for (OperadorUnario op : values()) {
            if (op.simbolo.equals(simbolo)) return op;
        }
        throw new IllegalArgumentException("Operador unario desconocido: " + simbolo);
    }

    @Override
    public String toString() {
        return simbolo;
    }
}
