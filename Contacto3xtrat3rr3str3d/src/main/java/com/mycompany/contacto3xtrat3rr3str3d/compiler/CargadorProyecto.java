package com.mycompany.contacto3xtrat3rr3str3d.compiler;

import com.mycompany.C3.grammar.PigLatinParser;
import com.mycompany.C3.grammar.YParser;
import com.mycompany.C3.grammar.ZetarianoParser;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ErrorCompilacion.TipoError;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Programa;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Unidad;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.UnidadPigLatin;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.UnidadY;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.UnidadZetariano;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.Import;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.constructores.ConstructorAstPigLatin;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.constructores.ConstructorAstY;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.constructores.ConstructorAstZetariano;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.constructores.ContextoConstruccion;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class CargadorProyecto {

    @FunctionalInterface
    public interface LectorArchivos {
        String leer(File archivo) throws IOException;
    }

    public record Resultado(Nodo raiz, List<ErrorCompilacion> errores) {
        public boolean exitoso() {
            return raiz != null && errores.isEmpty();
        }
    }

    private CargadorProyecto() {
    }

    public static Resultado cargarArchivo(File archivo, LectorArchivos lector) {
        List<ErrorCompilacion> errores = new ArrayList<>();
        Unidad unidad = construirUnidad(archivo, lector, errores);
        return new Resultado(unidad, errores);
    }

    public static Resultado cargarProyecto(File principal, LectorArchivos lector) {
        List<ErrorCompilacion> errores = new ArrayList<>();
        Unidad unidad = construirUnidad(principal, lector, errores);
        if (!(unidad instanceof UnidadPigLatin pig)) {
            if (unidad != null) {
                errores.add(new ErrorCompilacion(TipoError.SEMANTICO,
                        "El archivo principal debe ser un archivo .pig", principal.getPath(), 1, 0, 1));
            }
            return new Resultado(unidad, errores);
        }

        List<UnidadY> archivosY = new ArrayList<>();
        List<UnidadZetariano> archivosZ = new ArrayList<>();
        Set<Path> cargados = new HashSet<>();
        Path carpeta = principal.getAbsoluteFile().getParentFile().toPath();

        for (Import imp : pig.getImports()) {
            Lenguaje destino = imp.getLenguajeDestino();
            if (destino == null || destino == Lenguaje.PIG_LATIN) {
                errores.add(errorEn(imp, "Solo se pueden importar archivos .y o .z: " + imp.getRuta()));
                continue;
            }
            Path ruta = carpeta.resolve(imp.getRuta()).normalize();
            if (!cargados.add(ruta)) {
                errores.add(errorEn(imp, "El archivo " + imp.getRuta() + " ya fue importado"));
                continue;
            }
            File archivo = ruta.toFile();
            if (!archivo.isFile()) {
                errores.add(errorEn(imp, "No se encontró el archivo importado: " + imp.getRuta()));
                continue;
            }
            switch (construirUnidad(archivo, lector, errores)) {
                case UnidadY y -> archivosY.add(y);
                case UnidadZetariano z -> archivosZ.add(z);
                case null, default -> {
                }
            }
        }
        return new Resultado(new Programa(pig, archivosY, archivosZ), errores);
    }

    private static ErrorCompilacion errorEn(Import imp, String mensaje) {
        return new ErrorCompilacion(TipoError.SEMANTICO, mensaje, imp.getUbicacion().archivo(),
                imp.getUbicacion().linea(), imp.getUbicacion().columna(), "import".length());
    }

    private static Unidad construirUnidad(File archivo, LectorArchivos lector, List<ErrorCompilacion> errores) {
        String ruta = archivo.getPath();
        Lenguaje lenguaje = Lenguaje.desdeArchivo(archivo);
        if (lenguaje == null) {
            errores.add(new ErrorCompilacion(TipoError.SEMANTICO,
                    "Extensión no reconocida (se esperaba .pig, .y o .z): " + archivo.getName(), ruta, 1, 0, 1));
            return null;
        }
        String codigo;
        try {
            codigo = lector.leer(archivo);
        } catch (IOException e) {
            errores.add(new ErrorCompilacion(TipoError.SEMANTICO,
                    "No se pudo leer " + archivo.getName() + ": " + e.getMessage(), ruta, 1, 0, 1));
            return null;
        }

        AnalizadorSintactico.Resultado analisis = AnalizadorSintactico.analizar(codigo, lenguaje, ruta);
        errores.addAll(analisis.errores());
        if (!analisis.exitoso()) return null;

        ContextoConstruccion ctx = new ContextoConstruccion(ruta, lenguaje, errores);
        return switch (lenguaje) {
            case Y -> new ConstructorAstY(ctx).construir((YParser.ProgramaContext) analisis.arbol());
            case ZETARIANO -> new ConstructorAstZetariano(ctx).construir((ZetarianoParser.ProgramaContext) analisis.arbol());
            case PIG_LATIN -> new ConstructorAstPigLatin(ctx).construir((PigLatinParser.ProgramaContext) analisis.arbol());
        };
    }
}
