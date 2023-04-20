package week08.day32.course.sample1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class HelloSpringApp {
	public static void main(String[] args) {

		// applicationcontext 객체 생성 -> 스프링 컨테이너 (IoC 컨테이너) 초기화
		ApplicationContext factory
		    	= new ClassPathXmlApplicationContext("sample1.xml");
		System.out.println("************ IoC 컨테이너의 초기화 작업 끝 ************\n");


		MessageBean bean1=(MessageBean)factory.getBean("messageBean1");
		bean1.sayHello();                 
		bean1.sayHello("banana", 1500);   
		System.out.println(bean1);
		System.out.println(factory.getBean("messageBean1"));
		System.out.println(factory.getBean("messageBean1"));
		// messageBean1 객체를 3번 찾아옴 -> 이때마다 toString이 어떤지 살펴보기
		// 싱글톤이므로 객체의 참조값이 다 똑같음
		// 싱글톤 - 자바 클래스가 수행되는 동안 객체가 하나만 생성 (스프링은 기본적으로 싱글톤임)


		// 메세지빈 객체를 2번째 생성
		MessageBean bean2=(MessageBean)factory.getBean("messageBean2");

		// 객체 생성 후 setter 호출
		bean2.sayHello();                 
		bean2.sayHello("banana", 1500); 
		System.out.println(bean2);
		((ClassPathXmlApplicationContext)factory).close();
	}
}