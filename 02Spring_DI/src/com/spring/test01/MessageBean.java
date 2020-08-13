package com.spring.test01;

public interface MessageBean {
	//접근제한자는 default
	//같은 패키지 내에서는 사용할 수 있다.
	//interface이기 때문에 이 Class를 상속받는 곳에서 반드시 구현해야 한다.
	void sayHello();
}
