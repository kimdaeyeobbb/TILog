package week09.day35.course.ex1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller  // 해당 클래스가 컨트롤러임을 명시
public class TestModelController1 {
	  // 해당 메서드가 컨트롤러의 요청 처리 메서드가 호출되기 전에 미리 생성된 객체를 Model 객체에 추가해줌
	// 여기서는 v1 메서드가 정의된것
	@ModelAttribute("v1")
	public String createString() {
		System.out.println("객체 생성 자동호출1");
		return "테스트!!";
	}

	// @ModelAttribute("v2") 해석
	// v2 메서드 정의. 해당 메서드가 컨트롤러의 요청 처리 메서드가 호출되기 전에 미리 생성된 객체를 Model 객체에 추가해줌
	// v2 메서드는 int 배열 반환
	@ModelAttribute("v2")
	public int[] createArray() {
		System.out.println("객체 생성 자동호출2");
		return new int[]{10, 20, 30, 40, 50};  // int 배열 반환
	}


	// v3 메서드는 MyVO 객체 반환
	@ModelAttribute("v3")
	public MyVO createVO() {
		System.out.println("객체 생성 자동호출3");
		MyVO vo = new MyVO( 23, "yellow");
		return vo;  // v3 메서드는 MyVO 객체 반환
	}

	// v4 메서드는 Date 객체 반환
	@ModelAttribute("v4")
	public Date createDate() {
		System.out.println("객체 생성 자동호출4");		
		return new Date();   // v4메서드는 Date 객체 반환
	}

	// 이 메서드는 v5라는 이름으로 모델에 추가됨
	// v5 메서드는 MyVO 객체의 리스트를 반환
	@ModelAttribute("v5")
	public List<MyVO> createList() {
		System.out.println("객체 생성 자동호출5");
		List<MyVO> list = new ArrayList<MyVO>();
		MyVO vo = new MyVO(7, "red");
		list.add(vo);
		vo = new MyVO(11, "pink");
		list.add(vo);
		return list;  // v5 메서드는 MyVO 객체의 리스트를 반환
	}

	// 요청이 들어오면 handle 메서드가 실행됨
	// 이 때, @ModelAttribute 어노테이션을 가진 메서드들이 자동으로 호출되어 생성된 객체들이 Model 객체에 추가됨
	// 이 메서드는 "/modeltest1" URL에 대한 요청을 처리함
	@RequestMapping("/modeltest1")
	public String handle() {
		System.out.println("handle() 메서드 호출");		
		return "modelResult1";   // modelResult1을 반환하면 해당 View 이름에 해당하는 템플릿 파일이 렌더링되며, Model 객체에 추가된 데이터들을 템플릿에서 사용할 수 있음.
	}
}



