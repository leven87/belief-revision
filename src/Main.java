import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main (String [] args) {
<<<<<<< HEAD
		KnowledgeBase kb = new KnowledgeBase();
		BufferedReader in = new BufferedReader(new FileReader("C:/input.txt"));
		List<String> lines = new ArrayList<String>();

		while((String line = in.readLine()) != null){

			lines.add(line);
		}
		kb.initKnowledgeBase(lines.toArray());
		kb.printBelief();
=======
    	KnowledgeBase KB = new KnowledgeBase();
    	
    	KB.initKnowledgeBase();
    	
        System.out.println("The initial knowledge base are:");
        KB.printKnowledgeBase();    	
    	Sentence input = new Sentence("¬q", true);
    	KB.updateKnowledgeBase(input);
        System.out.println("The revised knowledge base are:");
        KB.printKnowledgeBase();     	
>>>>>>> 71671091679f47a1652fbcaf41ae6fd24fa60382
    }
}
