package com.spring.test02;

public interface MessageBean {
	//interface이기 때문에 MessageBean이라는 class를 상속받는 class에서는 무조건 body(중괄호)를 사용하여
	//구현을 해줘야한다.
	public void sayHello(String name);
}
