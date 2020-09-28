package com.mvc.spring.common.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAop {
	
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
	
	public void afterLog(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget() + "");
		logger.info("\n----------AOP End----------");
	}

	public void afterThrowingLog(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget() + "");
		logger.info("\n----------AOP Error----------");
		logger.info("\n Error : " + join.getArgs());
		logger.info("\n Error : " + join.toString());
	}
}
