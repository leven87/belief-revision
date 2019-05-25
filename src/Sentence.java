import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class Sentence {

    private String name;
    private boolean state;
    private int[] truth_table;

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
        
    }
    
}
