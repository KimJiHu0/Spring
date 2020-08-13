package com.spring.test02;

public class MTest {
	public static void main(String[] args) {
		
		//먼저 MessageBeanEn class와 MessageBeanKo class를 사용할 수 있게 객체를 생성한다.
		MessageBean bean01 = new MessageBeanEn();
		MessageBean bean02 = new MessageBeanKo();
		
		//객체를 생성한 [이름.메소드]를 사용해서 쓸 수 있다.
		//MessageBean에는 Parameter로 String name을 받아왔기 때문에
		//사용 할 때에 argument를 넣어서 사용해야한다.
		bean01.sayHello("Spring");
		bean02.sayHello("스프링");
		
	}
}
