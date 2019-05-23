public class sentence {

    public sentence () {}

    public sentence (boolean p) {}

    public sentence (char negation, boolean p) { }

    public sentence (boolean p, char notation, boolean q) {}

    public sentence (sentence p, char notation, sentence q) {

    }

    private boolean negation (boolean p) {
        return true;
    }

    private boolean conjunction (boolean p, boolean q) {
        return true;
    }

    private boolean disjunction (boolean p, boolean q) {
        return true;
    }

    private boolean implies (boolean p, boolean q) {
        return true;
    }

    private boolean biconditional (boolean p, boolean q) {
        return true;
    }
}
