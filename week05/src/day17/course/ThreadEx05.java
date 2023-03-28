package day17.course;

class ThreadEx05 {
	static long startTime = 0;

	public static void main(String args[]) throws InterruptedException {
		startTime = System.currentTimeMillis();
		ThreadEx5_1 th1 = new ThreadEx5_1();
		th1.start();
		for (int i = 0; i < 20; i++) {
			System.out.print("-");
			Thread.sleep(1000);
		}

		System.out.print("소요시간:" + (System.currentTimeMillis() - ThreadEx05.startTime));
	}
}

class ThreadEx5_1 extends Thread {
	public void run() {
		for (int i = 0; i < 20; i++) {
			// 메서드 오버라이딩시 조상에 정으되어있는 메서드의 THROWS절의 제한을 받음
			// 조상이 throws절을 가지고 있지 않으므로 자식에서도 throws절을 구현할 수 없음
			// 따라서 Thread.sleep에 대한 예외처리를 위해 try-catch 구문 사용
			try {
				System.out.print("|");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
