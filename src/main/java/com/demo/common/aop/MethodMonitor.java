package com.demo.common.aop;

public class MethodMonitor {
	private long start;
	
	private String method;
	
	public MethodMonitor(String method) {
		this.method = method;
		System.out.println("begin monitor...");
		this.start = System.currentTimeMillis();
	}
	
	public void log() {
		long elspsedTime = System.currentTimeMillis() - this.start;
		
		System.out.println("end monitor...");
		System.out.println("Method:" + this.method + ", execution time:" + elspsedTime);
	}
}
