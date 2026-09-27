package com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d;

import java.util.List;


public final class TraductorC {

    private TraductorC() {
    }

    public static String funcion(String nombre, List<Cuarteta> cuartetas) {
        StringBuilder sb = new StringBuilder("void ").append(nombre).append("() {\n");
        for (Cuarteta c : cuartetas) sb.append(linea(c)).append('\n');
        boolean terminaEnRetorno = !cuartetas.isEmpty()
                && cuartetas.get(cuartetas.size() - 1).operador() == Cuarteta.Operador.RETORNO;
        if (!terminaEnRetorno) sb.append("    return;\n");
        sb.append("}\n");
        return sb.toString();
    }

    public static String cuerpo(List<Cuarteta> cuartetas) {
        StringBuilder sb = new StringBuilder();
        for (Cuarteta c : cuartetas) sb.append(linea(c)).append('\n');
        return sb.toString();
    }

    static String linea(Cuarteta c) {
        String a = c.arg1();
        String b = c.arg2();
        String r = c.resultado();
        return switch (c.operador()) {
            case ETIQUETA -> r + ":";
            case ASIGNACION -> "    " + r + " = " + a + ";";
            case SUMA, RESTA, MULTIPLICACION, DIVISION, MENOR, MAYOR, MENOR_IGUAL, MAYOR_IGUAL, IGUAL, DIFERENTE ->
                    "    " + r + " = " + a + " " + c.operador().getSimbolo() + " " + b + ";";
            case MODULO -> "    " + r + " = (int) " + a + " % (int) " + b + ";";
            case NEGATIVO -> "    " + r + " = -" + a + ";";
            case NOT -> "    " + r + " = !" + a + ";";
            case TRUNCAR -> "    " + r + " = (int) " + a + ";";
            case CARGAR_STACK -> "    " + r + " = stack[(int) " + a + "];";
            case GUARDAR_STACK -> "    stack[(int) " + r + "] = " + a + ";";
            case CARGAR_HEAP -> "    " + r + " = heap[(int) " + a + "];";
            case GUARDAR_HEAP -> "    heap[(int) " + r + "] = " + a + ";";
            case SALTO -> "    goto " + r + ";";
            case SI_IGUAL, SI_DIFERENTE, SI_MENOR, SI_MAYOR, SI_MENOR_IGUAL, SI_MAYOR_IGUAL ->
                    "    if (" + a + " " + c.operador().getSimbolo() + " " + b + ") goto " + r + ";";
            case LLAMADA -> "    " + a + "();";
            case RETORNO -> "    return;";
            case IMPRIMIR_ENTERO -> "    printf(\"%d\", (int) " + a + ");";
            case IMPRIMIR_CARACTER -> "    printf(\"%c\", (int) " + a + ");";
            case LEER_CARACTER -> "    " + r + " = getchar();";
        };
    }
}
