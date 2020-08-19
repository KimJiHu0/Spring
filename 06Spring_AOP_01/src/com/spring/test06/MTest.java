package com.spring.test06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/spring/test06/applicationcontext.xml");	
		
		Person w = (Person)factory.getBean("woman");
		Person m = (Person)factory.getBean("man");
		
		System.out.println("[ 남학생 입장 ]");
		m.classWork();
		System.out.println("---------");
		System.out.println("[ 여학생 입장 ]");
		w.classWork();
	}

}
