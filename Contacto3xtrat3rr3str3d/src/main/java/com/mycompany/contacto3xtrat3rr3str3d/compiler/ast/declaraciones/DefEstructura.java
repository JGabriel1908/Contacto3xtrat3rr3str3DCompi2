package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Instruccion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoEstructura;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.Simbolo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.TablaSimbolos;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Definición de estructura (Y?). Es una instrucción porque también puede
 * declararse dentro de una función.
 */
public class DefEstructura extends Instruccion {

    private final String nombre;
    private final List<Campo> campos;

    public DefEstructura(Ubicacion ubicacion, String nombre, List<Campo> campos) {
        super(ubicacion);
        this.nombre = nombre;
        this.campos = List.copyOf(campos);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Campo> getCampos() {
        return campos;
    }

    /** Pasada 1: registra la estructura en el ámbito actual; null si el nombre ya está ocupado. */
    public InfoEstructura registrar(ContextoSemantico ctx) {
        TablaSimbolos tabla = ctx.tabla();
        if (tabla.buscarEstructura(nombre) != null) {
            ctx.error(this, "Ya existe una estructura llamada '" + nombre + "'");
            return null;
        }
        if (tabla.buscarClase(nombre) != null) {
            ctx.error(this, "El nombre '" + nombre + "' ya está en uso por una clase");
            ctx.marcarConflicto(nombre);
            return null;
        }
        InfoEstructura info = new InfoEstructura(this);
        tabla.declararEstructura(info);
        return info;
    }

    /** Pasada 2: valida cada campo y lo agrega a la estructura. */
    public void validarCampos(ContextoSemantico ctx, InfoEstructura info) {
        campos.forEach(c -> c.validar(ctx, info));
    }

    /** Una estructura no puede contenerse a sí misma (directa o indirectamente): su tamaño sería infinito. */
    public void verificarCiclo(ContextoSemantico ctx, InfoEstructura info) {
        if (contiene(ctx, info, nombre, new HashSet<>())) {
            ctx.error(this, "La estructura '" + nombre + "' se contiene a sí misma");
        }
    }

    private static boolean contiene(ContextoSemantico ctx, InfoEstructura actual, String buscado, Set<String> visitadas) {
        if (!visitadas.add(actual.getNombre())) return false;
        for (Simbolo campo : actual.getCampos().values()) {
            Tipo t = campo.getTipo();
            if (t.getBase() != Tipo.Base.ESTRUCTURA) continue;
            if (t.getNombre().equals(buscado)) return true;
            InfoEstructura siguiente = ctx.tabla().buscarEstructura(t.getNombre());
            if (siguiente != null && contiene(ctx, siguiente, buscado, visitadas)) return true;
        }
        return false;
    }

    /** Estructura declarada dentro de una función (Y?): se registra y valida en el ámbito actual. */
    @Override
    public void analizar(ContextoSemantico ctx) {
        InfoEstructura info = registrar(ctx);
        if (info != null) {
            validarCampos(ctx, info);
            verificarCiclo(ctx, info);
        }
    }
}
