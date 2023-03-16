package day0316.course;

class MySingleton {
	 // 클래스가 메모리에 올라갈 때 (클래스가 로딩될 때)

	// 메모리에 객체를 (미리) 생성하도록 만듦
	private static MySingleton obj = new MySingleton();
	private MySingleton() {		
	}

	// 미리 생성한 마이 싱글톤 객체를 리턴
	static MySingleton getMy() {
		return obj;
	}

	void printMyName() {
		System.out.println("유니코");	
	}
	void printFavoriteFood() {
		System.out.println("떡볶이");	
	}
}
public class MySingletonTest {
	public static void main(String[] args) {
		//MySingleton my = new MySingleton(); // error. Visible이 아님과 존재하지 않음은 다름
		MySingleton my = MySingleton.getMy();  // 이 클래스는 객체 생성을 위해 getMy() 메서드를 호출해야 함
		// 팩토리 메서드명은 뭘로 하든 상관없지만 일반적으로 `get인스턴스`라는 이름을 많이씀.
		// 혹은 create땡땡땡으로 작명함
		// MySingleton 객체가 생성된 후 리턴

		my.printMyName();
		my.printFavoriteFood();
		System.out.println(my);  // 전달된 객체의 toString 리턴값 (마이싱글톤이 toString이 없으므로 Object의 toString 호출)
		System.out.println(MySingleton.getMy());  // 마이싱글톤 객체를 달라고 함
		System.out.println(MySingleton.getMy());
	}
}
