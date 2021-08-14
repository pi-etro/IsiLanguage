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
	import br.com.professorisidro.isilanguage.ast.CommandComentario;
	import br.com.professorisidro.isilanguage.ast.CommandSwitch;
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
		ID=27, NUMBER=28, STRING=29, CMT=30, DFS=31, BOOLEAN=32, OPNOT=33, OPLOG=34, 
		WS=35;
	public static final int
		RULE_prog = 0, RULE_fimprog = 1, RULE_decl = 2, RULE_declaravar = 3, RULE_tipo = 4, 
		RULE_bloco = 5, RULE_cmd = 6, RULE_cmdleitura = 7, RULE_cmdescrita = 8, 
		RULE_cmdattrib = 9, RULE_cmdselecao = 10, RULE_cmdrepet1 = 11, RULE_cmdrepet2 = 12, 
		RULE_cmdcomment = 13, RULE_cmdswitch = 14, RULE_expr = 15, RULE_expr2 = 16, 
		RULE_termo = 17, RULE_termo2 = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "fimprog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", 
			"cmdescrita", "cmdattrib", "cmdselecao", "cmdrepet1", "cmdrepet2", "cmdcomment", 
			"cmdswitch", "expr", "expr2", "termo", "termo2"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog;'", "'numero'", "'texto'", "'booleano'", 
			"'leia'", "'escreva'", "'se'", "'senao'", "'enquanto'", "'para'", "'switch'", 
			"'case'", "'break'", "'default'", "'\"'", "'('", "')'", "':'", "';'", 
			null, "'='", "','", "'{'", "'}'", null, null, null, null, null, "'//'", 
			null, "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "ASP", "AP", "FP", "COLON", "SC", "OP", "ATTR", 
			"VIR", "ACH", "FCH", "OPREL", "ID", "NUMBER", "STRING", "CMT", "DFS", 
			"BOOLEAN", "OPNOT", "OPLOG", "WS"
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
			setState(38);
			match(T__0);
			setState(39);
			decl();
			setState(40);
			bloco();
			setState(41);
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
			setState(44);
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
			setState(48); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(47);
				declaravar();
				}
				}
				setState(50); 
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
			setState(52);
			tipo();
			setState(53);
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
			                    
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(55);
				match(VIR);
				setState(56);
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
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
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
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(T__2);
				 _tipo = IsiVariable.NUMBER;  
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				match(T__3);
				 _tipo = IsiVariable.TEXT;  
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
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
			          
			setState(75); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(74);
				cmd();
				}
				}
				setState(77); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << ID) | (1L << CMT))) != 0) );
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
		public CmdcommentContext cmdcomment() {
			return getRuleContext(CmdcommentContext.class,0);
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
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				cmdleitura();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				cmdattrib();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(82);
				cmdselecao();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(83);
				cmdrepet1();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 6);
				{
				setState(84);
				cmdrepet2();
				}
				break;
			case CMT:
				enterOuterAlt(_localctx, 7);
				{
				setState(85);
				cmdcomment();
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
			setState(88);
			match(T__5);
			setState(89);
			match(AP);
			setState(90);
			match(ID);
			 verificaID(_input.LT(-1).getText());
			                     	  _readID = _input.LT(-1).getText();
			                        
			setState(92);
			match(FP);
			setState(93);
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
			setState(96);
			match(T__6);
			setState(97);
			match(AP);
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(98);
				match(ID);
				 verificaID(_input.LT(-1).getText());
					                  _writeID = _input.LT(-1).getText();
					                  if(stackUsedVariables.contains(_writeID))
					                  	stackUsedVariables.remove(stackUsedVariables.indexOf(_writeID));
				                     
				}
				break;
			case STRING:
				{
				setState(100);
				match(STRING);
				_writeID = _input.LT(-1).getText() ;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(104);
			match(FP);
			setState(105);
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
			setState(108);
			match(ID);
			 verificaID(_input.LT(-1).getText());
			                    _exprID = _input.LT(-1).getText();
			                   
			setState(110);
			match(ATTR);
			 _exprContent = ""; 
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case NUMBER:
			case BOOLEAN:
				{
				setState(112);
				expr();
				}
				break;
			case STRING:
				{
				setState(113);
				match(STRING);
				_exprContent += _input.LT(-1).getText() ;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(117);
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
			setState(120);
			match(T__7);
			{
			setState(121);
			match(AP);
			setState(122);
			match(ID);
			 
			                    	verificaID(_input.LT(-1).getText());
			                    	_exprDecision = _input.LT(-1).getText();
			                    	if(stackUsedVariables.contains(_exprDecision))
				                  		stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
			                    
			setState(124);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(126);
				match(ID);

				                    		verificaID(_input.LT(-1).getText());
				                    		_exprDecision += _input.LT(-1).getText();
				                    		if(stackUsedVariables.contains(_exprDecision))
					                  			stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
				                    	
				}
				break;
			case NUMBER:
				{
				setState(128);
				match(NUMBER);

				                    		_exprDecision += _input.LT(-1).getText();
				                    	
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(132);
			match(FP);
			setState(133);
			match(ACH);
			 curThread = new ArrayList<AbstractCommand>(); 
			                      stack.push(curThread);
			                    
			setState(136); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(135);
				cmd();
				}
				}
				setState(138); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << ID) | (1L << CMT))) != 0) );
			setState(140);
			match(FCH);

			                       listaTrue = stack.pop();
			                       listaFalse = new ArrayList<AbstractCommand>();
			                    
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(142);
				match(T__8);
				setState(143);
				match(ACH);

				                   	 	curThread = new ArrayList<AbstractCommand>();
				                   	 	stack.push(curThread);
				                   	 
				{
				setState(146); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(145);
					cmd();
					}
					}
					setState(148); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << ID) | (1L << CMT))) != 0) );
				}
				setState(150);
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
			setState(157);
			match(T__9);
			setState(158);
			match(AP);
			 _exprDecision = ""; 
			setState(189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				{
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPNOT) {
					{
					setState(160);
					match(OPNOT);
					 _exprDecision += "!"; 
					}
				}

				setState(177);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOLEAN:
					{
					setState(164);
					match(BOOLEAN);
					 _exprDecision += IsiBool2Java(_input.LT(-1).getText()); 
					}
					break;
				case ID:
					{
					setState(166);
					match(ID);
					 
													   	verificaID(_input.LT(-1).getText());
													   	_exprDecision = _input.LT(-1).getText();
													   	if(stackUsedVariables.contains(_exprDecision))
													   		stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
													
					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==OPLOG) {
						{
						{
						setState(168);
						match(OPLOG);
						 _exprDecision += _input.LT(-1).getText();
						setState(170);
						match(ID);

														   		verificaID(_input.LT(-1).getText());
														   		_exprDecision += _input.LT(-1).getText();
														   		String aux = _input.LT(-1).getText();
														   		if(stackUsedVariables.contains(aux))
														   			stackUsedVariables.remove(stackUsedVariables.indexOf(aux));
														   	
						}
						}
						setState(176);
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
				setState(179);
				match(ID);
				 
										   	verificaID(_input.LT(-1).getText());
										   	_exprDecision = _input.LT(-1).getText();
										   	if(stackUsedVariables.contains(_exprDecision))
										   		stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
										   
				setState(181);
				match(OPREL);
				 _exprDecision += _input.LT(-1).getText(); 
				setState(187);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(183);
					match(ID);

											   		verificaID(_input.LT(-1).getText());
											   		_exprDecision += _input.LT(-1).getText();
											   		if(stackUsedVariables.contains(_exprDecision))
											   			stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
											   	
					}
					break;
				case NUMBER:
					{
					setState(185);
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
			setState(191);
			match(FP);
			setState(192);
			match(ACH);
			 curThread = new ArrayList<AbstractCommand>(); 
				                     stack.push(curThread);
				                   
			setState(195); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(194);
				cmd();
				}
				}
				setState(197); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << ID) | (1L << CMT))) != 0) );
			setState(199);
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
			setState(202);
			match(T__10);
			setState(203);
			match(AP);
			setState(204);
			match(ID);

							   	_exprDecision = "";
							   	verificaID(_input.LT(-1).getText());
							    _exprDecision = _input.LT(-1).getText();
							    if(stackUsedVariables.contains(_exprDecision))
							    	stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
							   
			setState(206);
			match(ATTR);
			 _exprDecision +="="; 
			setState(208);
			expr2();
			_exprDecision += ";";
			setState(210);
			match(SC);
			setState(211);
			match(ID);

							   	verificaID(_input.LT(-1).getText());
							   	_exprDecision += _input.LT(-1).getText();
							   	if(stackUsedVariables.contains(_exprDecision))
							    	stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
							   
			setState(213);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
			setState(215);
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
							   
			setState(217);
			match(SC);
			setState(218);
			match(ID);

							   	verificaID(_input.LT(-1).getText());
							   	_exprID = _input.LT(-1).getText();
							   	_exprDecision += _input.LT(-1).getText();
							   	if(stackUsedVariables.contains(_exprDecision))
							    	stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
							   
			setState(220);
			match(ATTR);
			 _exprDecision +="=";
			setState(222);
			expr2();
			setState(223);
			match(FP);
			setState(224);
			match(ACH);

							   	curThread = new ArrayList<AbstractCommand>(); 
				                stack.push(curThread);
				               
			setState(227); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(226);
				cmd();
				}
				}
				setState(229); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << ID) | (1L << CMT))) != 0) );
			setState(231);
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

	public static class CmdcommentContext extends ParserRuleContext {
		public TerminalNode CMT() { return getToken(IsiLangParser.CMT, 0); }
		public CmdcommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdcomment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdcomment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdcomment(this);
		}
	}

	public final CmdcommentContext cmdcomment() throws RecognitionException {
		CmdcommentContext _localctx = new CmdcommentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cmdcomment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(CMT);

								String comment = _input.LT(-1).getText();
								CommandComentario cmd = new CommandComentario(comment);
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
		enterRule(_localctx, 28, RULE_cmdswitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(T__11);
			setState(238);
			match(AP);
			setState(239);
			match(ID);

									   	verificaID(_input.LT(-1).getText());
									    _exprDecision = _input.LT(-1).getText();
									    if(stackUsedVariables.contains(_exprDecision))
									    	stackUsedVariables.remove(stackUsedVariables.indexOf(_exprDecision));
								   	
			setState(241);
			match(FP);
			setState(242);
			match(ACH);
			setState(248); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(243);
				match(T__12);
				setState(244);
				match(COLON);
				setState(245);
				match(NUMBER);
				setState(246);
				match(T__13);
				setState(247);
				match(SC);
				}
				}
				setState(250); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__12 );

								   		ncases += 1;
								   	
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(253);
				match(T__14);
				}
			}

			setState(256);
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
		enterRule(_localctx, 30, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			termo();
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(259);
				match(OP);
				 _exprContent += _input.LT(-1).getText();
				setState(261);
				termo();
				}
				}
				setState(266);
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
		enterRule(_localctx, 32, RULE_expr2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			termo2();
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(268);
				match(OP);
				 
					             	_exprDecision += _input.LT(-1).getText();	
					             
				setState(270);
				termo2();
				}
				}
				setState(275);
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
		enterRule(_localctx, 34, RULE_termo);
		try {
			setState(282);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(276);
				match(ID);
				 verificaID(_input.LT(-1).getText());
					               _exprContent += _input.LT(-1).getText();
				                 
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(278);
				match(NUMBER);

				              	_exprContent += _input.LT(-1).getText();
				              
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(280);
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
		enterRule(_localctx, 36, RULE_termo2);
		try {
			setState(288);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				match(ID);
				 verificaID(_input.LT(-1).getText());
					               _exprDecision += _input.LT(-1).getText();
				                 
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u0125\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\6\4\63\n"+
		"\4\r\4\16\4\64\3\5\3\5\3\5\3\5\3\5\3\5\7\5=\n\5\f\5\16\5@\13\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\5\6J\n\6\3\7\3\7\6\7N\n\7\r\7\16\7O\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\5\bY\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\5\ni\n\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13v\n\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\5\f\u0085\n\f\3\f\3\f\3\f\3\f\6\f\u008b\n\f\r\f\16\f\u008c\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\6\f\u0095\n\f\r\f\16\f\u0096\3\f\3\f\3\f\5\f\u009c\n"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\5\r\u00a5\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\7\r\u00af\n\r\f\r\16\r\u00b2\13\r\5\r\u00b4\n\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\5\r\u00be\n\r\5\r\u00c0\n\r\3\r\3\r\3\r\3\r\6\r\u00c6"+
		"\n\r\r\r\16\r\u00c7\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\6\16\u00e6\n\16\r\16\16\16\u00e7\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\6\20\u00fb"+
		"\n\20\r\20\16\20\u00fc\3\20\3\20\5\20\u0101\n\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\7\21\u0109\n\21\f\21\16\21\u010c\13\21\3\22\3\22\3\22\3\22\7"+
		"\22\u0112\n\22\f\22\16\22\u0115\13\22\3\23\3\23\3\23\3\23\3\23\3\23\5"+
		"\23\u011d\n\23\3\24\3\24\3\24\3\24\5\24\u0123\n\24\3\24\2\2\25\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\3\3\2\35\36\2\u0130\2(\3\2\2\2"+
		"\4.\3\2\2\2\6\62\3\2\2\2\b\66\3\2\2\2\nI\3\2\2\2\fK\3\2\2\2\16X\3\2\2"+
		"\2\20Z\3\2\2\2\22b\3\2\2\2\24n\3\2\2\2\26z\3\2\2\2\30\u009f\3\2\2\2\32"+
		"\u00cc\3\2\2\2\34\u00ec\3\2\2\2\36\u00ef\3\2\2\2 \u0104\3\2\2\2\"\u010d"+
		"\3\2\2\2$\u011c\3\2\2\2&\u0122\3\2\2\2()\7\3\2\2)*\5\6\4\2*+\5\f\7\2+"+
		",\5\4\3\2,-\b\2\1\2-\3\3\2\2\2./\7\4\2\2/\60\b\3\1\2\60\5\3\2\2\2\61\63"+
		"\5\b\5\2\62\61\3\2\2\2\63\64\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\7"+
		"\3\2\2\2\66\67\5\n\6\2\678\7\35\2\28>\b\5\1\29:\7\31\2\2:;\7\35\2\2;="+
		"\b\5\1\2<9\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?A\3\2\2\2@>\3\2\2\2A"+
		"B\7\26\2\2B\t\3\2\2\2CD\7\5\2\2DJ\b\6\1\2EF\7\6\2\2FJ\b\6\1\2GH\7\7\2"+
		"\2HJ\b\6\1\2IC\3\2\2\2IE\3\2\2\2IG\3\2\2\2J\13\3\2\2\2KM\b\7\1\2LN\5\16"+
		"\b\2ML\3\2\2\2NO\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\r\3\2\2\2QY\5\20\t\2RY\5"+
		"\22\n\2SY\5\24\13\2TY\5\26\f\2UY\5\30\r\2VY\5\32\16\2WY\5\34\17\2XQ\3"+
		"\2\2\2XR\3\2\2\2XS\3\2\2\2XT\3\2\2\2XU\3\2\2\2XV\3\2\2\2XW\3\2\2\2Y\17"+
		"\3\2\2\2Z[\7\b\2\2[\\\7\23\2\2\\]\7\35\2\2]^\b\t\1\2^_\7\24\2\2_`\7\26"+
		"\2\2`a\b\t\1\2a\21\3\2\2\2bc\7\t\2\2ch\7\23\2\2de\7\35\2\2ei\b\n\1\2f"+
		"g\7\37\2\2gi\b\n\1\2hd\3\2\2\2hf\3\2\2\2ij\3\2\2\2jk\7\24\2\2kl\7\26\2"+
		"\2lm\b\n\1\2m\23\3\2\2\2no\7\35\2\2op\b\13\1\2pq\7\30\2\2qu\b\13\1\2r"+
		"v\5 \21\2st\7\37\2\2tv\b\13\1\2ur\3\2\2\2us\3\2\2\2vw\3\2\2\2wx\7\26\2"+
		"\2xy\b\13\1\2y\25\3\2\2\2z{\7\n\2\2{|\7\23\2\2|}\7\35\2\2}~\b\f\1\2~\177"+
		"\7\34\2\2\177\u0084\b\f\1\2\u0080\u0081\7\35\2\2\u0081\u0085\b\f\1\2\u0082"+
		"\u0083\7\36\2\2\u0083\u0085\b\f\1\2\u0084\u0080\3\2\2\2\u0084\u0082\3"+
		"\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\7\24\2\2\u0087\u0088\7\32\2\2\u0088"+
		"\u008a\b\f\1\2\u0089\u008b\5\16\b\2\u008a\u0089\3\2\2\2\u008b\u008c\3"+
		"\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e"+
		"\u008f\7\33\2\2\u008f\u009b\b\f\1\2\u0090\u0091\7\13\2\2\u0091\u0092\7"+
		"\32\2\2\u0092\u0094\b\f\1\2\u0093\u0095\5\16\b\2\u0094\u0093\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\u0099\7\33\2\2\u0099\u009a\b\f\1\2\u009a\u009c\3\2\2\2\u009b"+
		"\u0090\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\b\f"+
		"\1\2\u009e\27\3\2\2\2\u009f\u00a0\7\f\2\2\u00a0\u00a1\7\23\2\2\u00a1\u00bf"+
		"\b\r\1\2\u00a2\u00a3\7#\2\2\u00a3\u00a5\b\r\1\2\u00a4\u00a2\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\u00b3\3\2\2\2\u00a6\u00a7\7\"\2\2\u00a7\u00b4\b\r"+
		"\1\2\u00a8\u00a9\7\35\2\2\u00a9\u00b0\b\r\1\2\u00aa\u00ab\7$\2\2\u00ab"+
		"\u00ac\b\r\1\2\u00ac\u00ad\7\35\2\2\u00ad\u00af\b\r\1\2\u00ae\u00aa\3"+
		"\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00a6\3\2\2\2\u00b3\u00a8\3\2"+
		"\2\2\u00b4\u00c0\3\2\2\2\u00b5\u00b6\7\35\2\2\u00b6\u00b7\b\r\1\2\u00b7"+
		"\u00b8\7\34\2\2\u00b8\u00bd\b\r\1\2\u00b9\u00ba\7\35\2\2\u00ba\u00be\b"+
		"\r\1\2\u00bb\u00bc\7\36\2\2\u00bc\u00be\b\r\1\2\u00bd\u00b9\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00a4\3\2\2\2\u00bf\u00b5\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\7\24\2\2\u00c2\u00c3\7\32\2\2\u00c3"+
		"\u00c5\b\r\1\2\u00c4\u00c6\5\16\b\2\u00c5\u00c4\3\2\2\2\u00c6\u00c7\3"+
		"\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\u00ca\7\33\2\2\u00ca\u00cb\b\r\1\2\u00cb\31\3\2\2\2\u00cc\u00cd\7\r\2"+
		"\2\u00cd\u00ce\7\23\2\2\u00ce\u00cf\7\35\2\2\u00cf\u00d0\b\16\1\2\u00d0"+
		"\u00d1\7\30\2\2\u00d1\u00d2\b\16\1\2\u00d2\u00d3\5\"\22\2\u00d3\u00d4"+
		"\b\16\1\2\u00d4\u00d5\7\26\2\2\u00d5\u00d6\7\35\2\2\u00d6\u00d7\b\16\1"+
		"\2\u00d7\u00d8\7\34\2\2\u00d8\u00d9\b\16\1\2\u00d9\u00da\t\2\2\2\u00da"+
		"\u00db\b\16\1\2\u00db\u00dc\7\26\2\2\u00dc\u00dd\7\35\2\2\u00dd\u00de"+
		"\b\16\1\2\u00de\u00df\7\30\2\2\u00df\u00e0\b\16\1\2\u00e0\u00e1\5\"\22"+
		"\2\u00e1\u00e2\7\24\2\2\u00e2\u00e3\7\32\2\2\u00e3\u00e5\b\16\1\2\u00e4"+
		"\u00e6\5\16\b\2\u00e5\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e5\3"+
		"\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\7\33\2\2\u00ea"+
		"\u00eb\b\16\1\2\u00eb\33\3\2\2\2\u00ec\u00ed\7 \2\2\u00ed\u00ee\b\17\1"+
		"\2\u00ee\35\3\2\2\2\u00ef\u00f0\7\16\2\2\u00f0\u00f1\7\23\2\2\u00f1\u00f2"+
		"\7\35\2\2\u00f2\u00f3\b\20\1\2\u00f3\u00f4\7\24\2\2\u00f4\u00fa\7\32\2"+
		"\2\u00f5\u00f6\7\17\2\2\u00f6\u00f7\7\25\2\2\u00f7\u00f8\7\36\2\2\u00f8"+
		"\u00f9\7\20\2\2\u00f9\u00fb\7\26\2\2\u00fa\u00f5\3\2\2\2\u00fb\u00fc\3"+
		"\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe"+
		"\u0100\b\20\1\2\u00ff\u0101\7\21\2\2\u0100\u00ff\3\2\2\2\u0100\u0101\3"+
		"\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\7\33\2\2\u0103\37\3\2\2\2\u0104"+
		"\u010a\5$\23\2\u0105\u0106\7\27\2\2\u0106\u0107\b\21\1\2\u0107\u0109\5"+
		"$\23\2\u0108\u0105\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b!\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u0113\5&\24\2"+
		"\u010e\u010f\7\27\2\2\u010f\u0110\b\22\1\2\u0110\u0112\5&\24\2\u0111\u010e"+
		"\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114"+
		"#\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u0117\7\35\2\2\u0117\u011d\b\23\1"+
		"\2\u0118\u0119\7\36\2\2\u0119\u011d\b\23\1\2\u011a\u011b\7\"\2\2\u011b"+
		"\u011d\b\23\1\2\u011c\u0116\3\2\2\2\u011c\u0118\3\2\2\2\u011c\u011a\3"+
		"\2\2\2\u011d%\3\2\2\2\u011e\u011f\7\35\2\2\u011f\u0123\b\24\1\2\u0120"+
		"\u0121\7\36\2\2\u0121\u0123\b\24\1\2\u0122\u011e\3\2\2\2\u0122\u0120\3"+
		"\2\2\2\u0123\'\3\2\2\2\32\64>IOXhu\u0084\u008c\u0096\u009b\u00a4\u00b0"+
		"\u00b3\u00bd\u00bf\u00c7\u00e7\u00fc\u0100\u010a\u0113\u011c\u0122";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}