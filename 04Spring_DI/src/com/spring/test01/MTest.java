package com.spring.test01;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		//("com/spring/test01/applicationcontext.xml")안에 있는 Xml파일을 찾아서 읽어온 후에 ApplicationContext객체를 만들어 줄거야.
		//ApplicationContext : Xml파일에서 작성한 bean객체를 생성해주는거야.
		ApplicationContext bean = new ClassPathXmlApplicationContext("com/spring/test01/applicationcontext.xml");
		
		//Xml파일에서 만들어준 id가 myclass인 객체를 MyClass로 형변환을 해준 후 my라는 이름으로 담아줬어.
		MyClass my = (MyClass)bean.getBean("myclass");
		//그리고 my(MyClass Class 객체)에 Prn메소드를 출력한다.
		my.Prn();
		
		//java.util에 있는 date를 가져와서 쓸거야
		//applicationcontext.xml에 있는 id가 date라는 객체를 date에 담을거야.
		//date라는 객체는 Xml에서 Constructor Injection를 이용해서 값을 주입해줬어.
		Date date = (Date)bean.getBean("date");
		System.out.println(date);
		
	}

}
