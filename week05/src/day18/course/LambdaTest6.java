package day18.course;

@FunctionalInterface
interface MyFunctionalInterface2 {
	public void method2(int x);
	// 인자 하나 받는 것임을 타입을 보면 알 수 있음
}

public class LambdaTest6 {
	public static void main(String[] args) {
		/* 람다식에 의해 만들어진 익명 객체 */
		MyFunctionalInterface2 fi = (x) -> {
			// 함수가 호출되었을 시 수행하게 될 내용
			System.out.println(x);
		};
		fi.method2(2);
		// method2 호출시 (x) -> {~}부분이 호출됨

		fi = x -> System.out.println(x);
		fi.method2(2);

		// 또 다른 메서드를 호출하는 수행하는 문장 1개로만 구성됨 람다식
		// (인자로 전달된 데이터를 호출되는 메서드에) 인자로 전달하여 출력하는것이 전부일 경우 System.out::println사용하는 것도 람다식으로 간주됨
		// System.out.println-> 인자를 받아서 출력하는 역할
		// println은 print 스트림이 가지고 있는 일반 메서드
		// System.out은 static 형으로서 자동으로 객체가 만들어짐. System.out은 출력 스트림을 만들어주는 객체
		// out은 따라서 자동으로 print 스트림을 참조하게 됨
		// 여기서는 print 스트림의 println을 참조하겠다는 것.
		// 따라서 System.out::println으로만 써줘도 람다식으로 간주되는 것임

		fi = System.out::println;
		fi.method2(2);
	}
}
