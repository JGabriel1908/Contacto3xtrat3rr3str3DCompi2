/*
 * Lexer del lenguaje Zetariano  (archivos .z)
 * Lenguaje orientado a objetos basado en Java.
 */
lexer grammar ZetarianoLexer;

// ---------------------------------------------------------------- comentarios y espacios
COMENTARIO_LINEA  : '//' ~[\r\n]* -> channel(HIDDEN) ;
COMENTARIO_BLOQUE : '/*' .*? '*/' -> channel(HIDDEN) ;
WS                : [ \t\r\n\f ​﻿]+ -> skip ;

// ---------------------------------------------------------------- modificadores y clases
// private y protected se reservan para el encapsulamiento del proyecto 2
PUBLIC    : 'public' ;
PRIVATE   : 'private' ;
PROTECTED : 'protected' ;
CLASS     : 'class' ;
NEW       : 'new' ;
THIS      : 'this' ;
VOID      : 'void' ;
RETURN    : 'return' ;

// ---------------------------------------------------------------- tipos
INT     : 'int' ;
DOUBLE  : 'double' ;
CHAR    : 'char' ;
BOOLEAN : 'boolean' ;
STRING  : 'String' ;

// ---------------------------------------------------------------- control de flujo
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

// ---------------------------------------------------------------- literales especiales
TRUE  : 'true' ;
FALSE : 'false' ;
NULL  : 'null' ;

// ---------------------------------------------------------------- funciones nativas
PRINTLN : 'println' ;
PRINT   : 'print' ;
READLN  : 'readln' ;

// ---------------------------------------------------------------- operadores
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
