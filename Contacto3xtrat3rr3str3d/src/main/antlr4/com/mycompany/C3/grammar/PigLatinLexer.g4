/*
 * Lexer del lenguaje Pig Latin  (archivos .pig)
 * Punto de entrada del programa: importa estructuras/funciones (.y) y clases (.z).
 */
lexer grammar PigLatinLexer;

// ---------------------------------------------------------------- comentarios y espacios
COMENTARIO_BLOQUE : '##' .*? '##' -> channel(HIDDEN) ;
COMENTARIO_LINEA  : '//' ~[\r\n]* -> channel(HIDDEN) ;
WS                : [ \t\r\n\f ​﻿]+ -> skip ;

// ---------------------------------------------------------------- secciones
IMPORT        : 'import' ;
SEC_VARIABLES : 'VARIABILES' [ \t]* '>' ;
SEC_PRINCIPAL : 'MAIOR' [ \t]* '>' ;
FIN_PROGRAMA  : 'FINIS' ;

// ---------------------------------------------------------------- declaraciones y tipos
ESTO      : 'esto' ;
SERIES    : 'series' ;
NUMERUS   : 'numerus' ;
TEXTUM    : 'textum' ;
DECIMALIS : 'decimalis' ;
LITTERA   : 'littera' ;
BOOL      : 'bool' ;
NOVUS     : 'novus' ;

// ---------------------------------------------------------------- literales booleanos
VERUM  : 'verum' ;
FALSUS : 'falsus' ;

// ---------------------------------------------------------------- control de flujo
SI         : 'si' ;
ALITER     : 'aliter' ;
FINIS      : 'finis' ;
DUM        : 'dum' ;
FACERE     : 'facere' ;
PER        : 'per' ;
PERGE      : 'perge' ;
INTERRUMPE : 'interrumpe' ;

// ---------------------------------------------------------------- entrada / salida
IMPRIMIR : '>>' ;
LEER     : '<<' ;

// ---------------------------------------------------------------- operadores
INCREMENTO  : '++' ;
DECREMENTO  : '--' ;
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
// También se aceptan comillas tipográficas “ ” (aparecen al copiar desde documentos)
CADENA_LIT   : '"' ( ~["\\\r\n] | ESCAPE )* '"'
             | '“' ~[”\r\n]* '”'
             ;
CARACTER_LIT : '\'' ( ~['\\\r\n] | ESCAPE ) '\'' ;
ID           : LETRA ( LETRA | [0-9] )* ;

fragment LETRA  : [a-zA-Z_áéíóúÁÉÍÓÚñÑüÜ] ;
fragment ESCAPE : '\\' [nrt"'\\0] ;

// Cualquier otro carácter es un error léxico
ERROR_CHAR : . ;
