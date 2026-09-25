// Generated from com/mycompany/C3/grammar/YParser.g4 by ANTLR 4.13.2
package com.mycompany.C3.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class YParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INDENT=1, DEDENT=2, COMENTARIO_LINEA=3, COMENTARIO_BLOQUE=4, NEWLINE=5, 
		WS=6, SEC_ESTRUCTURAS=7, SEC_FUNCIONES=8, ESTRUCTURA=9, DEFINIR=10, RETORNAR=11, 
		ENTERO=12, FLOTANTE=13, CADENA=14, CARACTER=15, BOOL=16, VERDADERO=17, 
		FALSO=18, SI=19, ENTONCES=20, SINO=21, CONTRARIO=22, ELEGIR=23, CASO=24, 
		SIEMPRE=25, ROMPER=26, CONTINUAR=27, PARA=28, MIENTRAS=29, HACER=30, IMPRIMIR=31, 
		LEER=32, INCREMENTO=33, DECREMENTO=34, FLECHA=35, IGUAL_IGUAL=36, DIFERENTE=37, 
		MENOR_IGUAL=38, MAYOR_IGUAL=39, MENOR=40, MAYOR=41, AND=42, OR=43, NOT=44, 
		MAS=45, MENOS=46, MULT=47, DIV=48, MOD=49, IGUAL=50, PAR_IZQ=51, PAR_DER=52, 
		COR_IZQ=53, COR_DER=54, LLA_IZQ=55, LLA_DER=56, PUNTO=57, COMA=58, DOSPUNTOS=59, 
		PUNTO_COMA=60, DECIMAL_LIT=61, ENTERO_LIT=62, CADENA_LIT=63, CARACTER_LIT=64, 
		ID=65, ERROR_CHAR=66;
	public static final int
		RULE_programa = 0, RULE_seccionEstructuras = 1, RULE_seccionFunciones = 2, 
		RULE_defEstructura = 3, RULE_campo = 4, RULE_defFuncion = 5, RULE_parametros = 6, 
		RULE_parametro = 7, RULE_bloque = 8, RULE_instruccion = 9, RULE_fin = 10, 
		RULE_declaracion = 11, RULE_dimension = 12, RULE_inicializador = 13, RULE_asignacion = 14, 
		RULE_incremento = 15, RULE_acceso = 16, RULE_sufijo = 17, RULE_llamada = 18, 
		RULE_argumentos = 19, RULE_condicional = 20, RULE_sinoSi = 21, RULE_contrario = 22, 
		RULE_seleccion = 23, RULE_caso = 24, RULE_casoDefecto = 25, RULE_cuerpoCaso = 26, 
		RULE_cicloPara = 27, RULE_inicioPara = 28, RULE_actualizacionPara = 29, 
		RULE_cicloMientras = 30, RULE_cicloHacer = 31, RULE_expr = 32, RULE_literal = 33, 
		RULE_tipo = 34, RULE_tipoPrimitivo = 35;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "seccionEstructuras", "seccionFunciones", "defEstructura", 
			"campo", "defFuncion", "parametros", "parametro", "bloque", "instruccion", 
			"fin", "declaracion", "dimension", "inicializador", "asignacion", "incremento", 
			"acceso", "sufijo", "llamada", "argumentos", "condicional", "sinoSi", 
			"contrario", "seleccion", "caso", "casoDefecto", "cuerpoCaso", "cicloPara", 
			"inicioPara", "actualizacionPara", "cicloMientras", "cicloHacer", "expr", 
			"literal", "tipo", "tipoPrimitivo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, "'%estructuras'", "'%funciones'", 
			"'estructura'", "'definir'", "'retornar'", "'entero'", "'flotante'", 
			"'cadena'", "'caracter'", "'bool'", "'verdadero'", "'falso'", "'si'", 
			"'entonces'", "'sino'", "'contrario'", "'elegir'", "'caso'", "'siempre'", 
			"'romper'", "'continuar'", "'para'", "'mientras'", "'hacer'", "'imprimir'", 
			"'leer'", "'++'", "'--'", "'->'", "'=='", "'!='", "'<='", "'>='", "'<'", 
			"'>'", "'&&'", "'||'", "'!'", "'+'", "'-'", "'*'", "'/'", "'%'", "'='", 
			"'('", "')'", "'['", "']'", "'{'", "'}'", "'.'", "','", "':'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INDENT", "DEDENT", "COMENTARIO_LINEA", "COMENTARIO_BLOQUE", "NEWLINE", 
			"WS", "SEC_ESTRUCTURAS", "SEC_FUNCIONES", "ESTRUCTURA", "DEFINIR", "RETORNAR", 
			"ENTERO", "FLOTANTE", "CADENA", "CARACTER", "BOOL", "VERDADERO", "FALSO", 
			"SI", "ENTONCES", "SINO", "CONTRARIO", "ELEGIR", "CASO", "SIEMPRE", "ROMPER", 
			"CONTINUAR", "PARA", "MIENTRAS", "HACER", "IMPRIMIR", "LEER", "INCREMENTO", 
			"DECREMENTO", "FLECHA", "IGUAL_IGUAL", "DIFERENTE", "MENOR_IGUAL", "MAYOR_IGUAL", 
			"MENOR", "MAYOR", "AND", "OR", "NOT", "MAS", "MENOS", "MULT", "DIV", 
			"MOD", "IGUAL", "PAR_IZQ", "PAR_DER", "COR_IZQ", "COR_DER", "LLA_IZQ", 
			"LLA_DER", "PUNTO", "COMA", "DOSPUNTOS", "PUNTO_COMA", "DECIMAL_LIT", 
			"ENTERO_LIT", "CADENA_LIT", "CARACTER_LIT", "ID", "ERROR_CHAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "YParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public YParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public SeccionFuncionesContext seccionFunciones() {
			return getRuleContext(SeccionFuncionesContext.class,0);
		}
		public TerminalNode EOF() { return getToken(YParser.EOF, 0); }
		public SeccionEstructurasContext seccionEstructuras() {
			return getRuleContext(SeccionEstructurasContext.class,0);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEC_ESTRUCTURAS) {
				{
				setState(72);
				seccionEstructuras();
				}
			}

			setState(75);
			seccionFunciones();
			setState(76);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SeccionEstructurasContext extends ParserRuleContext {
		public TerminalNode SEC_ESTRUCTURAS() { return getToken(YParser.SEC_ESTRUCTURAS, 0); }
		public TerminalNode NEWLINE() { return getToken(YParser.NEWLINE, 0); }
		public List<DefEstructuraContext> defEstructura() {
			return getRuleContexts(DefEstructuraContext.class);
		}
		public DefEstructuraContext defEstructura(int i) {
			return getRuleContext(DefEstructuraContext.class,i);
		}
		public SeccionEstructurasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seccionEstructuras; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterSeccionEstructuras(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitSeccionEstructuras(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitSeccionEstructuras(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeccionEstructurasContext seccionEstructuras() throws RecognitionException {
		SeccionEstructurasContext _localctx = new SeccionEstructurasContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_seccionEstructuras);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(SEC_ESTRUCTURAS);
			setState(79);
			match(NEWLINE);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ESTRUCTURA) {
				{
				{
				setState(80);
				defEstructura();
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SeccionFuncionesContext extends ParserRuleContext {
		public TerminalNode SEC_FUNCIONES() { return getToken(YParser.SEC_FUNCIONES, 0); }
		public TerminalNode NEWLINE() { return getToken(YParser.NEWLINE, 0); }
		public List<DefFuncionContext> defFuncion() {
			return getRuleContexts(DefFuncionContext.class);
		}
		public DefFuncionContext defFuncion(int i) {
			return getRuleContext(DefFuncionContext.class,i);
		}
		public SeccionFuncionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seccionFunciones; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterSeccionFunciones(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitSeccionFunciones(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitSeccionFunciones(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeccionFuncionesContext seccionFunciones() throws RecognitionException {
		SeccionFuncionesContext _localctx = new SeccionFuncionesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_seccionFunciones);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(SEC_FUNCIONES);
			setState(87);
			match(NEWLINE);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFINIR) {
				{
				{
				setState(88);
				defFuncion();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefEstructuraContext extends ParserRuleContext {
		public TerminalNode ESTRUCTURA() { return getToken(YParser.ESTRUCTURA, 0); }
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public TerminalNode DOSPUNTOS() { return getToken(YParser.DOSPUNTOS, 0); }
		public TerminalNode NEWLINE() { return getToken(YParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(YParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(YParser.DEDENT, 0); }
		public List<CampoContext> campo() {
			return getRuleContexts(CampoContext.class);
		}
		public CampoContext campo(int i) {
			return getRuleContext(CampoContext.class,i);
		}
		public DefEstructuraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defEstructura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterDefEstructura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitDefEstructura(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitDefEstructura(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefEstructuraContext defEstructura() throws RecognitionException {
		DefEstructuraContext _localctx = new DefEstructuraContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_defEstructura);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(ESTRUCTURA);
			setState(95);
			match(ID);
			setState(96);
			match(DOSPUNTOS);
			setState(97);
			match(NEWLINE);
			setState(98);
			match(INDENT);
			setState(100); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(99);
				campo();
				}
				}
				setState(102); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & 9007199254741023L) != 0) );
			setState(104);
			match(DEDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CampoContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public FinContext fin() {
			return getRuleContext(FinContext.class,0);
		}
		public List<DimensionContext> dimension() {
			return getRuleContexts(DimensionContext.class);
		}
		public DimensionContext dimension(int i) {
			return getRuleContext(DimensionContext.class,i);
		}
		public CampoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_campo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterCampo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitCampo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitCampo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CampoContext campo() throws RecognitionException {
		CampoContext _localctx = new CampoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_campo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			tipo();
			setState(107);
			match(ID);
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COR_IZQ) {
				{
				{
				setState(108);
				dimension();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114);
			fin();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefFuncionContext extends ParserRuleContext {
		public TerminalNode DEFINIR() { return getToken(YParser.DEFINIR, 0); }
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public TerminalNode PAR_IZQ() { return getToken(YParser.PAR_IZQ, 0); }
		public TerminalNode PAR_DER() { return getToken(YParser.PAR_DER, 0); }
		public TerminalNode DOSPUNTOS() { return getToken(YParser.DOSPUNTOS, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public TerminalNode FLECHA() { return getToken(YParser.FLECHA, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public DefFuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defFuncion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterDefFuncion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitDefFuncion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitDefFuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefFuncionContext defFuncion() throws RecognitionException {
		DefFuncionContext _localctx = new DefFuncionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_defFuncion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(DEFINIR);
			setState(117);
			match(ID);
			setState(118);
			match(PAR_IZQ);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 45035996273831936L) != 0)) {
				{
				setState(119);
				parametros();
				}
			}

			setState(122);
			match(PAR_DER);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FLECHA) {
				{
				setState(123);
				match(FLECHA);
				setState(124);
				tipo();
				}
			}

			setState(127);
			match(DOSPUNTOS);
			setState(128);
			bloque();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametrosContext extends ParserRuleContext {
		public List<ParametroContext> parametro() {
			return getRuleContexts(ParametroContext.class);
		}
		public ParametroContext parametro(int i) {
			return getRuleContext(ParametroContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(YParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(YParser.COMA, i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterParametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitParametros(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitParametros(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			parametro();
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(131);
				match(COMA);
				setState(132);
				parametro();
				}
				}
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametroContext extends ParserRuleContext {
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
	 
		public ParametroContext() { }
		public void copyFrom(ParametroContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParamValorContext extends ParametroContext {
		public TipoPrimitivoContext tipoPrimitivo() {
			return getRuleContext(TipoPrimitivoContext.class,0);
		}
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public ParamValorContext(ParametroContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterParamValor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitParamValor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitParamValor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParamEstructuraContext extends ParametroContext {
		public TerminalNode LLA_IZQ() { return getToken(YParser.LLA_IZQ, 0); }
		public TerminalNode LLA_DER() { return getToken(YParser.LLA_DER, 0); }
		public List<TerminalNode> ID() { return getTokens(YParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(YParser.ID, i);
		}
		public ParamEstructuraContext(ParametroContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterParamEstructura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitParamEstructura(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitParamEstructura(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParamArregloContext extends ParametroContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public List<TerminalNode> COR_IZQ() { return getTokens(YParser.COR_IZQ); }
		public TerminalNode COR_IZQ(int i) {
			return getToken(YParser.COR_IZQ, i);
		}
		public List<TerminalNode> COR_DER() { return getTokens(YParser.COR_DER); }
		public TerminalNode COR_DER(int i) {
			return getToken(YParser.COR_DER, i);
		}
		public ParamArregloContext(ParametroContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterParamArreglo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitParamArreglo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitParamArreglo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parametro);
		int _la;
		try {
			setState(154);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COR_IZQ:
				_localctx = new ParamArregloContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(140); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(138);
					match(COR_IZQ);
					setState(139);
					match(COR_DER);
					}
					}
					setState(142); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COR_IZQ );
				setState(144);
				tipo();
				setState(145);
				match(ID);
				}
				break;
			case LLA_IZQ:
				_localctx = new ParamEstructuraContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				match(LLA_IZQ);
				setState(148);
				match(LLA_DER);
				setState(149);
				match(ID);
				setState(150);
				match(ID);
				}
				break;
			case ENTERO:
			case FLOTANTE:
			case CADENA:
			case CARACTER:
			case BOOL:
				_localctx = new ParamValorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(151);
				tipoPrimitivo();
				setState(152);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BloqueContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(YParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(YParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(YParser.DEDENT, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public BloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterBloque(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitBloque(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitBloque(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(NEWLINE);
			setState(157);
			match(INDENT);
			setState(159); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(158);
				instruccion();
				}
				}
				setState(161); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & 72057594054591741L) != 0) );
			setState(163);
			match(DEDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstruccionContext extends ParserRuleContext {
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
	 
		public InstruccionContext() { }
		public void copyFrom(InstruccionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InsMientrasContext extends InstruccionContext {
		public CicloMientrasContext cicloMientras() {
			return getRuleContext(CicloMientrasContext.class,0);
		}
		public InsMientrasContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterInsMientras(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitInsMientras(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitInsMientras(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InsHacerContext extends InstruccionContext {
		public CicloHacerContext cicloHacer() {
			return getRuleContext(CicloHacerContext.class,0);
		}
		public InsHacerContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterInsHacer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitInsHacer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitInsHacer(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InsContinuarContext extends InstruccionContext {
		public TerminalNode CONTINUAR() { return getToken(YParser.CONTINUAR, 0); }
		public FinContext fin() {
			return getRuleContext(FinContext.class,0);
		}
		public InsContinuarContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterInsContinuar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitInsContinuar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitInsContinuar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InsIncrementoContext extends InstruccionContext {
		public IncrementoContext incremento() {
			return getRuleContext(IncrementoContext.class,0);
		}
		public FinContext fin() {
			return getRuleContext(FinContext.class,0);
		}
		public InsIncrementoContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterInsIncremento(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitInsIncremento(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitInsIncremento(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InsRomperContext extends InstruccionContext {
		public TerminalNode ROMPER() { return getToken(YParser.ROMPER, 0); }
		public FinContext fin() {
			return getRuleContext(FinContext.class,0);
		}
		public InsRomperContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterInsRomper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitInsRomper(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitInsRomper(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InsDefEstructuraContext extends InstruccionContext {
		public DefEstructuraContext defEstructura() {
			return getRuleContext(DefEstructuraContext.class,0);
		}
		public InsDefEstructuraContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterInsDefEstructura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitInsDefEstructura(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitInsDefEstructura(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InsLeerContext extends InstruccionContext {
		public TerminalNode LEER() { return getToken(YParser.LEER, 0); }
		public TerminalNode PAR_IZQ() { return getToken(YParser.PAR_IZQ, 0); }
		public TerminalNode PAR_DER() { return getToken(YParser.PAR_DER, 0); }
		public FinContext fin() {
			return getRuleContext(FinContext.class,0);
		}
		public InsLeerContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterInsLeer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitInsLeer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitInsLeer(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InsImprimirContext extends InstruccionContext {
		public TerminalNode IMPRIMIR() { return getToken(YParser.IMPRIMIR, 0); }
		public TerminalNode PAR_IZQ() { return getToken(YParser.PAR_IZQ, 0); }
		public TerminalNode PAR_DER() { return getToken(YParser.PAR_DER, 0); }
		public FinContext fin() {
			return getRuleContext(FinContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InsImprimirContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterInsImprimir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitInsImprimir(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitInsImprimir(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InsSeleccionContext extends InstruccionContext {
		public SeleccionContext seleccion() {
			return getRuleContext(SeleccionContext.class,0);
		}
		public InsSeleccionContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterInsSeleccion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitInsSeleccion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitInsSeleccion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InsCondicionalContext extends InstruccionContext {
		public CondicionalContext condicional() {
			return getRuleContext(CondicionalContext.class,0);
		}
		public InsCondicionalContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterInsCondicional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitInsCondicional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitInsCondicional(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InsParaContext extends InstruccionContext {
		public CicloParaContext cicloPara() {
			return getRuleContext(CicloParaContext.class,0);
		}
		public InsParaContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterInsPara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitInsPara(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitInsPara(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InsDeclaracionContext extends InstruccionContext {
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public FinContext fin() {
			return getRuleContext(FinContext.class,0);
		}
		public InsDeclaracionContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterInsDeclaracion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitInsDeclaracion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitInsDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InsLlamadaContext extends InstruccionContext {
		public LlamadaContext llamada() {
			return getRuleContext(LlamadaContext.class,0);
		}
		public FinContext fin() {
			return getRuleContext(FinContext.class,0);
		}
		public InsLlamadaContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterInsLlamada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitInsLlamada(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitInsLlamada(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InsRetornarContext extends InstruccionContext {
		public TerminalNode RETORNAR() { return getToken(YParser.RETORNAR, 0); }
		public FinContext fin() {
			return getRuleContext(FinContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InsRetornarContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterInsRetornar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitInsRetornar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitInsRetornar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InsAsignacionContext extends InstruccionContext {
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public FinContext fin() {
			return getRuleContext(FinContext.class,0);
		}
		public InsAsignacionContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterInsAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitInsAsignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitInsAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_instruccion);
		int _la;
		try {
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new InsDefEstructuraContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				defEstructura();
				}
				break;
			case 2:
				_localctx = new InsDeclaracionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				declaracion();
				setState(167);
				fin();
				}
				break;
			case 3:
				_localctx = new InsAsignacionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(169);
				asignacion();
				setState(170);
				fin();
				}
				break;
			case 4:
				_localctx = new InsIncrementoContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(172);
				incremento();
				setState(173);
				fin();
				}
				break;
			case 5:
				_localctx = new InsLlamadaContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(175);
				llamada();
				setState(176);
				fin();
				}
				break;
			case 6:
				_localctx = new InsImprimirContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(178);
				match(IMPRIMIR);
				setState(179);
				match(PAR_IZQ);
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & 545375618367491L) != 0)) {
					{
					setState(180);
					expr(0);
					}
				}

				setState(183);
				match(PAR_DER);
				setState(184);
				fin();
				}
				break;
			case 7:
				_localctx = new InsLeerContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(185);
				match(LEER);
				setState(186);
				match(PAR_IZQ);
				setState(187);
				match(PAR_DER);
				setState(188);
				fin();
				}
				break;
			case 8:
				_localctx = new InsRetornarContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(189);
				match(RETORNAR);
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & 545375618367491L) != 0)) {
					{
					setState(190);
					expr(0);
					}
				}

				setState(193);
				fin();
				}
				break;
			case 9:
				_localctx = new InsRomperContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(194);
				match(ROMPER);
				setState(195);
				fin();
				}
				break;
			case 10:
				_localctx = new InsContinuarContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(196);
				match(CONTINUAR);
				setState(197);
				fin();
				}
				break;
			case 11:
				_localctx = new InsCondicionalContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(198);
				condicional();
				}
				break;
			case 12:
				_localctx = new InsSeleccionContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(199);
				seleccion();
				}
				break;
			case 13:
				_localctx = new InsParaContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(200);
				cicloPara();
				}
				break;
			case 14:
				_localctx = new InsMientrasContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(201);
				cicloMientras();
				}
				break;
			case 15:
				_localctx = new InsHacerContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(202);
				cicloHacer();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FinContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(YParser.NEWLINE, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(YParser.PUNTO_COMA, 0); }
		public FinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterFin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitFin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitFin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinContext fin() throws RecognitionException {
		FinContext _localctx = new FinContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_fin);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_COMA) {
				{
				setState(205);
				match(PUNTO_COMA);
				}
			}

			setState(208);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionContext extends ParserRuleContext {
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
	 
		public DeclaracionContext() { }
		public void copyFrom(DeclaracionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclArregloContext extends DeclaracionContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public List<DimensionContext> dimension() {
			return getRuleContexts(DimensionContext.class);
		}
		public DimensionContext dimension(int i) {
			return getRuleContext(DimensionContext.class,i);
		}
		public TerminalNode IGUAL() { return getToken(YParser.IGUAL, 0); }
		public InicializadorContext inicializador() {
			return getRuleContext(InicializadorContext.class,0);
		}
		public DeclArregloContext(DeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterDeclArreglo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitDeclArreglo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitDeclArreglo(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclVariableContext extends DeclaracionContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public TerminalNode IGUAL() { return getToken(YParser.IGUAL, 0); }
		public InicializadorContext inicializador() {
			return getRuleContext(InicializadorContext.class,0);
		}
		public DeclVariableContext(DeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterDeclVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitDeclVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitDeclVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_declaracion);
		int _la;
		try {
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new DeclArregloContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				tipo();
				setState(211);
				match(ID);
				setState(213); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(212);
					dimension();
					}
					}
					setState(215); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COR_IZQ );
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IGUAL) {
					{
					setState(217);
					match(IGUAL);
					setState(218);
					inicializador();
					}
				}

				}
				break;
			case 2:
				_localctx = new DeclVariableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				tipo();
				setState(222);
				match(ID);
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IGUAL) {
					{
					setState(223);
					match(IGUAL);
					setState(224);
					inicializador();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DimensionContext extends ParserRuleContext {
		public TerminalNode COR_IZQ() { return getToken(YParser.COR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COR_DER() { return getToken(YParser.COR_DER, 0); }
		public DimensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterDimension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitDimension(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitDimension(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimensionContext dimension() throws RecognitionException {
		DimensionContext _localctx = new DimensionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_dimension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(COR_IZQ);
			setState(230);
			expr(0);
			setState(231);
			match(COR_DER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InicializadorContext extends ParserRuleContext {
		public InicializadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicializador; }
	 
		public InicializadorContext() { }
		public void copyFrom(InicializadorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IniExprContext extends InicializadorContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IniExprContext(InicializadorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterIniExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitIniExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitIniExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IniListaContext extends InicializadorContext {
		public TerminalNode LLA_IZQ() { return getToken(YParser.LLA_IZQ, 0); }
		public TerminalNode LLA_DER() { return getToken(YParser.LLA_DER, 0); }
		public List<InicializadorContext> inicializador() {
			return getRuleContexts(InicializadorContext.class);
		}
		public InicializadorContext inicializador(int i) {
			return getRuleContext(InicializadorContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(YParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(YParser.COMA, i);
		}
		public IniListaContext(InicializadorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterIniLista(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitIniLista(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitIniLista(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InicializadorContext inicializador() throws RecognitionException {
		InicializadorContext _localctx = new InicializadorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_inicializador);
		int _la;
		try {
			setState(246);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VERDADERO:
			case FALSO:
			case LEER:
			case NOT:
			case MENOS:
			case PAR_IZQ:
			case DECIMAL_LIT:
			case ENTERO_LIT:
			case CADENA_LIT:
			case CARACTER_LIT:
			case ID:
				_localctx = new IniExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
				expr(0);
				}
				break;
			case LLA_IZQ:
				_localctx = new IniListaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				match(LLA_IZQ);
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & 545650496274435L) != 0)) {
					{
					setState(235);
					inicializador();
					setState(240);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMA) {
						{
						{
						setState(236);
						match(COMA);
						setState(237);
						inicializador();
						}
						}
						setState(242);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(245);
				match(LLA_DER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AsignacionContext extends ParserRuleContext {
		public AccesoContext acceso() {
			return getRuleContext(AccesoContext.class,0);
		}
		public TerminalNode IGUAL() { return getToken(YParser.IGUAL, 0); }
		public InicializadorContext inicializador() {
			return getRuleContext(InicializadorContext.class,0);
		}
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitAsignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_asignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			acceso();
			setState(249);
			match(IGUAL);
			setState(250);
			inicializador();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IncrementoContext extends ParserRuleContext {
		public Token op;
		public AccesoContext acceso() {
			return getRuleContext(AccesoContext.class,0);
		}
		public TerminalNode INCREMENTO() { return getToken(YParser.INCREMENTO, 0); }
		public TerminalNode DECREMENTO() { return getToken(YParser.DECREMENTO, 0); }
		public IncrementoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incremento; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterIncremento(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitIncremento(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitIncremento(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncrementoContext incremento() throws RecognitionException {
		IncrementoContext _localctx = new IncrementoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_incremento);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			acceso();
			setState(253);
			((IncrementoContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==INCREMENTO || _la==DECREMENTO) ) {
				((IncrementoContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AccesoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public List<SufijoContext> sufijo() {
			return getRuleContexts(SufijoContext.class);
		}
		public SufijoContext sufijo(int i) {
			return getRuleContext(SufijoContext.class,i);
		}
		public AccesoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acceso; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterAcceso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitAcceso(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitAcceso(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccesoContext acceso() throws RecognitionException {
		AccesoContext _localctx = new AccesoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_acceso);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(ID);
			setState(259);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(256);
					sufijo();
					}
					} 
				}
				setState(261);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SufijoContext extends ParserRuleContext {
		public SufijoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sufijo; }
	 
		public SufijoContext() { }
		public void copyFrom(SufijoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SufIndiceContext extends SufijoContext {
		public TerminalNode COR_IZQ() { return getToken(YParser.COR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COR_DER() { return getToken(YParser.COR_DER, 0); }
		public SufIndiceContext(SufijoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterSufIndice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitSufIndice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitSufIndice(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SufCampoContext extends SufijoContext {
		public TerminalNode PUNTO() { return getToken(YParser.PUNTO, 0); }
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public SufCampoContext(SufijoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterSufCampo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitSufCampo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitSufCampo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SufijoContext sufijo() throws RecognitionException {
		SufijoContext _localctx = new SufijoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_sufijo);
		try {
			setState(268);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COR_IZQ:
				_localctx = new SufIndiceContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(262);
				match(COR_IZQ);
				setState(263);
				expr(0);
				setState(264);
				match(COR_DER);
				}
				break;
			case PUNTO:
				_localctx = new SufCampoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				match(PUNTO);
				setState(267);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LlamadaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public TerminalNode PAR_IZQ() { return getToken(YParser.PAR_IZQ, 0); }
		public TerminalNode PAR_DER() { return getToken(YParser.PAR_DER, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public LlamadaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llamada; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterLlamada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitLlamada(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitLlamada(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LlamadaContext llamada() throws RecognitionException {
		LlamadaContext _localctx = new LlamadaContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_llamada);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(ID);
			setState(271);
			match(PAR_IZQ);
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & 545375618367491L) != 0)) {
				{
				setState(272);
				argumentos();
				}
			}

			setState(275);
			match(PAR_DER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentosContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(YParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(YParser.COMA, i);
		}
		public ArgumentosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterArgumentos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitArgumentos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitArgumentos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentosContext argumentos() throws RecognitionException {
		ArgumentosContext _localctx = new ArgumentosContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_argumentos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			expr(0);
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(278);
				match(COMA);
				setState(279);
				expr(0);
				}
				}
				setState(284);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CondicionalContext extends ParserRuleContext {
		public TerminalNode SI() { return getToken(YParser.SI, 0); }
		public TerminalNode PAR_IZQ() { return getToken(YParser.PAR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_DER() { return getToken(YParser.PAR_DER, 0); }
		public TerminalNode ENTONCES() { return getToken(YParser.ENTONCES, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public List<SinoSiContext> sinoSi() {
			return getRuleContexts(SinoSiContext.class);
		}
		public SinoSiContext sinoSi(int i) {
			return getRuleContext(SinoSiContext.class,i);
		}
		public ContrarioContext contrario() {
			return getRuleContext(ContrarioContext.class,0);
		}
		public CondicionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterCondicional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitCondicional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitCondicional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondicionalContext condicional() throws RecognitionException {
		CondicionalContext _localctx = new CondicionalContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_condicional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(SI);
			setState(286);
			match(PAR_IZQ);
			setState(287);
			expr(0);
			setState(288);
			match(PAR_DER);
			setState(289);
			match(ENTONCES);
			setState(290);
			bloque();
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SINO) {
				{
				{
				setState(291);
				sinoSi();
				}
				}
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONTRARIO) {
				{
				setState(297);
				contrario();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SinoSiContext extends ParserRuleContext {
		public TerminalNode SINO() { return getToken(YParser.SINO, 0); }
		public TerminalNode PAR_IZQ() { return getToken(YParser.PAR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_DER() { return getToken(YParser.PAR_DER, 0); }
		public TerminalNode ENTONCES() { return getToken(YParser.ENTONCES, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public SinoSiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sinoSi; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterSinoSi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitSinoSi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitSinoSi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SinoSiContext sinoSi() throws RecognitionException {
		SinoSiContext _localctx = new SinoSiContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_sinoSi);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(SINO);
			setState(301);
			match(PAR_IZQ);
			setState(302);
			expr(0);
			setState(303);
			match(PAR_DER);
			setState(304);
			match(ENTONCES);
			setState(305);
			bloque();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContrarioContext extends ParserRuleContext {
		public TerminalNode CONTRARIO() { return getToken(YParser.CONTRARIO, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public TerminalNode DOSPUNTOS() { return getToken(YParser.DOSPUNTOS, 0); }
		public ContrarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contrario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterContrario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitContrario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitContrario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContrarioContext contrario() throws RecognitionException {
		ContrarioContext _localctx = new ContrarioContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_contrario);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			match(CONTRARIO);
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOSPUNTOS) {
				{
				setState(308);
				match(DOSPUNTOS);
				}
			}

			setState(311);
			bloque();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SeleccionContext extends ParserRuleContext {
		public TerminalNode ELEGIR() { return getToken(YParser.ELEGIR, 0); }
		public TerminalNode PAR_IZQ() { return getToken(YParser.PAR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_DER() { return getToken(YParser.PAR_DER, 0); }
		public TerminalNode DOSPUNTOS() { return getToken(YParser.DOSPUNTOS, 0); }
		public TerminalNode NEWLINE() { return getToken(YParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(YParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(YParser.DEDENT, 0); }
		public List<CasoContext> caso() {
			return getRuleContexts(CasoContext.class);
		}
		public CasoContext caso(int i) {
			return getRuleContext(CasoContext.class,i);
		}
		public CasoDefectoContext casoDefecto() {
			return getRuleContext(CasoDefectoContext.class,0);
		}
		public SeleccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seleccion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterSeleccion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitSeleccion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitSeleccion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeleccionContext seleccion() throws RecognitionException {
		SeleccionContext _localctx = new SeleccionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_seleccion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			match(ELEGIR);
			setState(314);
			match(PAR_IZQ);
			setState(315);
			expr(0);
			setState(316);
			match(PAR_DER);
			setState(317);
			match(DOSPUNTOS);
			setState(318);
			match(NEWLINE);
			setState(319);
			match(INDENT);
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASO) {
				{
				{
				setState(320);
				caso();
				}
				}
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SIEMPRE) {
				{
				setState(326);
				casoDefecto();
				}
			}

			setState(329);
			match(DEDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CasoContext extends ParserRuleContext {
		public TerminalNode CASO() { return getToken(YParser.CASO, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DOSPUNTOS() { return getToken(YParser.DOSPUNTOS, 0); }
		public CuerpoCasoContext cuerpoCaso() {
			return getRuleContext(CuerpoCasoContext.class,0);
		}
		public CasoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caso; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterCaso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitCaso(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitCaso(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CasoContext caso() throws RecognitionException {
		CasoContext _localctx = new CasoContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_caso);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			match(CASO);
			setState(332);
			expr(0);
			setState(333);
			match(DOSPUNTOS);
			setState(334);
			cuerpoCaso();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CasoDefectoContext extends ParserRuleContext {
		public TerminalNode SIEMPRE() { return getToken(YParser.SIEMPRE, 0); }
		public TerminalNode DOSPUNTOS() { return getToken(YParser.DOSPUNTOS, 0); }
		public CuerpoCasoContext cuerpoCaso() {
			return getRuleContext(CuerpoCasoContext.class,0);
		}
		public CasoDefectoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_casoDefecto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterCasoDefecto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitCasoDefecto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitCasoDefecto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CasoDefectoContext casoDefecto() throws RecognitionException {
		CasoDefectoContext _localctx = new CasoDefectoContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_casoDefecto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(SIEMPRE);
			setState(337);
			match(DOSPUNTOS);
			setState(338);
			cuerpoCaso();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CuerpoCasoContext extends ParserRuleContext {
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(YParser.NEWLINE, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public CuerpoCasoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cuerpoCaso; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterCuerpoCaso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitCuerpoCaso(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitCuerpoCaso(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CuerpoCasoContext cuerpoCaso() throws RecognitionException {
		CuerpoCasoContext _localctx = new CuerpoCasoContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_cuerpoCaso);
		int _la;
		try {
			setState(348);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(340);
				bloque();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(341);
				match(NEWLINE);
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & 72057594054591741L) != 0)) {
					{
					{
					setState(342);
					instruccion();
					}
					}
					setState(347);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CicloParaContext extends ParserRuleContext {
		public TerminalNode PARA() { return getToken(YParser.PARA, 0); }
		public TerminalNode PAR_IZQ() { return getToken(YParser.PAR_IZQ, 0); }
		public List<TerminalNode> PUNTO_COMA() { return getTokens(YParser.PUNTO_COMA); }
		public TerminalNode PUNTO_COMA(int i) {
			return getToken(YParser.PUNTO_COMA, i);
		}
		public TerminalNode PAR_DER() { return getToken(YParser.PAR_DER, 0); }
		public TerminalNode DOSPUNTOS() { return getToken(YParser.DOSPUNTOS, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public InicioParaContext inicioPara() {
			return getRuleContext(InicioParaContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ActualizacionParaContext actualizacionPara() {
			return getRuleContext(ActualizacionParaContext.class,0);
		}
		public CicloParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cicloPara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterCicloPara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitCicloPara(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitCicloPara(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CicloParaContext cicloPara() throws RecognitionException {
		CicloParaContext _localctx = new CicloParaContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_cicloPara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			match(PARA);
			setState(351);
			match(PAR_IZQ);
			setState(353);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & 9007199254741023L) != 0)) {
				{
				setState(352);
				inicioPara();
				}
			}

			setState(355);
			match(PUNTO_COMA);
			setState(357);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & 545375618367491L) != 0)) {
				{
				setState(356);
				expr(0);
				}
			}

			setState(359);
			match(PUNTO_COMA);
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(360);
				actualizacionPara();
				}
			}

			setState(363);
			match(PAR_DER);
			setState(364);
			match(DOSPUNTOS);
			setState(365);
			bloque();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InicioParaContext extends ParserRuleContext {
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public InicioParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicioPara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterInicioPara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitInicioPara(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitInicioPara(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InicioParaContext inicioPara() throws RecognitionException {
		InicioParaContext _localctx = new InicioParaContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_inicioPara);
		try {
			setState(369);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(367);
				declaracion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(368);
				asignacion();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ActualizacionParaContext extends ParserRuleContext {
		public IncrementoContext incremento() {
			return getRuleContext(IncrementoContext.class,0);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public ActualizacionParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualizacionPara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterActualizacionPara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitActualizacionPara(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitActualizacionPara(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActualizacionParaContext actualizacionPara() throws RecognitionException {
		ActualizacionParaContext _localctx = new ActualizacionParaContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_actualizacionPara);
		try {
			setState(373);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(371);
				incremento();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(372);
				asignacion();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CicloMientrasContext extends ParserRuleContext {
		public TerminalNode MIENTRAS() { return getToken(YParser.MIENTRAS, 0); }
		public TerminalNode PAR_IZQ() { return getToken(YParser.PAR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_DER() { return getToken(YParser.PAR_DER, 0); }
		public TerminalNode HACER() { return getToken(YParser.HACER, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public TerminalNode DOSPUNTOS() { return getToken(YParser.DOSPUNTOS, 0); }
		public CicloMientrasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cicloMientras; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterCicloMientras(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitCicloMientras(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitCicloMientras(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CicloMientrasContext cicloMientras() throws RecognitionException {
		CicloMientrasContext _localctx = new CicloMientrasContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_cicloMientras);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			match(MIENTRAS);
			setState(376);
			match(PAR_IZQ);
			setState(377);
			expr(0);
			setState(378);
			match(PAR_DER);
			setState(379);
			match(HACER);
			setState(381);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOSPUNTOS) {
				{
				setState(380);
				match(DOSPUNTOS);
				}
			}

			setState(383);
			bloque();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CicloHacerContext extends ParserRuleContext {
		public TerminalNode HACER() { return getToken(YParser.HACER, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public TerminalNode MIENTRAS() { return getToken(YParser.MIENTRAS, 0); }
		public TerminalNode PAR_IZQ() { return getToken(YParser.PAR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_DER() { return getToken(YParser.PAR_DER, 0); }
		public FinContext fin() {
			return getRuleContext(FinContext.class,0);
		}
		public TerminalNode DOSPUNTOS() { return getToken(YParser.DOSPUNTOS, 0); }
		public CicloHacerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cicloHacer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterCicloHacer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitCicloHacer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitCicloHacer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CicloHacerContext cicloHacer() throws RecognitionException {
		CicloHacerContext _localctx = new CicloHacerContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_cicloHacer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			match(HACER);
			setState(387);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOSPUNTOS) {
				{
				setState(386);
				match(DOSPUNTOS);
				}
			}

			setState(389);
			bloque();
			setState(390);
			match(MIENTRAS);
			setState(391);
			match(PAR_IZQ);
			setState(392);
			expr(0);
			setState(393);
			match(PAR_DER);
			setState(394);
			fin();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprLeerContext extends ExprContext {
		public TerminalNode LEER() { return getToken(YParser.LEER, 0); }
		public TerminalNode PAR_IZQ() { return getToken(YParser.PAR_IZQ, 0); }
		public TerminalNode PAR_DER() { return getToken(YParser.PAR_DER, 0); }
		public ExprLeerContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExprLeer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExprLeer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExprLeer(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprLlamadaContext extends ExprContext {
		public LlamadaContext llamada() {
			return getRuleContext(LlamadaContext.class,0);
		}
		public ExprLlamadaContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExprLlamada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExprLlamada(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExprLlamada(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAccesoContext extends ExprContext {
		public AccesoContext acceso() {
			return getRuleContext(AccesoContext.class,0);
		}
		public ExprAccesoContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExprAcceso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExprAcceso(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExprAcceso(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprOrContext extends ExprContext {
		public ExprContext izq;
		public Token op;
		public ExprContext der;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(YParser.OR, 0); }
		public ExprOrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExprOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExprOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExprOr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAditivaContext extends ExprContext {
		public ExprContext izq;
		public Token op;
		public ExprContext der;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MAS() { return getToken(YParser.MAS, 0); }
		public TerminalNode MENOS() { return getToken(YParser.MENOS, 0); }
		public ExprAditivaContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExprAditiva(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExprAditiva(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExprAditiva(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprRelacionalContext extends ExprContext {
		public ExprContext izq;
		public Token op;
		public ExprContext der;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MENOR() { return getToken(YParser.MENOR, 0); }
		public TerminalNode MAYOR() { return getToken(YParser.MAYOR, 0); }
		public TerminalNode MENOR_IGUAL() { return getToken(YParser.MENOR_IGUAL, 0); }
		public TerminalNode MAYOR_IGUAL() { return getToken(YParser.MAYOR_IGUAL, 0); }
		public ExprRelacionalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExprRelacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExprRelacional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExprRelacional(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprIgualdadContext extends ExprContext {
		public ExprContext izq;
		public Token op;
		public ExprContext der;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IGUAL_IGUAL() { return getToken(YParser.IGUAL_IGUAL, 0); }
		public TerminalNode DIFERENTE() { return getToken(YParser.DIFERENTE, 0); }
		public ExprIgualdadContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExprIgualdad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExprIgualdad(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExprIgualdad(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprParentesisContext extends ExprContext {
		public TerminalNode PAR_IZQ() { return getToken(YParser.PAR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_DER() { return getToken(YParser.PAR_DER, 0); }
		public ExprParentesisContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExprParentesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExprParentesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExprParentesis(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprUnariaContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(YParser.NOT, 0); }
		public TerminalNode MENOS() { return getToken(YParser.MENOS, 0); }
		public ExprUnariaContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExprUnaria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExprUnaria(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExprUnaria(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAndContext extends ExprContext {
		public ExprContext izq;
		public Token op;
		public ExprContext der;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(YParser.AND, 0); }
		public ExprAndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExprAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExprAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExprAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprLiteralContext extends ExprContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ExprLiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExprLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExprLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExprLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprMultiplicativaContext extends ExprContext {
		public ExprContext izq;
		public Token op;
		public ExprContext der;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULT() { return getToken(YParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(YParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(YParser.MOD, 0); }
		public ExprMultiplicativaContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExprMultiplicativa(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExprMultiplicativa(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExprMultiplicativa(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				_localctx = new ExprParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(397);
				match(PAR_IZQ);
				setState(398);
				expr(0);
				setState(399);
				match(PAR_DER);
				}
				break;
			case 2:
				{
				_localctx = new ExprLlamadaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(401);
				llamada();
				}
				break;
			case 3:
				{
				_localctx = new ExprLeerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(402);
				match(LEER);
				setState(403);
				match(PAR_IZQ);
				setState(404);
				match(PAR_DER);
				}
				break;
			case 4:
				{
				_localctx = new ExprAccesoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(405);
				acceso();
				}
				break;
			case 5:
				{
				_localctx = new ExprLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(406);
				literal();
				}
				break;
			case 6:
				{
				_localctx = new ExprUnariaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(407);
				((ExprUnariaContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NOT || _la==MENOS) ) {
					((ExprUnariaContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(408);
				expr(7);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(431);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(429);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMultiplicativaContext(new ExprContext(_parentctx, _parentState));
						((ExprMultiplicativaContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(411);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(412);
						((ExprMultiplicativaContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 985162418487296L) != 0)) ) {
							((ExprMultiplicativaContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(413);
						((ExprMultiplicativaContext)_localctx).der = expr(7);
						}
						break;
					case 2:
						{
						_localctx = new ExprAditivaContext(new ExprContext(_parentctx, _parentState));
						((ExprAditivaContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(414);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(415);
						((ExprAditivaContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MAS || _la==MENOS) ) {
							((ExprAditivaContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(416);
						((ExprAditivaContext)_localctx).der = expr(6);
						}
						break;
					case 3:
						{
						_localctx = new ExprRelacionalContext(new ExprContext(_parentctx, _parentState));
						((ExprRelacionalContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(417);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(418);
						((ExprRelacionalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4123168604160L) != 0)) ) {
							((ExprRelacionalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(419);
						((ExprRelacionalContext)_localctx).der = expr(5);
						}
						break;
					case 4:
						{
						_localctx = new ExprIgualdadContext(new ExprContext(_parentctx, _parentState));
						((ExprIgualdadContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(420);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(421);
						((ExprIgualdadContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==IGUAL_IGUAL || _la==DIFERENTE) ) {
							((ExprIgualdadContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(422);
						((ExprIgualdadContext)_localctx).der = expr(4);
						}
						break;
					case 5:
						{
						_localctx = new ExprAndContext(new ExprContext(_parentctx, _parentState));
						((ExprAndContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(423);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(424);
						((ExprAndContext)_localctx).op = match(AND);
						setState(425);
						((ExprAndContext)_localctx).der = expr(3);
						}
						break;
					case 6:
						{
						_localctx = new ExprOrContext(new ExprContext(_parentctx, _parentState));
						((ExprOrContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(426);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(427);
						((ExprOrContext)_localctx).op = match(OR);
						setState(428);
						((ExprOrContext)_localctx).der = expr(2);
						}
						break;
					}
					} 
				}
				setState(433);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode ENTERO_LIT() { return getToken(YParser.ENTERO_LIT, 0); }
		public TerminalNode DECIMAL_LIT() { return getToken(YParser.DECIMAL_LIT, 0); }
		public TerminalNode CADENA_LIT() { return getToken(YParser.CADENA_LIT, 0); }
		public TerminalNode CARACTER_LIT() { return getToken(YParser.CARACTER_LIT, 0); }
		public TerminalNode VERDADERO() { return getToken(YParser.VERDADERO, 0); }
		public TerminalNode FALSO() { return getToken(YParser.FALSO, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			_la = _input.LA(1);
			if ( !(((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & 263882790666243L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TipoPrimitivoContext tipoPrimitivo() {
			return getRuleContext(TipoPrimitivoContext.class,0);
		}
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_tipo);
		try {
			setState(438);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ENTERO:
			case FLOTANTE:
			case CADENA:
			case CARACTER:
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(436);
				tipoPrimitivo();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(437);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoPrimitivoContext extends ParserRuleContext {
		public TerminalNode ENTERO() { return getToken(YParser.ENTERO, 0); }
		public TerminalNode FLOTANTE() { return getToken(YParser.FLOTANTE, 0); }
		public TerminalNode CADENA() { return getToken(YParser.CADENA, 0); }
		public TerminalNode CARACTER() { return getToken(YParser.CARACTER, 0); }
		public TerminalNode BOOL() { return getToken(YParser.BOOL, 0); }
		public TipoPrimitivoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipoPrimitivo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterTipoPrimitivo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitTipoPrimitivo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitTipoPrimitivo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoPrimitivoContext tipoPrimitivo() throws RecognitionException {
		TipoPrimitivoContext _localctx = new TipoPrimitivoContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_tipoPrimitivo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 126976L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 32:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001B\u01bb\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0001\u0000\u0003\u0000J\b\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001R\b\u0001\n\u0001"+
		"\f\u0001U\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002Z\b\u0002"+
		"\n\u0002\f\u0002]\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0004\u0003e\b\u0003\u000b\u0003\f\u0003f\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004n\b"+
		"\u0004\n\u0004\f\u0004q\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005y\b\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005~\b\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u0086\b\u0006\n"+
		"\u0006\f\u0006\u0089\t\u0006\u0001\u0007\u0001\u0007\u0004\u0007\u008d"+
		"\b\u0007\u000b\u0007\f\u0007\u008e\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u009b\b\u0007\u0001\b\u0001\b\u0001\b\u0004\b"+
		"\u00a0\b\b\u000b\b\f\b\u00a1\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0003\t\u00b6\b\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00c0\b\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00cc"+
		"\b\t\u0001\n\u0003\n\u00cf\b\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0004\u000b\u00d6\b\u000b\u000b\u000b\f\u000b\u00d7\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u00dc\b\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u00e2\b\u000b\u0003\u000b\u00e4\b\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u00ef\b\r\n\r\f\r\u00f2\t\r\u0003\r\u00f4\b\r\u0001\r\u0003"+
		"\r\u00f7\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0005\u0010\u0102\b\u0010"+
		"\n\u0010\f\u0010\u0105\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u010d\b\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u0112\b\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u0119\b\u0013\n\u0013\f\u0013"+
		"\u011c\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0005\u0014\u0125\b\u0014\n\u0014\f\u0014\u0128"+
		"\t\u0014\u0001\u0014\u0003\u0014\u012b\b\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0003\u0016\u0136\b\u0016\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0005\u0017\u0142\b\u0017\n\u0017\f\u0017\u0145\t\u0017\u0001"+
		"\u0017\u0003\u0017\u0148\b\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u0158"+
		"\b\u001a\n\u001a\f\u001a\u015b\t\u001a\u0003\u001a\u015d\b\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u0162\b\u001b\u0001\u001b\u0001"+
		"\u001b\u0003\u001b\u0166\b\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u016a"+
		"\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001"+
		"\u001c\u0003\u001c\u0172\b\u001c\u0001\u001d\u0001\u001d\u0003\u001d\u0176"+
		"\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0003\u001e\u017e\b\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001"+
		"\u001f\u0003\u001f\u0184\b\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0003"+
		" \u019a\b \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0005"+
		" \u01ae\b \n \f \u01b1\t \u0001!\u0001!\u0001\"\u0001\"\u0003\"\u01b7"+
		"\b\"\u0001#\u0001#\u0001#\u0000\u0001@$\u0000\u0002\u0004\u0006\b\n\f"+
		"\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:"+
		"<>@BDF\u0000\b\u0001\u0000!\"\u0002\u0000,,..\u0001\u0000/1\u0001\u0000"+
		"-.\u0001\u0000&)\u0001\u0000$%\u0002\u0000\u0011\u0012=@\u0001\u0000\f"+
		"\u0010\u01d8\u0000I\u0001\u0000\u0000\u0000\u0002N\u0001\u0000\u0000\u0000"+
		"\u0004V\u0001\u0000\u0000\u0000\u0006^\u0001\u0000\u0000\u0000\bj\u0001"+
		"\u0000\u0000\u0000\nt\u0001\u0000\u0000\u0000\f\u0082\u0001\u0000\u0000"+
		"\u0000\u000e\u009a\u0001\u0000\u0000\u0000\u0010\u009c\u0001\u0000\u0000"+
		"\u0000\u0012\u00cb\u0001\u0000\u0000\u0000\u0014\u00ce\u0001\u0000\u0000"+
		"\u0000\u0016\u00e3\u0001\u0000\u0000\u0000\u0018\u00e5\u0001\u0000\u0000"+
		"\u0000\u001a\u00f6\u0001\u0000\u0000\u0000\u001c\u00f8\u0001\u0000\u0000"+
		"\u0000\u001e\u00fc\u0001\u0000\u0000\u0000 \u00ff\u0001\u0000\u0000\u0000"+
		"\"\u010c\u0001\u0000\u0000\u0000$\u010e\u0001\u0000\u0000\u0000&\u0115"+
		"\u0001\u0000\u0000\u0000(\u011d\u0001\u0000\u0000\u0000*\u012c\u0001\u0000"+
		"\u0000\u0000,\u0133\u0001\u0000\u0000\u0000.\u0139\u0001\u0000\u0000\u0000"+
		"0\u014b\u0001\u0000\u0000\u00002\u0150\u0001\u0000\u0000\u00004\u015c"+
		"\u0001\u0000\u0000\u00006\u015e\u0001\u0000\u0000\u00008\u0171\u0001\u0000"+
		"\u0000\u0000:\u0175\u0001\u0000\u0000\u0000<\u0177\u0001\u0000\u0000\u0000"+
		">\u0181\u0001\u0000\u0000\u0000@\u0199\u0001\u0000\u0000\u0000B\u01b2"+
		"\u0001\u0000\u0000\u0000D\u01b6\u0001\u0000\u0000\u0000F\u01b8\u0001\u0000"+
		"\u0000\u0000HJ\u0003\u0002\u0001\u0000IH\u0001\u0000\u0000\u0000IJ\u0001"+
		"\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KL\u0003\u0004\u0002\u0000"+
		"LM\u0005\u0000\u0000\u0001M\u0001\u0001\u0000\u0000\u0000NO\u0005\u0007"+
		"\u0000\u0000OS\u0005\u0005\u0000\u0000PR\u0003\u0006\u0003\u0000QP\u0001"+
		"\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000"+
		"ST\u0001\u0000\u0000\u0000T\u0003\u0001\u0000\u0000\u0000US\u0001\u0000"+
		"\u0000\u0000VW\u0005\b\u0000\u0000W[\u0005\u0005\u0000\u0000XZ\u0003\n"+
		"\u0005\u0000YX\u0001\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001"+
		"\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\\u0005\u0001\u0000\u0000"+
		"\u0000][\u0001\u0000\u0000\u0000^_\u0005\t\u0000\u0000_`\u0005A\u0000"+
		"\u0000`a\u0005;\u0000\u0000ab\u0005\u0005\u0000\u0000bd\u0005\u0001\u0000"+
		"\u0000ce\u0003\b\u0004\u0000dc\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000"+
		"\u0000fd\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0001\u0000"+
		"\u0000\u0000hi\u0005\u0002\u0000\u0000i\u0007\u0001\u0000\u0000\u0000"+
		"jk\u0003D\"\u0000ko\u0005A\u0000\u0000ln\u0003\u0018\f\u0000ml\u0001\u0000"+
		"\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001"+
		"\u0000\u0000\u0000pr\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000"+
		"rs\u0003\u0014\n\u0000s\t\u0001\u0000\u0000\u0000tu\u0005\n\u0000\u0000"+
		"uv\u0005A\u0000\u0000vx\u00053\u0000\u0000wy\u0003\f\u0006\u0000xw\u0001"+
		"\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000"+
		"z}\u00054\u0000\u0000{|\u0005#\u0000\u0000|~\u0003D\"\u0000}{\u0001\u0000"+
		"\u0000\u0000}~\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000"+
		"\u007f\u0080\u0005;\u0000\u0000\u0080\u0081\u0003\u0010\b\u0000\u0081"+
		"\u000b\u0001\u0000\u0000\u0000\u0082\u0087\u0003\u000e\u0007\u0000\u0083"+
		"\u0084\u0005:\u0000\u0000\u0084\u0086\u0003\u000e\u0007\u0000\u0085\u0083"+
		"\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087\u0085"+
		"\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\r\u0001"+
		"\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a\u008b\u0005"+
		"5\u0000\u0000\u008b\u008d\u00056\u0000\u0000\u008c\u008a\u0001\u0000\u0000"+
		"\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000"+
		"\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0003D\"\u0000\u0091\u0092\u0005A\u0000\u0000\u0092"+
		"\u009b\u0001\u0000\u0000\u0000\u0093\u0094\u00057\u0000\u0000\u0094\u0095"+
		"\u00058\u0000\u0000\u0095\u0096\u0005A\u0000\u0000\u0096\u009b\u0005A"+
		"\u0000\u0000\u0097\u0098\u0003F#\u0000\u0098\u0099\u0005A\u0000\u0000"+
		"\u0099\u009b\u0001\u0000\u0000\u0000\u009a\u008c\u0001\u0000\u0000\u0000"+
		"\u009a\u0093\u0001\u0000\u0000\u0000\u009a\u0097\u0001\u0000\u0000\u0000"+
		"\u009b\u000f\u0001\u0000\u0000\u0000\u009c\u009d\u0005\u0005\u0000\u0000"+
		"\u009d\u009f\u0005\u0001\u0000\u0000\u009e\u00a0\u0003\u0012\t\u0000\u009f"+
		"\u009e\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1"+
		"\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005\u0002\u0000\u0000\u00a4"+
		"\u0011\u0001\u0000\u0000\u0000\u00a5\u00cc\u0003\u0006\u0003\u0000\u00a6"+
		"\u00a7\u0003\u0016\u000b\u0000\u00a7\u00a8\u0003\u0014\n\u0000\u00a8\u00cc"+
		"\u0001\u0000\u0000\u0000\u00a9\u00aa\u0003\u001c\u000e\u0000\u00aa\u00ab"+
		"\u0003\u0014\n\u0000\u00ab\u00cc\u0001\u0000\u0000\u0000\u00ac\u00ad\u0003"+
		"\u001e\u000f\u0000\u00ad\u00ae\u0003\u0014\n\u0000\u00ae\u00cc\u0001\u0000"+
		"\u0000\u0000\u00af\u00b0\u0003$\u0012\u0000\u00b0\u00b1\u0003\u0014\n"+
		"\u0000\u00b1\u00cc\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005\u001f\u0000"+
		"\u0000\u00b3\u00b5\u00053\u0000\u0000\u00b4\u00b6\u0003@ \u0000\u00b5"+
		"\u00b4\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b8\u00054\u0000\u0000\u00b8\u00cc"+
		"\u0003\u0014\n\u0000\u00b9\u00ba\u0005 \u0000\u0000\u00ba\u00bb\u0005"+
		"3\u0000\u0000\u00bb\u00bc\u00054\u0000\u0000\u00bc\u00cc\u0003\u0014\n"+
		"\u0000\u00bd\u00bf\u0005\u000b\u0000\u0000\u00be\u00c0\u0003@ \u0000\u00bf"+
		"\u00be\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c1\u00cc\u0003\u0014\n\u0000\u00c2\u00c3"+
		"\u0005\u001a\u0000\u0000\u00c3\u00cc\u0003\u0014\n\u0000\u00c4\u00c5\u0005"+
		"\u001b\u0000\u0000\u00c5\u00cc\u0003\u0014\n\u0000\u00c6\u00cc\u0003("+
		"\u0014\u0000\u00c7\u00cc\u0003.\u0017\u0000\u00c8\u00cc\u00036\u001b\u0000"+
		"\u00c9\u00cc\u0003<\u001e\u0000\u00ca\u00cc\u0003>\u001f\u0000\u00cb\u00a5"+
		"\u0001\u0000\u0000\u0000\u00cb\u00a6\u0001\u0000\u0000\u0000\u00cb\u00a9"+
		"\u0001\u0000\u0000\u0000\u00cb\u00ac\u0001\u0000\u0000\u0000\u00cb\u00af"+
		"\u0001\u0000\u0000\u0000\u00cb\u00b2\u0001\u0000\u0000\u0000\u00cb\u00b9"+
		"\u0001\u0000\u0000\u0000\u00cb\u00bd\u0001\u0000\u0000\u0000\u00cb\u00c2"+
		"\u0001\u0000\u0000\u0000\u00cb\u00c4\u0001\u0000\u0000\u0000\u00cb\u00c6"+
		"\u0001\u0000\u0000\u0000\u00cb\u00c7\u0001\u0000\u0000\u0000\u00cb\u00c8"+
		"\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cb\u00ca"+
		"\u0001\u0000\u0000\u0000\u00cc\u0013\u0001\u0000\u0000\u0000\u00cd\u00cf"+
		"\u0005<\u0000\u0000\u00ce\u00cd\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u00d1\u0005"+
		"\u0005\u0000\u0000\u00d1\u0015\u0001\u0000\u0000\u0000\u00d2\u00d3\u0003"+
		"D\"\u0000\u00d3\u00d5\u0005A\u0000\u0000\u00d4\u00d6\u0003\u0018\f\u0000"+
		"\u00d5\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000"+
		"\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000"+
		"\u00d8\u00db\u0001\u0000\u0000\u0000\u00d9\u00da\u00052\u0000\u0000\u00da"+
		"\u00dc\u0003\u001a\r\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00db\u00dc"+
		"\u0001\u0000\u0000\u0000\u00dc\u00e4\u0001\u0000\u0000\u0000\u00dd\u00de"+
		"\u0003D\"\u0000\u00de\u00e1\u0005A\u0000\u0000\u00df\u00e0\u00052\u0000"+
		"\u0000\u00e0\u00e2\u0003\u001a\r\u0000\u00e1\u00df\u0001\u0000\u0000\u0000"+
		"\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e3\u00d2\u0001\u0000\u0000\u0000\u00e3\u00dd\u0001\u0000\u0000\u0000"+
		"\u00e4\u0017\u0001\u0000\u0000\u0000\u00e5\u00e6\u00055\u0000\u0000\u00e6"+
		"\u00e7\u0003@ \u0000\u00e7\u00e8\u00056\u0000\u0000\u00e8\u0019\u0001"+
		"\u0000\u0000\u0000\u00e9\u00f7\u0003@ \u0000\u00ea\u00f3\u00057\u0000"+
		"\u0000\u00eb\u00f0\u0003\u001a\r\u0000\u00ec\u00ed\u0005:\u0000\u0000"+
		"\u00ed\u00ef\u0003\u001a\r\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ef"+
		"\u00f2\u0001\u0000\u0000\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f0"+
		"\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f4\u0001\u0000\u0000\u0000\u00f2"+
		"\u00f0\u0001\u0000\u0000\u0000\u00f3\u00eb\u0001\u0000\u0000\u0000\u00f3"+
		"\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5"+
		"\u00f7\u00058\u0000\u0000\u00f6\u00e9\u0001\u0000\u0000\u0000\u00f6\u00ea"+
		"\u0001\u0000\u0000\u0000\u00f7\u001b\u0001\u0000\u0000\u0000\u00f8\u00f9"+
		"\u0003 \u0010\u0000\u00f9\u00fa\u00052\u0000\u0000\u00fa\u00fb\u0003\u001a"+
		"\r\u0000\u00fb\u001d\u0001\u0000\u0000\u0000\u00fc\u00fd\u0003 \u0010"+
		"\u0000\u00fd\u00fe\u0007\u0000\u0000\u0000\u00fe\u001f\u0001\u0000\u0000"+
		"\u0000\u00ff\u0103\u0005A\u0000\u0000\u0100\u0102\u0003\"\u0011\u0000"+
		"\u0101\u0100\u0001\u0000\u0000\u0000\u0102\u0105\u0001\u0000\u0000\u0000"+
		"\u0103\u0101\u0001\u0000\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000"+
		"\u0104!\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000\u0000\u0106"+
		"\u0107\u00055\u0000\u0000\u0107\u0108\u0003@ \u0000\u0108\u0109\u0005"+
		"6\u0000\u0000\u0109\u010d\u0001\u0000\u0000\u0000\u010a\u010b\u00059\u0000"+
		"\u0000\u010b\u010d\u0005A\u0000\u0000\u010c\u0106\u0001\u0000\u0000\u0000"+
		"\u010c\u010a\u0001\u0000\u0000\u0000\u010d#\u0001\u0000\u0000\u0000\u010e"+
		"\u010f\u0005A\u0000\u0000\u010f\u0111\u00053\u0000\u0000\u0110\u0112\u0003"+
		"&\u0013\u0000\u0111\u0110\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000"+
		"\u0000\u0000\u0112\u0113\u0001\u0000\u0000\u0000\u0113\u0114\u00054\u0000"+
		"\u0000\u0114%\u0001\u0000\u0000\u0000\u0115\u011a\u0003@ \u0000\u0116"+
		"\u0117\u0005:\u0000\u0000\u0117\u0119\u0003@ \u0000\u0118\u0116\u0001"+
		"\u0000\u0000\u0000\u0119\u011c\u0001\u0000\u0000\u0000\u011a\u0118\u0001"+
		"\u0000\u0000\u0000\u011a\u011b\u0001\u0000\u0000\u0000\u011b\'\u0001\u0000"+
		"\u0000\u0000\u011c\u011a\u0001\u0000\u0000\u0000\u011d\u011e\u0005\u0013"+
		"\u0000\u0000\u011e\u011f\u00053\u0000\u0000\u011f\u0120\u0003@ \u0000"+
		"\u0120\u0121\u00054\u0000\u0000\u0121\u0122\u0005\u0014\u0000\u0000\u0122"+
		"\u0126\u0003\u0010\b\u0000\u0123\u0125\u0003*\u0015\u0000\u0124\u0123"+
		"\u0001\u0000\u0000\u0000\u0125\u0128\u0001\u0000\u0000\u0000\u0126\u0124"+
		"\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127\u012a"+
		"\u0001\u0000\u0000\u0000\u0128\u0126\u0001\u0000\u0000\u0000\u0129\u012b"+
		"\u0003,\u0016\u0000\u012a\u0129\u0001\u0000\u0000\u0000\u012a\u012b\u0001"+
		"\u0000\u0000\u0000\u012b)\u0001\u0000\u0000\u0000\u012c\u012d\u0005\u0015"+
		"\u0000\u0000\u012d\u012e\u00053\u0000\u0000\u012e\u012f\u0003@ \u0000"+
		"\u012f\u0130\u00054\u0000\u0000\u0130\u0131\u0005\u0014\u0000\u0000\u0131"+
		"\u0132\u0003\u0010\b\u0000\u0132+\u0001\u0000\u0000\u0000\u0133\u0135"+
		"\u0005\u0016\u0000\u0000\u0134\u0136\u0005;\u0000\u0000\u0135\u0134\u0001"+
		"\u0000\u0000\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u0136\u0137\u0001"+
		"\u0000\u0000\u0000\u0137\u0138\u0003\u0010\b\u0000\u0138-\u0001\u0000"+
		"\u0000\u0000\u0139\u013a\u0005\u0017\u0000\u0000\u013a\u013b\u00053\u0000"+
		"\u0000\u013b\u013c\u0003@ \u0000\u013c\u013d\u00054\u0000\u0000\u013d"+
		"\u013e\u0005;\u0000\u0000\u013e\u013f\u0005\u0005\u0000\u0000\u013f\u0143"+
		"\u0005\u0001\u0000\u0000\u0140\u0142\u00030\u0018\u0000\u0141\u0140\u0001"+
		"\u0000\u0000\u0000\u0142\u0145\u0001\u0000\u0000\u0000\u0143\u0141\u0001"+
		"\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000\u0000\u0144\u0147\u0001"+
		"\u0000\u0000\u0000\u0145\u0143\u0001\u0000\u0000\u0000\u0146\u0148\u0003"+
		"2\u0019\u0000\u0147\u0146\u0001\u0000\u0000\u0000\u0147\u0148\u0001\u0000"+
		"\u0000\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u014a\u0005\u0002"+
		"\u0000\u0000\u014a/\u0001\u0000\u0000\u0000\u014b\u014c\u0005\u0018\u0000"+
		"\u0000\u014c\u014d\u0003@ \u0000\u014d\u014e\u0005;\u0000\u0000\u014e"+
		"\u014f\u00034\u001a\u0000\u014f1\u0001\u0000\u0000\u0000\u0150\u0151\u0005"+
		"\u0019\u0000\u0000\u0151\u0152\u0005;\u0000\u0000\u0152\u0153\u00034\u001a"+
		"\u0000\u01533\u0001\u0000\u0000\u0000\u0154\u015d\u0003\u0010\b\u0000"+
		"\u0155\u0159\u0005\u0005\u0000\u0000\u0156\u0158\u0003\u0012\t\u0000\u0157"+
		"\u0156\u0001\u0000\u0000\u0000\u0158\u015b\u0001\u0000\u0000\u0000\u0159"+
		"\u0157\u0001\u0000\u0000\u0000\u0159\u015a\u0001\u0000\u0000\u0000\u015a"+
		"\u015d\u0001\u0000\u0000\u0000\u015b\u0159\u0001\u0000\u0000\u0000\u015c"+
		"\u0154\u0001\u0000\u0000\u0000\u015c\u0155\u0001\u0000\u0000\u0000\u015d"+
		"5\u0001\u0000\u0000\u0000\u015e\u015f\u0005\u001c\u0000\u0000\u015f\u0161"+
		"\u00053\u0000\u0000\u0160\u0162\u00038\u001c\u0000\u0161\u0160\u0001\u0000"+
		"\u0000\u0000\u0161\u0162\u0001\u0000\u0000\u0000\u0162\u0163\u0001\u0000"+
		"\u0000\u0000\u0163\u0165\u0005<\u0000\u0000\u0164\u0166\u0003@ \u0000"+
		"\u0165\u0164\u0001\u0000\u0000\u0000\u0165\u0166\u0001\u0000\u0000\u0000"+
		"\u0166\u0167\u0001\u0000\u0000\u0000\u0167\u0169\u0005<\u0000\u0000\u0168"+
		"\u016a\u0003:\u001d\u0000\u0169\u0168\u0001\u0000\u0000\u0000\u0169\u016a"+
		"\u0001\u0000\u0000\u0000\u016a\u016b\u0001\u0000\u0000\u0000\u016b\u016c"+
		"\u00054\u0000\u0000\u016c\u016d\u0005;\u0000\u0000\u016d\u016e\u0003\u0010"+
		"\b\u0000\u016e7\u0001\u0000\u0000\u0000\u016f\u0172\u0003\u0016\u000b"+
		"\u0000\u0170\u0172\u0003\u001c\u000e\u0000\u0171\u016f\u0001\u0000\u0000"+
		"\u0000\u0171\u0170\u0001\u0000\u0000\u0000\u01729\u0001\u0000\u0000\u0000"+
		"\u0173\u0176\u0003\u001e\u000f\u0000\u0174\u0176\u0003\u001c\u000e\u0000"+
		"\u0175\u0173\u0001\u0000\u0000\u0000\u0175\u0174\u0001\u0000\u0000\u0000"+
		"\u0176;\u0001\u0000\u0000\u0000\u0177\u0178\u0005\u001d\u0000\u0000\u0178"+
		"\u0179\u00053\u0000\u0000\u0179\u017a\u0003@ \u0000\u017a\u017b\u0005"+
		"4\u0000\u0000\u017b\u017d\u0005\u001e\u0000\u0000\u017c\u017e\u0005;\u0000"+
		"\u0000\u017d\u017c\u0001\u0000\u0000\u0000\u017d\u017e\u0001\u0000\u0000"+
		"\u0000\u017e\u017f\u0001\u0000\u0000\u0000\u017f\u0180\u0003\u0010\b\u0000"+
		"\u0180=\u0001\u0000\u0000\u0000\u0181\u0183\u0005\u001e\u0000\u0000\u0182"+
		"\u0184\u0005;\u0000\u0000\u0183\u0182\u0001\u0000\u0000\u0000\u0183\u0184"+
		"\u0001\u0000\u0000\u0000\u0184\u0185\u0001\u0000\u0000\u0000\u0185\u0186"+
		"\u0003\u0010\b\u0000\u0186\u0187\u0005\u001d\u0000\u0000\u0187\u0188\u0005"+
		"3\u0000\u0000\u0188\u0189\u0003@ \u0000\u0189\u018a\u00054\u0000\u0000"+
		"\u018a\u018b\u0003\u0014\n\u0000\u018b?\u0001\u0000\u0000\u0000\u018c"+
		"\u018d\u0006 \uffff\uffff\u0000\u018d\u018e\u00053\u0000\u0000\u018e\u018f"+
		"\u0003@ \u0000\u018f\u0190\u00054\u0000\u0000\u0190\u019a\u0001\u0000"+
		"\u0000\u0000\u0191\u019a\u0003$\u0012\u0000\u0192\u0193\u0005 \u0000\u0000"+
		"\u0193\u0194\u00053\u0000\u0000\u0194\u019a\u00054\u0000\u0000\u0195\u019a"+
		"\u0003 \u0010\u0000\u0196\u019a\u0003B!\u0000\u0197\u0198\u0007\u0001"+
		"\u0000\u0000\u0198\u019a\u0003@ \u0007\u0199\u018c\u0001\u0000\u0000\u0000"+
		"\u0199\u0191\u0001\u0000\u0000\u0000\u0199\u0192\u0001\u0000\u0000\u0000"+
		"\u0199\u0195\u0001\u0000\u0000\u0000\u0199\u0196\u0001\u0000\u0000\u0000"+
		"\u0199\u0197\u0001\u0000\u0000\u0000\u019a\u01af\u0001\u0000\u0000\u0000"+
		"\u019b\u019c\n\u0006\u0000\u0000\u019c\u019d\u0007\u0002\u0000\u0000\u019d"+
		"\u01ae\u0003@ \u0007\u019e\u019f\n\u0005\u0000\u0000\u019f\u01a0\u0007"+
		"\u0003\u0000\u0000\u01a0\u01ae\u0003@ \u0006\u01a1\u01a2\n\u0004\u0000"+
		"\u0000\u01a2\u01a3\u0007\u0004\u0000\u0000\u01a3\u01ae\u0003@ \u0005\u01a4"+
		"\u01a5\n\u0003\u0000\u0000\u01a5\u01a6\u0007\u0005\u0000\u0000\u01a6\u01ae"+
		"\u0003@ \u0004\u01a7\u01a8\n\u0002\u0000\u0000\u01a8\u01a9\u0005*\u0000"+
		"\u0000\u01a9\u01ae\u0003@ \u0003\u01aa\u01ab\n\u0001\u0000\u0000\u01ab"+
		"\u01ac\u0005+\u0000\u0000\u01ac\u01ae\u0003@ \u0002\u01ad\u019b\u0001"+
		"\u0000\u0000\u0000\u01ad\u019e\u0001\u0000\u0000\u0000\u01ad\u01a1\u0001"+
		"\u0000\u0000\u0000\u01ad\u01a4\u0001\u0000\u0000\u0000\u01ad\u01a7\u0001"+
		"\u0000\u0000\u0000\u01ad\u01aa\u0001\u0000\u0000\u0000\u01ae\u01b1\u0001"+
		"\u0000\u0000\u0000\u01af\u01ad\u0001\u0000\u0000\u0000\u01af\u01b0\u0001"+
		"\u0000\u0000\u0000\u01b0A\u0001\u0000\u0000\u0000\u01b1\u01af\u0001\u0000"+
		"\u0000\u0000\u01b2\u01b3\u0007\u0006\u0000\u0000\u01b3C\u0001\u0000\u0000"+
		"\u0000\u01b4\u01b7\u0003F#\u0000\u01b5\u01b7\u0005A\u0000\u0000\u01b6"+
		"\u01b4\u0001\u0000\u0000\u0000\u01b6\u01b5\u0001\u0000\u0000\u0000\u01b7"+
		"E\u0001\u0000\u0000\u0000\u01b8\u01b9\u0007\u0007\u0000\u0000\u01b9G\u0001"+
		"\u0000\u0000\u0000,IS[fox}\u0087\u008e\u009a\u00a1\u00b5\u00bf\u00cb\u00ce"+
		"\u00d7\u00db\u00e1\u00e3\u00f0\u00f3\u00f6\u0103\u010c\u0111\u011a\u0126"+
		"\u012a\u0135\u0143\u0147\u0159\u015c\u0161\u0165\u0169\u0171\u0175\u017d"+
		"\u0183\u0199\u01ad\u01af\u01b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}