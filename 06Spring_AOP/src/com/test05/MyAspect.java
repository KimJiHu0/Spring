package com.test05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
//이 Class는 CCC(공통관심사항)
public class MyAspect {
	
	//before, after안에 pointCut을 넣어줘야한다.
	//qClass라는 이름으로 PointCut을 대신하겠다는 뜻.
	@Before("qClass()")
	public void before() {
		System.out.println("출석카드 찍는다.");
	}
	
	@After("qClass()")
	public void after() {
		System.out.println("집에 간다.");
	}
	
	@Pointcut("execution(public * *(..))")
	public void qClass() {
		
	}
}
