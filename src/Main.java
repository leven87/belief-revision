public class Main {

    public static void main (String [] args) {
    	KnowledgeBase KB = new KnowledgeBase();
    	
    	KB.initKnowledgeBase();
    	
        System.out.println("The initial knowledge base are:");
        KB.printKnowledgeBase();    	
    	Sentence input = new Sentence("¬q", true);
    	KB.updateKnowledgeBase(input);
        System.out.println("The revised knowledge base are:");
        KB.printKnowledgeBase();     	
    }
}
