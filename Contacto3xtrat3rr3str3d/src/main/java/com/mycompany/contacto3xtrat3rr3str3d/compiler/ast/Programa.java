package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * Proyecto completo: el archivo .pig principal y los archivos .y / .z que importa.
 */
public class Programa extends Nodo {

    private final UnidadPigLatin principal;
    private final List<UnidadY> archivosY;
    private final List<UnidadZetariano> archivosZetariano;

    public Programa(UnidadPigLatin principal, List<UnidadY> archivosY, List<UnidadZetariano> archivosZetariano) {
        super(principal.getUbicacion());
        this.principal = principal;
        this.archivosY = List.copyOf(archivosY);
        this.archivosZetariano = List.copyOf(archivosZetariano);
    }

    /** Todas las unidades, empezando por la principal. */
    public List<Unidad> getUnidades() {
        List<Unidad> todas = new ArrayList<>();
        todas.add(principal);
        todas.addAll(archivosY);
        todas.addAll(archivosZetariano);
        return todas;
    }
}
