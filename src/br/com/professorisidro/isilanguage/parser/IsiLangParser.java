// Generated from IsiLang.g4 by ANTLR 4.9.2
package br.com.professorisidro.isilanguage.parser;

	import br.com.professorisidro.isilanguage.datastructures.IsiSymbol;
	import br.com.professorisidro.isilanguage.datastructures.IsiVariable;
	import br.com.professorisidro.isilanguage.datastructures.IsiSymbolTable;
	import br.com.professorisidro.isilanguage.exceptions.IsiSemanticException;
	import br.com.professorisidro.isilanguage.ast.IsiProgram;
	import br.com.professorisidro.isilanguage.ast.AbstractCommand;
	import br.com.professorisidro.isilanguage.ast.CommandLeitura;
	import br.com.professorisidro.isilanguage.ast.CommandEscrita;
	import br.com.professorisidro.isilanguage.ast.CommandAtribuicao;
	import br.com.professorisidro.isilanguage.ast.CommandDecisao;
	import br.com.professorisidro.isilanguage.ast.CommandRepeticao1;
	import br.com.professorisidro.isilanguage.ast.CommandRepeticao2;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, ASP=16, AP=17, 
		FP=18, COLON=19, SC=20, OP=21, ATTR=22, VIR=23, ACH=24, FCH=25, OPREL=26, 
		ID=27, NUMBER=28, STRING=29, BOOLEAN=30, OPNOT=31, OPLOG=32, WS=33;
	public static final int
		RULE_prog = 0, RULE_fimprog = 1, RULE_decl = 2, RULE_declaravar = 3, RULE_tipo = 4, 
		RULE_bloco = 5, RULE_cmd = 6, RULE_cmdleitura = 7, RULE_cmdescrita = 8, 
		RULE_cmdattrib = 9, RULE_cmdselecao = 10, RULE_cmdrepet1 = 11, RULE_cmdrepet2 = 12, 
		RULE_cmdswitch = 13, RULE_expr = 14, RULE_expr2 = 15, RULE_termo = 16, 
		RULE_termo2 = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "fimprog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", 
			"cmdescrita", "cmdattrib", "cmdselecao", "cmdrepet1", "cmdrepet2", "cmdswitch", 
			"expr", "expr2", "termo", "termo2"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog;'", "'numero'", "'texto'", "'booleano'", 
			"'leia'", "'escreva'", "'se'", "'senao'", "'enquanto'", "'para'", "'switch'", 
			"'case'", "'break'", "'default'", "'\"'", "'('", "')'", "':'", "';'", 
			null, "'='", "','", "'{'", "'}'", null, null, null, null, null, "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "ASP", "AP", "FP", "COLON", "SC", "OP", "ATTR", 
			"VIR", "ACH", "FCH", "OPREL", "ID", "NUMBER", "STRING", "BOOLEAN", "OPNOT", 
			"OPLOG", "WS"
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
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		private int _tipo;
		private int ncases;
		private String _varName;
		private String _varValue;
		private IsiSymbolTable symbolTable = new IsiSymbolTable();
		private IsiSymbol symbol;
		private IsiProgram program = new IsiProgram();
		private ArrayList<AbstractCommand> curThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		private String _readID;
		private String _writeID;
		private String _exprID;
		private String _exprContent;
		private String _exprDecision;
		private ArrayList<AbstractCommand> listaTrue;
		private ArrayList<AbstractCommand> listaFalse;
		private ArrayList<String> stackUsedVariables = new ArrayList<String>();
		
		public void verificaID(String id){
			if (!symbolTable.exists(id)){
				throw new IsiSemanticException("Symbol "+id+" not declared");
			}
		}
		
		public void exibeComandos(){
			for (AbstractCommand c: program.getComandos()){
				System.out.println(c);
			}
		}
		
		public void generateCode(){
			program.generateTarget();
		}
		
		public String IsiBool2Java(String s){
	        if(s.equals("Verdadeiro")) return "true";
	        return "false";
	    }
		

	public IsiLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public FimprogContext fimprog() {
			return getRuleContext(FimprogContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(T__0);
			setState(37);
			decl();
			setState(38);
			bloco();
			setState(39);
			fimprog();
			  program.setVarTable(symbolTable);
			           	  program.setComandos(stack.pop());
			           	 
			           
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

	public static class FimprogContext extends ParserRuleContext {
		public FimprogContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fimprog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterFimprog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitFimprog(this);
		}
	}

	public final FimprogContext fimprog() throws RecognitionException {
		FimprogContext _localctx = new FimprogContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_fimprog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(T__1);
					
					if(!stackUsedVariables.isEmpty())
						throw new IsiSemanticException("Variable "+stackUsedVariables.get(0)+" not used");
				
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

	public static class DeclContext extends ParserRuleContext {
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(45);
				declaravar();
				}
				}
				setState(48); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0) );
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

	public static class DeclaravarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public List<TerminalNode> VIR() { return getTokens(IsiLangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(IsiLangParser.VIR, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			tipo();
			setState(51);
			match(ID);

				                  _varName = _input.LT(-1).getText();
				                  _varValue = null;
				                  symbol = new IsiVariable(_varName, _tipo, _varValue);
				                  stackUsedVariables.add(_varName);
				                  if (!symbolTable.exists(_varName)){
				                     symbolTable.add(symbol);	
				                  }
				                  else{
				                  	 throw new IsiSemanticException("Symbol "+_varName+" already declared");
				                  }
			                    
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(53);
				match(VIR);
				setState(54);
				match(ID);

					                  _varName = _input.LT(-1).getText();
					                  _varValue = null;
					                  stackUsedVariables.add(_varName);
					                  symbol = new IsiVariable(_varName, _tipo, _varValue);
					                  if (!symbolTable.exists(_varName)){
					                     symbolTable.add(symbol);	
					                  }
					                  else{
					                  	 throw new IsiSemanticException("Symbol "+_varName+" already declared");
					                  }
				                    
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
			match(SC);
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

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tipo);
		try {
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				match(T__2);
				 _tipo = IsiVariable.NUMBER;  
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				match(T__3);
				 _tipo = IsiVariable.TEXT;  
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				match(T__4);
				 _tipo = IsiVariable.BOOLEAN;  
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

	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 curThread = new ArrayList<AbstractCommand>(); 
				        stack.push(curThread);  
			          
			setState(73); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(72);
				cmd();
				}
				}
				setState(75); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << ID))) != 0) );
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

	public static class CmdContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdattribContext cmdattrib() {
			return getRuleContext(CmdattribContext.class,0);
		}
		public CmdselecaoContext cmdselecao() {
			return getRuleContext(CmdselecaoContext.class,0);
		}
		public Cmdrepet1Context cmdrepet1() {
			return getRuleContext(Cmdrepet1Context.class,0);
		}
		public Cmdrepet2Context cmdrepet2() {
			return getRuleContext(Cmdrepet2Context.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmd);
		try {
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				cmdleitura();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				cmdattrib();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				cmdselecao();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(81);
				cmdrepet1();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 6);
				{
				setState(82);
				cmdrepet2();
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

	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdleitura(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__5);
			setState(86);
			match(AP);
			setState(87);
			match(ID);
			 verificaID(_input.LT(-1).getText());
			                     	  _readID = _input.LT(-1).getText();
			                        
			setState(89);
			match(FP);
			setState(90);
			match(SC);

			              	IsiVariable var = (IsiVariable)symbolTable.get(_readID);
			              	CommandLeitura cmd = new CommandLeitura(_readID, var);
			              	stack.peek().add(cmd);
			              
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

	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode STRING() { return getToken(IsiLangParser.STRING, 0); }
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(T__6);
			setState(94);
			match(AP);
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(95);
				match(ID);
				 verificaID(_input.LT(-1).getText());
					                  _writeID = _input.LT(-1).getText();
					                  if(stackUsedVariables.contains(_writeID))
					                  	stackUsedVariables.remove(stackUsedVariables.indexOf(_writeID));
				                     
				}
				break;
			case STRING:
				{
				setState(97);
				match(STRING);
				_writeID = _input.LT(-1).getText() ;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(101);
			match(FP);
			setState(102);
			match(SC);

			               	  CommandEscrita cmd = new CommandEscrita(_writeID);
			               	  stack.peek().add(cmd);
			               
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

	public static class CmdattribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(IsiLangParser.ATTR, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode STRING() { return getToken(IsiLangParser.STRING, 0); }
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdattrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdattrib(this);
		}
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(ID);
			 verificaID(_input.LT(-1).getText());
			                    _exprID = _input.LT(-1).getText();
			                   
			setState(107);
			match(ATTR);
			 _exprContent = ""; 
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case NUMBER:
			case BOOLEAN:
				{
				setState(109);
				expr();
				}
				break;
			case STRING:
				{
				setState(110);
				match(STRING);
				_exprContent += _input.LT(-1).getText() ;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(114);
			match(SC);

			               	 CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
			               	 stack.peek().add(cmd);
			               
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

	public static class CmdselecaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(IsiLangParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(IsiLangParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(IsiLangParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(IsiLangParser.FCH, i);
		}
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdselecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdselecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdselecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdselecao(this);
		}
	}

	public final CmdselecaoContext cmdselecao() throws RecognitionException {
		CmdselecaoContext _localctx = new CmdselecaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdselecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(T__7);
			{
			setState(118);
			match(AP);
			setState(119);
			match(ID);
			 
			                    	verificaID(_input.LT(-1).getText());
			                    	_exprDecision = _input.LT(-1).getText();
			                    	if(stackUsedVariables.contains(_exprDecision))
				                  		stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
			                    
			setState(121);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
			setState(127);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(123);
				match(ID);

				                    		verificaID(_input.LT(-1).getText());
				                    		_exprDecision += _input.LT(-1).getText();
				                    		if(stackUsedVariables.contains(_exprDecision))
					                  			stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
				                    	
				}
				break;
			case NUMBER:
				{
				setState(125);
				match(NUMBER);

				                    		_exprDecision += _input.LT(-1).getText();
				                    	
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(129);
			match(FP);
			setState(130);
			match(ACH);
			 curThread = new ArrayList<AbstractCommand>(); 
			                      stack.push(curThread);
			                    
			setState(133); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(132);
				cmd();
				}
				}
				setState(135); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << ID))) != 0) );
			setState(137);
			match(FCH);

			                       listaTrue = stack.pop();
			                       listaFalse = new ArrayList<AbstractCommand>();
			                    
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(139);
				match(T__8);
				setState(140);
				match(ACH);

				                   	 	curThread = new ArrayList<AbstractCommand>();
				                   	 	stack.push(curThread);
				                   	 
				{
				setState(143); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(142);
					cmd();
					}
					}
					setState(145); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << ID))) != 0) );
				}
				setState(147);
				match(FCH);
				listaFalse = stack.pop();
				}
			}

			}

				               		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
				               		stack.peek().add(cmd);
			                   
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

	public static class Cmdrepet1Context extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode BOOLEAN() { return getToken(IsiLangParser.BOOLEAN, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public TerminalNode OPNOT() { return getToken(IsiLangParser.OPNOT, 0); }
		public List<TerminalNode> OPLOG() { return getTokens(IsiLangParser.OPLOG); }
		public TerminalNode OPLOG(int i) {
			return getToken(IsiLangParser.OPLOG, i);
		}
		public Cmdrepet1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdrepet1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdrepet1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdrepet1(this);
		}
	}

	public final Cmdrepet1Context cmdrepet1() throws RecognitionException {
		Cmdrepet1Context _localctx = new Cmdrepet1Context(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdrepet1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(T__9);
			setState(155);
			match(AP);
			 _exprDecision = ""; 
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				{
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPNOT) {
					{
					setState(157);
					match(OPNOT);
					 _exprDecision += "!"; 
					}
				}

				setState(174);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOLEAN:
					{
					setState(161);
					match(BOOLEAN);
					 _exprDecision += IsiBool2Java(_input.LT(-1).getText()); 
					}
					break;
				case ID:
					{
					setState(163);
					match(ID);
					 
													   	verificaID(_input.LT(-1).getText());
													   	_exprDecision = _input.LT(-1).getText();
													   	if(stackUsedVariables.contains(_exprDecision))
													   		stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
													
					setState(171);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==OPLOG) {
						{
						{
						setState(165);
						match(OPLOG);
						 _exprDecision += _input.LT(-1).getText();
						setState(167);
						match(ID);

														   		verificaID(_input.LT(-1).getText());
														   		_exprDecision += _input.LT(-1).getText();
														   		String aux = _input.LT(-1).getText();
														   		if(stackUsedVariables.contains(aux))
														   			stackUsedVariables.remove(stackUsedVariables.indexOf(aux));
														   	
						}
						}
						setState(173);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				break;
			case 2:
				{
				{
				setState(176);
				match(ID);
				 
										   	verificaID(_input.LT(-1).getText());
										   	_exprDecision = _input.LT(-1).getText();
										   	if(stackUsedVariables.contains(_exprDecision))
										   		stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
										   
				setState(178);
				match(OPREL);
				 _exprDecision += _input.LT(-1).getText(); 
				setState(184);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(180);
					match(ID);

											   		verificaID(_input.LT(-1).getText());
											   		_exprDecision += _input.LT(-1).getText();
											   		if(stackUsedVariables.contains(_exprDecision))
											   			stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
											   	
					}
					break;
				case NUMBER:
					{
					setState(182);
					match(NUMBER);

											   		_exprDecision += _input.LT(-1).getText();
											   	
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				break;
			}
			setState(188);
			match(FP);
			setState(189);
			match(ACH);
			 curThread = new ArrayList<AbstractCommand>(); 
				                     stack.push(curThread);
				                   
			setState(192); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(191);
				cmd();
				}
				}
				setState(194); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << ID))) != 0) );
			setState(196);
			match(FCH);

				                   	listaTrue = stack.pop();
				                   	CommandRepeticao1 cmd = new CommandRepeticao1(_exprDecision, listaTrue);
				                   	stack.peek().add(cmd);
				                   
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

	public static class Cmdrepet2Context extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public List<TerminalNode> ATTR() { return getTokens(IsiLangParser.ATTR); }
		public TerminalNode ATTR(int i) {
			return getToken(IsiLangParser.ATTR, i);
		}
		public List<Expr2Context> expr2() {
			return getRuleContexts(Expr2Context.class);
		}
		public Expr2Context expr2(int i) {
			return getRuleContext(Expr2Context.class,i);
		}
		public List<TerminalNode> SC() { return getTokens(IsiLangParser.SC); }
		public TerminalNode SC(int i) {
			return getToken(IsiLangParser.SC, i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public Cmdrepet2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdrepet2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdrepet2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdrepet2(this);
		}
	}

	public final Cmdrepet2Context cmdrepet2() throws RecognitionException {
		Cmdrepet2Context _localctx = new Cmdrepet2Context(_ctx, getState());
		enterRule(_localctx, 24, RULE_cmdrepet2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(T__10);
			setState(200);
			match(AP);
			setState(201);
			match(ID);

							   	_exprDecision = "";
							   	verificaID(_input.LT(-1).getText());
							    _exprDecision = _input.LT(-1).getText();
							    if(stackUsedVariables.contains(_exprDecision))
							    	stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
							   
			setState(203);
			match(ATTR);
			 _exprDecision +="="; 
			setState(205);
			expr2();
			_exprDecision += ";";
			setState(207);
			match(SC);
			setState(208);
			match(ID);

							   	verificaID(_input.LT(-1).getText());
							   	_exprDecision += _input.LT(-1).getText();
							   	if(stackUsedVariables.contains(_exprDecision))
							    	stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
							   
			setState(210);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
			setState(212);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}

							   	_exprDecision += _input.LT(-1).getText();
							   	_exprDecision += ";";
							   
			setState(214);
			match(SC);
			setState(215);
			match(ID);

							   	verificaID(_input.LT(-1).getText());
							   	_exprID = _input.LT(-1).getText();
							   	_exprDecision += _input.LT(-1).getText();
							   	if(stackUsedVariables.contains(_exprDecision))
							    	stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
							   
			setState(217);
			match(ATTR);
			 _exprDecision +="=";
			setState(219);
			expr2();
			setState(220);
			match(FP);
			setState(221);
			match(ACH);

							   	curThread = new ArrayList<AbstractCommand>(); 
				                stack.push(curThread);
				               
			setState(224); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(223);
				cmd();
				}
				}
				setState(226); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << ID))) != 0) );
			setState(228);
			match(FCH);

			                   	listaTrue = stack.pop();
			                   	CommandRepeticao2 cmd2 = new CommandRepeticao2(_exprDecision, listaTrue);
			                   	stack.peek().add(cmd2);
			                   
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

	public static class CmdswitchContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public List<TerminalNode> COLON() { return getTokens(IsiLangParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(IsiLangParser.COLON, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(IsiLangParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(IsiLangParser.NUMBER, i);
		}
		public List<TerminalNode> SC() { return getTokens(IsiLangParser.SC); }
		public TerminalNode SC(int i) {
			return getToken(IsiLangParser.SC, i);
		}
		public CmdswitchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdswitch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdswitch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdswitch(this);
		}
	}

	public final CmdswitchContext cmdswitch() throws RecognitionException {
		CmdswitchContext _localctx = new CmdswitchContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cmdswitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(T__11);
			setState(232);
			match(AP);
			setState(233);
			match(ID);

								   		_exprDecision = "";
									   	verificaID(_input.LT(-1).getText());
									    _exprDecision = _input.LT(-1).getText();
									    if(stackUsedVariables.contains(_exprDecision))
									    	stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
								   	
			setState(235);
			match(FP);
			setState(236);
			match(ACH);
			setState(242); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(237);
				match(T__12);
				setState(238);
				match(COLON);
				setState(239);
				match(NUMBER);
				setState(240);
				match(T__13);
				setState(241);
				match(SC);
				}
				}
				setState(244); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__12 );

								   		ncases += 1;
								   	
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(247);
				match(T__14);
				}
			}

			setState(250);
			match(FCH);
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

	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(IsiLangParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(IsiLangParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			termo();
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(253);
				match(OP);
				 _exprContent += _input.LT(-1).getText();
				setState(255);
				termo();
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

	public static class Expr2Context extends ParserRuleContext {
		public List<Termo2Context> termo2() {
			return getRuleContexts(Termo2Context.class);
		}
		public Termo2Context termo2(int i) {
			return getRuleContext(Termo2Context.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(IsiLangParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(IsiLangParser.OP, i);
		}
		public Expr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterExpr2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitExpr2(this);
		}
	}

	public final Expr2Context expr2() throws RecognitionException {
		Expr2Context _localctx = new Expr2Context(_ctx, getState());
		enterRule(_localctx, 30, RULE_expr2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			termo2();
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(262);
				match(OP);
				 
					             	_exprDecision += _input.LT(-1).getText();	
					             
				setState(264);
				termo2();
				}
				}
				setState(269);
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

	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public TerminalNode BOOLEAN() { return getToken(IsiLangParser.BOOLEAN, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_termo);
		try {
			setState(276);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(270);
				match(ID);
				 verificaID(_input.LT(-1).getText());
					               _exprContent += _input.LT(-1).getText();
				                 
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				match(NUMBER);

				              	_exprContent += _input.LT(-1).getText();
				              
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(274);
				match(BOOLEAN);

				                  _exprContent += IsiBool2Java(_input.LT(-1).getText());
				              
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

	public static class Termo2Context extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public Termo2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTermo2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTermo2(this);
		}
	}

	public final Termo2Context termo2() throws RecognitionException {
		Termo2Context _localctx = new Termo2Context(_ctx, getState());
		enterRule(_localctx, 34, RULE_termo2);
		try {
			setState(282);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(278);
				match(ID);
				 verificaID(_input.LT(-1).getText());
					               _exprDecision += _input.LT(-1).getText();
				                 
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(280);
				match(NUMBER);

				              	_exprDecision += _input.LT(-1).getText();
				              
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u011f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\6\4\61\n\4\r\4\16\4"+
		"\62\3\5\3\5\3\5\3\5\3\5\3\5\7\5;\n\5\f\5\16\5>\13\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\5\6H\n\6\3\7\3\7\6\7L\n\7\r\7\16\7M\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\5\bV\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\5\nf\n\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13s\n\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0082\n\f"+
		"\3\f\3\f\3\f\3\f\6\f\u0088\n\f\r\f\16\f\u0089\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\6\f\u0092\n\f\r\f\16\f\u0093\3\f\3\f\3\f\5\f\u0099\n\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\5\r\u00a2\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00ac"+
		"\n\r\f\r\16\r\u00af\13\r\5\r\u00b1\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\5\r\u00bb\n\r\5\r\u00bd\n\r\3\r\3\r\3\r\3\r\6\r\u00c3\n\r\r\r\16\r\u00c4"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\6"+
		"\16\u00e3\n\16\r\16\16\16\u00e4\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\6\17\u00f5\n\17\r\17\16\17\u00f6\3\17\3"+
		"\17\5\17\u00fb\n\17\3\17\3\17\3\20\3\20\3\20\3\20\7\20\u0103\n\20\f\20"+
		"\16\20\u0106\13\20\3\21\3\21\3\21\3\21\7\21\u010c\n\21\f\21\16\21\u010f"+
		"\13\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0117\n\22\3\23\3\23\3\23\3"+
		"\23\5\23\u011d\n\23\3\23\2\2\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$\2\3\3\2\35\36\2\u012a\2&\3\2\2\2\4,\3\2\2\2\6\60\3\2\2\2\b\64\3\2"+
		"\2\2\nG\3\2\2\2\fI\3\2\2\2\16U\3\2\2\2\20W\3\2\2\2\22_\3\2\2\2\24k\3\2"+
		"\2\2\26w\3\2\2\2\30\u009c\3\2\2\2\32\u00c9\3\2\2\2\34\u00e9\3\2\2\2\36"+
		"\u00fe\3\2\2\2 \u0107\3\2\2\2\"\u0116\3\2\2\2$\u011c\3\2\2\2&\'\7\3\2"+
		"\2\'(\5\6\4\2()\5\f\7\2)*\5\4\3\2*+\b\2\1\2+\3\3\2\2\2,-\7\4\2\2-.\b\3"+
		"\1\2.\5\3\2\2\2/\61\5\b\5\2\60/\3\2\2\2\61\62\3\2\2\2\62\60\3\2\2\2\62"+
		"\63\3\2\2\2\63\7\3\2\2\2\64\65\5\n\6\2\65\66\7\35\2\2\66<\b\5\1\2\678"+
		"\7\31\2\289\7\35\2\29;\b\5\1\2:\67\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2"+
		"\2=?\3\2\2\2><\3\2\2\2?@\7\26\2\2@\t\3\2\2\2AB\7\5\2\2BH\b\6\1\2CD\7\6"+
		"\2\2DH\b\6\1\2EF\7\7\2\2FH\b\6\1\2GA\3\2\2\2GC\3\2\2\2GE\3\2\2\2H\13\3"+
		"\2\2\2IK\b\7\1\2JL\5\16\b\2KJ\3\2\2\2LM\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\r"+
		"\3\2\2\2OV\5\20\t\2PV\5\22\n\2QV\5\24\13\2RV\5\26\f\2SV\5\30\r\2TV\5\32"+
		"\16\2UO\3\2\2\2UP\3\2\2\2UQ\3\2\2\2UR\3\2\2\2US\3\2\2\2UT\3\2\2\2V\17"+
		"\3\2\2\2WX\7\b\2\2XY\7\23\2\2YZ\7\35\2\2Z[\b\t\1\2[\\\7\24\2\2\\]\7\26"+
		"\2\2]^\b\t\1\2^\21\3\2\2\2_`\7\t\2\2`e\7\23\2\2ab\7\35\2\2bf\b\n\1\2c"+
		"d\7\37\2\2df\b\n\1\2ea\3\2\2\2ec\3\2\2\2fg\3\2\2\2gh\7\24\2\2hi\7\26\2"+
		"\2ij\b\n\1\2j\23\3\2\2\2kl\7\35\2\2lm\b\13\1\2mn\7\30\2\2nr\b\13\1\2o"+
		"s\5\36\20\2pq\7\37\2\2qs\b\13\1\2ro\3\2\2\2rp\3\2\2\2st\3\2\2\2tu\7\26"+
		"\2\2uv\b\13\1\2v\25\3\2\2\2wx\7\n\2\2xy\7\23\2\2yz\7\35\2\2z{\b\f\1\2"+
		"{|\7\34\2\2|\u0081\b\f\1\2}~\7\35\2\2~\u0082\b\f\1\2\177\u0080\7\36\2"+
		"\2\u0080\u0082\b\f\1\2\u0081}\3\2\2\2\u0081\177\3\2\2\2\u0082\u0083\3"+
		"\2\2\2\u0083\u0084\7\24\2\2\u0084\u0085\7\32\2\2\u0085\u0087\b\f\1\2\u0086"+
		"\u0088\5\16\b\2\u0087\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u0087\3"+
		"\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\7\33\2\2\u008c"+
		"\u0098\b\f\1\2\u008d\u008e\7\13\2\2\u008e\u008f\7\32\2\2\u008f\u0091\b"+
		"\f\1\2\u0090\u0092\5\16\b\2\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\7\33"+
		"\2\2\u0096\u0097\b\f\1\2\u0097\u0099\3\2\2\2\u0098\u008d\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\b\f\1\2\u009b\27\3\2\2"+
		"\2\u009c\u009d\7\f\2\2\u009d\u009e\7\23\2\2\u009e\u00bc\b\r\1\2\u009f"+
		"\u00a0\7!\2\2\u00a0\u00a2\b\r\1\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2"+
		"\2\2\u00a2\u00b0\3\2\2\2\u00a3\u00a4\7 \2\2\u00a4\u00b1\b\r\1\2\u00a5"+
		"\u00a6\7\35\2\2\u00a6\u00ad\b\r\1\2\u00a7\u00a8\7\"\2\2\u00a8\u00a9\b"+
		"\r\1\2\u00a9\u00aa\7\35\2\2\u00aa\u00ac\b\r\1\2\u00ab\u00a7\3\2\2\2\u00ac"+
		"\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b1\3\2"+
		"\2\2\u00af\u00ad\3\2\2\2\u00b0\u00a3\3\2\2\2\u00b0\u00a5\3\2\2\2\u00b1"+
		"\u00bd\3\2\2\2\u00b2\u00b3\7\35\2\2\u00b3\u00b4\b\r\1\2\u00b4\u00b5\7"+
		"\34\2\2\u00b5\u00ba\b\r\1\2\u00b6\u00b7\7\35\2\2\u00b7\u00bb\b\r\1\2\u00b8"+
		"\u00b9\7\36\2\2\u00b9\u00bb\b\r\1\2\u00ba\u00b6\3\2\2\2\u00ba\u00b8\3"+
		"\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00a1\3\2\2\2\u00bc\u00b2\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be\u00bf\7\24\2\2\u00bf\u00c0\7\32\2\2\u00c0\u00c2\b"+
		"\r\1\2\u00c1\u00c3\5\16\b\2\u00c2\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\7\33"+
		"\2\2\u00c7\u00c8\b\r\1\2\u00c8\31\3\2\2\2\u00c9\u00ca\7\r\2\2\u00ca\u00cb"+
		"\7\23\2\2\u00cb\u00cc\7\35\2\2\u00cc\u00cd\b\16\1\2\u00cd\u00ce\7\30\2"+
		"\2\u00ce\u00cf\b\16\1\2\u00cf\u00d0\5 \21\2\u00d0\u00d1\b\16\1\2\u00d1"+
		"\u00d2\7\26\2\2\u00d2\u00d3\7\35\2\2\u00d3\u00d4\b\16\1\2\u00d4\u00d5"+
		"\7\34\2\2\u00d5\u00d6\b\16\1\2\u00d6\u00d7\t\2\2\2\u00d7\u00d8\b\16\1"+
		"\2\u00d8\u00d9\7\26\2\2\u00d9\u00da\7\35\2\2\u00da\u00db\b\16\1\2\u00db"+
		"\u00dc\7\30\2\2\u00dc\u00dd\b\16\1\2\u00dd\u00de\5 \21\2\u00de\u00df\7"+
		"\24\2\2\u00df\u00e0\7\32\2\2\u00e0\u00e2\b\16\1\2\u00e1\u00e3\5\16\b\2"+
		"\u00e2\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5"+
		"\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\7\33\2\2\u00e7\u00e8\b\16\1\2"+
		"\u00e8\33\3\2\2\2\u00e9\u00ea\7\16\2\2\u00ea\u00eb\7\23\2\2\u00eb\u00ec"+
		"\7\35\2\2\u00ec\u00ed\b\17\1\2\u00ed\u00ee\7\24\2\2\u00ee\u00f4\7\32\2"+
		"\2\u00ef\u00f0\7\17\2\2\u00f0\u00f1\7\25\2\2\u00f1\u00f2\7\36\2\2\u00f2"+
		"\u00f3\7\20\2\2\u00f3\u00f5\7\26\2\2\u00f4\u00ef\3\2\2\2\u00f5\u00f6\3"+
		"\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8"+
		"\u00fa\b\17\1\2\u00f9\u00fb\7\21\2\2\u00fa\u00f9\3\2\2\2\u00fa\u00fb\3"+
		"\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\7\33\2\2\u00fd\35\3\2\2\2\u00fe"+
		"\u0104\5\"\22\2\u00ff\u0100\7\27\2\2\u0100\u0101\b\20\1\2\u0101\u0103"+
		"\5\"\22\2\u0102\u00ff\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2"+
		"\u0104\u0105\3\2\2\2\u0105\37\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u010d"+
		"\5$\23\2\u0108\u0109\7\27\2\2\u0109\u010a\b\21\1\2\u010a\u010c\5$\23\2"+
		"\u010b\u0108\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e"+
		"\3\2\2\2\u010e!\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0111\7\35\2\2\u0111"+
		"\u0117\b\22\1\2\u0112\u0113\7\36\2\2\u0113\u0117\b\22\1\2\u0114\u0115"+
		"\7 \2\2\u0115\u0117\b\22\1\2\u0116\u0110\3\2\2\2\u0116\u0112\3\2\2\2\u0116"+
		"\u0114\3\2\2\2\u0117#\3\2\2\2\u0118\u0119\7\35\2\2\u0119\u011d\b\23\1"+
		"\2\u011a\u011b\7\36\2\2\u011b\u011d\b\23\1\2\u011c\u0118\3\2\2\2\u011c"+
		"\u011a\3\2\2\2\u011d%\3\2\2\2\32\62<GMUer\u0081\u0089\u0093\u0098\u00a1"+
		"\u00ad\u00b0\u00ba\u00bc\u00c4\u00e4\u00f6\u00fa\u0104\u010d\u0116\u011c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}