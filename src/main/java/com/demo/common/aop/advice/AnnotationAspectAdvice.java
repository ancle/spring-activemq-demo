package com.demo.common.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnotationAspectAdvice {
	/** 
     * 指定切入点匹配表达式，注意它是以方法的形式进行声明的。 
     */  
    @Pointcut("execution(* com.demo.aop.service.impl.*.*(..))")  
    public void anyMethod() {  
    }  
  
    /** 
     * 前置通知 
     *  
     * @param jp 
     */  
    @Before(value = "execution(* com.demo.aop.service.impl.*.*(..))")  
    public void doBefore(JoinPoint jp) {  
        System.out.println("===========进入before advice============");  
  
        System.out.print("准备在" + jp.getTarget().getClass() + "对象上用");  
        System.out.print(jp.getSignature().getName() + "方法进行对 '");  
        System.out.print(jp.getArgs()[0] + "'进行删除！\n\n");  
  
        System.out.println("===========退出before advice============");  
    }  
  
    /** 
     * 后置通知 
     *  
     * @param jp 
     *            连接点 
     * @param result 
     *            返回值 
     */  
    @AfterReturning(value = "anyMethod()", returning = "result")  
    public void doAfter(JoinPoint jp, String result) {  
        System.out.println("==========进入after advice=========== ");  
        System.out.println("切入点方法执行完了 ");  
  
        System.out.print(jp.getArgs()[0] + "在");  
        System.out.print(jp.getTarget().getClass() + "对象上被");  
        System.out.print(jp.getSignature().getName() + "方法删除了");  
        System.out.print("只留下：" + result + "\n");  
        System.out.println("==========退出after advice=========== ");  
    }  
  
    /** 
     * 环绕通知 
     *  
     * @param pjp 
     *            连接点 
     */  
    @Around(value = "execution(* com.demo.aop.service.impl.*.*(..))")  
    public void doAround(ProceedingJoinPoint pjp) throws Throwable {  
        System.out.println("===========进入around环绕方法！=========== \n");  
  
        // 调用目标方法之前执行的动作  
        System.out.println("调用方法之前: 执行");  
  
        // 调用方法的参数  
        Object[] args = pjp.getArgs();  
        // 调用的方法名  
        String method = pjp.getSignature().getName();  
        // 获取目标对象  
        Object target = pjp.getTarget();  
        // 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行  
        Object result = pjp.proceed();  
  
        System.out.println("输出：" + args[0] + ";" + method + ";" + target + ";" + result );  
        System.out.println("===========退出around环绕方法！===========");  
    }  
  
    /** 
     * 异常通知 
     *  
     * @param jp 
     * @param e 
     */  
    @AfterThrowing(value = "execution(* com.demo.aop.service.impl.*.*(..))", throwing = "e")  
    public void doThrow(JoinPoint jp, Throwable e) {  
        System.out.println("删除出错啦");  
    }  
}
