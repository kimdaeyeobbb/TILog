package day12.course;

import java.util.HashSet;
import java.util.Objects;


class Member3 {
	private int id;
	private String name;
	private String password;

	Member3(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o != null && o instanceof Member3) {
			Member3 m = (Member3) o;
			if (id == m.id && name.equals(m.name) && password.equals(m.password))
				return true;
		}
		return false;
	}

	public String toString() {
		return "(" + id + ":" + name + ":" + password + ")";
	}

	public int hashCode() {
		return Objects.hash(id, name, password);
		// 가변형 인자
		// id, password만 비교할 거면 name은 빼면 됨
		// id와 name, password가 같으면 같은 해시코드를 리턴하게 만듦
	}
}

public class ObjectTest3 {
	public static void main(String args[]) {
		Member3 obj1 = new Member3(10, "자바", "duke");
		Member3 obj2 = new Member3(10, "자바", "duke");
		Member3 obj3 = new Member3(20, "자바", "duke");
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode()); // 위와 같은 해시코드를 가짐
		System.out.println(obj3.hashCode());
		HashSet<Member3> set = new HashSet<>();
		System.out.println(set.add(obj1));
		System.out.println(set.add(obj2));
		System.out.println(set.add(obj3));
		System.out.println("저장된 데이터의 갯수 : " + set.size());
		// 사이즈 2 -> 같은 내용인 key가 이미 들어가있으면 추가하지 않으므로 (value는 동일한 것이 들어갈 수 있음. key는 동일한 것이 들어갈 수 없음)
		// 이떄도 equals와 hashCode 사용
		System.out.println(set);
	}
}
