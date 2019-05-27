import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

import org.antlr.v4.parse.ANTLRParser.ruleReturns_return;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
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
    //public void initKnowledgeBase (ArrayList<Sentence> args) {
    public void initKnowledgeBase () {
    //public void initKnowledgeBase (Sentence [] args) {
    	//sentences = args;
        sentences = new ArrayList<Sentence>();
        
        Sentence s1 = new Sentence("p",true);
        Sentence s2 = new Sentence("q",true);
        Sentence s3 = new Sentence("¬p∨¬q∨s",true);
        Sentence s4 = new Sentence("p∨¬s",true);
        
        sentences.add(s1);
        sentences.add(s2);
        sentences.add(s3);
        sentences.add(s4);
        
        
    }
      
    /*
     * We assume KB have limited atomic formulas, i.e. only 5(p,q,r,s,t).
     * then, we can build truth table for each sentence in KB and input. Also, we set all sentence state false at first. 
     * We just validate the sentence with state false by following rules:
     * 
     * 1.the truth table of sentence is out that of input, return 0 (false);
     * 2. others return 1.
     *
     * 0 means we delete the sentence from KB; then if there are still sentence in KB, we choose the highest priority one, 
     * set it state true and join it in the input set, i.e, makes a conjunction between its truth table and the existing 
     * input truth table. Then we repeat the validate process as before, until there is no sentence with false in KB. And 
     * the true sentence in KB and the input would be the new KB.  
     * 
     */


	/*
	// Uncomment this section to use the validator
	public void updateKnowledgeBase(Sentence input) {

		input.setName(input.getName().replace('¬', '!'));
		input.setName(input.getName().replace('∧', '&'));
		input.setName(input.getName().replace('∨', '|'));
		input.setName(input.getName().replace('⇒', '>'));

		Validator validate = new Validator();

		CharStream sentence = CharStreams.fromString(input.getName());
		GrammarLexer lex = new GrammarLexer(sentence);
		CommonTokenStream tokens = new CommonTokenStream(lex);
		GrammarParser parser = new GrammarParser(tokens);

		ParseTree parseTree = parser.start();

		Boolean result = validate.visit(parseTree);
	}*/

     public void updateKnowledgeBase(Sentence input) {
    	 
    	List<Sentence> to_revise_sentences = this.sentences;
    	
    	input.calTruthtable();
    	int[] input_truthtable = input.getTruthtable(); 
    	for (Sentence s : to_revise_sentences) {
    		s.setState(false); // firstly,set all sentences false, we don't believe everything in the knowledge base
    		s.calTruthtable();
    	}
    	
    	int depends_sentences_length = to_revise_sentences.size();
//    	ArrayList<Sentence> true_sentences = new ArrayList<Sentence>(); 
//    	true_sentences.add(input);
    	Map<String, Boolean> true_sententces_truth_table = input.getCompleteTruthtable();
    	
    	System.out.println("here1");
    	while(depends_sentences_length > 0) {
    		ArrayList delete_sentence_num_list = new ArrayList(); 
    		for(int i=0;i<to_revise_sentences.size(); i++) { 
    			Sentence s  = to_revise_sentences.get(i);
	    		if(s.isState() == true) {
	    			continue;
	    		}
	    		

	    		int validate_result  = (int)this.validateWithTruthtable (s.getCompleteTruthtable(),true_sententces_truth_table);
	    		
	    		
	    		if(validate_result == 0) {// if false, delete the sentence
	    			delete_sentence_num_list.add(i);
	    			depends_sentences_length --;
	    		}
	    		else if(validate_result == 1) {// if true, keep the sentence
	    			//s.setState(true);
	    			//depends_sentences_length --;
	    		}
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
    				true_sententces_truth_table = TruthtableOperation.truthtableConjunction(true_sententces_truth_table, to_revise_sentences.get(i).getCompleteTruthtable());
    				depends_sentences_length--;
    				//System.exit(1);
    				break;
    			}
    		}
    	}

    	System.out.println("here");
    	
    	to_revise_sentences = this.removeDuplicate(to_revise_sentences,input);
    	to_revise_sentences.add(0,input);
    	
    	this.sentences = to_revise_sentences;    	
    }

     
     /*
      * validate with truth table method
      * 
      * @param table1 the table to validate
      * @param table2  the always true table
      */
     private Integer validateWithTruthtable (Map<String, Boolean> table1, Map<String, Boolean> table2) {
    	 
    	
    	// System.out.println(table1.toString());
    	// System.out.println(table2.toString());
    	int table1_true_num = (int)TruthtableOperation.getTruthtableTrueNum(table1); 
    	int table2_true_num = (int)TruthtableOperation.getTruthtableTrueNum(table2); 
    	int consistent_num = 0;
    	int table1_only_true_num = 0;
    	int table2_only_true_num = 0;
    	
 		for (String s1 : table1.keySet()) {
			Boolean v1 = table1.get(s1);
			Boolean v2 = table2.get(s1);
			if(v1 == true && v2 == true) {
				consistent_num ++;
			}else if(v1 == true && v2 == false) {
				table1_only_true_num ++;
			}else if(v1 == false && v2 == true) {
				table2_only_true_num ++;
			}
		}
 		
 		
 		if(table1_true_num == table1_only_true_num && table2_true_num == table2_only_true_num) {
 			return 0;//no consistent, should delete
 		}
 		
// 		if(consistent_num == table1_true_num) {
// 			result = 1;//totally consistent, should label true, no need to validate again
// 		} 		
    	return 1; 
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
        
}
