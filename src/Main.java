import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main (String [] args) throws IOException {
		KnowledgeBase kb = new KnowledgeBase();
		BufferedReader input,initial;
		String line;
		Sentence pass;
		initial = new BufferedReader(new FileReader("input.txt"));
		input = new BufferedReader(new FileReader("input.txt"));



		// Initialize the Knowledge base. Input and print initial belief set.
		kb.initKnowledgeBase();
		while((line = initial.readLine()) != null) {
			pass = new Sentence (line, true);
			kb.updateKnowledgeBase(pass);
		}

		System.out.println("The knowledge base before new facts have been added: ");
		kb.printKnowledgeBase();



		// Update the knowledge base and print new belief set.
		while((line = input.readLine()) != null) {
			pass = new Sentence (line, true);
			kb.updateKnowledgeBase(pass);
		}
		System.out.println(" ");
		System.out.println("The knowledge base after new facts have been added: ");
		kb.printKnowledgeBase();

	}
}
