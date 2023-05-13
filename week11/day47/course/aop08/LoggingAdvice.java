package aop08;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;
// 이 작업을 수행하는 동안 얼마나 시간이 걸렸는지 알기 위해 스탑워치 api를 사용함



// 어노테이션이 없음. 디스크립트 파일에 정해진 태그를 가지고 등록함.
// 어노테이션 방식과 룰은 거의 비슷함


//횡단(공통)관심 사항
public class LoggingAdvice {
	
	public void logAround(ProceedingJoinPoint jp) throws Throwable{
		String methodName = jp.getSignature().getName();
		StopWatch sw = new StopWatch();
		System.out.println("From [aop8.xml]");
		System.out.println("[LOG]METHOD : " + methodName + " 호출");
		sw.start();
		jp.proceed();   // 얘가 호출되는 시점에서 타겟 객체의 핵심 로직이 호출됨
		// proceed 호출후 되돌아오면 타겟객체의 메서드가 끝났다는 것임
		// 얘가 수행되는 시간이 얼마나 소요되었는지 알 수 있음.

		sw.stop();

		/* 로직 추가 */
		System.out.println(jp);
		System.out.println(jp.getSignature());  // getsignature -> 많이 사용함
		System.out.println(jp.getTarget());   // 프록시 객체에 대한 정보 & 객체에 대한 참조값이 나올것임
		System.out.println(jp.getTarget().getClass().getName());
		System.out.println(jp.toLongString());  // longstring -> 긴 정보
		System.out.println(jp.toShortString());
		System.out.println(jp.getThis());  // gethis -> 프록시 객체에 대한 정보를 보여줌
		System.out.println("프록시 정보: "+jp.getThis().getClass().getName());



		System.out.println("[LOG]METHOD : " + methodName + " 수행 종료");
		System.out.println("[LOG]처리시간   : " + sw.getTotalTimeMillis()/1000 + " 초");
		// 밀리세컨 단위로 얘가 몇초동안 시간이 흘렀는지 알 수 있음
	}
}