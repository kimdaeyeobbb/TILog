package com.example.springedu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;
@Controller
public class StaticController {
	public StaticController() {
		System.out.println("HelloController Create object");
	}
	@RequestMapping("/static")
	public ModelAndView xxx(){  // 메서드명은 뭘로주든지 상관이 없음
		InternalResourceView view = new InternalResourceView("/staticview.html");
		// InternalResourceView 객체 생성 => 정적 자원을 가지고 직접 응답하는 뷰 객체
		// 응답할 뷰에 대한 정보 (이미지에 대한 정보라면 image/img1.xxx~)
		// 일반 html은 static 폴더 밑에 있으므로 staticview.html
		// 정적 자원 내에는 이미지 등이 포함됨

		ModelAndView viewModel = new ModelAndView(view);
		return viewModel;
	}
}