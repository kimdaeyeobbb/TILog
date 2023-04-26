package com.example.springedu.controller;
// http://localhost:8088/bodystart로 확인

import com.example.springedu.domain.PersonVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
@Controller
public class RequestBodyController {  // 컨트롤러가 ResponseBody의 내용을 담는 ResponseBody와 다름
    // POST방식일 떄는 쿼리문자열이 아닌 요청 파라미터라고 해야함
    // 요청 파라미터를 내가 원하는 형식으로 받고 싶을 때 RequestBody 사용
    @GetMapping("/bodystart")
    public String test0() {  // 템플릿을 통해 응답
        System.out.println("요청 성공");
        return "result";
    }

    @PostMapping("/rb1")  // rb1을 요청
    // post방식- 요청바디안에서 받아서 전달되는 요청 파라미터 => 선언한 사양에 맞게 알아서 전달(String name, int age)
    public ModelAndView test1(String name, int age) {  // 템플릿을 통해 응답
        System.out.println(">>> " + name+":"+age);
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", "폼태그로 전달된 파라미터 : "+name+":"+age);
        mav.setViewName("result");
        return mav;
    }
    @PostMapping(value = "/rb2", produces = "application/json; charset=utf-8")  // 문자열로 읽고싶으면 json으로 줌
    @ResponseBody
    public String test2(@RequestBody String param) { // 직접 응답 (ResponseBody가 있으므로)
        // RequestBody는 GET방식과 무관하며 POST 방식과만 관련있음
        // GET방식- URL 문자열의 일부분이 되는 것
        // 반드시 POST 요청 방식에서만 RequestBody가 유의미함
        // post 방식은 html form 태그가 있어야 함
        // @RequestBody를 지정해주면 원하는 형식으로 읽을 수 있음
        System.out.println(">>> " + param);
        return param;
    }
    @PostMapping(value = "/rb3", produces = "application/json; charset=utf-8")
    @ResponseBody
    public PersonVO test3(@RequestBody PersonVO vo) { // 직접 응답 (ResponseBody가 있으므로)
        // RequestBody는 GET방식과 무관하며 POST 방식과만 관련있음
        // GET방식- URL 문자열의 일부분이 되는 것
        // 반드시 POST 요청 방식에서만 RequestBody가 유의미함
        // post 방식은 html form 태그가 있어야 함
        // @RequestBody를 지정해주면 원하는 형식으로 읽을 수 있음

        System.out.println(">>> " + vo.getName()+":"+vo.getAge());
        return vo;  //  vo 객체로 추출 -> json형식의 내용을 그대로 전달받음
    }
    @PostMapping(value = "/rb4", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map test4(@RequestBody Map<String,String> map) { // 직접 응답 (ResponseBody가 있으므로)
        // RequestBody는 GET방식과 무관하며 POST 방식과만 관련있음
        // GET방식- URL 문자열의 일부분이 되는 것
        // 반드시 POST 요청 방식에서만 RequestBody가 유의미함
        // post 방식은 html form 태그가 있어야 함
        // @RequestBody를 지정해주면 원하는 형식으로 읽을 수 있음

        System.out.println(">>> " + map);
        return map;
    }
}
