package com.demo.aop.service;

import com.demo.aop.entity.Customer;

public interface IBaseBusiness {
	/**  
    * 用作代理的切入点方法  
    *   
    * @param obj  
    * @return  
    */  
   public void delete(Customer obj);  
}
