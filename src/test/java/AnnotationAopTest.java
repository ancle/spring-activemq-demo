import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.modul.user.entity.LifeBean;

public class AnnotationAopTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-annotation-aop.xml");  
        /*AnnotationBusiness business = (AnnotationBusiness) context.getBean("annotationBusiness");  
        business.delete("JACK");  */
		
		/*Speakable business = (Speakable) context.getBean("personSpring");  
        business.sayBye();*/
		
		LifeBean lifeBean = (LifeBean) context.getBean(LifeBean.class);
		System.out.println("BeanNameAware : " + lifeBean.getBeanName());
	}

}
