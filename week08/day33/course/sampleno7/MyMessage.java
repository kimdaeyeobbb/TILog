package week08.day33.course.sampleno7;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")   // 싱글톤이 아닌. 요청시마다 객체 생성
public class MyMessage {
	String message;
	
	public MyMessage(){
		System.out.println("Create object");
		message="Good day!!";
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}	
}
