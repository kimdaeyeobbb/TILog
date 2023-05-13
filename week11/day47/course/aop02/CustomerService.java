package aop02;

public class CustomerService implements Person{
	// person인터페이스를 구현
	@Override
	public void work() {  // 인터페이스가 제공하는 메서드를 커스터머서비스에 맞게 오버라이딩
		System.out.println("고객 서비스 진행");
	}
}
