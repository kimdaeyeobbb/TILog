package com.example.springedu.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class SpringSchedulerTest {

	// 이 메서드가 원하는 시점에 수행되게 만들기 위한 설정 -> 이 어노테이션을 지정한 메서드를 담고 있는 클래스 또한 스프링이 관리하는 클래스가 되어야 함
	// -> 따라서 스프링의 빈으로 등록되는 클래스가 되어야 함 -> class에 @Component를 지정해야 함(혹은 @Service) -> 스프링 컨테이너에 의해 관리되는 빈이 되게 함
	// 서버가 죽지 않고 기동되고 있다면 매주 목요일 10시 27분 5초에 해당 메서드를 실행함 (스케줄링 이용) -> 서버가 죽어있으면 의미 없음

//	@Scheduled(cron = "5 27 10 * * 4")// 초(5: 5초), 분(27: 27분), 시(10: 10시), 일(*: 모든 일), 월 (*: 모든 월) , 요일(0: 일요일, 4: 목요일)


	@Scheduled(fixedDelay = 5000) // 5초에 한 번씩 주기적으로 수행함
	public void scheduleRun() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat =
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("**** 스케줄 실행 : " +
				dateFormat.format(calendar.getTime()));

	}
}
