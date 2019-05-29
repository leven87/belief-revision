import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/* this class is used to preset atomic formula and their position in assignment of truth value.*/
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