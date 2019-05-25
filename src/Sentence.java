import java.lang.reflect.Array;

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
    
}
