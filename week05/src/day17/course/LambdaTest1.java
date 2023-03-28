package day17.course;

// 함수형 인터페이스 -> 내부에 추상메서드가 1개
interface Sample {
	int calc(int n);
}

class MyTest {
	// static이 아닌 일반 메서드여도 무관
	static void pr(Sample p) {
		// Sample을 구현할 수 있는 자손 객체는 누구든지 매개변수 자리에 올수 있음
		System.out.println(p.calc(10));
	}
}

public class LambdaTest1 {
	public static void main(String[] args) {
		class SampleImpl implements Sample {
			public int calc(int n) {
				return n + 1;
			}
		}
		Sample obj = new SampleImpl();
		MyTest.pr(obj);

		MyTest.pr(new Sample() {
			public int calc(int n) {
				return n + 10;
			}
		});

		MyTest.pr((int n) -> {
			return n + 100;
		});
		MyTest.pr((n) -> {
			return n + 100;
		});
		MyTest.pr(n -> {
			return n + 100;
		});
		MyTest.pr(n -> n + 100);
	}
}
