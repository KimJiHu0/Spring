package com.test01;

public class Woman {
	
	//출첵, 쉬는날, 집에간다를 CCC로 묶을 수 있다(공통된 부분.)
	//나머지 부분이 CC(주 관점)
	public void classWork() {
		System.out.println("출석카드를 찍는다.");
		
		try {
			System.out.println("컴퓨터 켜서 쇼핑한다.");
		} catch (Exception e) {
			System.out.println("쉬는 날이었다.");
			e.printStackTrace();
		}
		
		System.out.println("집에 간다.");
	}

}
