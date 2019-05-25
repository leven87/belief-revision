import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
/*
public class AtomFormulaPos {
	public static final int ATOM_P = 0; 
	public static final int ATOM_Q = 1; 
	public static final int ATOM_R = 2; 
	public static final int ATOM_S = 3; 
	public static final int ATOM_T = 4;
	public static final int ATOMS_NUM = 5;  
}
*/

public class AtomFormulaPos {
	private static final Map<String, Integer> dataMap = new HashMap <String, Integer> ();
	
	static {
	dataMap.put("p", 0);
	dataMap.put("q", 1);
	dataMap.put("r", 2);
	dataMap.put("s", 3);
	dataMap.put("t", 4);
	}

	public static Integer getAtomFormulaPos(String atom_formula) {
		return dataMap.get(atom_formula);
	}
	
	public static Integer getAtomFormulasNum() {
		return dataMap.size();
	}
}