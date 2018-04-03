package com.activemq.topic.consumer;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicConsumerTest {

	public static void main(String[] args) throws JMSException, IOException {
		// 第一步：创建ConnectionFactory对象
		ConnectionFactory connFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
		
		// 第二步：创建Connection
		Connection conn = connFactory.createConnection();
		
		// 第三步：启用Connection
		conn.start();
		
		// 第四步：创建Session
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		// 第五步：创建Destination对象
		Topic topic = session.createTopic("test-topic");
		
		// 第六步：
		MessageConsumer consumer = session.createConsumer(topic);
		
		consumer.setMessageListener(new MessageListener() {

			@Override
			public void onMessage(Message message) {
				TextMessage txtMessage = (TextMessage)message;
				
				String text = null;
				if (txtMessage != null) {
					try {
						text = txtMessage.getText();
						String jmsType = txtMessage.getJMSType();
						
						System.out.println("consumer : " + text + "; jmsType : " + jmsType); 
					} catch (JMSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		
		System.in.read();
		     
		consumer.close();
		session.close();
		conn.close();
	}
}
