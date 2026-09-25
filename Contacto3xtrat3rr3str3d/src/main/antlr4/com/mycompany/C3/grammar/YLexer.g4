/*
 * Lexer del lenguaje Y?  (archivos .y)
 *
 * El lenguaje define bloques por indentación (estilo Python). El lexer produce
 * tokens NEWLINE, INDENT y DEDENT sintéticos a partir de los saltos de línea:
 *   - Las líneas en blanco o que solo contienen comentarios no generan tokens.
 *   - Dentro de (), [] y {} los saltos de línea se ignoran.
 *   - Al llegar a EOF se emite un NEWLINE final y todos los DEDENT pendientes.
 *   - Un tabulador equivale a avanzar hasta el siguiente múltiplo de 4.
 */
lexer grammar YLexer;

tokens { INDENT, DEDENT }

@header {
import java.util.ArrayDeque;
import java.util.Deque;
}

@members {
    // Tokens listos para entregarse al parser
    private final Deque<Token> pendientes = new ArrayDeque<>();
    // Niveles de indentación abiertos (el nivel 0 está implícito)
    private final Deque<Integer> indentaciones = new ArrayDeque<>();
    // Cantidad de (, [ y { sin cerrar
    private int abiertos = 0;
    // Último token del canal por defecto entregado
    private Token ultimo = null;
    private boolean finProcesado = false;

    @Override
    public void reset() {
        super.reset();
        pendientes.clear();
        indentaciones.clear();
        abiertos = 0;
        ultimo = null;
        finProcesado = false;
    }

    @Override
    public Token nextToken() {
        while (pendientes.isEmpty()) {
            procesar(super.nextToken());
        }
        return pendientes.poll();
    }

    private void procesar(Token t) {
        switch (t.getType()) {
            case PAR_IZQ:
            case COR_IZQ:
            case LLA_IZQ:
                abiertos++;
                encolar(t);
                break;
            case PAR_DER:
            case COR_DER:
            case LLA_DER:
                if (abiertos > 0) abiertos--;
                encolar(t);
                break;
            case NEWLINE:
                procesarSalto(t);
                break;
            case EOF:
                procesarFin(t);
                break;
            default:
                encolar(t);
        }
    }

    private void procesarSalto(Token t) {
        if (abiertos > 0) return;
        int sig = _input.LA(1);
        // EOF: procesarFin emite el NEWLINE y los DEDENT
        if (sig == EOF) return;
        // Línea que solo contiene un comentario: el salto que le sigue decide la indentación
        if (sig == '/' && (_input.LA(2) == '/' || _input.LA(2) == '*')) return;
        // Saltos al inicio del archivo
        if (ultimo == null) return;

        String texto = t.getText();
        int inicioLinea = texto.lastIndexOf('\n') + 1;
        int actual = 0;
        for (int i = inicioLinea; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c == '\t') actual += 4 - (actual % 4);
            else actual++;
        }

        encolar(crear(NEWLINE, "\\n", t));

        int previo = indentaciones.isEmpty() ? 0 : indentaciones.peek();
        if (actual > previo) {
            indentaciones.push(actual);
            encolar(crear(INDENT, "<INDENT>", t));
        } else {
            while (actual < previo) {
                indentaciones.pop();
                encolar(crear(DEDENT, "<DEDENT>", t));
                previo = indentaciones.isEmpty() ? 0 : indentaciones.peek();
            }
            if (actual != previo) {
                int linea = t.getLine() + (int) texto.chars().filter(c -> c == '\n').count();
                getErrorListenerDispatch().syntaxError(this, null, linea, actual,
                        "Indentación inconsistente: no coincide con ningún bloque abierto", null);
            }
        }
    }

    private void procesarFin(Token eof) {
        if (!finProcesado) {
            finProcesado = true;
            if (ultimo != null && ultimo.getType() != NEWLINE) {
                encolar(crear(NEWLINE, "\\n", eof));
            }
            while (!indentaciones.isEmpty()) {
                indentaciones.pop();
                encolar(crear(DEDENT, "<DEDENT>", eof));
            }
        }
        encolar(eof);
    }

    private void encolar(Token t) {
        pendientes.add(t);
        if (t.getChannel() == Token.DEFAULT_CHANNEL) ultimo = t;
    }

    private Token crear(int tipo, String texto, Token referencia) {
        CommonToken t = new CommonToken(referencia);
        t.setType(tipo);
        t.setText(texto);
        t.setChannel(Token.DEFAULT_CHANNEL);
        return t;
    }
}

// ---------------------------------------------------------------- comentarios y espacios
COMENTARIO_LINEA  : '//' ~[\r\n]* -> channel(HIDDEN) ;
COMENTARIO_BLOQUE : '/*' .*? '*/' -> channel(HIDDEN) ;

NEWLINE : ( '\r'? '\n' [ \t]* )+ ;
WS      : [ \t\f ​﻿]+ -> skip ;

// ---------------------------------------------------------------- secciones y definiciones
SEC_ESTRUCTURAS : '%estructuras' ;
SEC_FUNCIONES   : '%funciones' ;
ESTRUCTURA      : 'estructura' ;
DEFINIR         : 'definir' ;
RETORNAR        : 'retornar' ;

// ---------------------------------------------------------------- tipos
ENTERO   : 'entero' ;
FLOTANTE : 'flotante' ;
CADENA   : 'cadena' ;
CARACTER : 'caracter' ;
BOOL     : 'bool' ;

// ---------------------------------------------------------------- literales booleanos
VERDADERO : 'verdadero' ;
FALSO     : 'falso' ;

// ---------------------------------------------------------------- control de flujo
SI        : 'si' ;
ENTONCES  : 'entonces' ;
SINO      : 'sino' ;
CONTRARIO : 'contrario' ;
ELEGIR    : 'elegir' ;
CASO      : 'caso' ;
SIEMPRE   : 'siempre' ;
ROMPER    : 'romper' ;
CONTINUAR : 'continuar' ;
PARA      : 'para' ;
MIENTRAS  : 'mientras' ;
HACER     : 'hacer' ;

// ---------------------------------------------------------------- funciones nativas
IMPRIMIR : 'imprimir' ;
LEER     : 'leer' ;

// ---------------------------------------------------------------- operadores
INCREMENTO  : '++' ;
DECREMENTO  : '--' ;
FLECHA      : '->' ;
IGUAL_IGUAL : '==' ;
DIFERENTE   : '!=' ;
MENOR_IGUAL : '<=' ;
MAYOR_IGUAL : '>=' ;
MENOR       : '<' ;
MAYOR       : '>' ;
AND         : '&&' ;
OR          : '||' ;
NOT         : '!' ;
MAS         : '+' ;
MENOS       : '-' ;
MULT        : '*' ;
DIV         : '/' ;
MOD         : '%' ;
IGUAL       : '=' ;

// ---------------------------------------------------------------- símbolos
PAR_IZQ    : '(' ;
PAR_DER    : ')' ;
COR_IZQ    : '[' ;
COR_DER    : ']' ;
LLA_IZQ    : '{' ;
LLA_DER    : '}' ;
PUNTO      : '.' ;
COMA       : ',' ;
DOSPUNTOS  : ':' ;
PUNTO_COMA : ';' ;

// ---------------------------------------------------------------- literales e identificadores
DECIMAL_LIT  : [0-9]+ '.' [0-9]+ ;
ENTERO_LIT   : [0-9]+ ;
CADENA_LIT   : '"' ( ~["\\\r\n] | ESCAPE )* '"' ;
CARACTER_LIT : '\'' ( ~['\\\r\n] | ESCAPE ) '\'' ;
ID           : LETRA ( LETRA | [0-9] )* ;

fragment LETRA  : [a-zA-Z_áéíóúÁÉÍÓÚñÑüÜ] ;
fragment ESCAPE : '\\' [nrt"'\\0] ;

// Cualquier otro carácter es un error léxico
ERROR_CHAR : . ;
