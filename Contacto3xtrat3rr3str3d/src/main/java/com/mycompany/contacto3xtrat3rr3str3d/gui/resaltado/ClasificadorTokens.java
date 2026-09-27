package com.mycompany.contacto3xtrat3rr3str3d.gui.resaltado;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.Lenguaje;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Vocabulary;


public final class ClasificadorTokens {

    private static final Set<String> TIPOS = Set.of(
            "ENTERO", "FLOTANTE", "CADENA", "CARACTER", "BOOL",
            "INT", "DOUBLE", "CHAR", "BOOLEAN", "STRING", "VOID",
            "NUMERUS", "TEXTUM", "DECIMALIS", "LITTERA");

    private static final Set<String> FUNCIONES = Set.of(
            "IMPRIMIR", "LEER", "PRINTLN", "PRINT", "READLN");

    private static final Set<String> CONSTANTES = Set.of(
            "VERDADERO", "FALSO", "TRUE", "FALSE", "NULL", "VERUM", "FALSUS", "THIS");

    private static final Map<Lenguaje, Categoria[]> CACHE = new EnumMap<>(Lenguaje.class);

    private ClasificadorTokens() {
    }

    public static synchronized Categoria[] categorias(Lenguaje lenguaje) {
        return CACHE.computeIfAbsent(lenguaje, ClasificadorTokens::construir);
    }

    private static Categoria[] construir(Lenguaje lenguaje) {
        Vocabulary v = lenguaje.crearLexer(CharStreams.fromString("")).getVocabulary();
        Categoria[] resultado = new Categoria[v.getMaxTokenType() + 1];
        for (int tipo = 0; tipo < resultado.length; tipo++) {
            resultado[tipo] = clasificar(v.getSymbolicName(tipo), v.getLiteralName(tipo));
        }
        return resultado;
    }

    private static Categoria clasificar(String nombre, String literal) {
        if (nombre == null) return Categoria.NORMAL;
        if (TIPOS.contains(nombre)) return Categoria.TIPO;
        if (FUNCIONES.contains(nombre)) return Categoria.FUNCION_NATIVA;
        if (CONSTANTES.contains(nombre)) return Categoria.CONSTANTE;
        if (nombre.startsWith("SEC_") || nombre.equals("FIN_PROGRAMA") || nombre.equals("IMPORT")) {
            return Categoria.SECCION;
        }
        if (nombre.startsWith("COMENTARIO")) return Categoria.COMENTARIO;
        if (nombre.equals("CADENA_LIT") || nombre.equals("CARACTER_LIT")) return Categoria.CADENA;
        if (nombre.equals("ENTERO_LIT") || nombre.equals("DECIMAL_LIT")) return Categoria.NUMERO;
        if (nombre.equals("ERROR_CHAR")) return Categoria.ERROR;
        if (nombre.equals("ID")) return Categoria.IDENTIFICADOR;
        if (literal != null && literal.length() > 2) {
            return Character.isLetter(literal.charAt(1)) ? Categoria.PALABRA_RESERVADA : Categoria.OPERADOR;
        }
        return Categoria.NORMAL; 
    }
}
