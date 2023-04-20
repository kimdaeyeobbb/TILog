package week08.day32.course.sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FooTestApp {
	public static void main(String[] args) {
		ApplicationContext factory
    		= new ClassPathXmlApplicationContext("sample2.xml"); // 객체 생성
		System.out.println("************ IoC 컨테이너의 초기화 작업 끝 ************\n");
		// Spring IoC가 초기화 되는 시점에서 객체 생성 되지 x (싱글톤인 애들만 ApplicationContext가 생성되는 동안 미리 객체 생성)


		/* Bean 객체를 달라고 할 떄마다(요청시마다) 객체 생성 => 미리 객체 생성하는 것이 아닌 필요하다고 할 때 수행(lazy execution) */
		System.out.println("\nScope(singleton/prototype)");
		Foo ob1=(Foo)factory.getBean("foo0"); // xml 파일에서  foo0는 기본 싱글톤에서 prototype 속성을 바꿈 -> 싱글톤이 아니게 됨
		// 프로토타입은 필요할 때 마다 그때그때 객체를 생성해달라고 함
		System.out.println(ob1);
		Foo ob2=(Foo)factory.getBean("foo0");
		System.out.println(ob2);
		Foo ob3=(Foo)factory.getBean("foo0");
		System.out.println(ob3);
		
		((ClassPathXmlApplicationContext)factory).close();
	}
}
