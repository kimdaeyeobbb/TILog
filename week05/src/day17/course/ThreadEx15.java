package day17.course;

// 메인 클래스이자 Runnable
// run 메서드가 구현되어있을것임
class ThreadEx15 implements Runnable {
	static boolean autoSave = false;  // 명시적인 초기화 (생략해도 초기값은 false)

	public static void main(String[] args) {
		Thread t = new Thread(new ThreadEx15());  // 스레드 객체 생성
		t.setDaemon(true); // 이 부분이 없으면 종료되지 않는다. => 데몬화지정 (기동시키기전에 지정해주어야 함) => 주석처리하면 무한반복
		// 자식 스레드가 안죽으니까 메인 스레드도 죽지 않음

		t.start();  // 스레드 객체 생성후 start -> run 메서드가 자동호출될것임

		for (int i = 1; i <= 20; i++) {
			try {
				Thread.sleep(2000);  // 2초동안 쉼
			} catch (InterruptedException e) {
			}
			System.out.println(i);  // 2초동안 쉬었다가 1부터 20까지 출력

			/* (2000밀리세크*5 = 10초) 10초가 지나고 나서 autosave */
			if (i == 5)
				autoSave = true;
		}

		System.out.println("프로그램을 종료합니다.");
	}

	// 스레드의 기능은 run() 메서드를 보면 알 수 있다
	public void run() {
		// 스레드가 기동될 떄 자동으로 run()메서드가 기동될 것임
		while (true) {
			try {
				Thread.sleep(3 * 1000); // 3초마다
			} catch (InterruptedException e) {
			}

			// (3초마다) autoSave의 값이 true이면 autoSave()를 호출한다. (3초마다 저장)
			if (autoSave) {
				autoSave();
			}
		}
	}

	public void autoSave() {
		System.out.println("작업파일이 자동저장되었습니다.");
	}
}
