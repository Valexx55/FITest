package com.foodit.test;

public class Restaurant {
	
	private String name;
	
	private int id;

	
	
	public Restaurant(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}


	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	private Restaurant isRestaurant (Object obj)
	{
		Restaurant p = null;
		
		if (obj instanceof Restaurant) {
			 p = (Restaurant) obj;
		}
		
		return p;
		
	}
	
	
	/**
	 * Two restaurants would be equals if they have the same name
	 */
	@Override
	public boolean equals(Object obj) {
		boolean dev= false;
		Restaurant rt = null;
		
		dev = (null!=obj)&&((obj == this)||((null!=(rt=isRestaurant(obj)))&&(this.getName().endsWith(rt.getName()))));
	
		return (dev);
	}
	
	

}
