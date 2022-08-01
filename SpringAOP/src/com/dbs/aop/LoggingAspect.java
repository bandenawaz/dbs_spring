package com.dbs.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	
	//this is a pointcut expression. It denotes execution of method
	@Before("execution(* com.dbs.aop.BusinessLogic.getBusinessLogic(..))")
	public void loggingBeforeBusinessLogic(JoinPoint jp) {
		
		System.out.println("Logging before business logic is running!");
		System.out.println("Before execution of method :"+jp.getSignature().getName());
	}

}
