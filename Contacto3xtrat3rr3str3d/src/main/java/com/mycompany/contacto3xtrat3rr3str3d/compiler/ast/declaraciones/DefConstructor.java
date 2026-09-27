package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Bloque;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
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

    public String getNombre() { //coincidir con el de la clase
        return nombre;
    }

    public List<Parametro> getParametros() {
        return parametros;
    }

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

    public void analizar(ContextoSemantico ctx) {
        ctx.analizarFuncion(nombre + "()", parametros, Tipo.VACIO, cuerpo, this, null);
    }

    /** Marco: [0] retorno, [1] this, luego parámetros y variables locales. */
    public void generar(ContextoC3D ctx) {
        ctx.iniciarFuncion(2);
        parametros.forEach(p -> p.asignarDesplazamiento(ctx));
        cuerpo.getInstrucciones().forEach(ctx::generar);
        ctx.terminarFuncion(ctx.nombre(this));
    }
}
