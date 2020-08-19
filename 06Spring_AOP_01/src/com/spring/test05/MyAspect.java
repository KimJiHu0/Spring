package com.spring.test05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	//anno라는 메소드를 지정해준 후에 annotation으로 PointCut을 지정을 해줬다.
	//위의 메소드가 실행될 때 [public, (리턴타입상관x), (메소드명상관x), (파라미터갯수상관x)]
	//before, after annotation이 실행돼.
	@Pointcut("execution(public * *(..))")
	public void anno() {
		
	}
	
	@Before("anno()")
	public void before() {
		System.out.println("출석카드 찍는다.");
	}
	
	@After("anno()")
	public void after() {
		System.out.println("집에 간다.");
	}
	

}
