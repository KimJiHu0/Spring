package com.test01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAdvice {
	
	@Before("pointcut()")
	public void beforeSaying(JoinPoint join) {
		System.out.println("당신의 이름은 무엇입니까?");
	}
	@After("pointcut()")
	public void afterSaying(JoinPoint join) {
		System.out.println("이름이 멋지시네요");
	}
	@AfterReturning("pointcut()")
	public void afterReturnSaying(JoinPoint join) {
		System.out.println("직업이 무엇입니까?");
	}
	
	@Pointcut("execution(public * sayName(. . ))")
	public void pointcut() {
		
	}

}
