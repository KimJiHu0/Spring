package com.spring.test01;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BeanTest {
	
	//MyClass class를 전역변수으로 선언해줬어.
	//이건 extends와 같은 의미긴 해.
	//MyClass class의 값을 전역변수로 담은거지.
	private MyClass myclass;
	
	//1. BeanTest가 bean객체로 만들어지면서 출력이 되는 기본 생성자.
	public BeanTest() {
		System.out.println("1. BeanTest 기본생성자 출력");
	}
	
	//Date타입의 date를 파라미터로 받아오는 생성자.
	//Xml에서 constructor로 값을 주입해주어야 한다.
	public BeanTest(Date date) {
		System.out.println("2. BeanTest에서 date 출력 : " + date);
	}
	
	public BeanTest(MyClass myclass) {
		System.out.println("3. MyClass에서 받은 생성자 ");
	}
	
	public void setMyClass(MyClass myclass) {
		this.myclass = myclass;
		System.out.println("4. BeanTest에서 myclass 출력 ");
	}
	
	public void setDate(Date date) {
		System.out.println("5. BeanTest에서 Date객체 호출 : " + date);
	}
	
	public void setNumber(int num) {
		System.out.println("6. BeanTest에서 setNumber 호출 : " + num);
	}
	
	public void setArray(String[] arr) {
		System.out.println("7. setArray(String[] arr) 호출");
		for(String s : arr) {
			System.out.println(s);
		}
	}
	
	public void setList(List<String> list) {
		System.out.println("8. setList(List<String> list) 호출");
		System.out.println(list);
	}
	
	public void setSet(Set<String> set) {
		System.out.println("9. setSet(Set<String> set) 호출");
		for(String s : set) {
			System.out.println(s);
		}
	}
	
	public void setMap(Map<String, String> map) {
		System.out.println("10. setMap(Map<String, String>) 호출");
		//Collection은 List, Set .. 의 가장 큰 타입이다.
		//Collection 객체를 values이라는 이름으로 지정을 해줬고, map에 value들을 담아줬다.
		Collection<String> values = map.values();
		//그리고 String value에 values라는 이름을 가진 변수에 담긴 값들을 하나씩 부려서 담아준걸 출력해준다.
		for(String value : values) {
			System.out.println(value);
		}
		
		//key값을 이용해서 value값을 출력해보자!
		
		//Set타입의 객체인데 Entry가의 타입이 String(key), String(value)를 선언해줬어.
		//Set타입이라 배열일거야.{} -> 근데 Set안의 타입이 Entry<String, String>이면 저 형태가 Set의 배열로 들어간다는 소리지.
		//{Entry<String, String>, Entry<String, String>}이런 식으로 들어간다는 소리야.
		//근데 그 안에 들어갈 map.entrySet()은 뭐야??
		//map.entrySet() : map이라는 Map객체에서 key : value형태인 것들을 담아준거야.
		Set<Entry<String,String>> entrySet = map.entrySet();
		//그리고선 Entry<String, String>형태의 entry에 for문을 돌면서 entrySet에 담겨져있는 {Entry<String, String>, Entry<String, String>}를
		//하나하나씩 꺼내서 entry에 담아주는거야.
		//그럼 {key : value}의 형태가 여러개 있고, 이 여러개는 하나하나 전부 entry인거야.
		for(Entry<String, String> entry : entrySet) {
			//그 중에서 {key : value}에서 .getKet()로 key값을 불러왔고, .getValue()로 value값을 가져온거야.
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
	
	public void setScore(List<Score> list) {
		System.out.println("setScore(List<Score> list) 호출");
		for(Score sc : list) {
			System.out.println(sc);
		}
	}

}
