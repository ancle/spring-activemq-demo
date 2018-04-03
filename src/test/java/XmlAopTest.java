import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.aop.service.Greeting;

public class XmlAopTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 /*ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-aop.xml");  
	        AspectBusiness  business = (AspectBusiness  ) context.getBean("aspectBusiness");  
	        business.delete("JACK");  */
//	        business.add("JACK");  
//	        business.modify("JACK");  
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:aop-coding-config.xml");  
		Greeting  greeting = (Greeting) context.getBean("greetingImpl");  
		greeting.sayHello("yiwq"); 
	}

}
