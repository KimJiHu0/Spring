package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/aopAppcontext.xml");
		
		Human person01 = factory.getBean("person01",Human.class);
		// sayName라는 메소드가 호출이 되면 AOP 중 Aspect에 beforeSaying이라는 메소드가 먼저 호출.
		// 그래서 당신의 이름은 무엇입니까? 출력
		// 그 후에 sayName메소드가 실행 
		System.out.println(person01.sayName("뽀로로"));
		System.out.println(person01.sayJob("개발자"));
		
		System.out.println("------");
		
		Human person02 = factory.getBean("person02",Human.class);
		System.out.println(person02.sayName("둘리"));
		System.out.println(person02.sayJob("개그맨"));
	}
}
