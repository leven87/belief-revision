import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main (String [] args) {
		KnowledgeBase kb = new KnowledgeBase();
		BufferedReader in = new BufferedReader(new FileReader("C:/input.txt"));
		List<String> lines = new ArrayList<String>();

		while((String line = in.readLine()) != null){

			lines.add(line);
		}
		kb.initKnowledgeBase(lines.toArray());
		kb.printBelief();
    }
}
