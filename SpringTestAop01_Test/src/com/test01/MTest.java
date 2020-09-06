package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/aopAppcontext.xml");
		
		Human person01 = factory.getBean("person01",Human.class);
		// syso문 안에있는 sayName 메소드를 호출하게 되면 beforeSaying이 호출되어서
		// "당신의 이름은 무엇입니까?" 호출 후에 syso("나의 이름은 뽀로로 입니다.")를 출력
		// 결과 : "당신의 이름은 무엇입니까?" "나의 이름은 뽀로로 입니다."
		
		// syso문 안에있는 sayJob 메소드를 호출하게 되면 호출하고 난 후에 afterSaying 메소드가 출력
		// syso("나의 직업은 개발자 입니다.")를 print하기 전에 sayJob을 호출하고 난 후에 afterSaying 메소드가 출력되어서
		// "이름이 멋지시네요" 출력 후에 afterReturnSaying(after이 예외없이 호출되면 출력)이 출력되어서
		// "직업이 무엇입니까?" 출력 후에 syso문 print
		// 결과 : "이름이 멋지시네요" "직입이 무엇입니까?" "저의 직업은 개발자 입니다."
		System.out.println(person01.sayName("뽀로로"));
		System.out.println(person01.sayJob("개발자"));
		
		System.out.println("------");
		
		Human person02 = factory.getBean("person02",Human.class);
		System.out.println(person02.sayName("둘리"));
		System.out.println(person02.sayJob("개그맨"));
	}
}
