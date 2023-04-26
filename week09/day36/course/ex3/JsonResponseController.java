package com.example.springedu.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springedu.domain.TestVO;
@RestController  // 내부에 정의된 모든 컨트롤러 메서드는 직접 응답하게되는 성격을 지니게 됨 -> 어떤 형식인지는 produces에 설정한값에 따라 다름
public class JsonResponseController {
	@RequestMapping(value = "/getJSON1", produces = "application/json; charset=utf-8")  // RequestMapping 대신 GetMapping 해도 됨
	// 응답형식을 JSON으로 지정
	public String test1(String id) {   // id는 DUKE를 전달함
		String s = "{ \"name\":\"둘리\",\"id\":\"" + id +"\"}";   // JSON형식의 내용을 문자열로 만듦
		// 문자열로 만들면 후회할 수 있다! -> json에서는 json표현시 쌍따옴표를 쓰고 문자열 표현시 쌍따옴표를 또 써야하므로 \(백슬래쉬)를 써서 고유의 쌍따옴표 표시를 없애줘야하는 번거로움이 발생
		return s;
	}

	@RequestMapping(value = "/getJSON2", produces = "application/json; charset=utf-8")
	public HashMap<String, String> test2(String id) {  // 해시맵으로 리턴해도 json이 됨
		// 해시맵으로 들어가는 키가 name, value가 value가 됨
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", "유니코");
		map.put("id", id);
		return map;
	}

	@RequestMapping(value = "/getJSON3", produces = "application/json; charset=utf-8")
	public TestVO test3(String id) {
		TestVO vo = new TestVO();  // VO객체로 만들어서 리턴해도 됨
		// VO지만 setter, getter를 모두 정의하도록 만듦
		vo.setName("올라프");
		vo.setId(id);
		return vo;
	}
}
