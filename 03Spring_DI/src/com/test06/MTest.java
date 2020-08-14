package com.test06;

public class MTest {
	
	public static void main(String[] args) {
		
		//객체를 BeanFactory가 만들어준다.
		//사용은 MTest class를!
		//중간에 Spring을 껴서 했었는데
		//지금은 Spring이랑 동일하지 않지만 만드는거 따로/ 사용하는거 따로
		//Factory pattern 따로 보자.
		BeanFactory factory = new BeanFactory();
		
		TV tv = (TV) factory.getBean("samsung");
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
	}

}
