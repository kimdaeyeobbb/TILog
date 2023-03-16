package day0316.course;

interface Printable {
	// 인터페이스상의 상수 -> 자동으로 public static final이 붙음
	// 하지만 명시적 초기화는 반드시 해야함
	public static final int PRINT_TYPE1 = 1;
	static final int PRINT_TYPE2 = 2;
	final int PRINT_TYPE3 = 3;
	int PRINT_TYPE4 = 4;
//	int PRINT_TYPE4;
	// 명시적 초기화를 하지않은 상태에서 변수선언시 error

	/* 메서드 멤버 -> 추상메서드로 정의하고 있음 */
	// 인터페이스상 추상메서드 -> abstract 키워드로 판단 x -> body가 아닌 세미콜론(;)으로 마무리 하는 경우를 추상메서드로 판단
	// 반드시 오버라이딩해야하는 메서드가 3개가 됨
	public abstract void print(int type);
	abstract void setPage(int su);
	boolean isAvailable();
}

abstract class Shape3 {
	String color;

	abstract void draw();

	/* 일반 메서드 */
	void setColor(String color) {
		this.color = color;
	}
}

// Circle3 -> 다양한 타입으로 쓸 수 있음 (Object형 요구하는 자리, Shape3형 요구하는 자리, Printable요구하는 자리 모두에 갈 수 있음)
class Circle3 extends Shape3 implements Printable {
	int page;

	// 미완성 메서드를 오버라이딩하고 있음
	void draw() {
		System.out.println(color + " 원을 그리는 기능");
	}

	/* 인터페이스 상속을 통해 오버라이딩 하고 있는 메서드이므로 public을 반드시 붙여야함 */
	public void print(int type) {
		System.out.println(type + "번 방식으로 " + page + "페이지를 프린팅한다.");
	}

	public void setPage(int page) {
		this.page = page;
	}

	public boolean isAvailable() {
		if (color.equals("흰색"))
			return false;
		else
			return true;
	}
}

class Rectangle3 extends Shape3 {
	// 일반 메서드는 앞에 public을 붙이지 않아도 에러 발생x
	void draw() {
		System.out.println(color + " 사각형을 그리는 기능");
	}
}

class Triangle3 extends Shape3 {
	void draw() {
		System.out.println(color + " 삼각형을 그리는 기능");
	}
}

public class InterfaceTest1 {
	public static void main(String args[]) {
		printOut(new Circle3());
//		printOut(new Rectangle3()); // 컴파일 오류가 발생하는 행 -> 얘는 Printable으로써 역할을 하지 못함 (Pritable을 상속하고 있는 객체가 아니라는 뜻)
	}

	// 매개변수 타입이 Printable 타입 -> 전달되는 객체가 반드시 Printable을 구현하고 있는 객체만 올 수 있다는 뜻 (Printable을 상속하고 있는 객체여야 함)
	// 인터페이스가 가지는 메서드를 오버라이딩
	static void printOut(Printable prt) {
		// Printable 객체는 Printable이 구현하고 있는 자손의 객체를 받아서 메서드 구현.
		//  어떤 변수가 어떤 클래스 유형이다. 어떤 인터페이스 유형이다. 하면 접근할 수 있는 멤버으 ㅣ사양을 결정
		// 이 변수가 참조할 수있는 객체의 타입이 정해짐
		// Printable이 가지고 있는 isAvailable등을 사용할 수 있음
		// setColor는 Printable이 가지고 있지 않음

		prt.setPage(100);
		// prt가 어떤 유형의 변수냐에 따라서 접근할 수 있는 멤버의 사양이 다름
		// 여기서는 Object, Printable인터페이스에 정의된 애들만 등장할 수 있음. prt로는 setColor에 접근 불가
		// draw메서드는 Circle3가 추가하고 있는 메서드이므로 Printable에 없는 객체이므로 그냥 호출할 수 없음
		// setColor는 Printable에 없기 떄문에 그냥 호출할 수 없음.
		// prt가 참조하는 객체는 Printable의 멤버를 가지고 있음. 하지만 prt로는 setColor, draw등을 그냥 호출할 수 없음
		// 이 경우 해당 자손형으로 강제 형변환을 하자.

		((Circle3)prt).draw(); // 점연선자가 우선순위가 높으므로 괄호를 하나 더 감싸줘야 강제형변환이 적용됨
		((Shape3) prt).setColor("파란색");
		// 해당 자손형에서 강제 형변환을 통해 prt가 접근할 수 없는 멤버였던 것을 접근할 수 있게 만듦
		// Circle3는 Shape3를 상속하고 있음. draw나 setColor는 Shape3에서 상속받으므로 Shape3로 형변환해서 접근해도 됨
		// Shape3로부터 물려받은 클래스의 메서드 사양이기 때문이다.
		// 결론: 해당 자식 클래스의 형태로 변환하자

		// 일일이 형변환하기 귀찮을 경우에는 자손 유형의 변수(Circle3)형으로 변수를 하나 만들자
		// 자식 = 부모 꼴인경우 해당 자식 형태로 강제 형변환을 해야함
		Circle3 cobj = (Circle3) prt;
		cobj.draw();
		cobj.setColor("노란색");
		// 이후 prt가 받는 객체에 ~
		// 자손유형으로 일일이 형변환해서 접근하기 보다는 변수에 담아서 접근해도 됨


		if (prt.isAvailable())
			prt.print(Printable.PRINT_TYPE2);
	}
}
