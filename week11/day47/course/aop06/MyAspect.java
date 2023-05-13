package aop06;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect{

	// @pointcut ->
	@Pointcut("execution(public void aop06.*.*())")
	public void myWork() {
	}

	@Before("myWork()") // pointcut 표현식을 여기에 주지 않음
	public void login(JoinPoint joinPoint) {
		System.out.println("로그인 처리");
	}

	@After("myWork()")  // myWork() -> 어노테이션 내에서 사용
	public void logout(JoinPoint joinPoint) {
		System.out.println("로그아웃");
	}
}







