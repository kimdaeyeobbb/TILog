# 내부클래스

- 클래스 안에 정의되는 클래스
<br>=> 밖에 있는 클래스는 외부클래스(outer class)


- 내부 클래스에서는 외부 클래스의 멤버들에 접근할 수 있음


- 내부 클래스에서는 캡슐화를 통해 코드의 
- 객체를 필요로 하는 자리에 클래스를 만드는 것임 
<br> => 소스코드 리뷰시 이것저것 열 필요가 없음
- 객체를 만드는 자리에 클래스를 만드는 것
<br> => 프로그램 유지보수에 좋음

## 내부 클래스의 멤버

- static inner member

- non-static inner member

## 지역 변수의 멤버

### named inner local
  - 클래스가 정의된 named 안에서만 쓸 수 있으므로 지역변수의 유사

### anonymous inner local
  - 다른 inner class에 비해 만드는 방법이 특이함
  - 얘가 정의된 메서드 내에서만 쓸 수 있음
  - 이름이 없으므로 객체 생성은 1번만 할 수 있음 (클래스 정의가 곧 객체 생성임)
  - 객체를 여러번 사용해야하는 경우 anonymous inner local로 만들면 비효율적임




## 내부 클래스의 종류


- 자바의 실행 파일은 바이너리 파일이 아님. 바이트코드임. (자바만의 기술로 만들어진 바이트코드. JVM이 이를 읽고 해석해서 시스템을 수행함.)
- 바이너리 파일은 내부에 OS정보가 들어감.
- 소스안에 정의된 실행 파일이 각각 생성됨.
- 내부클래스도 내부클래스별로 실행파일이 각각 생성됨. 하지만 단독으로 정의된 파일과는 다름.
- 내부클래스는 항상 외부클래스이름이 밖에 붙음. 외부클래스와 내부클래스를 구분하기 위해서 달러($)가 붙음.
- 자바에서는 명칭 구분을 위해 언더바(_)와 달러($)를 사용.



### 멤버 클래스

- 클래스의 멤버로 정의

```java
class OuterClassP{
    ... // 멤버클래스
    
    void test(){
        
    }
}
```
#### 내부 클래스 종류


```java
class A{
    class B{
        // 인스턴스 클래스
    }
    
    static class C{
        // static class
    }
}
```

##### 1. 인스턴스 클래스
- 외부클래스$내부클래스.class (클래스명 규칙)
- 멤버가 static형이 아니면 객체 생성부터 해야함
- 객체 생성 방법
```java
A a = new A(); // A에 세들어사니까 A에 대한 객체를 먼저 생성해야함
A.B b = new B();  // 점(.)으로 접근시 앞이 소문자면 패키지. 여기서는 대문자니까 클래스명임.
b.멤버;
```


##### 2. static class
- 외부클래스$내부클래스.class (클래스명 규칙)
- 객체 생성 방법
```java
A.C.멤버
```

- 내부 멤버 중 많이 사용됨


### 로컬 클래스

- 특정 클래스가 가지고 있는 특정 메서드 내에 정의됨

```java
class OuterClass{
    void test(){
        ...    // 로컬 를래스
    }
}
```


#### 내부 클래스 종류

##### 1. 이름이 있는 로컬 클래스
  
- 외부클래스$N내부클래스.class (클래스명 규칙)
  - N은 숫자임. 실제로는 달러대신 점(.)을 많이사용



```java
class X{
    int num;
    void sum(final int i){
        int total = 20;
        final String s = "test";
        class Y{
            멤버들...
          // X$1Y.class명의 클래스 파일이 생성
          // Y클래스 내에서는 X 클래스의 멤버 변수 num, sum() 메서드의 final 지역변수 s를 사용할 수 있음
          // Y클래스는 sum() 메서드 내에서만 사용이 가능함
        }
        Y y = new Y();
        y.멤버들;
    }
}
```

- 제어자 중 final만 지역변수에서도 정의할 수 있음.
- 메서드 내에서만 사용가능한데 상수로 정의하고 싶은 경우에 final로 지정.
- 주인집인 X가 가진 멤버들은 같은 영역내에 있으므로 Y클래스에서도 사용할 수 있음. (같은 주인집에 세 들어 사니까 공유 가능!)
- final 형으로 정의된 변수들은 Y클래스에서도 사용이 가능함.




##### 2. 이름이 없는 로컬 클래스 



- 외부클래스$N.class (클래스명 규칙)
    - N은 숫자임. 
    - $1.class 꼴이면 inner class임을 추측가능

- 얘를 함수처럼 만든 것이 `람다`

- 메서드 호출 시 매개변수의 타입이 추상 클래스 형이거나 인터페이스 형이어서 가볍게 구현(자손) 클래스를 만들고
  객체를 생성해서 전달하려는 경우 유용하게 사용될 수 있는 구문

```java
class N{
    void pr(Test t){
      ...
    }
    
    void sam(){
        pr(new Test(){ 
            // anonymous inner local class 정의 (인자를 전달하는 자리에 위치시킴. 객체 생성해서 전달하는 역할)
            // 클래스의 정의와 객체 생성을 동시에 하는 일회용 클래스
            // 객체 생성과 클래스 body를 한번에 묶어놓은 것임
          // 이름 날리고 앞에 객체 생성식을 붙임.
          // 중괄호 부분이 클래스의 body
            멤버들...
        });
      ...
    }
}
```

- `N$1.class` 꼴로 생성될 것임
- 내부 클래스는 해당 자리에서 한번만 객체 생성이 가능한 일회용 클래스임




- 내부 익명 클래스 생성
```java
new 클래스명(){
        // 이름없는 inner local class
    // 객체 생성식 & 블록 지정
        // 블록 내부에 구현할 멤버를 정의
}
```

- 익명 클래스의 경우 new 키워드 뒤의 생성자 메서드의 명칭이 기존 클래스 명인 경우에는, 자동적으로 이 클래스의
  자손 클래스가 되며, 인터페이스 명인 경우에는 이 인터페이스를 구현하여 추가 상속하는 클래스로서 부모 클래스는
  Object 이 된다. 


###### 이름없는 inner local class 예제

```java
package day0323.day14;

class LocalTest {
	String name = "Java";

	void pr(final String s) {
		final int su = 100;
		System.out.println(s + " : " + su);
		class Local {
			// LocalTest$1Local꼴로 생성될 것임
			// Local 클래스가 객체 생성되어 사용되려면 pr메서드가 호출되어야 함.
			void pr(String ls) {
				System.out.println("s : " + s);
				System.out.println("ls : " + ls);
				System.out.println(name);  // 멤버변수 name 출력
				System.out.println(su);  // pr 메서드 내부의 final형 지역변수인 su의 값을 출력
			}
		}
		Local lt = new Local();  // 객체 생성
		lt.pr("Local Test"); // 문자열 전달
	}
}

public class InnerTest2 {
	public static void main(String args[]) {
		LocalTest l = new LocalTest();
		l.pr("Main Call");
	}
}

```
- 포함하고 있는 inner local 사용 가능

###### 예제


- `javap day14.InnerTest3$1` 입력시
```java
package day0323.day14;

abstract class Test {
  Test() {
    System.out.println("No Argument sample");
  }

  abstract void output(String s);
}

public class InnerTest3 {
  void pr(Test o) {  // pr 호출하려면 Test를 전달해야함.
    // Test는 추상클래스임.
    // 따라서 얘를 전달할 얘를 생성해야 함
    o.output("Test");
  }

  public static void main(String args[]) {
    System.out.println("Main start !!");
    InnerTest3 n = new InnerTest3();  // 객체 생성하여 pr을 전달할 것임
    n.pr(new Test() {
      // anaonymouse inner local class를 생성
      // 어떤 클래스/인터페이스를 대신해서 만들것이냐에 따라 대신해서 만들것을 앞에 붙여줌.
      // 누구에 대한 객체 생성하는식을 앞에 붙이냐에 따라서 누구를 상속하느냐가 정해짐. -> Test를 상속하게 됨
      // new Test()를 통해 Test 클래스의 자식이 됨.
      // 어떤 클래스/인터페이스를 상속하느냐에 따라서 new 생성자() 호출식을 지정
      // 매개변수 pr에 객체 전달
      // output 호출하면서 Test를 전달하고 있음
      // 이름없는 inner local의 부모가 Test임
      // 이름없는 얘도 클래스이므로 생성자를 가지고 있음 -> 부모의 생성자 호출

      int su = 100;



      // output 메서드를 오버라이딩
      // 추상 메서드 (미완성 메서드)를 오버라이딩해야 함
      public void output(String s) {
        System.out.println("Anonymous Class : " + s);
        System.out.println("Anonymous Class : " + su);
      }
    });
  }
}

```


###### 예제

```java
package day0323.day14;

interface Testable {
	final static String FS = "Interface Test"; // 상수 (값과 메모리 공간을 고정함)

	abstract void output(String s);
}

public class InnerTest4 {
	void pr(Testable o) {
		o.output("Test");
		System.out.println(Testable.FS);
		// System.out.println(o.su); // 자손에서 추가된 멤버는 접근할 수 없다.
	}

	public static void main(String args[]) {
		System.out.println("Main start !!");
		InnerTest4 n = new InnerTest4();
		// 이 이름 없는 Inner 클래스는 Testable 와 Object 의 자손이 된다.
		n.pr(new Testable() { 
			// 이름없는 inner local class는 한번만 생성이 가능함
			// new 다음에 인터페이스에 대한 객체 생성식이 나옴
			// 이 객체 생성식을 통해 Testable을 추가상속하는 클래스가됨.
			// (추상 메서드와 추상 클래스는 new 키워드로 생성자 생성할 수 없음)
			// 이 inner local class의 부모는 자동으로 Object이 됨 + Testable을 추가 상속하게 됨
			// extends절을 생략하면 자동으로 Object이 부모가 됨
			int su = 100; // 멤버변수

			/* 외부 클래스의 메서드 오버라이딩 */
			// 이름 없는 inner local class를 추상메서드로 만들 수 없음
			// 얘는 인터페이스니까 생성자는 정의할 수 없음.
			// 자손의 객체를 조상유형의 변수에 전달할 수 있지만 조상 유형의 변수로 자손에 추가된것에 접근을 할 수는 없음
			public void output(String s) {
				// 얘는 구현안하면 에러남
				System.out.println("Anonymous Class : " + s);
				System.out.println("Anonymous Class : " + su);
			}
		});
	}
}

```

- 인터페이스를 상속한다?
  - 인터페이스를 추가 상속함으로서 인터페이스의 자격을 갖춤
  <br>(클래스 상속은 걔를 상속하면 추가 상속 못함)
  

# 실습
