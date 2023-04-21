package week08.day33.course.sampleno8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component  
public class MyMessage {  // 얘네가 원하는 것은 모두 String형 객체 (bean 객체중 스트링 객체가 오면 무조건 걔가 세팅도미)
	@Autowired // 멤버변수에 오토와이어드
	@Qualifier("message1")
	String message;
	
	public MyMessage(){
		System.out.println("MyMessage 객체 생성 - no args ");		
	}

	@Autowired
	public MyMessage(String m){
		System.out.println("MyMessage 객체 생성 - "+m);		
	}

	@Autowired
	//@Qualifier("message1")
	public void setMessage(String message) {
		System.out.println("MyMessage 객체의 setMessage() 호출 - "+message);
		this.message = message;
	}

	@Autowired  // 일반 메서드에 지정가능
	//@Qualifier("message1")
	public void ccc(String message) {
		System.out.println("MyMessage 객체의 ccc() 호출 - "+message);
		this.message = message;
	}
	@Autowired
	//@Qualifier("message1")
	public void aaa(String message) {
		System.out.println("MyMessage 객체의 aaa() 호출 - "+message);
		this.message = message;
	}
	@Autowired
	//@Qualifier("message1")
	public void bbb(String message) {
		System.out.println("MyMessage 객체의 bbb() 호출 - "+message);
		this.message = message;
	}
	public String getMessage() {
		return message;
	}	
}
