package com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ErrorCompilacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Programa;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Unidad;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.UnidadY;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.UnidadZetariano;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoEstructura;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.TablaSimbolos;
import java.util.Comparator;
import java.util.List;

/**
 * Punto de entrada del análisis semántico. Coordina las tres pasadas; la validación de cada
 * construcción está en el método analizar(ctx) del nodo correspondiente del AST.
 *
 * Pasada 1: registra estructuras y funciones de los .y y clases de los .z (con nombres únicos).
 * Pasada 2: valida las declaraciones globales (campos, atributos, parámetros, sobrecargas).
 * Pasada 3: cada unidad analiza sus cuerpos; cada expresión calcula y anota su tipo.
 *
 * Una expresión con error recibe Tipo.ERROR, que es compatible con todo para no generar
 * errores en cascada.
 */
public final class AnalizadorSemantico {

    public record Resultado(List<ErrorCompilacion> errores, TablaSimbolos tabla) {
    }

    private AnalizadorSemantico() {
    }

    /** Analiza un Programa completo o una sola Unidad. */
    public static Resultado analizar(Nodo raiz) {
        ContextoSemantico ctx = new ContextoSemantico();
        List<Unidad> unidades = raiz instanceof Programa p ? p.getUnidades() : List.of((Unidad) raiz);

        // Pasada 1: primero los tipos (estructuras y clases), después las funciones
        for (Unidad u : unidades) if (u instanceof UnidadY y) y.registrarEstructuras(ctx);
        for (Unidad u : unidades) if (u instanceof UnidadZetariano z) z.registrar(ctx);
        for (Unidad u : unidades) if (u instanceof UnidadY y) y.registrarFunciones(ctx);

        // Pasada 2
        for (Unidad u : unidades) if (u instanceof UnidadY y) y.validarEstructuras(ctx);
        for (InfoEstructura e : ctx.getEstructurasGlobales()) e.getDefinicion().verificarCiclo(ctx, e);
        for (Unidad u : unidades) if (u instanceof UnidadY y) y.validarFunciones(ctx);
        for (Unidad u : unidades) if (u instanceof UnidadZetariano z) z.validarDeclaraciones(ctx);

        // Pasada 3
        for (Unidad u : unidades) u.analizar(ctx);

        List<ErrorCompilacion> errores = ctx.getErrores();
        errores.sort(Comparator.comparing(ErrorCompilacion::archivo)
                .thenComparingInt(ErrorCompilacion::linea)
                .thenComparingInt(ErrorCompilacion::columna));
        return new Resultado(errores, ctx.tabla());
    }
}
