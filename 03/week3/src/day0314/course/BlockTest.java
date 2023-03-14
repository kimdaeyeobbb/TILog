package day0314.course;
public class BlockTest {
	/* static 블럭 */
	// 클래스가 로딩되는 시점에 수행됨. 메인 메서드보다 먼저 수행 (메인 메서드는 클래스가 끝나고 나서 메인이 호출되어야 실행)
	static {
		System.out.println("static 블럭 수행");
	}

	/* 인스턴스 블록 */
	{
		System.out.println("instance 블럭 수행");
	}

	/* 생성자 */
	public BlockTest() {     
		System.out.println("생성자 수행");
	}
	public static void main(String args[]) {
		System.out.println("BlockTest bt = new BlockTest(); ");  // 메인메서드는 static 초기화 블럭보다 늦게 수행됨
		BlockTest bt = new BlockTest();
		System.out.println(bt);
		System.out.println("BlockTest bt2 = new BlockTest(); ");
		BlockTest bt2 = new BlockTest();
		System.out.println(bt2);
	}
}
