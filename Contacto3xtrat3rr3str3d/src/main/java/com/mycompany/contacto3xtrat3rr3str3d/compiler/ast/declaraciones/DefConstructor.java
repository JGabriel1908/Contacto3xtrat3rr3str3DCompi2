package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Bloque;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;

public class DefConstructor extends Nodo {

    private final Modificador modificador;
    private final String nombre;
    private final List<Parametro> parametros;
    private final Bloque cuerpo;

    public DefConstructor(Ubicacion ubicacion, Modificador modificador, String nombre,
                          List<Parametro> parametros, Bloque cuerpo) {
        super(ubicacion);
        this.modificador = modificador;
        this.nombre = nombre;
        this.parametros = List.copyOf(parametros);
        this.cuerpo = cuerpo;
    }

    /** Debe coincidir con el nombre de la clase (validación semántica). */
    public String getNombre() {
        return nombre;
    }

    public List<Parametro> getParametros() {
        return parametros;
    }

    /** Pasada 2: se llama como la clase, sus parámetros existen y la firma no se repite. */
    public void validarFirma(ContextoSemantico ctx, DefClase clase, List<List<Tipo>> firmasPrevias) {
        if (!nombre.equals(clase.getNombre())) {
            ctx.error(this, "'" + nombre + "' no tiene tipo de retorno; si es un constructor debe llamarse "
                    + clase.getNombre());
        }
        parametros.forEach(p -> p.validarTipo(ctx));
        List<Tipo> firma = ContextoSemantico.firma(parametros);
        String texto = clase.getNombre() + ctx.tiposTexto(firma, this);
        if (firmasPrevias.contains(firma)) ctx.error(this, "Ya existe un constructor " + texto);
        firmasPrevias.add(firma);
    }

    /** Pasada 3: analiza el cuerpo (un constructor no retorna valor). */
    public void analizar(ContextoSemantico ctx) {
        ctx.analizarFuncion(nombre + "()", parametros, Tipo.VACIO, cuerpo, this, null);
    }
}
