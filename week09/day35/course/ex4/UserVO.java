package week09.day35.course.ex4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class UserVO {
	private String userName;
	private String address;
	private String[] favoriteFruit;
}
