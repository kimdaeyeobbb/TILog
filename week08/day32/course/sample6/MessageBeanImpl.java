package week08.day32.course.sample6;

import java.io.IOException;

public class MessageBeanImpl implements MessageBean{
	/* 멤버변수 */
	private String name;
	private String phone;
	private Outputter outputter;
	
	//생성자로 name을 받음
	public MessageBeanImpl(String name) {
		super();
		this.name = name;  // 생성자를 통해 설정받고 있음
		System.out.println("1. IoC 컨테이너에 의해서 MessageBeanImpl 객체 생성");
	}
	
	//setter을 통해서 phone와 outputter입력받음
	public void setPhone(String phone) {
		this.phone = phone;   // setter 메서드를 통해 설정받고 있음
		System.out.println("5. IoC 컨테이너에 의해서 MessageBeanImpl 객체의 setPhone() 호출");
	}
	
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
		System.out.println("4. IoC 컨테이너에 의해서 MessageBeanImpl 객체의 setOutputter() 호출");
	}

	@Override
	public void helloCall() {
		String message=name+" : " +phone;
		System.out.println("6. helloCall() : "+message);
		
		try {
			outputter.output(message);
			System.out.println("8. 처리 종료");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}