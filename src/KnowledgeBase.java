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
    	
    	//System.out.println("here1");
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

    	//System.out.println("here");
    	
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
    
}
