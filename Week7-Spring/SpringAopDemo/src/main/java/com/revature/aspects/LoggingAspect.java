package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
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
	
	@After("within(com.revature.beans.*)")
	public void logAfter() {
		log.info("method invoked");
	}
	
}
