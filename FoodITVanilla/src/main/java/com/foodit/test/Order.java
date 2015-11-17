package com.foodit.test;

import java.util.Date;


public class Order {
	
	/**
	 * Order or Visit
	 */

	private Restaurant restaurant;
	private Date date_time;
	private int amount;
	private OrderDetail order_detail;
	
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Date getDate_time() {
		return date_time;
	}
	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public OrderDetail getOrder_detail() {
		return order_detail;
	}
	public void setOrder_detail(OrderDetail order_detail) {
		this.order_detail = order_detail;
	}
	
	@Override
	public String toString() {
		String str_dev = null;
	
			str_dev = "DATE = " + this.date_time + ";AMOUNT = " + this.amount +this.getOrder_detail().toString();
		
		return str_dev;
	}
	public Order(Restaurant restaurant, Date date_time, int amount) {
		super();
		this.restaurant = restaurant;
		this.date_time = date_time;
		this.amount = amount;
	}
}
