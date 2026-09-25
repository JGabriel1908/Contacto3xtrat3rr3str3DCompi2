// Generated from com/mycompany/C3/grammar/PigLatinParser.g4 by ANTLR 4.13.2
package com.mycompany.C3.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PigLatinParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PigLatinParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(PigLatinParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#importacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportacion(PigLatinParser.ImportacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#ruta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuta(PigLatinParser.RutaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#seccionVariables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeccionVariables(PigLatinParser.SeccionVariablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#seccionPrincipal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeccionPrincipal(PigLatinParser.SeccionPrincipalContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion(PigLatinParser.DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declVariable}
	 * labeled alternative in {@link PigLatinParser#declaracionSimple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclVariable(PigLatinParser.DeclVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declInferida}
	 * labeled alternative in {@link PigLatinParser#declaracionSimple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclInferida(PigLatinParser.DeclInferidaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declArreglo}
	 * labeled alternative in {@link PigLatinParser#declaracionSimple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclArreglo(PigLatinParser.DeclArregloContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#valorInferido}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValorInferido(PigLatinParser.ValorInferidoContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#dimension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimension(PigLatinParser.DimensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#valor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValor(PigLatinParser.ValorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#inicializadorLista}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicializadorLista(PigLatinParser.InicializadorListaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(PigLatinParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senDeclaracion}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenDeclaracion(PigLatinParser.SenDeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senAsignacion}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenAsignacion(PigLatinParser.SenAsignacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senIncremento}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenIncremento(PigLatinParser.SenIncrementoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senImprimir}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenImprimir(PigLatinParser.SenImprimirContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senLeer}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenLeer(PigLatinParser.SenLeerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senLlamada}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenLlamada(PigLatinParser.SenLlamadaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senSi}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenSi(PigLatinParser.SenSiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senDum}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenDum(PigLatinParser.SenDumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senFacere}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenFacere(PigLatinParser.SenFacereContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senPer}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenPer(PigLatinParser.SenPerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senPerge}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenPerge(PigLatinParser.SenPergeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senInterrumpe}
	 * labeled alternative in {@link PigLatinParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenInterrumpe(PigLatinParser.SenInterrumpeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#aliterSi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAliterSi(PigLatinParser.AliterSiContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#aliter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAliter(PigLatinParser.AliterContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(PigLatinParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#perInicio}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPerInicio(PigLatinParser.PerInicioContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#perActualizacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPerActualizacion(PigLatinParser.PerActualizacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#acceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcceso(PigLatinParser.AccesoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code accLlamada}
	 * labeled alternative in {@link PigLatinParser#inicioAcceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccLlamada(PigLatinParser.AccLlamadaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code accId}
	 * labeled alternative in {@link PigLatinParser#inicioAcceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccId(PigLatinParser.AccIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sufMetodo}
	 * labeled alternative in {@link PigLatinParser#sufijo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSufMetodo(PigLatinParser.SufMetodoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sufAtributo}
	 * labeled alternative in {@link PigLatinParser#sufijo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSufAtributo(PigLatinParser.SufAtributoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sufIndice}
	 * labeled alternative in {@link PigLatinParser#sufijo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSufIndice(PigLatinParser.SufIndiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#objetoNuevo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjetoNuevo(PigLatinParser.ObjetoNuevoContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#argumentos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentos(PigLatinParser.ArgumentosContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAcceso}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAcceso(PigLatinParser.ExprAccesoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOr(PigLatinParser.ExprOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprNuevo}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNuevo(PigLatinParser.ExprNuevoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAditiva}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAditiva(PigLatinParser.ExprAditivaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprRelacional}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprRelacional(PigLatinParser.ExprRelacionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprIgualdad}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIgualdad(PigLatinParser.ExprIgualdadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprParentesis}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParentesis(PigLatinParser.ExprParentesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprUnaria}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprUnaria(PigLatinParser.ExprUnariaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAnd(PigLatinParser.ExprAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprLiteral}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLiteral(PigLatinParser.ExprLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprMultiplicativa}
	 * labeled alternative in {@link PigLatinParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultiplicativa(PigLatinParser.ExprMultiplicativaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(PigLatinParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(PigLatinParser.TipoContext ctx);
}