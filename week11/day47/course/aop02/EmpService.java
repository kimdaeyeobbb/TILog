package aop02;

public class EmpService implements Person{
	@Override
	public void work() { // 인터페이스가 제공하는 메서드를 emp서비스에 맞게 오버라이딩
		System.out.println("직원 서비스 진행");
	}
}
