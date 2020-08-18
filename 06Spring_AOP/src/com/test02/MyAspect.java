package com.test02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//공통된 부분이 CCC를 잘라서 묶어줄 CLASS
//MethodInterceptor : 메소드 가로채기.
//MethodInvocation invocation : 내가 가로챈 애 (target) -> proxy ㅇ
public class MyAspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object target = null;
		
		System.out.println("출석카드를 찍는다.");
		
		try {
			//Advice = CCC(공통된 부분을 묶어준 것.
			//PointCut = CCC가 어디 부분에 들어갈 것인지 정해주는 애.
			target = invocation.proceed();
		} catch (Throwable e) {
			System.out.println("쉬는 날이었다.");
			e.printStackTrace();
		}
		
		System.out.println("집에 간다.");
		
		return target;
	}

}
