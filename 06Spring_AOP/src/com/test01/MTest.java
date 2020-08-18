package com.test01;

public class MTest {
	
	public static void main(String[] args) {
		
		Man man = new Man();
		Woman woman = new Woman();
		
		System.out.println("남학생입장.");
		man.classWork();
		System.out.println("---------");
		System.out.println("여학생입장.");
		woman.classWork();
	}

}
