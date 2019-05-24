import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

	public static void main (String [] args) {
		KnowledgeBase kb = new KnowledgeBase();
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));


		// Initialize the Knowledge base. Print initial belief set.
		kb.initKnowledgeBase();
		kb.printKnowledgeBase();

		// Update the knowledge base and print new belief set.
		while((Sentence line = (in.readLine(), true)) != null){
			KB.updateKnowledgeBase(line);
		}

		kb.printKnowledgeBase();

	}
}
