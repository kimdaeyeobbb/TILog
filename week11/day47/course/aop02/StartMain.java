package aop02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

/* aop01중 로그인 처리와 로그아웃 처리를 밖으로 뺀 예제 */
public class StartMain {
	public static void main(String[] args) {
		ApplicationContext factory
				= new ClassPathXmlApplicationContext("aop02.xml");
		// 스프링 컨테이너에게 미리 객체 생성해달라고 xml파일안에 구현해놓음
		String beanName;

		// 어떤 빈객체를 찾아와서 구분하는지에 따라 결과가 달라짐
		if (new Random().nextBoolean())
			beanName = "customer";
		else
			beanName = "emp";


		// 스프링 컨테이너에게 미리 객체 생성해달라고 xml파일안에 구현해놓음
		Person p=(Person)factory.getBean(beanName); // customer or emp
		p.work();
		((ClassPathXmlApplicationContext)factory).close();
	}
}
