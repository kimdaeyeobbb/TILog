package day18.course;

@FunctionalInterface
interface MyFunctionalInterface3 {
	public int method3(int x, int y);
}

public class LambdaTest7 {
	public static void main(String[] args) {
		/* 람다식 */
		MyFunctionalInterface3 fi = (x, y) -> {
			int result = x + y;
			return result;
		};
		System.out.println(fi.method3(1, 1));


		fi = (x, y) -> {
			return x + y;
		};
		System.out.println(fi.method3(2, 1));

		// 수행문장이 하나이면 중괄호 생략 가능
		// 리턴문이 하나이면 생략 가능
		fi = (x, y) -> x + y;
		System.out.println(fi.method3(3, 1));


		fi = (x, y) -> Math.addExact(x, y);
		System.out.println(fi.method3(4, 1));


		// 화살표가 없어도 람다식
		// Math.addExact로 쓰면 안됨
		// 받은거 주대로 준다는 의미에서 Math::addExact 사용 (2개받으면 2개를 가지고 명령 수행해서 그대로 2개 준다.)
		fi = Math::addExact;
		System.out.println(fi.method3(5, 1));

		fi = (x, y) -> sum(x, y);
		System.out.println(fi.method3(6, 1));

		// 화살표가 없어도 람다식
		// 맨뒤에 괄호()주면 안됨
		fi = LambdaTest7::sum;
		System.out.println(fi.method3(7, 1));
	}

	// static이므로 람다식이라고 해도 자바 프로그램 구문 범위안에서의 구현이므로 같은 클래스 내의 또다른 static형 메서드를 호출하는 것에 문제가 없다
	public static int sum(int x, int y) {
		return (x + y);
	}
}
