package day7.course;
public class KoreanDayTest {
	public static void main(String[] args) {
		System.out.print("오늘은 ");
		System.out.print(KoreanDay.day);
		// 이때 KoreanDay 수행
		// 항상 클래스는 필요한 시점에서 로딩됨. 이미 로딩되어 있다면 재활용함.
		// 03.14 기준 화요일

		System.out.println("입니다.");
	}
}
