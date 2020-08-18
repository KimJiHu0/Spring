package com.test03;

import org.aspectj.lang.JoinPoint;

public class MyAspect {
	public void before(JoinPoint join) {
		System.out.println(join.getTarget().getClass());
		System.out.println(join.getSignature().getName());
		System.out.println("출석카드를 찍는다.");
	}
	public void after() {
		System.out.println("집에 간다.");
	}
}
