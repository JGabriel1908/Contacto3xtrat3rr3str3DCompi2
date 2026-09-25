/*
 * Parser del lenguaje Zetariano  (archivos .z)
 * Cada archivo contiene una única clase con el mismo nombre que el archivo
 * (esto último se valida en el análisis semántico).
 */
parser grammar ZetarianoParser;

options { tokenVocab = ZetarianoLexer; }

programa
    : clase EOF
    ;

// ================================================================ clase y miembros

clase
    : modificador? CLASS ID LLA_IZQ miembro* LLA_DER
    ;

miembro
    : atributo
    | constructor
    | metodo
    ;

modificador
    : PUBLIC
    | PRIVATE
    | PROTECTED
    ;

atributo
    : modificador? tipo declarador (COMA declarador)* PUNTO_COMA
    ;

constructor
    : modificador? ID PAR_IZQ parametros? PAR_DER bloque
    ;

metodo
    : modificador? tipoRetorno ID PAR_IZQ parametros? PAR_DER bloque
    ;

tipoRetorno
    : VOID
    | tipo
    ;

parametros
    : parametro (COMA parametro)*
    ;

parametro
    : tipo ID
    ;

// ================================================================ sentencias

bloque
    : LLA_IZQ sentencia* LLA_DER
    ;

sentencia
    : bloque                                                          # senBloque
    | declaracionLocal PUNTO_COMA                                     # senDeclaracion
    | IF PAR_IZQ expr PAR_DER sentencia (ELSE sentencia)?             # senIf
    | SWITCH PAR_IZQ expr PAR_DER LLA_IZQ seccionSwitch* LLA_DER      # senSwitch
    | WHILE PAR_IZQ expr PAR_DER sentencia                            # senWhile
    | DO sentencia WHILE PAR_IZQ expr PAR_DER PUNTO_COMA              # senDoWhile
    | FOR PAR_IZQ forInicio? PUNTO_COMA expr? PUNTO_COMA forActualizacion? PAR_DER sentencia # senFor
    | BREAK PUNTO_COMA                                                # senBreak
    | CONTINUE PUNTO_COMA                                             # senContinue
    | RETURN expr? PUNTO_COMA                                         # senReturn
    | PRINTLN PAR_IZQ expr? PAR_DER PUNTO_COMA                         # senPrintln
    | PRINT PAR_IZQ expr PAR_DER PUNTO_COMA                            # senPrint
    | expr PUNTO_COMA                                                 # senExpresion // asignaciones, ++, llamadas...
    | PUNTO_COMA                                                      # senVacia
    ;

declaracionLocal
    : tipo declarador (COMA declarador)*
    ;

declarador
    : ID (IGUAL inicializador)?
    ;

inicializador
    : expr
    | inicializadorArreglo
    ;

inicializadorArreglo
    : LLA_IZQ (inicializador (COMA inicializador)* COMA?)? LLA_DER
    ;

seccionSwitch
    : etiquetaSwitch sentencia*
    ;

etiquetaSwitch
    : CASE expr DOSPUNTOS           # etiquetaCase
    | DEFAULT DOSPUNTOS             # etiquetaDefault
    ;

forInicio
    : declaracionLocal
    | expr (COMA expr)*
    ;

forActualizacion
    : expr (COMA expr)*
    ;

// ================================================================ expresiones
// Precedencia de mayor a menor (igual que Java)

expr
    : primario                                                                # exprPrimario
    | expr PUNTO ID PAR_IZQ argumentos? PAR_DER                               # exprLlamadaMetodo
    | expr PUNTO ID                                                           # exprAtributo
    | expr COR_IZQ expr COR_DER                                               # exprIndice
    | expr op=(INCREMENTO | DECREMENTO)                                       # exprPostfija
    | op=(MAS | MENOS | NOT | INCREMENTO | DECREMENTO) expr                   # exprPrefija
    | izq=expr op=(MULT | DIV | MOD) der=expr                                 # exprMultiplicativa
    | izq=expr op=(MAS | MENOS) der=expr                                      # exprAditiva
    | izq=expr op=(MENOR | MAYOR | MENOR_IGUAL | MAYOR_IGUAL) der=expr        # exprRelacional
    | izq=expr op=(IGUAL_IGUAL | DIFERENTE) der=expr                          # exprIgualdad
    | izq=expr op=AND der=expr                                                # exprAnd
    | izq=expr op=OR der=expr                                                 # exprOr
    | <assoc=right> cond=expr INTERROGACION siVerdadero=expr DOSPUNTOS siFalso=expr # exprTernaria
    | <assoc=right> izq=expr op=(IGUAL | MAS_IGUAL | MENOS_IGUAL | POR_IGUAL | DIV_IGUAL | MOD_IGUAL) der=expr # exprAsignacion
    ;

primario
    : PAR_IZQ expr PAR_DER                                          # primParentesis
    | literal                                                       # primLiteral
    | THIS                                                          # primThis
    | ID PAR_IZQ argumentos? PAR_DER                                # primLlamada
    | ID                                                            # primId
    | READLN PAR_IZQ PAR_DER                                        # primReadln
    | NEW ID PAR_IZQ argumentos? PAR_DER                            # primNuevoObjeto
    | NEW tipoBase (COR_IZQ expr COR_DER)+ (COR_IZQ COR_DER)*       # primNuevoArreglo
    | NEW tipoBase (COR_IZQ COR_DER)+ inicializadorArreglo          # primNuevoArregloInit
    ;

argumentos
    : expr (COMA expr)*
    ;

literal
    : ENTERO_LIT
    | DECIMAL_LIT
    | CADENA_LIT
    | CARACTER_LIT
    | TRUE
    | FALSE
    | NULL
    ;

// ================================================================ tipos

tipo
    : tipoBase (COR_IZQ COR_DER)*
    ;

tipoBase
    : INT
    | DOUBLE
    | CHAR
    | BOOLEAN
    | STRING
    | ID            // clase
    ;
