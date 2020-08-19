package com.spring.test02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {
	//이 class는 공통된 코드인 CCC를 잘라서 묶어준 Class이다.
	//MethodIntercepor : 메소드 가로채기.
	//MethodInvocation invocation : 내가 가로챈 target -> proxy를 의미한다.
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//Object Type인 변수 target를 선언해준다.
		Object target = null;
		
		//공통된 부분 중 가장 첫번째.
		System.out.println("출석카드를 찍는다.");
		
		try {
			//Advice : CCC(공통된 코드를 묶어준 것)
			//PointCut : CCC가 어디 부분에 들어갈 것인지 정해주는 애.
			//어떨 때 출력을 해줄 것인지 정해준다고 보면 된다.
			target = invocation.proceed();
		} catch (Throwable e) {
			//위의 try부분이 아닐 때.
			System.out.println("쉬는 날이었다.");
			e.printStackTrace();
		}
		
		//공통된 부분 중 가장 마지막번째
		System.out.println("집에 간다.");
		
		return target;
	}
}
