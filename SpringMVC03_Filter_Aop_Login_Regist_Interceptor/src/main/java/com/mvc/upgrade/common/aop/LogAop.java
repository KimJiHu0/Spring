package com.mvc.upgrade.common.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//slf4j를 상속받아서 확장시킨 애 : log4j
public class LogAop {
	
	public void beforeLog(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget() + "");
		logger.info("\n----------AOP Start----------");
		
		Object[] args = join.getArgs();
		if(args != null) {
			logger.info("\n* Method : " + join.getSignature().getName());
			for(int i = 0; i < args.length; i++) {
				logger.info(i + " 번 째 " + args[i]);
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
		logger.info("Error : " + join.getArgs());
		logger.info("Error : " + join.toString());
	}

}
