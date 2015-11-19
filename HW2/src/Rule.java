import java.util.ArrayList;
import java.util.Map.Entry;


public class Rule {
	
	public ArrayList<RuleData> ifRule;
	public RuleData thenRule;
	
	public Rule(ArrayList<RuleData> ifRule, RuleData thenRule) {
		this.ifRule = ifRule;
		this.thenRule = thenRule;
	}
}
