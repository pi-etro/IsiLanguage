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

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IsiLangParser}.
 */
public interface IsiLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(IsiLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(IsiLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#fimprog}.
	 * @param ctx the parse tree
	 */
	void enterFimprog(IsiLangParser.FimprogContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#fimprog}.
	 * @param ctx the parse tree
	 */
	void exitFimprog(IsiLangParser.FimprogContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(IsiLangParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(IsiLangParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(IsiLangParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(IsiLangParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(IsiLangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(IsiLangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(IsiLangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(IsiLangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(IsiLangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(IsiLangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(IsiLangParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(IsiLangParser.CmdleituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(IsiLangParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(IsiLangParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(IsiLangParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(IsiLangParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void enterCmdselecao(IsiLangParser.CmdselecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void exitCmdselecao(IsiLangParser.CmdselecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdrepet1}.
	 * @param ctx the parse tree
	 */
	void enterCmdrepet1(IsiLangParser.Cmdrepet1Context ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdrepet1}.
	 * @param ctx the parse tree
	 */
	void exitCmdrepet1(IsiLangParser.Cmdrepet1Context ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdrepet2}.
	 * @param ctx the parse tree
	 */
	void enterCmdrepet2(IsiLangParser.Cmdrepet2Context ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdrepet2}.
	 * @param ctx the parse tree
	 */
	void exitCmdrepet2(IsiLangParser.Cmdrepet2Context ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdcomment}.
	 * @param ctx the parse tree
	 */
	void enterCmdcomment(IsiLangParser.CmdcommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdcomment}.
	 * @param ctx the parse tree
	 */
	void exitCmdcomment(IsiLangParser.CmdcommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdswitch}.
	 * @param ctx the parse tree
	 */
	void enterCmdswitch(IsiLangParser.CmdswitchContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdswitch}.
	 * @param ctx the parse tree
	 */
	void exitCmdswitch(IsiLangParser.CmdswitchContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(IsiLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(IsiLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#expr2}.
	 * @param ctx the parse tree
	 */
	void enterExpr2(IsiLangParser.Expr2Context ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#expr2}.
	 * @param ctx the parse tree
	 */
	void exitExpr2(IsiLangParser.Expr2Context ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(IsiLangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(IsiLangParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#termo2}.
	 * @param ctx the parse tree
	 */
	void enterTermo2(IsiLangParser.Termo2Context ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#termo2}.
	 * @param ctx the parse tree
	 */
	void exitTermo2(IsiLangParser.Termo2Context ctx);
}