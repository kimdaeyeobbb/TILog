_# Collection API

- import 해놓고 사용하지 않는 것이 있으면 warning error 발생
- 트리
  - 저장되는 값의 순서에 따라 정렬됨

- ArrayList, LinkedList
  - add되는 순서 유지

- HashSet
  - add 되는 순서를 유지하지 않음

- HashMap
  - add 되는 순서를 유지하지 않음
  - key를 가지고 데이터를 처리

## Collections (클래스)

- Collection API 들 (데이터들을 묶어서 쓰기위한 API들)
- 컬렉션 API들을 사용하는데 있어 여러 유용한 기능을 제공함
- Collections를 사용함으로서 Collection API의 기능을 다양하게 고려할 수 있음
- 컬렉션 객체의 공통된 기능을 모아 놓음


### java.util.Collections 메서드
- Collections 내부에 컬렉션 API와 관련된 유용한 메서드를 제공함
- 컬렉션 API를 도와주므로 인자를 받아서 이를 토대로 수행하므로 대부분 static형 메서드임\
- 다양한 collection 객체를 받아서 처리할 수 있게 구성되어 있음
- ex) addAll, binarySearch 등 

#### [CollectionSort](./CollectionSort.java)

```java
package day0321.course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionSort {
	public static void main(String[] args) {
		String[] array = { "JAVA", "SERVLET", "JDBC", "JSP", "RMI" };
		List<String> list = new ArrayList<String>();
		Collections.addAll(list, array);
		// addAll -> list에 array의 요소를 넣음

		System.out.println("list에 저장된 모든 데이터 : " + list);

		int index = Collections.binarySearch(list, "JDBC");
		// 주어진 collection 객체 안에 어떤 데이터가 존재하는지 인덱스를 읽어올 수 있음


		System.out.println("\"JDBC\" 가 저장된 위치 : " + index);

		String maxStr = Collections.max(list);
		String minStr = Collections.min(list);
		System.out.println("최대값:" + maxStr);
		System.out.println("최소값:" + minStr);

		Collections.sort(list);
		// sort - 해당 collection 객체를 변화시킴
		
		System.out.println("list의 데이터들을 오름차순으로 소팅한 결과 : " + list);

		Collections.shuffle(list);
		// 값들을 무작위로 섞는 메서드. collection 객체의 데이터를 랜덤하게 섞음
		
		System.out.println("list의 데이터들을 섞은 결과 : " + list);

		List<Integer> list2 = new ArrayList<Integer>();
		// Integer 객체를 가지는 list 자료형 
		
		list2.add(10);
		list2.add(20);
		list2.add(15);
		list2.add(5);
		int maxNum = Collections.max(list2);
		int minNum = Collections.min(list2);
		System.out.println("최대값:" + maxNum);
		System.out.println("최소값:" + minNum);

	}
}

```

#### [CollectionSort2](./CollectionSort2.java)

```java
package day0321.course;

import java.util.ArrayList;
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

```

- 클래스로 만든 객체간 누가 더 큰지를 비교해야하는 경우 Comparable을 상속할 것
- 값을 보관하는 객체는 `떙떙땡VO`라고 많이 정의함. 
- 값을 전달하는 객체는 `땡떙땡DTO`라고 많이 정의함.
- String 클래스를 포함한 모든 Wrapper 클래스는 모두 Comparable을 상속하고 있음

#### [CollectionSort3](./CollectionSort3.java)

```java
package day0321.course;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Person2 {
	public String name;
	public int age;

	public Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {		
		return name+"("+age+")";
	}	
}

class PersonComparator implements Comparator<Person2> {
	// Comparator 상속해서 타입정보 지정
	@Override
	public int compare(Person2 o1, Person2 o2) {
		// 독립된 비교자 역할을 하는 객체
		if (o1.age < o2.age)
			return -1;
		else if (o1.age > o2.age)
			return 1;
		else 
			return 0;
	}	
}

public class CollectionSort3 {
	public static void main(String[] args) {
		List<Person2> list = new LinkedList<>();
		
		for(int i=1; i <= 10; i++) {
			list.add(new Person2("duke"+i, new Random().nextInt(30)));
		}

		System.out.println(list);
				
		list.sort(new PersonComparator());
		System.out.println("\nlist의 데이터들을 오름차순으로 소팅한 결과 : " + list);		
	}
}

```

- 비교자의 DOM을 받아서 처리

# [EqualsTest3](./EqualsTest3.java)

```java
package day0321.course;

import java.util.Date;

class Value {
	int value;  // 멤버변수

	Value(int value) {  // 생성자 메서드 (value 멤버변수 초기화)
		this.value = value;
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


		if (v1.equals(v2))
			System.out.println("v1과 v2는 같습니다.");
		else
			System.out.println("v1과 v2는 다릅니다.");
		v2 = v1;  // 두 참조변수가 하나의 객체를 공유하게 됨
		if (v1.equals(v2))
			System.out.println("v1과 v2는 같습니다.");
		else
			System.out.println("v1과 v2는 다릅니다.");
	}
}

```

- 조작을 가해보자
```java
package day0321.course;

import java.util.Date;

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


		if (v1.equals(v2))
			System.out.println("v1과 v2는 같습니다.");
		else
			System.out.println("v1과 v2는 다릅니다.");
		v2 = v1;  // 두 참조변수가 하나의 객체를 공유하게 됨
		if (v1.equals(v2))
			System.out.println("v1과 v2는 같습니다.");
		else
			System.out.println("v1과 v2는 다릅니다.");
	}
}

```

- HashSet 객체를 생성해서 v1,v2,v3를 저장한 후에 저장된 객체를 출력해 보자.

```java
package day0321.course;

import java.util.Date;
import java.util.HashSet;

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
		// Object의 hashCode만 출력되는 상황  (같은 내용의 객체는 해시코드값이 같도록 오버라이딩 해주는 작업이 필요한데 안해준 상황)
		// 객체가 생성될떄 부여된 고유의 각 객체의 참조값을 10진수로 리턴
		// 
		
		
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

```

- 해시코드 오버라이딩 추가

```java
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

```



# [ObjectTest1](./ObjectTest1.java)

# [ObjectTest2](./ObjectTest2.java)


# [ObjectTest3](./ObjectTest3.java)

- equals 메서드 오버라이딩 추가
- hashCode 메서드 추가

```java
package day0321.course;

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
```


# Java I/O

- 표준 입출력
- 네트워크를 통한 입출력
- 파일 입출력_