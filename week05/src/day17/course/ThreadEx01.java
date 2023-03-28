package day17.course;

class ThreadEx01 {
	public static void main(String args[]) {
		ThreadEx1_1 t1 = new ThreadEx1_1();

		Runnable r = new ThreadEx1_2();
		// 객체 생성 -> 이후 바로 start 불가 -> Thread나 Object이 start를 가지고 있는게 아니기 때문 -> start는 java.lang.Threadd가 가짐
		// 따라서 아래와 같이 Thread의 객체를 생성

		Thread t2 = new Thread(r); // 생성자 Thread(Runnable target)

		t1.start();
		t2.start();
	}
}

/* 스레드 클래스 상속 */
class ThreadEx1_1 extends Thread {
	public void run() {
		// 5번 getName을 호출해서 수행 (스레드 이름 추출) => 조상인 java.lang.Thread가 가지고 있음
		// 자식에서 조상의 메서드를 호출할 수 있음
		for (int i = 0; i < 5; i++) {
			System.out.println(getName()); // 조상인 Thread의 getName()을 호출
		}
	}
}

/* Runnable 인터페이스 구현 */
class ThreadEx1_2 implements Runnable {
	// run() 메서드 오버라이딩
	// java.lang.Thread가 부모가 아니고 Object이 부모임.
	// 따라서 getName 호출시 Thread.currentThread().getName() 이용
	public void run() {
		for (int i = 0; i < 5; i++) {
			// Thread.currentThread() - 현재 실행중인 Thread를 반환한다.
			System.out.println(Thread.currentThread().getName());
		}
	}
}
