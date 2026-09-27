
lexer grammar ZetarianoLexer;

COMENTARIO_LINEA  : '//' ~[\r\n]* -> channel(HIDDEN) ;
COMENTARIO_BLOQUE : '/*' .*? '*/' -> channel(HIDDEN) ;
WS                : [ \t\r\n\f ​﻿]+ -> skip ;

PUBLIC    : 'public' ;
PRIVATE   : 'private' ;
PROTECTED : 'protected' ;
CLASS     : 'class' ;
NEW       : 'new' ;
THIS      : 'this' ;
VOID      : 'void' ;
RETURN    : 'return' ;

INT     : 'int' ;
DOUBLE  : 'double' ;
CHAR    : 'char' ;
BOOLEAN : 'boolean' ;
STRING  : 'String' ;

IF       : 'if' ;
ELSE     : 'else' ;
SWITCH   : 'switch' ;
CASE     : 'case' ;
DEFAULT  : 'default' ;
BREAK    : 'break' ;
CONTINUE : 'continue' ;
FOR      : 'for' ;
WHILE    : 'while' ;
DO       : 'do' ;

TRUE  : 'true' ;
FALSE : 'false' ;
NULL  : 'null' ;

PRINTLN : 'println' ;
PRINT   : 'print' ;
READLN  : 'readln' ;

INCREMENTO    : '++' ;
DECREMENTO    : '--' ;
MAS_IGUAL     : '+=' ;
MENOS_IGUAL   : '-=' ;
POR_IGUAL     : '*=' ;
DIV_IGUAL     : '/=' ;
MOD_IGUAL     : '%=' ;
IGUAL_IGUAL   : '==' ;
DIFERENTE     : '!=' ;
MENOR_IGUAL   : '<=' ;
MAYOR_IGUAL   : '>=' ;
MENOR         : '<' ;
MAYOR         : '>' ;
AND           : '&&' ;
OR            : '||' ;
NOT           : '!' ;
MAS           : '+' ;
MENOS         : '-' ;
MULT          : '*' ;
DIV           : '/' ;
MOD           : '%' ;
IGUAL         : '=' ;
INTERROGACION : '?' ;

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
