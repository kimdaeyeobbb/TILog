package week08.day33.course.sampleno1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FoodTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("sampleanno1.xml");
		System.out.println("************ IoC 컨테이너의 초기화 작업 끝 ************\n");
		
		MyFoodMgr ob=factory.getBean("myFood", MyFoodMgr.class);
		// 컴포넌트 스캔 파일을 가지고있는 bean 설정파일 지정은 필수 (스프링 IoC 컨테이너가 모두 뒤질수는 없으므로)
		System.out.println(ob.toString());

		((ClassPathXmlApplicationContext) factory).close();
	}
}
