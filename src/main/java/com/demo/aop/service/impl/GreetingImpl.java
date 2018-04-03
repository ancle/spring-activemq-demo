package com.demo.aop.service.impl;

import org.springframework.stereotype.Service;

import com.demo.aop.service.Greeting;

@Service
public class GreetingImpl implements Greeting {

	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("hello, " + name);
	}

}
