package week08.day32.course.sample3;

public class UserServiceImpl implements UserService{

	// 생성자
	public UserServiceImpl() {
		super();
		System.out.println("UserService Constructor Call");
	}

	// addUser 메서드 오버라이딩
	@Override
	public void addUser(UserVo vo) {
		System.out.println("UserService : addUser() Method Call");
		System.out.println("NAME : " + vo.getUserName());
	}
}
