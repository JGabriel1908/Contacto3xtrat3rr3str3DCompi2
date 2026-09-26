package com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.Lenguaje;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.OperadorBinario;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.OperadorUnario;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public final class TablaCompatibilidad {

    private static final Map<Lenguaje, TablaCompatibilidad> TABLAS = new EnumMap<>(Lenguaje.class);
    private static final List<Tipo> PRIMITIVOS = List.of(Tipo.CARACTER, Tipo.ENTERO, Tipo.DECIMAL, Tipo.CADENA, Tipo.BOOLEANO);

    static {
        for (Lenguaje l : Lenguaje.values()) TABLAS.put(l, new TablaCompatibilidad(l));
    }

    private final Lenguaje lenguaje;

    private TablaCompatibilidad(Lenguaje lenguaje) {
        this.lenguaje = lenguaje;
    }

    public static TablaCompatibilidad para(Lenguaje lenguaje) {
        return TABLAS.get(lenguaje);
    }

    public Lenguaje getLenguaje() {
        return lenguaje;
    }

    public String nombre(Tipo tipo) {
        return tipo.nombreEn(lenguaje);
    }

    /** Posición en la jerarquía numérica; 0 si el tipo no es numérico. */
    public static int rango(Tipo t) {
        if (t.esArreglo()) return 0;
        return switch (t.getBase()) {
            case CARACTER -> 1;
            case ENTERO -> 2;
            case DECIMAL -> 3;
            default -> 0;
        };
    }

    private static Tipo tipoDeRango(int rango) {
        return switch (rango) {
            case 1 -> Tipo.CARACTER;
            case 2 -> Tipo.ENTERO;
            default -> Tipo.DECIMAL;
        };
    }

    private static boolean esError(Tipo t) {
        return t.getBase() == Tipo.Base.ERROR;
    }

    private static boolean es(Tipo t, Tipo.Base base) {
        return !t.esArreglo() && t.getBase() == base;
    }


    public boolean asignable(Tipo destino, Tipo origen) {
        if (esError(destino) || esError(origen)) return true;
        if (destino.equals(origen)) return true;
        if (origen.getBase() == Tipo.Base.NULO) return lenguaje == Lenguaje.ZETARIANO && aceptaNulo(destino);
        int rd = rango(destino);
        int ro = rango(origen);
        return rd > 0 && ro > 0 && ro <= rd;
    }

    public Tipo binaria(OperadorBinario op, Tipo a, Tipo b) {
        if (esError(a) || esError(b)) return Tipo.ERROR;
        int ra = rango(a);
        int rb = rango(b);
        return switch (op) {
            case SUMA -> {
                if ((es(a, Tipo.Base.CADENA) && b.esPrimitivo()) || (es(b, Tipo.Base.CADENA) && a.esPrimitivo())) {
                    yield Tipo.CADENA;
                }
                yield aritmetica(ra, rb);
            }
            case RESTA, MULTIPLICACION, DIVISION -> aritmetica(ra, rb);
            case MODULO -> ra > 0 && ra <= 2 && rb > 0 && rb <= 2 ? Tipo.ENTERO : null;
            case MENOR, MAYOR, MENOR_IGUAL, MAYOR_IGUAL -> ra > 0 && rb > 0 ? Tipo.BOOLEANO : null;
            case IGUAL, DIFERENTE -> comparables(a, b) ? Tipo.BOOLEANO : null;
            case AND, OR -> es(a, Tipo.Base.BOOLEANO) && es(b, Tipo.Base.BOOLEANO) ? Tipo.BOOLEANO : null;
        };
    }

    private static Tipo aritmetica(int ra, int rb) {
        if (ra == 0 || rb == 0) return null;
        return tipoDeRango(Math.max(2, Math.max(ra, rb)));
    }

    private boolean comparables(Tipo a, Tipo b) {
        if (rango(a) > 0 && rango(b) > 0) return true;
        if (a.equals(b) && (a.esPrimitivo() || lenguaje == Lenguaje.ZETARIANO && a.esReferencia())) return true;
        if (lenguaje != Lenguaje.ZETARIANO) return false;
        boolean nuloA = a.getBase() == Tipo.Base.NULO;
        boolean nuloB = b.getBase() == Tipo.Base.NULO;
        return (nuloA && (nuloB || aceptaNulo(b))) || (nuloB && aceptaNulo(a));
    }

    private static boolean aceptaNulo(Tipo t) {
        return t.esReferencia() || es(t, Tipo.Base.CADENA);
    }


    public Tipo unaria(OperadorUnario op, Tipo t) {
        if (esError(t)) return Tipo.ERROR;
        return switch (op) {
            case NEGATIVO, POSITIVO -> rango(t) > 0 ? tipoDeRango(Math.max(2, rango(t))) : null;
            case NOT -> es(t, Tipo.Base.BOOLEANO) ? Tipo.BOOLEANO : null;
        };
    }

    public String documentar() {
        StringBuilder sb = new StringBuilder();
        sb.append("## Tabla de compatibilidad de tipos — ").append(lenguaje.getNombre()).append("\n\n");
        sb.append("Jerarquía: ").append(nombre(Tipo.CARACTER)).append(" → ").append(nombre(Tipo.ENTERO))
                .append(" → ").append(nombre(Tipo.DECIMAL)).append("\n\n");
        tablaOperador(sb, "Suma (+)", OperadorBinario.SUMA);
        tablaOperador(sb, "Resta, multiplicación y división (- * /)", OperadorBinario.RESTA);
        tablaOperador(sb, "Módulo (%)", OperadorBinario.MODULO);
        tablaOperador(sb, "Relacionales (< > <= >=)", OperadorBinario.MENOR);
        tablaOperador(sb, "Igualdad (== !=)", OperadorBinario.IGUAL);
        tablaOperador(sb, "Lógicos (&& ||)", OperadorBinario.AND);

        sb.append("### Asignación (fila = destino, columna = valor)\n\n");
        encabezado(sb);
        for (Tipo destino : PRIMITIVOS) {
            sb.append("| **").append(nombre(destino)).append("** |");
            for (Tipo origen : PRIMITIVOS) sb.append(' ').append(asignable(destino, origen) ? "✓" : "✗").append(" |");
            sb.append('\n');
        }
        sb.append('\n');
        return sb.toString();
    }

    private void tablaOperador(StringBuilder sb, String titulo, OperadorBinario op) {
        sb.append("### ").append(titulo).append("\n\n");
        encabezado(sb);
        for (Tipo a : PRIMITIVOS) {
            sb.append("| **").append(nombre(a)).append("** |");
            for (Tipo b : PRIMITIVOS) {
                Tipo r = binaria(op, a, b);
                sb.append(' ').append(r == null ? "error" : nombre(r)).append(" |");
            }
            sb.append('\n');
        }
        sb.append('\n');
    }

    private void encabezado(StringBuilder sb) {
        sb.append("|  |");
        for (Tipo t : PRIMITIVOS) sb.append(' ').append(nombre(t)).append(" |");
        sb.append("\n|---|");
        sb.append("---|".repeat(PRIMITIVOS.size())).append('\n');
    }
}
