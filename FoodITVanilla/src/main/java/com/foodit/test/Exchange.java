package com.foodit.test;

public class Exchange {
	
	/**
	 * Class to keep the exchange value Loyalty points / Pence
	 */
	
	
	final public static int exchange_rate_pence = 2; //ideally in a properties file
	
	
	/**
	 * 
	 * @param loyalty_point
	 * @return
	 */
	public static int getExchange (int loyalty_point)
	{
		return loyalty_point*Exchange.exchange_rate_pence;
	}

}
