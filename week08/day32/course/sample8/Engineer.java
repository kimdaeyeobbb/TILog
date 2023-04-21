package week08.day32.course.sample8;

public class Engineer{

//	상속 관계가 아닌 포함관계임을 잘 알아둘 것
	// 포함관계 - 다른 클래스의 기능을 이 클래스가 필요로 할 때
	private Emp emp;
	private String dept;

	/* 생성자 */
	public Engineer() {
		super();
	}

	public Engineer(Emp emp, String dept) {
		super();
		this.emp = emp;
		this.dept = dept;
	// 생성자를 통해 겍체 초기화
	}

	@Override
	public String toString() {
		return emp.toString() + " Department : " + dept;
	}
}
