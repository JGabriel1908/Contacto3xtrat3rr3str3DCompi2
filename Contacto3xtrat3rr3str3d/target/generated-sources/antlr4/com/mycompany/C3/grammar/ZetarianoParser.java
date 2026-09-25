// Generated from com/mycompany/C3/grammar/ZetarianoParser.g4 by ANTLR 4.13.2
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
public class ZetarianoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMENTARIO_LINEA=1, COMENTARIO_BLOQUE=2, WS=3, PUBLIC=4, PRIVATE=5, PROTECTED=6, 
		CLASS=7, NEW=8, THIS=9, VOID=10, RETURN=11, INT=12, DOUBLE=13, CHAR=14, 
		BOOLEAN=15, STRING=16, IF=17, ELSE=18, SWITCH=19, CASE=20, DEFAULT=21, 
		BREAK=22, CONTINUE=23, FOR=24, WHILE=25, DO=26, TRUE=27, FALSE=28, NULL=29, 
		PRINTLN=30, PRINT=31, READLN=32, INCREMENTO=33, DECREMENTO=34, MAS_IGUAL=35, 
		MENOS_IGUAL=36, POR_IGUAL=37, DIV_IGUAL=38, MOD_IGUAL=39, IGUAL_IGUAL=40, 
		DIFERENTE=41, MENOR_IGUAL=42, MAYOR_IGUAL=43, MENOR=44, MAYOR=45, AND=46, 
		OR=47, NOT=48, MAS=49, MENOS=50, MULT=51, DIV=52, MOD=53, IGUAL=54, INTERROGACION=55, 
		PAR_IZQ=56, PAR_DER=57, COR_IZQ=58, COR_DER=59, LLA_IZQ=60, LLA_DER=61, 
		PUNTO=62, COMA=63, DOSPUNTOS=64, PUNTO_COMA=65, DECIMAL_LIT=66, ENTERO_LIT=67, 
		CADENA_LIT=68, CARACTER_LIT=69, ID=70, ERROR_CHAR=71;
	public static final int
		RULE_programa = 0, RULE_clase = 1, RULE_miembro = 2, RULE_modificador = 3, 
		RULE_atributo = 4, RULE_constructor = 5, RULE_metodo = 6, RULE_tipoRetorno = 7, 
		RULE_parametros = 8, RULE_parametro = 9, RULE_bloque = 10, RULE_sentencia = 11, 
		RULE_declaracionLocal = 12, RULE_declarador = 13, RULE_inicializador = 14, 
		RULE_inicializadorArreglo = 15, RULE_seccionSwitch = 16, RULE_etiquetaSwitch = 17, 
		RULE_forInicio = 18, RULE_forActualizacion = 19, RULE_expr = 20, RULE_primario = 21, 
		RULE_argumentos = 22, RULE_literal = 23, RULE_tipo = 24, RULE_tipoBase = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "clase", "miembro", "modificador", "atributo", "constructor", 
			"metodo", "tipoRetorno", "parametros", "parametro", "bloque", "sentencia", 
			"declaracionLocal", "declarador", "inicializador", "inicializadorArreglo", 
			"seccionSwitch", "etiquetaSwitch", "forInicio", "forActualizacion", "expr", 
			"primario", "argumentos", "literal", "tipo", "tipoBase"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'public'", "'private'", "'protected'", "'class'", 
			"'new'", "'this'", "'void'", "'return'", "'int'", "'double'", "'char'", 
			"'boolean'", "'String'", "'if'", "'else'", "'switch'", "'case'", "'default'", 
			"'break'", "'continue'", "'for'", "'while'", "'do'", "'true'", "'false'", 
			"'null'", "'println'", "'print'", "'readln'", "'++'", "'--'", "'+='", 
			"'-='", "'*='", "'/='", "'%='", "'=='", "'!='", "'<='", "'>='", "'<'", 
			"'>'", "'&&'", "'||'", "'!'", "'+'", "'-'", "'*'", "'/'", "'%'", "'='", 
			"'?'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'.'", "','", "':'", 
			"';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMENTARIO_LINEA", "COMENTARIO_BLOQUE", "WS", "PUBLIC", "PRIVATE", 
			"PROTECTED", "CLASS", "NEW", "THIS", "VOID", "RETURN", "INT", "DOUBLE", 
			"CHAR", "BOOLEAN", "STRING", "IF", "ELSE", "SWITCH", "CASE", "DEFAULT", 
			"BREAK", "CONTINUE", "FOR", "WHILE", "DO", "TRUE", "FALSE", "NULL", "PRINTLN", 
			"PRINT", "READLN", "INCREMENTO", "DECREMENTO", "MAS_IGUAL", "MENOS_IGUAL", 
			"POR_IGUAL", "DIV_IGUAL", "MOD_IGUAL", "IGUAL_IGUAL", "DIFERENTE", "MENOR_IGUAL", 
			"MAYOR_IGUAL", "MENOR", "MAYOR", "AND", "OR", "NOT", "MAS", "MENOS", 
			"MULT", "DIV", "MOD", "IGUAL", "INTERROGACION", "PAR_IZQ", "PAR_DER", 
			"COR_IZQ", "COR_DER", "LLA_IZQ", "LLA_DER", "PUNTO", "COMA", "DOSPUNTOS", 
			"PUNTO_COMA", "DECIMAL_LIT", "ENTERO_LIT", "CADENA_LIT", "CARACTER_LIT", 
			"ID", "ERROR_CHAR"
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
	public String getGrammarFileName() { return "ZetarianoParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ZetarianoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public ClaseContext clase() {
			return getRuleContext(ClaseContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ZetarianoParser.EOF, 0); }
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			clase();
			setState(53);
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
	public static class ClaseContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(ZetarianoParser.CLASS, 0); }
		public TerminalNode ID() { return getToken(ZetarianoParser.ID, 0); }
		public TerminalNode LLA_IZQ() { return getToken(ZetarianoParser.LLA_IZQ, 0); }
		public TerminalNode LLA_DER() { return getToken(ZetarianoParser.LLA_DER, 0); }
		public ModificadorContext modificador() {
			return getRuleContext(ModificadorContext.class,0);
		}
		public List<MiembroContext> miembro() {
			return getRuleContexts(MiembroContext.class);
		}
		public MiembroContext miembro(int i) {
			return getRuleContext(MiembroContext.class,i);
		}
		public ClaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterClase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitClase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitClase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClaseContext clase() throws RecognitionException {
		ClaseContext _localctx = new ClaseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_clase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 112L) != 0)) {
				{
				setState(55);
				modificador();
				}
			}

			setState(58);
			match(CLASS);
			setState(59);
			match(ID);
			setState(60);
			match(LLA_IZQ);
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 128112L) != 0) || _la==ID) {
				{
				{
				setState(61);
				miembro();
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
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
	public static class MiembroContext extends ParserRuleContext {
		public AtributoContext atributo() {
			return getRuleContext(AtributoContext.class,0);
		}
		public ConstructorContext constructor() {
			return getRuleContext(ConstructorContext.class,0);
		}
		public MetodoContext metodo() {
			return getRuleContext(MetodoContext.class,0);
		}
		public MiembroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_miembro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterMiembro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitMiembro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitMiembro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MiembroContext miembro() throws RecognitionException {
		MiembroContext _localctx = new MiembroContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_miembro);
		try {
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				atributo();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				constructor();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				metodo();
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
	public static class ModificadorContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(ZetarianoParser.PUBLIC, 0); }
		public TerminalNode PRIVATE() { return getToken(ZetarianoParser.PRIVATE, 0); }
		public TerminalNode PROTECTED() { return getToken(ZetarianoParser.PROTECTED, 0); }
		public ModificadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modificador; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterModificador(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitModificador(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitModificador(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModificadorContext modificador() throws RecognitionException {
		ModificadorContext _localctx = new ModificadorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_modificador);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 112L) != 0)) ) {
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
	public static class AtributoContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<DeclaradorContext> declarador() {
			return getRuleContexts(DeclaradorContext.class);
		}
		public DeclaradorContext declarador(int i) {
			return getRuleContext(DeclaradorContext.class,i);
		}
		public TerminalNode PUNTO_COMA() { return getToken(ZetarianoParser.PUNTO_COMA, 0); }
		public ModificadorContext modificador() {
			return getRuleContext(ModificadorContext.class,0);
		}
		public List<TerminalNode> COMA() { return getTokens(ZetarianoParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(ZetarianoParser.COMA, i);
		}
		public AtributoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atributo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterAtributo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitAtributo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitAtributo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtributoContext atributo() throws RecognitionException {
		AtributoContext _localctx = new AtributoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_atributo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 112L) != 0)) {
				{
				setState(76);
				modificador();
				}
			}

			setState(79);
			tipo();
			setState(80);
			declarador();
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(81);
				match(COMA);
				setState(82);
				declarador();
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(88);
			match(PUNTO_COMA);
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
	public static class ConstructorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ZetarianoParser.ID, 0); }
		public TerminalNode PAR_IZQ() { return getToken(ZetarianoParser.PAR_IZQ, 0); }
		public TerminalNode PAR_DER() { return getToken(ZetarianoParser.PAR_DER, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public ModificadorContext modificador() {
			return getRuleContext(ModificadorContext.class,0);
		}
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public ConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorContext constructor() throws RecognitionException {
		ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_constructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 112L) != 0)) {
				{
				setState(90);
				modificador();
				}
			}

			setState(93);
			match(ID);
			setState(94);
			match(PAR_IZQ);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & 288230376151711775L) != 0)) {
				{
				setState(95);
				parametros();
				}
			}

			setState(98);
			match(PAR_DER);
			setState(99);
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
	public static class MetodoContext extends ParserRuleContext {
		public TipoRetornoContext tipoRetorno() {
			return getRuleContext(TipoRetornoContext.class,0);
		}
		public TerminalNode ID() { return getToken(ZetarianoParser.ID, 0); }
		public TerminalNode PAR_IZQ() { return getToken(ZetarianoParser.PAR_IZQ, 0); }
		public TerminalNode PAR_DER() { return getToken(ZetarianoParser.PAR_DER, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public ModificadorContext modificador() {
			return getRuleContext(ModificadorContext.class,0);
		}
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public MetodoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metodo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterMetodo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitMetodo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitMetodo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MetodoContext metodo() throws RecognitionException {
		MetodoContext _localctx = new MetodoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_metodo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 112L) != 0)) {
				{
				setState(101);
				modificador();
				}
			}

			setState(104);
			tipoRetorno();
			setState(105);
			match(ID);
			setState(106);
			match(PAR_IZQ);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & 288230376151711775L) != 0)) {
				{
				setState(107);
				parametros();
				}
			}

			setState(110);
			match(PAR_DER);
			setState(111);
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
	public static class TipoRetornoContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(ZetarianoParser.VOID, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TipoRetornoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipoRetorno; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterTipoRetorno(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitTipoRetorno(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitTipoRetorno(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoRetornoContext tipoRetorno() throws RecognitionException {
		TipoRetornoContext _localctx = new TipoRetornoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tipoRetorno);
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				match(VOID);
				}
				break;
			case INT:
			case DOUBLE:
			case CHAR:
			case BOOLEAN:
			case STRING:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				tipo();
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
	public static class ParametrosContext extends ParserRuleContext {
		public List<ParametroContext> parametro() {
			return getRuleContexts(ParametroContext.class);
		}
		public ParametroContext parametro(int i) {
			return getRuleContext(ParametroContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(ZetarianoParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(ZetarianoParser.COMA, i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterParametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitParametros(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitParametros(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			parametro();
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(118);
				match(COMA);
				setState(119);
				parametro();
				}
				}
				setState(124);
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
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(ZetarianoParser.ID, 0); }
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterParametro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitParametro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitParametro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parametro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			tipo();
			setState(126);
			match(ID);
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
		public TerminalNode LLA_IZQ() { return getToken(ZetarianoParser.LLA_IZQ, 0); }
		public TerminalNode LLA_DER() { return getToken(ZetarianoParser.LLA_DER, 0); }
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
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterBloque(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitBloque(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitBloque(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(LLA_IZQ);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & 9084049620098599931L) != 0)) {
				{
				{
				setState(129);
				sentencia();
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(135);
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
	public static class SenDoWhileContext extends SentenciaContext {
		public TerminalNode DO() { return getToken(ZetarianoParser.DO, 0); }
		public SentenciaContext sentencia() {
			return getRuleContext(SentenciaContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(ZetarianoParser.WHILE, 0); }
		public TerminalNode PAR_IZQ() { return getToken(ZetarianoParser.PAR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_DER() { return getToken(ZetarianoParser.PAR_DER, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(ZetarianoParser.PUNTO_COMA, 0); }
		public SenDoWhileContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterSenDoWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitSenDoWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitSenDoWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenPrintlnContext extends SentenciaContext {
		public TerminalNode PRINTLN() { return getToken(ZetarianoParser.PRINTLN, 0); }
		public TerminalNode PAR_IZQ() { return getToken(ZetarianoParser.PAR_IZQ, 0); }
		public TerminalNode PAR_DER() { return getToken(ZetarianoParser.PAR_DER, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(ZetarianoParser.PUNTO_COMA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SenPrintlnContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterSenPrintln(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitSenPrintln(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitSenPrintln(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenBreakContext extends SentenciaContext {
		public TerminalNode BREAK() { return getToken(ZetarianoParser.BREAK, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(ZetarianoParser.PUNTO_COMA, 0); }
		public SenBreakContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterSenBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitSenBreak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitSenBreak(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenContinueContext extends SentenciaContext {
		public TerminalNode CONTINUE() { return getToken(ZetarianoParser.CONTINUE, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(ZetarianoParser.PUNTO_COMA, 0); }
		public SenContinueContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterSenContinue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitSenContinue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitSenContinue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenDeclaracionContext extends SentenciaContext {
		public DeclaracionLocalContext declaracionLocal() {
			return getRuleContext(DeclaracionLocalContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(ZetarianoParser.PUNTO_COMA, 0); }
		public SenDeclaracionContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterSenDeclaracion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitSenDeclaracion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitSenDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenVaciaContext extends SentenciaContext {
		public TerminalNode PUNTO_COMA() { return getToken(ZetarianoParser.PUNTO_COMA, 0); }
		public SenVaciaContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterSenVacia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitSenVacia(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitSenVacia(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenSwitchContext extends SentenciaContext {
		public TerminalNode SWITCH() { return getToken(ZetarianoParser.SWITCH, 0); }
		public TerminalNode PAR_IZQ() { return getToken(ZetarianoParser.PAR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_DER() { return getToken(ZetarianoParser.PAR_DER, 0); }
		public TerminalNode LLA_IZQ() { return getToken(ZetarianoParser.LLA_IZQ, 0); }
		public TerminalNode LLA_DER() { return getToken(ZetarianoParser.LLA_DER, 0); }
		public List<SeccionSwitchContext> seccionSwitch() {
			return getRuleContexts(SeccionSwitchContext.class);
		}
		public SeccionSwitchContext seccionSwitch(int i) {
			return getRuleContext(SeccionSwitchContext.class,i);
		}
		public SenSwitchContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterSenSwitch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitSenSwitch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitSenSwitch(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenForContext extends SentenciaContext {
		public TerminalNode FOR() { return getToken(ZetarianoParser.FOR, 0); }
		public TerminalNode PAR_IZQ() { return getToken(ZetarianoParser.PAR_IZQ, 0); }
		public List<TerminalNode> PUNTO_COMA() { return getTokens(ZetarianoParser.PUNTO_COMA); }
		public TerminalNode PUNTO_COMA(int i) {
			return getToken(ZetarianoParser.PUNTO_COMA, i);
		}
		public TerminalNode PAR_DER() { return getToken(ZetarianoParser.PAR_DER, 0); }
		public SentenciaContext sentencia() {
			return getRuleContext(SentenciaContext.class,0);
		}
		public ForInicioContext forInicio() {
			return getRuleContext(ForInicioContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForActualizacionContext forActualizacion() {
			return getRuleContext(ForActualizacionContext.class,0);
		}
		public SenForContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterSenFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitSenFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitSenFor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenExpresionContext extends SentenciaContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(ZetarianoParser.PUNTO_COMA, 0); }
		public SenExpresionContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterSenExpresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitSenExpresion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitSenExpresion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenWhileContext extends SentenciaContext {
		public TerminalNode WHILE() { return getToken(ZetarianoParser.WHILE, 0); }
		public TerminalNode PAR_IZQ() { return getToken(ZetarianoParser.PAR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_DER() { return getToken(ZetarianoParser.PAR_DER, 0); }
		public SentenciaContext sentencia() {
			return getRuleContext(SentenciaContext.class,0);
		}
		public SenWhileContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterSenWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitSenWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitSenWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenReturnContext extends SentenciaContext {
		public TerminalNode RETURN() { return getToken(ZetarianoParser.RETURN, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(ZetarianoParser.PUNTO_COMA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SenReturnContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterSenReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitSenReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitSenReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenIfContext extends SentenciaContext {
		public TerminalNode IF() { return getToken(ZetarianoParser.IF, 0); }
		public TerminalNode PAR_IZQ() { return getToken(ZetarianoParser.PAR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_DER() { return getToken(ZetarianoParser.PAR_DER, 0); }
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(ZetarianoParser.ELSE, 0); }
		public SenIfContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterSenIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitSenIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitSenIf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenBloqueContext extends SentenciaContext {
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public SenBloqueContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterSenBloque(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitSenBloque(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitSenBloque(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenPrintContext extends SentenciaContext {
		public TerminalNode PRINT() { return getToken(ZetarianoParser.PRINT, 0); }
		public TerminalNode PAR_IZQ() { return getToken(ZetarianoParser.PAR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_DER() { return getToken(ZetarianoParser.PAR_DER, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(ZetarianoParser.PUNTO_COMA, 0); }
		public SenPrintContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterSenPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitSenPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitSenPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sentencia);
		int _la;
		try {
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new SenBloqueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				bloque();
				}
				break;
			case 2:
				_localctx = new SenDeclaracionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				declaracionLocal();
				setState(139);
				match(PUNTO_COMA);
				}
				break;
			case 3:
				_localctx = new SenIfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
				match(IF);
				setState(142);
				match(PAR_IZQ);
				setState(143);
				expr(0);
				setState(144);
				match(PAR_DER);
				setState(145);
				sentencia();
				setState(148);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(146);
					match(ELSE);
					setState(147);
					sentencia();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new SenSwitchContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(150);
				match(SWITCH);
				setState(151);
				match(PAR_IZQ);
				setState(152);
				expr(0);
				setState(153);
				match(PAR_DER);
				setState(154);
				match(LLA_IZQ);
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CASE || _la==DEFAULT) {
					{
					{
					setState(155);
					seccionSwitch();
					}
					}
					setState(160);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(161);
				match(LLA_DER);
				}
				break;
			case 5:
				_localctx = new SenWhileContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(163);
				match(WHILE);
				setState(164);
				match(PAR_IZQ);
				setState(165);
				expr(0);
				setState(166);
				match(PAR_DER);
				setState(167);
				sentencia();
				}
				break;
			case 6:
				_localctx = new SenDoWhileContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(169);
				match(DO);
				setState(170);
				sentencia();
				setState(171);
				match(WHILE);
				setState(172);
				match(PAR_IZQ);
				setState(173);
				expr(0);
				setState(174);
				match(PAR_DER);
				setState(175);
				match(PUNTO_COMA);
				}
				break;
			case 7:
				_localctx = new SenForContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(177);
				match(FOR);
				setState(178);
				match(PAR_IZQ);
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & 8935430832382280179L) != 0)) {
					{
					setState(179);
					forInicio();
					}
				}

				setState(182);
				match(PUNTO_COMA);
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & 8935430832382279683L) != 0)) {
					{
					setState(183);
					expr(0);
					}
				}

				setState(186);
				match(PUNTO_COMA);
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & 8935430832382279683L) != 0)) {
					{
					setState(187);
					forActualizacion();
					}
				}

				setState(190);
				match(PAR_DER);
				setState(191);
				sentencia();
				}
				break;
			case 8:
				_localctx = new SenBreakContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(192);
				match(BREAK);
				setState(193);
				match(PUNTO_COMA);
				}
				break;
			case 9:
				_localctx = new SenContinueContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(194);
				match(CONTINUE);
				setState(195);
				match(PUNTO_COMA);
				}
				break;
			case 10:
				_localctx = new SenReturnContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(196);
				match(RETURN);
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & 8935430832382279683L) != 0)) {
					{
					setState(197);
					expr(0);
					}
				}

				setState(200);
				match(PUNTO_COMA);
				}
				break;
			case 11:
				_localctx = new SenPrintlnContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(201);
				match(PRINTLN);
				setState(202);
				match(PAR_IZQ);
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & 8935430832382279683L) != 0)) {
					{
					setState(203);
					expr(0);
					}
				}

				setState(206);
				match(PAR_DER);
				setState(207);
				match(PUNTO_COMA);
				}
				break;
			case 12:
				_localctx = new SenPrintContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(208);
				match(PRINT);
				setState(209);
				match(PAR_IZQ);
				setState(210);
				expr(0);
				setState(211);
				match(PAR_DER);
				setState(212);
				match(PUNTO_COMA);
				}
				break;
			case 13:
				_localctx = new SenExpresionContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(214);
				expr(0);
				setState(215);
				match(PUNTO_COMA);
				}
				break;
			case 14:
				_localctx = new SenVaciaContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(217);
				match(PUNTO_COMA);
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
	public static class DeclaracionLocalContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<DeclaradorContext> declarador() {
			return getRuleContexts(DeclaradorContext.class);
		}
		public DeclaradorContext declarador(int i) {
			return getRuleContext(DeclaradorContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(ZetarianoParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(ZetarianoParser.COMA, i);
		}
		public DeclaracionLocalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracionLocal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterDeclaracionLocal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitDeclaracionLocal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitDeclaracionLocal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionLocalContext declaracionLocal() throws RecognitionException {
		DeclaracionLocalContext _localctx = new DeclaracionLocalContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_declaracionLocal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			tipo();
			setState(221);
			declarador();
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(222);
				match(COMA);
				setState(223);
				declarador();
				}
				}
				setState(228);
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
	public static class DeclaradorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ZetarianoParser.ID, 0); }
		public TerminalNode IGUAL() { return getToken(ZetarianoParser.IGUAL, 0); }
		public InicializadorContext inicializador() {
			return getRuleContext(InicializadorContext.class,0);
		}
		public DeclaradorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarador; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterDeclarador(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitDeclarador(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitDeclarador(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaradorContext declarador() throws RecognitionException {
		DeclaradorContext _localctx = new DeclaradorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_declarador);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(ID);
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IGUAL) {
				{
				setState(230);
				match(IGUAL);
				setState(231);
				inicializador();
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
	public static class InicializadorContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InicializadorArregloContext inicializadorArreglo() {
			return getRuleContext(InicializadorArregloContext.class,0);
		}
		public InicializadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicializador; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterInicializador(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitInicializador(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitInicializador(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InicializadorContext inicializador() throws RecognitionException {
		InicializadorContext _localctx = new InicializadorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_inicializador);
		try {
			setState(236);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEW:
			case THIS:
			case TRUE:
			case FALSE:
			case NULL:
			case READLN:
			case INCREMENTO:
			case DECREMENTO:
			case NOT:
			case MAS:
			case MENOS:
			case PAR_IZQ:
			case DECIMAL_LIT:
			case ENTERO_LIT:
			case CADENA_LIT:
			case CARACTER_LIT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				expr(0);
				}
				break;
			case LLA_IZQ:
				enterOuterAlt(_localctx, 2);
				{
				setState(235);
				inicializadorArreglo();
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
	public static class InicializadorArregloContext extends ParserRuleContext {
		public TerminalNode LLA_IZQ() { return getToken(ZetarianoParser.LLA_IZQ, 0); }
		public TerminalNode LLA_DER() { return getToken(ZetarianoParser.LLA_DER, 0); }
		public List<InicializadorContext> inicializador() {
			return getRuleContexts(InicializadorContext.class);
		}
		public InicializadorContext inicializador(int i) {
			return getRuleContext(InicializadorContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(ZetarianoParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(ZetarianoParser.COMA, i);
		}
		public InicializadorArregloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicializadorArreglo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterInicializadorArreglo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitInicializadorArreglo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitInicializadorArreglo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InicializadorArregloContext inicializadorArreglo() throws RecognitionException {
		InicializadorArregloContext _localctx = new InicializadorArregloContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_inicializadorArreglo);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(LLA_IZQ);
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & 8939934432009650179L) != 0)) {
				{
				setState(239);
				inicializador();
				setState(244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(240);
						match(COMA);
						setState(241);
						inicializador();
						}
						} 
					}
					setState(246);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				}
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMA) {
					{
					setState(247);
					match(COMA);
					}
				}

				}
			}

			setState(252);
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
	public static class SeccionSwitchContext extends ParserRuleContext {
		public EtiquetaSwitchContext etiquetaSwitch() {
			return getRuleContext(EtiquetaSwitchContext.class,0);
		}
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public SeccionSwitchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seccionSwitch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterSeccionSwitch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitSeccionSwitch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitSeccionSwitch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeccionSwitchContext seccionSwitch() throws RecognitionException {
		SeccionSwitchContext _localctx = new SeccionSwitchContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_seccionSwitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			etiquetaSwitch();
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & 9084049620098599931L) != 0)) {
				{
				{
				setState(255);
				sentencia();
				}
				}
				setState(260);
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
	public static class EtiquetaSwitchContext extends ParserRuleContext {
		public EtiquetaSwitchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_etiquetaSwitch; }
	 
		public EtiquetaSwitchContext() { }
		public void copyFrom(EtiquetaSwitchContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EtiquetaDefaultContext extends EtiquetaSwitchContext {
		public TerminalNode DEFAULT() { return getToken(ZetarianoParser.DEFAULT, 0); }
		public TerminalNode DOSPUNTOS() { return getToken(ZetarianoParser.DOSPUNTOS, 0); }
		public EtiquetaDefaultContext(EtiquetaSwitchContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterEtiquetaDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitEtiquetaDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitEtiquetaDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EtiquetaCaseContext extends EtiquetaSwitchContext {
		public TerminalNode CASE() { return getToken(ZetarianoParser.CASE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DOSPUNTOS() { return getToken(ZetarianoParser.DOSPUNTOS, 0); }
		public EtiquetaCaseContext(EtiquetaSwitchContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterEtiquetaCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitEtiquetaCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitEtiquetaCase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EtiquetaSwitchContext etiquetaSwitch() throws RecognitionException {
		EtiquetaSwitchContext _localctx = new EtiquetaSwitchContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_etiquetaSwitch);
		try {
			setState(267);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				_localctx = new EtiquetaCaseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				match(CASE);
				setState(262);
				expr(0);
				setState(263);
				match(DOSPUNTOS);
				}
				break;
			case DEFAULT:
				_localctx = new EtiquetaDefaultContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
				match(DEFAULT);
				setState(266);
				match(DOSPUNTOS);
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
	public static class ForInicioContext extends ParserRuleContext {
		public DeclaracionLocalContext declaracionLocal() {
			return getRuleContext(DeclaracionLocalContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(ZetarianoParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(ZetarianoParser.COMA, i);
		}
		public ForInicioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInicio; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterForInicio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitForInicio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitForInicio(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInicioContext forInicio() throws RecognitionException {
		ForInicioContext _localctx = new ForInicioContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_forInicio);
		int _la;
		try {
			setState(278);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				declaracionLocal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(270);
				expr(0);
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(271);
					match(COMA);
					setState(272);
					expr(0);
					}
					}
					setState(277);
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
	public static class ForActualizacionContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(ZetarianoParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(ZetarianoParser.COMA, i);
		}
		public ForActualizacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forActualizacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterForActualizacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitForActualizacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitForActualizacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForActualizacionContext forActualizacion() throws RecognitionException {
		ForActualizacionContext _localctx = new ForActualizacionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_forActualizacion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			expr(0);
			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(281);
				match(COMA);
				setState(282);
				expr(0);
				}
				}
				setState(287);
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
		public TerminalNode MAS() { return getToken(ZetarianoParser.MAS, 0); }
		public TerminalNode MENOS() { return getToken(ZetarianoParser.MENOS, 0); }
		public ExprAditivaContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterExprAditiva(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitExprAditiva(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitExprAditiva(this);
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
		public TerminalNode MENOR() { return getToken(ZetarianoParser.MENOR, 0); }
		public TerminalNode MAYOR() { return getToken(ZetarianoParser.MAYOR, 0); }
		public TerminalNode MENOR_IGUAL() { return getToken(ZetarianoParser.MENOR_IGUAL, 0); }
		public TerminalNode MAYOR_IGUAL() { return getToken(ZetarianoParser.MAYOR_IGUAL, 0); }
		public ExprRelacionalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterExprRelacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitExprRelacional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitExprRelacional(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprIndiceContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COR_IZQ() { return getToken(ZetarianoParser.COR_IZQ, 0); }
		public TerminalNode COR_DER() { return getToken(ZetarianoParser.COR_DER, 0); }
		public ExprIndiceContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterExprIndice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitExprIndice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitExprIndice(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprPostfijaContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode INCREMENTO() { return getToken(ZetarianoParser.INCREMENTO, 0); }
		public TerminalNode DECREMENTO() { return getToken(ZetarianoParser.DECREMENTO, 0); }
		public ExprPostfijaContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterExprPostfija(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitExprPostfija(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitExprPostfija(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprTernariaContext extends ExprContext {
		public ExprContext cond;
		public ExprContext siVerdadero;
		public ExprContext siFalso;
		public TerminalNode INTERROGACION() { return getToken(ZetarianoParser.INTERROGACION, 0); }
		public TerminalNode DOSPUNTOS() { return getToken(ZetarianoParser.DOSPUNTOS, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprTernariaContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterExprTernaria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitExprTernaria(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitExprTernaria(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAsignacionContext extends ExprContext {
		public ExprContext izq;
		public Token op;
		public ExprContext der;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IGUAL() { return getToken(ZetarianoParser.IGUAL, 0); }
		public TerminalNode MAS_IGUAL() { return getToken(ZetarianoParser.MAS_IGUAL, 0); }
		public TerminalNode MENOS_IGUAL() { return getToken(ZetarianoParser.MENOS_IGUAL, 0); }
		public TerminalNode POR_IGUAL() { return getToken(ZetarianoParser.POR_IGUAL, 0); }
		public TerminalNode DIV_IGUAL() { return getToken(ZetarianoParser.DIV_IGUAL, 0); }
		public TerminalNode MOD_IGUAL() { return getToken(ZetarianoParser.MOD_IGUAL, 0); }
		public ExprAsignacionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterExprAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitExprAsignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitExprAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprLlamadaMetodoContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PUNTO() { return getToken(ZetarianoParser.PUNTO, 0); }
		public TerminalNode ID() { return getToken(ZetarianoParser.ID, 0); }
		public TerminalNode PAR_IZQ() { return getToken(ZetarianoParser.PAR_IZQ, 0); }
		public TerminalNode PAR_DER() { return getToken(ZetarianoParser.PAR_DER, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public ExprLlamadaMetodoContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterExprLlamadaMetodo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitExprLlamadaMetodo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitExprLlamadaMetodo(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAtributoContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PUNTO() { return getToken(ZetarianoParser.PUNTO, 0); }
		public TerminalNode ID() { return getToken(ZetarianoParser.ID, 0); }
		public ExprAtributoContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterExprAtributo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitExprAtributo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitExprAtributo(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprPrefijaContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode MAS() { return getToken(ZetarianoParser.MAS, 0); }
		public TerminalNode MENOS() { return getToken(ZetarianoParser.MENOS, 0); }
		public TerminalNode NOT() { return getToken(ZetarianoParser.NOT, 0); }
		public TerminalNode INCREMENTO() { return getToken(ZetarianoParser.INCREMENTO, 0); }
		public TerminalNode DECREMENTO() { return getToken(ZetarianoParser.DECREMENTO, 0); }
		public ExprPrefijaContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterExprPrefija(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitExprPrefija(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitExprPrefija(this);
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
		public TerminalNode OR() { return getToken(ZetarianoParser.OR, 0); }
		public ExprOrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterExprOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitExprOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitExprOr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprPrimarioContext extends ExprContext {
		public PrimarioContext primario() {
			return getRuleContext(PrimarioContext.class,0);
		}
		public ExprPrimarioContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterExprPrimario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitExprPrimario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitExprPrimario(this);
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
		public TerminalNode IGUAL_IGUAL() { return getToken(ZetarianoParser.IGUAL_IGUAL, 0); }
		public TerminalNode DIFERENTE() { return getToken(ZetarianoParser.DIFERENTE, 0); }
		public ExprIgualdadContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterExprIgualdad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitExprIgualdad(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitExprIgualdad(this);
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
		public TerminalNode AND() { return getToken(ZetarianoParser.AND, 0); }
		public ExprAndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterExprAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitExprAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitExprAnd(this);
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
		public TerminalNode MULT() { return getToken(ZetarianoParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(ZetarianoParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(ZetarianoParser.MOD, 0); }
		public ExprMultiplicativaContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterExprMultiplicativa(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitExprMultiplicativa(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitExprMultiplicativa(this);
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
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEW:
			case THIS:
			case TRUE:
			case FALSE:
			case NULL:
			case READLN:
			case PAR_IZQ:
			case DECIMAL_LIT:
			case ENTERO_LIT:
			case CADENA_LIT:
			case CARACTER_LIT:
			case ID:
				{
				_localctx = new ExprPrimarioContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(289);
				primario();
				}
				break;
			case INCREMENTO:
			case DECREMENTO:
			case NOT:
			case MAS:
			case MENOS:
				{
				_localctx = new ExprPrefijaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(290);
				((ExprPrefijaContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1970350606778368L) != 0)) ) {
					((ExprPrefijaContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(291);
				expr(9);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(341);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(339);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMultiplicativaContext(new ExprContext(_parentctx, _parentState));
						((ExprMultiplicativaContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(294);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(295);
						((ExprMultiplicativaContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 15762598695796736L) != 0)) ) {
							((ExprMultiplicativaContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(296);
						((ExprMultiplicativaContext)_localctx).der = expr(9);
						}
						break;
					case 2:
						{
						_localctx = new ExprAditivaContext(new ExprContext(_parentctx, _parentState));
						((ExprAditivaContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(297);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(298);
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
						setState(299);
						((ExprAditivaContext)_localctx).der = expr(8);
						}
						break;
					case 3:
						{
						_localctx = new ExprRelacionalContext(new ExprContext(_parentctx, _parentState));
						((ExprRelacionalContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(300);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(301);
						((ExprRelacionalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 65970697666560L) != 0)) ) {
							((ExprRelacionalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(302);
						((ExprRelacionalContext)_localctx).der = expr(7);
						}
						break;
					case 4:
						{
						_localctx = new ExprIgualdadContext(new ExprContext(_parentctx, _parentState));
						((ExprIgualdadContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(303);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(304);
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
						setState(305);
						((ExprIgualdadContext)_localctx).der = expr(6);
						}
						break;
					case 5:
						{
						_localctx = new ExprAndContext(new ExprContext(_parentctx, _parentState));
						((ExprAndContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(306);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(307);
						((ExprAndContext)_localctx).op = match(AND);
						setState(308);
						((ExprAndContext)_localctx).der = expr(5);
						}
						break;
					case 6:
						{
						_localctx = new ExprOrContext(new ExprContext(_parentctx, _parentState));
						((ExprOrContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(309);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(310);
						((ExprOrContext)_localctx).op = match(OR);
						setState(311);
						((ExprOrContext)_localctx).der = expr(4);
						}
						break;
					case 7:
						{
						_localctx = new ExprTernariaContext(new ExprContext(_parentctx, _parentState));
						((ExprTernariaContext)_localctx).cond = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(312);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(313);
						match(INTERROGACION);
						setState(314);
						((ExprTernariaContext)_localctx).siVerdadero = expr(0);
						setState(315);
						match(DOSPUNTOS);
						setState(316);
						((ExprTernariaContext)_localctx).siFalso = expr(2);
						}
						break;
					case 8:
						{
						_localctx = new ExprAsignacionContext(new ExprContext(_parentctx, _parentState));
						((ExprAsignacionContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(318);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(319);
						((ExprAsignacionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 18015463661371392L) != 0)) ) {
							((ExprAsignacionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(320);
						((ExprAsignacionContext)_localctx).der = expr(1);
						}
						break;
					case 9:
						{
						_localctx = new ExprLlamadaMetodoContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(321);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(322);
						match(PUNTO);
						setState(323);
						match(ID);
						setState(324);
						match(PAR_IZQ);
						setState(326);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & 8935430832382279683L) != 0)) {
							{
							setState(325);
							argumentos();
							}
						}

						setState(328);
						match(PAR_DER);
						}
						break;
					case 10:
						{
						_localctx = new ExprAtributoContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(329);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(330);
						match(PUNTO);
						setState(331);
						match(ID);
						}
						break;
					case 11:
						{
						_localctx = new ExprIndiceContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(332);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(333);
						match(COR_IZQ);
						setState(334);
						expr(0);
						setState(335);
						match(COR_DER);
						}
						break;
					case 12:
						{
						_localctx = new ExprPostfijaContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(337);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(338);
						((ExprPostfijaContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==INCREMENTO || _la==DECREMENTO) ) {
							((ExprPostfijaContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(343);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
	public static class PrimarioContext extends ParserRuleContext {
		public PrimarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primario; }
	 
		public PrimarioContext() { }
		public void copyFrom(PrimarioContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimLiteralContext extends PrimarioContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public PrimLiteralContext(PrimarioContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterPrimLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitPrimLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitPrimLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimIdContext extends PrimarioContext {
		public TerminalNode ID() { return getToken(ZetarianoParser.ID, 0); }
		public PrimIdContext(PrimarioContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterPrimId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitPrimId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitPrimId(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimReadlnContext extends PrimarioContext {
		public TerminalNode READLN() { return getToken(ZetarianoParser.READLN, 0); }
		public TerminalNode PAR_IZQ() { return getToken(ZetarianoParser.PAR_IZQ, 0); }
		public TerminalNode PAR_DER() { return getToken(ZetarianoParser.PAR_DER, 0); }
		public PrimReadlnContext(PrimarioContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterPrimReadln(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitPrimReadln(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitPrimReadln(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimParentesisContext extends PrimarioContext {
		public TerminalNode PAR_IZQ() { return getToken(ZetarianoParser.PAR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_DER() { return getToken(ZetarianoParser.PAR_DER, 0); }
		public PrimParentesisContext(PrimarioContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterPrimParentesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitPrimParentesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitPrimParentesis(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimThisContext extends PrimarioContext {
		public TerminalNode THIS() { return getToken(ZetarianoParser.THIS, 0); }
		public PrimThisContext(PrimarioContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterPrimThis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitPrimThis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitPrimThis(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimNuevoArregloInitContext extends PrimarioContext {
		public TerminalNode NEW() { return getToken(ZetarianoParser.NEW, 0); }
		public TipoBaseContext tipoBase() {
			return getRuleContext(TipoBaseContext.class,0);
		}
		public InicializadorArregloContext inicializadorArreglo() {
			return getRuleContext(InicializadorArregloContext.class,0);
		}
		public List<TerminalNode> COR_IZQ() { return getTokens(ZetarianoParser.COR_IZQ); }
		public TerminalNode COR_IZQ(int i) {
			return getToken(ZetarianoParser.COR_IZQ, i);
		}
		public List<TerminalNode> COR_DER() { return getTokens(ZetarianoParser.COR_DER); }
		public TerminalNode COR_DER(int i) {
			return getToken(ZetarianoParser.COR_DER, i);
		}
		public PrimNuevoArregloInitContext(PrimarioContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterPrimNuevoArregloInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitPrimNuevoArregloInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitPrimNuevoArregloInit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimNuevoObjetoContext extends PrimarioContext {
		public TerminalNode NEW() { return getToken(ZetarianoParser.NEW, 0); }
		public TerminalNode ID() { return getToken(ZetarianoParser.ID, 0); }
		public TerminalNode PAR_IZQ() { return getToken(ZetarianoParser.PAR_IZQ, 0); }
		public TerminalNode PAR_DER() { return getToken(ZetarianoParser.PAR_DER, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public PrimNuevoObjetoContext(PrimarioContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterPrimNuevoObjeto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitPrimNuevoObjeto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitPrimNuevoObjeto(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimNuevoArregloContext extends PrimarioContext {
		public TerminalNode NEW() { return getToken(ZetarianoParser.NEW, 0); }
		public TipoBaseContext tipoBase() {
			return getRuleContext(TipoBaseContext.class,0);
		}
		public List<TerminalNode> COR_IZQ() { return getTokens(ZetarianoParser.COR_IZQ); }
		public TerminalNode COR_IZQ(int i) {
			return getToken(ZetarianoParser.COR_IZQ, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COR_DER() { return getTokens(ZetarianoParser.COR_DER); }
		public TerminalNode COR_DER(int i) {
			return getToken(ZetarianoParser.COR_DER, i);
		}
		public PrimNuevoArregloContext(PrimarioContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterPrimNuevoArreglo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitPrimNuevoArreglo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitPrimNuevoArreglo(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimLlamadaContext extends PrimarioContext {
		public TerminalNode ID() { return getToken(ZetarianoParser.ID, 0); }
		public TerminalNode PAR_IZQ() { return getToken(ZetarianoParser.PAR_IZQ, 0); }
		public TerminalNode PAR_DER() { return getToken(ZetarianoParser.PAR_DER, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public PrimLlamadaContext(PrimarioContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterPrimLlamada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitPrimLlamada(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitPrimLlamada(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimarioContext primario() throws RecognitionException {
		PrimarioContext _localctx = new PrimarioContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_primario);
		int _la;
		try {
			int _alt;
			setState(394);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				_localctx = new PrimParentesisContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(344);
				match(PAR_IZQ);
				setState(345);
				expr(0);
				setState(346);
				match(PAR_DER);
				}
				break;
			case 2:
				_localctx = new PrimLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(348);
				literal();
				}
				break;
			case 3:
				_localctx = new PrimThisContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(349);
				match(THIS);
				}
				break;
			case 4:
				_localctx = new PrimLlamadaContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(350);
				match(ID);
				setState(351);
				match(PAR_IZQ);
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & 8935430832382279683L) != 0)) {
					{
					setState(352);
					argumentos();
					}
				}

				setState(355);
				match(PAR_DER);
				}
				break;
			case 5:
				_localctx = new PrimIdContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(356);
				match(ID);
				}
				break;
			case 6:
				_localctx = new PrimReadlnContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(357);
				match(READLN);
				setState(358);
				match(PAR_IZQ);
				setState(359);
				match(PAR_DER);
				}
				break;
			case 7:
				_localctx = new PrimNuevoObjetoContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(360);
				match(NEW);
				setState(361);
				match(ID);
				setState(362);
				match(PAR_IZQ);
				setState(364);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & 8935430832382279683L) != 0)) {
					{
					setState(363);
					argumentos();
					}
				}

				setState(366);
				match(PAR_DER);
				}
				break;
			case 8:
				_localctx = new PrimNuevoArregloContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(367);
				match(NEW);
				setState(368);
				tipoBase();
				setState(373); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(369);
						match(COR_IZQ);
						setState(370);
						expr(0);
						setState(371);
						match(COR_DER);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(375); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(381);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(377);
						match(COR_IZQ);
						setState(378);
						match(COR_DER);
						}
						} 
					}
					setState(383);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				}
				}
				break;
			case 9:
				_localctx = new PrimNuevoArregloInitContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(384);
				match(NEW);
				setState(385);
				tipoBase();
				setState(388); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(386);
					match(COR_IZQ);
					setState(387);
					match(COR_DER);
					}
					}
					setState(390); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COR_IZQ );
				setState(392);
				inicializadorArreglo();
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
	public static class ArgumentosContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(ZetarianoParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(ZetarianoParser.COMA, i);
		}
		public ArgumentosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterArgumentos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitArgumentos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitArgumentos(this);
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
			setState(396);
			expr(0);
			setState(401);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(397);
				match(COMA);
				setState(398);
				expr(0);
				}
				}
				setState(403);
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
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode ENTERO_LIT() { return getToken(ZetarianoParser.ENTERO_LIT, 0); }
		public TerminalNode DECIMAL_LIT() { return getToken(ZetarianoParser.DECIMAL_LIT, 0); }
		public TerminalNode CADENA_LIT() { return getToken(ZetarianoParser.CADENA_LIT, 0); }
		public TerminalNode CARACTER_LIT() { return getToken(ZetarianoParser.CARACTER_LIT, 0); }
		public TerminalNode TRUE() { return getToken(ZetarianoParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ZetarianoParser.FALSE, 0); }
		public TerminalNode NULL() { return getToken(ZetarianoParser.NULL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			_la = _input.LA(1);
			if ( !(((((_la - 27)) & ~0x3f) == 0 && ((1L << (_la - 27)) & 8246337208327L) != 0)) ) {
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
		public TipoBaseContext tipoBase() {
			return getRuleContext(TipoBaseContext.class,0);
		}
		public List<TerminalNode> COR_IZQ() { return getTokens(ZetarianoParser.COR_IZQ); }
		public TerminalNode COR_IZQ(int i) {
			return getToken(ZetarianoParser.COR_IZQ, i);
		}
		public List<TerminalNode> COR_DER() { return getTokens(ZetarianoParser.COR_DER); }
		public TerminalNode COR_DER(int i) {
			return getToken(ZetarianoParser.COR_DER, i);
		}
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			tipoBase();
			setState(411);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COR_IZQ) {
				{
				{
				setState(407);
				match(COR_IZQ);
				setState(408);
				match(COR_DER);
				}
				}
				setState(413);
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
	public static class TipoBaseContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ZetarianoParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(ZetarianoParser.DOUBLE, 0); }
		public TerminalNode CHAR() { return getToken(ZetarianoParser.CHAR, 0); }
		public TerminalNode BOOLEAN() { return getToken(ZetarianoParser.BOOLEAN, 0); }
		public TerminalNode STRING() { return getToken(ZetarianoParser.STRING, 0); }
		public TerminalNode ID() { return getToken(ZetarianoParser.ID, 0); }
		public TipoBaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipoBase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).enterTipoBase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZetarianoParserListener ) ((ZetarianoParserListener)listener).exitTipoBase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZetarianoParserVisitor ) return ((ZetarianoParserVisitor<? extends T>)visitor).visitTipoBase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoBaseContext tipoBase() throws RecognitionException {
		TipoBaseContext _localctx = new TipoBaseContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_tipoBase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			_la = _input.LA(1);
			if ( !(((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & 288230376151711775L) != 0)) ) {
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
		case 20:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		case 7:
			return precpred(_ctx, 1);
		case 8:
			return precpred(_ctx, 13);
		case 9:
			return precpred(_ctx, 12);
		case 10:
			return precpred(_ctx, 11);
		case 11:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001G\u01a1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0003\u00019\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001?\b\u0001\n\u0001\f\u0001B\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002I\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0003\u0004N\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004T\b\u0004\n\u0004\f\u0004W\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0003\u0005\\\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005a\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0003\u0006g\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006m\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0003\u0007t\b\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0005\by\b\b\n\b\f\b|\t\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0005\n\u0083\b\n\n\n\f\n\u0086\t\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0095\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005"+
		"\u000b\u009d\b\u000b\n\u000b\f\u000b\u00a0\t\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u00b5\b\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00b9\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u00bd\b\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u00c7\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u00cd\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u00db\b\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0005\f\u00e1\b\f\n\f\f\f\u00e4\t\f\u0001\r\u0001\r\u0001\r\u0003\r"+
		"\u00e9\b\r\u0001\u000e\u0001\u000e\u0003\u000e\u00ed\b\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00f3\b\u000f\n\u000f"+
		"\f\u000f\u00f6\t\u000f\u0001\u000f\u0003\u000f\u00f9\b\u000f\u0003\u000f"+
		"\u00fb\b\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0005\u0010"+
		"\u0101\b\u0010\n\u0010\f\u0010\u0104\t\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u010c\b\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u0112\b\u0012\n"+
		"\u0012\f\u0012\u0115\t\u0012\u0003\u0012\u0117\b\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0005\u0013\u011c\b\u0013\n\u0013\f\u0013\u011f\t\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0125\b\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0003\u0014\u0147\b\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u0154\b\u0014\n\u0014"+
		"\f\u0014\u0157\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015"+
		"\u0162\b\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u016d\b\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0004\u0015\u0176\b\u0015\u000b\u0015\f\u0015\u0177\u0001"+
		"\u0015\u0001\u0015\u0005\u0015\u017c\b\u0015\n\u0015\f\u0015\u017f\t\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0004\u0015\u0185\b\u0015"+
		"\u000b\u0015\f\u0015\u0186\u0001\u0015\u0001\u0015\u0003\u0015\u018b\b"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u0190\b\u0016\n"+
		"\u0016\f\u0016\u0193\t\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0005\u0018\u019a\b\u0018\n\u0018\f\u0018\u019d\t\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0000\u0001(\u001a\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.02\u0000\n\u0001\u0000\u0004\u0006\u0002\u0000!\"02\u0001\u0000"+
		"35\u0001\u000012\u0001\u0000*-\u0001\u0000()\u0002\u0000#\'66\u0001\u0000"+
		"!\"\u0002\u0000\u001b\u001dBE\u0002\u0000\f\u0010FF\u01cf\u00004\u0001"+
		"\u0000\u0000\u0000\u00028\u0001\u0000\u0000\u0000\u0004H\u0001\u0000\u0000"+
		"\u0000\u0006J\u0001\u0000\u0000\u0000\bM\u0001\u0000\u0000\u0000\n[\u0001"+
		"\u0000\u0000\u0000\ff\u0001\u0000\u0000\u0000\u000es\u0001\u0000\u0000"+
		"\u0000\u0010u\u0001\u0000\u0000\u0000\u0012}\u0001\u0000\u0000\u0000\u0014"+
		"\u0080\u0001\u0000\u0000\u0000\u0016\u00da\u0001\u0000\u0000\u0000\u0018"+
		"\u00dc\u0001\u0000\u0000\u0000\u001a\u00e5\u0001\u0000\u0000\u0000\u001c"+
		"\u00ec\u0001\u0000\u0000\u0000\u001e\u00ee\u0001\u0000\u0000\u0000 \u00fe"+
		"\u0001\u0000\u0000\u0000\"\u010b\u0001\u0000\u0000\u0000$\u0116\u0001"+
		"\u0000\u0000\u0000&\u0118\u0001\u0000\u0000\u0000(\u0124\u0001\u0000\u0000"+
		"\u0000*\u018a\u0001\u0000\u0000\u0000,\u018c\u0001\u0000\u0000\u0000."+
		"\u0194\u0001\u0000\u0000\u00000\u0196\u0001\u0000\u0000\u00002\u019e\u0001"+
		"\u0000\u0000\u000045\u0003\u0002\u0001\u000056\u0005\u0000\u0000\u0001"+
		"6\u0001\u0001\u0000\u0000\u000079\u0003\u0006\u0003\u000087\u0001\u0000"+
		"\u0000\u000089\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:;\u0005"+
		"\u0007\u0000\u0000;<\u0005F\u0000\u0000<@\u0005<\u0000\u0000=?\u0003\u0004"+
		"\u0002\u0000>=\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000@>\u0001"+
		"\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AC\u0001\u0000\u0000\u0000"+
		"B@\u0001\u0000\u0000\u0000CD\u0005=\u0000\u0000D\u0003\u0001\u0000\u0000"+
		"\u0000EI\u0003\b\u0004\u0000FI\u0003\n\u0005\u0000GI\u0003\f\u0006\u0000"+
		"HE\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HG\u0001\u0000\u0000"+
		"\u0000I\u0005\u0001\u0000\u0000\u0000JK\u0007\u0000\u0000\u0000K\u0007"+
		"\u0001\u0000\u0000\u0000LN\u0003\u0006\u0003\u0000ML\u0001\u0000\u0000"+
		"\u0000MN\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OP\u00030\u0018"+
		"\u0000PU\u0003\u001a\r\u0000QR\u0005?\u0000\u0000RT\u0003\u001a\r\u0000"+
		"SQ\u0001\u0000\u0000\u0000TW\u0001\u0000\u0000\u0000US\u0001\u0000\u0000"+
		"\u0000UV\u0001\u0000\u0000\u0000VX\u0001\u0000\u0000\u0000WU\u0001\u0000"+
		"\u0000\u0000XY\u0005A\u0000\u0000Y\t\u0001\u0000\u0000\u0000Z\\\u0003"+
		"\u0006\u0003\u0000[Z\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000"+
		"\\]\u0001\u0000\u0000\u0000]^\u0005F\u0000\u0000^`\u00058\u0000\u0000"+
		"_a\u0003\u0010\b\u0000`_\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000"+
		"ab\u0001\u0000\u0000\u0000bc\u00059\u0000\u0000cd\u0003\u0014\n\u0000"+
		"d\u000b\u0001\u0000\u0000\u0000eg\u0003\u0006\u0003\u0000fe\u0001\u0000"+
		"\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hi\u0003"+
		"\u000e\u0007\u0000ij\u0005F\u0000\u0000jl\u00058\u0000\u0000km\u0003\u0010"+
		"\b\u0000lk\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0001\u0000"+
		"\u0000\u0000no\u00059\u0000\u0000op\u0003\u0014\n\u0000p\r\u0001\u0000"+
		"\u0000\u0000qt\u0005\n\u0000\u0000rt\u00030\u0018\u0000sq\u0001\u0000"+
		"\u0000\u0000sr\u0001\u0000\u0000\u0000t\u000f\u0001\u0000\u0000\u0000"+
		"uz\u0003\u0012\t\u0000vw\u0005?\u0000\u0000wy\u0003\u0012\t\u0000xv\u0001"+
		"\u0000\u0000\u0000y|\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000"+
		"z{\u0001\u0000\u0000\u0000{\u0011\u0001\u0000\u0000\u0000|z\u0001\u0000"+
		"\u0000\u0000}~\u00030\u0018\u0000~\u007f\u0005F\u0000\u0000\u007f\u0013"+
		"\u0001\u0000\u0000\u0000\u0080\u0084\u0005<\u0000\u0000\u0081\u0083\u0003"+
		"\u0016\u000b\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0083\u0086\u0001"+
		"\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001"+
		"\u0000\u0000\u0000\u0085\u0087\u0001\u0000\u0000\u0000\u0086\u0084\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0005=\u0000\u0000\u0088\u0015\u0001\u0000"+
		"\u0000\u0000\u0089\u00db\u0003\u0014\n\u0000\u008a\u008b\u0003\u0018\f"+
		"\u0000\u008b\u008c\u0005A\u0000\u0000\u008c\u00db\u0001\u0000\u0000\u0000"+
		"\u008d\u008e\u0005\u0011\u0000\u0000\u008e\u008f\u00058\u0000\u0000\u008f"+
		"\u0090\u0003(\u0014\u0000\u0090\u0091\u00059\u0000\u0000\u0091\u0094\u0003"+
		"\u0016\u000b\u0000\u0092\u0093\u0005\u0012\u0000\u0000\u0093\u0095\u0003"+
		"\u0016\u000b\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001"+
		"\u0000\u0000\u0000\u0095\u00db\u0001\u0000\u0000\u0000\u0096\u0097\u0005"+
		"\u0013\u0000\u0000\u0097\u0098\u00058\u0000\u0000\u0098\u0099\u0003(\u0014"+
		"\u0000\u0099\u009a\u00059\u0000\u0000\u009a\u009e\u0005<\u0000\u0000\u009b"+
		"\u009d\u0003 \u0010\u0000\u009c\u009b\u0001\u0000\u0000\u0000\u009d\u00a0"+
		"\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0001\u0000\u0000\u0000\u009f\u00a1\u0001\u0000\u0000\u0000\u00a0\u009e"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005=\u0000\u0000\u00a2\u00db\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a4\u0005\u0019\u0000\u0000\u00a4\u00a5\u0005"+
		"8\u0000\u0000\u00a5\u00a6\u0003(\u0014\u0000\u00a6\u00a7\u00059\u0000"+
		"\u0000\u00a7\u00a8\u0003\u0016\u000b\u0000\u00a8\u00db\u0001\u0000\u0000"+
		"\u0000\u00a9\u00aa\u0005\u001a\u0000\u0000\u00aa\u00ab\u0003\u0016\u000b"+
		"\u0000\u00ab\u00ac\u0005\u0019\u0000\u0000\u00ac\u00ad\u00058\u0000\u0000"+
		"\u00ad\u00ae\u0003(\u0014\u0000\u00ae\u00af\u00059\u0000\u0000\u00af\u00b0"+
		"\u0005A\u0000\u0000\u00b0\u00db\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005"+
		"\u0018\u0000\u0000\u00b2\u00b4\u00058\u0000\u0000\u00b3\u00b5\u0003$\u0012"+
		"\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b8\u0005A\u0000\u0000"+
		"\u00b7\u00b9\u0003(\u0014\u0000\u00b8\u00b7\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b9\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba"+
		"\u00bc\u0005A\u0000\u0000\u00bb\u00bd\u0003&\u0013\u0000\u00bc\u00bb\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00be\u0001"+
		"\u0000\u0000\u0000\u00be\u00bf\u00059\u0000\u0000\u00bf\u00db\u0003\u0016"+
		"\u000b\u0000\u00c0\u00c1\u0005\u0016\u0000\u0000\u00c1\u00db\u0005A\u0000"+
		"\u0000\u00c2\u00c3\u0005\u0017\u0000\u0000\u00c3\u00db\u0005A\u0000\u0000"+
		"\u00c4\u00c6\u0005\u000b\u0000\u0000\u00c5\u00c7\u0003(\u0014\u0000\u00c6"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c8\u0001\u0000\u0000\u0000\u00c8\u00db\u0005A\u0000\u0000\u00c9\u00ca"+
		"\u0005\u001e\u0000\u0000\u00ca\u00cc\u00058\u0000\u0000\u00cb\u00cd\u0003"+
		"(\u0014\u0000\u00cc\u00cb\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000"+
		"\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00cf\u00059\u0000"+
		"\u0000\u00cf\u00db\u0005A\u0000\u0000\u00d0\u00d1\u0005\u001f\u0000\u0000"+
		"\u00d1\u00d2\u00058\u0000\u0000\u00d2\u00d3\u0003(\u0014\u0000\u00d3\u00d4"+
		"\u00059\u0000\u0000\u00d4\u00d5\u0005A\u0000\u0000\u00d5\u00db\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d7\u0003(\u0014\u0000\u00d7\u00d8\u0005A\u0000\u0000"+
		"\u00d8\u00db\u0001\u0000\u0000\u0000\u00d9\u00db\u0005A\u0000\u0000\u00da"+
		"\u0089\u0001\u0000\u0000\u0000\u00da\u008a\u0001\u0000\u0000\u0000\u00da"+
		"\u008d\u0001\u0000\u0000\u0000\u00da\u0096\u0001\u0000\u0000\u0000\u00da"+
		"\u00a3\u0001\u0000\u0000\u0000\u00da\u00a9\u0001\u0000\u0000\u0000\u00da"+
		"\u00b1\u0001\u0000\u0000\u0000\u00da\u00c0\u0001\u0000\u0000\u0000\u00da"+
		"\u00c2\u0001\u0000\u0000\u0000\u00da\u00c4\u0001\u0000\u0000\u0000\u00da"+
		"\u00c9\u0001\u0000\u0000\u0000\u00da\u00d0\u0001\u0000\u0000\u0000\u00da"+
		"\u00d6\u0001\u0000\u0000\u0000\u00da\u00d9\u0001\u0000\u0000\u0000\u00db"+
		"\u0017\u0001\u0000\u0000\u0000\u00dc\u00dd\u00030\u0018\u0000\u00dd\u00e2"+
		"\u0003\u001a\r\u0000\u00de\u00df\u0005?\u0000\u0000\u00df\u00e1\u0003"+
		"\u001a\r\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e1\u00e4\u0001\u0000"+
		"\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000"+
		"\u0000\u0000\u00e3\u0019\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000"+
		"\u0000\u0000\u00e5\u00e8\u0005F\u0000\u0000\u00e6\u00e7\u00056\u0000\u0000"+
		"\u00e7\u00e9\u0003\u001c\u000e\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000"+
		"\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9\u001b\u0001\u0000\u0000\u0000"+
		"\u00ea\u00ed\u0003(\u0014\u0000\u00eb\u00ed\u0003\u001e\u000f\u0000\u00ec"+
		"\u00ea\u0001\u0000\u0000\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ed"+
		"\u001d\u0001\u0000\u0000\u0000\u00ee\u00fa\u0005<\u0000\u0000\u00ef\u00f4"+
		"\u0003\u001c\u000e\u0000\u00f0\u00f1\u0005?\u0000\u0000\u00f1\u00f3\u0003"+
		"\u001c\u000e\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f3\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001"+
		"\u0000\u0000\u0000\u00f5\u00f8\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001"+
		"\u0000\u0000\u0000\u00f7\u00f9\u0005?\u0000\u0000\u00f8\u00f7\u0001\u0000"+
		"\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9\u00fb\u0001\u0000"+
		"\u0000\u0000\u00fa\u00ef\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000"+
		"\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fd\u0005=\u0000"+
		"\u0000\u00fd\u001f\u0001\u0000\u0000\u0000\u00fe\u0102\u0003\"\u0011\u0000"+
		"\u00ff\u0101\u0003\u0016\u000b\u0000\u0100\u00ff\u0001\u0000\u0000\u0000"+
		"\u0101\u0104\u0001\u0000\u0000\u0000\u0102\u0100\u0001\u0000\u0000\u0000"+
		"\u0102\u0103\u0001\u0000\u0000\u0000\u0103!\u0001\u0000\u0000\u0000\u0104"+
		"\u0102\u0001\u0000\u0000\u0000\u0105\u0106\u0005\u0014\u0000\u0000\u0106"+
		"\u0107\u0003(\u0014\u0000\u0107\u0108\u0005@\u0000\u0000\u0108\u010c\u0001"+
		"\u0000\u0000\u0000\u0109\u010a\u0005\u0015\u0000\u0000\u010a\u010c\u0005"+
		"@\u0000\u0000\u010b\u0105\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000"+
		"\u0000\u0000\u010c#\u0001\u0000\u0000\u0000\u010d\u0117\u0003\u0018\f"+
		"\u0000\u010e\u0113\u0003(\u0014\u0000\u010f\u0110\u0005?\u0000\u0000\u0110"+
		"\u0112\u0003(\u0014\u0000\u0111\u010f\u0001\u0000\u0000\u0000\u0112\u0115"+
		"\u0001\u0000\u0000\u0000\u0113\u0111\u0001\u0000\u0000\u0000\u0113\u0114"+
		"\u0001\u0000\u0000\u0000\u0114\u0117\u0001\u0000\u0000\u0000\u0115\u0113"+
		"\u0001\u0000\u0000\u0000\u0116\u010d\u0001\u0000\u0000\u0000\u0116\u010e"+
		"\u0001\u0000\u0000\u0000\u0117%\u0001\u0000\u0000\u0000\u0118\u011d\u0003"+
		"(\u0014\u0000\u0119\u011a\u0005?\u0000\u0000\u011a\u011c\u0003(\u0014"+
		"\u0000\u011b\u0119\u0001\u0000\u0000\u0000\u011c\u011f\u0001\u0000\u0000"+
		"\u0000\u011d\u011b\u0001\u0000\u0000\u0000\u011d\u011e\u0001\u0000\u0000"+
		"\u0000\u011e\'\u0001\u0000\u0000\u0000\u011f\u011d\u0001\u0000\u0000\u0000"+
		"\u0120\u0121\u0006\u0014\uffff\uffff\u0000\u0121\u0125\u0003*\u0015\u0000"+
		"\u0122\u0123\u0007\u0001\u0000\u0000\u0123\u0125\u0003(\u0014\t\u0124"+
		"\u0120\u0001\u0000\u0000\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0125"+
		"\u0155\u0001\u0000\u0000\u0000\u0126\u0127\n\b\u0000\u0000\u0127\u0128"+
		"\u0007\u0002\u0000\u0000\u0128\u0154\u0003(\u0014\t\u0129\u012a\n\u0007"+
		"\u0000\u0000\u012a\u012b\u0007\u0003\u0000\u0000\u012b\u0154\u0003(\u0014"+
		"\b\u012c\u012d\n\u0006\u0000\u0000\u012d\u012e\u0007\u0004\u0000\u0000"+
		"\u012e\u0154\u0003(\u0014\u0007\u012f\u0130\n\u0005\u0000\u0000\u0130"+
		"\u0131\u0007\u0005\u0000\u0000\u0131\u0154\u0003(\u0014\u0006\u0132\u0133"+
		"\n\u0004\u0000\u0000\u0133\u0134\u0005.\u0000\u0000\u0134\u0154\u0003"+
		"(\u0014\u0005\u0135\u0136\n\u0003\u0000\u0000\u0136\u0137\u0005/\u0000"+
		"\u0000\u0137\u0154\u0003(\u0014\u0004\u0138\u0139\n\u0002\u0000\u0000"+
		"\u0139\u013a\u00057\u0000\u0000\u013a\u013b\u0003(\u0014\u0000\u013b\u013c"+
		"\u0005@\u0000\u0000\u013c\u013d\u0003(\u0014\u0002\u013d\u0154\u0001\u0000"+
		"\u0000\u0000\u013e\u013f\n\u0001\u0000\u0000\u013f\u0140\u0007\u0006\u0000"+
		"\u0000\u0140\u0154\u0003(\u0014\u0001\u0141\u0142\n\r\u0000\u0000\u0142"+
		"\u0143\u0005>\u0000\u0000\u0143\u0144\u0005F\u0000\u0000\u0144\u0146\u0005"+
		"8\u0000\u0000\u0145\u0147\u0003,\u0016\u0000\u0146\u0145\u0001\u0000\u0000"+
		"\u0000\u0146\u0147\u0001\u0000\u0000\u0000\u0147\u0148\u0001\u0000\u0000"+
		"\u0000\u0148\u0154\u00059\u0000\u0000\u0149\u014a\n\f\u0000\u0000\u014a"+
		"\u014b\u0005>\u0000\u0000\u014b\u0154\u0005F\u0000\u0000\u014c\u014d\n"+
		"\u000b\u0000\u0000\u014d\u014e\u0005:\u0000\u0000\u014e\u014f\u0003(\u0014"+
		"\u0000\u014f\u0150\u0005;\u0000\u0000\u0150\u0154\u0001\u0000\u0000\u0000"+
		"\u0151\u0152\n\n\u0000\u0000\u0152\u0154\u0007\u0007\u0000\u0000\u0153"+
		"\u0126\u0001\u0000\u0000\u0000\u0153\u0129\u0001\u0000\u0000\u0000\u0153"+
		"\u012c\u0001\u0000\u0000\u0000\u0153\u012f\u0001\u0000\u0000\u0000\u0153"+
		"\u0132\u0001\u0000\u0000\u0000\u0153\u0135\u0001\u0000\u0000\u0000\u0153"+
		"\u0138\u0001\u0000\u0000\u0000\u0153\u013e\u0001\u0000\u0000\u0000\u0153"+
		"\u0141\u0001\u0000\u0000\u0000\u0153\u0149\u0001\u0000\u0000\u0000\u0153"+
		"\u014c\u0001\u0000\u0000\u0000\u0153\u0151\u0001\u0000\u0000\u0000\u0154"+
		"\u0157\u0001\u0000\u0000\u0000\u0155\u0153\u0001\u0000\u0000\u0000\u0155"+
		"\u0156\u0001\u0000\u0000\u0000\u0156)\u0001\u0000\u0000\u0000\u0157\u0155"+
		"\u0001\u0000\u0000\u0000\u0158\u0159\u00058\u0000\u0000\u0159\u015a\u0003"+
		"(\u0014\u0000\u015a\u015b\u00059\u0000\u0000\u015b\u018b\u0001\u0000\u0000"+
		"\u0000\u015c\u018b\u0003.\u0017\u0000\u015d\u018b\u0005\t\u0000\u0000"+
		"\u015e\u015f\u0005F\u0000\u0000\u015f\u0161\u00058\u0000\u0000\u0160\u0162"+
		"\u0003,\u0016\u0000\u0161\u0160\u0001\u0000\u0000\u0000\u0161\u0162\u0001"+
		"\u0000\u0000\u0000\u0162\u0163\u0001\u0000\u0000\u0000\u0163\u018b\u0005"+
		"9\u0000\u0000\u0164\u018b\u0005F\u0000\u0000\u0165\u0166\u0005 \u0000"+
		"\u0000\u0166\u0167\u00058\u0000\u0000\u0167\u018b\u00059\u0000\u0000\u0168"+
		"\u0169\u0005\b\u0000\u0000\u0169\u016a\u0005F\u0000\u0000\u016a\u016c"+
		"\u00058\u0000\u0000\u016b\u016d\u0003,\u0016\u0000\u016c\u016b\u0001\u0000"+
		"\u0000\u0000\u016c\u016d\u0001\u0000\u0000\u0000\u016d\u016e\u0001\u0000"+
		"\u0000\u0000\u016e\u018b\u00059\u0000\u0000\u016f\u0170\u0005\b\u0000"+
		"\u0000\u0170\u0175\u00032\u0019\u0000\u0171\u0172\u0005:\u0000\u0000\u0172"+
		"\u0173\u0003(\u0014\u0000\u0173\u0174\u0005;\u0000\u0000\u0174\u0176\u0001"+
		"\u0000\u0000\u0000\u0175\u0171\u0001\u0000\u0000\u0000\u0176\u0177\u0001"+
		"\u0000\u0000\u0000\u0177\u0175\u0001\u0000\u0000\u0000\u0177\u0178\u0001"+
		"\u0000\u0000\u0000\u0178\u017d\u0001\u0000\u0000\u0000\u0179\u017a\u0005"+
		":\u0000\u0000\u017a\u017c\u0005;\u0000\u0000\u017b\u0179\u0001\u0000\u0000"+
		"\u0000\u017c\u017f\u0001\u0000\u0000\u0000\u017d\u017b\u0001\u0000\u0000"+
		"\u0000\u017d\u017e\u0001\u0000\u0000\u0000\u017e\u018b\u0001\u0000\u0000"+
		"\u0000\u017f\u017d\u0001\u0000\u0000\u0000\u0180\u0181\u0005\b\u0000\u0000"+
		"\u0181\u0184\u00032\u0019\u0000\u0182\u0183\u0005:\u0000\u0000\u0183\u0185"+
		"\u0005;\u0000\u0000\u0184\u0182\u0001\u0000\u0000\u0000\u0185\u0186\u0001"+
		"\u0000\u0000\u0000\u0186\u0184\u0001\u0000\u0000\u0000\u0186\u0187\u0001"+
		"\u0000\u0000\u0000\u0187\u0188\u0001\u0000\u0000\u0000\u0188\u0189\u0003"+
		"\u001e\u000f\u0000\u0189\u018b\u0001\u0000\u0000\u0000\u018a\u0158\u0001"+
		"\u0000\u0000\u0000\u018a\u015c\u0001\u0000\u0000\u0000\u018a\u015d\u0001"+
		"\u0000\u0000\u0000\u018a\u015e\u0001\u0000\u0000\u0000\u018a\u0164\u0001"+
		"\u0000\u0000\u0000\u018a\u0165\u0001\u0000\u0000\u0000\u018a\u0168\u0001"+
		"\u0000\u0000\u0000\u018a\u016f\u0001\u0000\u0000\u0000\u018a\u0180\u0001"+
		"\u0000\u0000\u0000\u018b+\u0001\u0000\u0000\u0000\u018c\u0191\u0003(\u0014"+
		"\u0000\u018d\u018e\u0005?\u0000\u0000\u018e\u0190\u0003(\u0014\u0000\u018f"+
		"\u018d\u0001\u0000\u0000\u0000\u0190\u0193\u0001\u0000\u0000\u0000\u0191"+
		"\u018f\u0001\u0000\u0000\u0000\u0191\u0192\u0001\u0000\u0000\u0000\u0192"+
		"-\u0001\u0000\u0000\u0000\u0193\u0191\u0001\u0000\u0000\u0000\u0194\u0195"+
		"\u0007\b\u0000\u0000\u0195/\u0001\u0000\u0000\u0000\u0196\u019b\u0003"+
		"2\u0019\u0000\u0197\u0198\u0005:\u0000\u0000\u0198\u019a\u0005;\u0000"+
		"\u0000\u0199\u0197\u0001\u0000\u0000\u0000\u019a\u019d\u0001\u0000\u0000"+
		"\u0000\u019b\u0199\u0001\u0000\u0000\u0000\u019b\u019c\u0001\u0000\u0000"+
		"\u0000\u019c1\u0001\u0000\u0000\u0000\u019d\u019b\u0001\u0000\u0000\u0000"+
		"\u019e\u019f\u0007\t\u0000\u0000\u019f3\u0001\u0000\u0000\u0000+8@HMU"+
		"[`flsz\u0084\u0094\u009e\u00b4\u00b8\u00bc\u00c6\u00cc\u00da\u00e2\u00e8"+
		"\u00ec\u00f4\u00f8\u00fa\u0102\u010b\u0113\u0116\u011d\u0124\u0146\u0153"+
		"\u0155\u0161\u016c\u0177\u017d\u0186\u018a\u0191\u019b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}