package com.test04;

public class Engineer {

	private Emp emp;
	private String dept;
	
	public Engineer() {
		
	}
	
	public Engineer(Emp emp, String dept) {
		super();
		this.emp = emp;
		this.dept = dept;
	}
	
	public String toString() {
		return emp + "\t 부서 : " + dept;
	}
	
	
}
