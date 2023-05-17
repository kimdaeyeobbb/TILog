package springjpa.exam.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import springjpa.exam.entity.Meeting;
import springjpa.exam.entity.Reply;
import springjpa.exam.repository.MeetingRepository;
import springjpa.exam.repository.ReplyRepository;

// http://localhost:8088/meeting 으로 확인
@Controller
public class MeetingController  {

	/* 얘네는 field injection */
	@Autowired  // 객체를 찾아와서 알아서 주입해줌 -> 안그러면 객체를 생성해서 써야함
			MeetingRepository repositoryM;
	@Autowired
	ReplyRepository repositoryR;
	@GetMapping("/meeting")
	public ModelAndView list() {
		List<Meeting> list = repositoryM.findAll();
		ModelAndView mav = new ModelAndView();
		if (list.size() != 0) {
			mav.addObject("list", list);
		} else {
			mav.addObject("msg", "추출된 결과가 없어요");
		}
		mav.setViewName("meetingView");
		return mav;
	}

	@GetMapping("/meeting/search")
	public ModelAndView search(String keyword) {
		List<Meeting> list = repositoryM.findByTitleContains(keyword);
		ModelAndView mav = new ModelAndView();
		if (list.size() != 0) {
			mav.addObject("list", list);
			mav.addObject("button", "메인화면으로");
		} else {
			mav.addObject("msg", "추출된 결과가 없어요");
		}
		mav.setViewName("meetingView");
		return mav;
	}

	@GetMapping("/meeting/searchname")
	public ModelAndView searchName(String name) {
		List<Meeting> list = repositoryM.findByName(name);
		ModelAndView mav = new ModelAndView();
		if (list.size() != 0) {
			mav.addObject("list", list);
			mav.addObject("button", "메인화면으로");
		} else {
			mav.addObject("msg", "추출된 결과가 없어요");
		}
		mav.setViewName("meetingView");
		return mav;
	}

	@GetMapping("/meeting/delete")
	@Transactional
	public ModelAndView delete(int id) {
		ModelAndView mav = new ModelAndView();
		try {
			repositoryM.deleteById(id);
			mav.addObject("list", repositoryM.findAll());
		} catch(Exception e) {
			mav.addObject("msg", "삭제를 처리하는 동안 오류 발생");
		}
		mav.setViewName("meetingView");
		return mav;
	}

	@GetMapping(value ="/meeting/one", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Meeting one(int id) {
		Meeting vo = repositoryM.findById(id).get();
		return vo;
	}

	@PostMapping("/meeting/insert")
	@Transactional
	public ModelAndView insert(Meeting vo) {
		System.out.println(vo);
		ModelAndView mav = new ModelAndView();
		try {
			repositoryM.save(vo);
			mav.addObject("list", repositoryM.findAll());
		} catch(Exception e) {
			mav.addObject("msg", "글 작성을 처리하는 동안 오류 발생");
		}
		mav.setViewName("meetingView");
		return mav;
	}

	@PostMapping("/meeting/update")
	@Transactional
	public ModelAndView update(Meeting vo) { // 클라이언트로부터 meeting 객체가 가진 필드와 똑같은 이름의 엔티티 객체가 와서 세팅됨.
		ModelAndView mav = new ModelAndView();
		try {
			Meeting oldvo = repositoryM.findById(vo.getId()).get();  // findbyid는 Optional객체를 반환하므로 get 메서드를 호출해야 내부에 포장된 객체를 꺼내올 수 있음
			oldvo.setName(vo.getName());
			oldvo.setTitle(vo.getTitle());
			oldvo.setMeetingDate(vo.getMeetingDate());
			mav.addObject("list", repositoryM.findAll());
		} catch(Exception e) {
			mav.addObject("msg", "글 작성을 수정하는 동안 오류 발생");
		}
		mav.setViewName("meetingView");
		return mav;
	}

	@GetMapping(value="/meeting/ireply", produces = "application/json; charset=utf-8")
	@ResponseBody
	@Transactional
	public String insert_reply(String name, String content, int refid) {

		Meeting mainWriting = repositoryM.findById(refid).get();
		Reply vo = new Reply();
		vo.setName(name);
		vo.setContent(content);
		vo.setRefid(mainWriting);
		try {
			repositoryR.save(vo);
			return "{ \"result\": true }";
		} catch(Exception e) {
			return "{ \"result\": false }";
		}
	}

	@GetMapping(value="/meeting/lreply", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<Reply> list_reply(int refid) {
		Meeting mainWriting = repositoryM.findById(refid).get();
		List<Reply> list = repositoryR.findByRefid(mainWriting);
		return list;
	}
}
