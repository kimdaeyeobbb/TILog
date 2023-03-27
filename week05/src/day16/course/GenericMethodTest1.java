package day16.course;

import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;

public class GenericMethodTest1 {
	/* 제네릭 메소드 */

	// 매개변수 타입에 제네릭을 쓰는 것이 좋다
	// 매개변수 타입에만 타입 파라미터 사용
	// 리턴값이 없음 (제네릭 타입에도 리턴값의 유형을 꼭 적어야하는것은 아님)
	public static <T> void test1(T t) {
		System.out.println("어떤 객체가 전달되었을까요? "+t.getClass().getName());
	}

	// 리턴값이 있음
	public static <T> String test2(T t) {
		return "제네릭 메서드 : " + t;
	}

	// 리턴하는 것 - ArrayList 객체
	public static <T> ArrayList<T> test3(int num) {		
		return new ArrayList<T>(num);
	}

	// 매개변수, 리턴값의 유형에 제네릭 사용
	// 숫자형, 문자형 ... 등 메서드를 호출하는 개발자 마음대로 ArrayList가 다루는 데이터의 형태를 결정할 수 있음
	// 어떤 타입의 데이터를 저장하고 있든간에 제한 없이 ArrayList 객체이기만 하면 된다고 지정해준 것
	// 문자열을 보관하고 있는 ArrayList 객체 전달시 리턴값의 타입은 String.
	// 인자로 전달된 값에 따라서 리턴값의 유형을 달리함
	public static <T> T test4(ArrayList<T> t) {
		return t.get(0);		// ArrayList가 첫번쨰 element를 찾아서 리턴
	}

	public static void main(String[] args) {		
		test1("가나다");
		test1(new java.util.Date());
		test1(100);
		System.out.println("-----------------------");
		System.out.println(test2("가나다"));
		System.out.println(test2(new java.util.Date()));
		System.out.println(test2(100));
		System.out.println("-----------------------");
		ArrayList<Date> l1 = test3(10);
		l1.add(new Date());
		l1.add(new Date());
		System.out.println(l1);
		ArrayList<String> l2 = test3(10);
		l2.add("가나다");
		l2.add("abc");
		l2.add("123");
		System.out.println(l2);
		System.out.println("-----------------------");
		Date d = test4(l1);
		String s = test4(l2);
		System.out.println(d);
		System.out.println(s);
	}
}