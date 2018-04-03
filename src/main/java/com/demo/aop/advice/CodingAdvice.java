package com.demo.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class CodingAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("afterReturning Advice");
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("before Advice");
	}

}
