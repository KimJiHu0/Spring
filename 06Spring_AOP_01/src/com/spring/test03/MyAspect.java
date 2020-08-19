package com.spring.test03;

import org.aspectj.lang.JoinPoint;

public class MyAspect {
	
	//pointcut(어느 지점에서 호출을 할지 정해주는 애)를 기준으로 호출 전에 출력해주는.
	//JoinPoint는 잘라낸 CCC를 붙일 수 있는 모든 곳을 의미한다.
	public void before(JoinPoint join) {
		System.out.println(join.getTarget().getClass());
		System.out.println(join.getSignature().getName());
		System.out.println("출석카드를 찍는다.");
	}
	
	//pointcut(어느 지점에서 호출을 할지 정해주는 애)를 기준으로 호출 후에 출력해주는.
	public void after() {
		System.out.println("집에 간다.");
	}

}
