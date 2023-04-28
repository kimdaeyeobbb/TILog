package week09.day38.course.ex2;

import com.example.springedu.domain.VisitorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller  // 없으면 스프링 컨테이너가 알아서 객체생성해서 넣어주지 못함
public class VisitorController {// 인터페이스를 사용하면 컨트롤러와 DAO간의 결합도를 낮출 수 있음
	// 인터페이스가 있으면 dao의 구현스펙을 인터페이스로 정의해놓고 implements해서 계속 사용할 수 있음
	// 인터페이스가 있으면 컨트롤로와 DAO간의 결합도가 낮아짐
	// 인터페이스에 호출되는 메서드의 스펙을 정희해놓고 구현은 클래스에서 하자.


	// 이 예시는 인터페이스가 없고 VisitorMybatisDAO를 그대로 가져다가 씀
//	@Autowired  // Autowired -> 스프링 컨테이너가 알아서 객체생성해서 넣어줌
//	VisitorMybatisDAO dao;  // dao => VisitorMybatisDAO 객체를 참조함
//
	@Autowired
	VisitorMapperDAO dao;


	@RequestMapping("/vlist") 	// 템플릿을 통해 응답하도록 만듦
	public ModelAndView list() {
		List<VisitorDTO> list = dao.list();
		ModelAndView mav = new ModelAndView();	
		if (list.size() != 0) {
			mav.addObject("list", list);
		} else {
			mav.addObject("msg", "추출된 결과가 없어요");
		}
		mav.setViewName("visitorView");
		return mav;
	}

	@RequestMapping("/vsearch") 	// 템플릿을 통해 응답하도록 만듦
	public ModelAndView search(String key) {
		List<VisitorDTO> list = dao.search(key);
		System.out.println(list.size());
		ModelAndView mav = new ModelAndView();
		if (list.size() != 0) {
			mav.addObject("list", list);
		} else {
			mav.addObject("msg", "추출된 결과가 없어요");
		}
		mav.setViewName("visitorView");
		return mav;
	}

	@RequestMapping(value = "/vdelete") 	// 템플릿을 통해 응답하도록 만듦
	public ModelAndView delete(String id) {
		boolean result = dao.delete(id);
		ModelAndView mav = new ModelAndView();
		if (result) {
			mav.addObject("list", dao.list());
		} else {
			mav.addObject("msg", "글 삭제에 실패했습니다.");
		}
		mav.setViewName("visitorView");
		return mav;
	}
	
	@RequestMapping(value = "/one", produces = "application/json; charset=utf-8")
	// one은 직접 응답하도록 만듦 	(템플릿을 통해 응답하도록 만들지 않음)
	// 수정할 글에 대한 데이터기 때문임
	@ResponseBody
	public VisitorDTO one(int id) {
		return dao.one(id);
	}

	@RequestMapping(value = "/vinsert", 
			                     method = RequestMethod.POST)
	public ModelAndView insert(VisitorDTO vo) {   // 클라이언트에게서 글이 왔을 떄 VisitorDTO형의 객체로 받아서 insert
		boolean result = dao.insert(vo);
		ModelAndView mav = new ModelAndView();
		if (result) {
			mav.addObject("list", dao.list());  // list를 읽어서 줌 -> html 화면에서 정보를 받아오는데 성공하면 리스트를 항상 보여줌
		} else {
			mav.addObject("msg", "글 등록에 실패했습니다.");
			// 글자수는 10글자로 제한해뒀으므로 10자를 초과하면 에러 발생
		}
		mav.setViewName("visitorView");
		return mav;
	}
	
	@RequestMapping(value = "/vupdate", 
            method = RequestMethod.POST)   // update -> POST 방식의 요청 수행
	public ModelAndView update(VisitorDTO vo) {
		boolean result = dao.update(vo);
		ModelAndView mav = new ModelAndView();
		if (result) {
			mav.addObject("list", dao.list());
		} else {
			mav.addObject("msg", "글 수정에 실패했습니다.");
		}
		mav.setViewName("visitorView");
		return mav;
	}
}



