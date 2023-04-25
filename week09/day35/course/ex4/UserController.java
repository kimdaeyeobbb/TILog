package com.example.springedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springedu.domain.UserVO;

// http://localhost:8088/userForm -> userForm.html이 직접 보내준 화면이 아님.
// 컨트롤러가 보내준 데이터로 구성한 것임
@Controller
public class UserController {

	@ModelAttribute("popularFruit") // 모델어트리뷰트로 체크박스 구성
	public String[] refPopularFruit() {
		System.out.println("popularFruit 명으로 보관될 문자열 배열객체 생성과 보관");
		return new String[] { "망고", "멜론", "수박", "참외" };
		// 배열객체를 리턴 => popularFruit으로 보관
	}

	@RequestMapping(value = "/userForm", method = RequestMethod.GET) // 브라우저에서 GET방식으로 userForm이 요청되었을 때
	public String userForm() {
		System.out.println("----- UserController.userForm() : GET -----");
		return "userForm";  // 타임리프 기반으로 만들어진 템플릿 넘김
	}

	@RequestMapping(value = "/userSave", method = RequestMethod.POST)
	public String userSave(UserVO userVo, Model model) {
		// UserVO형 매개변수 - UserVO는 클라이언트로부터 전달되는 쿼리문자열을 하나의덩어리(하나의 객체)로 받겠다는 것
		// UserVO에 정외되어있는 ~와 쿼리문자여링 ㄱ강타
		// Model형 매개변수 - 모델 객체 달라는 뜻.
		//  ~가 호출될때 디스패처서블릿이 모델 객체를 알아서 만들어서 줌
		// 모델 -> 뒤에있는 데이터를 담아서 보관하는 역할
		// 디스패처 서블릿이 모델객체를 줌
		// m,P
		System.out.println("----- UserController.userSave() : POST -----");
		System.out.println("userInfo : " + userVo.toString());
		model.addAttribute("msg", "SUCCESS");
		return "userInfo";
	}
}
