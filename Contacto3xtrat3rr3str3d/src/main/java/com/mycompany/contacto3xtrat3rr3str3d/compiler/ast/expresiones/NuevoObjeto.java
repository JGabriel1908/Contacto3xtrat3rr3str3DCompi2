package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefConstructor;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.ContextoC3D;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoClase;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.ArrayList;
import java.util.List;

public class NuevoObjeto extends Expresion {

    private final String clase;
    private final List<Expresion> argumentos;

    public NuevoObjeto(Ubicacion ubicacion, String clase, List<Expresion> argumentos) {
        super(ubicacion);
        this.clase = clase;
        this.argumentos = List.copyOf(argumentos);
    }

    public String getClase() {
        return clase;
    }

    private DefConstructor constructor;

    @Override
    public Tipo analizar(ContextoSemantico ctx) {
        List<Tipo> tipos = ctx.tiposArgumentos(argumentos);
        if (ctx.enConflicto(clase)) return resultado(Tipo.ERROR);
        InfoClase info = ctx.tabla().buscarClase(clase);
        if (info == null) {
            String mensaje = ctx.tabla().buscarEstructura(clase) != null
                    ? clase + " es una estructura: se inicializa con {...}, no con " + ctx.palabra(this, "", "new", "novus")
                    : "La clase '" + clase + "' no existe";
            ctx.error(this, mensaje);
            return resultado(Tipo.ERROR);
        }
        Tipo tipo = Tipo.clase(info.getNombre());
        if (info.getConstructores().isEmpty()) {
            // Constructor por defecto
            if (!tipos.isEmpty()) ctx.error(this, "La clase " + info.getNombre() + " no tiene un constructor con parámetros");
            return resultado(tipo);
        }
        constructor = ctx.resolverConstructor(info, tipos, this);
        return resultado(tipo);
    }

    /** Reserva los atributos en el heap, ejecuta los valores iniciales y luego el constructor elegido. */
    @Override
    public String generar(ContextoC3D ctx) {
        InfoClase info = ctx.tabla().buscarClase(clase);
        String objeto = ctx.heap(String.valueOf(Math.max(1, info.getCantidadAtributos())));
        String inicio = ctx.nombre(info.getDefinicion());
        if (inicio != null) ctx.usar(ctx.llamar(inicio, List.of(ctx.copia(objeto))));
        if (constructor != null) {
            List<String> valores = new ArrayList<>();
            valores.add(ctx.copia(objeto));
            for (Expresion a : argumentos) valores.add(a.generar(ctx));
            ctx.usar(ctx.llamar(ctx.nombre(constructor), valores));
        }
        return objeto;
    }
}
