package com.activemq.provider;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;


public class MQQueueProviderTest {

	public static void main(String[] args) throws JMSException {
		// 第一步：创建ConnectionFactory对象，需要指定服务端IP和端口
		ConnectionFactory connFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
		
		// 第二步：使用ConnectionFactory对象创建一个Connection对象
		Connection conn = connFactory.createConnection();
		
		// 第三步：开启连接，调用Connection对象的start方法
		conn.start();
		
		//第四步：使用Connection对象创建一个session对象
		// 第一个参数：是否开启事务
		// 第二个参数：当第一个参数为false时，才有意义（消息的应答模式：1，自动应答；2，手动应答），一般为自动应答
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		// 第五步：使用Session对象创建一个Destination对象（topic、queue），此处创建一个Queue对象
		// 参数：队列名
		Queue queue = session.createQueue("test-queue");
		
		// 第六步：使用Session对象创建一个Producer对象
		MessageProducer producer = session.createProducer(queue);
		
		// 第七步：创建一个Message对象，创建一个TextMessage对象。
		TextMessage txtMsg = session.createTextMessage("扆武强进行MQ Queue测试");
		
		// 第八步：使用Producer对象发送消息
		producer.send(txtMsg);
		
		// 第九步：关闭资源
		producer.close();
		session.close();
		conn.close();
	}
	

}
