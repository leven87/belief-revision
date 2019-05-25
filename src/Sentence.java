import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.xpath.internal.functions.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sentence {

    private String name;
    private boolean state;
    private int[] truth_table; //store an array, in which each atom's value indicate the sentence true. e.x., p∨¬s  is presented by [1,9,9,0,9]
    private Map<String, ArrayList<Integer>> range_truth_table ; // a list of truth table which indicates a range that can make the sentence true.

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
        
        //calculate the range of its truthtable when sentence is true, assume the sentence is horn clause
        //List<List<Integer>> range_truth_table = new ArrayList();
        Map<String, ArrayList<Integer>> range_truth_table = new HashMap<String, ArrayList<Integer>>();
        
        //calculate atom in sentence on by one
        for (String atom : atoms_table.keySet()) {
        	ArrayList<Integer> range_truth_table_ele = new ArrayList<Integer>();
    		for(int i=0;i<this.truth_table.length;i++) {
    			range_truth_table_ele.add(9);
    		}
    		
    		//set the value of calculated atoms opposite value.(1 to 0, 0 to 1)
    		for (String atom_in_range : range_truth_table.keySet()) {
    			Integer atom_pos = AtomFormulaPos.getAtomFormulaPos(atom_in_range);
    			if(this.truth_table[atom_pos] == 0) {
    				range_truth_table_ele.set(atom_pos, 1);
    			}else if(this.truth_table[atom_pos] == 1) {
    				range_truth_table_ele.set(atom_pos, 0);
    			}else {
    				System.out.println("wrong1"); System.exit(1);
    			}
    		}
    		
    		int atom_value = this.truth_table[AtomFormulaPos.getAtomFormulaPos(atom)];
    		range_truth_table_ele.set(AtomFormulaPos.getAtomFormulaPos(atom), atom_value);
    		range_truth_table.put(atom, range_truth_table_ele);
        }
        this.range_truth_table = range_truth_table;
    }
    
    public Map<String, ArrayList<Integer>> getRangeTruthtable() {
    	return this.range_truth_table;
    }
    
}
