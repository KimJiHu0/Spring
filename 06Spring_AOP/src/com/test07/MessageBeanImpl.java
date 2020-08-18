package com.test07;

public class MessageBeanImpl implements MessageBean {

	private String name;
	
	//setter
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void sayHello() {
		try {
			//다른 메소드가 실행할때까지 멈추는거. (1000밀리세컨드 = 1초)
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hello, " + name);
	}

}
