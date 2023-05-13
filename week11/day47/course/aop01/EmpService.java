package aop01;

public class EmpService {
	// 직원으로서의 서비스 객체
	// 직원으로서 인증을 받게끔 하기 위함

	public void work() { // 로그인 및 로그아웃 처리가 시작한 시점과 끝나는 지점에 수행되도록 함
		System.out.println("로그인 처리");
		try{
			System.out.println("직원 서비스 진행");
		}catch(Exception e) {
			System.out.println("예외발생!!");
		}
		System.out.println("로그아웃 처리");
	}
}
