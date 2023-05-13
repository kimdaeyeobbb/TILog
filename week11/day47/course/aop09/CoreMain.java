package aop09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoreMain {
	public static void main(String[] args) {
		ApplicationContext factory=new ClassPathXmlApplicationContext("aop09.xml");
		
		CoreEx ex=factory.getBean("core", CoreEx.class);
		try {
//			ex.zeroMethod(5,2);
						ex.zeroMethod(5,0);
		}catch(Exception e) {
			System.out.println("오류발생");
		}
		((ClassPathXmlApplicationContext)factory).close();
	}
}

/*
*  ex.zeroMethod(5,2); 수행 결과
Around Advice(1)
Before Advice
5/2=2 -> 타겟 객체의 클라이언트가 호출한 핵심 로직을 구현한 메서드를 타겟 메서드라 함 -> 여기서는 zeroMethod
Joinpoint 가 정상 종료후 실행되는 Advice -> afterReturning이 수행된 것
After Advice
Around Advice(2)
* */


/*ex.zeroMethod(5,0);
* 또다른 exception이 발생 -> 런타임 Exception으로 바꿈 ->
* Around Advice(1)
Before Advice
예외가 실행될때 호출되는 Advice : 0으로 나눌수 없습니다.
After Advice
오류가 발생했다네 : 0으로 나눌수 없습니다.
Around Advice(2)
*
*
* */