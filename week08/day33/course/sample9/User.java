package week08.day33.course.sample9;

public class User {
	// setter injection 사용
	private String name;
	private int age;	
	private String hobby;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getHobby() {
		return hobby;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", hobby=" + hobby + "]";
	}
}