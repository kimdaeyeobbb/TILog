package com.example.springedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.springedu.domain.MemberDTO;

// 컨트롤러에서 제일 우선시되는 것이 쿼리문자열 추출하는 것
@Controller
public class MemberController {
	// http://localhost:8088/memberForm.html
	@PostMapping("/member1")
	protected ModelAndView proc1(@RequestParam(value = "name", defaultValue = "없음") String name,
								 @RequestParam(value = "phone", defaultValue = "없음") String phone,
								 @RequestParam(value = "id", defaultValue = "없음") String id,
								 @RequestParam(value = "password", defaultValue = "없음") String password) {
		// 쿼리문자열 없이 전달했으면 기본값을 "없음"으로 넣으라는 것
		// 아무것도 입력하지 않고 등록하면 '없음'이 나옴

		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.addObject("id", id);
		mav.addObject("phone", phone);
		mav.addObject("password", password);
		mav.setViewName("memberView");
		return mav;
	}

	@PostMapping("/member2")
	public String proc2(@ModelAttribute("member") MemberDTO vo) {
		// 4개의 데이터를 하나의 객체(MemberDTO)로 받음
		// 보관시 member라는 이름으로 보관함

		if( vo.getName() == null || vo.getName().equals(""))
			vo.setName("없음");
		if( vo.getPhone() == null || vo.getPhone().equals(""))
			vo.setPhone("없음");
		if( vo.getId() == null || vo.getId().equals(""))
			vo.setId("없음");
		if( vo.getPassword() == null || vo.getPassword().equals(""))
			vo.setPassword("없음");
		return "memberView";
	}

	@PostMapping("/member3")
	public String proc3(MemberDTO vo) { // memberVO 이름으로 request 객체에 보관까지 된다
		if( vo.getName() == null || vo.getName().equals(""))
			vo.setName("없음");
		if( vo.getPhone() == null || vo.getPhone().equals(""))
			vo.setPhone("없음");
		if( vo.getId() == null || vo.getId().equals(""))
			vo.setId("없음");
		if( vo.getPassword() == null || vo.getPassword().equals(""))
			vo.setPassword("없음");

		return "memberView";
	}
}
