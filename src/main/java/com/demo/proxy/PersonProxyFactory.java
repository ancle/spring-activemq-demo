package com.demo.proxy;

import com.demo.common.aop.advice.DynamicProxy;
import com.demo.modul.user.service.Speakable;
import com.demo.modul.user.service.impl.PersonImpl;

public class PersonProxyFactory {
	public static Speakable newJdkProxy() {
		DynamicProxy proxy = new DynamicProxy(new PersonImpl());
		
		return proxy.getProxy();
	}
}
