// Generated from com/mycompany/C3/grammar/YParser.g4 by ANTLR 4.13.2
package com.mycompany.C3.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link YParser}.
 */
public interface YParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link YParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(YParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(YParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#seccionEstructuras}.
	 * @param ctx the parse tree
	 */
	void enterSeccionEstructuras(YParser.SeccionEstructurasContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#seccionEstructuras}.
	 * @param ctx the parse tree
	 */
	void exitSeccionEstructuras(YParser.SeccionEstructurasContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#seccionFunciones}.
	 * @param ctx the parse tree
	 */
	void enterSeccionFunciones(YParser.SeccionFuncionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#seccionFunciones}.
	 * @param ctx the parse tree
	 */
	void exitSeccionFunciones(YParser.SeccionFuncionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#defEstructura}.
	 * @param ctx the parse tree
	 */
	void enterDefEstructura(YParser.DefEstructuraContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#defEstructura}.
	 * @param ctx the parse tree
	 */
	void exitDefEstructura(YParser.DefEstructuraContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#campo}.
	 * @param ctx the parse tree
	 */
	void enterCampo(YParser.CampoContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#campo}.
	 * @param ctx the parse tree
	 */
	void exitCampo(YParser.CampoContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#defFuncion}.
	 * @param ctx the parse tree
	 */
	void enterDefFuncion(YParser.DefFuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#defFuncion}.
	 * @param ctx the parse tree
	 */
	void exitDefFuncion(YParser.DefFuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(YParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(YParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paramArreglo}
	 * labeled alternative in {@link YParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParamArreglo(YParser.ParamArregloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paramArreglo}
	 * labeled alternative in {@link YParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParamArreglo(YParser.ParamArregloContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paramEstructura}
	 * labeled alternative in {@link YParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParamEstructura(YParser.ParamEstructuraContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paramEstructura}
	 * labeled alternative in {@link YParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParamEstructura(YParser.ParamEstructuraContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paramValor}
	 * labeled alternative in {@link YParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParamValor(YParser.ParamValorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paramValor}
	 * labeled alternative in {@link YParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParamValor(YParser.ParamValorContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(YParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(YParser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insDefEstructura}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInsDefEstructura(YParser.InsDefEstructuraContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insDefEstructura}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInsDefEstructura(YParser.InsDefEstructuraContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insDeclaracion}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInsDeclaracion(YParser.InsDeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insDeclaracion}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInsDeclaracion(YParser.InsDeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insAsignacion}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInsAsignacion(YParser.InsAsignacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insAsignacion}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInsAsignacion(YParser.InsAsignacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insIncremento}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInsIncremento(YParser.InsIncrementoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insIncremento}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInsIncremento(YParser.InsIncrementoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insLlamada}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInsLlamada(YParser.InsLlamadaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insLlamada}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInsLlamada(YParser.InsLlamadaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insImprimir}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInsImprimir(YParser.InsImprimirContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insImprimir}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInsImprimir(YParser.InsImprimirContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insLeer}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInsLeer(YParser.InsLeerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insLeer}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInsLeer(YParser.InsLeerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insRetornar}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInsRetornar(YParser.InsRetornarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insRetornar}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInsRetornar(YParser.InsRetornarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insRomper}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInsRomper(YParser.InsRomperContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insRomper}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInsRomper(YParser.InsRomperContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insContinuar}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInsContinuar(YParser.InsContinuarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insContinuar}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInsContinuar(YParser.InsContinuarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insCondicional}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInsCondicional(YParser.InsCondicionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insCondicional}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInsCondicional(YParser.InsCondicionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insSeleccion}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInsSeleccion(YParser.InsSeleccionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insSeleccion}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInsSeleccion(YParser.InsSeleccionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insPara}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInsPara(YParser.InsParaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insPara}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInsPara(YParser.InsParaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insMientras}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInsMientras(YParser.InsMientrasContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insMientras}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInsMientras(YParser.InsMientrasContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insHacer}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInsHacer(YParser.InsHacerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insHacer}
	 * labeled alternative in {@link YParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInsHacer(YParser.InsHacerContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#fin}.
	 * @param ctx the parse tree
	 */
	void enterFin(YParser.FinContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#fin}.
	 * @param ctx the parse tree
	 */
	void exitFin(YParser.FinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declArreglo}
	 * labeled alternative in {@link YParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclArreglo(YParser.DeclArregloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declArreglo}
	 * labeled alternative in {@link YParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclArreglo(YParser.DeclArregloContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declVariable}
	 * labeled alternative in {@link YParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclVariable(YParser.DeclVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declVariable}
	 * labeled alternative in {@link YParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclVariable(YParser.DeclVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#dimension}.
	 * @param ctx the parse tree
	 */
	void enterDimension(YParser.DimensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#dimension}.
	 * @param ctx the parse tree
	 */
	void exitDimension(YParser.DimensionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iniExpr}
	 * labeled alternative in {@link YParser#inicializador}.
	 * @param ctx the parse tree
	 */
	void enterIniExpr(YParser.IniExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iniExpr}
	 * labeled alternative in {@link YParser#inicializador}.
	 * @param ctx the parse tree
	 */
	void exitIniExpr(YParser.IniExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iniLista}
	 * labeled alternative in {@link YParser#inicializador}.
	 * @param ctx the parse tree
	 */
	void enterIniLista(YParser.IniListaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iniLista}
	 * labeled alternative in {@link YParser#inicializador}.
	 * @param ctx the parse tree
	 */
	void exitIniLista(YParser.IniListaContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(YParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(YParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#incremento}.
	 * @param ctx the parse tree
	 */
	void enterIncremento(YParser.IncrementoContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#incremento}.
	 * @param ctx the parse tree
	 */
	void exitIncremento(YParser.IncrementoContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#acceso}.
	 * @param ctx the parse tree
	 */
	void enterAcceso(YParser.AccesoContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#acceso}.
	 * @param ctx the parse tree
	 */
	void exitAcceso(YParser.AccesoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sufIndice}
	 * labeled alternative in {@link YParser#sufijo}.
	 * @param ctx the parse tree
	 */
	void enterSufIndice(YParser.SufIndiceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sufIndice}
	 * labeled alternative in {@link YParser#sufijo}.
	 * @param ctx the parse tree
	 */
	void exitSufIndice(YParser.SufIndiceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sufCampo}
	 * labeled alternative in {@link YParser#sufijo}.
	 * @param ctx the parse tree
	 */
	void enterSufCampo(YParser.SufCampoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sufCampo}
	 * labeled alternative in {@link YParser#sufijo}.
	 * @param ctx the parse tree
	 */
	void exitSufCampo(YParser.SufCampoContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#llamada}.
	 * @param ctx the parse tree
	 */
	void enterLlamada(YParser.LlamadaContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#llamada}.
	 * @param ctx the parse tree
	 */
	void exitLlamada(YParser.LlamadaContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void enterArgumentos(YParser.ArgumentosContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void exitArgumentos(YParser.ArgumentosContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#condicional}.
	 * @param ctx the parse tree
	 */
	void enterCondicional(YParser.CondicionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#condicional}.
	 * @param ctx the parse tree
	 */
	void exitCondicional(YParser.CondicionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#sinoSi}.
	 * @param ctx the parse tree
	 */
	void enterSinoSi(YParser.SinoSiContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#sinoSi}.
	 * @param ctx the parse tree
	 */
	void exitSinoSi(YParser.SinoSiContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#contrario}.
	 * @param ctx the parse tree
	 */
	void enterContrario(YParser.ContrarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#contrario}.
	 * @param ctx the parse tree
	 */
	void exitContrario(YParser.ContrarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#seleccion}.
	 * @param ctx the parse tree
	 */
	void enterSeleccion(YParser.SeleccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#seleccion}.
	 * @param ctx the parse tree
	 */
	void exitSeleccion(YParser.SeleccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#caso}.
	 * @param ctx the parse tree
	 */
	void enterCaso(YParser.CasoContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#caso}.
	 * @param ctx the parse tree
	 */
	void exitCaso(YParser.CasoContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#casoDefecto}.
	 * @param ctx the parse tree
	 */
	void enterCasoDefecto(YParser.CasoDefectoContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#casoDefecto}.
	 * @param ctx the parse tree
	 */
	void exitCasoDefecto(YParser.CasoDefectoContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#cuerpoCaso}.
	 * @param ctx the parse tree
	 */
	void enterCuerpoCaso(YParser.CuerpoCasoContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#cuerpoCaso}.
	 * @param ctx the parse tree
	 */
	void exitCuerpoCaso(YParser.CuerpoCasoContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#cicloPara}.
	 * @param ctx the parse tree
	 */
	void enterCicloPara(YParser.CicloParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#cicloPara}.
	 * @param ctx the parse tree
	 */
	void exitCicloPara(YParser.CicloParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#inicioPara}.
	 * @param ctx the parse tree
	 */
	void enterInicioPara(YParser.InicioParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#inicioPara}.
	 * @param ctx the parse tree
	 */
	void exitInicioPara(YParser.InicioParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#actualizacionPara}.
	 * @param ctx the parse tree
	 */
	void enterActualizacionPara(YParser.ActualizacionParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#actualizacionPara}.
	 * @param ctx the parse tree
	 */
	void exitActualizacionPara(YParser.ActualizacionParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#cicloMientras}.
	 * @param ctx the parse tree
	 */
	void enterCicloMientras(YParser.CicloMientrasContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#cicloMientras}.
	 * @param ctx the parse tree
	 */
	void exitCicloMientras(YParser.CicloMientrasContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#cicloHacer}.
	 * @param ctx the parse tree
	 */
	void enterCicloHacer(YParser.CicloHacerContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#cicloHacer}.
	 * @param ctx the parse tree
	 */
	void exitCicloHacer(YParser.CicloHacerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprLeer}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprLeer(YParser.ExprLeerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprLeer}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprLeer(YParser.ExprLeerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprLlamada}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprLlamada(YParser.ExprLlamadaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprLlamada}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprLlamada(YParser.ExprLlamadaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAcceso}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAcceso(YParser.ExprAccesoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAcceso}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAcceso(YParser.ExprAccesoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprOr(YParser.ExprOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprOr(YParser.ExprOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAditiva}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAditiva(YParser.ExprAditivaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAditiva}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAditiva(YParser.ExprAditivaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprRelacional}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprRelacional(YParser.ExprRelacionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprRelacional}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprRelacional(YParser.ExprRelacionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprIgualdad}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprIgualdad(YParser.ExprIgualdadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprIgualdad}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprIgualdad(YParser.ExprIgualdadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprParentesis}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParentesis(YParser.ExprParentesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprParentesis}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParentesis(YParser.ExprParentesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprUnaria}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprUnaria(YParser.ExprUnariaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprUnaria}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprUnaria(YParser.ExprUnariaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAnd(YParser.ExprAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAnd(YParser.ExprAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprLiteral}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprLiteral(YParser.ExprLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprLiteral}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprLiteral(YParser.ExprLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMultiplicativa}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMultiplicativa(YParser.ExprMultiplicativaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMultiplicativa}
	 * labeled alternative in {@link YParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMultiplicativa(YParser.ExprMultiplicativaContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(YParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(YParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(YParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(YParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#tipoPrimitivo}.
	 * @param ctx the parse tree
	 */
	void enterTipoPrimitivo(YParser.TipoPrimitivoContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#tipoPrimitivo}.
	 * @param ctx the parse tree
	 */
	void exitTipoPrimitivo(YParser.TipoPrimitivoContext ctx);
}