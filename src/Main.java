import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main (String [] args) throws IOException {
		KnowledgeBase kb = new KnowledgeBase();
		BufferedReader in;
		String line;
		in = new BufferedReader(new FileReader("input.txt"));



		// Initialize the Knowledge base. Print initial belief set.
		kb.initKnowledgeBase();
		System.out.println("The knowledge base before new facts have been added: ");
		kb.printKnowledgeBase();

		// Update the knowledge base and print new belief set.
		while((line = in.readLine()) != null) {
			Sentence input = new Sentence (line, true);
			kb.updateKnowledgeBase(input);
		}
		System.out.println(" ");
		System.out.println("The knowledge base after new facts have been added: ");
		kb.printKnowledgeBase();

	}
}
