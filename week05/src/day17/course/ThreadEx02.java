package day17.course;

// 메인 스레드외에 1개의 스레드를 기동시킴
class ThreadEx02 {
	public static void main(String args[]) throws Exception {
		ThreadEx2_1 t1 = new ThreadEx2_1();  // 스레드 클래스에 대한 객체 생성
		t1.start(); // 스레드 클래스에 대한 객체 생성 후 start

		// START 메서드는 내부적으로 하나의 스레드를 기동시키기 위한 베이스 작업을 함
		// 스레드마다 메서드 호출이 개별적으로 일어남
		// 자바 프로그램이 3개의 스레드로 동작하면 스레드마다 콜스택이 개별적으로 만들어지므로 콜스택이 3개가 됨
		// 새로운 스레드만의 콜스택이 생성되며 제일 먼저 호출되는 메서드는 run() -> run이 throws exception 호출
	}
}

class ThreadEx2_1 extends Thread {
	public void run() {
		throwException();
	}
	// run()메서드도 호출하고 싶은 API가 있다면 얼마든지 호출할 수 있다



	public void throwException() {
		// 호출하자마자 예외 발생 -> 콜스택 정보를 보기 위함 (콜스택 정보: 예외가 발생해야만 볼 수 있는 데이터.)
		// 우리가 구현한 자바 프로그램의 성능이 어떤지, 어떻게 수행되는지를 보기 위한 툴을 사용하지 않는 한에는 프로그램의 흐름을 눈으로 보기 위한 방법은 콜스택을 내보내는 방법이다
		// 콜스택은 아무때나 출력할 수 없고 예외객체가 만들어져야만 출력할 수 있다
		try {
			throw new Exception();
		} catch (Exception e) { // 예외를 발생시킴과 동시에 잡아버림
			e.printStackTrace();
			// 원래는 프로그램이 제일 먼저 호출되면 main이 먼저 호출
			// 하지만 여기서는 메인 스레드의 콜스택이 아닌 새로이 기동된 자식 스레드의 콜스택임.
			// 스레드가 기동될 떄마다 새로이 생성된 스레드만의 콜스택이 새로이 기동됨.
			// 메인에 대한 정보가 없는 이유는 메인스레드에 대한 정보는 메인 콜스택에 보관되어있음
			// 여기서는 자식스레드에 대한 콜스택을 호출함 
		}
	}
}
