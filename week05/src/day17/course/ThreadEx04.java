package day17.course;

class ThreadEx04 {
	public static void main(String args[]) throws InterruptedException {
		long startTime = System.currentTimeMillis(); // 초시간을 꺼내주는 메서드

		for (int i = 0; i < 20; i++) {  // 1초에 한번씩 (-)기호를 꺼내줌
			System.out.printf("%s", new String("-"));
			Thread.sleep(1000);
			// 출력후 1초 쉼
			// Thrad.sleep은 예외처리가 필요 -> 메인메서드의 throws로 예외처리
		}
		// System.out.println("소요시간1:" +(System.currentTimeMillis()- startTime));

		for (int i = 0; i < 20; i++) {
			System.out.printf("%s", new String("|"));
			// 파이프기호(|) => UNIX나 LINUX에서 앞의 명령 수행결과를 다음 명령으로 넘김

			Thread.sleep(1000); // 출력 후 1초 쉼
		}

		System.out.print("소요시간2:" + (System.currentTimeMillis() - startTime));
	}
}