package day18.course;

@FunctionalInterface
interface MyFunctionalInterface6 {
	public int method6(String str);
	// 문자열을 받아서 int형 리턴
}

public class LambdaTest10 {
	public static void main(String[] args) {
		MyFunctionalInterface6 fi = (String str) -> {
			return str.length();
		};
		System.out.println(fi.method6("HTML"));

		fi = str -> {
			return str.length();
		};
		System.out.println(fi.method6("JAVASCRIPT"));

		fi = str -> str.length();
		System.out.println(fi.method6("CSS"));
		// 매개변수로 전달된 String 객체의 메서드를 호출할 것임


		// 전달된 String 객체를 가지고 메서드를 호출할 것임
		// 따라서 메서드 호출식으로 람다식을 대신할 때에는 매개변수 또한 지정하지 않음
		// 전달받는 클래스의 객체이름::호출하고 싶은 메서드 -> 이 꼴로 설계가 되어 있음

		// 문자열의 길이 받아서 리턴
		fi =  String::length;
		System.out.println(fi.method6("AJAX"));		
	}
}
