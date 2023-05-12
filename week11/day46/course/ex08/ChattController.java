package week11.day46.course.ex08;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChattController {
	
	@RequestMapping("/chattstart")
	public ModelAndView chatt() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chatting");
		return mv;
	}

}
