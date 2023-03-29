package day18.course;

interface ActionExpression {
	void exec(Object... param);
	// Object... -> 어떤 객체든 올 수 있고, 몇개든 올 수 있다는 것
	// printf메서드 2번쨰 인자는 Object...임
	// printf 첫번쨰 인자는 문자열, 두번쨰 인자는 어떤 타입이든, 몇개든 와도 됨
}

interface FuncExpression<T> {
	// 인터페이스의 객체 생성시 어떤 타입의 데이터를 다룰 것인지는 사용할떄마다 결정하겠다는 것
	T exec(Object... param);
	// 객체 생성시점에서 타입 파라미터를 뭘로 주느냐에 따라서 그에 맞는 타입을 리턴할 것임
}

public class LambdaTest12 {
	public static void test1(ActionExpression action) {
		action.exec("hello world", "aaa","bbb");
	}

	public static void test2(FuncExpression<String> func) {
		// 문자열을 다루는 FuncExpression을 받겠다는 것

		String ret = func.exec("hello world","aa","111","가나다");
		// exec 호출해서 String 변수에 담음

		System.out.println(ret);
	}

	public static void main(String[] args) throws Exception {
		/* anonymous inner class */
		// LambdaTest12$1 이라는 컴파일 결과물이 도출
		test1(new ActionExpression() {
			public void exec(Object... data) {
				// 여기서는 객체가 배열에 담긴다고 보면 됨
				System.out.println("Test1 - " + data[0]);
				// 첫번쨰 요소
			}
		});
		test2(new FuncExpression<String>() {
			// 문자열을 다루는 객체
			// 여기서는 타입 파라미터를 생략하면 안됨 (변수 선언과 생성자 생성을 동시에 할때에만 생략 가능)
			public String exec(Object... data) {
				System.out.println(data[0]);
				return "OK1";
			}
		});

		test1((Object... data) -> System.out.println("Test2 - " + data[0]));

		test1(data -> System.out.println("Test3 - " + data[0]));
		// 타입 생략해도 에러나지 않음

		test2((Object... data) -> {
			System.out.println(data[0]);
			return "OK2";
		});
	}
}
