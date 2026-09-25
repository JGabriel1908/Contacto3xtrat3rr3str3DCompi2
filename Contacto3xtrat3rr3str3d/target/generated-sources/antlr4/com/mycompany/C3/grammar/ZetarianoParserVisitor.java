// Generated from com/mycompany/C3/grammar/ZetarianoParser.g4 by ANTLR 4.13.2
package com.mycompany.C3.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ZetarianoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ZetarianoParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(ZetarianoParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#clase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClase(ZetarianoParser.ClaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#miembro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMiembro(ZetarianoParser.MiembroContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#modificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModificador(ZetarianoParser.ModificadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#atributo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtributo(ZetarianoParser.AtributoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor(ZetarianoParser.ConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#metodo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetodo(ZetarianoParser.MetodoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#tipoRetorno}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoRetorno(ZetarianoParser.TipoRetornoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(ZetarianoParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(ZetarianoParser.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(ZetarianoParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senBloque}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenBloque(ZetarianoParser.SenBloqueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senDeclaracion}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenDeclaracion(ZetarianoParser.SenDeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senIf}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenIf(ZetarianoParser.SenIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senSwitch}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenSwitch(ZetarianoParser.SenSwitchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senWhile}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenWhile(ZetarianoParser.SenWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senDoWhile}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenDoWhile(ZetarianoParser.SenDoWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senFor}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenFor(ZetarianoParser.SenForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senBreak}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenBreak(ZetarianoParser.SenBreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senContinue}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenContinue(ZetarianoParser.SenContinueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senReturn}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenReturn(ZetarianoParser.SenReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senPrintln}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenPrintln(ZetarianoParser.SenPrintlnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senPrint}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenPrint(ZetarianoParser.SenPrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senExpresion}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenExpresion(ZetarianoParser.SenExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senVacia}
	 * labeled alternative in {@link ZetarianoParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenVacia(ZetarianoParser.SenVaciaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#declaracionLocal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionLocal(ZetarianoParser.DeclaracionLocalContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#declarador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarador(ZetarianoParser.DeclaradorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#inicializador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicializador(ZetarianoParser.InicializadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#inicializadorArreglo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicializadorArreglo(ZetarianoParser.InicializadorArregloContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#seccionSwitch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeccionSwitch(ZetarianoParser.SeccionSwitchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code etiquetaCase}
	 * labeled alternative in {@link ZetarianoParser#etiquetaSwitch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEtiquetaCase(ZetarianoParser.EtiquetaCaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code etiquetaDefault}
	 * labeled alternative in {@link ZetarianoParser#etiquetaSwitch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEtiquetaDefault(ZetarianoParser.EtiquetaDefaultContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#forInicio}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInicio(ZetarianoParser.ForInicioContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#forActualizacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForActualizacion(ZetarianoParser.ForActualizacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAditiva}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAditiva(ZetarianoParser.ExprAditivaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprRelacional}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprRelacional(ZetarianoParser.ExprRelacionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprIndice}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIndice(ZetarianoParser.ExprIndiceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprPostfija}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPostfija(ZetarianoParser.ExprPostfijaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprTernaria}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprTernaria(ZetarianoParser.ExprTernariaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAsignacion}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAsignacion(ZetarianoParser.ExprAsignacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprLlamadaMetodo}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLlamadaMetodo(ZetarianoParser.ExprLlamadaMetodoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAtributo}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAtributo(ZetarianoParser.ExprAtributoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprPrefija}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPrefija(ZetarianoParser.ExprPrefijaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOr(ZetarianoParser.ExprOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprPrimario}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPrimario(ZetarianoParser.ExprPrimarioContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprIgualdad}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIgualdad(ZetarianoParser.ExprIgualdadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAnd(ZetarianoParser.ExprAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprMultiplicativa}
	 * labeled alternative in {@link ZetarianoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultiplicativa(ZetarianoParser.ExprMultiplicativaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primParentesis}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimParentesis(ZetarianoParser.PrimParentesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primLiteral}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimLiteral(ZetarianoParser.PrimLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primThis}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimThis(ZetarianoParser.PrimThisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primLlamada}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimLlamada(ZetarianoParser.PrimLlamadaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primId}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimId(ZetarianoParser.PrimIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primReadln}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimReadln(ZetarianoParser.PrimReadlnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primNuevoObjeto}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimNuevoObjeto(ZetarianoParser.PrimNuevoObjetoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primNuevoArreglo}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimNuevoArreglo(ZetarianoParser.PrimNuevoArregloContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primNuevoArregloInit}
	 * labeled alternative in {@link ZetarianoParser#primario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimNuevoArregloInit(ZetarianoParser.PrimNuevoArregloInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#argumentos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentos(ZetarianoParser.ArgumentosContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(ZetarianoParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(ZetarianoParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#tipoBase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoBase(ZetarianoParser.TipoBaseContext ctx);
}