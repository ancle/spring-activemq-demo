package com.demo.aop.service.impl;

import com.demo.aop.entity.Customer;
import com.demo.aop.service.IBaseBusiness;

public class BaseBusiness implements IBaseBusiness {

	@Override
	public void delete(Customer obj) {
		System.out.println("||=====================||");  
        System.out.println("删除用户:"+obj.getName());  
        System.out.println("||=====================||"); 
	}

}
