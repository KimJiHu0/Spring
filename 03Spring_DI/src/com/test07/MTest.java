package com.test07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test07/applicationcontext.xml");
		
		//ApplicationContext객체가 먼저 생성이 되었기 때문에 SamSunTV, IgTV 의 기본생성자에서 작성한 명령문이 실행이 된 후에
		//아래의 출력문이 나중에 출력이 된다.
		System.out.println("Spring Bean Container 생성!");
		
		SamSungTV samsung = factory.getBean("SamSungTV", SamSungTV.class);
		samsung.powerOn();
		samsung.powerOff();
		samsung.volumeUp();
		samsung.volumeDown();
		
		
		IgTV ig = (IgTV)factory.getBean("IgTV");
		ig.powerOn();
		ig.powerOff();
		ig.volumeUp();
		ig.volumeDown();

		
	}

}
