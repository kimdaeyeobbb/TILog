package com.example.springedu.controller;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.springedu.domain.QueryDTO;
@Controller
public class QueryStringController2 {
	// http://localhost:8088/queryform.html를 먼저 요청

	@RequestMapping("/querystring5")
	public ModelAndView proc(QueryDTO vo) {  // 매개변수 -> 여러 객체를 하나로 묶은 커멘드 객체
		// 이름 설정을 하지 않으면 QueryDTO의 첫글자를 소문자로 바꿔서 보관해줌 (request 스코프 공간에!)
		// 세션 스코프에 저장하고 싶으면 modelAttribute를 따로 또 써야 함
		// DTO 클래스를 매개변수로 함 (하나하나 전달하기보다 묶어서 전달하기 위해 DTO 사용)
		ModelAndView mav = new ModelAndView();
		String name = vo.getTestName();
		int age = vo.getTestAge();
		String addr = vo.getTestAddr();
		mav.addObject("spring", name + "-" + age + "-" + addr);  // 쿼리문자열을 붙여서 요청
		mav.setViewName("queryView2");
		return mav;
	}
	@RequestMapping(value = "/querystring6",
			method = RequestMethod.POST)
	// 메서드 속성을 같이줌 -> method = RequestMethod.POST => post 방식만 지원
	//  POST만 지원한다는 뜻 (이것을 따로 설정하지 않으면 GET, POST 방식 모두 지원함)
	public ModelAndView procPost(QueryDTO vo) {
		ModelAndView mav = new ModelAndView();
		String name = vo.getTestName();
		int age = vo.getTestAge();
		String addr = vo.getTestAddr();
		mav.addObject("spring", name + "@" + age + "@" + addr);
		mav.setViewName("queryView2");
		return mav;
	}
	@RequestMapping("/querystring7")
	public ModelAndView proc(HttpServletRequest request) {
		// HttpServletRequest 형 매개변수

		ModelAndView mav = new ModelAndView();
		String name =request.getParameter("testName");
		int age = Integer.parseInt(request.getParameter("testAge"));
		String addr = request.getParameter("testAddr");
		mav.addObject("spring", name + "#" + age + "#" + addr);
		mav.setViewName("queryView2");
		return mav;
	}

	@RequestMapping(value="/locale/mine")
	public ModelAndView proc(Locale l) {
		ModelAndView mav = new ModelAndView();

		// 클라이언트 머신이 속한 나라정보를 추출해서 요청헤더의 서버에게 전송
		mav.addObject("spring", "Processing locale ............"+
				l.getDisplayCountry()+"_"+l.getDisplayLanguage());
		mav.setViewName("queryView2");
		return mav;
	}
}