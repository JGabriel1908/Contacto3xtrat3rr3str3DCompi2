/*
 * Parser del lenguaje Pig Latin  (archivos .pig)
 *
 * El ';' final es opcional en todas las sentencias.
 * En la impresión cada elemento va precedido de '>>':  >> "Poder: " >> calcular(x)
 */
parser grammar PigLatinParser;

options { tokenVocab = PigLatinLexer; }

programa
    : importacion* seccionVariables? seccionPrincipal EOF
    ;

// ================================================================ secciones

// import carpeta.Objeto1.z  /  import carpeta.Funciones.y
importacion
    : IMPORT ruta PUNTO_COMA?
    ;

ruta
    : ID (PUNTO ID)+
    ;

// Solo variables, arreglos y estructuras/objetos globales
seccionVariables
    : SEC_VARIABLES declaracion*
    ;

seccionPrincipal
    : SEC_PRINCIPAL sentencia* FIN_PROGRAMA PUNTO_COMA?
    ;

// ================================================================ declaraciones

declaracion
    : declaracionSimple PUNTO_COMA?
    ;

declaracionSimple
    : ESTO ID DOSPUNTOS tipo valor?                               # declVariable
    | ESTO ID DOSPUNTOS valorInferido                             # declInferida   // esto o : novus Clase(...)
    | SERIES ID dimension+ DOSPUNTOS tipo inicializadorLista?     # declArreglo
    ;

// El tipo se deduce del valor
valorInferido
    : objetoNuevo
    | literal
    ;

dimension
    : COR_IZQ expr COR_DER
    ;

// Una expresión o una lista entre llaves (arreglos y estructuras, admite anidamiento)
valor
    : expr
    | inicializadorLista
    ;

inicializadorLista
    : LLA_IZQ (valor (COMA valor)*)? LLA_DER
    ;

// ================================================================ sentencias

bloque
    : LLA_IZQ sentencia* LLA_DER
    ;

sentencia
    : declaracion                                                          # senDeclaracion
    | asignacion PUNTO_COMA?                                               # senAsignacion
    | acceso op=(INCREMENTO | DECREMENTO) PUNTO_COMA?                      # senIncremento
    | IMPRIMIR expr (IMPRIMIR expr)* PUNTO_COMA?                           # senImprimir
    | acceso? LEER PUNTO_COMA?                                             # senLeer
    | acceso PUNTO_COMA?                                                   # senLlamada     // debe terminar en llamada (semántico)
    | SI PAR_IZQ expr PAR_DER bloque aliterSi* aliter? FINIS PUNTO_COMA?   # senSi
    | DUM PAR_IZQ expr PAR_DER bloque FINIS PUNTO_COMA?                    # senDum
    | FACERE bloque DUM PAR_IZQ expr PAR_DER PUNTO_COMA?                   # senFacere
    | PER PAR_IZQ perInicio? PUNTO_COMA expr? PUNTO_COMA perActualizacion? PAR_DER bloque (FINIS PUNTO_COMA?)? # senPer
    | PERGE PUNTO_COMA?                                                    # senPerge       // continue
    | INTERRUMPE PUNTO_COMA?                                               # senInterrumpe  // break
    ;

aliterSi
    : ALITER PAR_IZQ expr PAR_DER bloque
    ;

aliter
    : ALITER bloque
    ;

asignacion
    : acceso IGUAL valor
    ;

perInicio
    : declaracionSimple
    | asignacion
    ;

perActualizacion
    : acceso op=(INCREMENTO | DECREMENTO)
    | asignacion
    ;

// variable, arreglo[i], obj.atributo, obj.metodo(...), funcion(...), a[0].b.c(...)
acceso
    : inicioAcceso sufijo*
    ;

inicioAcceso
    : ID PAR_IZQ argumentos? PAR_DER    # accLlamada     // función definida en un .y
    | ID                                # accId
    ;

sufijo
    : PUNTO ID PAR_IZQ argumentos? PAR_DER  # sufMetodo
    | PUNTO ID                              # sufAtributo
    | COR_IZQ expr COR_DER                  # sufIndice
    ;

objetoNuevo
    : NOVUS ID PAR_IZQ argumentos? PAR_DER
    ;

argumentos
    : expr (COMA expr)*
    ;

// ================================================================ expresiones
// Precedencia de mayor a menor. En expresiones '=' también es comparación de igualdad.

expr
    : PAR_IZQ expr PAR_DER                                            # exprParentesis
    | literal                                                         # exprLiteral
    | objetoNuevo                                                     # exprNuevo
    | acceso                                                          # exprAcceso
    | op=(NOT | MENOS) expr                                           # exprUnaria
    | izq=expr op=(MULT | DIV | MOD) der=expr                         # exprMultiplicativa
    | izq=expr op=(MAS | MENOS) der=expr                              # exprAditiva
    | izq=expr op=(MENOR | MAYOR | MENOR_IGUAL | MAYOR_IGUAL) der=expr # exprRelacional
    | izq=expr op=(IGUAL_IGUAL | IGUAL | DIFERENTE) der=expr          # exprIgualdad
    | izq=expr op=AND der=expr                                        # exprAnd
    | izq=expr op=OR der=expr                                         # exprOr
    ;

literal
    : ENTERO_LIT
    | DECIMAL_LIT
    | CADENA_LIT
    | CARACTER_LIT
    | VERUM
    | FALSUS
    ;

// ================================================================ tipos

tipo
    : NUMERUS
    | TEXTUM
    | DECIMALIS
    | LITTERA
    | BOOL
    | ID            // estructura (.y) u objeto (.z)
    ;
