package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationcontext.xml");
		
		Person w = factory.getBean("woman", Person.class);
		Person m = factory.getBean("man", Person.class);
		
		System.out.println("여학생 입장");
		//w.classWork, m.classWork가 target
		w.classWork();
		System.out.println("-------");
		System.out.println("남학생 입장");
		m.classWork();
		
		/*
		 * CC(target)을 호출해서 잘 뜬다.
		 * CCC를 붙여주려면 "니가 원하는게 나야" 라는 걸 알려야돼.
		 * 프록시가 "내가 필요한게 너여"라는걸 알아서 가져와야해.
		 * 프록시 객체를 만들어야한다.
		 * target인 척 하는애가 프록시?..
		 * 메소드를 인터셉트해야돼.(가로채야돼.)
		 * 
		 */
	}
}
