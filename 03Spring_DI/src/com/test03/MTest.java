package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationcontext.xml");
	
		Emp bae = (Emp)factory.getBean("bae");
		Emp soung = factory.getBean("soung", Emp.class);
		
		System.out.println(bae);
		System.out.println(soung);
	}

}
