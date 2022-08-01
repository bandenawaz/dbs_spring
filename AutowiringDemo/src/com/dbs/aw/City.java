package com.dbs.aw;

import org.springframework.beans.factory.annotation.Autowired;

public class City {
	
	private int id;
	private String name;
	
	private State s;

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

	public State getState() {
		return s;
	}

	@Autowired public void setState(State st) {
		this.s = st;
	}
	
	public void showCityDetails() {
		
		System.out.println("City Id is :" +id);
		System.out.println("City Name is :" +name);
		System.out.println("State name is :" +s.getName());
		
	}
	

}
