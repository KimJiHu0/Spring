package com.test04;

public class Man implements Person {

	//CC : 주관점사항
	@Override
	public String classWork() {
		System.out.println("컴퓨터를 켜서 축구 본다.");
		return "Spring";
	}

}
