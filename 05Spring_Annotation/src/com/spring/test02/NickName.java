package com.spring.test02;

import org.springframework.stereotype.Component;

@Component
//@Component : 해당 클래스에 대한 bean객체를 자동으로 등록해줘.

//bean 객체로 만들어지는데
// <bean id="nickName" class="com.spring.test01.NickName">
//id는 class와 동일한 이름이고 가장 앞글자는 소문자야.
public class NickName {
	
	public String toString() {
		return "쥬";
	}

}
