package com.demo.common.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class BaseAfterReturningAdvice implements AfterReturningAdvice {

	@Override
	/**
	 * returnValue ：切入点执行完方法的返回值，但不能修改<br>
	 * method ：切入点方法 <br>
	 * args ：切入点方法的参数数组 <br>
	 * target ：目标对象 
	 */
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("====进入after()==========");
		System.out.print(args[0] + "在");
		System.out.print(target + "对象上被");
		System.out.println(method + "方法删除了");
		System.out.println("====退出after()===========");
	}
}
