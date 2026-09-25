package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones;

/** Modificador de acceso de Zetariano (el encapsulamiento se valida en el proyecto 2). */
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
