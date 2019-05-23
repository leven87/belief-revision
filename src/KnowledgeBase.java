import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnowledgeBase {

    private List<String> sentences;

    public KnowledgeBase () {  }

    public void initKnowledgeBase (String [] args) {
        sentences = new ArrayList<>();
        sentences.addAll(Arrays.asList(args));
    }

    /**
     * Updating the current knowledge bases and provides each Validator with a new priority value
     *  - newest information gets highest priority.
     * @param input Validator to update the knowledge base with
     */
    public void updateKnowledgeBase (String input) { }

    public String printKnowledgeBase () {
        return null;
    }
}
