package com.spring.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		ApplicationContext beans = new ClassPathXmlApplicationContext("com/spring/test03/applicationcontext.xml");
		
		School school = beans.getBean("school", School.class);
		System.out.println(school);
	}

}
