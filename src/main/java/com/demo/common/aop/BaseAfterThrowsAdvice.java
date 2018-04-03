package com.demo.common.aop;

import org.aspectj.apache.bcel.classfile.Method;
import org.springframework.aop.ThrowsAdvice;

public class BaseAfterThrowsAdvice implements ThrowsAdvice {
	public void afterThrowing(Method method, Object[] args, Object target, Throwable throwable) {
		System.out.println("删除出错");
	}
}
