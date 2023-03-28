package day17.course;

public class ThreadEx08 {
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		// 현재 스레드(메인 스레드)에 대한 객체 추출
		// 자식 스레드를 기동시킨 상태가 아님
		// 자식 스레드 기동은 start를 호출해주어야 기동됨

		System.out.println("[ 프로그램 시작 스레드 이름 ] : " + mainThread.getName());
		// 현재 스레드에 대한 객체의 이름

		System.out.println("-------------------------------");
		ThreadA threadA = new ThreadA();  // 스레드A 객체  생성
		System.out.println("작업 스레드 이름: " + threadA.getName());

		ThreadB threadB = new ThreadB("ThreadB");  // 스레드B 객체 생성
		System.out.println("작업 스레드 이름: " + threadB.getName());

		ThreadC threadC = new ThreadC();   // 스레드C 객체 생성
		System.out.println("작업 스레드 이름: " + threadC.getName());

		threadA.start();
		threadB.start();
		threadC.start();

		for (int i = 0; i < 3; i++)
			System.out.println("프로그램 시작 스레드 이름: " + mainThread.getName());
	}
}

class ThreadA extends Thread {
	public ThreadA() { // 생성자 호출시
		setName("ThreadA");    // 조상의 setName 호출 => 조상의 이름을 ThreadA로 등록 (스레드를 객체 생성할 때 이 스레드는 어떤 이름이 되도록 지정할 수 있음)
		// ThreadA로 스레드 이름이 fix
	}

	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(getName() + "가 출력한 내용");
		}
		System.out.println("-------------------------------");
	}
}

class ThreadB extends Thread {
	public ThreadB(String name) {
		super(name);  	// 조상 생성자를 호출하면서 이름을 등록
		// 스레드 이름이 fix되지X => 객체 생성될때마다 스레드 이름 지정 가능
		// super로 이름을 설정 => 생성자 메서드 내에서만 가능 (setName으로도 이름 설정 가능)
	}

	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(getName() + "가 출력한 내용");
		}
		System.out.println("-------------------------------");
	}
}

class ThreadC extends Thread {
	// 이름 설정하지 않음 => JVM이 자동으로 이름을 부여해줌 => Thread-1과 같은 꼴로 나타남
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(getName() + "가 출력한 내용");
		}
		System.out.println("-------------------------------");
	}
}