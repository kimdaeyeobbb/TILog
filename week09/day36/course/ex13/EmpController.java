package week09.day36.course.ex13;

import com.example.springedu.domain.PageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller  // EmpController가 MVC 구조에서 Controller 역할을 수행함을 나타냄
public class EmpController {
	@Autowired   // EmpMybatisDAO 객체를 주입함
	EmpMybatisDAO dao;

	// @GetMapping: HTTP GET 요청을 처리하는 메서드임을 나타냄. request URL과 해당 URL을 처리하는 메서드를 매핑하는 역할을 함
	// 여기서는 /countnum이라는 요청 URL을 처리하는 메서드를 정의함.
	@GetMapping("/countnum") // 수정
	public ModelAndView count() {
		ModelAndView mav = new ModelAndView();
		int num = dao.getAllDataNum();
		mav.addObject("num", num);
		mav.setViewName("empResult");
		return mav;   // empReuslt라는 뷰를 반환함
	}

	// @GetMapping: HTTP GET 요청을 처리하는 메서드임을 나타냄. request URL과 해당 URL을 처리하는 메서드를 매핑하는 역할을 함
	// 여기서는 /list request URL을 처리하는 list()를 정의함
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<EmpVO> list = dao.listAll();
		mav.addObject("list", list);
		mav.setViewName("empResult");
		return mav;
	}


	// @GetMapping: HTTP GET 요청을 처리하는 메서드임을 나타냄. request URL과 해당 URL을 처리하는 메서드를 매핑하는 역할을 함
	// 여기서는 /part request URL을 처리하는 part() 메서드를 정의함
	@GetMapping("/part")
	public ModelAndView part(PageDTO vo) {
		ModelAndView mav = new ModelAndView();
		List<EmpVO> list = dao.listPart(vo);
		mav.addObject("list", list);
		mav.setViewName("empResult");
		return mav;
	}

}
