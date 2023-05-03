package com.example.springedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springedu.domain.UserVO;

// http://localhost:8088/userForm -> userForm.html이 직접 보내준 화면이 아님.
// 컨트롤러가 보내준 데이터로 구성한 것임
@Controller // UserController 클래스가 컨트롤러임을 나타냄
public class UserController {

	// @ModelAttribute 어노테이션을 사용하여 popularFruit 이름으로 모델 어트리뷰트를 추가함
	@ModelAttribute("popularFruit") // 모델어트리뷰트로 체크박스 구성
	public String[] refPopularFruit() {
		System.out.println("popularFruit 명으로 보관될 문자열 배열객체 생성과 보관");
		return new String[] { "망고", "멜론", "수박", "참외" };
		// 배열객체를 리턴 => popularFruit으로 보관
		// 이 메서드에서는 배열 객체를 생성하고 나서 popularFruit이름으로 추가된 모델 어트리뷰트에 배열 객체를 저장함
		// 이 모델 어트리뷰트는 userForm.html 템플릿에서 체크박스를 구성하는데 도움이 됨
	}

	// <form> method의 default value는 get임
	// @RequestMapping 어노테이션을 사용하여 /userForm 경로로 GET 요청이 들어왔을 때 userForm() 메서드가 호출되도록 함
	// 브라우저에서 url 입력해서 요청하는 방식은 무조건 GET 방식의 요청임
	@RequestMapping(value = "/userForm", method = RequestMethod.GET) // 브라우저에서 GET방식으로 userForm이 요청되었을 때
	public String userForm() {
		System.out.println("----- UserController.userForm() : GET -----");
		return "userForm";  // 타임리프 기반으로 만들어진 템플릿 넘김 (userForm() 메서드에서는 타임리프 기반으로 만들어진 템플릿 파일인 userForm 문자열을 리턴함)
	}

	// @RequestMapping 어노테이션을 사용하여 /userSave 경로로 POST 요청이 들어왔을 때 userSave() 메서드가 호출되도록 함
	@RequestMapping(value = "/userSave", method = RequestMethod.POST)
	public String userSave(UserVO userVo, Model model) {
		// UserVO형 매개변수 - UserVO는 클라이언트로부터 전달되는 쿼리문자열을 하나의덩어리(하나의 객체)인 UserVO 객체로 받겠다는 것
		// Model형 매개변수 - 모델 객체 달라는 뜻. (model 매개변수는 모델 객체를 받아오기 위해서 사용됨)
		//  ~가 호출될때 디스패처서블릿이 모델 객체를 알아서 만들어서 줌
		// 모델 -> 뒤에있는 데이터를 담아서 보관하는 역할
		// 디스패처 서블릿이 모델객체를 줌
		// m,P
		System.out.println("----- UserController.userSave() : POST -----");
		System.out.println("userInfo : " + userVo.toString());  // userVo 객체의 정보를 출력
		model.addAttribute("msg", "SUCCESS");  // Model 객체에 msg라는 이름으로 SUCCESS 문자열을 추가함
		return "userInfo";  // userInfo 문자열 반환 -> 이 문자열은 userInfo.html을 찾아서 반환함 -> 이 파일에서는 msg라는 이름으로 모델에 담겨있는 SUCCESS 문자열을 사용할 수 있음
	}
}
