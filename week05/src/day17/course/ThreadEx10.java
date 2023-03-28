package day17.course;

public class ThreadEx10 {
	public static void main(String[] args) {
		StatePrintThread statePrintThread = new StatePrintThread(new TargetThread());
		statePrintThread.start();
		// start - 스레드를 기동시키는 메서드
		//  스레드를 종료시키는 메서드 - 없음. 스레드 스스로 종료될 수 있게 구현해야 함 (stop은 사라짐)
		// 사용하던 자원을 반납하는 등의 작업을 수행한 후에 종료할 수 있게 구현해야 함
	}
}

class StatePrintThread extends Thread {
	private Thread targetThread;

	public StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	}


	public void run() {
		// run()메서드 - 무한루프돌면서
		// NEW 상태인지 TERMINATED 상태인지 ...
		while (true) {
			Thread.State state = targetThread.getState();
			System.out.println("타겟 스레드 상태: " + state);
			if (state == Thread.State.NEW) {
				targetThread.start();
			}
			if (state == Thread.State.TERMINATED) {
				break;
			}
			try {
				// 0.5초간 일시 정지
				Thread.sleep(50);
			} catch (Exception e) {
			}
		}
	}
}

class TargetThread extends Thread {
	public void run() {
		for (long i = 0; i < 1000000000; i++) {
		}

		try {
			// 1.5초간 일시 정지
			Thread.sleep(1500);
		} catch (Exception e) {
		}

		for (long i = 0; i < 1000000000; i++) {
		}
	}
}