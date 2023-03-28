package day17.course;

@FunctionalInterface // 함수형 인터페이스 체크 어노테이션
interface MyNumber {
	int getMax(int num1, int num2);
}

public class LambdaTest3 {
	public static void main(String[] args) {
		/* anonymous inner local class */
		// MyNumber형 - 얘를 구현하는 자식 객체가 되겠구나. 하고 예상할 수 있음.
		// MyNumber가 가지는 추상 메서드를 오버라이딩 하고 있음
		MyNumber max1 = new MyNumber() {
			public int getMax(int x, int y) {
				return (x >= y) ? x : y;
			}
		};
		System.out.println(max1.getMax(100, 300));

		/* 람다식 */
		MyNumber max2 = (int x, int y) -> {
			return (x >= y) ? x : y;
		};

		System.out.println(max2.getMax(100, 300));

		/* 람다식 */
		MyNumber max3 = (x, y) -> (x >= y) ? x : y;

		System.out.println(max3.getMax(100, 300));		
	}
}
