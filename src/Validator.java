public class Validator {

    public Validator() {}

    public Validator(boolean p) {}

    public Validator(char negation, boolean p) { }

    public Validator(boolean p, char notation, boolean q) {}

    //public Validator(Sentences p, char notation, Sentences q) {
    // I change this because "∧" is a string datatype.
    public Validator(Sentence p, String notation, Sentence q) {

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
