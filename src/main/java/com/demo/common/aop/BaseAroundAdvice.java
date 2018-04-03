package com.demo.common.aop;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class BaseAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("===========进入around===========");  
        // 调用方法的参数  
        Object[] args = invocation.getArguments();  
        // 调用的方法  
        Method method = invocation.getMethod();  
        // 获取目标对象  
        Object target = invocation.getThis();  
        // 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行  
        Object returnValue = invocation.proceed();  
        System.out.println("输出：" + args[0] + ";" + method + ";" + target + ";" + returnValue + "\n");  
        System.out.println("===========结束进入around===========");  
        return returnValue;  
	}

}
