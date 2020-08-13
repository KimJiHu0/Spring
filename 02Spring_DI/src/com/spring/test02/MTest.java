package com.spring.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		//com/spring/test02/applicationcontext.xml경로에 있는 xml을 읽어와서 ApplicationContext 객체를 factoty라는 이름으로 만듬
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/spring/test02/applicationcontext.xml");
		
		Address people1 = (Address)factory.getBean("people1");
		System.out.println(people1);
		
		Address people2 = (Address)factory.getBean("people2");
		System.out.println(people2);
		
		Address people3 = (Address)factory.getBean("people3");
		System.out.println(people3);
		
	}

}
