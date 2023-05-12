package week11.day46.course.ex01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j // 얘를 정의하면 log를 쓸 수 있는 객체가 자동으로 추가됨. 따라서 log라는 이름의 변수만 사용해도 됨. 이게 없으면 log 객체를 직접 생성해야 함
public class LogTestController1 {
	@RequestMapping("/log1")
	public ModelAndView xxx(HttpServletRequest req){
		log.error("error-로그를 테스트합니다!");
		log.warn("warn-로그를 테스트합니다!");
		log.info("info-로그를 테스트합니다!");
		log.debug("debug-로그를 테스트합니다!");
		log.trace("trace-로그를 테스트합니다!");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("logView");
		mav.addObject("msg", "톰캣콘솔창에서 확인하세요!!");
		return mav;
	}
}




