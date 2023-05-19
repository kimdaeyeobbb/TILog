package springrest.exam.controller;

//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
import java.nio.charset.Charset;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.hateoas.EntityModel;
import springrest.exam.dto.MemberDTO;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/restapi")
@Slf4j
public class GetController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        log.info("getHello 메소드가 호출되었습니다.");
        return "안녕하세요?";
    }
    @GetMapping(value = "/name")
    public String getName() {
        log.info("getName 메소드가 호출되었습니다.");
        return "둘리";
    }
    @GetMapping(value = "/var1/{variable}")   // path variable이용해서 지정한 내용 테스트
    public String getVariable1(@PathVariable String variable) {
        log.info("@PathVariable을 통해 들어온 값 : {}", variable);
        return variable;
    }
    @GetMapping(value = "/var2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }


    // http://localhost:8088/restapi/req1로 요청시 null, null, null이 응답됨. 매개변수중 int형이 있었다면 에러가 났을 것임.
    // http://localhost:8088/restapi/req1?name=DANNY&email=ace@daum.net&phone=010-7777-1010 처럼 요청해야 정상적으로 동작함
    @GetMapping(value = "/req1")   // req1 테스트시 선언된 매개변수에 맞춰서 쿼리문자열을 줘야함.
    public String getRequestParam1(String name, String email, String phone) {
        return name + " " + email + " " + phone;
    }

    // http://localhost:8088/restapi/req2?productname=자바의정석&price=35000 처럼 요청
    @GetMapping(value = "/req2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        // 전달받을 쿼리가 여러개인 경우 매개변수 여러개를 선언하는 것과 DTO를 이용할수도 있지만 MAP객체를 이용할수도 있음. 쿼리 파라미터는 기본적으로 name&value쌍으로 전달됨
        // key & name value를 추출하여 처리
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();  // toString한 결과를 body 내용으로 클라이언트에게 응답하고 있음
    }

    // http://localhost:8088/restapi/req3?name=둘리&email=ace@daum.net&phone=010-1111-2222 꼴로 확인
    @GetMapping(value = "/req3")
    public String getRequestParam3(MemberDTO memberDTO) {  // 매개변수가 DTO ->  memberDTO 클래스들의 멤버변수 사양부터 확인할 것
        return memberDTO.toString();
        // 읃답되는 content type - text/plain (dto를 string으로 변환하였으므로)
    }


    // http://localhost:8088/restapi/req4 꼴로 확인 -> response type이 json
    // 도메인객체로 리턴하면 default가 Json임 (content type ->  applicaiont/hal+json)
    @GetMapping(value = "/req4")  // dto 객체를 리턴하고 있음
    public MemberDTO getRequestParam4(MemberDTO memberDTO) {
        return memberDTO;
    }

    // http://localhost:8088/restapi/req5?name=고길동
    @GetMapping(value = "/req5")
    public ResponseEntity getRequestParam5(String name) {
        // 이메일과 핸드폰은 알아서 dto 설정해서 리턴
        MemberDTO dto = new MemberDTO();
        dto.setName(name);
        dto.setEmail("aaa@naver.com");
        dto.setPhone("010-3333-4444");

        /* 응답헤더 설정 */
        HttpHeaders header = new HttpHeaders();
        //header. // 응답헤더에 들어갈 수 있는 key&value쌍에 관련된 메서드
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        // content type 설정에 특화된 메서드
        // 공식적으로 정해놓은 key가 아닐 경우에 setheader를 사용

        return new ResponseEntity<>(dto, header, HttpStatus.OK);
        // 세번쨰인자 - HttpStatus.OK => 성공했다는 200 응답코드를 리턴하겠다는 것
        // 201 -> 만들었다는 뜻. (~할 때 200보다 적합)
        // 404 -> 클라이언트가 요청한 자원이 없다는 것. (클라이언트가 요청한 컨트롤러가 없는것인지, 클라이언트가 요청한 데이터가 없는 것인지 등을 이것만으로 알기 어려우므로 이에 대한 추가적인 response header가 있으면 좋음)
    }

    @GetMapping(value = "/req6")
    public ResponseEntity<MemberDTO> getRequestParam6() {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("unico");
        memberDTO.setEmail("unicodaum@hanmail.net");
        memberDTO.setPhone("010-1111-2222");

        WebMvcLinkBuilder linkTo = linkTo(methodOn(GetController.class).getRequestParam6());
        return new ResponseEntity<>(memberDTO.add( linkTo.withSelfRel()), HttpStatus.OK);
    }
}
