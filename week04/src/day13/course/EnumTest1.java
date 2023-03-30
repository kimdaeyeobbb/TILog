package day13.course;

enum Season {
	// enum 타입 내에 4개의 상수가 정의되어 있음. 이 4개의 값만 가질 수 있고 다른 값은 가질 수 없게됨
	// 콤마(,)로 구분해서 정의 되었음 (행단위로 구분해도 됨)
	// 메서드를 추가할 경우 끝에 세미콜론(;)을 줘야함 (상수만 정의할 경우에는 생략해도 됨)
	// Season 유형의 변수 선언시 (SPRING ~ WINTER) Season 타입으로 만들어짐
	// 계절들은 static형이므로 enum 타입의 클래스(Season)로 접근할 수 있음.
	SPRING, SUMMER, FALL, WINTER
}

public class EnumTest1 {
	public static void main(String args[]) {
		System.out.println(Season.SPRING);
		System.out.println(Season.SUMMER);
		System.out.println(Season.FALL);
		System.out.println(Season.WINTER);
		Season data1 = Season.FALL;  // data1 => Season이라는 enum이 가지고 있는 상속값 중 하나만 가질 수 있음.
		/* if문 - enum이 가진 데이터 확인시 사용 */
		if (data1 == Season.FALL)
			System.out.println("당신이 좋아하는 계절은 가을!!");

		/* switch문 - enum이 가진 데이터 확인 할 때 사용 */
		switch (data1) {
		case SPRING:
			System.out.println("대저토마토");
			break;
		case SUMMER:
			System.out.println("복숭아");
			break;
		case FALL:
			System.out.println("홍로");
			break;
		case WINTER:
			System.out.println("레드향");
			break;
		}

		for (Season v : Season.values())
			// Enum은 values라는 메서드가 자동으로 만들어짐
			// 상수들의 리스트를 보여줌. 여기서는 Season 타입의 배열임.
			// Season 타입의 객체를 담아서 출력하고 있음.
			System.out.print(v + " ");
		// Enum의 toString이 호출되어서 현재의 Enum의 값이 출력됨. (SUMMER라는 이름이 상수명이자 값이 됨)
		// 출력시 한 행에 출력됨.
		System.out.println();
		
		Season data2 = Season.valueOf("SUMMER");
		// valueOf도 자동으로 만들어짐.
		// SUMMER 값에 알맞은 Enum 상수객체를 리턴
		// 이떄는 SUMMER라는 Season 객체가 리턴됨

		System.out.println(data2);
	}
}
