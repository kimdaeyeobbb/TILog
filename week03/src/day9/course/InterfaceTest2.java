package day9.course;

interface Inter1 {
	void expr1();
}

interface Inter2 {
	void expr2();
}

interface Inter3 extends Inter1, Inter2 {
	// Inter3 구현시 오버라이딩 해야하는 메서드는 3개
	void expr3();
}

class InterClass implements Inter3 {
	// Inter3가 물려받은 조상의 메서드 또한 모두 오버라이딩을 해야함
	// Inter3는 3개의 추상메서드를 가지고 있는것과 동일
	public void expr1() {
		System.out.println("expr1() 메서드 오버라이딩");
	}

	public void expr2() {
		System.out.println("expr2() 메서드 오버라이딩");
	}

	public void expr3() {
		System.out.println("expr3() 메서드 오버라이딩");
	}
}

public class InterfaceTest2 {
	public static void main(String args[]) {
		System.out.println("InterClass 객체를 Inter1 타입 변수에 대입");

		// InterClass 객체 생성해서 Inter1 유형의 변수에 대입
		// 부모 인터페이스 유형의 클래스 객체가 대입되어 사용되고 있음.
		// 단, 어떤 유형의 인터페이스 유형이냐에 따라 접근할 수 있는 것이 달라짐
		Inter1 obj1 = new InterClass();
		obj1.expr1();
		System.out.println("InterClass 객체를 Inter2 타입 변수에 대입");
		Inter2 obj2 = new InterClass();
		obj2.expr2();
		System.out.println("InterClass 객체를 Inter3 타입 변수에 대입");
		Inter3 obj3 = new InterClass();
		obj3.expr1();
		obj3.expr2();
		obj3.expr3();
	}
}
