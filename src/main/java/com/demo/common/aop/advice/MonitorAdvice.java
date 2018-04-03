package com.demo.common.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.demo.common.aop.MonitorSession;

@Aspect
@Component
public class MonitorAdvice {
	@Pointcut("execution(* com.demo.modul.user.service.Speakable.*(..))")
	public void pointcut() {}
	
	@Around("pointcut()")
	public void around(ProceedingJoinPoint jp) throws Throwable {
		MonitorSession.begin(jp.getSignature().getName());
		
		
		jp.proceed();
		
		MonitorSession.end();
	}
}
