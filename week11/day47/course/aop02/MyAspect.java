package aop02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor{
	// 메서드인터셉터를 구현함
	// 공통 로직을 지원하는 advice가 되려면 상속해서 오버라이딩해서 구현해야 함


	@Override
	public Object invoke(MethodInvocation invo) {  // 메서드 오버라이딩
		// 메서드 인보케이션 객체 안에 실제 수행하고자하는 서비스 객체의 메서드를 호출하는 기능을 가지고 있음


		//대상 메서드 실행 전
		System.out.println("로그인 처리--");
		try {
			//대상 메서드 실행
			invo.proceed();    // filter처리
		}catch(Throwable e) {
			System.out.println("예외발생!!!");
		}
		//대상 메서스 실행 후
		System.out.println("로그아웃 처리--");
		return null;
	}
}
