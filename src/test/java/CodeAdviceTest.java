import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.aop.service.Greeting;

public class CodeAdviceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");  
	        IBaseBusiness business = (IBaseBusiness ) context.getBean("businessProxy");  
	        business.delete(new Customer("Tom","male",22));  */
		
		/*ProxyFactory proxy = new ProxyFactory();
		proxy.setTarget(new GreetingImpl());
		//proxy.addAdvice(new CodingAdvice());
		proxy.addAdvice(new CodingAroundAdvice());
		
		Greeting greeting = (Greeting) proxy.getProxy();
		greeting.sayHello("ancle");*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:aop-coding-config.xml");  
		Greeting proxyBean = (Greeting) context.getBean("proxyFactory");  
		proxyBean.sayHello("yiwq");
	}

}
