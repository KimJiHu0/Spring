package com.spring.test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	@Before("execution(public * *(..))") // => Annotation에 PoinCut을 설정해준 것.MyAspect는 Advice인데 PointCut과 합쳐져 Advisor이 돼.
	public void before(JoinPoint join) {
		System.out.println("출석카드를 찍는다.");
	}
	
	@After("execution(public * *(..))")
	public void after(JoinPoint join) {
		System.out.println("집에 간다.");
	}
	
	@AfterThrowing("execution(public * *(..))")
	//target이 비정상적으로 동장했을 때 실행되는 메소드야.
	public void throwing(JoinPoint join) {
		System.out.println("쉬는 날이었다.");
	}
	
	@AfterReturning(pointcut = "execution(public * *(..))", returning = "returnVal")
	//target에서 return되는 값을 받아서 사용할 수 있게 해준다.
	//target이 정상적으로 동작해서 return값을 넘겨주면 동작하는 메소드
	//return되는 값은 target이 주는거야.
	public void returning(JoinPoint join, Object returnVal) {
		System.out.println(returnVal + "공부하는 날이었다.");
	}

}
