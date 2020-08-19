package com.spring.test07;

public class MessageBeanImpl implements MessageBean {
	
	//전역변수로 name을 선언
	private String name;
	
	//setter
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void sayHello() {
		
		//다른 메소드가 실행할 때까지 ()안에 지정해준 시간ㄴ만큼 멈추는것.
		//1000밀리세컨드 : 1초
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hello, " + name);
		
	}

}
