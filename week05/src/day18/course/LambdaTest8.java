package day18.course;

import java.util.Date;

@FunctionalInterface
interface MyFunctionalInterface4 {
	public Date method4();
}

public class LambdaTest8 {
	public static void main(String[] args) {
		MyFunctionalInterface4 fi = () -> {
			return new Date();
			// Date형을 리턴값으로 하는 메서드를 구현하고 있으므로 Date 객체를 리턴해야함
		};
		System.out.println(fi.method4());
		// 리턴된 Date 객체의 toString 내용이 화면에 출력됨
		// Date 객체가 생성된 시점의 년월일 정보가 나올 것임

		fi = () -> {
			return new Date();
		};
		System.out.println(fi.method4());

		fi = () -> new Date();
		System.out.println(fi.method4());

		// Date::new 형식을 쓸 경우에는 매개변수의 사양도 지우고 화살표도 지워야 함
		// () -> Date::new; 처럼 쓰면안됨
		fi =  Date::new;
		System.out.println(fi.method4());		
	}
}
