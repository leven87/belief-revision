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
        Sentence s3 = new Sentence("p∨q",true);
        Sentence s4 = new Sentence("p∨s",true);
        
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
    		
    		String[] validate_result  = this.validate (s,"∧",input);
    		
    		System.out.println(validate_result[0]);
    		
    		//System.out.println(s.getName());
    	}    	
    	
    	
    	
    	
    	//Sentence s = sentences.get(0); 
    	//Validator v = new Validator(s,"∧",input);  
    }
    
    
    private String[] validate (Sentence p, String notation, Sentence q) {
    	String[] result = new String[2];
        Map<String,Boolean> p_atoms_table = new HashMap<String,Boolean>(); 
        Map<String,Boolean> q_atoms_table = new HashMap<String,Boolean>();
        String[] atoms;
        //ArrayList<String> atoms_table = new ArrayList<>();
        
        String p_name = p.getName();
        atoms = p_name.split("∨");
       
        for(int i=0; i< atoms.length;i++) {
        	if(atoms[i].charAt(0)=='¬') {
        		p_atoms_table.put(atoms[i].substring(1), false); 
        		//atoms_table.add(atoms[i].substring(1));
        	}else {
        		p_atoms_table.put(atoms[i], true); 
        	}
        }
        
        String q_name = q.getName();
        atoms = q_name.split("∨");
       
        for(int i=0; i< atoms.length;i++) {
        	if(atoms[i].charAt(0)=='¬') {
        		q_atoms_table.put(atoms[i].substring(1), false); 
        		//atoms_table.add(atoms[i].substring(1));
        	}else {
        		q_atoms_table.put(atoms[i], true); 
        	}
        }        
        
        
        Boolean p_bool_value = true;
        int inconsistent_count = 0;
        for (String q_atom : q_atoms_table.keySet()) {
        	Boolean q_atom_value = q_atoms_table.get(q_atom);
        	for (String p_atom : p_atoms_table.keySet()) {
        		if(p_atom.equals(q_atom)) {
        			Boolean p_atom_value = p_atoms_table.get(p_atom);
        			if(p_atom_value != q_atom_value) {
        				if(q_atoms_table.size() == 1) {
        					p_atoms_table.remove(p_atom);
        					
        				}
        				inconsistent_count ++;
        			}
        		}else {
        			continue;
        		}
        	}
        } 
        
        if(p_atoms_table.size() == 0) {
        	result[0] = "0";//false
        }else if(inconsistent_count > 0) {
        	
        	p_name = "";	
        	for (String p_atom : p_atoms_table.keySet()) {
        		 
        		if(p_atoms_table.get(p_atom) == true ) {
        			p_name +=  p_atom + "∨";
        		}else {
        			p_name += "¬" + p_atom + "∨";
        		}
        	}
        	if(p_name.charAt(p_name.length()-1)=='∨') {
        		p_name = p_name.substring(0, p_name.length()-1);
        	}      
        	result[0] = "2";
        	result[1] = p_name;//depends
        }else {
        	result[0] = "1";//true
        }

        return result;
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
