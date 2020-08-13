package com.spring.test01;

public class MessageBeanImpl implements MessageBean {
	
	//전역변수 선언
	
	//과일 이름 선언
	private String fruit;
	//과일 가격 선언
	private int cost;
	
	//기본생성자 만들어주기
	public MessageBeanImpl() {
		this.fruit = "apple";
		this.cost = 1000;
	}
	
	//Parameter 2개 받는 생성자
	public MessageBeanImpl(String fruit, int cost) {
		this.fruit = fruit;
		this.cost = cost;
	}

	@Override
	public void sayHello() {
		System.out.printf("과일 : %s \t 가격 : %d\n", fruit, cost);
	}

}
