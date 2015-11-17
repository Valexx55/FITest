package com.foodit.test;

import java.util.Calendar;
import java.util.Date;


public class Matcher {
	
	
	
	
	/*
	 * 1 spend over 100 pounds get 5 bonus points

	2 every 3rd visit in the month get 5 bonus points

	3 double points for orders before 6pm Tuesday and Wednesday
	 */
	
	//
	@SuppressWarnings("deprecation")
	public static boolean isMatchingRule (Rule rule, Order order, Customer customer)
	{
		boolean bdev = false;
		
		switch (rule.getId()) {
		case 1:
				if (order.getAmount()>100)
				{
					bdev = true;
				}
			
			break;
		
		case 2:
				if (customer.thirdVisitInSameMonth (order.getRestaurant()))
				{
					bdev = true;
				}
			
			break;
		
		case 3:
				Date date_aux = order.getDate_time();
				int day = date_aux.getDay();
				int hour = date_aux.getHours();
				
				if (((day == 2)||(day == 3)) && (hour <18))
						
				{
					bdev = true;
				}
			
			break;

		default:
				System.out.println("Unknown rule");
			break;
		}
		
		return bdev;
	}

}
