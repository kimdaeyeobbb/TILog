package day0321.course;

class Member2 {
	private int id;
	private String name;
	private String password;

	Member2(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	/* equals 오버라이딩 */
	public boolean equals(Object o) {
		if (this == o)
			// 멤버 객체의 자기자신과 매개변수 값이 같은지를 비교
			return true;
		if (o != null && o instanceof Member2) {
			// 매개변수로 전달된 객체가 Member2 타입인지 확인
			// 부모 유형으로 자식 객체를 받음. 자식형으로 변환에서 접근해야 함.
			// 자식 멤버가 여러명인경우 자식형으로 변환해서 접근해야함.
			// 조상형에서 자손형으로 대입하는것이므로 형변환해야 함
			Member2 m = (Member2) o;
			if (id == m.id && name.equals(m.name) && password.equals(m.password))
				// id와 이름, 비밀번호 모두가 같아야 같은 객체로 보겠다는 것
				// Object의 equals는 등가연산과 동일함
				return true;
		}
		return false;
	}
}

public class ObjectTest2 {
	public static void main(String args[]) {
		Member2 obj1 = new Member2(10, "자바", "duke");
		Member2 obj2 = new Member2(10, "자바", "duke");
		Member2 obj3 = new Member2(20, "자바", "duke");
		System.out.println(obj1.equals(obj2));
		System.out.println(obj1 == obj2);
		System.out.println(obj1.equals(null));
		System.out.println(obj1.equals(new java.util.Date()));
		System.out.println(obj1.equals(obj3));
	}
}
