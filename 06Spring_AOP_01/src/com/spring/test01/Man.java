package com.spring.test01;

public class Man {
	
	public void classWork() {
		System.out.println("출석카드를 찍는다.");
		
		try {
			System.out.println("컴퓨터를 키고 축구를 본다.");
		} catch (Exception e) {
			System.out.println("쉬는 날이었다.");
			e.printStackTrace();
		}
		
		System.out.println("집에 간다.");
	}

}
