import java.util.HashMap;


public class Data {
	
	Enum fuzzy;
	public HashMap<Enum, Graph> mf;
	public Range range;
	
	public Data(HashMap<Enum, Graph> mf, Range range) {
		//this.fuzzy = fuzzy;
		this.mf = mf;
		this.range = range;
	}
}
