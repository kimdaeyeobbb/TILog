package aop08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		ApplicationContext factory=new ClassPathXmlApplicationContext("aop08.xml");
		
		MessageBean ob=factory.getBean("proxy",MessageBean.class);  // proxy라는 이름으로 만들어진 메세지빈 객체 찾아와서 imple호출하는 예제
		ob.sayHello();
		
		((ClassPathXmlApplicationContext)factory).close();
	}
}
