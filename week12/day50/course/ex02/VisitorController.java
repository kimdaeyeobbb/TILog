package springjpa.exam.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import springjpa.exam.entity.Visitor;
import springjpa.exam.repository.VisitorRepository;

// http://localhost:8088/visitormain.html 로 확인
@Controller
public class VisitorController {  // 기존의 컨트롤러와 큰 차이는 없음
	private VisitorRepository  repository; // 멤버변수에 어노테이션이 빠져있음

	/* 생성자 메서드 정의 */
	// 원래는 생성자 메서드에도 @Autowired를 써서 생성자 주입을 해야함. 생성자를 호출하면서 주입해준다.
	// 객체 생성하려면 전달해야하므로 어노테이션을 지정해주지 않아도, 생성자를 통해 생성 후 초기화하면 autowired를 생략할 수 있음
	// 즉, 여기서는 생성자를 통한 autowired를 수행한 것임
	public VisitorController(VisitorRepository repository) {
		this.repository = repository;
	}

	@RequestMapping("/vlist")
	public ModelAndView list() {
		List<Visitor> list = null;
		list = repository.findAll();
		ModelAndView mav = new ModelAndView();
		if (list.size() != 0) {
			mav.addObject("list", list);
		} else {
			mav.addObject("msg", "추출된 결과가 없어요");
		}
		mav.setViewName("visitorView");
		return mav;
	}

	@RequestMapping("/vsearch")
	public ModelAndView search(String key) {
		List<Visitor> list = null;
		//list = repository.findByMemoLike(key);
		list = repository.findByMemoContains(key);
		ModelAndView mav = new ModelAndView();
		if (list.size() != 0) {
			System.out.println(list);
			mav.addObject("list", list);
		} else {
			mav.addObject("msg", "추출된 결과가 없어요");
		}
		mav.setViewName("visitorView");
		return mav;
	}

	@RequestMapping(value = "/vdelete")
	@Transactional
	// dml명령에 해당되는 메서드를 호출할 때 transactional 어노테이션 사용 -> delete, update, insert 같은 dml sql명령이 필요할 때 해당 메서드에 transactional 삽입 -> 에러 발생시 롤백. 에러가 발생하지 않으면 정상적으로 수행됨
	// service를 만들떄에 transactional 어노테이션 붙임
	// read에는 붙이지 않음 (tranaction 상태가 아니어도 되기 떄문임)
	public ModelAndView delete(int id) {
		ModelAndView mav = new ModelAndView();
		try {
			repository.deleteById(id);
			mav.addObject("list", repository.findAll());
		} catch(Exception e) {
			mav.addObject("msg", "글 삭제에 실패했습니다.");
		}
		mav.setViewName("visitorView");
		return mav;
	}


	// 글 수정시 그 글만 받아오기 위해서 responsebody 어노테이션 사용. 템플릿을 거치지 않고 application/json형식으로 바로 응답하고 있음.
	@RequestMapping(value = "/one", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Visitor one(int id) {
		Optional<Visitor> result = repository.findById(id);
		// optional객체로 포장해서 리턴. 옵셔널 객체가 보관한 visitor 객체 리턴 -> visitor 객체를 꺼내서 사용하려면 get 메서드를 사용해야함
		// 엔티티 객체가 아닌 옵셔널 객체에 담아서 리턴.
		// 안에 있는 객체는 꺼내 줘야함.
		return result.get();		 // visitor 객체를 꺼내서 사용하려면 get 메서드를 사용해서 꺼내어 써야함
	}

	@RequestMapping(value = "/vinsert",
			method = RequestMethod.POST)
	@Transactional
	public String insert(Visitor vo, Model model) {
		try {
			repository.save(vo);
			return "redirect:/vlist";
		} catch(Exception e) {
			model.addAttribute("msg", "글 작성에 실패했습니다.");
		}
		return "visitorView";
	}

	@RequestMapping(value = "/vupdate",
			method = RequestMethod.POST)
	@Transactional
	public String update(Visitor vo, Model model) {
		try {
			Visitor entity = repository.findById(vo.getId()).get();
			entity.setName(vo.getName());
			entity.setMemo(vo.getMemo());
			return "redirect:/vlist";
		} catch(Exception e) {
			model.addAttribute("msg", "글 수정에 실패했습니다.");
		}
		return "visitorView";
	}
}



