package aop07;

import org.springframework.stereotype.Component;

@Component(value = "customer")  // 원하는 이름으로 설정하기 위해 @component 내부의 괄호로 원하는 이름을 지정
public class CustomerService implements Person{
	@Override
	public void work() {
		System.out.println("고객 서비스 진행");
	}
}
