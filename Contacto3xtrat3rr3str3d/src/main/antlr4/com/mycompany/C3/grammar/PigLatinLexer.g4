
lexer grammar PigLatinLexer;

COMENTARIO_BLOQUE : '##' .*? '##' -> channel(HIDDEN) ;
COMENTARIO_LINEA  : '//' ~[\r\n]* -> channel(HIDDEN) ;
WS                : [ \t\r\n\f ​﻿]+ -> skip ;

IMPORT        : 'import' ;
SEC_VARIABLES : 'VARIABILES' [ \t]* '>' ;
SEC_PRINCIPAL : 'MAIOR' [ \t]* '>' ;
FIN_PROGRAMA  : 'FINIS' ;

ESTO      : 'esto' ;
SERIES    : 'series' ;
NUMERUS   : 'numerus' ;
TEXTUM    : 'textum' ;
DECIMALIS : 'decimalis' ;
LITTERA   : 'littera' ;
BOOL      : 'bool' ;
NOVUS     : 'novus' ;

VERUM  : 'verum' ;
FALSUS : 'falsus' ;

SI         : 'si' ;
ALITER     : 'aliter' ;
FINIS      : 'finis' ;
DUM        : 'dum' ;
FACERE     : 'facere' ;
PER        : 'per' ;
PERGE      : 'perge' ;
INTERRUMPE : 'interrumpe' ;

IMPRIMIR : '>>' ;
LEER     : '<<' ;

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
CADENA_LIT   : '"' ( ~["\\\r\n] | ESCAPE )* '"'
             | '“' ~[”\r\n]* '”'
             ;
CARACTER_LIT : '\'' ( ~['\\\r\n] | ESCAPE ) '\'' ;
ID           : LETRA ( LETRA | [0-9] )* ;

fragment LETRA  : [a-zA-Z_áéíóúÁÉÍÓÚñÑüÜ] ;
fragment ESCAPE : '\\' [nrt"'\\0] ;

ERROR_CHAR : . ;
