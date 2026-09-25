// Generated from com/mycompany/C3/grammar/PigLatinParser.g4 by ANTLR 4.13.2
package com.mycompany.C3.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PigLatinParser}.
 */
public interface PigLatinParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(PigLatinParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(PigLatinParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#importacion}.
	 * @param ctx the parse tree
	 */
	void enterImportacion(PigLatinParser.ImportacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#importacion}.
	 * @param ctx the parse tree
	 */
	void exitImportacion(PigLatinParser.ImportacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#ruta}.
	 * @param ctx the parse tree
	 */
	void enterRuta(PigLatinParser.RutaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#ruta}.
	 * @param ctx the parse tree
	 */
	void exitRuta(PigLatinParser.RutaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#seccionVariables}.
	 * @param ctx the parse tree
	 */
	void enterSeccionVariables(PigLatinParser.SeccionVariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#seccionVariables}.
	 * @param ctx the parse tree
	 */
	void exitSeccionVariables(PigLatinParser.SeccionVariablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#seccionPrincipal}.
	 * @param ctx the parse tree
	 */
	void enterSeccionPrincipal(PigLatinParser.SeccionPrincipalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#seccionPrincipal}.
	 * @param ctx the parse tree
	 */
	void exitSeccionPrincipal(PigLatinParser.SeccionPrincipalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(PigLatinParser.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(PigLatinParser.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declVariable}
	 * labeled alternative in {@link PigLatinParser#declaracionSimple}.
	 * @param ctx the parse tree
	 */
	void enterDeclVariable(PigLatinParser.DeclVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declVariable}
	 * labeled alternative in {@link PigLatinParser#declaracionSimple}.
	 * @param ctx the parse tree
	 */
	void exitDeclVariable(PigLatinParser.DeclVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declInferida}
	 * labeled alternative in {@link PigLatinParser#declaracionSimple}.
	 * @param ctx the parse tree
	 */
	void enterDeclInferida(PigLatinParser.DeclInferidaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declInferida}
	 * labeled alternative in {@link PigLatinParser#declaracionSimple}.
	 * @param ctx the parse tree
	 */
	void exitDeclInferida(PigLatinParser.DeclInferidaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declArreglo}
	 * labeled alternative in {@link PigLatinParser#declaracionSimple}.
	 * @param ctx the parse tree
	 */
	void enterDeclArreglo(PigLatinParser.DeclArregloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declArreglo}
	 * labeled alternative in {@link PigLatinParser#declaracionSimple}.
	 * @param ctx the parse tree
	 */
	void exitDeclArreglo(PigLatinParser.DeclArregloContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#valorInferido}.
	 * @param ctx the parse tree
	 */
	void enterValorInferido(PigLatinParser.ValorInferidoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#valorInferido}.
	 * @param ctx the parse tree
	 */
	void exitValorInferido(PigLatinParser.ValorInferidoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#dimension}.
	 * @param ctx the parse tree
	 */
	void enterDimension(PigLatinParser.DimensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#dimension}.
	 * @param ctx the parse tree
	 */
	void exitDimension(PigLatinParser.DimensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#valor}.
	 * @param ctx the parse tree
	 */
	void enterValor(PigLatinParser.ValorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#valor}.
	 * @param ctx the parse tree
	 */
	void exitValor(PigLatinParser.ValorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#inicializadorLista}.
	 * @param ctx the parse tree
	 */
	void enterInicializadorLista(PigLatinParser.InicializadorListaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#inicializadorLista}.
	 * @param ctx the parse tree
	 */
	void exitInicializadorLista(PigLatinParser.InicializadorListaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(PigLatinParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(PigLatinParser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senDeclaracion}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenDeclaracion(PigLatinParser.SenDeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senDeclaracion}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenDeclaracion(PigLatinParser.SenDeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senAsignacion}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenAsignacion(PigLatinParser.SenAsignacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senAsignacion}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenAsignacion(PigLatinParser.SenAsignacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senIncremento}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenIncremento(PigLatinParser.SenIncrementoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senIncremento}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenIncremento(PigLatinParser.SenIncrementoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senImprimir}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenImprimir(PigLatinParser.SenImprimirContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senImprimir}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenImprimir(PigLatinParser.SenImprimirContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senLeer}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenLeer(PigLatinParser.SenLeerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senLeer}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenLeer(PigLatinParser.SenLeerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senLlamada}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenLlamada(PigLatinParser.SenLlamadaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senLlamada}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenLlamada(PigLatinParser.SenLlamadaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senSi}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenSi(PigLatinParser.SenSiContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senSi}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenSi(PigLatinParser.SenSiContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senDum}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenDum(PigLatinParser.SenDumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senDum}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenDum(PigLatinParser.SenDumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senFacere}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenFacere(PigLatinParser.SenFacereContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senFacere}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenFacere(PigLatinParser.SenFacereContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senPer}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenPer(PigLatinParser.SenPerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senPer}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenPer(PigLatinParser.SenPerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senPerge}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenPerge(PigLatinParser.SenPergeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senPerge}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenPerge(PigLatinParser.SenPergeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senInterrumpe}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSenInterrumpe(PigLatinParser.SenInterrumpeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senInterrumpe}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSenInterrumpe(PigLatinParser.SenInterrumpeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#aliterSi}.
	 * @param ctx the parse tree
	 */
	void enterAliterSi(PigLatinParser.AliterSiContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#aliterSi}.
	 * @param ctx the parse tree
	 */
	void exitAliterSi(PigLatinParser.AliterSiContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#aliter}.
	 * @param ctx the parse tree
	 */
	void enterAliter(PigLatinParser.AliterContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#aliter}.
	 * @param ctx the parse tree
	 */
	void exitAliter(PigLatinParser.AliterContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(PigLatinParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(PigLatinParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#perInicio}.
	 * @param ctx the parse tree
	 */
	void enterPerInicio(PigLatinParser.PerInicioContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#perInicio}.
	 * @param ctx the parse tree
	 */
	void exitPerInicio(PigLatinParser.PerInicioContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#perActualizacion}.
	 * @param ctx the parse tree
	 */
	void enterPerActualizacion(PigLatinParser.PerActualizacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#perActualizacion}.
	 * @param ctx the parse tree
	 */
	void exitPerActualizacion(PigLatinParser.PerActualizacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#acceso}.
	 * @param ctx the parse tree
	 */
	void enterAcceso(PigLatinParser.AccesoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#acceso}.
	 * @param ctx the parse tree
	 */
	void exitAcceso(PigLatinParser.AccesoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code accLlamada}
	 * labeled alternative in {@link PigLatinParser#inicioAcceso}.
	 * @param ctx the parse tree
	 */
	void enterAccLlamada(PigLatinParser.AccLlamadaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code accLlamada}
	 * labeled alternative in {@link PigLatinParser#inicioAcceso}.
	 * @param ctx the parse tree
	 */
	void exitAccLlamada(PigLatinParser.AccLlamadaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code accId}
	 * labeled alternative in {@link PigLatinParser#inicioAcceso}.
	 * @param ctx the parse tree
	 */
	void enterAccId(PigLatinParser.AccIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code accId}
	 * labeled alternative in {@link PigLatinParser#inicioAcceso}.
	 * @param ctx the parse tree
	 */
	void exitAccId(PigLatinParser.AccIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sufMetodo}
	 * labeled alternative in {@link PigLatinParser#sufijo}.
	 * @param ctx the parse tree
	 */
	void enterSufMetodo(PigLatinParser.SufMetodoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sufMetodo}
	 * labeled alternative in {@link PigLatinParser#sufijo}.
	 * @param ctx the parse tree
	 */
	void exitSufMetodo(PigLatinParser.SufMetodoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sufAtributo}
	 * labeled alternative in {@link PigLatinParser#sufijo}.
	 * @param ctx the parse tree
	 */
	void enterSufAtributo(PigLatinParser.SufAtributoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sufAtributo}
	 * labeled alternative in {@link PigLatinParser#sufijo}.
	 * @param ctx the parse tree
	 */
	void exitSufAtributo(PigLatinParser.SufAtributoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sufIndice}
	 * labeled alternative in {@link PigLatinParser#sufijo}.
	 * @param ctx the parse tree
	 */
	void enterSufIndice(PigLatinParser.SufIndiceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sufIndice}
	 * labeled alternative in {@link PigLatinParser#sufijo}.
	 * @param ctx the parse tree
	 */
	void exitSufIndice(PigLatinParser.SufIndiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#objetoNuevo}.
	 * @param ctx the parse tree
	 */
	void enterObjetoNuevo(PigLatinParser.ObjetoNuevoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#objetoNuevo}.
	 * @param ctx the parse tree
	 */
	void exitObjetoNuevo(PigLatinParser.ObjetoNuevoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void enterArgumentos(PigLatinParser.ArgumentosContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void exitArgumentos(PigLatinParser.ArgumentosContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAcceso}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAcceso(PigLatinParser.ExprAccesoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAcceso}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAcceso(PigLatinParser.ExprAccesoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprOr(PigLatinParser.ExprOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprOr(PigLatinParser.ExprOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprNuevo}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprNuevo(PigLatinParser.ExprNuevoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprNuevo}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprNuevo(PigLatinParser.ExprNuevoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAditiva}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAditiva(PigLatinParser.ExprAditivaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAditiva}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAditiva(PigLatinParser.ExprAditivaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprRelacional}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprRelacional(PigLatinParser.ExprRelacionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprRelacional}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprRelacional(PigLatinParser.ExprRelacionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprIgualdad}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprIgualdad(PigLatinParser.ExprIgualdadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprIgualdad}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprIgualdad(PigLatinParser.ExprIgualdadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprParentesis}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParentesis(PigLatinParser.ExprParentesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprParentesis}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParentesis(PigLatinParser.ExprParentesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprUnaria}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprUnaria(PigLatinParser.ExprUnariaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprUnaria}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprUnaria(PigLatinParser.ExprUnariaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAnd(PigLatinParser.ExprAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAnd(PigLatinParser.ExprAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprLiteral}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprLiteral(PigLatinParser.ExprLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprLiteral}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprLiteral(PigLatinParser.ExprLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMultiplicativa}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMultiplicativa(PigLatinParser.ExprMultiplicativaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMultiplicativa}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMultiplicativa(PigLatinParser.ExprMultiplicativaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(PigLatinParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(PigLatinParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(PigLatinParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(PigLatinParser.TipoContext ctx);
}