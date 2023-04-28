package week09.day38.course.ex2;

import lombok.Data;

@Data // 롬복에서 @Data 사용시 -> 정해져있는 몇가지의 설정을 적용해서 자동으로 생성해줌.
// @Data를 주면 setter, getter, toString, requiredArgsConstructor 등이 자동으로 생성도미
public class VisitorDTO {
	int id;
	String name;
	String writedate;
	String memo;
}