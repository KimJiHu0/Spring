package com.test07;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LoggingAdvice implements MethodInterceptor{

	
	@Override
	//target인척하고 target호출된 신호를 인터셉트해서 타겟 호출하기 전에, 타겟 호출한 후에 CCC를 붙여주는 애
	public Object invoke(MethodInvocation invocation) throws Throwable {

			String methodName = invocation.getMethod().getName();
			
			StopWatch timer = new StopWatch();
			
			timer.start(methodName);
			System.out.println("[LOG] Method : " + methodName + " is Calling ");
			Object obj = invocation.proceed();
			timer.stop();
			
			System.out.println("[LOG] Method : " + methodName + " was Called ");
			System.out.println("[LOG] Time : " + timer.getTotalTimeSeconds() + "sec");
		return obj;
	}

}
