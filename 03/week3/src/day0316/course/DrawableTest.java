package day0316.course;
import java.util.Random;
interface Drawable {
	// 인터페이스는 추상클래스를 상속으로만 사용할 수 있음
	// 객체생성이 안됨.
	 void draw();
	 // 인터페이스 내 body가 없는 메서드 정의 -> 자동으로 public abstract가 붙음 (static인 경우  안 붙음)
	// 인터페이스 내에서 정의되는 메서드는 무조건  자동으로 public이 되므로 오버라이딩시 public을 붙여야 함
}
class Rect implements Drawable { // implement를 뺴더라도 Rect객체가 Drawble위치에 갈 수 없음
	// 상속시 인터페이스가 가지고 있는 추상메서드를 몇개든 무조건 오버라이딩 해야함

	// 인터페이스 내에서 정의되는 메서드는 무조건  자동으로 public이 되므로 오버라이딩시 public을 붙여야 함
	public void draw() {
		System.out.println("사각형을 그립니다.");
	}
}
class Circle implements Drawable {
	public void draw() {
		System.out.println("원을 그립니다.");
	}
}
class Diamond implements Drawable  {
	public void draw() {
		System.out.println("마름모를 그립니다.");
	}
}
public class DrawableTest {
	public static void main(String[] args) {
		Random rand = new Random();
		// Random클래스  -> Math.random보다 사용하기 편함. 객체 생성을 해야함 . 원하는 타입의 난수를 리턴할 수 있음
		// 원하는 탕비의 난수를 꺼낼 수 있도록 메서드 제공

		int num = rand.nextInt(3);
		// nextInt(3) -> 0~2 사이의 난수를 정수로 꺼내줌
		// nextDouble -> 실수형 난수. nextBoolean -> True 또는 False

		Drawable d = null;
		// null로 초기화를 하지 않으면 output(d)에서 에러남.
		// d라는 변수는 어떤 객체가 담겨지게 될 텐데. 문제는 if ~ else if를 사용하고있다.
		// 근데 어느 블록에도 해당이 안되면 d는 r-value가 되어 아무값도 가지지 않을 수 있기 떄문에.
		// d는 객체를 참조하는 변수 (참조형변수) -> 0으로 초기화할 수 없음 -> null으로 초기화 해야함
		// null -> 참조할 객체가 아직은 존재하지 않음을 뜻함

		if(num == 0)
			d = new Rect();
			// d 변수의 타입은 Drawble형. 객체를 담을 변수의 타입과 실제 객체의 타입이 다름
		// 하지만 자손 객체가 Drawble을 상속하므로 ok
		else if(num == 1)
			d = new Circle();		
		else if(num == 2)
			d = new Diamond();		
		output(d);
	}
	public static void output(Drawable d){
		System.out.println("전달된 객체의 클래스명 : "+
	                        d.getClass().getName());
		d.draw();
	}
}



