package day17.course;

// 함수형 인터페이스
interface Calculation {
	public int add(int a, int b);
}
// 객체가 인터페이스이고 내부에 메서드가 하나있으면 람다식으로 만들어서 전달할 수 있음
// 람다식으로 만들어서 전달할 경우 -> 실제로 전달할 때에는 익명 객체


public class LambdaTest2 {
	public static void exec(Calculation com) {
		int k = 10;
		int m = 20;
		int value = com.add(k, m);
		System.out.println("덧셈 결과 : " + value);
	}

	public static void main(String[] args) {
		/*  annonymouse inner local class 방법 이용 */
		// 실제로 만들어지는 클래스명 - LambdaTest2$1
		exec(new Calculation() {
			public int add(int a, int b) {
				return a + b;
			}
		});

		/* 람다식 이용 */
		exec((int a, int b) -> {
			return a + b;
		});
		
		exec((a, b) -> a*a + b*b);
	}
}
