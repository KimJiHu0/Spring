package com.spring.test01;

public class MTest {
	public static void main(String[] args) {
		
		//class 와 class의 강결합.
		//MessageBean이라는 class와 MTest라는 class가 직접적으로 연결이 되어있다.
		//이를 결합도가 강하다. 즉, 강결합 이라고 한다.
		
		//MessageBean이라는 객체를 생성해준다.
		MessageBean bean = new MessageBean();
		//bean이라는 이름으로 만든 객체에서 sayHello라는 메소드를 호출한다.
		bean.sayHello("Spring");
		
	}
}
