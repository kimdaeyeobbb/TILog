package com.example.springedu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springedu.domain.StepVO;

@Controller
public class StepController {
    @PostMapping("/step")
    public String memberHandle(@ModelAttribute("kkk") StepVO vo) {
        // @ModelAttribute("kkk") StepVO vo  => 보관할 때 kkk라는 이름으로 보관하라는 것
        // StepVO vo =>  도메인 객체를 통해 클라이언트 쿼리를 전달 받겠다는 것
        if(vo.getAge() < 18)  // 전달된 스텝의 나이가 18미만이면 등록해도 등록이 되지 않음
            return "redirect:/stepForm.html";  // 바로 redirect하기때문
        // 템플릿이 응답하는 것은 항상 forward 기능임
        // redirection으로 서버가 클라이언트에게 다시 요청하고 싶으면 redirect:리다이렉트할 대상 path 를 주면 됨
        // redirect는 다른 주소도 쓸 수 있음
        System.out.println("[ 전달된 Command 객체의 정보 ]");
        System.out.println(vo.getName());
        System.out.println(vo.getPhoneNumber());
        System.out.println(vo.getAge());
        return  "stepOutput"; // stepOutput.html 이라는 템플릿이 응답하게끔 stepOutput 리턴
    }
}