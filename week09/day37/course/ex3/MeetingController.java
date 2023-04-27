package com.example.springedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.springedu.dao.MeetingMyBatisDAO;
import com.example.springedu.domain.MeetingDTO;
import com.example.springedu.domain.ReplyVO;
@Controller
public class MeetingController  {
	@Autowired
	MeetingMyBatisDAO dao;
	@GetMapping("/meeting")
	public ModelAndView list() {
		List<MeetingDTO> list = dao.listM();
		ModelAndView mav = new ModelAndView();
		if (list.size() != 0) {
			mav.addObject("list", list);  // 추출된 미팅 리스트 객체 정보 전달
		} else {
			mav.addObject("msg", "추출된 결과가 없어요");
		}
		mav.setViewName("meetingView");
		return mav;
	}

	@GetMapping("/meeting/search")
	public ModelAndView search(String keyword) {  // 쿼리 문자열을 통해 검색어를 전달받음
		List<MeetingDTO> list = dao.searchM1(keyword);
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
	public ModelAndView searchName(String name) {  // 쿼리문자열로 미팅글의 이름을 전달받음
		List<MeetingDTO> list = dao.searchM2(name);
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
	public ModelAndView delete(int id) {  // 쿼리문자열로 id를 전달받음
		boolean result = dao.deleteM(id);
		ModelAndView mav = new ModelAndView();
		if (result) {
			mav.addObject("list", dao.listM());
		} else {
			mav.addObject("msg", "삭제를 처리하는 동안 오류 발생");
		}
		mav.setViewName("meetingView");
		return mav;
	}
//
//	@GetMapping(value ="/meeting/one", produces = "application/json; charset=utf-8")
//	@ResponseBody
//	public MeetingDTO one(int id) {
//		MeetingDTO vo = dao.oneM();
//		return vo;
//	}

	@PostMapping("/meeting/insert")
	public ModelAndView insert(MeetingDTO vo) {
		boolean result = dao.insertM(vo);
		ModelAndView mav = new ModelAndView();
		if (result) {
			mav.addObject("list", dao.listM());
		} else {
			mav.addObject("msg", "글 작성을 처리하는 동안 오류 발생");
		}
		mav.setViewName("meetingView");
		return mav;
	}

	@PostMapping("/meeting/update")
	public ModelAndView update(MeetingDTO vo) {
		boolean result = dao.updateM(vo);
		ModelAndView mav = new ModelAndView();
		if (result) {
			mav.addObject("list", dao.listM());
		} else {
			mav.addObject("msg", "글 수정을 처리하는 동안 오류 발생");
		}
		mav.setViewName("meetingView");
		return mav;
	}

	// 댓글 처리는 AJAX로 처리함
	@GetMapping(value="/meeting/ireply", produces = "application/json; charset=utf-8")  // ireply -> 댓글 insert 요청
	@ResponseBody  // 템플릿을 거치지않으므로 추가로 써주어야 함
	public String insert_reply(ReplyVO vo) {
		boolean result = dao.insertReply(vo);
		// dao -> 성공시 TRUE 리턴, 실패라면  FALSE
		String jsonStr;
		if (result) {
			jsonStr = "{ \"result\": true }";   // 한쌍의 문자열로 구성되었다면 json으로 만들어도됨
			// \"result\" ->  이름은 반드시 문자열이어야함. true -> value는 반드시 문자열이 아니어도 됨
		} else {
			jsonStr = "{ \"result\": false }";
		}
		return  jsonStr;
	}

	/* AJAX 요청 */
	@GetMapping(value="/meeting/lreply", produces = "application/json; charset=utf-8")
	@ResponseBody  // 템플릿을 거치지않으므로 추가로 써주어야 함
	public List<ReplyVO> list_reply(int refid) { // ReplyVO의 리스트 객체
		// JSON 문서도 얼마든지 ARRAY로 만들 수 있음
		// JSON을 ARRAY형식으로 전달시 전체 JSON 내용이 대괄호로 전달될 것임
		List<ReplyVO> list = dao.listReply(refid);
		return list;
	}
}

// restcontroller를 안쓴이유? -> 템플릿을 거쳐야하는 경우 사용할 수 없음
// restcontroller를 사용하면 -> 해당 클래스 내의 모든 컨트롤 메서드들이 restcontroller의 영향을 받음 -> 템플릿을 거치지 않고 직접 응답하게 됨