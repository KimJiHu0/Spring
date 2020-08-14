package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationcontext.xml");
		
		//아래는 우리가 원하는 타입으로 형 변환을 했어야했는데.
		Emp bae = (Emp)factory.getBean("bae");
		
		//아래와 같이 class를 넣어줄 수 있다.
		Emp kim = factory.getBean("kim", Emp.class);
		
		System.out.println(bae);
		System.out.println(kim);
		
		((ClassPathXmlApplicationContext)factory).close();
	}

}
