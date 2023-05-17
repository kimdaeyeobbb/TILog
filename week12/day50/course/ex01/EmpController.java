package springjpa.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;   // pagereuqest에 대해 알고싶을 떄 얘를 복사해서 구글링하면 됨 -> 오버라이딩된 메서드를 확인할 수 있음.
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;  // 패키지를 읽어보면 누가 제공하는지 알 수 있음. RequiredArgsConstructor는 Lombock이 제공하는 거구나!
import springjpa.exam.entity.Emp;
import springjpa.exam.repository.EmpRepository;

@Controller  // 컨트롤러 역할의 빈이라는 것을 정의
@RequiredArgsConstructor
// 생성자를 직접 구현하지 않고 lombock이 처리. constructor를 자동으로 만들어 달라는 것. 클래스가 가진 멤버변수 중 초기화를 요구하는 멤버변수인데, final형으로 정의된 멤버변수가 있으면 이 멤버변수를 초기화하는 생성자를 자동으로 만들어달라는 것
// final형 멤버변수가 없다면 반드시 전달해야하는 필드의 클래스가 아님. final형 멤버변수는 생성자를 통해서만 초기화가 가능함. 멤버변수가 final형이어야만 자동으로 초기화해주는 역할의 생성자를 자동으로 넣어준다.

public class EmpController {
	// 컨트롤러 클래스는 다이렉트로 repository를 사용하고 있음 (service를 거치지 않음)
	// emprepository는 직접 구현만 메서드가 하나도 없고 모두 상속받음.

	//	@Autowired
	private final EmpRepository dao;

	@GetMapping("/countnum") // 수정
	public ModelAndView count() {

		ModelAndView mav = new ModelAndView();
		long num = dao.count();
		mav.addObject("num", num);
		mav.setViewName("empResult");
		return mav;
	}

	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<Emp> list = dao.findAll();

		list.parallelStream().forEach(System.out::println);  // 출력

		mav.addObject("list", list);
		mav.setViewName("empResult");
		return mav;
	}

	// http://localhost:8088/part -> 에러
	// http://localhost:8088/part?page=1&size=2 -> 이런식으로 요청해야 함
	// 사이즈값을 몇개의 page로 나눌것인지를 지정해야 함
	// size=3 -> 한 페이지에 데이터가 3개 -> 다섯개의 페이지가 나올것임
	// size=2 -> 7페이지가 됨
	@GetMapping("/part") // part 테스트하려면 쿼리 문자열을 줘야함 (int형 매개변수를 2개 주고 있으므로)
	public ModelAndView part(int page, int size) {
		ModelAndView mav = new ModelAndView();
		PageRequest pageRequest = PageRequest.of(page, size);  // 사이즈정보로 몇개로 나눌것인지를 설정
		Page<Emp> pageObj = dao.findAll(pageRequest);
		List<Emp> list = pageObj.toList();
		mav.setViewName("empResult");
		mav.addObject("list", list);
		return mav;
	}

	// http://localhost:8088/partsal?page=1&size=9 -> 한 페이지당 9개를 보여주겠다는것. 여기서는 0페이지와 1페이지가 있는 것임. 따라서 0페이지에서는 9개 1페이지에서는 나머지 5개가 나온것
	@GetMapping("/partsal")
	public ModelAndView partsal(int page, int size) {
		ModelAndView mav = new ModelAndView();
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by("sal").descending()); // salary 기준으로 내림차순 정렬
		Page<Emp> pageObj = dao.findAll(pageRequest);
		List<Emp> list = pageObj.toList();
		mav.setViewName("empResult");
		mav.addObject("list", list);
		return mav;
	}

	@GetMapping("/parthiredate")
	public ModelAndView parthiredate(int page, int size) {
		ModelAndView mav = new ModelAndView();
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by("hiredate"));
		Page<Emp> pageObj = dao.findAll(pageRequest);
		List<Emp> list = pageObj.toList();
		mav.setViewName("empResult");
		mav.addObject("list", list);
		return mav;
	}

}


