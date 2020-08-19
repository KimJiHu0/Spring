package com.spring.test01;

public class MTest {
	
	//제대로된 aop를 사용하기 전에 어떤식으로 해야하는지 감잡기.
	public static void main(String[] args) {
		
		//man과 woman의 객체를 생성
		Man man = new Man();
		Woman woman = new Woman();
		
		System.out.println("[ 여학생 입장 ]");
		woman.classWork();
		System.out.println("[ 남학생 입장 ]");
		man.classWork();
		
		/*
		 * 우리가 지금까지 배워왔던 java로만 aop를 아주 간단하게 발을 담군다.
		 * Man class와 Woman class에서는 공통된 코드가 있고, 아닌 부분이 있다.
		 * AOP를 사용하기 위해서는 공통된 코드과 유니크한 코드를 분리해줘 야한다.
		 * 
		 * 공통된 코드
		 * "카드를 찍는다." / "집에 간다."
		 * 
		 * 유니크한 코드
		 * "컴퓨터를 키고 축구를 본다." / "컴퓨터를 키고 쇼핑을 한다."
		 * 
		 * 공통된 코드를 CCC / 유니크한코드를 CC로 나누어서 작성을 해야한다.
		 * 
		 * 그리고 유니크한 코드에서 try_catch를 사용했는데
		 * 이는 예외처리이다.
		 * 
		 */
		
	}

}
