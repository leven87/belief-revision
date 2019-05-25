import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

public class Validator extends AbstractParseTreeVisitor<Boolean> implements GrammarVisitor <Boolean> {

    @Override
    public Boolean visitStart(GrammarParser.StartContext ctx) {
        return visit(ctx.sentence);
    }

    @Override
    public Boolean visitAtomic(GrammarParser.AtomicContext ctx) {
        return visit(ctx.atomicSentence());
    }

    @Override
    public Boolean visitParenthesis(GrammarParser.ParenthesisContext ctx) {
        return visit(ctx.sentence());
    }

    @Override
    public Boolean visitBracket(GrammarParser.BracketContext ctx) {
        return visit(ctx.sentence());
    }

    @Override
    public Boolean visitNot(GrammarParser.NotContext ctx) {
        return !visit(ctx.sentence());
    }

    @Override
    public Boolean visitAnd(GrammarParser.AndContext ctx) {
        return visit(ctx.s1) && visit(ctx.s2);
    }

    @Override
    public Boolean visitOr(GrammarParser.OrContext ctx) {
        return visit(ctx.s1) || visit(ctx.s2);
    }

    @Override
    public Boolean visitImplies(GrammarParser.ImpliesContext ctx) {
        if (visit(ctx.s1))
            return visit(ctx.s2);
        return true;
    }

    @Override
    public Boolean visitIfAndOnlyIf(GrammarParser.IfAndOnlyIfContext ctx) {
        if (visit(ctx.s1))
            return visit(ctx.s2);
        else
            return !visit(ctx.s2);
    }

    @Override
    public Boolean visitPredicate(GrammarParser.PredicateContext ctx) {
        return ctx.getText().equals("TRUE");
    }

    /*
     * Issue remains that to validate a sentence according to knowledge base, the knowledge base need to know
     * each of it's individual states.
     *
     * If we only have P, Q and R in our belief base as single statements, then we can't work with a sentence that
     * contain S, cause it doesn't exist?
     * In my mind when i started this, a knowledge base of P, Q, (P AND Q) -> S
     * would actually also mean that S is equally true as P and Q. However, this is not supported and therefore i don't
     * think i can make this validator work without a major rework.
     */

    @Override
    public Boolean visitTerms(GrammarParser.TermsContext ctx) {
        for (Sentence sentence : KnowledgeBase.sentences) {
            if (sentence.getName().equals(ctx.x.getText()))
                return sentence.isState();
        }
        return false;
    }

}
