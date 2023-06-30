package com.cglia.aop.aspect;

import org.slf4j.*;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectClass {
	
	private final Logger logger = LoggerFactory.getLogger(AspectClass.class);
	
	//to specify the point cut
	@Pointcut("execution(* com.cglia.aop.controller.*.*(..))")
	public void applicationPackagePointcut() {
    }
	
	@Before("applicationPackagePointcut()")
	public void beforeAdvice(JoinPoint joinPoint) {
        logger.info("Executing method: {}", joinPoint.getSignature().toShortString());
    }
	
	 //after invoking the method
    @After("applicationPackagePointcut()")
    public void afterAdvice(JoinPoint joinPoint) {
        logger.info("Finished executing method: {}", joinPoint.getSignature().toShortString());
    }

    
    //After Successful execution
    @AfterReturning(pointcut = "applicationPackagePointcut()", returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        logger.info("Method: {} returned: {}", joinPoint.getSignature().toShortString(), result);
    }

    
    //After throwing  Exceptions
    @AfterThrowing(pointcut = "applicationPackagePointcut()", throwing = "exception")
    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
        logger.error("Exception thrown by method: {}", joinPoint.getSignature().toShortString());
        logger.error("Exception details: ", exception);
    }

    // To specify the pointcut
	@Pointcut("execution(* com.cglia.aop.service.*.*(..))")
	public void serviceMethods() {
	}
	
	@Before("serviceMethods()")
	public void beforeService(JoinPoint joinPoint) {
		logger.info("Service Method : {}- Started",  joinPoint.getSignature().toShortString());
	}
	 
	@After("serviceMethods()")
	public void afterService(JoinPoint joinPoint) {
		logger.info("Service Method : {}- Ended",  joinPoint.getSignature().toShortString());
	}
	
	@Around("serviceMethods()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Executing method: {}", joinPoint.getSignature().toShortString());

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        logger.info("Finished executing method: {}. Execution time for Service method: {} ms", joinPoint.getSignature().toShortString(), (endTime - startTime));

        return result;
    }

}

















