package com.foodit.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Customer {
	
	/**
	 * Customer or Visitor
	 */
	
	private int id;
	private String name;
	private Map<Restaurant, Integer> ntimes;
	private List<Order> l_orders;
	
	private int tot_loyalty_points;
	private int tot_pence;
	
	public int getTot_loyalty_points() {
		return tot_loyalty_points;
	}
	public void setTot_loyalty_points(int tot_loyalty_points) {
		this.tot_loyalty_points = tot_loyalty_points;
	}
	public int getTot_pence() {
		return tot_pence;
	}
	public void setTot_pence(int tot_pence) {
		this.tot_pence = tot_pence;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<Restaurant, Integer> getNtimes() {
		return ntimes;
	}
	public void setNtimes(Map<Restaurant, Integer> ntimes) {
		this.ntimes = ntimes;
	}
	public Customer(int id, String name) {
		
		this.id = id;
		this.name = name;
		this.ntimes = new HashMap<Restaurant, Integer>();
		this.l_orders = new ArrayList<Order>();
	}
	
	/**
	 * NOTE: In order to keep updated properly the times that a restaurant is visited, we should implement other method, wich shoudl be called
	 * at the begining of eacht month, removing ntimes's content
	 * 
	 * @param restaurant
	 */
	public void resetCustomerCounter (Restaurant restaurant)
	{
		
		Integer time = new Integer(0);
		
		this.ntimes.put(restaurant, time);
		
	}
	
	public boolean thirdVisitInSameMonth (Restaurant restaurant)
	{
		boolean dev = false;
		
		Integer time = this.ntimes.get(restaurant);
		
		dev = ((null != time)&& (time % 3 == 0));
		
		return dev;
		
	}
	
	public void recordVisit (Restaurant restaurant)
	{
		Integer time = this.ntimes.get(restaurant);
		
		if (null == time) //first time restaurant visited
		{
			time = new Integer(1);
		}
		else {
				time = time +1;
		}
		this.ntimes.put(restaurant, time);
	}
	
	
	public List<Order> getL_orders() {
		return l_orders;
	}
	public void setL_orders(List<Order> l_orders) {
		this.l_orders = l_orders;
	}
	
	public void addOrder (Order order)
	{
		this.l_orders.add(order);
	}
	
	
	private String info_rests ()
	{
		StringBuffer str_dev = new StringBuffer("RESTs Times INFO\n");
			
		Iterator<Restaurant> itr = this.ntimes.keySet().iterator();
		Restaurant rt = null;
		int ntimes = 0;
		
		while (itr.hasNext())
		{
			rt = itr.next();
			ntimes = this.ntimes.get(rt);
			str_dev.append("Rest = "+ rt.getName() + ";Times = " + ntimes + "\n");
		}
		
		return str_dev.toString();
	}
	
	@Override
	public String toString() {
		String str_aux = null;
			
			str_aux = "\nTOT_PENCE = " + this.tot_pence + " TOT_LP = " + this.tot_loyalty_points + "\n" + info_rests()+"\n";
			
			str_aux = str_aux + "ORDERS details ...\n"; 
			int count= 1;
					
			for (Order o: this.l_orders)
			{
				str_aux = str_aux + "ORDER Nº "+count+"\n";
				str_aux = str_aux + o.toString()+"\n";
				count++;
			}
		
		return str_aux;
	}
	
	

}
