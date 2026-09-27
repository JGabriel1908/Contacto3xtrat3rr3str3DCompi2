package com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;

/**
 * Entrada de la tabla de símbolos.
 */
public class Simbolo {

    public enum Categoria {
        VARIABLE("Variable"),
        PARAMETRO("Parámetro"),
        ATRIBUTO("Atributo"),
        CAMPO("Campo"),
        FUNCION("Función"),
        METODO("Método"),
        CONSTRUCTOR("Constructor"),
        ESTRUCTURA("Estructura"),
        CLASE("Clase");

        private final String nombre;

        Categoria(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }

    private final String nombre;
    private final Categoria categoria;
    private final Tipo tipo;
    private final Nodo declaracion;
    private int desplazamiento;

    public Simbolo(String nombre, Categoria categoria, Tipo tipo, Nodo declaracion) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.tipo = tipo;
        this.declaracion = declaracion;
    }

    public String getNombre() {
        return nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    /** Nodo que declara el símbolo (DeclaracionVariable, Parametro, Atributo, Campo, DefFuncion...). */
    public Nodo getDeclaracion() {
        return declaracion;
    }

    /** Posición en el marco de la función (variables y parámetros) o en el objeto (atributos). */
    public int getDesplazamiento() {
        return desplazamiento;
    }

    public void setDesplazamiento(int desplazamiento) {
        this.desplazamiento = desplazamiento;
    }

    public Ubicacion getUbicacion() {
        return declaracion.getUbicacion();
    }

    /** Variables, parámetros y atributos: símbolos que guardan un valor. */
    public boolean esValor() {
        return categoria == Categoria.VARIABLE || categoria == Categoria.PARAMETRO
                || categoria == Categoria.ATRIBUTO || categoria == Categoria.CAMPO;
    }
}
