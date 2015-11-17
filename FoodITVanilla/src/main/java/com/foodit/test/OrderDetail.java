package com.foodit.test;

import java.util.ArrayList;
import java.util.List;


public class OrderDetail {
	
	private int start_loyalties;
	private int end_loyalties;

	private int start_amount;
	private int end_amount;
	
	private List<Rule> list_rules_app;
	
	public int getStart_loyalties() {
		return start_loyalties;
	}
	public void setStart_loyalties(int start_loyalties) {
		this.start_loyalties = start_loyalties;
	}
	public int getEnd_loyalties() {
		return end_loyalties;
	}
	public void setEnd_loyalties(int end_loyalties) {
		this.end_loyalties = end_loyalties;
	}
	public int getStart_amount() {
		return start_amount;
	}
	public void setStart_amount(int start_amount) {
		this.start_amount = start_amount;
	}
	public int getEnd_amount() {
		return end_amount;
	}
	public void setEnd_amount(int end_amount) {
		this.end_amount = end_amount;
	}
	public OrderDetail(int start_loyalties, int end_loyalties,
			int start_amount, int end_amount, List<Rule>list_rules_app) {

		
		this.start_loyalties = start_loyalties;
		this.end_loyalties = end_loyalties;
		this.start_amount = start_amount;
		this.end_amount = end_amount;
		
		this.list_rules_app = list_rules_app;
		
	}
	public List<Rule> getList_rules_app() {
		return list_rules_app;
	}
	public void setList_rules_app(List<Rule> list_rules_app) {
		this.list_rules_app = list_rules_app;
	}
	
	private String info_rules_app ()
	{
		String str = "";
		boolean ra = false;
		
		for (Rule r: this.list_rules_app)
		{
			str = str + r.getId() + " "+ r.getDescription() +"\n";
			ra = true;
		}
		
		if (!ra)
		{
			str = "no rules applied\n";
		}
	
		
		return str;
	}
	
	@Override
	public String toString() {
		String str_dev = null;
		
		str_dev = " ;START_LP " + this.getStart_loyalties() + " ;END_LP = " + this.getEnd_loyalties() + " ;START_AMOUNT = " + this.getStart_amount() + " ;END_AMOUNT = "  + this.getEnd_amount();
		str_dev = str_dev +"\nRULES applied\n"+ info_rules_app();
	
	return str_dev;
	}

}
