package com.mycompany.contacto3xtrat3rr3str3d.compiler;

import com.mycompany.C3.grammar.PigLatinLexer;
import com.mycompany.C3.grammar.PigLatinParser;
import com.mycompany.C3.grammar.YLexer;
import com.mycompany.C3.grammar.YParser;
import com.mycompany.C3.grammar.ZetarianoLexer;
import com.mycompany.C3.grammar.ZetarianoParser;
import java.io.File;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Lenguajes soportados por el compilador, identificados por la extensión del archivo.
 */
public enum Lenguaje {
    Y("Y?", "y"),
    ZETARIANO("Zetariano", "z"),
    PIG_LATIN("Pig Latin", "pig");

    private final String nombre;
    private final String extension;

    Lenguaje(String nombre, String extension) {
        this.nombre = nombre;
        this.extension = extension;
    }

    public String getNombre() {
        return nombre;
    }

    /** Devuelve el lenguaje según la extensión, o null si no es un archivo del proyecto. */
    public static Lenguaje desdeArchivo(File archivo) {
        return archivo == null ? null : desdeNombre(archivo.getName());
    }

    public static Lenguaje desdeNombre(String nombre) {
        int punto = nombre.lastIndexOf('.');
        if (punto < 0) return null;
        String ext = nombre.substring(punto + 1);
        for (Lenguaje l : values()) {
            if (l.extension.equals(ext)) return l;
        }
        return null;
    }

    public Lexer crearLexer(CharStream entrada) {
        return switch (this) {
            case Y -> new YLexer(entrada);
            case ZETARIANO -> new ZetarianoLexer(entrada);
            case PIG_LATIN -> new PigLatinLexer(entrada);
        };
    }

    public Parser crearParser(TokenStream tokens) {
        return switch (this) {
            case Y -> new YParser(tokens);
            case ZETARIANO -> new ZetarianoParser(tokens);
            case PIG_LATIN -> new PigLatinParser(tokens);
        };
    }

    /** Ejecuta la regla inicial del parser. */
    public ParseTree analizar(Parser parser) {
        return switch (this) {
            case Y -> ((YParser) parser).programa();
            case ZETARIANO -> ((ZetarianoParser) parser).programa();
            case PIG_LATIN -> ((PigLatinParser) parser).programa();
        };
    }

    /** Contenido inicial para un archivo nuevo de este lenguaje. */
    public String plantilla(String nombreBase) {
        return switch (this) {
            case Y -> "%funciones\n";
            case ZETARIANO -> "public class " + nombreBase + " {\n\n}\n";
            case PIG_LATIN -> "VARIABILES>\n\nMAIOR>\n\nFINIS;\n";
        };
    }
}
