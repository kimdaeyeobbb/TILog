package day0315.course;


abstract class Pet {
	public abstract void petSound();  // 추상메서드는 반드시 오버라이딩 해야 함 (접근 제어자가 public. 상속받은 얘들도 접근 제어자가 public이어야함. 접근 권한을 축소시키면 안됨)

	public void sleep() {
		System.out.println("Zzz");
	}  // 일반 메서드는 오버라이딩이 선택사항임
}
class Dog extends Pet{
	public void petSound() {
		System.out.println("멍멍!!");
	}   // petSound 오버라이딩
}
class Cat extends Pet{
	public void petSound() {
		System.out.println("야옹~~");
	}  // petSound 오버라이딩
}
public class PetTest {
	public static void main(String[] args) {
		actionPet(new Dog());
		actionPet(new Cat());
	}
	static void actionPet(Pet obj) {  // 매개변수 Pet형. Pet을 상속하고 있는 애라면 누구든 전달될 수 있다는 것. Pet은 멤버가 2개
		obj.petSound();   // Pet의 petSound는 미완성. 하지만 전달되는 애들은 오버라이딩 되어야 함 (그래야 객체 생성이 가능). 이자리에는 Pet이 전달하는 petSound를 제대로 구현하는 애들만 올 수 있음 (제대로 오버라이딩 했음을 약속)
		obj.sleep();
	}
}
