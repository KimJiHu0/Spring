package com.spring.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		//우선 ApplicationContext를 생성해주는데 ClassPath경로에 있는[com/spring/test01/applicationcontext.xml]
		//xml파일을 읽어와서 ApplicationContext객체를 만들어준다.
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/spring/test01/applicationcontext.xml");
		
		//MessageBean객체를 apple라는 이름으로 만들어주는데 이 때 bean에는 어떤 타입이 들어올지 모르기 때문에
		//명시적 형변환을 해준 후에 application.xml에서 만들어준 객체 fruit를 가져온다.
		MessageBean apple = (MessageBean)factory.getBean("fruit");
		//이 때 fruit는 아규먼트가 없다.그래서 MessageBean.java에 있는 기본생성자를 실행해줘서 출력해준다.
		apple.sayHello();
		
		//Application.xml에서 만들어준 watermelon을 가져오는데 여기서는
		//constructor-arg을 통해서 아규먼트를 입력해주어서 가져온다.
		MessageBean watermelon = (MessageBean)factory.getBean("watermelon");
		//사실상 watermelon("WATERMELON", 20000); 이 들어가있는 것이다.
		//MessageBean.java에서 파라미터 2개받는 생성자를 거쳐 실행한 다음에 sayHello메소드를 행하여 출력한다.
		watermelon.sayHello();
		
		//Application.xml에서 만들어준 melon을 가져온다.
		//melon은 constructor-arg태그를 사용했는데 그 안의 속성으로 index속성과 value속성을 사용했다
		//n번쨰위치에 있는 파라미터 값에(index="") / 값을 대입해준다. (value="")
		//0번째에는 참외, 1번째에는 5000을 대입했다
		//사실상 melon("참외", 5000)이라는 뜻이다.
		MessageBean melon = (MessageBean)factory.getBean("melon");
		//MessageBean.java에서 파라미터 2개받는 생성자를 거쳐 실행한 다음에 sayHello메소드를 행하여 출력한다
		melon.sayHello();
		}
}
