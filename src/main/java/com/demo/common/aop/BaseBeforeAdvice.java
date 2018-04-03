package com.demo.common.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BaseBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("=进入before()============");
		System.out.print("准备在" + target + "对象上用");
		System.out.print(method + "方法进行对 '");
		System.out.println(args[0] + "'进行删除！");
		System.out.println("=退出before()============");
	}

}
