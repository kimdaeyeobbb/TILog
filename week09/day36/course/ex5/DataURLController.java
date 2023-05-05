package week09.day36.course.ex5;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileReader;

@RestController   // 해당 클래스가 RESTful 웹 서비스를 제공하는 컨트롤러임을 나타냄
public class DataURLController {
	@RequestMapping(value = "/dataurl", produces="text/plain; charset=US-ASCII")
	// 요청 URL과 해당 URL을 처리하는 메서드를 매핑하는 역할을 함
	// value 속성은 요청 URL을, produces 속성은 응답으로 반환할 데이터의 형식과 문자 인코딩을 지정함
	public String getDataURL() {  // /dataurl 요청 URL을 처리하는 getDataURL() 메서드
		char[] content = null;
		File f = new File("c:/uploadtest/test.png");
		if (f.exists() && f.length() > 0) {
			content = new char[(int)f.length()];
			try (FileReader reader = new FileReader("c:/uploadtest/test.png");) {
				reader.read(content);
				// FileReader를 사용하여 파일의 내용을 읽어옴
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new String(content);  // 읽어온 내용을 문자열로 변환하여 반환함
	}
}
/* /dataurl 요청 URL을 호출하면 c:/uploadtest/test.png 파일의 내용을 반환하는 RESTful 웹 서비스를 제공함 */