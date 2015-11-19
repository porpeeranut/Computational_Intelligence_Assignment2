import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class SteakFuzzyLogic {

	HashMap<Fuzzy, Data> input;
	HashMap<Fuzzy, Data> output;
	ArrayList<Rule> rules;
	double maxFireSoft = 0;
	double maxFireMed = 0;
	double maxFireHard = 0;
	
	public SteakFuzzyLogic(HashMap<Fuzzy, Data> input, HashMap<Fuzzy, Data> output, ArrayList<Rule> rules) {
		this.input = input;
		this.output = output;
		this.rules = rules;
	}
	
	double defuz(double time, double size, double hardness) {
		maxFireSoft = 0;
		maxFireMed = 0;
		maxFireHard = 0;
		int r = 1;
		boolean debug = false;
		for(Rule rule : rules) {
			double minInRule = 1;
			if (debug) {
				System.out.print ("#"+r+" ");
			}
			for(RuleData ruleData : rule.ifRule) {
				//	ifRule.add(new RuleData(Fuzzy.TIME, TimeLevel.SHORT));
				//	input.put(Fuzzy.TIME, new Data(mfTime, new Range(0, 60, 1)));
				double tmp = 0;
				if (ruleData.fuzzy == Fuzzy.TIME) {
					if (ruleData.level == TimeLevel.SHORT) {
						tmp = input.get(Fuzzy.TIME).mf.get(TimeLevel.SHORT).getFuzzyValDown(time);
						if (debug) {
							System.out.print ("SHORT->"+tmp);
						}
					} else if (ruleData.level == TimeLevel.MEDIUM) {
						tmp = input.get(Fuzzy.TIME).mf.get(TimeLevel.MEDIUM).getFuzzyValTriangle(time);
						if (debug) {
							System.out.print ("MED->"+tmp);
						}
					} else if (ruleData.level == TimeLevel.LONG) {
						tmp = input.get(Fuzzy.TIME).mf.get(TimeLevel.LONG).getFuzzyValUp(time);
						if (debug) {
							System.out.print ("LONG->"+tmp);
						}
					}
				} else if (ruleData.fuzzy == Fuzzy.SIZE) {
					if (ruleData.level == SizeLevel.SMALL) {
						tmp = input.get(Fuzzy.SIZE).mf.get(SizeLevel.SMALL).getFuzzyValDown(size);
						if (debug) {
							System.out.print (" SMALL->"+tmp);
						}
					} else if (ruleData.level == SizeLevel.MEDIUM) {
						tmp = input.get(Fuzzy.SIZE).mf.get(SizeLevel.MEDIUM).getFuzzyValTriangle(size);
						if (debug) {
							System.out.print (" MED->"+tmp);
						}
					} else if (ruleData.level == SizeLevel.BIG) {
						tmp = input.get(Fuzzy.SIZE).mf.get(SizeLevel.BIG).getFuzzyValUp(size);
						if (debug) {
							System.out.print (" BIG->"+tmp);
						}
					}
				} else if (ruleData.fuzzy == Fuzzy.HARDNESS) {
					if (ruleData.level == HardnessLevel.FEW) {
						tmp = input.get(Fuzzy.HARDNESS).mf.get(HardnessLevel.FEW).getFuzzyValDown(hardness);
						if (debug) {
							System.out.print (" FEW->"+tmp);
						}
					} else if (ruleData.level == HardnessLevel.MEDIUM) {
						tmp = input.get(Fuzzy.HARDNESS).mf.get(HardnessLevel.MEDIUM).getFuzzyValTriangle(hardness);
						if (debug) {
							System.out.print (" MED->"+tmp);
						}
					} else if (ruleData.level == HardnessLevel.VERY) {
						tmp = input.get(Fuzzy.HARDNESS).mf.get(HardnessLevel.VERY).getFuzzyValUp(hardness);
						if (debug) {
							System.out.print (" VERY->"+tmp);
						}
					}
				}
				/*for (int i = 0;i < tmp * 100.0;i++) {
					System.out.print("*");
				}
				System.out.println("*");*/
				
				
				if (minInRule > tmp && tmp >= 0)
					minInRule = tmp;
			}
			
			if (rule.thenRule.level == FireLevel.SOFT) {
				if (debug) {
					System.out.println(" soft = "+minInRule);
				}
				if (maxFireSoft < minInRule)
					maxFireSoft = minInRule;
			} else if (rule.thenRule.level == FireLevel.MEDIUM) {
				if (debug) {
					System.out.println(" med = "+minInRule);
				}
				if (maxFireMed < minInRule)
					maxFireMed = minInRule;
			} else if (rule.thenRule.level == FireLevel.HARD) {
				if (debug) {
					System.out.println(" heig = "+minInRule);
				}
				if (maxFireHard < minInRule)
					maxFireHard = minInRule;
			}
			r++;
		}
		if (debug) {
			System.out.println(maxFireSoft);
			System.out.println(maxFireMed);
			System.out.println(maxFireHard);
		}
		
		double start = output.get(Fuzzy.FIRE).range.start;
		double end = output.get(Fuzzy.FIRE).range.end;
		double step = output.get(Fuzzy.FIRE).range.step;
		double startSoft = output.get(Fuzzy.FIRE).mf.get(FireLevel.SOFT).x_start;
		double endSoft = output.get(Fuzzy.FIRE).mf.get(FireLevel.SOFT).x_end;
		double startMed = output.get(Fuzzy.FIRE).mf.get(FireLevel.MEDIUM).x_start;
		double endMed = output.get(Fuzzy.FIRE).mf.get(FireLevel.MEDIUM).x_end;
		double startHard = output.get(Fuzzy.FIRE).mf.get(FireLevel.HARD).x_start;
		double endHard = output.get(Fuzzy.FIRE).mf.get(FireLevel.HARD).x_end;
		
		double sum1 = 0;
		double sum2 = 0;
		for (double x = start;x <= end;x += step) {
			double ySoft = 0;
			double yMed = 0;
			double yHard = 0;
			if (x <= endSoft) {
				ySoft = output.get(Fuzzy.FIRE).mf.get(FireLevel.SOFT).getFuzzyValDown(x);
				if (ySoft > maxFireSoft)
					ySoft = maxFireSoft;
			}
			if (x >= startMed && x <= endMed) {
				yMed = output.get(Fuzzy.FIRE).mf.get(FireLevel.MEDIUM).getFuzzyValTriangle(x);
				if (yMed > maxFireMed)
					yMed = maxFireMed;
			}
			if (x >= startHard) {
				yHard = output.get(Fuzzy.FIRE).mf.get(FireLevel.HARD).getFuzzyValUp(x);
				if (yHard > maxFireHard)
					yHard = maxFireHard;
			}
			
			double max = max(ySoft, yMed, yHard);
			/*for (int i = 0;i < max * 100.0;i++) {
				System.out.print(" ");
			}
			System.out.println("*");*/
			sum1 += max*x;
			sum2 += max;
		}
		if (sum2 == 0)
			sum2 = 1;
		return sum1/sum2;
	}
	
	double max(double ySoft, double yMed, double yHard) {
		if (ySoft > yMed) {
			if (ySoft > yHard)
				return ySoft;
			else
				return yHard;
		} else {
			if (yMed > yHard)
				return yMed;
			else
				return yHard;
		}
	}
}
