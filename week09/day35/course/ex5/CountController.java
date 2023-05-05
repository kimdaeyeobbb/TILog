package com.example.springedu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.springedu.domain.CountDTO;
@Controller
@SessionAttributes({"count1", "count2"})
// @SessionAttributes: 해당 메서드가 리턴한 객체를 모델에 추가하여 뷰에서 사용할 수 있도록 해줌
// sessionAttribute가 쓰이지 않았다면 count1이든 count2는  request 스코프가 되었을 것임
// 2개의 CountDTO객체인 count1과 count2를 세션 스코프로 생성
public class CountController {
	// http://localhost:8088/count?num1=10&num2=20 꼴이어야 함 num1, num2를 입력하지 않으면 null이 들어가서 error
	@ModelAttribute("count1")
	public CountDTO countMethod1() {
		System.out.println("countMethod1 호출");
		return new CountDTO();
	}
	@ModelAttribute("count2")
	public CountDTO countMethod2() {
		System.out.println("countMethod2 호출");
		return new CountDTO();
	}
	@RequestMapping(value="/count")
	public void handle(@ModelAttribute("count1") CountDTO vo1,
					   @ModelAttribute("count2") CountDTO vo2, int num1, int num2) {
		// countDTO 객체 -> 세션스코프를 갖는 객체를 만들어서 쓰고 싶으면 ModelAttribute를 정의한 커멘드 객체를 만들고 에노테이션 지정
		// 이렇게 보관되는 객체가 sessionAttribute를 갖도록 sessionScoep 지정
		// CountDTO -> 누적 값을 저장하는 countNum 필드를 갖는 DTO 클래스 -> 이 클래스는 컨트롤러에서 세션 스코프로 사용됨

		// num1, num2 =>  클라이언트로부터 전달된 쿼리문자열 전달받음 -> 여기서 num1, num2 추출
		// 디스패처서블릿이 ~을 자동 변환해줌
		vo1.setCountNum(num1);
		vo2.setCountNum(num2);
		System.out.println("handle() : "+
				vo1.getCountNum() + " : " + vo2.getCountNum());

		// 요청할때마다 handle 메서드 안에서 증가된 값을 표준출력으로 내보냄
		System.out.println("=============================");
	}
	@RequestMapping(value="/countdel")
	// countdel이라는 매핑명으로 요청이 가능한 컨트롤 메서드
	// 지금까지 생성된 것을 다 없애고 싶으면 SessionStatue지정하여 SessionStatus객체를 전달받음
	// 세션 객체에 보관되어있는 애들이 더 이상 필요없다! -> 삭제
	public void handle(SessionStatus s) {
		s.setComplete();  // 세션 객체에 보관되어있던 애들을 모두 없앰 (한번에 삭제하므로 각각 삭제하고 싶으면 선별할 것)
		System.out.println("Both count1 and count2 deleted!");
		System.out.println("=============================");
		// 컨트롤러 메서드가 리턴값이 없음
		//  리턴값이 void이므로  request시 사용되는 매핑된 countdel이 뷰이름으로 대신 사용되어 뷰가 됨 (countdel이 응답한것)
	}
}