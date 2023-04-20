package week08.day32.course.sample1;

// 인터페이스를 구현하고 있는 클래스
// 스프링에서 빈이되는 클래스는 반드시 인터페이스를 구현해야하는 것은 아님
// 하지만 인터페이스를 구현하면 확장성이 넓어짐
public interface MessageBean {
	public void sayHello();
	public void sayHello(String a, int b);
}
