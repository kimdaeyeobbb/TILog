package week08.day32.course.sample3;

public class UserVo {
	private String userName;

	public UserVo(String userName) {
		super();
		this.userName = userName;
	// 유저명을 받아서 private형 멤버변수에 세팅
		System.out.println("UserVO Constructor Call");
	}

	public String getUserName() {
		return userName;
	}
}
