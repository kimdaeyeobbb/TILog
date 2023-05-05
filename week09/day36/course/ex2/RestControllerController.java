package com.example.springedu.controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springedu.domain.MyModel;
@RestController  // RestController -> 해당 클래스가 REST 웹 서비스를 위한 컨트롤러임을 나타냄
public class RestControllerController {

	// @RequestMapping => 요청 URL과 메서드를 매핑함
	// /rest/text/{id} 라는 URL에 대해서 메서드를 정의하고 있음. {id}는 URL경로에서 변수로 사용됨
	// text/plain 미디어 타입으로 response
	@RequestMapping(value = "/rest/text/{id}", produces="text/plain; charset=utf-8")
	public String getByIdInTEXT(@PathVariable String id) {
		// @PathVariable => 요청 URL 경로에 변수를 포함하고 싶을 때 사용함
		return "<h1>컨트롤러에서 바로 문자열을 리턴해요 : "+id+"</h1>";
	}


	// @RequestMapping => 요청 URL과 메서드를 매핑함
	// /rest/htmltext/{id} 라는 URL에 대해서 메서드를 정의하고 있음. {id}는 URL경로에서 변수로 사용됨
	// text/html 미디어 타입으로 response
	@RequestMapping(value = "/rest/htmltext/{id}", produces="text/html; charset=utf-8")
	public String getByIdInHTMLTEXT(@PathVariable String id) {
		return "<h1>컨트롤러에서 바로 HTML 문자열을 리턴해요 : " + id +"</h1>";
	}


	// @RequestMapping => 요청 URL과 메서드를 매핑함
	// /rest/json/{id} 라는 URL에 대해서 메서드를 정의하고 있음. {id}는 URL경로에서 변수로 사용됨
	// application/json 미디어 타입으로 response
	@RequestMapping(value = "/rest/json/{id}", produces = "application/json; charset=utf-8")  // json형식으로 응답해달라는 것
	// xml은 이와달리 root element에 대한 정보를 지정해주어야 함
	public MyModel getByIdInJSON(@PathVariable String id) {
		MyModel my = new MyModel();
		// JSON 객체의 속성으로는 flowerName, num, id가 있음
		my.setFlowerName("장미");
		my.setNum(5);
		my.setId(id);
		return my;
	}
}