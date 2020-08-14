package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationcontext.xml");
		
		AbstractTest today = (AbstractTest)factory.getBean("singleton");
		System.out.println("오늘은 : " + today.dayInfo());
	}
	
	/*
	 * 싱글톤 레지스트리
	 * - 스프링이 직접 싱글톤 형태의 오브젝트를 만들고 관리하는 기능을 제공
	 *   (스프링 빈 오브젝트는 내부적으로 싱글톤 레지스트리를 만들어서 연동해줘)
	 *   싱글톤으로 객체를 가지고 놀고 있어서 메모리가 좀 더 절약될거야.
	 * 
	 * 싱글톤 : AbstractTest
	 * 얘는 추상클래스야. 객체를 만들 수 없어.
	 * xml에서 getInstance를 통해서 객체를 만들어달라고 요청했어.
	 * factory-method="getInstance"
	 * 
	 * AbstractTest getInstance()는 객체를 만들어서 나 자신을 return하는 객체를 만들었어.
	 * switch에 쓰여있는 요일 메소드는 상속받은 class
	 * 자식객체를 리턴할 수 있어. 왜냐면 부모객체가 더 크기 떄문에 다형성에 의해서 리턴이 가능해.
	 */
}
