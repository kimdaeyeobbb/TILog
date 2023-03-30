package day7.course;
class Parent {
	int x = 1, y = 2;

//	@Override  // 이것 붙이면 메서드명을 잘못적어도 에러메시지를 명시해줌
	public String toString(int n) {  // 오버라이딩이 아님 (매개변수가 다르므로 -> 오버로딩이 된 것)
		return "Parent 클래스의 객체 입니당";
	}
}
class Child extends Parent {
	int x = 10;
	void printInfo() {
		int x = 100;
		System.out.println(x);				//	100. 지역변수 100이 있으므로 (그냥 x는 가까운것이 우선. 지역변수 100 출력) (가까운것이 없으면 조상으로 거슬러 올라감)
		System.out.println(this.x);		//  this -> 이 클래스의 멤버변수인 10 출력
		System.out.println(super.x);		//	1. (super를 붙였으므로 조상의 값 출력)
		System.out.println(y);				//  2. 같은 메서드 안에 y라는 지역변수가 없음. 멤버변수 영역까지 찾아감. -> 부모에게 찾아감 -> y가 있으므로 2를 출력 -> parent에도 없으면 Object까지 올라감
		System.out.println(this.y);		//	2. 멤버변수가 없음 -> 부모에게 찾아감 -> y가 있으므로 2를 출력
		System.out.println(super.y);		// 2.  super가 있으므로 조상부터 바로 찾아감.
		//System.out.println(z);  // 지역변수에도, 멤버변수에도, 부모에도 없으므로 주석풀면 error. 소괄호를 붙여서 z()라 하면 메서드로 인식. 소괄호 안붙이면 변수로 인식.
	}
	// tostring 처럼 s를 소문자로 잘못썼을 경우, 오버로딩도 오버라이딩도 아닌 추가메서드로 인식.
	public String toString() {  // Object 클래스에 있는 toString을 오버라이딩 함 (이름, 매개변수 동일.) (접근제어자는 같거나 좁아져야 함)
		return "Child 클래스의 객체 입니당";
	}
}

public class ParentChildTest {
	public static void main(String[] args) {
		Parent p = new Parent();  // Parent 객체 생성
		System.out.println(p.toString());   // toString 호출. Object에 있는애가 대신 호출될 것임
		System.out.println(p);
		System.out.println("출력 1-" + p);

		Card c = new Card();  // Card 객체 생성
		System.out.println(c.toString());  // toString 생략해도 자동으로 toString의 결과가 등장.
		System.out.println("출력 2-" + c);

		java.util.Date d = new java.util.Date();  // Date클래스는 toString을 오버라이딩 해뒀다
		System.out.println(d.toString());
		System.out.println("출력 3-" + d);

		Child ch = new Child();  // Child 클래스의 객체 생성
		System.out.println("출력 4-" + ch);  // 자동으로 toString이 호출되어 결과가 처리됨
		ch.printInfo();   // child 객체를 생성해서 printInfo 호출
		System.out.println(ch.x);
		System.out.println(ch.y);  // 점(.) 연산자로 접근할 수 있는 것은 멤버변수 -> child에 없으면 -> 부모에게 거슬러 올라감
	}
}