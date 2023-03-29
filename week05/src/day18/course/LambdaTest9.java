package day18.course;

@FunctionalInterface
interface MyFunctionalInterface5 {
	public int[] method5(int size);
	// 리턴값의 유형이 배열 : int[]
}

public class LambdaTest9 {
	public static void main(String[] args) {
		MyFunctionalInterface5 fi = (int size) -> {
			return new int[size];
		};
		System.out.println(fi.method5(10).length);
		// 10개의 요소를 갖는 배열이 리턴됨


		// 매개변수의 타입 및 괄호 생략 가능 (매개변수가 1개이므로)
		// 호출시 size에 기반한 int형 배열 생성
		fi = size -> {
			return new int[size];
		};
		System.out.println(fi.method5(5).length);

		// 수행문장이 1개 -> 중괄호 생략 가능
		fi = size -> new int[size];
		System.out.println(fi.method5(8).length);

		// int형 배열을 생성해서 리턴하므로 타입 유형을 맞추어서 타입명[]::new 꼴로 람다식으로 사용할 수 있다.
		fi =  int[]::new;
		System.out.println(fi.method5(20).length);		// 20개의 요소를 갖는 배열이 리턴됨
	}
}
