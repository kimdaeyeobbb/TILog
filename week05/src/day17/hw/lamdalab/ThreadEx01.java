package day17.hw.lamdalab;

class ThreadEx01 {
	public static void main(String args[]) {
		Thread t1 = new Thread(() -> {
			for (int i=0; i<5; i++){
				System.out.println(Thread.currentThread().getName());
			}
		});

		Runnable r = () -> {
			for (int i=0; i<5; i++){
				System.out.println(Thread.currentThread().getName());
			}
		};

		Thread t2 = new Thread(r);

		t1.start();
		t2.start();
	}
}