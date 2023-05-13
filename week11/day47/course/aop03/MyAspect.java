package aop03;

import org.aspectj.lang.JoinPoint;

// Pojo -> 순수한 자바 객체. plain old java object
public class MyAspect{
	public void login(JoinPoint joinPoint) {  // 조인포인트 -> 스프링상 메서드 호출 시점 -> 포인트컷으로 선정된 조인포인트에 대한 정보가 들어옴
		System.out.println("로그인 처리**");
	}

	public void logout(JoinPoint joinPoint) {
		System.out.println("로그아웃**");
	}
}
