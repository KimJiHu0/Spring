package com.test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//CCC : 공통된 부분을 묶어놓은 Class
@Aspect
public class MyAspect {
	
	//public에 접근제한자상관x, 이름상관x 파라미터 자유 -> 인 애가 호출되면 before 호출
	@Before("execution(public * *(..))")
	public void before(JoinPoint join) {
		System.out.println("출석 카드를 찍는다.");
	}
	//public에 void에 이름상관x 파라미터값 자유 -> 인 애가 호출되면 after 호출
	@After("execution(public * *(..))")
	public void after(JoinPoint join) {
		System.out.println("집에간다.");
	}
	
	//public에 접근제한자상관x , 이름상관x 파라미터값 자유 -> 인 애가 호출되면 after호출
	//예외가 발생했을 때 이 메소드가 출력이 돼.
	//target이 비정상적으로 동작했을 때 실행되는 메소드
	@AfterThrowing("execution(public * *(..))")
	public void throwing(JoinPoint join) {
		System.out.println("쉬는 날이었다.");
	}
	
	//target에서 return되는 값을 받아서 사용할 수 있게 해주는 애.
	//target이 정상적으로 동작해서 return값을 넘겨주면 동작하는 메소드
	@AfterReturning(pointcut = "execution(public * *(..))", returning = "returnVal")
	//return되는 값은 target이 주는 것.
	public void returning(JoinPoint join, Object returnVal) {
		System.out.println(returnVal + " 공부하는 날이었다. ");
	}

}
