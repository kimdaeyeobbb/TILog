package aop01;

public class CustomerService {
	// 고객과 관련된 처리 기능이 핵심 로직이 됨
	public void work() {
		System.out.println("로그인 처리");
		try{
			System.out.println("고객 서비스 진행");
		}catch(Exception e) {
			System.out.println("예외발생!!");
		}
		System.out.println("로그아웃 처리");
	}
}
