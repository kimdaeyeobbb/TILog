package com.example.springedu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// http://localhost:8088/querystring1 로 입력해서 확인 -> 쿼리문자열을 주지 않았으므로 브라우저에는 쿼리문자열에 대한것이 아무것도 나타나지 않음

@Controller
public class QueryStringController1 {
	@RequestMapping("/querystring1")
	public ModelAndView proc(String name) {
		// 가장 기본적인 리턴타입 유형 - ModelAndView (모델정보와 뷰 정보가 다 들어갈 수 있는 객체)

		// 매개변수의 타입과 리턴타입에 주목해야함
		// 매개변수가 String형 하나임. name이라는 이름으로 쿼리문자열의 value를 추출해서 nanme 변수에게 전달받도록 하겠다는 의도
		// 쿼리문자열을 전달하지 않아도 에러는 안나고 null이 전달됨 (null을 숫자로 바꾸려고하면 에러가 남 -> 매개변수를 숫자형으로 지정한 경우)


		ModelAndView mav = new ModelAndView();
		System.out.println("["+name+"]");
		mav.addObject("spring", name);
		//

		mav.setViewName("queryView1");
		return mav;
	}
	@RequestMapping("/querystring2")
	public ModelAndView proc(int number) {
		// 에러 안나게하려면 http://localhost:8088/querystring2?number=100과 같이 숫자를 전달해야 함
		ModelAndView mav = new ModelAndView();
		mav.addObject("spring", number); // 전달받은 숫자를 spring이라는 이름으로 전달
		mav.setViewName("queryView1");
		return mav;
	}
	@RequestMapping("/querystring3")
	public ModelAndView proc(String name,
							 @RequestParam("num")int number) {
		// RequestParam ->
		// http://localhost:8088/querystring2?name="크크"&number=100 꼴로 전달해야 에러 없이 결과를 확인할 수 있음
		ModelAndView mav = new ModelAndView();
		mav.addObject("spring", name+":"+number);
		mav.setViewName("queryView1");
		return mav;
	}
	@RequestMapping("/querystring4")
	public ModelAndView proc(
			@RequestParam("myname1") String name1,
			@RequestParam(value="myname2", required=false) String name2,
			// required = false => 반드시 설정해야하는 것은 아니라는 뜻. 따라서 값을 넣ㄹ지 않으면 null이 들어감
			@RequestParam(defaultValue="10") int number1,
			@RequestParam(value="NUM2", defaultValue="100")int number2){
		// 매개변수마다 RequestParam을 줌
		// 문자열로 받을 떄에는 쿼리가 안와도 null이 전달됨
		// @RequestParam("myname1") String name1 처럼 이름을 지정했을 떄 이름에 알맞은 쿼리가 오지 않으면 에러가 남
		// 	@RequestParam(value="NUM2", defaultValue="100")int number2) -> 쿼리가 오지 않으면 default value가 쓰임

		ModelAndView mav = new ModelAndView();
		mav.addObject("spring", name1+":"+(number1 + number2)
				+":"+name2);
		// spring이라는 이름으로 전달

		mav.setViewName("queryView1");
		return mav;
	}
}