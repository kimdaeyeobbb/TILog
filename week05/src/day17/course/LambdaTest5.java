package day17.course;

@FunctionalInterface
interface MyFunctionalInterface1 {
	public void method1();
}

public class LambdaTest5 {
	public static void main(String[] args) {
		/* 람다식 */
		MyFunctionalInterface1 fi = () -> {
			String str = "method call1";
			System.out.println(str);
		};
		fi.method1();

		/* 람다식 */
		// 출력메시지를 바로 argument로 전달
		// 수행문장이 하나일 경우 중괄호 생략 가능
		fi = () -> System.out.println("method call2");		
		fi.method1();
	}
}