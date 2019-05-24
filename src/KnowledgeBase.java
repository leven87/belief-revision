import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class KnowledgeBase {

    //private List<String> sentences;
	private List<Sentence> sentences;

    public KnowledgeBase () {  }

    
    /*
     * ¬ negation
     * ∧ conjunction
     * ∨  disjunction
     * → implies
     * ↔ biconditional
     */
    public void initKnowledgeBase () {
    //public void initKnowledgeBase (Sentence [] args) {
        sentences = new ArrayList<Sentence>();
        
        Sentence s1 = new Sentence("p",true);
        Sentence s2 = new Sentence("q",true);
        Sentence s3 = new Sentence("p→q",true);
        
        sentences.add(s1);
        sentences.add(s2);
        sentences.add(s3);
        

        //System.out.println(sentences.get(2).getName());

        //sentences.addAll(Arrays.asList(args));
        
    }
    
    

    /**
     * Updating the current knowledge bases and provides each Validator with a new priority value
     *  - newest information gets highest priority.
     * @param input Validator to update the knowledge base with
     */
    public void updateKnowledgeBase (Sentence input) {
    	
    	List<Sentence> to_revise_sentences = this.sentences;
    	
    	for (Sentence s : to_revise_sentences) {
    		if(s.isState() == false) {
    			continue;
    		}
    		
    		Map<String, Sentence> map = this.validate (s,"∧",input);
    		
    		System.out.println(s.getName());
    	}    	
    	
    	
    	Sentence s = sentences.get(0); 
    	Validator v = new Validator(s,"∧",input);  
    }
    
    
    private Map<String, Sentence> validate (Sentence p, String notation, Sentence q) {
        Map<String, Sentence> map = new HashMap<String, Sentence>();
    	
        
        
        map.put("2", p);

        return map;
    }


    /*
     * print knowledge base
     */
    public void printKnowledgeBase () {
    	for (Sentence s : sentences) {
    		System.out.println(s.getName());
    	}
    }
}
