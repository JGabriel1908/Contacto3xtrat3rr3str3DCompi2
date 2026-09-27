package com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Programa;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Unidad;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.TablaSimbolos;
import java.util.List;
import java.util.Map;

public final class GeneradorC3D {

    private static final int TAMANO_MEMORIA = 1000000;

    private GeneradorC3D() {
    }

    public static String generar(Programa programa, TablaSimbolos tabla) {
        ContextoC3D ctx = new ContextoC3D(tabla);
        for (Unidad u : programa.getUnidades()) u.nombrar(ctx);
        for (Unidad u : programa.getUnidades()) u.generar(ctx);
        return ensamblar(ctx);
    }

    private static String ensamblar(ContextoC3D ctx) {
        StringBuilder sb = new StringBuilder();
        sb.append("/* Código de tres direcciones generado por Contacto 3xtrat3rr3str3D */\n");
        sb.append("#include <stdio.h>\n\n");
        sb.append("double stack[").append(TAMANO_MEMORIA).append("];\n");
        sb.append("double heap[").append(TAMANO_MEMORIA).append("];\n");
        sb.append("int P;\n");
        sb.append("int H;\n\n");
        declarar(sb, "t", ctx.getTemporales());
        declarar(sb, "n", Nativas.TEMPORALES);
        sb.append('\n');

        for (String nativa : ctx.getNativasUsadas()) sb.append("void ").append(nativa).append("();\n");
        for (String funcion : ctx.getFunciones().keySet()) sb.append("void ").append(funcion).append("();\n");
        sb.append('\n');

        for (String nativa : Nativas.nombres()) {
            if (ctx.getNativasUsadas().contains(nativa)) sb.append(Nativas.codigo(nativa)).append('\n');
        }
        for (Map.Entry<String, List<Cuarteta>> f : ctx.getFunciones().entrySet()) {
            sb.append(TraductorC.funcion(f.getKey(), f.getValue())).append('\n');
        }

        sb.append("int main() {\n");
        sb.append("    P = 0;\n");
        sb.append("    H = 1;\n");
        sb.append(TraductorC.cuerpo(ctx.getPrincipal()));
        sb.append("    return 0;\n");
        sb.append("}\n");
        return sb.toString();
    }

    private static void declarar(StringBuilder sb, String prefijo, int cantidad) {
        for (int inicio = 1; inicio <= cantidad; inicio += 20) {
            sb.append("double ");
            for (int i = inicio; i < Math.min(inicio + 20, cantidad + 1); i++) {
                if (i > inicio) sb.append(", ");
                sb.append(prefijo).append(i);
            }
            sb.append(";\n");
        }
    }
}
