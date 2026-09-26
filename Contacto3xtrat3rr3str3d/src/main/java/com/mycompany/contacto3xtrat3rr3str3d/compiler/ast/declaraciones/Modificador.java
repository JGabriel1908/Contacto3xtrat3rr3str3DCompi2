package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones;

//Modificador para el zetariano
public enum Modificador {
    PUBLICO("public"),
    PRIVADO("private"),
    PROTEGIDO("protected"),
    NINGUNO("");

    private final String palabra;

    Modificador(String palabra) {
        this.palabra = palabra;
    }

    @Override
    public String toString() {
        return palabra;
    }
}
