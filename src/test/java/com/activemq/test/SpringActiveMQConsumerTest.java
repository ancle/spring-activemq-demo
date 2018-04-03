package com.activemq.test;

import javax.jms.Queue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class SpringActiveMQConsumerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-activemq.xml");
		
		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
		Queue queue = (Queue) context.getBean("queueDest");
		
	}

}
