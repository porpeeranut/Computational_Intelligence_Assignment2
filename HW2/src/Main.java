import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		HashMap<Enum, Graph> mfTime = new HashMap<Enum, Graph>();
		mfTime.put(TimeLevel.SHORT, new Graph(0, 20));
		mfTime.put(TimeLevel.MEDIUM, new Graph(15, 45));
		mfTime.put(TimeLevel.LONG, new Graph(40, 60));
		
		HashMap<Enum, Graph> mfSize = new HashMap<Enum, Graph>();
		mfSize.put(SizeLevel.SMALL, new Graph(0, 50));
		mfSize.put(SizeLevel.MEDIUM, new Graph(40, 160));
		mfSize.put(SizeLevel.BIG, new Graph(150, 200));
		
		HashMap<Enum, Graph> mfHardness = new HashMap<Enum, Graph>();
		mfHardness.put(HardnessLevel.FEW, new Graph(0, 0.4));
		mfHardness.put(HardnessLevel.MEDIUM, new Graph(0.3, 0.7));
		mfHardness.put(HardnessLevel.VERY, new Graph(0.6, 1));
		
		HashMap<Enum, Graph> mfFire = new HashMap<Enum, Graph>();
		mfFire.put(FireLevel.SOFT, new Graph(90, 110));
		mfFire.put(FireLevel.MEDIUM, new Graph(100, 150));
		mfFire.put(FireLevel.HARD, new Graph(140, 160));
		
		HashMap<Fuzzy, Data> input = new HashMap<Fuzzy, Data>() ;
		input.put(Fuzzy.TIME, new Data(mfTime, new Range(0, 60, 1)));
		input.put(Fuzzy.SIZE, new Data(mfSize, new Range(0, 200, 1)));
		input.put(Fuzzy.HARDNESS, new Data(mfHardness, new Range(0, 1, 0.05)));
		
		HashMap<Fuzzy, Data> output = new HashMap<Fuzzy, Data>();
		output.put(Fuzzy.FIRE, new Data(mfFire, new Range(0, 160, 1)));
		
		ArrayList<Rule> rules = new ArrayList<Rule>();
		/*addRule(TimeLevel.SHORT, SizeLevel.SMALL, HardnessLevel.FEW, FireLevel.SOFT, rules);
		addRule(TimeLevel.SHORT, SizeLevel.SMALL, HardnessLevel.MEDIUM, FireLevel.MEDIUM, rules);
		addRule(TimeLevel.SHORT, SizeLevel.SMALL, HardnessLevel.VERY, FireLevel.MEDIUM, rules);
		addRule(TimeLevel.SHORT, SizeLevel.MEDIUM, HardnessLevel.FEW, FireLevel.MEDIUM, rules);
		addRule(TimeLevel.SHORT, SizeLevel.MEDIUM, HardnessLevel.MEDIUM, FireLevel.HARD, rules);
		addRule(TimeLevel.SHORT, SizeLevel.MEDIUM, HardnessLevel.VERY, FireLevel.HARD, rules);
		addRule(TimeLevel.SHORT, SizeLevel.BIG, HardnessLevel.FEW, FireLevel.MEDIUM, rules);
		addRule(TimeLevel.SHORT, SizeLevel.BIG, HardnessLevel.MEDIUM, FireLevel.HARD, rules);
		addRule(TimeLevel.SHORT, SizeLevel.BIG, HardnessLevel.VERY, FireLevel.HARD, rules);
		
		addRule(TimeLevel.MEDIUM, SizeLevel.SMALL, HardnessLevel.FEW, FireLevel.SOFT, rules);
		addRule(TimeLevel.MEDIUM, SizeLevel.SMALL, HardnessLevel.MEDIUM, FireLevel.SOFT, rules);
		addRule(TimeLevel.MEDIUM, SizeLevel.SMALL, HardnessLevel.VERY, FireLevel.MEDIUM, rules);
		addRule(TimeLevel.MEDIUM, SizeLevel.MEDIUM, HardnessLevel.FEW, FireLevel.SOFT, rules);
		addRule(TimeLevel.MEDIUM, SizeLevel.MEDIUM, HardnessLevel.MEDIUM, FireLevel.MEDIUM, rules);
		addRule(TimeLevel.MEDIUM, SizeLevel.MEDIUM, HardnessLevel.VERY, FireLevel.HARD, rules);
		addRule(TimeLevel.MEDIUM, SizeLevel.BIG, HardnessLevel.FEW, FireLevel.MEDIUM, rules);
		addRule(TimeLevel.MEDIUM, SizeLevel.BIG, HardnessLevel.MEDIUM, FireLevel.HARD, rules);
		addRule(TimeLevel.MEDIUM, SizeLevel.BIG, HardnessLevel.VERY, FireLevel.HARD, rules);
		
		addRule(TimeLevel.LONG, SizeLevel.SMALL, HardnessLevel.FEW, FireLevel.SOFT, rules);
		addRule(TimeLevel.LONG, SizeLevel.SMALL, HardnessLevel.MEDIUM, FireLevel.SOFT, rules);
		addRule(TimeLevel.LONG, SizeLevel.SMALL, HardnessLevel.VERY, FireLevel.MEDIUM, rules);
		addRule(TimeLevel.LONG, SizeLevel.MEDIUM, HardnessLevel.FEW, FireLevel.SOFT, rules);
		addRule(TimeLevel.LONG, SizeLevel.MEDIUM, HardnessLevel.MEDIUM, FireLevel.SOFT, rules);
		addRule(TimeLevel.LONG, SizeLevel.MEDIUM, HardnessLevel.VERY, FireLevel.MEDIUM, rules);
		addRule(TimeLevel.LONG, SizeLevel.BIG, HardnessLevel.FEW, FireLevel.MEDIUM, rules);
		addRule(TimeLevel.LONG, SizeLevel.BIG, HardnessLevel.MEDIUM, FireLevel.MEDIUM, rules);
		addRule(TimeLevel.LONG, SizeLevel.BIG, HardnessLevel.VERY, FireLevel.HARD, rules);*/
		
		addRule(TimeLevel.SHORT, SizeLevel.SMALL, HardnessLevel.FEW, FireLevel.SOFT, rules);
		addRule(TimeLevel.SHORT, SizeLevel.SMALL, HardnessLevel.MEDIUM, FireLevel.SOFT, rules);
		addRule(TimeLevel.SHORT, SizeLevel.SMALL, HardnessLevel.VERY, FireLevel.SOFT, rules);
		addRule(TimeLevel.SHORT, SizeLevel.MEDIUM, HardnessLevel.FEW, FireLevel.HARD, rules);
		addRule(TimeLevel.SHORT, SizeLevel.MEDIUM, HardnessLevel.MEDIUM, FireLevel.HARD, rules);
		addRule(TimeLevel.SHORT, SizeLevel.MEDIUM, HardnessLevel.VERY, FireLevel.HARD, rules);
		addRule(TimeLevel.SHORT, SizeLevel.BIG, HardnessLevel.FEW, FireLevel.HARD, rules);
		addRule(TimeLevel.SHORT, SizeLevel.BIG, HardnessLevel.MEDIUM, FireLevel.HARD, rules);
		addRule(TimeLevel.SHORT, SizeLevel.BIG, HardnessLevel.VERY, FireLevel.HARD, rules);
		
		addRule(TimeLevel.MEDIUM, SizeLevel.SMALL, HardnessLevel.FEW, FireLevel.SOFT, rules);
		addRule(TimeLevel.MEDIUM, SizeLevel.SMALL, HardnessLevel.MEDIUM, FireLevel.SOFT, rules);
		addRule(TimeLevel.MEDIUM, SizeLevel.SMALL, HardnessLevel.VERY, FireLevel.SOFT, rules);
		addRule(TimeLevel.MEDIUM, SizeLevel.MEDIUM, HardnessLevel.FEW, FireLevel.MEDIUM, rules);
		addRule(TimeLevel.MEDIUM, SizeLevel.MEDIUM, HardnessLevel.MEDIUM, FireLevel.MEDIUM, rules);
		addRule(TimeLevel.MEDIUM, SizeLevel.MEDIUM, HardnessLevel.VERY, FireLevel.MEDIUM, rules);
		addRule(TimeLevel.MEDIUM, SizeLevel.BIG, HardnessLevel.FEW, FireLevel.HARD, rules);
		addRule(TimeLevel.MEDIUM, SizeLevel.BIG, HardnessLevel.MEDIUM, FireLevel.HARD, rules);
		addRule(TimeLevel.MEDIUM, SizeLevel.BIG, HardnessLevel.VERY, FireLevel.HARD, rules);
		
		addRule(TimeLevel.LONG, SizeLevel.SMALL, HardnessLevel.FEW, FireLevel.SOFT, rules);
		addRule(TimeLevel.LONG, SizeLevel.SMALL, HardnessLevel.MEDIUM, FireLevel.SOFT, rules);
		addRule(TimeLevel.LONG, SizeLevel.SMALL, HardnessLevel.VERY, FireLevel.SOFT, rules);
		addRule(TimeLevel.LONG, SizeLevel.MEDIUM, HardnessLevel.FEW, FireLevel.SOFT, rules);
		addRule(TimeLevel.LONG, SizeLevel.MEDIUM, HardnessLevel.MEDIUM, FireLevel.SOFT, rules);
		addRule(TimeLevel.LONG, SizeLevel.MEDIUM, HardnessLevel.VERY, FireLevel.SOFT, rules);
		addRule(TimeLevel.LONG, SizeLevel.BIG, HardnessLevel.FEW, FireLevel.HARD, rules);
		addRule(TimeLevel.LONG, SizeLevel.BIG, HardnessLevel.MEDIUM, FireLevel.HARD, rules);
		addRule(TimeLevel.LONG, SizeLevel.BIG, HardnessLevel.VERY, FireLevel.HARD, rules);
		
		
		
		SteakFuzzyLogic steakFuzzy = new SteakFuzzyLogic(input, output, rules);
		//System.out.println(steakFuzzy.defuz(20, 190, 0.9)+" °c\n"); //> 150
		//System.out.println(steakFuzzy.defuz(40, 100, 0.5)+" °c\n"); //>124
		System.out.println(steakFuzzy.defuz(41, 150, 0.9)+" °c\n"); //>95
	}
	
	static void addRule(TimeLevel tLevel, SizeLevel sLevel, HardnessLevel hLevel, FireLevel fLevel, ArrayList<Rule> rules) {
		ArrayList<RuleData> ifRule = new ArrayList<RuleData>();		
		ifRule.add(new RuleData(Fuzzy.TIME, tLevel));
		ifRule.add(new RuleData(Fuzzy.SIZE, sLevel));
		ifRule.add(new RuleData(Fuzzy.HARDNESS, hLevel));
		
		RuleData thenRule = new RuleData(Fuzzy.FIRE, fLevel);
		rules.add(new Rule(ifRule, thenRule));
	}
}