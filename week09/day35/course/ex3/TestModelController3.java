package week09.day35.course.ex3;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("data1")  // 핸들러 메서드 (컨트롤러 메서드)
// data1으로 보관되는 객체는 sessionAttribute를 적용
// class에만 적용될 수 있는 어노테이션
// 클래스 레벨에서 선언되었으므로 해당 클래스에 data1이라는 이름의 모델 속성이 세션이 유지되도록함
public class TestModelController3 {

	@ModelAttribute("data1")  // 컨트롤러 메서드보다 먼저 호출됨
	public StringBuffer createModel1() {
		// String은 한번 만들어지면 결과가 바뀌지 않으므로 StringBuffer 이용

		System.out.println("createModel1() 호출");
		return new StringBuffer();   // 리턴되는 객체가 세션스코프를 가짐 
		// 세션 스코픅 기반의 객체는 최초에 1번만 수행됨
		// 세션 스코프로 정의되는 모델객체를 정의하느냬~ 
	}
	@ModelAttribute("data2")  // 컨트롤러 메서드보다 먼저 호출됨
	public StringBuffer createModel2() {	
		System.out.println("createModel2() 호출");
		return new StringBuffer();
	}
	@RequestMapping(value="/modeltest3")
	public String handle(@ModelAttribute("data1") StringBuffer vo1, 
			@ModelAttribute("data2") StringBuffer vo2, String str) {
		// ModelAttribute를 정의한 객체 
		vo1.append(str+"#");
		vo2.append(str+"@");
		System.out.println("handle 에서 출력 : "+vo1 + " - " + vo2);
		System.out.println("=============================");
		return "modelResult2";
	}	
}
