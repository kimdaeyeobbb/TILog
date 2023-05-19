package springrest.exam.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springrest.exam.dto.MemberDTO;


// post 방식이므로 요청방식에 소스를 맞춰서 작성
@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample(){
        return "안녕? POST 방식 요청 했네~~~";
    }

    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        // get방식이 아닌 post 방식일 떄에는 요청파라미터라고 부름. (name * value쌍으로 전달됨 -> map객체로 받았음)
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {  // Post 방식일떄에는 request body에 담겨서 전달됨. -> 매개변수 앞에 @requestbody를 붙일 것.
            // 요청 방식은 json 객체로 넘겨주는 것이 원래는 defualt. (json내에서는 단일인용부호쓰면 안되고 더블인용부호를 써야함)
            // post 방식일떄에는 요청 파라미터가 요청 바디 안에 들어가야 함
            sb.append(map.getKey() + " : " + map.getValue() + "\n");  // 맵 객체를 가지고 하나의 문자열을 만들어서 리턴
        });

        return sb.toString();
    }

    // post는 클라이언트로부터 전송된 내용을 서버 어딘가에 보관해둠
    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDTO memberDTO) {
        return memberDTO.toString();
    }
}
