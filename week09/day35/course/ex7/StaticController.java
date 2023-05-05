package com.example.springedu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;
@Controller  // 이 클래스가 컨트롤러임을 나타냄
public class StaticController {
	public StaticController() {
		System.out.println("HelloController Create object");
	}
	@RequestMapping("/static")   //    /static 요청 URL로 이 메서드가 실행되도록 매핑함
	public ModelAndView xxx(){  // 메서드명은 뭘로주든지 상관이 없음
		InternalResourceView view = new InternalResourceView("/staticview.html");
		// InternalResourceView 객체 생성 => 정적 자원을 가지고 직접 응답하는 뷰 객체
		// 응답할 뷰에 대한 정보 (이미지에 대한 정보라면 image/img1.xxx~)
		// 일반 html은 static 폴더 밑에 있으므로 staticview.html
		// 정적 자원 내에는 이미지 등이 포함됨

		// InternalResourceView: 정적 자원을 가지고 직접 응답하는 View 객체
		// 응답할 View에 대한 정보는 /staticview.html에 저장되어있으며, 이는 static 폴더 밑에 있는 html 파일임

		ModelAndView viewModel = new ModelAndView(view);
		return viewModel;
		//ModelAndView 객체에 InternalResourceView 객체를 설정하고 이를 반환함
		// 이를 통해 해당 URL로 접근시 staticview.html 파일이 응답됨
	}
}