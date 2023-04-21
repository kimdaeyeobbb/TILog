package week08.day33.course;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 컨트롤러 역할로서의 bean
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model){   // hello -> 클라이언트로부터 요청을 받아서 수행하는 핸들러 메서드
        System.out.println("맨 처음 스프링 부트 테스트~~!");
        model.addAttribute("data","Spring Boot!");  // data라는 이름으로 Spring Boot 라는 값을 출력
        return "hello";   // 리턴값이 문자열 -> 응답하게 될 뷰를 지정 (응답은 컨트롤러가 아닌 뷰가함. 이름이 hello인 뷰를 리턴하는 것)
        // 이름이 hello인 뷰를 이용해서 응답하는 것
    }
}
