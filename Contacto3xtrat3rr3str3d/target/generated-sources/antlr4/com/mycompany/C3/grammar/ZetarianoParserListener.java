// Generated from com/mycompany/C3/grammar/ZetarianoParser.g4 by ANTLR 4.13.2
package com.mycompany.C3.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ZetarianoParser}.
 */
public interface ZetarianoParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(ZetarianoParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(ZetarianoParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#clase}.
	 * @param ctx the parse tree
	 */
	void enterClase(ZetarianoParser.ClaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#clase}.
	 * @param ctx the parse tree
	 */
	void exitClase(ZetarianoParser.ClaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#miembro}.
	 * @param ctx the parse tree
	 */
	void enterMiembro(ZetarianoParser.MiembroContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#miembro}.
	 * @param ctx the parse tree
	 */
	void exitMiembro(ZetarianoParser.MiembroContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#modificador}.
	 * @param ctx the parse tree
	 */
	void enterModificador(ZetarianoParser.ModificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#modificador}.
	 * @param ctx the parse tree
	 */
	void exitModificador(ZetarianoParser.ModificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#atributo}.
	 * @param ctx the parse tree
	 */
	void enterAtributo(ZetarianoParser.AtributoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#atributo}.
	 * @param ctx the parse tree
	 */
	void exitAtributo(ZetarianoParser.AtributoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterConstructor(ZetarianoParser.ConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitConstructor(ZetarianoParser.ConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#metodo}.
	 * @param ctx the parse tree
	 */
	void enterMetodo(ZetarianoParser.MetodoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#metodo}.
	 * @param ctx the parse tree
	 */
	void exitMetodo(ZetarianoParser.MetodoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#tipoRetorno}.
	 * @param ctx the parse tree
	 */
	void enterTipoRetorno(ZetarianoParser.TipoRetornoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#tipoRetorno}.
	 * @param ctx the parse tree
	 */
	void exitTipoRetorno(ZetarianoParser.TipoRetornoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(ZetarianoParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(ZetarianoParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(ZetarianoParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(ZetarianoParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(ZetarianoParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(ZetarianoParser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senBloque}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenBloque(ZetarianoParser.SenBloqueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senBloque}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenBloque(ZetarianoParser.SenBloqueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senDeclaracion}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenDeclaracion(ZetarianoParser.SenDeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senDeclaracion}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenDeclaracion(ZetarianoParser.SenDeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senIf}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenIf(ZetarianoParser.SenIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senIf}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenIf(ZetarianoParser.SenIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senSwitch}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenSwitch(ZetarianoParser.SenSwitchContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senSwitch}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenSwitch(ZetarianoParser.SenSwitchContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senWhile}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenWhile(ZetarianoParser.SenWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senWhile}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenWhile(ZetarianoParser.SenWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senDoWhile}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenDoWhile(ZetarianoParser.SenDoWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senDoWhile}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenDoWhile(ZetarianoParser.SenDoWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senFor}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenFor(ZetarianoParser.SenForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senFor}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenFor(ZetarianoParser.SenForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senBreak}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenBreak(ZetarianoParser.SenBreakContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senBreak}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenBreak(ZetarianoParser.SenBreakContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senContinue}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenContinue(ZetarianoParser.SenContinueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senContinue}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenContinue(ZetarianoParser.SenContinueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senReturn}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenReturn(ZetarianoParser.SenReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senReturn}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenReturn(ZetarianoParser.SenReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senPrintln}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenPrintln(ZetarianoParser.SenPrintlnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senPrintln}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenPrintln(ZetarianoParser.SenPrintlnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senPrint}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenPrint(ZetarianoParser.SenPrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senPrint}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenPrint(ZetarianoParser.SenPrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senExpresion}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenExpresion(ZetarianoParser.SenExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senExpresion}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenExpresion(ZetarianoParser.SenExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senVacia}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenVacia(ZetarianoParser.SenVaciaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senVacia}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenVacia(ZetarianoParser.SenVaciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#declaracionLocal}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionLocal(ZetarianoParser.DeclaracionLocalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#declaracionLocal}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionLocal(ZetarianoParser.DeclaracionLocalContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#declarador}.
	 * @param ctx the parse tree
	 */
	void enterDeclarador(ZetarianoParser.DeclaradorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#declarador}.
	 * @param ctx the parse tree
	 */
	void exitDeclarador(ZetarianoParser.DeclaradorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#inicializador}.
	 * @param ctx the parse tree
	 */
	void enterInicializador(ZetarianoParser.InicializadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#inicializador}.
	 * @param ctx the parse tree
	 */
	void exitInicializador(ZetarianoParser.InicializadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#inicializadorArreglo}.
	 * @param ctx the parse tree
	 */
	void enterInicializadorArreglo(ZetarianoParser.InicializadorArregloContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#inicializadorArreglo}.
	 * @param ctx the parse tree
	 */
	void exitInicializadorArreglo(ZetarianoParser.InicializadorArregloContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#seccionSwitch}.
	 * @param ctx the parse tree
	 */
	void enterSeccionSwitch(ZetarianoParser.SeccionSwitchContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#seccionSwitch}.
	 * @param ctx the parse tree
	 */
	void exitSeccionSwitch(ZetarianoParser.SeccionSwitchContext ctx);
	/**
	 * Enter a parse tree produced by the {@code etiquetaCase}
	 * labeled alternative in {@link ZetarianoParser#etiquetaSwitch}.
	 * @param ctx the parse tree
	 */
	void enterEtiquetaCase(ZetarianoParser.EtiquetaCaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code etiquetaCase}
	 * labeled alternative in {@link ZetarianoParser#etiquetaSwitch}.
	 * @param ctx the parse tree
	 */
	void exitEtiquetaCase(ZetarianoParser.EtiquetaCaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code etiquetaDefault}
	 * labeled alternative in {@link ZetarianoParser#etiquetaSwitch}.
	 * @param ctx the parse tree
	 */
	void enterEtiquetaDefault(ZetarianoParser.EtiquetaDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code etiquetaDefault}
	 * labeled alternative in {@link ZetarianoParser#etiquetaSwitch}.
	 * @param ctx the parse tree
	 */
	void exitEtiquetaDefault(ZetarianoParser.EtiquetaDefaultContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#forInicio}.
	 * @param ctx the parse tree
	 */
	void enterForInicio(ZetarianoParser.ForInicioContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#forInicio}.
	 * @param ctx the parse tree
	 */
	void exitForInicio(ZetarianoParser.ForInicioContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#forActualizacion}.
	 * @param ctx the parse tree
	 */
	void enterForActualizacion(ZetarianoParser.ForActualizacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#forActualizacion}.
	 * @param ctx the parse tree
	 */
	void exitForActualizacion(ZetarianoParser.ForActualizacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAditiva}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAditiva(ZetarianoParser.ExprAditivaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAditiva}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAditiva(ZetarianoParser.ExprAditivaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprRelacional}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprRelacional(ZetarianoParser.ExprRelacionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprRelacional}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprRelacional(ZetarianoParser.ExprRelacionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprIndice}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprIndice(ZetarianoParser.ExprIndiceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprIndice}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprIndice(ZetarianoParser.ExprIndiceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprPostfija}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprPostfija(ZetarianoParser.ExprPostfijaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprPostfija}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprPostfija(ZetarianoParser.ExprPostfijaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprTernaria}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprTernaria(ZetarianoParser.ExprTernariaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprTernaria}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprTernaria(ZetarianoParser.ExprTernariaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAsignacion}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAsignacion(ZetarianoParser.ExprAsignacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAsignacion}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAsignacion(ZetarianoParser.ExprAsignacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprLlamadaMetodo}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprLlamadaMetodo(ZetarianoParser.ExprLlamadaMetodoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprLlamadaMetodo}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprLlamadaMetodo(ZetarianoParser.ExprLlamadaMetodoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAtributo}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAtributo(ZetarianoParser.ExprAtributoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAtributo}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAtributo(ZetarianoParser.ExprAtributoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprPrefija}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprPrefija(ZetarianoParser.ExprPrefijaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprPrefija}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprPrefija(ZetarianoParser.ExprPrefijaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprOr(ZetarianoParser.ExprOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprOr(ZetarianoParser.ExprOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprPrimario}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprPrimario(ZetarianoParser.ExprPrimarioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprPrimario}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprPrimario(ZetarianoParser.ExprPrimarioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprIgualdad}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprIgualdad(ZetarianoParser.ExprIgualdadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprIgualdad}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprIgualdad(ZetarianoParser.ExprIgualdadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAnd(ZetarianoParser.ExprAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAnd(ZetarianoParser.ExprAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMultiplicativa}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMultiplicativa(ZetarianoParser.ExprMultiplicativaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMultiplicativa}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMultiplicativa(ZetarianoParser.ExprMultiplicativaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primParentesis}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 */
	void enterPrimParentesis(ZetarianoParser.PrimParentesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primParentesis}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 */
	void exitPrimParentesis(ZetarianoParser.PrimParentesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primLiteral}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 */
	void enterPrimLiteral(ZetarianoParser.PrimLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primLiteral}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 */
	void exitPrimLiteral(ZetarianoParser.PrimLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primThis}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 */
	void enterPrimThis(ZetarianoParser.PrimThisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primThis}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 */
	void exitPrimThis(ZetarianoParser.PrimThisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primLlamada}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 */
	void enterPrimLlamada(ZetarianoParser.PrimLlamadaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primLlamada}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 */
	void exitPrimLlamada(ZetarianoParser.PrimLlamadaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primId}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 */
	void enterPrimId(ZetarianoParser.PrimIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primId}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 */
	void exitPrimId(ZetarianoParser.PrimIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primReadln}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 */
	void enterPrimReadln(ZetarianoParser.PrimReadlnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primReadln}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 */
	void exitPrimReadln(ZetarianoParser.PrimReadlnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primNuevoObjeto}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 */
	void enterPrimNuevoObjeto(ZetarianoParser.PrimNuevoObjetoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primNuevoObjeto}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 */
	void exitPrimNuevoObjeto(ZetarianoParser.PrimNuevoObjetoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primNuevoArreglo}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 */
	void enterPrimNuevoArreglo(ZetarianoParser.PrimNuevoArregloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primNuevoArreglo}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 */
	void exitPrimNuevoArreglo(ZetarianoParser.PrimNuevoArregloContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primNuevoArregloInit}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 */
	void enterPrimNuevoArregloInit(ZetarianoParser.PrimNuevoArregloInitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primNuevoArregloInit}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 */
	void exitPrimNuevoArregloInit(ZetarianoParser.PrimNuevoArregloInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void enterArgumentos(ZetarianoParser.ArgumentosContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void exitArgumentos(ZetarianoParser.ArgumentosContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(ZetarianoParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(ZetarianoParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(ZetarianoParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(ZetarianoParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#tipoBase}.
	 * @param ctx the parse tree
	 */
	void enterTipoBase(ZetarianoParser.TipoBaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#tipoBase}.
	 * @param ctx the parse tree
	 */
	void exitTipoBase(ZetarianoParser.TipoBaseContext ctx);
}