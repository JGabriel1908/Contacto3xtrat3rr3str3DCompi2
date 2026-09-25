package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;

/** {a, b, {c, d}}: valores de un arreglo o de los campos de una estructura, en orden. */
public class InicializadorLista extends Expresion {

    private final List<Expresion> elementos;

    public InicializadorLista(Ubicacion ubicacion, List<Expresion> elementos) {
        super(ubicacion);
        this.elementos = List.copyOf(elementos);
    }

    public List<Expresion> getElementos() {
        return elementos;
    }

    /** Las listas se validan contra su destino en ContextoSemantico.verificarValor; aquí están fuera de lugar. */
    @Override
    public Tipo analizar(ContextoSemantico ctx) {
        ctx.error(this, "Una lista {...} solo puede usarse para inicializar un arreglo o una estructura");
        return resultado(Tipo.ERROR);
    }
}
