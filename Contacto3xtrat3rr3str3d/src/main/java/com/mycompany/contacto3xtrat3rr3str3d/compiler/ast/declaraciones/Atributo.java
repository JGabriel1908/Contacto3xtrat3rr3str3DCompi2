package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoClase;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.Simbolo.Categoria;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.Simbolo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;

/** Atributo de una clase de Zetariano. */
public class Atributo extends Nodo {

    private final Modificador modificador;
    private final Tipo tipo;
    private final String nombre;
    private final Expresion valorInicial;

    public Atributo(Ubicacion ubicacion, Modificador modificador, Tipo tipo, String nombre, Expresion valorInicial) {
        super(ubicacion);
        this.modificador = modificador;
        this.tipo = tipo;
        this.nombre = nombre;
        this.valorInicial = valorInicial;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    /** Pasada 2: resuelve el tipo y lo agrega a la clase (sin repetir nombres). */
    public void validar(ContextoSemantico ctx, InfoClase clase) {
        Tipo resuelto = ctx.resolverTipo(tipo, this, true);
        Simbolo s = new Simbolo(nombre, Categoria.ATRIBUTO, resuelto, this);
        if (!clase.agregarAtributo(s)) {
            ctx.error(this, "El atributo '" + nombre + "' ya fue declarado en la clase " + clase.getNombre());
        }
    }

    /** Pasada 3: el valor inicial debe ser compatible con el tipo. */
    public void analizar(ContextoSemantico ctx) {
        if (valorInicial != null) ctx.verificarValor(ctx.resolverTipo(tipo, this, false), valorInicial, List.of());
    }
}
