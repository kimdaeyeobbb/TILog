package day10.course;
import java.util.Random;

class TestException extends Exception {
	// 멤버 - 생성자 하나 가지고 있음
	// 얘는 객체 생성시 메시지 전달을 반드시 해야함 (최소한 null문자열처럼 비어있는 문자열이라도 전달해야 함)
	TestException(String message){
		super(message);
	}
}

public class ExceptionTest3 {
	// 콜스택에 main -> a -> b -> c 순서대로 올라감
	public static void main(String[] args)  {
		System.out.println("main()수행시작");
		a();
		System.out.println("main()수행종료");
	}
	static void a()  {
		System.out.println("a()수행시작");
		try {
			b();
		} catch (TestException e){	
			System.out.println("오류 발생 : "+e.getMessage());
//			System.exit();  // 얘를 삽입하면 프로그램이 강제 종료됨 -> 웹을 다룰 때 얘를 쓰면 좋지 않음.
		}
		System.out.println("a()수행종료");
	}
	static void b() throws TestException {
		System.out.println("b()수행시작");
		c();
		System.out.println("b()수행종료");
	}
	static void c() throws TestException {
		System.out.println("c()수행시작");
		boolean flag = new Random().nextBoolean();
		// 객체 생성하자마자 점 연산자 이용 (객체 생성해서 반드시 변수에 담아야한다는 생각은 안해도 됨)
		// 객체가 가진 멤버를 2번 이상 사용하고 싶은 경우 변수에 담음
		// nextBoolean을 2번이상 호출하고 싶으면 new Random()을 2번이상하는것은 적절하지 않으므로 변수를 생성해서 객체를 담아주자.
		if(flag){
			throw new TestException("<<:::::테스트로 예외발생시킴:::::>>");
			// 여기서 예외 발생시키면 c메서드에서의 수행은 끝!
			// 이 문장은 a메서드의 catch 블록이 내보냄
		} else {
			System.out.println("ㅋㅋㅋㅋ");
		}	
		System.out.println("c()수행종료");
	}	
}