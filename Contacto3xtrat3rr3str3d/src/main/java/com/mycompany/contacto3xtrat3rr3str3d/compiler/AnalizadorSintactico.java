package com.mycompany.contacto3xtrat3rr3str3d.compiler;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ErrorCompilacion.TipoError;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Ejecuta el análisis léxico y sintáctico de un archivo y recolecta los errores.
 */
public final class AnalizadorSintactico {

    public record Resultado(ParseTree arbol, Parser parser, CommonTokenStream tokens,
                            List<ErrorCompilacion> errores) {
        public boolean exitoso() {
            return errores.isEmpty();
        }
    }

    private static final Pattern NO_COINCIDE = Pattern.compile("mismatched input (.*) expecting (.*)");
    private static final Pattern SOBRANTE = Pattern.compile("extraneous input (.*) expecting (.*)");
    private static final Pattern FALTANTE = Pattern.compile("missing (.*) at (.*)");
    private static final Pattern NO_VIABLE = Pattern.compile("no viable alternative at input (.*)");

    // Nombres de tokens que se muestran de forma más legible en los mensajes
    private static final Map<String, String> NOMBRES = Map.ofEntries(
            Map.entry("'\\\\n'", "salto de línea"),
            Map.entry("'<INDENT>'", "indentación"),
            Map.entry("'<DEDENT>'", "fin de bloque"),
            Map.entry("<EOF>", "fin de archivo"),
            Map.entry("'<EOF>'", "fin de archivo"),
            Map.entry("NEWLINE", "salto de línea"),
            Map.entry("INDENT", "indentación"),
            Map.entry("DEDENT", "fin de bloque"),
            Map.entry("ID", "identificador"),
            Map.entry("ENTERO_LIT", "entero"),
            Map.entry("DECIMAL_LIT", "decimal"),
            Map.entry("CADENA_LIT", "cadena"),
            Map.entry("CARACTER_LIT", "carácter"));

    private AnalizadorSintactico() {
    }

    public static Resultado analizar(String codigo, Lenguaje lenguaje, String archivo) {
        List<ErrorCompilacion> errores = new ArrayList<>();

        Lexer lexer = lenguaje.crearLexer(CharStreams.fromString(codigo, archivo));
        lexer.removeErrorListeners();
        lexer.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> r, Object simbolo, int linea, int columna,
                                    String mensaje, RecognitionException e) {
                errores.add(new ErrorCompilacion(TipoError.LEXICO, mensaje, archivo, linea, columna, 1));
            }
        });

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();

        int tipoError = tipoToken(lexer.getVocabulary(), "ERROR_CHAR");
        for (Token t : tokens.getTokens()) {
            if (t.getType() == tipoError) {
                errores.add(new ErrorCompilacion(TipoError.LEXICO,
                        "Símbolo no reconocido: '" + t.getText() + "'",
                        archivo, t.getLine(), t.getCharPositionInLine(), 1));
            }
        }

        Parser parser = lenguaje.crearParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> r, Object simbolo, int linea, int columna,
                                    String mensaje, RecognitionException e) {
                int longitud = 1;
                if (simbolo instanceof Token t) {
                    // El símbolo inválido ya se reportó como error léxico
                    if (t.getType() == tipoError) return;
                    String texto = t.getText();
                    if (t.getType() != Token.EOF && texto != null && !texto.startsWith("<")) {
                        longitud = Math.max(1, texto.length());
                    }
                }
                errores.add(new ErrorCompilacion(TipoError.SINTACTICO, traducir(mensaje),
                        archivo, linea, columna, longitud));
            }
        });

        ParseTree arbol = lenguaje.analizar(parser);
        errores.sort(Comparator.comparingInt(ErrorCompilacion::linea)
                .thenComparingInt(ErrorCompilacion::columna));
        return new Resultado(arbol, parser, tokens, errores);
    }

    private static int tipoToken(Vocabulary vocabulario, String nombre) {
        for (int i = 1; i <= vocabulario.getMaxTokenType(); i++) {
            if (nombre.equals(vocabulario.getSymbolicName(i))) return i;
        }
        return Integer.MIN_VALUE;
    }

    /** Traduce los mensajes estándar de ANTLR al español. */
    static String traducir(String mensaje) {
        Matcher m;
        // Pig Latin: el archivo terminó sin cerrar la sección principal
        if (mensaje.contains("<EOF>") && mensaje.contains("'FINIS'")) {
            return "Falta 'FINIS;' al final del programa para cerrar la sección MAIOR>";
        }
        if ((m = NO_COINCIDE.matcher(mensaje)).matches()) {
            return "Se encontró " + legible(m.group(1)) + " pero se esperaba " + legible(m.group(2));
        }
        if ((m = SOBRANTE.matcher(mensaje)).matches()) {
            return "Símbolo inesperado " + legible(m.group(1)) + ", se esperaba " + legible(m.group(2));
        }
        if ((m = FALTANTE.matcher(mensaje)).matches()) {
            return "Falta " + legible(m.group(1)) + " antes de " + legible(m.group(2));
        }
        if ((m = NO_VIABLE.matcher(mensaje)).matches()) {
            return "Instrucción no válida cerca de '" + m.group(1).replace("\\n", " ").strip() + "'";
        }
        return legible(mensaje);
    }

    private static String legible(String texto) {
        String resultado = texto;
        for (Map.Entry<String, String> e : NOMBRES.entrySet()) {
            resultado = resultado.replaceAll("(?<![\\w'])" + Pattern.quote(e.getKey()) + "(?![\\w'])",
                    Matcher.quoteReplacement(e.getValue()));
        }
        return resultado;
    }
}
