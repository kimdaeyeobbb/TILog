package week08.day33.course.sampleno4;

import org.springframework.stereotype.Component;

@Component("samsung")  // 객체 생성은 IoC 컨테이너가 대신하게 해줌
public class SamsungTv implements Tv{

	@Override
	public void powerOn() {
		System.out.println("SAMSUNG TV - Power On");
	}

	@Override
	public void powerOff() {
		System.out.println("SAMSUNG TV - Power Off");
	}

	@Override
	public void volumeUp() {
		System.out.println("SAMSUNG TV - Volume Up");
	}

	@Override
	public void volumeDown() {
		System.out.println("SAMSUNG TV - Volume Down");
	}

}
