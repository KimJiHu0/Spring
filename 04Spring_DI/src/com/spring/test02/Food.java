package com.spring.test02;

public class Food {
	
	private String name;
	private int price;
	
	public Food() {
		
	}
	
	//constructor-arg가능
	public Food(String name, int price) {
		this.name = name;;
		this.price = price;
	}
	
	//property가능
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String toString() {
		return name + " \t " + price;
	}
}
