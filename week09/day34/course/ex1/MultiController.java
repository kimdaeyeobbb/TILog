package week09.day34.course.ex1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MultiController {
	// 컨트롤러 메서드가 4개 있음
	// 컨트롤러 메서드마다 request mapping을 줌
	// 요청방식이 따로 지정되어있지 않으면 get, post 모두를 지원함

	// 스프링 컨트롤러 메서드는 쿼리문자열에 따라서 매개변수를 줄수도, 안줄수도 있음
	@RequestMapping(value="/select")
	public String select_proc() {
		System.out.println("select ............");
		return  "viewTest";
	}
	@RequestMapping(value="/search")
	public String search_proc() {
		System.out.println("search ............");
		return "viewTest";
	}

	// 집어넣는 Post 요청방식은 insert로 지정
	@RequestMapping(value="/insert")
	public String insert_proc(int pageno) {
		// 쿼리문자열을 숫자로 받겠다는 것
		// 스프링에서는 매개변수만 잘 선언해놓으면 쿼리문자열을 자동으로 잘 전달받음 (DispatcherServlet이 수행)

		System.out.println("insert ............"+pageno);
		return  "viewTest";
	}
	@RequestMapping(value="/viewTest")
	public void void_proc(int pageno) {
		// 얘는 리턴값이 없는 애 이므로 /viewTest가 바로 응답함
		// 리턴값으로 뷰이름이 없다면 디스패처서블릿이 매핑명과 똑같은이름의 템플릿을 선정함
		// 응답하는 템플릿이 viewTest면 응답은~
		System.out.println("viewTest ............");
	}
}


