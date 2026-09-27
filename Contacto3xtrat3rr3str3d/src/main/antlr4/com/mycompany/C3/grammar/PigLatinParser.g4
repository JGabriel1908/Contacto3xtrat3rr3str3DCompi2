
parser grammar PigLatinParser;

options { tokenVocab = PigLatinLexer; }

programa
    : importacion* seccionVariables? seccionPrincipal EOF
    ;

importacion
    : IMPORT ruta PUNTO_COMA?
    ;

ruta
    : ID (PUNTO ID)+
    ;

seccionVariables
    : SEC_VARIABLES declaracion*
    ;

seccionPrincipal
    : SEC_PRINCIPAL sentencia* (FIN_PROGRAMA PUNTO_COMA?)?
    ;

declaracion
    : declaracionSimple PUNTO_COMA?
    ;

declaracionSimple
    : ESTO ID DOSPUNTOS tipo valor?                               # declVariable
    | ESTO ID DOSPUNTOS valorInferido                             # declInferida   // esto o : novus Clase(...)
    | SERIES ID dimension+ DOSPUNTOS tipo inicializadorLista?     # declArreglo
    ;

valorInferido
    : objetoNuevo
    | literal
    ;

dimension
    : COR_IZQ expr COR_DER
    ;

valor
    : expr
    | inicializadorLista
    ;

inicializadorLista
    : LLA_IZQ (valor (COMA valor)*)? LLA_DER
    ;

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


tipo
    : NUMERUS
    | TEXTUM
    | DECIMALIS
    | LITTERA
    | BOOL
    | ID           
    ;
