package com.test05;

public class Emp {
	
	private String name;
	private String salary;
	
	public Emp(String name, String salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public Emp() {
		super();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return name + "\t 월급 : " + salary;
	}
	

}
