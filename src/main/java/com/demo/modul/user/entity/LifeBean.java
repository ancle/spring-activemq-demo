package com.demo.modul.user.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

//@Component
public class LifeBean implements BeanPostProcessor, InitializingBean, BeanNameAware {
	private String beanName;
	private String name;
	private LifeBean lb;
	
	public LifeBean() {
		System.out.println("LifeBean()构造函数");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LifeBean getLb() {
		return lb;
	}

	public void setLb(LifeBean lb) {
		this.lb = lb;
	}
	
	//@PostConstruct
	public void init() {
		System.out.println("初始化LifeBean对象");
	}
	
	//@PreDestroy
	public void destroy() {
		System.out.println("销毁LifeBean对象");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("ceshi InitializingBean");       
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		System.out.println("postProcessBeforeInitialization : bean class," + bean.getClass().getName() + " | beanName = " + beanName);
		
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		
		System.out.println("postProcessAfterInitialization : bean class," + bean.getClass().getName() + " | beanName = " + beanName);
		
		return bean;
	}

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}
	
	public String getBeanName() {
		return this.beanName;
	}
}
