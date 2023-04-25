package com.example.springedu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

// 컨트롤러 메서드 1개 (핸들)
@Controller
public class TestModelController2 {
	/* 커멘드 메서드 - 데이터를 하나로 묶어주는 메서드 */
	// 핸들러보다 먼저 수행
	// 최대 유지시간 - 요청이 끝날때까지
	@ModelAttribute("data1")
	public int createModel1() {
		System.out.println("createModel1() 호출");
		return 100;
	}
	/* 커멘드 메서드 - 데이터를 하나로 묶어주는 메서드 */
	// 핸들러보다 먼저 수행
	// 최대 유지시간 - 요청이 끝날때까지
	@ModelAttribute("data2")
	public int createModel2() {
		System.out.println("createModel2() 호출");
		return 200;
	}
	@RequestMapping(value="/modeltest2")
	public String handle(@ModelAttribute("data1") int vo1,
						 @ModelAttribute("data2") int vo2) {
		// 컨트롤러 메서드에서도 커멘드 메서드가 보관한 객체를 사용하고 싶으면 ModelAttribute를 지정하면 됨
		// 지정하지 않으면 쿼리문자열을 세팅
		// 지정하면 data1, data2 이라는 이름으로 보관된 객체를 전달받겠다는 것 (클라이언트에서 전송된 쿼리를 받는것이 아님)
		System.out.println("handle 에서 출력 : "+vo1 + " - " + vo2);
		System.out.println("=============================");
		return "modelResult2";
	}
}
