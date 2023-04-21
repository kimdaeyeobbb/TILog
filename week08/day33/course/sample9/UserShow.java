package week08.day33.course.sample9;

public class UserShow {
	private User user;
	// user 객체를 인자로 받음

	//얘는 인자가 없으므로 주입받는 애를 호출하지 않음
	public UserShow() {		
		super();
		System.out.println("UserShow 객체 생성(no-args)");
	}

	// 마지막은 얘가 호출됨
	// 주입받는 얘가 호출됨.
	public UserShow(User user) {
		super();
		this.user = user;
		System.out.println("UserShow 객체 생성(User 객체 전달)");
	}


//	user1 => 매개변수명이아닌 user 라는 이름으로 만들어진 객체를 세팅
//	byName => 이름으로 찾음
//	byType => 타입으로 찾음
	// 2,3번째 모두 얘가 호출됨.
	public void setUser(User user1) {
		System.out.println("UserShow 객체의 setUser() 호출(User 객체 전달)");
		this.user = user1;
	}

	@Override
	public String toString() {
		return "UserShow [user=" + user + "]";
	}

}
