package com.activemq.test;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class SpringActiveMQTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-activemq.xml");
		
		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
		Queue queue = (Queue) context.getBean("queueDest");
		
		jmsTemplate.send(new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("hello, yiwq");
			}
			
		});
	}

}
