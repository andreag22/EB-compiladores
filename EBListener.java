// Generated from EB.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EBParser}.
 */
public interface EBListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EBParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(EBParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link EBParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(EBParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link EBParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(EBParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link EBParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(EBParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link EBParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(EBParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link EBParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(EBParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link EBParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(EBParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link EBParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(EBParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link EBParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignStatement(EBParser.AssignStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link EBParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignStatement(EBParser.AssignStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link EBParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(EBParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EBParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(EBParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EBParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(EBParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link EBParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(EBParser.OperatorContext ctx);
}