package week08.day33.course.sampleno3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("carTire") // 기본값 : car (컴포넌트 애노테이션) -> 이름 지정했으므로 carTire로 이름이 바뀜 (ㅈ지정하지 않았다면 car가 됨)
public class Car {  // 타이어를 포함함. 따라서 포함되는 Tire를 먼저 분석.
	@Autowired(required = false) // default = true (멤버변수에 오토와이어드 정의)
	private Tire tire; // 멤버변수에 오토와이어드 정의 되어 있음 => 얘 떄문에 Tire 변수에도 베스트드라이브가 주입된 상태로 객체가 생성됨

	public Car() {
		System.out.println("Car 객체 생성 - no args");
	}

	@Autowired(required = false)   // required=false => 객체가 없더라도 에러가 나지 않고 null로 처리함
	// 오토와이어드가 여기있으므로 위의 생성자가 아닌 아래 생성자가 전달되어 객체 생성
	public Car(Tire tire) {
		System.out.println("Car 객체 생성 - "+tire);
	}

	public void drive() {
		if (tire != null)
			System.out.println("Nice made of "+tire.getBrand()+"s car.");
		else
			System.out.println("tire --> "+tire);
	}
}
