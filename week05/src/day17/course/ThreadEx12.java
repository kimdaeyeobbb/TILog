package day17.course;

class NewThread2 extends Thread {
	NewThread2() {
		System.out.println("Child thread: " + this);
	}

	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Child Thread: " + i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("**** Child interrupted.****");
		}
		System.out.println("Exiting child thread.");
	}
}

class ThreadEx12 {
	public static void main(String args[]) {
		NewThread2 nt = new NewThread2();
		nt.start();
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Main Thread: " + i);
				if (i == 3)
					nt.interrupt();
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}
		System.out.println("Main thread exiting.");
	}
}