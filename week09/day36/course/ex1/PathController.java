package com.example.springedu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PathController {
	@RequestMapping(value="/character/detail/{name}/{number}") // name, number는 동적 path -> 매개변수 num과 name에 전달되도록 함
	public String getAllBoards(@PathVariable("number") int num,
							   @PathVariable String name, Model model){
		// @PathVariable 이 없으면 쿼리문자열에서 num을 받으려고 할것임.
		// @PathVariable이 있으므로  num위치의 값을 nu에게 전달함
		// 동적매개변수와 매개변수명이 같으면 값의 이름을 지정하지 않아도 됨 (다른이름일 경우에는 @PathVariable뒤에 이름을 지정해줄것)

		// 수행결과를 보관하는 Model 객체 -> 내부에 어떤 이미지를 클라이언트에 보여줄지 이미지 정보를 addAttribute로 넣어서 detailView가 응답하도록 함
		// http://localhost:8088/character/detail/kakao/1 등과 같이 url 입력
		// http://localhost:8088/character/detail/line/3 등과 같이 url 입력
		// path에 어떤 값이 들어오는지에 따라 클라이언트에게 다른 화면을 보여줌
		System.out.println(model.getClass().getName());
		if(name.equals("kakao")) {  // 전달된 name 확인
			if (num == 1) // 전달된 num 확인
				model.addAttribute("imgname", "ryan");
			else if (num == 2)
				model.addAttribute("imgname", "muzicon");
			else if (num == 3)
				model.addAttribute("imgname", "apeach");
			else if (num == 4)
				model.addAttribute("imgname", "jayg");
			else if (num == 5)
				model.addAttribute("imgname", "frodoneo");
			else if (num == 6)
				model.addAttribute("imgname", "tube");
		} else if (name.equals("line")) {
			if (num == 1)
				model.addAttribute("imgname", "brown");
			else if (num ==2)
				model.addAttribute("imgname", "james");
			else if (num == 3)
				model.addAttribute("imgname", "cony");
			else if (num == 4)
				model.addAttribute("imgname", "edward");
			else if (num == 5)
				model.addAttribute("imgname", "leonard");
			else if (num == 6)
				model.addAttribute("imgname", "moon");
			else if (num == 7)
				model.addAttribute("imgname", "sally");
			else if (num == 8)
				model.addAttribute("imgname", "jessica");
		}
		return "detailView";
	}
}
