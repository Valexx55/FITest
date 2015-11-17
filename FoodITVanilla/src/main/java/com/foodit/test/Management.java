package com.foodit.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Management {

	
	public static void processOrder (Customer customer, Order order)
	{
		
		int amount_lp = 0;
		List<Rule> l_matched_rules = null;
		
		customer.recordVisit (order.getRestaurant());//due to update visiting times
		amount_lp = order.getAmount(); //Initially, lp's = pounds 1-1. ASSUMPTION -> In order to simplify the exercise, amounts will be allways whole numbers
		l_matched_rules = new ArrayList<Rule>();
		
		for (int n_rule = 0; n_rule < Rules.NUM_RULES; n_rule++) {
			
			Rule current_rule = Rules.getRule(n_rule);
			if (Matcher.isMatchingRule(current_rule, order, customer))
			{
				amount_lp = Rules.updateLoyaltyPoints (amount_lp, current_rule);
				l_matched_rules.add(current_rule);
			}
			
		}
		//sl, el, sp, ep
		//UPDATE ORDER'S DATA
		int start_loyal = customer.getTot_loyalty_points();
		int end_loyal = customer.getTot_loyalty_points() + amount_lp;
		int start_pence = customer.getTot_pence();
		int end_pence = customer.getTot_pence() + Exchange.getExchange(amount_lp);
		
		OrderDetail orderdetail = new OrderDetail(start_loyal, end_loyal, start_pence, end_pence, l_matched_rules);
		order.setOrder_detail(orderdetail);
		
		//UPDATE CUSTOMER'S balance
		customer.setTot_loyalty_points(end_loyal);
		customer.setTot_pence(end_pence);
		customer.addOrder(order);
	
		
	}
	
	public static void showMonthlyReport (Customer customer)
	{
		
		System.out.println("Customer report from  " + customer.getName());
		System.out.println(customer.toString());
		
	}
}
