package week08.day33.course.sampleno4;

import org.springframework.stereotype.Component;

@Component("lg")  // 객체 생성은 IoC 컨테이너가 대신하게 해줌
public class LgTv implements Tv{

	@Override
	public void powerOn() {
		System.out.println("LG TV - Power On");
	}

	@Override
	public void powerOff() {
		System.out.println("LG TV - Power Off");
	}

	@Override
	public void volumeUp() {
		System.out.println("LG TV - Volume Up");
	}

	@Override
	public void volumeDown() {
		System.out.println("LG TV - Volume Down");
	}

}
