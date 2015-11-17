package com.foodit.test;

import java.util.ArrayList;
import java.util.List;


public class Rules {
	
	private static List<Rule> rules_defined;
	public static final int NUM_RULES = 3;
	
	
	static {
		
		Rule rule1 = new Rule(1, "More than 100 pounds");
		Rule rule2 = new Rule(2, "3rd visit in same month");
		Rule rule3 = new Rule(3, "Tues or Wends befor 6");
		
		rules_defined = new ArrayList<Rule>(NUM_RULES);
		rules_defined.add(rule1);
		rules_defined.add(rule2);
		rules_defined.add(rule3);
		
		
	}
	
	public static Rule getRule (int i)
	{
		return rules_defined.get(i);
	}
	
	public static int updateLoyaltyPoints (int amount, Rule rule)
	{
		int n_amount = 0;
		
		switch (rule.getId()) {
		case 1:
			n_amount = amount + 5;
			break;

		case 2:
			n_amount = amount + 5;
			break;
			
		case 3:
			n_amount = amount * 2;
			break;
		default:
			break;
		}
		
		return n_amount;
	}

}
