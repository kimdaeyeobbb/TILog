package week08.day33.course.sampleno3;

import org.springframework.stereotype.Component;

@Component // name = vestTire (객체 생성) -> bean 태그를 간단하게 작성한것과 동일. 이름 지정하지 않았으므로 VestTire에서 맨 첫글자를 소문자로 바꾼것으로 객체 생성
public class VestTire implements Tire{  // 타이어를 구현한 VestTire. 얘가 하나의 컴포넌트로 등록이 됨

	// 객체 생성시 호출되는 생성자
	public VestTire() {
		System.out.println("VestTire - Create object");
	}

	@Override
	public String getBrand() {
		return "MICHELIN Tire!!";
	}
}
