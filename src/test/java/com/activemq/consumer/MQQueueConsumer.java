package com.activemq.consumer;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MQQueueConsumer {

	public static void main(String[] args) throws JMSException, IOException {
		// 第一步：创建ConnectionFactory对象
		ConnectionFactory connFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
		
		// 第二步：创建Connection对象
		Connection conn = (Connection) connFactory.createConnection();
		
		// 第三步：调用Connection对象的start方法
		conn.start();
		
		// 第四步：创建Session对象
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		// 第五步：使用Session对象创建一个Destination对象。和发送到保持一致的queue，并且队列的名称一致
		Queue queue = session.createQueue("test-queue");
		
		// 第六步：使用Session对象创建一个Consumer对象
		MessageConsumer consumer = session.createConsumer(queue);
		
		// 第七步：接收消息
		consumer.setMessageListener(new MessageListener() {
			public void onMessage(Message message) {
				TextMessage txtMsg = (TextMessage)message;
				
				String msg = "";
				if (txtMsg != null) {
					try {
						msg = txtMsg.getText();
						
						System.out.println("consumer : " + msg + " ; jmsType : " + txtMsg.getJMSType());
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
