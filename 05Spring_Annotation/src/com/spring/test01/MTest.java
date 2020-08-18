package com.spring.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		//()안에있는 xml경로를 찾아서 applicationcontext객체를 만들어주고 객체를 생성
		ApplicationContext bean = new ClassPathXmlApplicationContext("com/spring/test01/applicationcontext.xml");
		
		//xml에서 만들어진 id가 mynickname인 애를 nn에 담고
		MyNickNamePrn nn = (MyNickNamePrn)bean.getBean("mynickname");
		//nn을 출력한다.
		System.out.println(nn);
	}

}
