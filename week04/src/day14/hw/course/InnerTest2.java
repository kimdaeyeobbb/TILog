package day14.hw.course;

class LocalTest {
	String name = "Java";

	void pr(final String s) {
		final int su = 100;
		System.out.println(s + " : " + su);
		class Local {
			// LocalTest$1Local꼴로 생성될 것임
			// Local 클래스가 객체 생성되어 사용되려면 pr메서드가 호출되어야 함.
			void pr(String ls) {
				System.out.println("s : " + s);
				System.out.println("ls : " + ls);
				System.out.println(name);  // 멤버변수 name 출력
				System.out.println(su);  // pr 메서드 내부의 final형 지역변수인 su의 값을 출력
			}
		}
		Local lt = new Local();  // 객체 생성
		lt.pr("Local Test"); // 문자열 전달
	}
}

public class InnerTest2 {
	public static void main(String args[]) {
		LocalTest l = new LocalTest();
		l.pr("Main Call");
	}
}
