import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

public class HelperClass {

    public List<Sentence> sentences;

    public void KnowledgeBaseHelper () {
        sentences.add(new Sentence("p", true));
        sentences.add(new Sentence("q", true));
        sentences.add(new Sentence("r", false));
    }

    /**
     * Validator accepts all valid sentences as a simple string, using the rules dictated in Grammar.g4
     */
    public void MainClassHelper () {

        /*
         * An complete sentence which we wish to validate
         */
        String sentence = "";

        /*
         * New instance
         */
        Validator validate = new Validator();

        /*
         * Creating the necessary classes to run through the grammar
         */
        CharStream input = CharStreams.fromString(sentence);
        GrammarLexer lex = new GrammarLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        GrammarParser parser = new GrammarParser(tokens);

        /*
         * Starting our parser
         */
        ParseTree parseTree = parser.start();


        /*
         * Do whatever we want with the result of the String
         */
        Boolean result = validate.visit(parseTree);
    }
}
