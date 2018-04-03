package com.demo.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CodingAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("Before Adivce");
		Object result = invocation.proceed();
		System.out.println("After Returning Advice");
		
		return result;
	}

}
