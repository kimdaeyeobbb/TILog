package week08.day33.course.sampleno5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("userService")  // 빈객체로 등록. userService라는 이름으로 객체 생성
public class UserServiceImpl implements UserService{
	@Autowired
	@Qualifier("myUser")  // myUser 이름으로 만들어진 User 객체를 주입받음
	User member;
	
	public void setMember(User member) {
		this.member = member;
		System.out.println("setMember() 기 호출될까요?");
	}

	@Override
	public void addUser() {
		System.out.println("Added member : " + member.getUserName());
	}
}

















