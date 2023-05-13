package aop05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect{
	@Before("execution(public void aop05.*.*())")
	public void login(JoinPoint joinPoint) {
		// advice가 수행되게하는 조건을 만족하는 포인트컷에 대한 정보를 받을 수 있게끔 매개변수 타입이 joinpoint형으로 되어있음

		// advice가 수행되게 하는 joinpoint정보를 알아낼 수 있음
		System.out.println("AOP 가 적용된 조인포인트에 대한 정보를 추출해 보장~~");
		System.out.println(joinPoint);
		System.out.println(joinPoint.getSignature());  // getsignature -> 많이 사용함
		System.out.println(joinPoint.getTarget());   // 프록시 객체에 대한 정보 & 객체에 대한 참조값이 나올것임
		System.out.println(joinPoint.getTarget().getClass().getName());
		System.out.println(joinPoint.toLongString());  // longstring -> 긴 정보
		System.out.println(joinPoint.toShortString());
		System.out.println(joinPoint.getThis());  // gethis -> 프록시 객체에 대한 정보를 보여줌
		System.out.println("프록시 정보: "+joinPoint.getTarget().getClass().getName());
		System.out.println("-------------------------------------------");
		System.out.println("로그인 처리");
	}
	
	@After("execution(public void aop05.*.*())")
	public void logout(JoinPoint joinPoint) {
		System.out.println("로그아웃");
	}
}







