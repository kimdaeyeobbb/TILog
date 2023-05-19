package springrest.exam.controller;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springrest.exam.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/put-api")  // 클래스에 request mapping
public class PutController {
    // post와 put은 요청 바디안에 서버에게 전송할 요청 파라미터가 들어가는점은 동일.
    /// put은 이미 기존에 저장되어있고 만들어져있던 애를 변경하는 요청으로 처리함 (post는 이와달리 새로 생성)

    // http://localhost:8088/api/v1/put-api/default 꼴로 확인
    // 프로젝트 시에는 ajax로 요청
    @PutMapping(value = "/default")
    public String putMethod() {
        return "안녕? PUT 방식 요청 했네~~~";
    }

    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @PutMapping(value = "/member1")
    public String postMemberDto1(@RequestBody MemberDTO memberDto) {
        return memberDto.toString();
    }


    @PutMapping(value = "/member2")
    public MemberDTO postMemberDto2(@RequestBody MemberDTO memberDto) {
        return memberDto;
    }

    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDTO> postMemberDto3(@RequestBody MemberDTO memberDto) {
        return ResponseEntity // static 메서드로 객체 생서ㅐㅇ
                .status(HttpStatus.ACCEPTED)  // 응답 상태코드를 acceptec -> 201 (변경했다는 의미. 원래는 변경상태 성공이라는 상태코드는 없음.)
                .body(memberDto);
        // status, body를 이용하여 응답값 처리
    }
}