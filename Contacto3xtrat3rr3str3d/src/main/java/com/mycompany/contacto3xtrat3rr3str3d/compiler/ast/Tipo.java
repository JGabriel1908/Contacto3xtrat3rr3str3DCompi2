package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.Lenguaje;
import java.util.Objects;


public final class Tipo {

    public enum Base {
        ENTERO("entero"),
        DECIMAL("decimal"),
        CADENA("cadena"),
        CARACTER("caracter"),
        BOOLEANO("booleano"),
        VACIO("vacio"),
        NULO("nulo"),
        ESTRUCTURA("estructura"),
        CLASE("clase"),
        NOMBRADO("nombrado"),
        ERROR("error");

        private final String nombre;

        Base(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }
    }

    public static final Tipo ENTERO = new Tipo(Base.ENTERO, null, 0);
    public static final Tipo DECIMAL = new Tipo(Base.DECIMAL, null, 0);
    public static final Tipo CADENA = new Tipo(Base.CADENA, null, 0);
    public static final Tipo CARACTER = new Tipo(Base.CARACTER, null, 0);
    public static final Tipo BOOLEANO = new Tipo(Base.BOOLEANO, null, 0);
    public static final Tipo VACIO = new Tipo(Base.VACIO, null, 0);
    public static final Tipo NULO = new Tipo(Base.NULO, null, 0);
    public static final Tipo ERROR = new Tipo(Base.ERROR, null, 0);

    private final Base base;
    private final String nombre;
    private final int dimensiones;

    private Tipo(Base base, String nombre, int dimensiones) {
        this.base = base;
        this.nombre = nombre;
        this.dimensiones = dimensiones;
    }

    public static Tipo estructura(String nombre) {
        return new Tipo(Base.ESTRUCTURA, nombre, 0);
    }

    public static Tipo clase(String nombre) {
        return new Tipo(Base.CLASE, nombre, 0);
    }

    public static Tipo nombrado(String nombre) {
        return new Tipo(Base.NOMBRADO, nombre, 0);
    }

    public Tipo arreglo(int dimensiones) {
        return dimensiones == 0 ? this : new Tipo(base, nombre, this.dimensiones + dimensiones);
    }

    public Tipo elemento() {
        if (dimensiones == 0) throw new IllegalStateException(this + " no es un arreglo");
        return new Tipo(base, nombre, dimensiones - 1);
    }

    public Tipo tipoBase() {
        return dimensiones == 0 ? this : new Tipo(base, nombre, 0);
    }

    public Tipo resolver(Base nuevaBase) {
        return new Tipo(nuevaBase, nombre, dimensiones);
    }

    public Base getBase() {
        return base;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDimensiones() {
        return dimensiones;
    }

    public boolean esArreglo() {
        return dimensiones > 0;
    }

    public boolean esPrimitivo() {
        return dimensiones == 0 && switch (base) {
            case ENTERO, DECIMAL, CADENA, CARACTER, BOOLEANO -> true;
            default -> false;
        };
    }

    public boolean esError() {
        return base == Base.ERROR;
    }

    public boolean es(Base base) {
        return dimensiones == 0 && this.base == base;
    }

    public boolean esEntero() {
        return esError() || es(Base.ENTERO) || es(Base.CARACTER);
    }

    public boolean esReferencia() {
        return esArreglo() || base == Base.ESTRUCTURA || base == Base.CLASE || base == Base.NOMBRADO;
    }

    public String nombreEn(Lenguaje lenguaje) {
        if (lenguaje == null) return toString();
        String texto = switch (base) {
            case ENTERO -> elegir(lenguaje, "entero", "int", "numerus");
            case DECIMAL -> elegir(lenguaje, "flotante", "double", "decimalis");
            case CADENA -> elegir(lenguaje, "cadena", "String", "textum");
            case CARACTER -> elegir(lenguaje, "caracter", "char", "littera");
            case BOOLEANO -> elegir(lenguaje, "bool", "boolean", "bool");
            case VACIO -> elegir(lenguaje, "vacio", "void", "vacio");
            case NULO -> "null";
            default -> nombre != null ? nombre : base.getNombre();
        };
        return texto + "[]".repeat(dimensiones);
    }

    private static String elegir(Lenguaje lenguaje, String y, String zetariano, String pigLatin) {
        return switch (lenguaje) {
            case Y -> y;
            case ZETARIANO -> zetariano;
            case PIG_LATIN -> pigLatin;
        };
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Tipo t && base == t.base && dimensiones == t.dimensiones
                && Objects.equals(nombre, t.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, nombre, dimensiones);
    }

    @Override
    public String toString() {
        String texto = nombre != null ? nombre : base.getNombre();
        return texto + "[]".repeat(dimensiones);
    }
}
