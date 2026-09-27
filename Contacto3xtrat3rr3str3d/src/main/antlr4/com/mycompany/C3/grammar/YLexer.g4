
lexer grammar YLexer;

tokens { INDENT, DEDENT }

@header {
import java.util.ArrayDeque;
import java.util.Deque;
}

@members {
    private final Deque<Token> pendientes = new ArrayDeque<>();
    private final Deque<Integer> indentaciones = new ArrayDeque<>();
    private int abiertos = 0;
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
        if (sig == EOF) return;
        if (sig == '/' && (_input.LA(2) == '/' || _input.LA(2) == '*')) return;
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

COMENTARIO_LINEA  : '//' ~[\r\n]* -> channel(HIDDEN) ;
COMENTARIO_BLOQUE : '/*' .*? '*/' -> channel(HIDDEN) ;

NEWLINE : ( '\r'? '\n' [ \t]* )+ ;
WS      : [ \t\f ​﻿]+ -> skip ;

SEC_ESTRUCTURAS : '%estructuras' ;
SEC_FUNCIONES   : '%funciones' ;
ESTRUCTURA      : 'estructura' ;
DEFINIR         : 'definir' ;
RETORNAR        : 'retornar' ;

ENTERO   : 'entero' ;
FLOTANTE : 'flotante' ;
CADENA   : 'cadena' ;
CARACTER : 'caracter' ;
BOOL     : 'bool' ;

VERDADERO : 'verdadero' ;
FALSO     : 'falso' ;

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

IMPRIMIR : 'imprimir' ;
LEER     : 'leer' ;

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

DECIMAL_LIT  : [0-9]+ '.' [0-9]+ ;
ENTERO_LIT   : [0-9]+ ;
CADENA_LIT   : '"' ( ~["\\\r\n] | ESCAPE )* '"' ;
CARACTER_LIT : '\'' ( ~['\\\r\n] | ESCAPE ) '\'' ;
ID           : LETRA ( LETRA | [0-9] )* ;

fragment LETRA  : [a-zA-Z_áéíóúÁÉÍÓÚñÑüÜ] ;
fragment ESCAPE : '\\' [nrt"'\\0] ;

ERROR_CHAR : . ;
