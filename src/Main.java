import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
		kb.printKnowledgeBase();

		// Update the knowledge base and print new belief set.
		while((line = in.readLine()) != null) {
			Sentence input = (line, true);
			kb.updateKnowledgeBase(input);
		}

		kb.printKnowledgeBase();

	}
}
