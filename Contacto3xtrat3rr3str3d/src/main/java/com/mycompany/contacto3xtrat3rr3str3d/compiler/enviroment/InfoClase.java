package com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefClase;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefConstructor;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefMetodo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase registrada: atributos, constructores y métodos (agrupados por nombre por la sobrecarga).
 * Los modificadores se conservan en las definiciones para validar el encapsulamiento en el proyecto 2.
 */
public class InfoClase {

    private final DefClase definicion;
    private final Map<String, Simbolo> atributos = new LinkedHashMap<>();
    private final Map<String, List<DefMetodo>> metodos = new LinkedHashMap<>();

    public InfoClase(DefClase definicion) {
        this.definicion = definicion;
    }

    public String getNombre() {
        return definicion.getNombre();
    }

    public DefClase getDefinicion() {
        return definicion;
    }

    public Simbolo getAtributo(String nombre) {
        return atributos.get(nombre);
    }

    public boolean agregarAtributo(Simbolo atributo) {
        return atributos.putIfAbsent(atributo.getNombre(), atributo) == null;
    }

    public List<DefConstructor> getConstructores() {
        return definicion.getConstructores();
    }

    public List<DefMetodo> getMetodos(String nombre) {
        return metodos.getOrDefault(nombre, List.of());
    }

    public void agregarMetodo(DefMetodo metodo) {
        metodos.computeIfAbsent(metodo.getNombre(), k -> new ArrayList<>()).add(metodo);
    }
}
