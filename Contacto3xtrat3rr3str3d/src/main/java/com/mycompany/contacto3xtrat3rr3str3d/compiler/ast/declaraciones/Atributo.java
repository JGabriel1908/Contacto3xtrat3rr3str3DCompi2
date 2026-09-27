package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.InicializadorLista;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.Cuarteta.Operador;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.Direccion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoClase;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.Simbolo.Categoria;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.Simbolo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;

//Atributo para xetariano
public class Atributo extends Nodo {

    private final Modificador modificador;
    private final Tipo tipo;
    private final String nombre;
    private final Expresion valorInicial;
    private Simbolo simbolo;

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

    public void validar(ContextoSemantico ctx, InfoClase clase) {
        Tipo resuelto = ctx.resolverTipo(tipo, this, true);
        Simbolo s = new Simbolo(nombre, Categoria.ATRIBUTO, resuelto, this);
        simbolo = s;
        s.setDesplazamiento(clase.getCantidadAtributos());
        if (!clase.agregarAtributo(s)) {
            ctx.error(this, "El atributo '" + nombre + "' ya fue declarado en la clase " + clase.getNombre());
        }
    }

    /** Pasada 3: el valor inicial debe ser compatible con el tipo. */
    public void analizar(ContextoSemantico ctx) {
        if (valorInicial != null) ctx.verificarValor(ctx.resolverTipo(tipo, this, false), valorInicial, List.of());
    }

    public boolean tieneValorInicial() {
        return valorInicial != null;
    }

    /** heap[this + desplazamiento] = valor inicial */
    public void generar(ContextoC3D ctx) {
        if (valorInicial == null) return;
        Tipo t = simbolo.getTipo();
        String valor = valorInicial instanceof InicializadorLista lista
                ? ctx.crearDesdeLista(t, lista, List.of())
                : valorInicial.generar(ctx);
        String posicion = ctx.operar(Operador.SUMA, ctx.este(), String.valueOf(simbolo.getDesplazamiento()));
        ctx.guardar(Direccion.HEAP, posicion, valor);
        ctx.finInstruccion();
    }
}
