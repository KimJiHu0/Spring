package com.spring.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/spring/test04/applicationcontext.xml");
		
		IgTV ig = (IgTV)factory.getBean("igTV");
		SamSungTV samsung = (SamSungTV)factory.getBean("samSungTV");
		
		ig.powerOn();
		ig.powertOff();
		ig.volumeUp();
		ig.volumeDown();
		
		samsung.powerOn();
		samsung.powertOff();
		samsung.volumeUp();
		samsung.volumeDown();
		
	}

}
