import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.xpath.internal.functions.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/* this class is used to store formula.*/
public class Sentence {

    private String name;
    private boolean state;
    private int[] truth_table; //store an array, in which each atom's value indicate the sentence true. e.x., p∨¬s  is presented by [1,9,9,0,9]
    private Map<String, Boolean> complete_truth_table; //with just string 0110...  and its truth value

    public Sentence(String name, boolean state) {
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    
    public void setTruthtable(int[] truth_table) {
    	this.truth_table = truth_table;
    }
    
    public int[] getTruthtable() {
    	return this.truth_table;
    }
    
    public void calTruthtable() {
		this.truth_table = new int[AtomFormulaPos.getAtomFormulasNum()];
		
		for(int i=0;i<this.truth_table.length;i++) {
			this.truth_table[i] = 9; //9 means it can be 0 or 1
		}

		Map<String,Boolean> atoms_table = new HashMap<String,Boolean>();

		String[] atoms = this.name.split("∨");    
        for(int i=0; i< atoms.length;i++) {
        	if(atoms[i].charAt(0)=='¬') {          		
        		String atom = atoms[i].substring(1);
        		Integer atom_pos = AtomFormulaPos.getAtomFormulaPos(atom);
        		this.truth_table[atom_pos] = 0;
        		atoms_table.put(atom, false);
        	}else {
        		String atom = atoms[i];
        		Integer atom_pos = AtomFormulaPos.getAtomFormulaPos(atom);
        		this.truth_table[atom_pos] = 1;            		
        		atoms_table.put(atom, true); 
        	}
        }

        
        //calculate complete_truth_table        
        this.complete_truth_table = new HashMap<String,Boolean>();
        
        int truth_table_length = (int)Math.pow((double)2,(double)AtomFormulaPos.getAtomFormulasNum());
        for(int i=0;i<truth_table_length;i++) {
        	//String i_binary = Integer.toBinaryString(i);
            char[] chs = new char[AtomFormulaPos.getAtomFormulasNum()];
            for (int j = 0; j < AtomFormulaPos.getAtomFormulasNum(); j++) {
                chs[AtomFormulaPos.getAtomFormulasNum() - 1 - j] = (char) ((i >> j & 1) + '0');
            }
            String i_binary = new String(chs);
            
            int inconsistent_count = 0;
            int atom_has_value_num = 0;
            for(int j=0; j<i_binary.length();j++) {
                String i_binary_ele = i_binary.substring(i_binary.length()-j-1,i_binary.length()-j);
                String truth_table_ele = String.valueOf(this.truth_table[j]);
                
                if(!truth_table_ele.equals("9")) {
                	atom_has_value_num ++;  
                }
                
                if((i_binary_ele.equals("1") && truth_table_ele.equals("0")) || (i_binary_ele.equals("0") && truth_table_ele.equals("1"))){
                	inconsistent_count ++;
                	//System.out.println(i_binary +"|" + i_binary_ele + "|" + truth_table_ele + "|" + j);
                }
                
            }
            
//            System.out.println(inconsistent_count);
            if( inconsistent_count == atom_has_value_num) {//inconsistent with all the atoms(with value , not 9) in sentence, set false
            	this.complete_truth_table.put(i_binary, false);
            }else {
            	this.complete_truth_table.put(i_binary, true);
            }
            
        	//System.out.println(i_binary);
        	//this.complete_truth_table.put(i_binary, value);
        }
    }
    
    public Map<String, Boolean> getCompleteTruthtable() {
    	return this.complete_truth_table;
    }
     
}
