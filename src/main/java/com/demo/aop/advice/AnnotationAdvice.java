package com.demo.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnotationAdvice {
	@Around("execution(* com.demo..*.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		before();
		Object result = pjp.proceed();
		after();
		
		return result;
	}
	
	private void before() {
		System.out.println("Before Advice");
	}
	
	private void after() {
		System.out.println("After Advice");
	}
}
