package com.example.springedu.controller;
import java.io.IOException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.springedu.service.FriendNotFoundException;
import com.example.springedu.service.FriendService;
import com.example.springedu.domain.FriendDTO;

// http://localhost:8088/exceptionTest?num=10 꼴로 입력해서 확인

@Controller
public class ExceptionLocalController {
	@Autowired  // @Autowired 설정을 하여
	FriendService ms; // service 패키지 내의 FriendService 객체를 자동으로 주입받게 만듦

	@RequestMapping("/exceptionTest")  // RequestMapping으로 요청하였을 때 detail을 호출
	public String detail(int num, Model model) throws FriendNotFoundException {
		// int num -> 쿼리 문자열을 통해서 받으려고 함 -> num=1의 꼴처럼 입력 -> 얘를 안주면 에러 발생
		// model 객체 -> 수행 결과를 담을 용도로 받음
		FriendDTO vo = ms.get(num);
		if (vo == null) {
			throw new FriendNotFoundException();  // 직접 예외 발생시킴.
		}
		model.addAttribute("friend", vo);  // friend라는 이름으로 등록
		return "friendView";  // view 에게 전달
	}


	// http://localhost:8088/exceptionTest?num=ten 꼴로 입력해서 확인
	// 이 컨트롤러가 클라이언트로부터 요청이 되었을 때 TypeMismatchException이 발생하면 이 메서드를 수행하라는 것
	@ExceptionHandler(TypeMismatchException.class)  // 타입이맞지 않은 exception에 대한 클래스 정보를 담고 있는 메서드
	// TypeMismatchException.class -> 이 클래스에 대한 클래스 객체가 됨 ( TypeMismatchException 정보를 담고있는 java.lang의 클래스 객체)
	public ModelAndView handleTypeMismatchException(TypeMismatchException ex) {  // exception 객체정보를 매개변수로 받음
		System.out.println("TypeMismatchException 발생시 처리하는 핸들러가 오류 처리합니다.");
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "타입을 맞춰주세용!!");
		mav.setViewName("errorPage");  // errorPage.html이 존재해야 함
		return mav;
	}

	// http://localhost:8088/exceptionTest?num=100로 입력해서 확인
	// 이 컨트롤러가 클라이언트로부터 요청이 되었을 때 FriendNotFoundException이 발생하면 이 메서드를 수행하라는 것
	@ExceptionHandler(FriendNotFoundException.class)
	public String handleNotFoundException() throws IOException {  // 매개변수 받을것이 없으므로 비워놓음
		System.out.println("FriendNotFoundException 발생시 처리하는 핸들러가 오류 처리합니다.");
		return "noFriend";
	}

	// http://localhost:8088/exceptionTest 로 입력해서 확인
	// 이 컨트롤러가 클라이언트로부터 요청이 되었을 때 IIllegalStateException가 발생하면 이 메서드를 수행하라는 것
	@ExceptionHandler(IllegalStateException.class)
	public ModelAndView handleIllegalStateException() throws IOException {
		System.out.println("IllegalStateException 발생시 처리하는 핸들러가 오류 처리합니다.");
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "num=숫자 형식의 쿼리를 전달하세요!!");
		mav.setViewName("errorPage");
		return mav;
	}
}
