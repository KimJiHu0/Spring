package com.test04;

public class Developer {
	
	//아래에 Eem class를 private로 사용한다는건 extends와 비슷한 의미이다.
	private Emp emp;
	private String dept;
	
	public Developer() {
		
	}

	public Developer(Emp emp, String dept) {
		super();
		this.emp = emp;
		this.dept = dept;
	}
	
	public String toString() {
		return emp + "\t 부서 : " + dept;
	}


}
