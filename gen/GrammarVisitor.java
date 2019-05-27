// Generated from C:/Users/Thomas-PC/IdeaProjects/believe-revision\Grammar.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(GrammarParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Bracket}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracket(GrammarParser.BracketContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis(GrammarParser.ParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(GrammarParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(GrammarParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Implies}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplies(GrammarParser.ImpliesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(GrammarParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfAndOnlyIf}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfAndOnlyIf(GrammarParser.IfAndOnlyIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Atomic}
	 * labeled alternative in {@link GrammarParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomic(GrammarParser.AtomicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Predicate}
	 * labeled alternative in {@link GrammarParser#atomicSentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(GrammarParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Terms}
	 * labeled alternative in {@link GrammarParser#atomicSentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerms(GrammarParser.TermsContext ctx);
}