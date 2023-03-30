package day12.course;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Person implements Comparable<Person> {
	// Person 객체는 제네릭 구문을 적용하여 만들어짐
	// 비교할 대상 객체에 대한 정보를 타입 파라미터로 지정함
	// 타입 파라미터를 지정해야하는 경우 제네릭 타입의 클래스, 제네릭 타입의 인터페이스라고 함.

	public String name;
	public int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		// 기준 객체인 age.
	}

	@Override
	public int compareTo(Person o) {
		// Person이 compareTo를 멤버로 가짐
		// 메서드 오버라이딩
		// Person 객체끼리의 비교하는 것이므로 자기 자신의 타입과 똑같게 지정

		// Person 객체는 나이로 비교
		// 나이가 작으면 더 작은 객체로 지정. 크면 더 큰 객체로 지정.
		if(age<o.age) return -1;
		else if(age == o.age) return 0;
		else return 1;
	}

	@Override
	public String toString() {		
		return name+"("+age+")";
	}	
}

public class CollectionSort2 {
	public static void main(String[] args) {
		List<Person> list = new LinkedList<>();
		// Person 객체를 보관하는 LinkedList

		
		for(int i=1; i <= 10; i++) {
			list.add(new Person("duke"+i, new Random().nextInt(30)));
		}

		System.out.println(list);
		
		Collections.sort(list);
		// 위에 implements 부분 지우면 에러메시지 나옴 -> 직접 확인할 것
		//

		System.out.println("\nlist의 데이터들을 오름차순으로 소팅한 결과 : " + list);	
		Collections.reverse(list);
		System.out.println("\nlist의 데이터들을 내림차순으로 소팅한 결과 : " + list);		
	}
}
