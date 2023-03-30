package day10.course;

interface InterCalculator {

	int add(int x, int y); //  얘는 미완성이므로 자손이 오버라이딩 해야함

	int sub(int x, int y); //  얘는 미완성이므로 자손이 오버라이딩 해야함

	default int mul(int x, int y) {
		return x * y;
	}
	
	static void print() {		 // 부모것과 자식것이 구분되므로 오버라이딩 하는것이 의미없음
        System.out.println("사칙 연산 처리");
    }
}

class Calculator implements InterCalculator {

	@Override
	public int add(int x, int y) {
		return x + y;
	}

	@Override
	public int sub(int x, int y) {
		return x - y;
	}
	
	/*@Override
    public int mul(int x, int y) {  // 오버라이딩을 해도그만, 안해도 그만임. 주석풀어도 에러나지 않음
        System.out.println(x + "와 " + y + "를 곱합니다.");
        return x * y;
    }*/
	
	public int div(int x, int y) { // 자식에서 추가함
		if (y != 0)
			return x/y;
		return 0;
	}
}

public interface InterfaceTest3 {
	public static void main(String[] args) {
		InterCalculator cal = new Calculator();
		// 인터페이스도 다형성 적용 - 자손 객체를 조상 인터페이스 변수에 담아서 사용할 수 있음
		// 자식 클래스 객체 - new Calculator();의 Calculator();

		System.out.println("5 * 3 = " + cal.mul(5, 3));
		System.out.println("5 + 3 = " + cal.add(5, 3));
		System.out.println("5 - 3 = " + cal.sub(5, 3));
		System.out.println("5 - 3 = " + ((Calculator)cal).div(5, 3));
		InterCalculator.print();		
	}
}
