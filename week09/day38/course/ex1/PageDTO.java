package week09.day38.course.ex1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PageDTO {
	// DB마다 start만 주기도, start & end를 주기도, start&end&count를 주기도 함. 여러가지 선택권을 주기 위해서 멤버변수 설정
	private int startNum;
	private int endNum;
	private int countNum;
}
