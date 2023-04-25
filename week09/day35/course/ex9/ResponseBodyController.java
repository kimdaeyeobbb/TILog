package com.example.springedu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springedu.domain.MyModel;

@Controller
public class ResponseBodyController {  // 이 클래스에는 컨트롤 메서드가 3개 정의 되어 있음
    @RequestMapping(value = "/body/text/{id}", produces="text/plain; charset=utf-8")  // id라는 값으로 받겠다는 것
    // http://localhost:8088/body/text/danny -> 이러한 꼴로 URL을 입력할 것
    // text/plain => 브라우저가 H1태그를 일반 문자열로 인식해서 출력하게 만듦
    @ResponseBody  // 컨트롤러가 직접 응답하게 만들고 싶을 때 사용
    public String getByIdInTEXT(@PathVariable String id) {  // id라는 매개변수를 이용함
        // PathVariable은 얘가 없으면 id라는 매개변수는 클라이언트에서 id라는 이름의 쿼리문자열의 value를 받음
        // PathVariable이 있으니까 -> 요청하는데 사용한 uri의 일부분에서 id를 받는것
        // 요청 uri가 localhost:8088/body/text/땡땡떙 꼴이므로 땡떙땡에 해당되는것을 id로 추출하겠다는 것
        // 이 id의 값을 매개변수를 통해 전달받겠다는 것이 pathVariable의 역할임
        return "<h1>컨트롤러에서 바로 문자열을 리턴해요 : "+id+"</h1>";
    }

    @RequestMapping(value = "/body/htmltext/{id}", 	produces="text/html; charset=utf-8")
    @ResponseBody  // 얘가 붙은것은 템플릿을 거치지 않고 컨트롤러가 리턴하는것을 그대로 클라이언트에게 줌 (컨트롤러가 응답바디를 줌)
    public String getByIdInHTMLTEXT(@PathVariable String id) {
        return "<h1>컨트롤러에서 바로 HTML 문자열을 리턴해요 : " + id +"</h1>";
    }

    @RequestMapping(value = "/body/json/{id}", produces = "application/json; charset=utf-8")  // text/json
    // /body/json/{id} => {id}의 id에는 임의의 변수명  => 컨트롤러에 id 전달
    // application/json => json형식으로 응답하는 것 (text/json으로 쓰면 안됨)
    // json에서 문자열은 쌍따옴표를 사용해야함
    @ResponseBody // 얘가 붙은것은 템플릿을 거치지 않고 컨트롤러가 리턴하는것을 그대로 클라이언트에게 줌 (컨트롤러가 응답바디를 줌)
    public MyModel getByIdInJSON(@PathVariable String id) {  // MyModel이라는 도메인 객체 리턴
        // http://localhost:8088/body/json/danny 꼴로 url 입력해서 확인하기
        MyModel my = new MyModel();   // 객체 생성
        my.setFlowerName("장미");
        my.setNum(5);
        my.setId(id);  // 클라이언트에서 보내온 url 문자열의 마지막에 온 path정보를 id로 전달받겠다고 설정함
        // http://localhost:8088/body/json/danny의 danny가 id
        System.out.println(my);
        return my;
    }
}