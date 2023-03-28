package day17.course;

public class ThreadEx13 {
	public static void main(String[] args) {
		PrintThread1 printThread = new PrintThread1();
		printThread.start();
		// run 메서드가 자동호출

		try {
			Thread.sleep(1000);
		// 메인스레드가 1초동안 대기 상태에 있게 만듦

		} catch (InterruptedException e) {
		}

		printThread.setStop(true);
		// 자식 스레드의 setStop 호출
		// stop 변수는 default로 false(멤버변수이므로 default는 false)
	}
}

class PrintThread1 extends Thread {
	private boolean stop;
		// stop 변수는 default로 false(멤버변수이므로 default는 false)

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public void run() {
		// stop이 false인동안 수행
		// stop 변수가 true가 되면 수행되지 않음
		while (!stop) {
			System.out.println("실행 중");
		}
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
}