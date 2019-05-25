import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

import sun.tools.jar.resources.jar;


public class KnowledgeBase {

    //private List<String> sentences;
	public static List<Sentence> sentences;

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
        Sentence s2 = new Sentence("¬q",true);
        Sentence s3 = new Sentence("¬p∨¬q∨s",true);
        Sentence s4 = new Sentence("p∨¬s",true);
        
        sentences.add(s1);
        sentences.add(s2);
        sentences.add(s3);
        sentences.add(s4);
        

        //System.out.println(sentences.get(2).getName());

        //sentences.addAll(Arrays.asList(args));
        
    }
    
    

    /**
     * Updating the current knowledge bases and provides each Validator with a new priority value
     *  - newest information gets highest priority.
     *  
     * I assume just have ∨,¬, and sentences are in Horn clause. 
     * Firstly,I check each sentences in KB with input, if consistent, label it true, 
     * if not consistent,delete it, otherwise label it false(can't decided yet). 
     * Then, I choose the highest priority(lowest index) labeled false sentence and label it true.
     * Then, check all the labeled false sentences with input and this sentence , 
     * then we also can turn some false(can't decided yet) sentence true or delete it. 
     * We go on and on, finally, we just have true sentences. and these with input are new KB.
     * 
     * @param input Validator to update the knowledge base with
     */
    public int updateKnowledgeBase2 (Sentence input) {
    	
    	List<Sentence> to_revise_sentences = this.sentences;
    	
    	for (Sentence s : to_revise_sentences) {
    		s.setState(false); // firstly,set all sentences false, we don't believe everything in the knowledge base
    	}
    	
    	int depends_sentences_length = to_revise_sentences.size();
    	ArrayList<Sentence> true_sentences = new ArrayList<Sentence>(); 
    	true_sentences.add(input);
    	
    	System.out.println("here");
    	while(depends_sentences_length > 0) {
    		ArrayList delete_sentence_num_list = new ArrayList(); 
    		for(int i=0;i<to_revise_sentences.size(); i++) { 
    			Sentence s  = to_revise_sentences.get(i);
	    	//for (Sentence s : to_revise_sentences) {
	    		if(s.isState() == true) {
	    			continue;
	    		}
	    		
	    		String[] validate_result  = this.validate (s,"∧",true_sentences);
	    		
	    		
	    		if(validate_result[0] == "0") {// if false, delete the sentence
	    			//to_revise_sentences.remove(s);
	    			delete_sentence_num_list.add(i);
	    			depends_sentences_length --;
	    		}
	    		else if(validate_result[0] == "1") {// if true, keep the sentence
	    			s.setState(true);
	    			depends_sentences_length --;
	    		}
	    		else if(validate_result[0] == "2") {// if depends, set the sentence state false, and update the sentence to simplified version
	    			System.out.println(validate_result[1]);
	    			//s.setName();
	    		}    		
	    		System.out.println(validate_result[0]);
	    		
	    		//System.out.println(s.getName());
	    	} 
    		
    		for(int i=0; i<delete_sentence_num_list.size();i++) {
    			to_revise_sentences.remove((int)delete_sentence_num_list.get(i));
    		}
    		
    		if(depends_sentences_length <= 0) {
    			break;
    		}
    		
    		//set the highest priority sentence which is false to be true
    		//the lowest index sentenece has the highest priority
    		for(int i=0;i<to_revise_sentences.size();i++) {
    			Sentence s  = to_revise_sentences.get(i);
    			if(s.isState() == false) {
    				to_revise_sentences.get(i).setState(true);
    				true_sentences.add(to_revise_sentences.get(i));
    				depends_sentences_length--;
    				break;
    			}
    		}
    	}

    	System.out.println("here");
    	
    	//to_revise_sentences.add(input);
    	to_revise_sentences = this.removeDuplicate(to_revise_sentences,input);
    	to_revise_sentences.add(0,input);
    	
    	this.sentences = to_revise_sentences;
    	return 1;
    	//Sentence s = sentences.get(0); 
    	//Validator v = new Validator(s,"∧",input);  
    }
    
    
    private String[] validate (Sentence p, String notation, ArrayList<Sentence> q_arr) {
    	
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

        
        ArrayList<String> delete_p_atoms_list = new ArrayList<String>(); 
        int inconsistent_count =0;
        //pick each atom in p, validate it in q 
        for (String p_atom : p_atoms_table.keySet()) {
        	
        	boolean consistent = false;
        	boolean inconsistent = false;
        	Boolean p_atom_value = p_atoms_table.get(p_atom);
	        	
	    	for(int j=0;j<q_arr.size(); j++) {//initialize, turn string to atom formulas
	    		Sentence q = q_arr.get(j);
	            String q_name = q.getName();
	            
	//                if(q_name.contains("∨")){
	//                	atoms = q_name.split("∨");  
	//                }
	//                else{
	//                	atoms = q_name.split("∧");
	//                }
	            atoms = q_name.split("∨");                
	            for(int i=0; i< atoms.length;i++) {
	            	if(atoms[i].charAt(0)=='¬') {
	            		q_atoms_table.put(atoms[i].substring(1), false);
	            	}else {
	            		q_atoms_table.put(atoms[i], true); 
	            	}
	            }
	            
	            
	            for (String q_atom : q_atoms_table.keySet()) {
   
	            	if(p_atom.equals(q_atom)) {
	            		Boolean q_atom_value = q_atoms_table.get(q_atom);
	        			if(p_atom_value != q_atom_value) {
	        				delete_p_atoms_list.add(p_atom);
	        				inconsistent_count ++;
	        				inconsistent = true;
	        				break;
	        			}else {
	        				consistent = true;
	        				break;
	        			}
	            	}else {
	            		continue;
	            	}                    
	        	} 
	            
	            if(consistent == true || inconsistent == true) {
	            	break;
	            }
	
	        }        	
        }

   
		for(int i=0; i<delete_p_atoms_list.size();i++) {
			p_atoms_table.remove(delete_p_atoms_list.get(i));
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
        	//System.out.println("here");
        }else {
        	result[0] = "1";//true
        }

        return result;
    }
    
    
    
    
    /*
     * We assume KB have limited atomic formulas, i.e. only 5(p,q,r,s,t).
     * then, we can build truth table for each sentence in KB and input. We just validate the sentence by following rules:
     * 
     * 1. the truth table of sentence is within that of input, return 1(true);
     * 2. the truth table of sentence is out that of input, return 0 (false);
     * 3. the truth table of sentence is partly with that of input, return 2(depends).
     */
    //public void updateKnowledgeBaseWithTruthtable (Sentence input) {
     public void updateKnowledgeBase(Sentence input) {
    	List<Sentence> to_revise_sentences = this.sentences;
    	
    	input.calTruthtable();
    	int[] input_truthtable = input.getTruthtable(); 
    	for (Sentence s : to_revise_sentences) {
    		s.setState(false); // firstly,set all sentences false, we don't believe everything in the knowledge base
    		s.calTruthtable();
    	}
    	
    	int depends_sentences_length = to_revise_sentences.size();
    	ArrayList<Sentence> true_sentences = new ArrayList<Sentence>(); 
    	true_sentences.add(input);
    	
    	System.out.println("here");
    	while(depends_sentences_length > 0) {
    		ArrayList delete_sentence_num_list = new ArrayList(); 
    		for(int i=0;i<to_revise_sentences.size(); i++) { 
    			Sentence s  = to_revise_sentences.get(i);
	    		if(s.isState() == true) {
	    			continue;
	    		}
	    		
	    		String[] validate_result  = this.validateWithTruthtable (s,true_sentences);
	    		
	    		
	    		if(validate_result[0] == "0") {// if false, delete the sentence
	    			//to_revise_sentences.remove(s);
	    			delete_sentence_num_list.add(i);
	    			depends_sentences_length --;
	    		}
	    		else if(validate_result[0] == "1") {// if true, keep the sentence
	    			s.setState(true);
	    			depends_sentences_length --;
	    		}
	    		else if(validate_result[0] == "2") {// if depends, set the sentence state false, and update the sentence to simplified version
	    			System.out.println(validate_result[1]);
	    			//s.setName();
	    		}    		
	    		System.out.println(validate_result[0]);
	    		
	    		//System.out.println(s.getName());
	    	} 
    		
    		for(int i=0; i<delete_sentence_num_list.size();i++) {
    			to_revise_sentences.remove((int)delete_sentence_num_list.get(i));
    		}
    		
    		if(depends_sentences_length <= 0) {
    			break;
    		}
    		
    		//set the highest priority sentence which is false to be true
    		//the lowest index sentenece has the highest priority
    		for(int i=0;i<to_revise_sentences.size();i++) {
    			Sentence s  = to_revise_sentences.get(i);
    			if(s.isState() == false) {
    				to_revise_sentences.get(i).setState(true);
    				true_sentences.add(to_revise_sentences.get(i));
    				depends_sentences_length--;
    				break;
    			}
    		}
    	}

    	System.out.println("here");
    	
    	//to_revise_sentences.add(input);
    	to_revise_sentences = this.removeDuplicate(to_revise_sentences,input);
    	to_revise_sentences.add(0,input);
    	
    	this.sentences = to_revise_sentences;    	
    }

     
     /*
      * validate with truth table method
      * 
      * @param p the sentence to validate
      * @param q_arr a list of sentences which are assumed true
      */
     private String[] validateWithTruthtable (Sentence p, ArrayList<Sentence> q_arr) {
    	 String[] result = new String[2];
    	 
    	 p.getTruthtable()
    	 
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
    
    
    private static List<Sentence> removeDuplicate(List<Sentence> list, Sentence input) {
    	   Iterator<Sentence> iterator = list.iterator();
    	    while (iterator.hasNext()){
    	    	Sentence next = iterator.next();
    	    	if(next.getName().equals(input.getName())){
    	    		iterator.remove();
    	    	} 
    	    }
        return list;
    }
}
