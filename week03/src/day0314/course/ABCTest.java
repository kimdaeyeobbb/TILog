package day0314.course;

class A{
	A() {
		System.out.println("A클래스의 객체 생성!");
	}
}
class B extends A{
	B(int num) {  // int num 에러 유발
		System.out.println("B클래스의 객체 생성!");
	}
}
class C extends B{
	C() {  // 에러
		super(10);  // 에러 해결
		System.out.println("C클래스의 객체 생성!");
	}
}

public class ABCTest {
	public static void main(String[] args) {
//		C c = new C();
		new C();   // 이렇게 해도 됨 (C클래스의 객체가 생성되는 동안 무슨일이 일어나는지 보자.)
		// 특정 틀래스의 객체가 생성되는 동안 -> 생성자 메서드를 호출 -> 모든 생성자는 기본적으로 호출되자마자 조상 생성자를 호출하는 기능을 내제하고 있음
	}
}