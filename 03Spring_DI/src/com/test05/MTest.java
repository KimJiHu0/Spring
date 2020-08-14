package com.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test05/applicationcontext.xml");
		
		Engineer leess = factory.getBean("leess", Engineer.class);
		Developer honggil = factory.getBean("honggil", Developer.class);
		
		System.out.println(leess);
		System.out.println(honggil);
		
	}

}
