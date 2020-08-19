package com.spring.test04;

import org.springframework.stereotype.Component;

@Component
public class Man implements Person {

	@Override
	public String classWork() {
		System.out.println("컴퓨터를 켜서 축구본다.");
		/*
		 * String s = null;
		 * s.length();
		 * 위와같이 예외가 발생하면 target이 정상적으로 동작하지 않았기 때문에
		 * 예외메소드가 호출이 돼.
		 */
		
		return "Spring";
	}

}
