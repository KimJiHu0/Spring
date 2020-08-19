package com.spring.test07;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

//target을 가로채서 target인첫하는 classsssssssss
public class LoggingAdvice implements MethodInterceptor{

	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		//메소드이름 : 내가 가로챈애 메소드의 이름?
		String methodName = invocation.getMethod().getName();
		
		//시간객체
		StopWatch timer = new StopWatch();
		
		//타이머 시작!
		timer.start(methodName);
		System.out.println("[LOG] Method : " + methodName + "is Calling");
		Object obj = invocation.proceed();
		
		//타이머 종료!
		timer.stop();
		System.out.println("[LOG] Method : " + methodName + "was Called");
		
		//timer에서 total[총] 걸린 Seconds[초]
		System.out.println("[LOG] Time : " + timer.getTotalTimeSeconds());
		
		return obj;
	}
	
	

}
