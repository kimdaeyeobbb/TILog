package day17.course;

//@FunctionalInterface
// 인터페이스 내에 추상메서드가 2개인 상황
// 이때 FunctionalInterface annotation을 갖는다면 에러 발생
interface Test {
	void run();

	void print();
}

public class LambdaTest4 {
	public static void main(String[] args) {
		/* anonymous inner local class */
		Test test = new Test() {
			@Override
			public void run() {
				System.out.println("run");
			}

			@Override
			public void print() {
				System.out.println("print");
			}
		};
		test.run();
		test.print();
	}
}
