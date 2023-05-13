package aop09;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdviceEx {  // advice 클래스
	    @Before("within(aop09.CoreEx)")  //within -> 특정 클래스에 정의된 메서드가 여러개 있는데 얘들이 모두 포인트 컷이 되게 만듦
		public void before(){
			System.out.println("Before Advice");
		}
		
		@AfterThrowing(pointcut="within(aop09.CoreEx)", throwing="e" )  // 얘가 호출된다고 해서 예외처리까지 해주지는 않음
		public void afterThrowing(Throwable e){
			System.out.println("예외가 실행될때 호출되는 Advice : "+e.getMessage());
		}
		
		@AfterReturning(pointcut="within(aop09.CoreEx)", returning="ret" )
		public void afterReturing(Object ret){
			System.out.println("Joinpoint 가 정상 종료후 실행되는 Advice");
		}
		
		@After("within(aop09.CoreEx)")
		public void after(){
			System.out.println("After Advice");
		}
		
		@Around("within(aop09.CoreEx)")  // advice로 예외처리를 하려면 반드시 around메서드를 사용해야함
		public Object around(ProceedingJoinPoint  jp) throws Throwable{
			System.out.println("Around Advice(1)");
			Object result = null;
			try {
				result = jp.proceed();
			} catch(Exception e ) {
				System.out.println("오류가 발생했다네 : "+ e.getMessage());
			}
			System.out.println("Around Advice(2)");
			return result;
		}	
}
