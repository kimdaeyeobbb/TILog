package day16.course;

public class GenericMethodTest2 {
	//제네릭 메소드
	public static <T extends Number> T whichBig(T t1, T t2) {
		// 넘버 객체나 그의 자손 객체를 받아서 하나를 리턴
		if (t1.doubleValue() > t2.doubleValue())
			return t1;
		else 
			return t2;
	}	
	public static <T extends Number> boolean equalValue(T t1, T t2) {
		// 넘버를 확장한 타입 한정 제네릭 메서드 (처리할 수 있는 타입을 한정함. 리턴값은 불리언.)
		// 두 매개변수 모두 Number의 자손
		// Java5 버전부터 100, 200등이 Integer 객체로 전달됨. -> 자동으로 객체로 바뀜.
		// 컴파일시 기본형 데이터의 값이 어떠냐에 따라서 그에 매핑되는 래퍼 클래스의 객체도 바뀜
		if (t1.doubleValue() == t2.doubleValue())
			return true;
		else 
			return false;
	}	
	public static void main(String[] args) {		
		System.out.println(whichBig(100, 200));
		System.out.println(whichBig(100, 20));
		System.out.println(whichBig(100.0, 20.0));
		//System.out.println(whichBig("100", "20")); // error -> Number를 확장한 타입만 올 수 있도록 제한했는데 String을 전달했으므로.
		System.out.println(equalValue(100, 100));
		System.out.println(equalValue(200, 100));
	}
}