package week08.day33.course.sample9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMain {

	public static void main(String[] args) {
		ApplicationContext factory 
		    = new ClassPathXmlApplicationContext("sample9.xml");
		System.out.println("************ IoC 컨테이너의 초기화 작업 끝 ************\n");
		
		UserShow ob=factory.getBean("myProcess0", UserShow.class);
		System.out.println(ob.toString());	// user=null. 전달받은 유저 객체가 없음.
		System.out.println("-----------------");		
		UserShow ob1=factory.getBean("myProcess1", UserShow.class);
		System.out.println(ob1.toString());	
		System.out.println("-----------------");		
		UserShow ob2=factory.getBean("myProcess2", UserShow.class);
		System.out.println(ob2.toString());	
		System.out.println("-----------------");		
		UserShow ob3=factory.getBean("myProcess3", UserShow.class);
		System.out.println(ob3.toString());	
		
		((ClassPathXmlApplicationContext)factory).close();
	}
}
