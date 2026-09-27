// Generated from com/mycompany/C3/grammar/PigLatinParser.g4 by ANTLR 4.13.2
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
public class PigLatinParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMENTARIO_BLOQUE=1, COMENTARIO_LINEA=2, WS=3, IMPORT=4, SEC_VARIABLES=5, 
		SEC_PRINCIPAL=6, FIN_PROGRAMA=7, ESTO=8, SERIES=9, NUMERUS=10, TEXTUM=11, 
		DECIMALIS=12, LITTERA=13, BOOL=14, NOVUS=15, VERUM=16, FALSUS=17, SI=18, 
		ALITER=19, FINIS=20, DUM=21, FACERE=22, PER=23, PERGE=24, INTERRUMPE=25, 
		IMPRIMIR=26, LEER=27, INCREMENTO=28, DECREMENTO=29, IGUAL_IGUAL=30, DIFERENTE=31, 
		MENOR_IGUAL=32, MAYOR_IGUAL=33, MENOR=34, MAYOR=35, AND=36, OR=37, NOT=38, 
		MAS=39, MENOS=40, MULT=41, DIV=42, MOD=43, IGUAL=44, PAR_IZQ=45, PAR_DER=46, 
		COR_IZQ=47, COR_DER=48, LLA_IZQ=49, LLA_DER=50, PUNTO=51, COMA=52, DOSPUNTOS=53, 
		PUNTO_COMA=54, DECIMAL_LIT=55, ENTERO_LIT=56, CADENA_LIT=57, CARACTER_LIT=58, 
		ID=59, ERROR_CHAR=60;
	public static final int
		RULE_programa = 0, RULE_importacion = 1, RULE_ruta = 2, RULE_seccionVariables = 3, 
		RULE_seccionPrincipal = 4, RULE_declaracion = 5, RULE_declaracionSimple = 6, 
		RULE_valorInferido = 7, RULE_dimension = 8, RULE_valor = 9, RULE_inicializadorLista = 10, 
		RULE_bloque = 11, RULE_sentencia = 12, RULE_aliterSi = 13, RULE_aliter = 14, 
		RULE_asignacion = 15, RULE_perInicio = 16, RULE_perActualizacion = 17, 
		RULE_acceso = 18, RULE_inicioAcceso = 19, RULE_sufijo = 20, RULE_objetoNuevo = 21, 
		RULE_argumentos = 22, RULE_expr = 23, RULE_literal = 24, RULE_tipo = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "importacion", "ruta", "seccionVariables", "seccionPrincipal", 
			"declaracion", "declaracionSimple", "valorInferido", "dimension", "valor", 
			"inicializadorLista", "bloque", "sentencia", "aliterSi", "aliter", "asignacion", 
			"perInicio", "perActualizacion", "acceso", "inicioAcceso", "sufijo", 
			"objetoNuevo", "argumentos", "expr", "literal", "tipo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'import'", null, null, "'FINIS'", "'esto'", 
			"'series'", "'numerus'", "'textum'", "'decimalis'", "'littera'", "'bool'", 
			"'novus'", "'verum'", "'falsus'", "'si'", "'aliter'", "'finis'", "'dum'", 
			"'facere'", "'per'", "'perge'", "'interrumpe'", "'>>'", "'<<'", "'++'", 
			"'--'", "'=='", "'!='", "'<='", "'>='", "'<'", "'>'", "'&&'", "'||'", 
			"'!'", "'+'", "'-'", "'*'", "'/'", "'%'", "'='", "'('", "')'", "'['", 
			"']'", "'{'", "'}'", "'.'", "','", "':'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMENTARIO_BLOQUE", "COMENTARIO_LINEA", "WS", "IMPORT", "SEC_VARIABLES", 
			"SEC_PRINCIPAL", "FIN_PROGRAMA", "ESTO", "SERIES", "NUMERUS", "TEXTUM", 
			"DECIMALIS", "LITTERA", "BOOL", "NOVUS", "VERUM", "FALSUS", "SI", "ALITER", 
			"FINIS", "DUM", "FACERE", "PER", "PERGE", "INTERRUMPE", "IMPRIMIR", "LEER", 
			"INCREMENTO", "DECREMENTO", "IGUAL_IGUAL", "DIFERENTE", "MENOR_IGUAL", 
			"MAYOR_IGUAL", "MENOR", "MAYOR", "AND", "OR", "NOT", "MAS", "MENOS", 
			"MULT", "DIV", "MOD", "IGUAL", "PAR_IZQ", "PAR_DER", "COR_IZQ", "COR_DER", 
			"LLA_IZQ", "LLA_DER", "PUNTO", "COMA", "DOSPUNTOS", "PUNTO_COMA", "DECIMAL_LIT", 
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
	public String getGrammarFileName() { return "PigLatinParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PigLatinParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public SeccionPrincipalContext seccionPrincipal() {
			return getRuleContext(SeccionPrincipalContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PigLatinParser.EOF, 0); }
		public List<ImportacionContext> importacion() {
			return getRuleContexts(ImportacionContext.class);
		}
		public ImportacionContext importacion(int i) {
			return getRuleContext(ImportacionContext.class,i);
		}
		public SeccionVariablesContext seccionVariables() {
			return getRuleContext(SeccionVariablesContext.class,0);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitPrograma(this);
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
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(52);
				importacion();
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEC_VARIABLES) {
				{
				setState(58);
				seccionVariables();
				}
			}

			setState(61);
			seccionPrincipal();
			setState(62);
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
	public static class ImportacionContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(PigLatinParser.IMPORT, 0); }
		public RutaContext ruta() {
			return getRuleContext(RutaContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public ImportacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterImportacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitImportacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitImportacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportacionContext importacion() throws RecognitionException {
		ImportacionContext _localctx = new ImportacionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importacion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(IMPORT);
			setState(65);
			ruta();
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_COMA) {
				{
				setState(66);
				match(PUNTO_COMA);
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
	public static class RutaContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PigLatinParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PigLatinParser.ID, i);
		}
		public List<TerminalNode> PUNTO() { return getTokens(PigLatinParser.PUNTO); }
		public TerminalNode PUNTO(int i) {
			return getToken(PigLatinParser.PUNTO, i);
		}
		public RutaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruta; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterRuta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitRuta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitRuta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RutaContext ruta() throws RecognitionException {
		RutaContext _localctx = new RutaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ruta);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(ID);
			setState(72); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(70);
				match(PUNTO);
				setState(71);
				match(ID);
				}
				}
				setState(74); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PUNTO );
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
	public static class SeccionVariablesContext extends ParserRuleContext {
		public TerminalNode SEC_VARIABLES() { return getToken(PigLatinParser.SEC_VARIABLES, 0); }
		public List<DeclaracionContext> declaracion() {
			return getRuleContexts(DeclaracionContext.class);
		}
		public DeclaracionContext declaracion(int i) {
			return getRuleContext(DeclaracionContext.class,i);
		}
		public SeccionVariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seccionVariables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSeccionVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSeccionVariables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSeccionVariables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeccionVariablesContext seccionVariables() throws RecognitionException {
		SeccionVariablesContext _localctx = new SeccionVariablesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_seccionVariables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(SEC_VARIABLES);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ESTO || _la==SERIES) {
				{
				{
				setState(77);
				declaracion();
				}
				}
				setState(82);
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
	public static class SeccionPrincipalContext extends ParserRuleContext {
		public TerminalNode SEC_PRINCIPAL() { return getToken(PigLatinParser.SEC_PRINCIPAL, 0); }
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public TerminalNode FIN_PROGRAMA() { return getToken(PigLatinParser.FIN_PROGRAMA, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public SeccionPrincipalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seccionPrincipal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSeccionPrincipal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSeccionPrincipal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSeccionPrincipal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeccionPrincipalContext seccionPrincipal() throws RecognitionException {
		SeccionPrincipalContext _localctx = new SeccionPrincipalContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_seccionPrincipal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(SEC_PRINCIPAL);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 576460752570024704L) != 0)) {
				{
				{
				setState(84);
				sentencia();
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FIN_PROGRAMA) {
				{
				setState(90);
				match(FIN_PROGRAMA);
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(91);
					match(PUNTO_COMA);
					}
				}

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
	public static class DeclaracionContext extends ParserRuleContext {
		public DeclaracionSimpleContext declaracionSimple() {
			return getRuleContext(DeclaracionSimpleContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterDeclaracion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitDeclaracion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaracion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			declaracionSimple();
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_COMA) {
				{
				setState(97);
				match(PUNTO_COMA);
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
	public static class DeclaracionSimpleContext extends ParserRuleContext {
		public DeclaracionSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracionSimple; }
	 
		public DeclaracionSimpleContext() { }
		public void copyFrom(DeclaracionSimpleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclArregloContext extends DeclaracionSimpleContext {
		public TerminalNode SERIES() { return getToken(PigLatinParser.SERIES, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode DOSPUNTOS() { return getToken(PigLatinParser.DOSPUNTOS, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<DimensionContext> dimension() {
			return getRuleContexts(DimensionContext.class);
		}
		public DimensionContext dimension(int i) {
			return getRuleContext(DimensionContext.class,i);
		}
		public InicializadorListaContext inicializadorLista() {
			return getRuleContext(InicializadorListaContext.class,0);
		}
		public DeclArregloContext(DeclaracionSimpleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterDeclArreglo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitDeclArreglo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitDeclArreglo(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclVariableContext extends DeclaracionSimpleContext {
		public TerminalNode ESTO() { return getToken(PigLatinParser.ESTO, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode DOSPUNTOS() { return getToken(PigLatinParser.DOSPUNTOS, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ValorContext valor() {
			return getRuleContext(ValorContext.class,0);
		}
		public DeclVariableContext(DeclaracionSimpleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterDeclVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitDeclVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitDeclVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclInferidaContext extends DeclaracionSimpleContext {
		public TerminalNode ESTO() { return getToken(PigLatinParser.ESTO, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode DOSPUNTOS() { return getToken(PigLatinParser.DOSPUNTOS, 0); }
		public ValorInferidoContext valorInferido() {
			return getRuleContext(ValorInferidoContext.class,0);
		}
		public DeclInferidaContext(DeclaracionSimpleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterDeclInferida(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitDeclInferida(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitDeclInferida(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionSimpleContext declaracionSimple() throws RecognitionException {
		DeclaracionSimpleContext _localctx = new DeclaracionSimpleContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declaracionSimple);
		int _la;
		try {
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new DeclVariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				match(ESTO);
				setState(101);
				match(ID);
				setState(102);
				match(DOSPUNTOS);
				setState(103);
				tipo();
				setState(105);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(104);
					valor();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new DeclInferidaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(ESTO);
				setState(108);
				match(ID);
				setState(109);
				match(DOSPUNTOS);
				setState(110);
				valorInferido();
				}
				break;
			case 3:
				_localctx = new DeclArregloContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				match(SERIES);
				setState(112);
				match(ID);
				setState(114); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(113);
					dimension();
					}
					}
					setState(116); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COR_IZQ );
				setState(118);
				match(DOSPUNTOS);
				setState(119);
				tipo();
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LLA_IZQ) {
					{
					setState(120);
					inicializadorLista();
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
	public static class ValorInferidoContext extends ParserRuleContext {
		public ObjetoNuevoContext objetoNuevo() {
			return getRuleContext(ObjetoNuevoContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ValorInferidoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valorInferido; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterValorInferido(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitValorInferido(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitValorInferido(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValorInferidoContext valorInferido() throws RecognitionException {
		ValorInferidoContext _localctx = new ValorInferidoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_valorInferido);
		try {
			setState(127);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOVUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				objetoNuevo();
				}
				break;
			case VERUM:
			case FALSUS:
			case DECIMAL_LIT:
			case ENTERO_LIT:
			case CADENA_LIT:
			case CARACTER_LIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				literal();
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
	public static class DimensionContext extends ParserRuleContext {
		public TerminalNode COR_IZQ() { return getToken(PigLatinParser.COR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COR_DER() { return getToken(PigLatinParser.COR_DER, 0); }
		public DimensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterDimension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitDimension(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitDimension(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimensionContext dimension() throws RecognitionException {
		DimensionContext _localctx = new DimensionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_dimension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(COR_IZQ);
			setState(130);
			expr(0);
			setState(131);
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
	public static class ValorContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InicializadorListaContext inicializadorLista() {
			return getRuleContext(InicializadorListaContext.class,0);
		}
		public ValorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterValor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitValor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitValor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValorContext valor() throws RecognitionException {
		ValorContext _localctx = new ValorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_valor);
		try {
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOVUS:
			case VERUM:
			case FALSUS:
			case NOT:
			case MENOS:
			case PAR_IZQ:
			case DECIMAL_LIT:
			case ENTERO_LIT:
			case CADENA_LIT:
			case CARACTER_LIT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				expr(0);
				}
				break;
			case LLA_IZQ:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				inicializadorLista();
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
	public static class InicializadorListaContext extends ParserRuleContext {
		public TerminalNode LLA_IZQ() { return getToken(PigLatinParser.LLA_IZQ, 0); }
		public TerminalNode LLA_DER() { return getToken(PigLatinParser.LLA_DER, 0); }
		public List<ValorContext> valor() {
			return getRuleContexts(ValorContext.class);
		}
		public ValorContext valor(int i) {
			return getRuleContext(ValorContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(PigLatinParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(PigLatinParser.COMA, i);
		}
		public InicializadorListaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicializadorLista; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterInicializadorLista(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitInicializadorLista(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitInicializadorLista(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InicializadorListaContext inicializadorLista() throws RecognitionException {
		InicializadorListaContext _localctx = new InicializadorListaContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_inicializadorLista);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(LLA_IZQ);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1117492216303157248L) != 0)) {
				{
				setState(138);
				valor();
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(139);
					match(COMA);
					setState(140);
					valor();
					}
					}
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(148);
			match(LLA_DER);
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
		public TerminalNode LLA_IZQ() { return getToken(PigLatinParser.LLA_IZQ, 0); }
		public TerminalNode LLA_DER() { return getToken(PigLatinParser.LLA_DER, 0); }
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public BloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterBloque(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitBloque(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitBloque(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(LLA_IZQ);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 576460752570024704L) != 0)) {
				{
				{
				setState(151);
				sentencia();
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(157);
			match(LLA_DER);
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
	public static class SentenciaContext extends ParserRuleContext {
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
	 
		public SentenciaContext() { }
		public void copyFrom(SentenciaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenAsignacionContext extends SentenciaContext {
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public SenAsignacionContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenAsignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenSiContext extends SentenciaContext {
		public TerminalNode SI() { return getToken(PigLatinParser.SI, 0); }
		public TerminalNode PAR_IZQ() { return getToken(PigLatinParser.PAR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_DER() { return getToken(PigLatinParser.PAR_DER, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public TerminalNode FINIS() { return getToken(PigLatinParser.FINIS, 0); }
		public List<AliterSiContext> aliterSi() {
			return getRuleContexts(AliterSiContext.class);
		}
		public AliterSiContext aliterSi(int i) {
			return getRuleContext(AliterSiContext.class,i);
		}
		public AliterContext aliter() {
			return getRuleContext(AliterContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public SenSiContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenSi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenSi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenSi(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenFacereContext extends SentenciaContext {
		public TerminalNode FACERE() { return getToken(PigLatinParser.FACERE, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public TerminalNode DUM() { return getToken(PigLatinParser.DUM, 0); }
		public TerminalNode PAR_IZQ() { return getToken(PigLatinParser.PAR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_DER() { return getToken(PigLatinParser.PAR_DER, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public SenFacereContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenFacere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenFacere(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenFacere(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenPergeContext extends SentenciaContext {
		public TerminalNode PERGE() { return getToken(PigLatinParser.PERGE, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public SenPergeContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenPerge(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenPerge(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenPerge(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenLeerContext extends SentenciaContext {
		public TerminalNode LEER() { return getToken(PigLatinParser.LEER, 0); }
		public AccesoContext acceso() {
			return getRuleContext(AccesoContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public SenLeerContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenLeer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenLeer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenLeer(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenLlamadaContext extends SentenciaContext {
		public AccesoContext acceso() {
			return getRuleContext(AccesoContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public SenLlamadaContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenLlamada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenLlamada(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenLlamada(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenInterrumpeContext extends SentenciaContext {
		public TerminalNode INTERRUMPE() { return getToken(PigLatinParser.INTERRUMPE, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public SenInterrumpeContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenInterrumpe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenInterrumpe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenInterrumpe(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenDeclaracionContext extends SentenciaContext {
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public SenDeclaracionContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenDeclaracion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenDeclaracion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenImprimirContext extends SentenciaContext {
		public List<TerminalNode> IMPRIMIR() { return getTokens(PigLatinParser.IMPRIMIR); }
		public TerminalNode IMPRIMIR(int i) {
			return getToken(PigLatinParser.IMPRIMIR, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public SenImprimirContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenImprimir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenImprimir(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenImprimir(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenPerContext extends SentenciaContext {
		public TerminalNode PER() { return getToken(PigLatinParser.PER, 0); }
		public TerminalNode PAR_IZQ() { return getToken(PigLatinParser.PAR_IZQ, 0); }
		public List<TerminalNode> PUNTO_COMA() { return getTokens(PigLatinParser.PUNTO_COMA); }
		public TerminalNode PUNTO_COMA(int i) {
			return getToken(PigLatinParser.PUNTO_COMA, i);
		}
		public TerminalNode PAR_DER() { return getToken(PigLatinParser.PAR_DER, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public PerInicioContext perInicio() {
			return getRuleContext(PerInicioContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PerActualizacionContext perActualizacion() {
			return getRuleContext(PerActualizacionContext.class,0);
		}
		public TerminalNode FINIS() { return getToken(PigLatinParser.FINIS, 0); }
		public SenPerContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenPer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenPer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenPer(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenIncrementoContext extends SentenciaContext {
		public Token op;
		public AccesoContext acceso() {
			return getRuleContext(AccesoContext.class,0);
		}
		public TerminalNode INCREMENTO() { return getToken(PigLatinParser.INCREMENTO, 0); }
		public TerminalNode DECREMENTO() { return getToken(PigLatinParser.DECREMENTO, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public SenIncrementoContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenIncremento(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenIncremento(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenIncremento(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenDumContext extends SentenciaContext {
		public TerminalNode DUM() { return getToken(PigLatinParser.DUM, 0); }
		public TerminalNode PAR_IZQ() { return getToken(PigLatinParser.PAR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_DER() { return getToken(PigLatinParser.PAR_DER, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public TerminalNode FINIS() { return getToken(PigLatinParser.FINIS, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public SenDumContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenDum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenDum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenDum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_sentencia);
		int _la;
		try {
			int _alt;
			setState(257);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				_localctx = new SenDeclaracionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				declaracion();
				}
				break;
			case 2:
				_localctx = new SenAsignacionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				asignacion();
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(161);
					match(PUNTO_COMA);
					}
				}

				}
				break;
			case 3:
				_localctx = new SenIncrementoContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				acceso();
				setState(165);
				((SenIncrementoContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INCREMENTO || _la==DECREMENTO) ) {
					((SenIncrementoContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(166);
					match(PUNTO_COMA);
					}
				}

				}
				break;
			case 4:
				_localctx = new SenImprimirContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(169);
				match(IMPRIMIR);
				setState(170);
				expr(0);
				setState(175);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(171);
						match(IMPRIMIR);
						setState(172);
						expr(0);
						}
						} 
					}
					setState(177);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(178);
					match(PUNTO_COMA);
					}
				}

				}
				break;
			case 5:
				_localctx = new SenLeerContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(181);
					acceso();
					}
				}

				setState(184);
				match(LEER);
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(185);
					match(PUNTO_COMA);
					}
				}

				}
				break;
			case 6:
				_localctx = new SenLlamadaContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(188);
				acceso();
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(189);
					match(PUNTO_COMA);
					}
				}

				}
				break;
			case 7:
				_localctx = new SenSiContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(192);
				match(SI);
				setState(193);
				match(PAR_IZQ);
				setState(194);
				expr(0);
				setState(195);
				match(PAR_DER);
				setState(196);
				bloque();
				setState(200);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(197);
						aliterSi();
						}
						} 
					}
					setState(202);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				}
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ALITER) {
					{
					setState(203);
					aliter();
					}
				}

				setState(206);
				match(FINIS);
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(207);
					match(PUNTO_COMA);
					}
				}

				}
				break;
			case 8:
				_localctx = new SenDumContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(210);
				match(DUM);
				setState(211);
				match(PAR_IZQ);
				setState(212);
				expr(0);
				setState(213);
				match(PAR_DER);
				setState(214);
				bloque();
				setState(215);
				match(FINIS);
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(216);
					match(PUNTO_COMA);
					}
				}

				}
				break;
			case 9:
				_localctx = new SenFacereContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(219);
				match(FACERE);
				setState(220);
				bloque();
				setState(221);
				match(DUM);
				setState(222);
				match(PAR_IZQ);
				setState(223);
				expr(0);
				setState(224);
				match(PAR_DER);
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(225);
					match(PUNTO_COMA);
					}
				}

				}
				break;
			case 10:
				_localctx = new SenPerContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(228);
				match(PER);
				setState(229);
				match(PAR_IZQ);
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 576460752303424256L) != 0)) {
					{
					setState(230);
					perInicio();
					}
				}

				setState(233);
				match(PUNTO_COMA);
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1116929266349735936L) != 0)) {
					{
					setState(234);
					expr(0);
					}
				}

				setState(237);
				match(PUNTO_COMA);
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(238);
					perActualizacion();
					}
				}

				setState(241);
				match(PAR_DER);
				setState(242);
				bloque();
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FINIS) {
					{
					setState(243);
					match(FINIS);
					setState(245);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==PUNTO_COMA) {
						{
						setState(244);
						match(PUNTO_COMA);
						}
					}

					}
				}

				}
				break;
			case 11:
				_localctx = new SenPergeContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(249);
				match(PERGE);
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(250);
					match(PUNTO_COMA);
					}
				}

				}
				break;
			case 12:
				_localctx = new SenInterrumpeContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(253);
				match(INTERRUMPE);
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(254);
					match(PUNTO_COMA);
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
	public static class AliterSiContext extends ParserRuleContext {
		public TerminalNode ALITER() { return getToken(PigLatinParser.ALITER, 0); }
		public TerminalNode PAR_IZQ() { return getToken(PigLatinParser.PAR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_DER() { return getToken(PigLatinParser.PAR_DER, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public AliterSiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aliterSi; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterAliterSi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitAliterSi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitAliterSi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AliterSiContext aliterSi() throws RecognitionException {
		AliterSiContext _localctx = new AliterSiContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_aliterSi);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(ALITER);
			setState(260);
			match(PAR_IZQ);
			setState(261);
			expr(0);
			setState(262);
			match(PAR_DER);
			setState(263);
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
	public static class AliterContext extends ParserRuleContext {
		public TerminalNode ALITER() { return getToken(PigLatinParser.ALITER, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public AliterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aliter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterAliter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitAliter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitAliter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AliterContext aliter() throws RecognitionException {
		AliterContext _localctx = new AliterContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_aliter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(ALITER);
			setState(266);
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
	public static class AsignacionContext extends ParserRuleContext {
		public AccesoContext acceso() {
			return getRuleContext(AccesoContext.class,0);
		}
		public TerminalNode IGUAL() { return getToken(PigLatinParser.IGUAL, 0); }
		public ValorContext valor() {
			return getRuleContext(ValorContext.class,0);
		}
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitAsignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_asignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			acceso();
			setState(269);
			match(IGUAL);
			setState(270);
			valor();
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
	public static class PerInicioContext extends ParserRuleContext {
		public DeclaracionSimpleContext declaracionSimple() {
			return getRuleContext(DeclaracionSimpleContext.class,0);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public PerInicioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_perInicio; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterPerInicio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitPerInicio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitPerInicio(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PerInicioContext perInicio() throws RecognitionException {
		PerInicioContext _localctx = new PerInicioContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_perInicio);
		try {
			setState(274);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ESTO:
			case SERIES:
				enterOuterAlt(_localctx, 1);
				{
				setState(272);
				declaracionSimple();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(273);
				asignacion();
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
	public static class PerActualizacionContext extends ParserRuleContext {
		public Token op;
		public AccesoContext acceso() {
			return getRuleContext(AccesoContext.class,0);
		}
		public TerminalNode INCREMENTO() { return getToken(PigLatinParser.INCREMENTO, 0); }
		public TerminalNode DECREMENTO() { return getToken(PigLatinParser.DECREMENTO, 0); }
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public PerActualizacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_perActualizacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterPerActualizacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitPerActualizacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitPerActualizacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PerActualizacionContext perActualizacion() throws RecognitionException {
		PerActualizacionContext _localctx = new PerActualizacionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_perActualizacion);
		int _la;
		try {
			setState(280);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(276);
				acceso();
				setState(277);
				((PerActualizacionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INCREMENTO || _la==DECREMENTO) ) {
					((PerActualizacionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(279);
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
	public static class AccesoContext extends ParserRuleContext {
		public InicioAccesoContext inicioAcceso() {
			return getRuleContext(InicioAccesoContext.class,0);
		}
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
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterAcceso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitAcceso(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitAcceso(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccesoContext acceso() throws RecognitionException {
		AccesoContext _localctx = new AccesoContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_acceso);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			inicioAcceso();
			setState(286);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(283);
					sufijo();
					}
					} 
				}
				setState(288);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
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
	public static class InicioAccesoContext extends ParserRuleContext {
		public InicioAccesoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicioAcceso; }
	 
		public InicioAccesoContext() { }
		public void copyFrom(InicioAccesoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AccIdContext extends InicioAccesoContext {
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public AccIdContext(InicioAccesoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterAccId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitAccId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitAccId(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AccLlamadaContext extends InicioAccesoContext {
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode PAR_IZQ() { return getToken(PigLatinParser.PAR_IZQ, 0); }
		public TerminalNode PAR_DER() { return getToken(PigLatinParser.PAR_DER, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public AccLlamadaContext(InicioAccesoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterAccLlamada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitAccLlamada(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitAccLlamada(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InicioAccesoContext inicioAcceso() throws RecognitionException {
		InicioAccesoContext _localctx = new InicioAccesoContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_inicioAcceso);
		int _la;
		try {
			setState(296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				_localctx = new AccLlamadaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(289);
				match(ID);
				setState(290);
				match(PAR_IZQ);
				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1116929266349735936L) != 0)) {
					{
					setState(291);
					argumentos();
					}
				}

				setState(294);
				match(PAR_DER);
				}
				break;
			case 2:
				_localctx = new AccIdContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(295);
				match(ID);
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
		public TerminalNode COR_IZQ() { return getToken(PigLatinParser.COR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COR_DER() { return getToken(PigLatinParser.COR_DER, 0); }
		public SufIndiceContext(SufijoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSufIndice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSufIndice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSufIndice(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SufAtributoContext extends SufijoContext {
		public TerminalNode PUNTO() { return getToken(PigLatinParser.PUNTO, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public SufAtributoContext(SufijoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSufAtributo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSufAtributo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSufAtributo(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SufMetodoContext extends SufijoContext {
		public TerminalNode PUNTO() { return getToken(PigLatinParser.PUNTO, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode PAR_IZQ() { return getToken(PigLatinParser.PAR_IZQ, 0); }
		public TerminalNode PAR_DER() { return getToken(PigLatinParser.PAR_DER, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public SufMetodoContext(SufijoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSufMetodo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSufMetodo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSufMetodo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SufijoContext sufijo() throws RecognitionException {
		SufijoContext _localctx = new SufijoContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_sufijo);
		int _la;
		try {
			setState(311);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				_localctx = new SufMetodoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(298);
				match(PUNTO);
				setState(299);
				match(ID);
				setState(300);
				match(PAR_IZQ);
				setState(302);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1116929266349735936L) != 0)) {
					{
					setState(301);
					argumentos();
					}
				}

				setState(304);
				match(PAR_DER);
				}
				break;
			case 2:
				_localctx = new SufAtributoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(305);
				match(PUNTO);
				setState(306);
				match(ID);
				}
				break;
			case 3:
				_localctx = new SufIndiceContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(307);
				match(COR_IZQ);
				setState(308);
				expr(0);
				setState(309);
				match(COR_DER);
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
	public static class ObjetoNuevoContext extends ParserRuleContext {
		public TerminalNode NOVUS() { return getToken(PigLatinParser.NOVUS, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode PAR_IZQ() { return getToken(PigLatinParser.PAR_IZQ, 0); }
		public TerminalNode PAR_DER() { return getToken(PigLatinParser.PAR_DER, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public ObjetoNuevoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objetoNuevo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterObjetoNuevo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitObjetoNuevo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitObjetoNuevo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjetoNuevoContext objetoNuevo() throws RecognitionException {
		ObjetoNuevoContext _localctx = new ObjetoNuevoContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_objetoNuevo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			match(NOVUS);
			setState(314);
			match(ID);
			setState(315);
			match(PAR_IZQ);
			setState(317);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1116929266349735936L) != 0)) {
				{
				setState(316);
				argumentos();
				}
			}

			setState(319);
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
		public List<TerminalNode> COMA() { return getTokens(PigLatinParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(PigLatinParser.COMA, i);
		}
		public ArgumentosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterArgumentos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitArgumentos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitArgumentos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentosContext argumentos() throws RecognitionException {
		ArgumentosContext _localctx = new ArgumentosContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_argumentos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			expr(0);
			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(322);
				match(COMA);
				setState(323);
				expr(0);
				}
				}
				setState(328);
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
	public static class ExprAccesoContext extends ExprContext {
		public AccesoContext acceso() {
			return getRuleContext(AccesoContext.class,0);
		}
		public ExprAccesoContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExprAcceso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExprAcceso(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExprAcceso(this);
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
		public TerminalNode OR() { return getToken(PigLatinParser.OR, 0); }
		public ExprOrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExprOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExprOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExprOr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprNuevoContext extends ExprContext {
		public ObjetoNuevoContext objetoNuevo() {
			return getRuleContext(ObjetoNuevoContext.class,0);
		}
		public ExprNuevoContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExprNuevo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExprNuevo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExprNuevo(this);
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
		public TerminalNode MAS() { return getToken(PigLatinParser.MAS, 0); }
		public TerminalNode MENOS() { return getToken(PigLatinParser.MENOS, 0); }
		public ExprAditivaContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExprAditiva(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExprAditiva(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExprAditiva(this);
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
		public TerminalNode MENOR() { return getToken(PigLatinParser.MENOR, 0); }
		public TerminalNode MAYOR() { return getToken(PigLatinParser.MAYOR, 0); }
		public TerminalNode MENOR_IGUAL() { return getToken(PigLatinParser.MENOR_IGUAL, 0); }
		public TerminalNode MAYOR_IGUAL() { return getToken(PigLatinParser.MAYOR_IGUAL, 0); }
		public ExprRelacionalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExprRelacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExprRelacional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExprRelacional(this);
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
		public TerminalNode IGUAL_IGUAL() { return getToken(PigLatinParser.IGUAL_IGUAL, 0); }
		public TerminalNode IGUAL() { return getToken(PigLatinParser.IGUAL, 0); }
		public TerminalNode DIFERENTE() { return getToken(PigLatinParser.DIFERENTE, 0); }
		public ExprIgualdadContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExprIgualdad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExprIgualdad(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExprIgualdad(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprParentesisContext extends ExprContext {
		public TerminalNode PAR_IZQ() { return getToken(PigLatinParser.PAR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_DER() { return getToken(PigLatinParser.PAR_DER, 0); }
		public ExprParentesisContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExprParentesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExprParentesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExprParentesis(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprUnariaContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(PigLatinParser.NOT, 0); }
		public TerminalNode MENOS() { return getToken(PigLatinParser.MENOS, 0); }
		public ExprUnariaContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExprUnaria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExprUnaria(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExprUnaria(this);
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
		public TerminalNode AND() { return getToken(PigLatinParser.AND, 0); }
		public ExprAndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExprAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExprAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExprAnd(this);
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
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExprLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExprLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExprLiteral(this);
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
		public TerminalNode MULT() { return getToken(PigLatinParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(PigLatinParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(PigLatinParser.MOD, 0); }
		public ExprMultiplicativaContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExprMultiplicativa(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExprMultiplicativa(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExprMultiplicativa(this);
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PAR_IZQ:
				{
				_localctx = new ExprParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(330);
				match(PAR_IZQ);
				setState(331);
				expr(0);
				setState(332);
				match(PAR_DER);
				}
				break;
			case VERUM:
			case FALSUS:
			case DECIMAL_LIT:
			case ENTERO_LIT:
			case CADENA_LIT:
			case CARACTER_LIT:
				{
				_localctx = new ExprLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(334);
				literal();
				}
				break;
			case NOVUS:
				{
				_localctx = new ExprNuevoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(335);
				objetoNuevo();
				}
				break;
			case ID:
				{
				_localctx = new ExprAccesoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(336);
				acceso();
				}
				break;
			case NOT:
			case MENOS:
				{
				_localctx = new ExprUnariaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(337);
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
				setState(338);
				expr(7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(361);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(359);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMultiplicativaContext(new ExprContext(_parentctx, _parentState));
						((ExprMultiplicativaContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(341);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(342);
						((ExprMultiplicativaContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 15393162788864L) != 0)) ) {
							((ExprMultiplicativaContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(343);
						((ExprMultiplicativaContext)_localctx).der = expr(7);
						}
						break;
					case 2:
						{
						_localctx = new ExprAditivaContext(new ExprContext(_parentctx, _parentState));
						((ExprAditivaContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(344);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(345);
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
						setState(346);
						((ExprAditivaContext)_localctx).der = expr(6);
						}
						break;
					case 3:
						{
						_localctx = new ExprRelacionalContext(new ExprContext(_parentctx, _parentState));
						((ExprRelacionalContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(347);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(348);
						((ExprRelacionalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 64424509440L) != 0)) ) {
							((ExprRelacionalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(349);
						((ExprRelacionalContext)_localctx).der = expr(5);
						}
						break;
					case 4:
						{
						_localctx = new ExprIgualdadContext(new ExprContext(_parentctx, _parentState));
						((ExprIgualdadContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(350);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(351);
						((ExprIgualdadContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 17595407269888L) != 0)) ) {
							((ExprIgualdadContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(352);
						((ExprIgualdadContext)_localctx).der = expr(4);
						}
						break;
					case 5:
						{
						_localctx = new ExprAndContext(new ExprContext(_parentctx, _parentState));
						((ExprAndContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(353);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(354);
						((ExprAndContext)_localctx).op = match(AND);
						setState(355);
						((ExprAndContext)_localctx).der = expr(3);
						}
						break;
					case 6:
						{
						_localctx = new ExprOrContext(new ExprContext(_parentctx, _parentState));
						((ExprOrContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(356);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(357);
						((ExprOrContext)_localctx).op = match(OR);
						setState(358);
						((ExprOrContext)_localctx).der = expr(2);
						}
						break;
					}
					} 
				}
				setState(363);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
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
		public TerminalNode ENTERO_LIT() { return getToken(PigLatinParser.ENTERO_LIT, 0); }
		public TerminalNode DECIMAL_LIT() { return getToken(PigLatinParser.DECIMAL_LIT, 0); }
		public TerminalNode CADENA_LIT() { return getToken(PigLatinParser.CADENA_LIT, 0); }
		public TerminalNode CARACTER_LIT() { return getToken(PigLatinParser.CARACTER_LIT, 0); }
		public TerminalNode VERUM() { return getToken(PigLatinParser.VERUM, 0); }
		public TerminalNode FALSUS() { return getToken(PigLatinParser.FALSUS, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 540431955284656128L) != 0)) ) {
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
		public TerminalNode NUMERUS() { return getToken(PigLatinParser.NUMERUS, 0); }
		public TerminalNode TEXTUM() { return getToken(PigLatinParser.TEXTUM, 0); }
		public TerminalNode DECIMALIS() { return getToken(PigLatinParser.DECIMALIS, 0); }
		public TerminalNode LITTERA() { return getToken(PigLatinParser.LITTERA, 0); }
		public TerminalNode BOOL() { return getToken(PigLatinParser.BOOL, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 576460752303455232L) != 0)) ) {
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
		case 23:
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
		"\u0004\u0001<\u0171\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0001\u0000\u0005\u00006\b\u0000\n\u0000\f\u0000"+
		"9\t\u0000\u0001\u0000\u0003\u0000<\b\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001D\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0004\u0002I\b\u0002\u000b\u0002\f\u0002"+
		"J\u0001\u0003\u0001\u0003\u0005\u0003O\b\u0003\n\u0003\f\u0003R\t\u0003"+
		"\u0001\u0004\u0001\u0004\u0005\u0004V\b\u0004\n\u0004\f\u0004Y\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004]\b\u0004\u0003\u0004_\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0003\u0005c\b\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006j\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004"+
		"\u0006s\b\u0006\u000b\u0006\f\u0006t\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006z\b\u0006\u0003\u0006|\b\u0006\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u0080\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0003"+
		"\t\u0088\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u008e\b\n\n\n\f\n"+
		"\u0091\t\n\u0003\n\u0093\b\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0005"+
		"\u000b\u0099\b\u000b\n\u000b\f\u000b\u009c\t\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0003\f\u00a3\b\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u00a8\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00ae\b\f\n\f\f\f"+
		"\u00b1\t\f\u0001\f\u0003\f\u00b4\b\f\u0001\f\u0003\f\u00b7\b\f\u0001\f"+
		"\u0001\f\u0003\f\u00bb\b\f\u0001\f\u0001\f\u0003\f\u00bf\b\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00c7\b\f\n\f\f\f\u00ca\t\f"+
		"\u0001\f\u0003\f\u00cd\b\f\u0001\f\u0001\f\u0003\f\u00d1\b\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00da\b\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00e3\b\f\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u00e8\b\f\u0001\f\u0001\f\u0003\f\u00ec\b\f\u0001\f"+
		"\u0001\f\u0003\f\u00f0\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00f6"+
		"\b\f\u0003\f\u00f8\b\f\u0001\f\u0001\f\u0003\f\u00fc\b\f\u0001\f\u0001"+
		"\f\u0003\f\u0100\b\f\u0003\f\u0102\b\f\u0001\r\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0003\u0010\u0113"+
		"\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0119"+
		"\b\u0011\u0001\u0012\u0001\u0012\u0005\u0012\u011d\b\u0012\n\u0012\f\u0012"+
		"\u0120\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0125\b"+
		"\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0129\b\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u012f\b\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003"+
		"\u0014\u0138\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003"+
		"\u0015\u013e\b\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0005\u0016\u0145\b\u0016\n\u0016\f\u0016\u0148\t\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0154\b\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017"+
		"\u0168\b\u0017\n\u0017\f\u0017\u016b\t\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0000\u0001.\u001a\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02\u0000\b\u0001\u0000\u001c\u001d\u0002\u0000&&((\u0001\u0000)+\u0001"+
		"\u0000\'(\u0001\u0000 #\u0002\u0000\u001e\u001f,,\u0002\u0000\u0010\u0011"+
		"7:\u0002\u0000\n\u000e;;\u019b\u00007\u0001\u0000\u0000\u0000\u0002@\u0001"+
		"\u0000\u0000\u0000\u0004E\u0001\u0000\u0000\u0000\u0006L\u0001\u0000\u0000"+
		"\u0000\bS\u0001\u0000\u0000\u0000\n`\u0001\u0000\u0000\u0000\f{\u0001"+
		"\u0000\u0000\u0000\u000e\u007f\u0001\u0000\u0000\u0000\u0010\u0081\u0001"+
		"\u0000\u0000\u0000\u0012\u0087\u0001\u0000\u0000\u0000\u0014\u0089\u0001"+
		"\u0000\u0000\u0000\u0016\u0096\u0001\u0000\u0000\u0000\u0018\u0101\u0001"+
		"\u0000\u0000\u0000\u001a\u0103\u0001\u0000\u0000\u0000\u001c\u0109\u0001"+
		"\u0000\u0000\u0000\u001e\u010c\u0001\u0000\u0000\u0000 \u0112\u0001\u0000"+
		"\u0000\u0000\"\u0118\u0001\u0000\u0000\u0000$\u011a\u0001\u0000\u0000"+
		"\u0000&\u0128\u0001\u0000\u0000\u0000(\u0137\u0001\u0000\u0000\u0000*"+
		"\u0139\u0001\u0000\u0000\u0000,\u0141\u0001\u0000\u0000\u0000.\u0153\u0001"+
		"\u0000\u0000\u00000\u016c\u0001\u0000\u0000\u00002\u016e\u0001\u0000\u0000"+
		"\u000046\u0003\u0002\u0001\u000054\u0001\u0000\u0000\u000069\u0001\u0000"+
		"\u0000\u000075\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u00008;\u0001"+
		"\u0000\u0000\u000097\u0001\u0000\u0000\u0000:<\u0003\u0006\u0003\u0000"+
		";:\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000"+
		"\u0000=>\u0003\b\u0004\u0000>?\u0005\u0000\u0000\u0001?\u0001\u0001\u0000"+
		"\u0000\u0000@A\u0005\u0004\u0000\u0000AC\u0003\u0004\u0002\u0000BD\u0005"+
		"6\u0000\u0000CB\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000D\u0003"+
		"\u0001\u0000\u0000\u0000EH\u0005;\u0000\u0000FG\u00053\u0000\u0000GI\u0005"+
		";\u0000\u0000HF\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JH\u0001"+
		"\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000K\u0005\u0001\u0000\u0000"+
		"\u0000LP\u0005\u0005\u0000\u0000MO\u0003\n\u0005\u0000NM\u0001\u0000\u0000"+
		"\u0000OR\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000"+
		"\u0000\u0000Q\u0007\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000"+
		"SW\u0005\u0006\u0000\u0000TV\u0003\u0018\f\u0000UT\u0001\u0000\u0000\u0000"+
		"VY\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000"+
		"\u0000X^\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000Z\\\u0005\u0007"+
		"\u0000\u0000[]\u00056\u0000\u0000\\[\u0001\u0000\u0000\u0000\\]\u0001"+
		"\u0000\u0000\u0000]_\u0001\u0000\u0000\u0000^Z\u0001\u0000\u0000\u0000"+
		"^_\u0001\u0000\u0000\u0000_\t\u0001\u0000\u0000\u0000`b\u0003\f\u0006"+
		"\u0000ac\u00056\u0000\u0000ba\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000"+
		"\u0000c\u000b\u0001\u0000\u0000\u0000de\u0005\b\u0000\u0000ef\u0005;\u0000"+
		"\u0000fg\u00055\u0000\u0000gi\u00032\u0019\u0000hj\u0003\u0012\t\u0000"+
		"ih\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000j|\u0001\u0000\u0000"+
		"\u0000kl\u0005\b\u0000\u0000lm\u0005;\u0000\u0000mn\u00055\u0000\u0000"+
		"n|\u0003\u000e\u0007\u0000op\u0005\t\u0000\u0000pr\u0005;\u0000\u0000"+
		"qs\u0003\u0010\b\u0000rq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000"+
		"tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000"+
		"\u0000vw\u00055\u0000\u0000wy\u00032\u0019\u0000xz\u0003\u0014\n\u0000"+
		"yx\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z|\u0001\u0000\u0000"+
		"\u0000{d\u0001\u0000\u0000\u0000{k\u0001\u0000\u0000\u0000{o\u0001\u0000"+
		"\u0000\u0000|\r\u0001\u0000\u0000\u0000}\u0080\u0003*\u0015\u0000~\u0080"+
		"\u00030\u0018\u0000\u007f}\u0001\u0000\u0000\u0000\u007f~\u0001\u0000"+
		"\u0000\u0000\u0080\u000f\u0001\u0000\u0000\u0000\u0081\u0082\u0005/\u0000"+
		"\u0000\u0082\u0083\u0003.\u0017\u0000\u0083\u0084\u00050\u0000\u0000\u0084"+
		"\u0011\u0001\u0000\u0000\u0000\u0085\u0088\u0003.\u0017\u0000\u0086\u0088"+
		"\u0003\u0014\n\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0086\u0001"+
		"\u0000\u0000\u0000\u0088\u0013\u0001\u0000\u0000\u0000\u0089\u0092\u0005"+
		"1\u0000\u0000\u008a\u008f\u0003\u0012\t\u0000\u008b\u008c\u00054\u0000"+
		"\u0000\u008c\u008e\u0003\u0012\t\u0000\u008d\u008b\u0001\u0000\u0000\u0000"+
		"\u008e\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0093\u0001\u0000\u0000\u0000"+
		"\u0091\u008f\u0001\u0000\u0000\u0000\u0092\u008a\u0001\u0000\u0000\u0000"+
		"\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000"+
		"\u0094\u0095\u00052\u0000\u0000\u0095\u0015\u0001\u0000\u0000\u0000\u0096"+
		"\u009a\u00051\u0000\u0000\u0097\u0099\u0003\u0018\f\u0000\u0098\u0097"+
		"\u0001\u0000\u0000\u0000\u0099\u009c\u0001\u0000\u0000\u0000\u009a\u0098"+
		"\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009d"+
		"\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009d\u009e"+
		"\u00052\u0000\u0000\u009e\u0017\u0001\u0000\u0000\u0000\u009f\u0102\u0003"+
		"\n\u0005\u0000\u00a0\u00a2\u0003\u001e\u000f\u0000\u00a1\u00a3\u00056"+
		"\u0000\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a3\u0102\u0001\u0000\u0000\u0000\u00a4\u00a5\u0003$\u0012"+
		"\u0000\u00a5\u00a7\u0007\u0000\u0000\u0000\u00a6\u00a8\u00056\u0000\u0000"+
		"\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000"+
		"\u00a8\u0102\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005\u001a\u0000\u0000"+
		"\u00aa\u00af\u0003.\u0017\u0000\u00ab\u00ac\u0005\u001a\u0000\u0000\u00ac"+
		"\u00ae\u0003.\u0017\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ae\u00b1"+
		"\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00af\u00b0"+
		"\u0001\u0000\u0000\u0000\u00b0\u00b3\u0001\u0000\u0000\u0000\u00b1\u00af"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b4\u00056\u0000\u0000\u00b3\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\u0102\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b7\u0003$\u0012\u0000\u00b6\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000"+
		"\u0000\u0000\u00b8\u00ba\u0005\u001b\u0000\u0000\u00b9\u00bb\u00056\u0000"+
		"\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000"+
		"\u0000\u00bb\u0102\u0001\u0000\u0000\u0000\u00bc\u00be\u0003$\u0012\u0000"+
		"\u00bd\u00bf\u00056\u0000\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00be"+
		"\u00bf\u0001\u0000\u0000\u0000\u00bf\u0102\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c1\u0005\u0012\u0000\u0000\u00c1\u00c2\u0005-\u0000\u0000\u00c2\u00c3"+
		"\u0003.\u0017\u0000\u00c3\u00c4\u0005.\u0000\u0000\u00c4\u00c8\u0003\u0016"+
		"\u000b\u0000\u00c5\u00c7\u0003\u001a\r\u0000\u00c6\u00c5\u0001\u0000\u0000"+
		"\u0000\u00c7\u00ca\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000"+
		"\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00cc\u0001\u0000\u0000"+
		"\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00cb\u00cd\u0003\u001c\u000e"+
		"\u0000\u00cc\u00cb\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000"+
		"\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00d0\u0005\u0014\u0000"+
		"\u0000\u00cf\u00d1\u00056\u0000\u0000\u00d0\u00cf\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u0102\u0001\u0000\u0000\u0000"+
		"\u00d2\u00d3\u0005\u0015\u0000\u0000\u00d3\u00d4\u0005-\u0000\u0000\u00d4"+
		"\u00d5\u0003.\u0017\u0000\u00d5\u00d6\u0005.\u0000\u0000\u00d6\u00d7\u0003"+
		"\u0016\u000b\u0000\u00d7\u00d9\u0005\u0014\u0000\u0000\u00d8\u00da\u0005"+
		"6\u0000\u0000\u00d9\u00d8\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000"+
		"\u0000\u0000\u00da\u0102\u0001\u0000\u0000\u0000\u00db\u00dc\u0005\u0016"+
		"\u0000\u0000\u00dc\u00dd\u0003\u0016\u000b\u0000\u00dd\u00de\u0005\u0015"+
		"\u0000\u0000\u00de\u00df\u0005-\u0000\u0000\u00df\u00e0\u0003.\u0017\u0000"+
		"\u00e0\u00e2\u0005.\u0000\u0000\u00e1\u00e3\u00056\u0000\u0000\u00e2\u00e1"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u0102"+
		"\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005\u0017\u0000\u0000\u00e5\u00e7"+
		"\u0005-\u0000\u0000\u00e6\u00e8\u0003 \u0010\u0000\u00e7\u00e6\u0001\u0000"+
		"\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000"+
		"\u0000\u0000\u00e9\u00eb\u00056\u0000\u0000\u00ea\u00ec\u0003.\u0017\u0000"+
		"\u00eb\u00ea\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000"+
		"\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed\u00ef\u00056\u0000\u0000\u00ee"+
		"\u00f0\u0003\"\u0011\u0000\u00ef\u00ee\u0001\u0000\u0000\u0000\u00ef\u00f0"+
		"\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f2"+
		"\u0005.\u0000\u0000\u00f2\u00f7\u0003\u0016\u000b\u0000\u00f3\u00f5\u0005"+
		"\u0014\u0000\u0000\u00f4\u00f6\u00056\u0000\u0000\u00f5\u00f4\u0001\u0000"+
		"\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6\u00f8\u0001\u0000"+
		"\u0000\u0000\u00f7\u00f3\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000"+
		"\u0000\u0000\u00f8\u0102\u0001\u0000\u0000\u0000\u00f9\u00fb\u0005\u0018"+
		"\u0000\u0000\u00fa\u00fc\u00056\u0000\u0000\u00fb\u00fa\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u0102\u0001\u0000\u0000"+
		"\u0000\u00fd\u00ff\u0005\u0019\u0000\u0000\u00fe\u0100\u00056\u0000\u0000"+
		"\u00ff\u00fe\u0001\u0000\u0000\u0000\u00ff\u0100\u0001\u0000\u0000\u0000"+
		"\u0100\u0102\u0001\u0000\u0000\u0000\u0101\u009f\u0001\u0000\u0000\u0000"+
		"\u0101\u00a0\u0001\u0000\u0000\u0000\u0101\u00a4\u0001\u0000\u0000\u0000"+
		"\u0101\u00a9\u0001\u0000\u0000\u0000\u0101\u00b6\u0001\u0000\u0000\u0000"+
		"\u0101\u00bc\u0001\u0000\u0000\u0000\u0101\u00c0\u0001\u0000\u0000\u0000"+
		"\u0101\u00d2\u0001\u0000\u0000\u0000\u0101\u00db\u0001\u0000\u0000\u0000"+
		"\u0101\u00e4\u0001\u0000\u0000\u0000\u0101\u00f9\u0001\u0000\u0000\u0000"+
		"\u0101\u00fd\u0001\u0000\u0000\u0000\u0102\u0019\u0001\u0000\u0000\u0000"+
		"\u0103\u0104\u0005\u0013\u0000\u0000\u0104\u0105\u0005-\u0000\u0000\u0105"+
		"\u0106\u0003.\u0017\u0000\u0106\u0107\u0005.\u0000\u0000\u0107\u0108\u0003"+
		"\u0016\u000b\u0000\u0108\u001b\u0001\u0000\u0000\u0000\u0109\u010a\u0005"+
		"\u0013\u0000\u0000\u010a\u010b\u0003\u0016\u000b\u0000\u010b\u001d\u0001"+
		"\u0000\u0000\u0000\u010c\u010d\u0003$\u0012\u0000\u010d\u010e\u0005,\u0000"+
		"\u0000\u010e\u010f\u0003\u0012\t\u0000\u010f\u001f\u0001\u0000\u0000\u0000"+
		"\u0110\u0113\u0003\f\u0006\u0000\u0111\u0113\u0003\u001e\u000f\u0000\u0112"+
		"\u0110\u0001\u0000\u0000\u0000\u0112\u0111\u0001\u0000\u0000\u0000\u0113"+
		"!\u0001\u0000\u0000\u0000\u0114\u0115\u0003$\u0012\u0000\u0115\u0116\u0007"+
		"\u0000\u0000\u0000\u0116\u0119\u0001\u0000\u0000\u0000\u0117\u0119\u0003"+
		"\u001e\u000f\u0000\u0118\u0114\u0001\u0000\u0000\u0000\u0118\u0117\u0001"+
		"\u0000\u0000\u0000\u0119#\u0001\u0000\u0000\u0000\u011a\u011e\u0003&\u0013"+
		"\u0000\u011b\u011d\u0003(\u0014\u0000\u011c\u011b\u0001\u0000\u0000\u0000"+
		"\u011d\u0120\u0001\u0000\u0000\u0000\u011e\u011c\u0001\u0000\u0000\u0000"+
		"\u011e\u011f\u0001\u0000\u0000\u0000\u011f%\u0001\u0000\u0000\u0000\u0120"+
		"\u011e\u0001\u0000\u0000\u0000\u0121\u0122\u0005;\u0000\u0000\u0122\u0124"+
		"\u0005-\u0000\u0000\u0123\u0125\u0003,\u0016\u0000\u0124\u0123\u0001\u0000"+
		"\u0000\u0000\u0124\u0125\u0001\u0000\u0000\u0000\u0125\u0126\u0001\u0000"+
		"\u0000\u0000\u0126\u0129\u0005.\u0000\u0000\u0127\u0129\u0005;\u0000\u0000"+
		"\u0128\u0121\u0001\u0000\u0000\u0000\u0128\u0127\u0001\u0000\u0000\u0000"+
		"\u0129\'\u0001\u0000\u0000\u0000\u012a\u012b\u00053\u0000\u0000\u012b"+
		"\u012c\u0005;\u0000\u0000\u012c\u012e\u0005-\u0000\u0000\u012d\u012f\u0003"+
		",\u0016\u0000\u012e\u012d\u0001\u0000\u0000\u0000\u012e\u012f\u0001\u0000"+
		"\u0000\u0000\u012f\u0130\u0001\u0000\u0000\u0000\u0130\u0138\u0005.\u0000"+
		"\u0000\u0131\u0132\u00053\u0000\u0000\u0132\u0138\u0005;\u0000\u0000\u0133"+
		"\u0134\u0005/\u0000\u0000\u0134\u0135\u0003.\u0017\u0000\u0135\u0136\u0005"+
		"0\u0000\u0000\u0136\u0138\u0001\u0000\u0000\u0000\u0137\u012a\u0001\u0000"+
		"\u0000\u0000\u0137\u0131\u0001\u0000\u0000\u0000\u0137\u0133\u0001\u0000"+
		"\u0000\u0000\u0138)\u0001\u0000\u0000\u0000\u0139\u013a\u0005\u000f\u0000"+
		"\u0000\u013a\u013b\u0005;\u0000\u0000\u013b\u013d\u0005-\u0000\u0000\u013c"+
		"\u013e\u0003,\u0016\u0000\u013d\u013c\u0001\u0000\u0000\u0000\u013d\u013e"+
		"\u0001\u0000\u0000\u0000\u013e\u013f\u0001\u0000\u0000\u0000\u013f\u0140"+
		"\u0005.\u0000\u0000\u0140+\u0001\u0000\u0000\u0000\u0141\u0146\u0003."+
		"\u0017\u0000\u0142\u0143\u00054\u0000\u0000\u0143\u0145\u0003.\u0017\u0000"+
		"\u0144\u0142\u0001\u0000\u0000\u0000\u0145\u0148\u0001\u0000\u0000\u0000"+
		"\u0146\u0144\u0001\u0000\u0000\u0000\u0146\u0147\u0001\u0000\u0000\u0000"+
		"\u0147-\u0001\u0000\u0000\u0000\u0148\u0146\u0001\u0000\u0000\u0000\u0149"+
		"\u014a\u0006\u0017\uffff\uffff\u0000\u014a\u014b\u0005-\u0000\u0000\u014b"+
		"\u014c\u0003.\u0017\u0000\u014c\u014d\u0005.\u0000\u0000\u014d\u0154\u0001"+
		"\u0000\u0000\u0000\u014e\u0154\u00030\u0018\u0000\u014f\u0154\u0003*\u0015"+
		"\u0000\u0150\u0154\u0003$\u0012\u0000\u0151\u0152\u0007\u0001\u0000\u0000"+
		"\u0152\u0154\u0003.\u0017\u0007\u0153\u0149\u0001\u0000\u0000\u0000\u0153"+
		"\u014e\u0001\u0000\u0000\u0000\u0153\u014f\u0001\u0000\u0000\u0000\u0153"+
		"\u0150\u0001\u0000\u0000\u0000\u0153\u0151\u0001\u0000\u0000\u0000\u0154"+
		"\u0169\u0001\u0000\u0000\u0000\u0155\u0156\n\u0006\u0000\u0000\u0156\u0157"+
		"\u0007\u0002\u0000\u0000\u0157\u0168\u0003.\u0017\u0007\u0158\u0159\n"+
		"\u0005\u0000\u0000\u0159\u015a\u0007\u0003\u0000\u0000\u015a\u0168\u0003"+
		".\u0017\u0006\u015b\u015c\n\u0004\u0000\u0000\u015c\u015d\u0007\u0004"+
		"\u0000\u0000\u015d\u0168\u0003.\u0017\u0005\u015e\u015f\n\u0003\u0000"+
		"\u0000\u015f\u0160\u0007\u0005\u0000\u0000\u0160\u0168\u0003.\u0017\u0004"+
		"\u0161\u0162\n\u0002\u0000\u0000\u0162\u0163\u0005$\u0000\u0000\u0163"+
		"\u0168\u0003.\u0017\u0003\u0164\u0165\n\u0001\u0000\u0000\u0165\u0166"+
		"\u0005%\u0000\u0000\u0166\u0168\u0003.\u0017\u0002\u0167\u0155\u0001\u0000"+
		"\u0000\u0000\u0167\u0158\u0001\u0000\u0000\u0000\u0167\u015b\u0001\u0000"+
		"\u0000\u0000\u0167\u015e\u0001\u0000\u0000\u0000\u0167\u0161\u0001\u0000"+
		"\u0000\u0000\u0167\u0164\u0001\u0000\u0000\u0000\u0168\u016b\u0001\u0000"+
		"\u0000\u0000\u0169\u0167\u0001\u0000\u0000\u0000\u0169\u016a\u0001\u0000"+
		"\u0000\u0000\u016a/\u0001\u0000\u0000\u0000\u016b\u0169\u0001\u0000\u0000"+
		"\u0000\u016c\u016d\u0007\u0006\u0000\u0000\u016d1\u0001\u0000\u0000\u0000"+
		"\u016e\u016f\u0007\u0007\u0000\u0000\u016f3\u0001\u0000\u0000\u000027"+
		";CJPW\\^bity{\u007f\u0087\u008f\u0092\u009a\u00a2\u00a7\u00af\u00b3\u00b6"+
		"\u00ba\u00be\u00c8\u00cc\u00d0\u00d9\u00e2\u00e7\u00eb\u00ef\u00f5\u00f7"+
		"\u00fb\u00ff\u0101\u0112\u0118\u011e\u0124\u0128\u012e\u0137\u013d\u0146"+
		"\u0153\u0167\u0169";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}