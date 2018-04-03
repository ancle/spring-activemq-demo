package com.demo.common.aop.advice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.demo.common.aop.MonitorSession;

public class DynamicProxy implements InvocationHandler {
	private Object target;
	
	public DynamicProxy(Object obj) {
		this.target = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		MonitorSession.begin(method.getName());
		
		Object result = method.invoke(target, args);
		
		MonitorSession.end();
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getProxy() {
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), 
					target.getClass().getInterfaces(), this);
	}

}
