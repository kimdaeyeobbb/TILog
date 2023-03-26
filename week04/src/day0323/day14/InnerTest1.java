package day0323.day14;

class Outer {

	// pr이 static 형이면 Outer.pr 꼴로 호출
	// 그게 아니니까 Outer 클래스에 대한 객체 생성후 pr를 호출해야함
	void pr() {
		System.out.println("Outer's pr() Method !!");
	}

	/* inner class */
	class Inner {
		void pr() {
			System.out.println("Inner's pr() Method !!");
		}
	}

	/* static inner class */
	static class Static_Inner {
		static void pr() {
			System.out.println("Static_Inner's pr() Method !!");
		}
		// staic inner member class 내부의 메서드 중 static형으로 정의된것이 static형으로 간주됨
		// Outer 클래스명으로 바로 접근하도록 처리
		// 따라서 얘를 사용하려면 Outer클래스명.Inner클래스명.메서드명 꼴로 호출
	}
}

public class InnerTest1 {
	public static void main(String args[]) {
		Outer.Static_Inner.pr();
		Outer o = new Outer();
		o.pr();  // Outer 객체 생성해서 pr 호출
		Outer.Inner i = o.new Inner();
		// inner class의 객체 생성 ( o.을 빼면 안됨. 다른 클래스 안에 있는 인스턴스 멤버이므로)
		// inner class 정의할 떄 inner memeber 정의 가능

		i.pr();
	}
}
