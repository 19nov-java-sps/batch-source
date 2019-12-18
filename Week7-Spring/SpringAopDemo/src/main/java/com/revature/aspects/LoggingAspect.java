package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	/*
	 * - logging layout gives us consistent and meaningful information
	 * - logging levels 
	 * 		debug
	 * 		info
	 * 		warn
	 * 		error
	 * 		fatal
	 *	- can choose a threshold for what levels to log
	 *	- logging also allows us to choose a destination to log (file, stdout, etc.)
	 * 
	 */

	private static Logger log = Logger.getRootLogger();
	
	@AfterReturning("within(com.revature.beans.*)")
	public void logAfter(JoinPoint jp) {
		log.info(jp.getSignature().getName()+" executed successfully");
	}
	
	@AfterThrowing(pointcut="within(com.revature.beans.*)", throwing="ex")
	public void logAfterException(JoinPoint jp, Exception ex) {
		log.error(jp.getSignature().getName()+" threw an exception: "+ex);
	}
	
	@Before("execution(void bearHibernates())")
	public void logHibernation() {
		log.info("bear is attempting to hibernate");
	}
	
	@After("execution(void set*(..))")
	public void logSetter(JoinPoint jp) {
		log.info("setter called ("+ jp.getSignature().getName()+")");
	}
	
}
