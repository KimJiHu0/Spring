package com.mvc.spring.common.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAop {
	
	// 특정 target 호출 전 출력
	public void beforeLog(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget() + "");
		logger.info("\n----------AOP Start----------");
		
		Object[] args = join.getArgs();
		if(args != null) {
			logger.info("\n Method : " + join.getSignature().getName());
			for(int i = 0; i < args.length; i++) {
				logger.info("\n" + i + "번째" + args[i]);
			}
		}
	}
	
	// 특정 target 호출 후 출력
	public void afterLog(JoinPoint join) {
		
		Logger logger = LoggerFactory.getLogger(join.getTarget() + "");
		logger.info("\n ----------AOP END----------");
		
	}
	
	
	// 오류났을 때 출력
	public void afterThrowingLog(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
		logger.info("\n ----------AOP Error----------");
		logger.info("ERROR : " + join.getArgs());
		logger.info("ERROR : " + join.toString());
	}

}
