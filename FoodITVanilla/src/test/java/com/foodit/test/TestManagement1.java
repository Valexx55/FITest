package com.foodit.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestManagement1 {
	
	Customer c1, c2, c3 = null;
	Order o1, o2, o3, o4, o5, o6, o7, o8, o9, o10, o11, o12 = null;
	
	@Before
	public void initData ()
	{
		c1 = new Customer(1,"Angel");
		c2 = new Customer(2,"Charles");
		c3 = new Customer(3,"Mike");
		
		Restaurant r1 = new Restaurant("Izzu",1);
		Restaurant r2 = new Restaurant("Anger Stakehouse",2);
		Restaurant r3 = new Restaurant("Paco Bell",3);
		
		Date date1 = new Date(115, 10, 17, 17, 5); //bonus date
		Date date2 = new Date(115, 10, 17, 20, 5); //no bonus date
		Date date3 = new Date(115, 10, 18, 17, 5); //bonus date
		Date date4 = new Date(115, 10, 18, 20, 5); //no bonus date
		Date date5 = new Date(115, 10, 16, 20, 5); //no bonus date
		
		o1 = new Order(r1,date5,30);//c1 less than 100, no bonus date, no bonus 3rd v
		o2 = new Order(r1,date2,130);//c5 more than 100, no bonus date, no bonus 3rd v
		o3 = new Order(r2,date1,30);//c3 less than 100, bonus date, no bonus 3rd v
		o4 = new Order(r1,date5,30);//c2 less than 100, no bonus date, bonus 3rd v
		o5 = new Order(r2,date3,230);//c7 more than 100, bonus date, no bonus 3rd v
		o6 = new Order(r2,date3,130);//c4 less than 100, bonus date,  bonus 3rd v
		o7 = new Order(r3,date3,30);
		o8 = new Order(r3,date3,20);
		o9 = new Order(r3,date4,230);//c6 more than 100,no bonus date, no bonus 3rd v
		o10 = new Order(r3,date3,30);
		o11 = new Order(r3,date3,20);
		o12 = new Order(r3,date1,230);//c8 more than 100, bonus date, no bonus 3rd v
	}
	
	@Test
	public void testProcessOrder() {
		Management.processOrder(c1, o1);

		assertEquals("Angel's balance should be 60", 60, c1.getTot_pence());
		assertThat (c1.getTot_pence(), IsEqual.equalTo(60));
		
		Management.processOrder(c1, o2);
		Management.processOrder(c2, o3);
		Management.processOrder(c1, o4);
		Management.processOrder(c2, o5);
		Management.processOrder(c2, o6);
		
		Management.processOrder(c3, o7);
		Management.processOrder(c3, o8);
		Management.processOrder(c3, o9);

		Management.processOrder(c1, o10);
		Management.processOrder(c1, o11);
		Management.processOrder(c1, o12);
	}
	
	@After
	public void showReports ()
	{
		Management.showMonthlyReport(c1);
		Management.showMonthlyReport(c2);
		Management.showMonthlyReport(c3);
	}

	

}
