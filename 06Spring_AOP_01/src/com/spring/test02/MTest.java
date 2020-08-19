package com.spring.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/spring/test02/applicationcontext.xml");
		
		Person w = (Person)factory.getBean("woman");
		Person m = factory.getBean("man", Person.class);
		
		System.out.println("[ 여학생 입장 ]");
		w.classWork();
		System.out.println("----------");
		System.out.println("[ 남학생 입장 ]");
		m.classWork();
				
	}

}
