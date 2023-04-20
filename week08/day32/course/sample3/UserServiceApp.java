package week08.day32.course.sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceApp {
	public static void main(String[] args) {
		ApplicationContext factory 
        		= new ClassPathXmlApplicationContext("sample3.xml");
		System.out.println("************ IoC 컨테이너의 초기화 작업 끝 ************\n");
		
		UserService u1=(UserService)factory.getBean("userService");  // 리턴값의 유형- obejct => 강제형변환을 해야함
		UserVo vo = (UserVo)factory.getBean("obj1");
		u1.addUser(vo);
		System.out.println(u1);
		System.out.println("----------------------------------------------------");
		
		UserService u2=factory.getBean("userService", UserService.class);
		//  클래스 타입의 객체를 전달
		// UserService를 구현한 (UserService 타입을 만족한) 인터페이스의 객체
		// 확장자를 생략하지 말아야 함. 확장자를 써우저야 비로소 해당 클래스 티입의 객체가 됨

		UserVo vo2 = (UserVo)factory.getBean("obj2");
		u2.addUser(vo2);
		System.out.println(u2);		
		((ClassPathXmlApplicationContext)factory).close();
	}
}





