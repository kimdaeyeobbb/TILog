package week08.day32.course.sample7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {
	public static void main(String[] args) {
		ApplicationContext factory =
				   new ClassPathXmlApplicationContext("sample7_1.xml");
		// sample7_2.xml로 바꿔서도 실행 해볼 것

		System.out.println("************ IoC 컨테이너의 초기화 작업 끝 ************\n");
		
		Emp b1 = (Emp)factory.getBean("developer");
		System.out.println(b1.toString());
		
		Emp b2 = (Emp)factory.getBean("engineer");
		System.out.println(b2.toString());
		
		((ClassPathXmlApplicationContext)factory).close();
	}
}
