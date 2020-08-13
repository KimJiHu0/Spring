package com.spring.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		/*
		 * ★★★★★ 객체를 만들어준 xml파일을 가져와서 쓰는 방법★★★★★
		 * 
		 * [ 기존방식 ]
		 * 1.
		 * Resource res = new FileSystemResource("src/com/spring/test03/beans.xml");
		 * 2.
		 * Resource res = new ClassPathResource("com/spring/test03/beans.xml");
		 * BeanFactory factory = new XmlBeanFactory(res);
		 * 
		 * [ 새로운 방법 ]
		 * 3.
		 * ClassPath(어떠한 경로)에서 Xml파일을 읽어와서 applicationcontext라는 객체를 만든다.
		 * ClassPath() 안에 있는 경로에서 만들어준다.
		 * 그럼 com/spring/test03/beans.xml을 읽어와서 applicationcontext라는 객체를 만들어준다.
		 * applicationcontext를 만들어주는 명령문이 실행되면 beans.xml에서 만들어준
		 * bean01, bean02라는 객체를 생성해준다.
		 * 그런 후에 이곳에서 사용하면 된다.
		 * 
		 * ApplicatioonContext는 beanfactory를 상속받았다.(Bean을 만들어주는 것)
		 */
		
		//아래의 명령문을 해석해보자.
		//ApplicationContext객체의 이름은 factory로 만들거다.
		//ClassPathXmlApplicationContext() 안에 있는 경로의 xml파일을 읽어와서 ApplicationContext객체를 만들어준다.
		//그리고 이제 사용해주면 된다.
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/spring/test03/beans.xml");
	
		//사용하기 전에
		//어떤 객체가 bean으로 만들어질지 모르기 때문에 Object로 만들어준다.
		//큰 타입에서 작은타입으로 가는 [ 명시적 형변환 ]을 해줘야한다.
		
		//MessageBean 객체 사용할거다. 이름은 english라는 이름으로.
		//우선 어떠한 객체가 들어올지 모르니까 큰타입 -> 작은타입 명시적 형변환을 사용해준다.
		//그 후 ApplicationContext를 만들어서 담아준 factory에서 bean01이라는 이름을 가진 객체를 불러온다.
		MessageBean english = (MessageBean)factory.getBean("bean01");
		//그 만들어준 객체에서 sayHello라는 메소드를 실행해준다.
		english.sayHello("Spring");
		
		MessageBean korean = (MessageBean)factory.getBean("bean02");
		korean.sayHello("스프링");
		
		/*
		 * bean.xml : Spring FrameWork에서 만들어서
		 * MTest와 MessageBean을 interfacec로 약결합을 해준 ㅎ ㅜ
		 * 가운데 ApplicationContext를 사용했다.
		 * 
		 * Inversion Of Control(IOC) : 제어역전 / 역전제어 / 제어반전
		 * -> 원래는 객체생성과 사용을 동시에 한다.
		 * 지금은 
		 * Spring : 객체생성
		 * java : 사용
		 * 생성하는 쪽에서 사용하는게 아니다.
		 * 생성하는 곳 / 사용하는 곳  을 분리시켜준다.
		 * 
		 * BeanFactory를 상속받은 ApplicationContext를 상속받은 ClassPathXmlApplicationContext
		 * Spring의 ApplicationContext 객체는 Spring Container instance
		 * Spring은 ApplicationContext interface의 여러 객체를 제공한다.
		 * 그 중에서 하나은 ClassPathXmlApplicationContext : 지정된 ClassPath에서 Xml파일을 읽어솨서 bean 생성.
		 */
	}
}
