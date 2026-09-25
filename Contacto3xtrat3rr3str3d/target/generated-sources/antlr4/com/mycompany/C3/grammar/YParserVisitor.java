// Generated from com/mycompany/C3/grammar/YParser.g4 by ANTLR 4.13.2
package com.mycompany.C3.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link YParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface YParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link YParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(YParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#seccionEstructuras}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeccionEstructuras(YParser.SeccionEstructurasContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#seccionFunciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeccionFunciones(YParser.SeccionFuncionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#defEstructura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefEstructura(YParser.DefEstructuraContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#campo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCampo(YParser.CampoContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#defFuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefFuncion(YParser.DefFuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(YParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paramArreglo}
	 * labeled alternative in {@link YParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamArreglo(YParser.ParamArregloContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paramEstructura}
	 * labeled alternative in {@link YParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamEstructura(YParser.ParamEstructuraContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paramValor}
	 * labeled alternative in {@link YParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamValor(YParser.ParamValorContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(YParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insDefEstructura}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsDefEstructura(YParser.InsDefEstructuraContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insDeclaracion}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsDeclaracion(YParser.InsDeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insAsignacion}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsAsignacion(YParser.InsAsignacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insIncremento}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsIncremento(YParser.InsIncrementoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insLlamada}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsLlamada(YParser.InsLlamadaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insImprimir}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsImprimir(YParser.InsImprimirContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insLeer}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsLeer(YParser.InsLeerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insRetornar}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsRetornar(YParser.InsRetornarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insRomper}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsRomper(YParser.InsRomperContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insContinuar}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsContinuar(YParser.InsContinuarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insCondicional}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsCondicional(YParser.InsCondicionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insSeleccion}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsSeleccion(YParser.InsSeleccionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insPara}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsPara(YParser.InsParaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insMientras}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsMientras(YParser.InsMientrasContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insHacer}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsHacer(YParser.InsHacerContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#fin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFin(YParser.FinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declArreglo}
	 * labeled alternative in {@link YParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclArreglo(YParser.DeclArregloContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declVariable}
	 * labeled alternative in {@link YParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclVariable(YParser.DeclVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#dimension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimension(YParser.DimensionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iniExpr}
	 * labeled alternative in {@link YParser#inicializador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIniExpr(YParser.IniExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iniLista}
	 * labeled alternative in {@link YParser#inicializador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIniLista(YParser.IniListaContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(YParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#incremento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncremento(YParser.IncrementoContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#acceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcceso(YParser.AccesoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sufIndice}
	 * labeled alternative in {@link YParser#sufijo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSufIndice(YParser.SufIndiceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sufCampo}
	 * labeled alternative in {@link YParser#sufijo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSufCampo(YParser.SufCampoContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#llamada}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamada(YParser.LlamadaContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#argumentos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentos(YParser.ArgumentosContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#condicional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicional(YParser.CondicionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#sinoSi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSinoSi(YParser.SinoSiContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#contrario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContrario(YParser.ContrarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#seleccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeleccion(YParser.SeleccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#caso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaso(YParser.CasoContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#casoDefecto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCasoDefecto(YParser.CasoDefectoContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#cuerpoCaso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuerpoCaso(YParser.CuerpoCasoContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#cicloPara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCicloPara(YParser.CicloParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#inicioPara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicioPara(YParser.InicioParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#actualizacionPara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualizacionPara(YParser.ActualizacionParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#cicloMientras}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCicloMientras(YParser.CicloMientrasContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#cicloHacer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCicloHacer(YParser.CicloHacerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprLeer}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLeer(YParser.ExprLeerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprLlamada}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLlamada(YParser.ExprLlamadaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAcceso}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAcceso(YParser.ExprAccesoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOr(YParser.ExprOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAditiva}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAditiva(YParser.ExprAditivaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprRelacional}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprRelacional(YParser.ExprRelacionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprIgualdad}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIgualdad(YParser.ExprIgualdadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprParentesis}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParentesis(YParser.ExprParentesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprUnaria}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprUnaria(YParser.ExprUnariaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAnd(YParser.ExprAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprLiteral}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLiteral(YParser.ExprLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprMultiplicativa}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultiplicativa(YParser.ExprMultiplicativaContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(YParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(YParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#tipoPrimitivo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoPrimitivo(YParser.TipoPrimitivoContext ctx);
}