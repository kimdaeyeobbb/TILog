package com.example.springedu.controller;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.springedu.domain.CountDTO;


@Controller
public class CountController2 {
	// 컨트롤러 메서드가 2개 - 첫번쨰
	@RequestMapping(value="/count2")  //  count2 요청시에도 쿼리문자열을 주어야 함
	public void handle(int num1, int num2, HttpSession s) {   // 리턴값이 void -> 매핑된 count2가 응답함
		// HttpSession형을 매개변수로 함
		// http://localhost:8088/count2 -> error
		// http://localhost:8088/count2?num1=10&num2=20 -> 정상결과 출력
		System.out.println(s.getId());
		if(s.getAttribute("count3") == null )  // count3라는 이름의 객체가 있는지 확인
			s.setAttribute("count3", new CountDTO());  // 없으면 DTO에 등록
		if(s.getAttribute("count4") == null )
			s.setAttribute("count4", new CountDTO());

		CountDTO vo3 = (CountDTO)s.getAttribute("count3");
		CountDTO vo4 = (CountDTO)s.getAttribute("count4");

		vo3.setCountNum(num1);  // num1만큼 카운트값 증가시켜 줌
		vo4.setCountNum(num2);
		System.out.println("handle() : "+
				vo3.getCountNum() + " : " + vo4.getCountNum());

		System.out.println("=============================");
	}

	// 컨트롤러 메서드가 2개 - 두번쨰
	@RequestMapping(value="/countdel2")  // 세션 객체가 필요함
	public void handle(HttpSession s, String who) {   // 따라서 매개변수로 HttpSession 객체를 받음
		// http://localhost:8088/countdel2?who=count4로 확인
		if(who != null) {
			s.removeAttribute(who);
			System.out.println(who + " deleted!");
		}
		System.out.println("=============================");
	}
}