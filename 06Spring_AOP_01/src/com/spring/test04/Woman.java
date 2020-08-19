package com.spring.test04;

import org.springframework.stereotype.Component;

@Component
public class Woman implements Person {

	@Override
	public String classWork() {
		System.out.println("컴퓨터를 켜서 쇼핑한다.");
		return "스프링";
	}

}
