import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.NMTOKENDatatypeValidator;

/* this class includes some function to operate truth table.*/
public class TruthtableOperation {


	public static Map<String, Boolean> truthtableConjunction(Map<String, Boolean> table1, Map<String, Boolean> table2) {
		Map<String, Boolean> result = new HashMap<String,Boolean>();

		for (String s1 : table1.keySet()) {
			Boolean v1 = table1.get(s1);
			if(v1 == true) {
				Boolean v2 = table2.get(s1);
				if(v2 == true) {
					result.put(s1, true);
				}else {
					result.put(s1, false);
				}
			}else{
				result.put(s1, false);
			}			
		}
		return result;
	}
	
	public static Integer getTruthtableTrueNum(Map<String, Boolean> table) {
		Integer num = 0;
		
		for (String s : table.keySet()) {
			Boolean v = table.get(s);
			if(v == true) {
				num ++;
			}
		}
		
		return num;
	}

}