package com.test01;

public class Man {
	
	public void classWork() {
		System.out.println("출석카드 찍는다.");
		
		try {
			System.out.println("컴퓨터 켜서 축구 본다.");
		} catch (Exception e) {
			System.out.println("쉬는 날이었다.");
			e.printStackTrace();
		}
		
		System.out.println("집에 간다.");
	}
	
}
