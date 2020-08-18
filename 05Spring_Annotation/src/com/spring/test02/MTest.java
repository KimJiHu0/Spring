package com.spring.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/spring/test02/applicationcontext.xml");
	
		MyNickNamePrn mn = (MyNickNamePrn)factory.getBean("myNickNamePrn");
		System.out.println(mn);
		
	}

}
