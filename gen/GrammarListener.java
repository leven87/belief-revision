// Generated from C:/Users/Thomas-PC/IdeaProjects/believe-revision\Grammar.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(GrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(GrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bracket}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterBracket(GrammarParser.BracketContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bracket}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitBracket(GrammarParser.BracketContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(GrammarParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(GrammarParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterNot(GrammarParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitNot(GrammarParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Or}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterOr(GrammarParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitOr(GrammarParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Implies}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterImplies(GrammarParser.ImpliesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Implies}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitImplies(GrammarParser.ImpliesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterAnd(GrammarParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitAnd(GrammarParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfAndOnlyIf}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterIfAndOnlyIf(GrammarParser.IfAndOnlyIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfAndOnlyIf}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitIfAndOnlyIf(GrammarParser.IfAndOnlyIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Atomic}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterAtomic(GrammarParser.AtomicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Atomic}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitAtomic(GrammarParser.AtomicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Predicate}
	 * labeled alternative in {@link GrammarParser#atomicSentence}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(GrammarParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Predicate}
	 * labeled alternative in {@link GrammarParser#atomicSentence}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(GrammarParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Terms}
	 * labeled alternative in {@link GrammarParser#atomicSentence}.
	 * @param ctx the parse tree
	 */
	void enterTerms(GrammarParser.TermsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Terms}
	 * labeled alternative in {@link GrammarParser#atomicSentence}.
	 * @param ctx the parse tree
	 */
	void exitTerms(GrammarParser.TermsContext ctx);
}