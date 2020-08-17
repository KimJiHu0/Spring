package com.spring.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationcontext.xml");
		
		MyFood food = (MyFood)factory.getBean("choice");
		System.out.println(food);
		
		//factory객체를 close해주면 사용하지 않는 값들은 가비지컬렉터에 담기지 못하기 때문에 쓸데없는 메모리가 늘어날 수 있다.
		((ClassPathXmlApplicationContext)factory).close();
		
	}

}
