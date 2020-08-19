package com.spring.test07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/spring/test07/applicationcontext.xml");
		
		MessageBean bean = (MessageBean)factory.getBean("proxy");
		bean.sayHello();
	}

}
