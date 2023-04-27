package com.example.springedu.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class StudyPathController {
    @RequestMapping(value = "/study/{num}/thymeleaf", produces = "text/html; charset=utf-8")
    public RedirectView getRedirectURL(@PathVariable int num) {
        String url="";
        if(num == 1){
            url = "https://abbo.tistory.com/56";
        } else if (num == 2){
            url = "https://abbo.tistory.com/57";
        } else if (num == 3) {
            url = "https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html";
        } else if (num == 4) {
            url = "https://www.baeldung.com/dates-in-thymeleaf";
        }
        RedirectView redirectView =  new RedirectView();
        redirectView.setUrl(url);
        return redirectView;
        // return "redirect:"+url꼴로 써주면 객체 생성하지 않아도 됨
        // redirect시 redirect: 만 붙여주면 나머지는 스프링이 알아서 함
        // 다른 웹 사이트이므로 uri가 아니라 url를 기재해야 함
    }
}
