import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnowledgeBase {

    private List<String> sentences;

    public KnowledgeBase () {  }

    public void initKnowledgeBase(String [] args) {
        sentences = new ArrayList<>();
        sentences.addAll(Arrays.asList(args));
    }

    public String printKnowledgeBase() {
        return null;
    }
}
