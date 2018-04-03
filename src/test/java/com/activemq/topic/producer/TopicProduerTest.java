package com.activemq.topic.producer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicProduerTest {

	public static void main(String[] args) throws JMSException {
		// 第一步：创建ConnectionFactory对象
		ConnectionFactory connFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
		
		// 第二步：创建Connection对象
		Connection conn = connFactory.createConnection();
		
		// 第三步：调用Connection对象的start方法
		conn.start();
		
		// 第四步：创建Session对象
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		// 第五步：创建Topic对象
		Topic topic = session.createTopic("test-topic");
		
		// 第六步：创建Producer对象
		MessageProducer producer = session.createProducer(topic);
		
		// 第七步：创建Message对象
		Message txtMsg = session.createTextMessage("测试Topic对象");
		
		// 第八步：使用Producer发送数据
		producer.send(txtMsg);
		
		producer.close();
		session.close();
		conn.close();
		
	}

}
