package day0321.course;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

class Value {
	int value;  // 멤버변수

	Value(int value) {  // 생성자 메서드 (value 멤버변수 초기화)
		this.value = value;
	}

	// equlas() 메서드를 오버라이딩
	public boolean equals(Object obj){

		boolean result = false;
		if(obj != null && obj instanceof Value){
			if(value == ((Value) obj).value){
				// 기본형이니까 등가형산으로 비교하면 됨
				result = true;
			}
		}
		return result;
	}

	/* toString 오버라이딩 */
	@Override
	public String toString() {
		return "Value [value=" + value + "]";
	}

	/* 해시코드 오버라이딩 */
	@Override
	public int hashCode() {
		return Objects.hash(value);
		// Object의 hash 메서드 - 인자값을 가지고 계산 후 해시값을 리턴
		// 가변형 인자임
	}
}

public class EqualsTest3 {
	public static void main(String[] args) {
		// value 클래스 객체 3개를 초기화함
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		Value v3 = new Value(20);

		/* equals 수행 - Object에 있는 equals가 대신 호출됨. (등가연산과 동일 - 하나의 객체를 공유하는지를 따짐. 객체의 내용을 비교하지 않음)*/
		// 아래의 것들은 각각의 객체를 가지므로 모두 false
		// Value v2 = v1;이라고 기재되어있었으면 v1.equals(v2)가 true임
		// v1,v2,v3는 모두 각각의 Value 객체임
		System.out.println(v1.equals(null));
		System.out.println(v1.equals(v3)); 
		System.out.println(v1.equals(v2)); 
		System.out.println(v1.equals(new Date()));

		/* HashSet 객체에 v1,v2,v3 를 저장한 다음 저장한 객체를 출력해보자. */
		HashSet<Value> set = new HashSet<>();
		set.add(v1);
		set.add(v2);
		set.add(v3);

		System.out.println(v1.hashCode());  // v1이 참조하는 Value 객체에 대한 hashCode
		System.out.println(v2.hashCode());  // v2가 참조하는 Value 객체에 대한 hashCode
		System.out.println(v3.hashCode());  // v3가 참조하는 Value 객체에 대한 hashCode
		// HashCode - 동일한 내용이 들어가있는지 판단하기 위해서 사용
		// 객체의 내용을 비교해야하는 상황에서 HashCode가 동일한지를 먼저 판단 후 처리
		// 같은 내용의 객체는 해시코드값이 같도록 오버라이딩 해주는 작업 수행
		// 객체가 생성될떄 부여된 고유의 각 객체의 참조값을 10진수로 리턴


		// HashCode가 동일하면 equals로 넘어가고 equals까지 같으면 같은 것으로 판단

		System.out.println(set);

		for (Value data: set) {
			System.out.println(data);
		}



//		if (v1.equals(v2))
//			System.out.println("v1과 v2는 같습니다.");
//		else
//			System.out.println("v1과 v2는 다릅니다.");
//		v2 = v1;  // 두 참조변수가 하나의 객체를 공유하게 됨
//		if (v1.equals(v2))
//			System.out.println("v1과 v2는 같습니다.");
//		else
//			System.out.println("v1과 v2는 다릅니다.");
	}
}
