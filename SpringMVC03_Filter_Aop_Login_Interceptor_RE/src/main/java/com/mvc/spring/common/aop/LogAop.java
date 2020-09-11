package com.mvc.spring.common.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// slf4j를 상속받아서 확장시킨 애 : log4j
public class LogAop {
	
	public void beforeLog(JoinPoint join) {
		// 로그 객체 선언?
		Logger logger = LoggerFactory.getLogger(join.getTarget() + "");
		logger.info("----------AOP START----------");
		
		Object[] args = join.getArgs();
		if(args != null) {
			logger.info("Method : " + join.getSignature().getName());
			for(int i = 0; i < args.length; i++) {
				logger.info(i + "번째" + args[i]);
			}
		}
	}
	
	public void afterLog(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget() + "");
		logger.info("----------AOP END----------");
	}
	
	public void afterThrowingLog(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget() + "");
		logger.info("-----------AOP ERROR----------");
		logger.info("ERROR : " + join.getArgs());
		logger.info("ERROR : " + join.toString());
	}

}
