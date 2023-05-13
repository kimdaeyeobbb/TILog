package aop04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component  // 해당 adivce의 클래스 객체는 스프링 컨테이너가 관리하도록 빈으로 등록해야 함
@Aspect  // aspect 정의 -> before, after와 같은 어노테이션을 쓸 수 있게 됨
public class MyAspect{  // aspect보다는 advice라는 용어를 더 많이 씀 (before advice, after advice 등)

	// aspectj가 지원하는 pointcut expression (execution 함수 내부에 정의) -> 이 식에 알맞는 함수가 호출되었을 때 수행
	@Before("execution(public int aop04.*.*())")  // before advice로서의 기능을 담고 있는 메서드
	public void b(JoinPoint joinPoint) {
		System.out.println("Before");
	}
	
	@After("execution(public int aop04.*.*())")
	public void a(JoinPoint joinPoint) {
		System.out.println("After");
	}

	@Around("execution(public int aop04.*.*())")
	public Object around(ProceedingJoinPoint jp) {  // around는 반드시 매개변수를 정의하고 있어야 함
		// Object로 지정

		System.out.println("Before Around");
		Object obj = null;
		try {
			obj = jp.proceed();  // proceed() -> 클라이언트가 호출한 메서드가 실제로 호출됨
			System.out.println("Around 리턴 값 : "+obj);
		} catch(Throwable e) {
			System.out.println("Around 예외 발생 : "+e.getMessage());
		}

		// 핵심로직이 수행된 다음에 수행할 것을 기술
		if (obj == null)
			obj = new Integer(0);
		System.out.println("After Around");
		return obj;
	}

	// after -> after, afterthrowing, afterreturning이 존재
	// after: 무조건 수행
	// afterthrowing: 에러가 났을 떄 수행
	// afterreturning: 에러가 안나고 정상적으로 리턴되었을 때 수행


	// 발생한 예외 객체를 매개변수 e를 통해서 받음 -> 매개변수명과 일치해야 함
	// afterthrowing은 예외처리를 대신해주지는 않음 (예외가 발생했음을 알리기만하고, around를 통해 예외처리를 함)
	// 예외에 대한 로그를 남기고 싶을 때 e.getmessage 이용
	@AfterThrowing(pointcut="execution(public int aop04.*.*())", throwing="e" )
	public void at(Throwable e){
		System.out.println("AfterThrowing : " + e.getMessage());
	}

	@AfterReturning(pointcut="execution(public int aop04.*.*())", returning="ret" )
	public void ar(Object ret){
		System.out.println("AfterReturning : " + ret);
	}



	// before
	// work2가 호출될 떄에만 기능을 가지는 메서드
	// 리턴값의 유형이 void -> 리턴값의 유형이 int인 work1과 일치하지 않으므로 콘솔창을 보면 work1만 수행한 것
	@Before("execution(* *.work2()))")
	public void b1(JoinPoint joinPoint) {
		System.out.println("Before-b1");
	}


	@Before("execution(* *.work3()))")
	public void b2(JoinPoint joinPoint) {
		System.out.println("Before-b2");
	}
}