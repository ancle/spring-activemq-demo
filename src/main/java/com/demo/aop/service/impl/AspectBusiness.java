package com.demo.aop.service.impl;

public class AspectBusiness {
	  /** 
     * 切入点 
     */  
    public String delete(String obj) {  
        System.out.println("==========delete===========");  
        System.out.println("==========delete===========");  
        System.out.println("==========delete===========");  
        return obj;  
    }  
  
    public String add(String obj) {  
        System.out.println("================add============== ");  
        System.out.println("================add============== ");  
        System.out.println("================add============== ");  
          
        return obj;  
    }  
  
    public String modify(String obj) {  
        System.out.println("=================modify====================");  
        System.out.println("=================modify====================");  
        System.out.println("=================modify====================");  
        return obj ;  
    }  
}
