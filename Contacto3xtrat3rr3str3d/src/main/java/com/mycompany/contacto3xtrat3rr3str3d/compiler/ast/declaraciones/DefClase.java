package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoClase;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.TablaSimbolos;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

//clase para el zetariano
public class DefClase extends Nodo {

    private final Modificador modificador;
    private final String nombre;
    private final List<Atributo> atributos;
    private final List<DefConstructor> constructores;
    private final List<DefMetodo> metodos;

    public DefClase(Ubicacion ubicacion, Modificador modificador, String nombre, List<Atributo> atributos,
                    List<DefConstructor> constructores, List<DefMetodo> metodos) {
        super(ubicacion);
        this.modificador = modificador;
        this.nombre = nombre;
        this.atributos = List.copyOf(atributos);
        this.constructores = List.copyOf(constructores);
        this.metodos = List.copyOf(metodos);
    }

    public String getNombre() {
        return nombre;
    }

    public List<DefConstructor> getConstructores() {
        return constructores;
    }

    public List<DefMetodo> getMetodos() {
        return metodos;
    }

    public void registrar(ContextoSemantico ctx, String archivo) {
        String nombreArchivo = new File(archivo).getName();
        String esperado = nombreArchivo.substring(0, nombreArchivo.lastIndexOf('.'));
        if (!esperado.equals(nombre)) {
            ctx.error(this, "La clase '" + nombre + "' debe estar en un archivo llamado " + nombre + ".z (está en "
                    + nombreArchivo + ")");
        }
        TablaSimbolos tabla = ctx.tabla();
        if (tabla.buscarClase(nombre) != null) {
            ctx.error(this, "Ya existe una clase llamada '" + nombre + "'");
            return;
        }
        if (tabla.buscarEstructura(nombre) != null) {
            ctx.error(this, "El nombre '" + nombre + "' ya está en uso por una estructura");
            ctx.marcarConflicto(nombre);
            return;
        }
        tabla.registrarClase(new InfoClase(this));
    }

    private InfoClase info(ContextoSemantico ctx) {
        InfoClase info = ctx.tabla().buscarClase(nombre);
        return info != null && info.getDefinicion() == this ? info : null;
    }

    public void validarMiembros(ContextoSemantico ctx) {
        InfoClase info = info(ctx);
        if (info == null) return;
        ctx.tabla().abrir(nombre);
        atributos.forEach(a -> a.validar(ctx, info));
        List<List<Tipo>> firmas = new ArrayList<>();
        constructores.forEach(k -> k.validarFirma(ctx, this, firmas));
        metodos.forEach(m -> m.validarFirma(ctx, info));
        ctx.tabla().cerrar();
    }

    public void analizar(ContextoSemantico ctx) {
        InfoClase info = info(ctx);
        if (info == null) return;
        ctx.setClaseActual(info);
        ctx.tabla().abrir(nombre);
        atributos.forEach(a -> a.analizar(ctx));
        constructores.forEach(k -> k.analizar(ctx));
        metodos.forEach(m -> m.analizar(ctx));
        ctx.tabla().cerrar();
        ctx.setClaseActual(null);
    }
}
