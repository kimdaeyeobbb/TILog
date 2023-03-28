package day17.course;

public class ThreadEx14 {
	public static void main(String[] args) {
		Thread thread = new PrintThread2();
		thread.start();

		// 1초동안은 interrupt가 걸린 상태가 아니므로 열심히 작업 수행
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

		thread.interrupt();
		// 자식스레드의 interrupt 호출 => 자식 스레드의 동작을 중단시킴
	}
}

class PrintThread2 extends Thread {
	public void run() {
		while (true) {
			System.out.println("실행 중");

			/* static 메서드에 대한 처리 */
			if (Thread.interrupted()) { // interrupt 걸린상태인지 체크
				// 해야할 자원정리가 남아있다면 이 부분에서 자원 정리를 수행하고
				// 아래에서 빠져나감
				break;
			}
		}
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
}
