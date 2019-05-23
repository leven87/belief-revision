public class Main {

    public static void main (String [] args) {
    	KnowledgeBase KB = new KnowledgeBase();
    	
    	KB.initKnowledgeBase();
    	
    	Sentence input = new Sentence("¬q", true);
    	KB.updateKnowledgeBase(input);
    }
}
