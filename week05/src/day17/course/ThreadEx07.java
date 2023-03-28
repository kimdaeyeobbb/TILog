package day17.course;

import javax.swing.JOptionPane;

class ThreadEx07 {
	public static void main(String[] args) throws Exception {
		/* 추가 자식 스레드 기동시킴 */
		ThreadEx7_1 th1 = new ThreadEx7_1();
		th1.start();

		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요. 입력할 때까지 놀고있지는 않을께요..(^^)");
		System.out.println("입력하신 값은 " + input + "입니다.");
	}
}

// 자식스레드에서 10부터 1까지 출력
class ThreadEx7_1 extends Thread {
	public void run() {
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}
