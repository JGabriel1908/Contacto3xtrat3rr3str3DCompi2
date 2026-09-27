
parser grammar YParser;

options { tokenVocab = YLexer; }

programa
    : seccionEstructuras? seccionFunciones EOF
    ;


seccionEstructuras
    : SEC_ESTRUCTURAS NEWLINE defEstructura*
    ;

seccionFunciones
    : SEC_FUNCIONES NEWLINE defFuncion*
    ;


defEstructura
    : ESTRUCTURA ID DOSPUNTOS NEWLINE INDENT campo+ DEDENT
    ;

campo
    : tipo ID dimension* fin
    ;


defFuncion
    : DEFINIR ID PAR_IZQ parametros? PAR_DER (FLECHA tipo)? DOSPUNTOS bloque
    ;

parametros
    : parametro (COMA parametro)*
    ;

parametro
    : (COR_IZQ COR_DER)+ tipo ID        # paramArreglo      // por referencia
    | LLA_IZQ LLA_DER ID ID             # paramEstructura   // por referencia
    | tipoPrimitivo ID                  # paramValor        // por valor
    ;


bloque
    : NEWLINE INDENT instruccion+ DEDENT
    ;

instruccion
    : defEstructura                               # insDefEstructura
    | declaracion fin                             # insDeclaracion
    | asignacion fin                              # insAsignacion
    | incremento fin                              # insIncremento
    | llamada fin                                 # insLlamada
    | IMPRIMIR PAR_IZQ expr? PAR_DER fin          # insImprimir
    | LEER PAR_IZQ PAR_DER fin                    # insLeer
    | RETORNAR expr? fin                          # insRetornar
    | ROMPER fin                                  # insRomper
    | CONTINUAR fin                               # insContinuar
    | condicional                                 # insCondicional
    | seleccion                                   # insSeleccion
    | cicloPara                                   # insPara
    | cicloMientras                               # insMientras
    | cicloHacer                                  # insHacer
    ;

fin
    : PUNTO_COMA? NEWLINE
    ;

declaracion
    : tipo ID dimension+ (IGUAL inicializador)?   # declArreglo
    | tipo ID (IGUAL inicializador)?              # declVariable
    ;

dimension
    : COR_IZQ expr COR_DER
    ;

inicializador
    : expr                                                        # iniExpr
    | LLA_IZQ (inicializador (COMA inicializador)*)? LLA_DER      # iniLista
    ;

asignacion
    : acceso IGUAL inicializador
    ;

incremento
    : acceso op=(INCREMENTO | DECREMENTO)
    ;

acceso
    : ID sufijo*
    ;

sufijo
    : COR_IZQ expr COR_DER      # sufIndice
    | PUNTO ID                  # sufCampo
    ;

llamada
    : ID PAR_IZQ argumentos? PAR_DER
    ;

argumentos
    : expr (COMA expr)*
    ;


condicional
    : SI PAR_IZQ expr PAR_DER ENTONCES bloque sinoSi* contrario?
    ;

sinoSi
    : SINO PAR_IZQ expr PAR_DER ENTONCES bloque
    ;

contrario
    : CONTRARIO DOSPUNTOS? bloque
    ;

seleccion
    : ELEGIR PAR_IZQ expr PAR_DER DOSPUNTOS NEWLINE INDENT caso* casoDefecto? DEDENT
    ;

caso
    : CASO expr DOSPUNTOS cuerpoCaso
    ;

casoDefecto
    : SIEMPRE DOSPUNTOS cuerpoCaso
    ;

cuerpoCaso
    : bloque
    | NEWLINE instruccion*
    ;

cicloPara
    : PARA PAR_IZQ inicioPara? PUNTO_COMA expr? PUNTO_COMA actualizacionPara? PAR_DER DOSPUNTOS bloque
    ;

inicioPara
    : declaracion
    | asignacion
    ;

actualizacionPara
    : incremento
    | asignacion
    ;

cicloMientras
    : MIENTRAS PAR_IZQ expr PAR_DER HACER DOSPUNTOS? bloque
    ;

cicloHacer
    : HACER DOSPUNTOS? bloque MIENTRAS PAR_IZQ expr PAR_DER fin
    ;

expr
    : PAR_IZQ expr PAR_DER                                            # exprParentesis
    | llamada                                                         # exprLlamada
    | LEER PAR_IZQ PAR_DER                                            # exprLeer
    | acceso                                                          # exprAcceso
    | literal                                                         # exprLiteral
    | op=(NOT | MENOS) expr                                           # exprUnaria
    | izq=expr op=(MULT | DIV | MOD) der=expr                         # exprMultiplicativa
    | izq=expr op=(MAS | MENOS) der=expr                              # exprAditiva
    | izq=expr op=(MENOR | MAYOR | MENOR_IGUAL | MAYOR_IGUAL) der=expr # exprRelacional
    | izq=expr op=(IGUAL_IGUAL | DIFERENTE) der=expr                  # exprIgualdad
    | izq=expr op=AND der=expr                                        # exprAnd
    | izq=expr op=OR der=expr                                         # exprOr
    ;

literal
    : ENTERO_LIT
    | DECIMAL_LIT
    | CADENA_LIT
    | CARACTER_LIT
    | VERDADERO
    | FALSO
    ;

tipo
    : tipoPrimitivo
    | ID                    // estructura definida por el usuario
    ;

tipoPrimitivo
    : ENTERO
    | FLOTANTE
    | CADENA
    | CARACTER
    | BOOL
    ;
