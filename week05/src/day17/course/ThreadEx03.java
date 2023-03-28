package day17.course;

class ThreadEx03 {
	public static void main(String args[]) throws Exception {
		ThreadEx3_1 t1 = new ThreadEx3_1();
		t1.run();
		// 자식 스레드에서는 제일 먼저 호출되는 스레드가 run
		// 메인 스레드에서 제일 먼저 호출되는 스레드는 main
		// 여기서는 start를 안했으므로 자식 스레드를 기동시키지 않음. 자식 스레드를 호출하는 것은 start()
	}
}

class ThreadEx3_1 extends Thread {
	public void run() {
		throwException();
	}
	// 자식스레드를 띄운것이 아니라 run()을 일반 메서드처럼 호출시킴
	// 메인 메서드 상에서 run을 호출시킴

	public void throwException() {
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
