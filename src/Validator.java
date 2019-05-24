import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

public class Validator extends AbstractParseTreeVisitor<Boolean> implements GrammarVisitor <Boolean> {

    @Override
    public Boolean visitStart(GrammarParser.StartContext ctx) {
        for (GrammarParser.SentenceContext s : ctx.s)
            visit(s);
        return visit(ctx.EOF());
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

    @Override
    public Boolean visitTerms(GrammarParser.TermsContext ctx) {
        HelperClass helper = new HelperClass();
        for (Sentence sentence : helper.sentences) {
            if (sentence.getName().equals(ctx.x.getText()))
                return sentence.isState();
        }
        return false;
    }

}
