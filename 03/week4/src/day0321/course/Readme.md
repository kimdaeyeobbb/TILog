# Collection API

- import 해놓고 사용하지 않는 것이 있으면 warning error 발생

- jav.util 패키지에 효율적인 검색/추가/삭제를 할 수 있도록 관련 인터페이스 및 클래스를 모아놓은 것

- 몇가지 인터페이스를 통해 다양한 컬렉션 클래스를 이용할 수 있도록 설계되어 있음

## 컬렉션 관련 인터페이스

|인터페이스| 소분류  |                                     특징                                     |구현 클래스|
|:---:|:----:|:--------------------------------------------------------------------------:|:---:|
|Collection| List |                          add되는 순서를 유지<br>중복 저장 기능                          |ArrayList<br>Vector<br>LinkedList|
|Collection| Set  |                       add 되는 순서를 유지하지 않음<br>중복 저장 불가                       |HashSet<br>TreeSet|
|Map|      | add되는 순서를 유지 하지 않음<br>키와 값으로 구성된 엔트리 저장<br>키는 중복 저장 불가<br> key를 가지고 데이터 처리 |HashMap<br>Hashtable<br>TreeMap<br>Properites|

### List 컬렉션

- List 컬렉션에는 ArrayList, LinkedList등이 있음
- List 컬렉션은 객체 자체를 저장하는 것이 아닌 객체의 번지를 저장함
  (동일한 객체를 중복하여 저장할 경우 동일한 번지가 지정됨)

#### 기본 형태

```java
List<K> list = new ArrayList<K>();  // K에 지정된 타입의 객체만 저장
List<K> list = new ArrayList<>();  // K에 지정된 타입의 객체만 저장
List list = new ArrayList();  // 모든  타입의 객체를 저장
```

- 타입 파라미터 K에 저장하고 싶은 객체의 타입을 지정
- List에 지정한 객체 타입과 동일하다면 ArrayList<>와 같이 객체 타입을 생략할 수 있음
- 객체 타입을 모두 생략할 경우 모든 종류의 객체를 저장할 수 있음
- 객체의 삽입 및 삭제가 빈번히 일어난다면 `LinkedList`를 사용하는 것이 좋음


#### 예제

### 트리
- 저장되는 값의 순서에 따라 정렬됨

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

# 실습과제

```java
package day0321.hw;

import java.util.HashSet;
import java.util.Objects;

class Product{
    /* 멤버변수 */
    private String productID;
    private String productName;
    private String productPrice;

    /* 생성자 메서드 */
    Product(String productID, String productName, String productPrice){
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    /* equals 메서드 오버라이딩 */
    public boolean equals(Object obj){  
        boolean result = false;
        if(obj != null && obj instanceof Product){
            if(productID == ((Product) obj).productID){
                // 기준 객체와 타겟 객체의 값이 동일한 지 확인
                result = true;
            }
        }
        return result;
    }

    /* toString 오버라이딩 */
    @Override
    public String toString(){
        return productID + "\t" + productName + "\t" + productPrice;
    }

    /* hashCode 오버라이딩 */

    @Override
    public int hashCode() {
        return Objects.hash(productID);
    }
    
    public void check(boolean b){
        if(b){
          System.out.println("성공적으로 저장되었습니다.");
        } else {
          System.out.println("동일한 ID의 제품이 이미 저장되었습니다.");
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Product p1 = new Product("p100","TV","        20000");
        Product p2 = new Product("p200","Computer","10000");
        Product p3 = new Product("p100","MP3","700");
        Product p4 = new Product("p300","Audio","    1000");

        HashSet<Product> set = new HashSet<>();
        
        /* 동일 객체 여부 확인 */
        p1.check(set.add(p1));
        p2.check(set.add(p2));
        p3.check(set.add(p3));
        p4.check(set.add(p4));
        
        System.out.println();

        System.out.println("제품ID\t제품명\t\t가격");
        System.out.println("--------------------------------------------------");
        for (Product data: set){
            System.out.println(data);
        }

    }
}
```

- contains 불필요. add 리턴타입이 boolean이므로 add 메서드만 호출해도 성공여부를 알 수 있음. 이것을 가지고 메시지 처리 가능
- Product 클래스 생성시 Hashset을 쓴다는 것은 동일 객체를 넣는다는 것이므로 equals와 hashcode를 오버라이딩해야 내가 가져올 데이터의 중복 여부를 체킹하면서 가져올 수 있음
- 실무에서 equals와 hashcode 구현은 필수임


# Java I/O

- I/O할떄 내부의 I/O스트림 객체를 거쳐서 I/O를 수행하도록 설계됨
- 이로인해 2가지 특성을 가짐
  - 스트림은 입력방향과 출력방향이 정해져있음 
  <br>(입력용 API, 출력용 API가 구분되어 있음)
  - 스트림이 I/O하는 단위가 byte 스트림과 문자 스트림으로 나뉘어져 있음
  <br>(API에 따라서는 byte 스트림을 쓰면 문자가 깨지는 현상이 발생 -> 이 경우 문자 스트림을 쓸 것)
  <br>(한글이 들어간 것을 입출력하려면 문자 스트림, 이미지는 byte 스트림을 이용)

## 스트림 입출력

- 스트림
  - 순서가 있고 길이가 정해져 있지 않은 일련의 데이터 흐름을 뜻함

- 스트림이라는 객체를 통해 I/O

### 바이트 스트림

- InputStream, OutputStream의 자손
- class이름에 file이 들어가있으면 file을 open하는 기능을 가지고 있음



#### 예제

```java
package day0321.course;

public class StandardInput {
    public static void main(String[] args) throws Exception{
        // I/O에 대해 Exception 처리를 안하면 error 발생

        System.out.print("입력 : ");
        char munja = (char) System.in.read();
        // 한 문자만 읽음

        System.out.println(munja);
    }
}

// ABC 입력시 A만 들어감
// 한글 입력시 꺠짐 (바이트 스트림으로 들어가므로 1byte만 들어감) (한글은 2byte)
```

- ABC 입력시 A만 들어감

- 한글 입력시 꺠짐 
<br>(바이트 스트림으로 들어가므로 1byte만 들어가는데 한글은 2byte임
<br>(폰트에 따라서 나타나는 형태가 다름)

### 문자 스트림

- 파일 오픈시 오버라이딩 모드로 열면 이전의 내용이 모두 사라짐
- 파일 오픈시 append 모드로 열어야 이전의 내용이 살아있음
- 자바 안에서는 UTF-16으로 인식됨
(자바 밖에서는 UTF-16로 인식되지 않음)


#### 예제
```java
package day0321.course;

import java.io.InputStreamReader;

public class StandardInput2 {
    public static void main(String[] args) throws Exception{
        System.out.print("입력 : ");
        InputStreamReader isr = new InputStreamReader(System.in);
        // 바이트스트림을 문자스트림으로 바꿔줌
        // System.in : 바이트 스트림 객체

        char munja = (char) isr.read();
        System.out.println("입력된 문자 : " + munja);
    }
}
```

- 한글이 안깨지고 잘 나옴

#### 예제2

```java
package day0321.course;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StandardInput3 {
    public static void main(String[] args) throws Exception{
        System.out.print("입력 : ");
        InputStreamReader isr = new InputStreamReader(System.in);
        // 바이트스트림을 문자스트림으로 바꿔줌
        // System.in : 바이트 스트림 객체 (표준 출력 장치를 가리키게 끔 자바 프로그램이 시작할 때 자동으로 초기화되는 객체)

        BufferedReader br = new BufferedReader(isr);
        String str = br.readLine();
        // readline: 사용자가 입력한 한 행을 읽어들임

        System.out.println("입력된 문자 : " + str);
    }
}
```

#### FileReader

- 파일을 입력 모드로 오픈하여 입력을 위한 스트림을 생성하는 클래스
- 생성자의 파라미터로 지정된 파일이 존재하지 않는 경우 FileNotFoundException이 발생함

```java
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {
  public static void main(String[] args) {
    FileReader reader = null;
    try {
      reader = new FileReader("test.txt");
      while (true) {
        int data = reader.read();
        if (data == -1) {
          break;
        }
        char ch = (char) data;
        System.out.println(ch);
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("파일이 존재하지 않습니다.");
    } catch (IOException ioe){
      System.out.println("파일을 읽을 수 없습니다.");
    } finally {
        try{
            reader.close();
        } catch (Exception e){
            
        }
    }
  }
}
```

- FileNotFoundException과 IOException의 위치가 바뀌면 안됨
  (IOException이 FileNotFoundException의 조상이므로 
IOException이 더 위에 줄이 위치하게 되면 
아래에 위치한 FileNotFoundException은 효력을 발휘할 수 없게 됨)

  
#### FileWriter

- 인자로 지정된 파일이 실제로 존재하지 않으면 새로 만듦
  - 새로 만들려고 보니 무엇인가가 안맞은 경우(디렉토리가 없는 경우 등) 에러 발생

##### 예제

```java
package day0321.course;

import java.io.File;
import java.util.Scanner;

public class FileTest1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("생성하려는 디렉토리명을 작성하세요 : ");
		String dirName = scan.nextLine();
		File f = new File(dirName); // 파일 객체 생성
		if (f.exists()) {
			System.out.println(dirName + "명의 디렉토리가 존재합니다.");
		} else {
			if (f.mkdirs()) { // s까지 붙여줘야 서브폴더까지 만들어줌
				System.out.println(dirName + "명의 디렉토리가 생성되었습니다.");
			} else {
				System.out.println(dirName + "명의 디렉토리 생성에 실패했습니다.");
			}
		}
		scan.close();
	}
}

```

- 절대경로를 기준으로    이클립스, 인텔리제이는 현재 프로젝트가 있는 경로에 폴더를 생성함

- FileWriter가 추가 상속하는 클래스들
  - Closeable, Flushable, Appendable, AutoCloseable


# [FileReaderTest3](./FileReaderTest3.java)

# [FileReaderTest4](./FileReaderTest4.java)

# Scanner

- System.in
  - 표준 입출력 장치와 관련된 Input stream

- 표준 입력을 받을 때 Scanner 객체 이용

- 파일 객체로 Scanner 객체 생성
  - 파일에서 읽겠다는 뜻

- 토큰
  - 분리문자를 기준으로 함 

- useDelimeter
  - 구분자로 콤마(,)를 사용함

## [ScannerFromFile](./ScannerFromFile.java)




# File 클래스

- 자바는 모든것을 객체로 취급함. 파일을 자바에서 다룬다고 하면 파일 객체로 만들어서 다룸.
- 객체 생성시 어떤 파일에 대한 객체를 생성하냐느에 따라 다른 생성자가 있음
- 디렉토리도 파일임. isDirectory의 결과가 true.


### 입력 스트림






### 출력 스트림


- 표준 입출력
- 네트워크를 통한 입출력
- 파일 입출력