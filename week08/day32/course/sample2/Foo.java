package week08.day32.course.sample2;

public class Foo {
	// 생성자 오버로딩 -> 5개
	public Foo() {
		System.out.println("Foo 객체 생성-no arsg");
		System.out.println("-----------------------");
	}
	public Foo(String str) {
		System.out.println("Foo 객체 생성-" + str);
		System.out.println("-----------------------");
	}
	public Foo(String str, int n) {
		System.out.println("Foo 객체 생성-" + str + "  " + n);
		System.out.println("-----------------------");
	}
	public Foo(String str, int n, boolean b) {
		System.out.println("Foo 객체 생성-" + str + "  " + n + "   " + b);
		System.out.println("-----------------------");
	}
	public Foo(Bar bar) {
		System.out.println("Foo 객체 생성-" + bar);
		System.out.println("----------------------- ");
	}
}








