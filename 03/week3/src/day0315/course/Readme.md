# 0314 실습 풀이

```java
package exercise;  // 제출시 packge exercise로 변경

class Human{
    private String name;
    private int age;
    private int height;
    private int weight;

    /* 멤버변수를 기본값으로 초기화 */
    // 얘로 객체 생성가능 
    public Human(){}

    /* 멤버변수 초기화 */
    // 얘로 객체생성 가능
    public Human(String name, int age, int height, int weight){
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String printInformation(){
        return name + "\t" + age + "\t" + height + "\t" + weight;
    }
}

class Student extends Human{
    private String number;
    private String major;

    public Student(){}

    // number, major는 직접 세팅. 나머지는 조상 생성자를 통해 세팅 
    public Student(String name, int age, int height, int weight, String number, String major){
        super(name, age, height, weight);
        this.number = number;
        this.major = major;
    }

    /* 조상을 호출하지 않으면 자기 자신을 재귀적으로 호출 => 스택오버플로우 발생 */
    @Override
    public String printInformation() {
        return super.printInformation() + "\t" + number + "\t" + major;
    }
}

public class StudentTest {
    public static void main(String[] args) {
        Student arrays[] = new Student[3];
        arrays[0] = new Student("홍길동", 20, 171,81,"2001101","영문");
        arrays[1] = new Student("고길동", 21, 183,72,"2001102","건축");
        arrays[2] = new Student("박길동", 22, 175,65,"2001103","컴공");

        for(Student st: arrays){
            System.out.println(st.printInformation());
        }
    }
}
```
## 멤버변수

- 클래스 내에 선언된 변수
- `인스턴스 변수`, `정적 변수`가 멤버변수임

```java
class Person{
    String name;   // 인스턴스 변수
    int age;  // 인스턴스 변수
    String sex;  // 인스턴스 변수 
    static String nation = "KOREA";  // 정적 변수
}
```


### 인스턴스 변수

- 인스턴스를 생성하고나서 접근이 가능한 변수 
- 인스턴스의 생명주기와 동일한 주기를 가짐

```java
class Person{
    String name;   // 인스턴스 변수
    int age;  // 인스턴스 변수
    String sex;  // 인스턴스 변수 
    static String nation = "KOREA";  // 정적 변수
}

Person person1 = new Person();
person1.name = "카세미루";  // 인스턴스 변수
person1.sex = "male";  // 인스턴스 변수 
```

### 정적 변수

- 인스턴스를 생성하지 않아도 접근이 가능한 변수
- `클래스 변수`라고도 함
- 정적 변수 `nation`은 Person 클래스에서 동일한 메모리를 참조하므로 변수를 공유한다고 볼 수 있음
- 인스턴스의 생성과 소멸 생명주기와 상관없이 프로그램이 시작되면 메모리에 적재되므로 인스턴스 생성없이 접근이 가능함


```java
class Person{
    String name;   // 인스턴스 변수
    int age;  // 인스턴스 변수
    String sex;  // 인스턴스 변수 
    static String nation = "KOREA";  // 정적 변수
}

String nation2 = Person.nation;  // 정적 변수
```


## 객체 생성자

- 객체 생성자는 호출시 조상 생성자부터 호출


# Tip

- 실무에서는 클래스마다 소스를 클래스명과 동일하게 주어서 정의하는 것이 기본


# 7. 상속

## 1.1 상속의 정의와 단점

- 상속
  - 새로운 클래스를 만들 때 부모-자식 관계를 맺어주는 것
  - 이렇게 함으로써 부모 클래스에 있는 대부분의 멤버는 자식 클래스에 그대로 귀속됨
  - 이때, 상속이 안되는 것이 존재함 (생성자, static&인스턴스 초기화 블럭)<br>따라서 자손은 조상보다 멤버가 더 많거나 동일하다 (멤버가 더 적어질 수는 없다)
  - 상속을 이용하면 새로운 클래스를 만들 때 빠르게 생성이 가능함  
  - 상속을 이용하면 프로그램 개발을 빠르게 할 수 있음
  - 서블릿은 상속을 이용하지 않으면 프로그래밍 짤 것이 많지만, 상속을 이용하면 편리하게 프로그램 개발이 가능함

```java
class Point {
    int x;
    int y;
}

class Point3D extends Point{
    int z;
}
// Point3D는 x,y,z라는 3개의 멤버가 존재
```

## 1.2 클래스간의 관계 - 상속 관계

```java
class Parent(){}
class Child extends Parent{}
class GrandChild extends Child {}
```

- Parent는 Child에게는 부모이지만 GrandParent에게 있어서는 조상임
- 조상의 변경은 자손에 영향을 미치지만 자손의 변경은 조상에 영향을 미치지 않음
- 자바에서는 형제관계가 없다 (부모-자식, 조상-자손 관계등만 존재)

## 1.2 클래스간의 관계 - 포함 관계

- 기존 클래스를 사용하는 방법
    - 객체 생성해서 사용
        - static이 아닐 떄 객체 생성해서 기존 클래스를 사용
    - 상속해서 사용
        - static 일때 기존 클래스를 상속해서 사용
        - 포함관계가 아닌 경우

### 포함이란?

- 객체 생성해서 사용하는 관계
- 한 클래스의 멤버변수로 다른 클래스를 선언하는 것

<br>

- 예제
```java
class Circle{
    int x;  // 원점의 x좌표
    int y;  // 원점의 y좌표
    int r;  // 반지름
}

/* 포함 관계 */
class Circle {
    Point c = new Point();   // 원점 - 한 클래스의 멤버변수로 다른 클래스를 선언 
    int r;  //반지름
}
// 이 경우 Circle은 Point를 포함한다고 함
```


## 1.3 클래스간의 관계 결정 - 상속 VS 포함

- Point 객체를 생성해서 사용하는 것도 말이되고
```java
class Circle{
    int x;  // 원점의 x좌표
    int y;  // 원점의 y좌표
    int r;  // 반지름
}

/* 포함 관계 */
class Circle {
    Point c = new Point();   // 원점 - 한 클래스의 멤버변수로 다른 클래스를 선언 
    int r;  //반지름
}
// 이 경우 Circle은 Point를 포함한다고 함
```
- 상속해도 x,y에 대한 멤버가 만들어지는 것과 동일
```java
class Circle{
    int x;  // 원점의 x좌표
    int y;  // 원점의 y좌표
    int r;  // 반지름
}

/* 포함 관계 */
class Circle {
    Point c = new Point();   // 원점 - 한 클래스의 멤버변수로 다른 클래스를 선언 
    int r;  //반지름
}
// 이 경우 Circle은 Point를 포함한다고 함
```

- 이러한 경우 새로이 만들고자 하는 클래스와 어떻게 사용해야하는지 헷갈리는 기존 클래스의 관계가 `is - a` 관계이면 `상속`해서 사용하는것이 적절하고, `has - a`관계이면 `포함관계`로 간주하자.
- `원은 점을 갖는다`가 적절하므로 `포함관계`를 사용하자 (Circle has a dot)

### 예제

```java

```

- 원은 도형이다 (A Circle `is a` Shape) : 상속 관계
- 원은 점을 가지고 있다 (A Circle `has a` Point) : 포함 관계


## 1.4 단일상속

- 자바는 단일상속만을 지원함 (C++은 다중상속 허용. 따라서 C++은 부모를 원하는 만큼 지정할 수 있기에 무겁다.)
```java
class TVCR extends TV, VCR{
    // 다중상속 허용x
}
```

- 비중이 높은 클래스 하나만 상속하고, 그렇지 않은 나머지는 포함관계로 사용하자
```java

```


## 1.5 Object 클래스

- 모든 클래스의 최고 조상임 (상속계층도의 최상위에 존재)
- 조상이 없는 클래스는 자동적으로 Object 클래스를 상속받게 됨
- 모든 클래스는 Object 클래스에 정의된 11개의 메서드를 상속받음

<br>

## 2.1. 오버라이딩

- 조상클래스로부터 상속받은 메서드의 내용을 상속받은 클래스에 맞게 변경하는 것
- final 메서드를 제외하고 오버라이딩이 가능 
- override : ~위에 덮어쓰다
- 자식에게 있어 무엇인가가 바뀌어야하면 오버라이딩을 사용함

```java

```

## 2.2. 오버라이딩의 조건

1. 선언부가 같아야 함 (이름, 매개변수, 리턴타입)
2. 접근 제어자를 좁은 범위로 변경 할 수 없음
3. ㅁ

## 2.3 오버로딩 vs 오버라이딩

### 오버로딩

- 기존에 없는 새로운 메서드를 정의하는 것 (new)

### 오버라이딩

- 상속받은 메서드의 내용을 변경하는 것(change, modify)

```java
class Parent{
    void parentMethod() {}
}

class Child extends Parent{
    void parentMethod() {}  // 오버라이딩
    void
    
    void childMethod(int i)// 오버로딩
}
```

- 같은 클래스 내 메서드를 재정의 하는것은 말이 안됨

## 2.4 super 

- this
  - 인스턴스 자신을 가리키는 참조변수
  - 인스턴스의 주소가 저장되어 있음
  - 모든 인스턴스 메서드에 지역변수로 숨겨진채로 존재

- super
  - 조상 객체 참조 변수
  
```java

// 조상의 getLoation 호출하기 위해 super. 사용
```

## 2.4. super(2)

- 어떤 클래스든 객체 생성시 물려받은 멤버까지 사용할 수 있음
- 모든 생성자 메서드는 호출되었을 떄 조상 생성자부터 호출하면서 내려옴. 
따라서 생성자 메서드 내에는 super 호출문장이 있어야 함 (없으면 자동으로 추가됨)
- 부모가 인자를 안받는 생성자를 안가지고 있으면 super를 넣어주어야 함
- this를 호출하는 경우 넣어주지 않음 

```java

// this 호출시 super를 넣어주지 않음.


// this도, super도 없으면 super 넣어줌
```


## 2.5 super


<br>

# 다형성

- 다형성이 자바에 지원되지 않았다면 상속구문의 장점을 최대치로 끌어올릴 수 없었을 것임
- 실제로 프로그래밍을 하다보면 덧셈/뺄셈 연산자보다 많이 사용함

```java
package day0315.course;

public class PolyTest {
    public static void main(String[] args) {
        printObjectInfo(new Object());
        // Object 클래스는 java.lang 패키지에 있으므로 따로 import 안해도됨
        // java.lang 패키지는 자동으로 import 됨

    }

    // 같은 static이어야 메인메서드에서 호출하기 편함
    // non static 메서드일 경우 객체 생성해야 호출 가능함 (같은 클래스 내에 있어도 객체를 통해서만 호출가능)
    static  void printObjectInfo(Object o){
        // 매개변수 - Object이라는 클래스형의 변수
        // Object 객체를 전닲하겠다는 뜻 (Object 또한 자바의 클래스임. 최상위 클래스.)

        System.out.println("전달된 객체의 클래스명: " + o.getClass().getName());
        // getClass().getname() -> 실제 전달된 객체가 누구인지 확인 (자주 사용)


    }
}
```

- 어떤 클래스든 패키지명을 붙인것이 정식 클래스명임

```java
package day0315.course;

public class PolyTest {
    public static void main(String[] args) {
        printObjectInfo(new Object());
        // Object 클래스는 java.lang 패키지에 있으므로 따로 import 안해도됨
        // java.lang 패키지는 자동으로 import 됨

        printObjectInfo("가나다");
        printObjectInfo("ABC");
        printObjectInfo(new java.util.Date());
        // 다른 패키지에 있는 클래스를 가져다 쓸 경우 클래스명 앞에 패키지명을 붙여서 사용해도 됨

        printObjectInfo(new java.io.File("c:/Temp"));
        // io 패키지에 있는 클래스. 인자가 없는 생성자는 가지고 있지 않음. 따라서 반드시 인자로 무엇인가를 줘야함
        // OS에 따라 디렉토리 구분자가 다름. 윈도우는 슬래시 나머지는 모두 백슬래시
        // JAVA에서는 OS에 관게없이 슬래쉬를 사용해도 됨. 백슬래쉬를 쓸거면 2번을 써야함 (한번은 이스케이프 문자로 인식하므로)

        printObjectInfo(new int[10]);
        printObjectInfo(new double[5]);
        printObjectInfo(100);
        // 기본형 데이터(int 형)

        printObjectInfo(3.14);  // java.lang.Double
    }

    // 같은 static이어야 메인메서드에서 호출하기 편함
    // non static 메서드일 경우 객체 생성해야 호출 가능함 (같은 클래스 내에 있어도 객체를 통해서만 호출가능)
    static  void printObjectInfo(Object o){
        // 매개변수 - Object이라는 클래스형의 변수
        // Object 객체를 전닲하겠다는 뜻 (Object 또한 자바의 클래스임. 최상위 클래스.)

        System.out.println("전달된 객체의 클래스명: " + o.getClass().getName());
        // getClass().getname() -> 실제 전달된 객체가 누구인지 확인 (자주 사용)

    }
}
```

- 매개변수 타입이 Object형 (클래스 유형)임. 
- 에러가 안나는 이유?
  - 다형성 구문 때문임

## 다형성 구문

- 조상으로부터 상속된 모든 자손 객체를 전달하여 사용할 수 있음
- 조상유형은 자손객체까지 모두 참조할 수 있는것이 `다형성`
- String, File, 배열, 기본형(java5이후 오토박싱을 통해 객체형으로 변환 - java.lang.Integer와 같은 래퍼 클래스 등으로 바뀜 -> JVM이 Integer 객체로 바꾸어서 전달) 등은 모두 Object 자손
- 자바는 쌍따옴표가 붙은 리터럴은 자동으로 String 객체로 취급
- 전달된 객체의 타입이 java.lang.String.
- `[I`: 어떤 타입의 배열 객체인지에 대한 정보를 내보내줌 (배열은 클래스가 따로없음. 자바에서의 배열은 정해진 구문으로 배열을 만드는 것일 뿐이므로 클래스명은 자바 개발한 사람이 `[I`, `[D` 등으로 정해놓음)

- 자바의 모든 객체는 Object의 자손임.
- 매개변수 타입이 Object일 경우 객체만 전달하면 됨

- 매개변수 타입을 String으로 바꾸면 에러 발생
<br> (매개변수는 String 혹은 String의 자손만 올 수 있게 만듦)
```java
package day0315.course;

public class PolyTest {
    public static void main(String[] args) {
        printObjectInfo(new Object());
        // Object 클래스는 java.lang 패키지에 있으므로 따로 import 안해도됨
        // java.lang 패키지는 자동으로 import 됨

        printObjectInfo("가나다");
        printObjectInfo("ABC");
        printObjectInfo(new java.util.Date());
        // 다른 패키지에 있는 클래스를 가져다 쓸 경우 클래스명 앞에 패키지명을 붙여서 사용해도 됨

        printObjectInfo(new java.io.File("c:/Temp"));
        // io 패키지에 있는 클래스. 인자가 없는 생성자는 가지고 있지 않음. 따라서 반드시 인자로 무엇인가를 줘야함
        // OS에 따라 디렉토리 구분자가 다름. 윈도우는 슬래시 나머지는 모두 백슬래시
        // JAVA에서는 OS에 관게없이 슬래쉬를 사용해도 됨. 백슬래쉬를 쓸거면 2번을 써야함 (한번은 이스케이프 문자로 인식하므로)

        printObjectInfo(new int[10]);
        printObjectInfo(new double[5]);
        printObjectInfo(100);
        // 기본형 데이터(int 형)

        printObjectInfo(3.14);  // java.lang.Double
    }

    // 같은 static이어야 메인메서드에서 호출하기 편함
    // non static 메서드일 경우 객체 생성해야 호출 가능함 (같은 클래스 내에 있어도 객체를 통해서만 호출가능)
    static  void printObjectInfo(String o){

        System.out.println("전달된 객체의 클래스명: " + o.getClass().getName());
        // getClass().getname() -> 실제 전달된 객체가 누구인지 확인 (자주 사용)

    }
}
```

- 다형성이란
  - 변수를 다양하게 사용할 수 있게 만들어주는것
  - 어떤 유형의 변수는 해당 클래스뿐만 아니라 자손의 객체도 참조할 수 있다는 것

- 자바의 다형성이 없었다면 코딩량이 늘었을 것이다. 그리고 인터페이스와 앱색클래스 등은 활용되기가 어려울 것이다. 다형성이 있으믈 코딩량이 줄고 추상클래스나 인터페이스등을 활용할 수 있게 된것이다.
- 다형성으로 인해 해당 클래스의 객체 뿐만아니라 자손의 객체또한 참조할 수 있게 됨


```java
Date d1 = new Date(); 
// Date라는 클래스형의 변수 d1
// d1 -> Date 클래스의 객체. 해당 클래스의 유형에 담아서 쓰는것이 일반적
// 부모 유형의 변수에 자식 유형을 대입해서 사용하는 것이 가능

        
/* 다형성 사용 예제 */        
Ojbect d2 = new Date();
// 조상 유형을 대입해서 사용하는 것이 가능

/* 불가능 */
String d3 = new Date();  
// 얘네 둘이 부모-자식 관계가 아니므로 불가능!


```

- 부모 유형의 변수에 자식 유형을 대입해서 사용하는 것이 가능
- 어떤 클래스의 유형이냐에 따라서 접근할 수 있는 멤버의 사양이 달라짐
  - d2는 Date 객체를 참조할 수는 있지만 d2는 Object 타입이므로 자손에서 추가된 멤버에는 접근할 수 없음.
  - 어떤 클래스의 유형이냐에 따라서 접근할 수 있는 멤버들은 이 변수가 어떤 클래스의 유형이냐에 따라 결정됨. 자손에서 추가된 것에는 접근할 수 없음.

```java
package day0315.course;

public class PolyTest {
    public static void main(String[] args) {
        printObjectInfo(new Object());
        // Object 클래스는 java.lang 패키지에 있으므로 따로 import 안해도됨
        // java.lang 패키지는 자동으로 import 됨

        printObjectInfo("가나다");
        printObjectInfo("ABC");
        printObjectInfo(new java.util.Date());
        // 다른 패키지에 있는 클래스를 가져다 쓸 경우 클래스명 앞에 패키지명을 붙여서 사용해도 됨

        printObjectInfo(new java.io.File("c:/Temp"));
        // io 패키지에 있는 클래스. 인자가 없는 생성자는 가지고 있지 않음. 따라서 반드시 인자로 무엇인가를 줘야함
        // OS에 따라 디렉토리 구분자가 다름. 윈도우는 슬래시 나머지는 모두 백슬래시
        // JAVA에서는 OS에 관게없이 슬래쉬를 사용해도 됨. 백슬래쉬를 쓸거면 2번을 써야함 (한번은 이스케이프 문자로 인식하므로)

        printObjectInfo(new int[10]);
        printObjectInfo(new double[5]);
        printObjectInfo(100);
        // 기본형 데이터(int 형)

        printObjectInfo(3.14);  // java.lang.Double
    }

    // 같은 static이어야 메인메서드에서 호출하기 편함
    // non static 메서드일 경우 객체 생성해야 호출 가능함 (같은 클래스 내에 있어도 객체를 통해서만 호출가능)
    static  void printObjectInfo(Object o){
        // 매개변수 - Object이라는 클래스형의 변수
        // Object 객체를 전닲하겠다는 뜻 (Object 또한 자바의 클래스임. 최상위 클래스.)
        // - Object이 가지고 있는 사양까지만 접근 가능 (자손에게 추가된 멤버에 접근이 불가능)

        System.out.println("전달된 객체의 클래스명: " + o.getClass().getName());
        // getClass().getname() -> 실제 전달된 객체가 누구인지 확인 (자주 사용)

    }
}
```

- o에는 어떤 객체든 전달될 수 있는데, String이 전달되었는지 확인해보자. 
- String이 전달된 경우 전달된 문자열의 길이정보를 확인해보자.
- 어떤 참조형 변수에 할당된 객체가 어떤 형태인지 확인하고 싶을떄 `instanceof` 사용

```java
package day0315.course;

public class PolyTest {
    public static void main(String[] args) {
        printObjectInfo(new Object());
        // Object 클래스는 java.lang 패키지에 있으므로 따로 import 안해도됨
        // java.lang 패키지는 자동으로 import 됨

        printObjectInfo("가나다");
        printObjectInfo("ABC");
        printObjectInfo(new java.util.Date());
        // 다른 패키지에 있는 클래스를 가져다 쓸 경우 클래스명 앞에 패키지명을 붙여서 사용해도 됨

        printObjectInfo(new java.io.File("c:/Temp"));
        // io 패키지에 있는 클래스. 인자가 없는 생성자는 가지고 있지 않음. 따라서 반드시 인자로 무엇인가를 줘야함
        // OS에 따라 디렉토리 구분자가 다름. 윈도우는 슬래시 나머지는 모두 백슬래시
        // JAVA에서는 OS에 관게없이 슬래쉬를 사용해도 됨. 백슬래쉬를 쓸거면 2번을 써야함 (한번은 이스케이프 문자로 인식하므로)

        printObjectInfo(new int[10]);
        printObjectInfo(new double[5]);
        printObjectInfo(100);
        // 기본형 데이터(int 형)

        printObjectInfo(3.14);  // java.lang.Double
    }

    // 같은 static이어야 메인메서드에서 호출하기 편함
    // non static 메서드일 경우 객체 생성해야 호출 가능함 (같은 클래스 내에 있어도 객체를 통해서만 호출가능)
    static  void printObjectInfo(Object o){
        // 매개변수 - Object이라는 클래스형의 변수
        // Object 객체를 전닲하겠다는 뜻 (Object 또한 자바의 클래스임. 최상위 클래스.)
        // Object이 가지고 있는 사양까지만 접근 가능 (자손에게 추가된 멤버에 접근이 불가능)

        if (o instanceof String){ 
            // o에게 전달된 객체가 문자열인지 확인 
            // instanceof -> 비교연산자 (true or false)
            System.out.println("문자열 객체가 전달됨 : " + o.toString() + "-" + (o.length());
        } else {
            System.out.println("전달된 객체의 클래스명: " + o.getClass().getName());
            // getClass().getname() -> 실제 전달된 객체가 누구인지 확인 (자주 사용)
        }
    }
}
```

- toString은 Object가 가지고 있음
- length는 Object가 가지고 없음
- 에러를 해결하기 위해서는 자손으로 형변환을 해서 호출하자
- 따라서 o.length를 ((String o)).length로 바꾸자
- (String o).length로 쓰면 안됨 (점 연산자는 연산 우선순위가 제일 높기 때문)
- String으로 변환하였으므로 String으로 바뀐 멤버까지는 ~을 줌

- 자손 유형의 객체를 조상 유형에 대입하는 것은 가능하지만, 반대의 경우에는 형 변환 연산자를 써주어야 한다 (자손입장에서는 조상은 1명이지만 조상입장에서는 자손이 여러명이므로 어느것을 참고하실지를 명시해주어야 한다는 것임)

# 5.1 다형성이란?

- 여러가지 형태를 가질 수 있는 능력
- 하나의 참조변수로 여러 타입의 객체를 참조할 수 있는 것
<br>(즉, 조상타입의 참조변수로 자손타입의 객체를 다룰 수 있는 것)

```java
//class Tv{
//    boolean power; 
//    int channel;
//    
//    void power(){ power =!power;}
//}
//
//~~~
```

## 5.2. 참조변수의 형변환

- 서로 상속관꼐에 있는 타입간의 형변환만 가능함
- 자손 타입에서 조상타입으로 형변환하는 경우, 형변환 생략 가능
- 기본형 변환 규칙
1. 정수형 -> 실수형
2. 사이즈 작은형 -> 사이즈 큰형
3. boolean형은 절대 형변환 될 수  없음

- 참조형 간의 형변환은 클래스 형변환이라 보면됨. (부모-자식간에만 형변환이 됨!)
```java
자손타입 -> 조상타입 // 형변환 생략 가능
조상타입 -> 자손타입 
// 형변환 생략불가. 
// 반드시 형변환 연산자를 써주어야함. 
// 부모입장에서 자식이 여려명이고 어느자식으로 변환하는지 명시해주어야 함
```

```java
class Car {
    String color;
    int door;
    
    void drive(){
      System.out.println("drive ,ERRR~");
    }
}

class FireEngine extends Car {
    void water(){
      System.out.println("water!!");
    }
}

class Ambulance extends Car{
    void siren(){
      System.out.println("siren~~~!!!");
    }
}

public class Ex{
  public static void main(String[] args) {
    Car car = null; // 아직 참조하는게 없다는 뜻
    FireEngine fe = new FireEngine();
    FireEngine fe2 = null;
    
    fe.water();
    car = fe;   // 자식 -> 조상으로 대입 (자동형변환)
//    car.water();  // car로는 water() 호출 불가
    fe2 = (FireEngine) car;  // 조상 -> 자손으로 대입 
    fe2.water();
  }
}
```

- 자식 클래스를 만드는 시점에서 부모가 누구인지를 알고있지만 반대로 부모입장에서는 자식이 누가될지는 모름.
- 여기서 FireEngine과 Ambulance는 아무관계도 아님.
- 대입연산을 할 떄 부모-> 자식으로 대입하면 어떤 형으로 변환할 것인지를 명시해주어야 함

# 5.3 instanceof 연산자



# 5.5 매개변수의 다형성

- 참조형 매개변수는 메서드 호출시, 자신과 같은 타입 또는 자손타입의 인스턴스를 넘겨줄 수 있다

```java
class Product{
    int price;
    int bonusPoint;
}

class Tv extends Product{}
class Computer extends Product{}
class Audio extends Product{}

class Buyer{  // 구매자
    int money = 1000;  // 소유금액
    int bonusPoint = 0;  // 보너스점수
  
  void buy(Tv t){ // 매개변수타입이 Tv. Tv 구매할 떄에만 호출 할 수 있는 메서드인 상태임.
      money -= t.price;
      bonusPoint += t.bonusPoint;
  }
  
  /* buy 메서드 오버로딩 */
  void buy(Computer c){
      money -= c.price;
      bonusPoint += c.bonusPoint;
  }
  
  /* 메서드 오버로딩 */
  void buy(Audio a){
      money -= a.price;
      bonusPoint += a.bonusPoint;
  }
}
```

- 상품객체를 argument로 받도록 설계하면 상품이 늘어날수록 buy메서드 개수가 늘어나야 함
- 이렇게 설계하면 판매상품이 늘어날수록 buy 메서드를 또만들고 또만들어야하는 상황이 생김. 따라서 이러한 경우에는 `다형성`을 이용하자

```java
class Product{
    int price;
    int bonusPoint;
}

class Tv extends Product{}
class Computer extends Product{}
class Audio extends Product{}

class Buyer{  // 구매자
    int money = 1000;  // 소유금액
    int bonusPoint = 0;  // 보너스점수
  
  void buy(Product t){ 
      // 상속을 할 떄 Product형만 받도록 정함 (다형성 이용)
      money -= t.price;
      bonusPoint += t.bonusPoint;
  }
  
  
  Product p1 = new Tv();
  Product p2 = new Computer();
  Product p3 = new Audio();
  
}
```
- buy 메서드를 만들 떄 애초에 Product 형을 매개변수로 받도록 설계하자
- 공통부모인 Product형으로 매개변수 선언시 이 buy는 어떤 객체든 전달받을 수 있다.
<br>(조상형으로 사용하도록 강제함)


# 4. 제어자 (modifier)

- 클래스, 변수, 메서드의 선언부에 사용되어 부가적인 의미를 부여함
- 제어자는 크게 접근 제어자와 활용 제어자로 나뉜다.

## 접근 제어자

### public
- 대부분은 public임
- 클래스 앞에 올 수 있음
- 멤버변수, 메서드, 생성자 메서드 앞에 올 수 있음
- 이 클래스에서는 이 패키지 내에서 쓸거야! 하면 public을 생략하면 됨
- 아무리 클래스가 public이어도 생성자가 public이 아니면 생성자 메서드 호출을 못함
<br> -> public인것이 의미 없어짐.
<br>(보통 클래스가 public이면 생성자도 public으로 설정하는게 일반적.)
<br>(가끔 생성자를 private으로 감춰놓기도 함.)

### protected
- 자손이거나 같은 패키지
- 멤버변수, 메서드, 생성자 메서드 앞에 올 수 있음
- 같은 패키지가 아닌데 객체 생성하면 접근할 수 없음
  <br>(같은 패키지이거나 자손이어야 함. 두가지 조건 중 하나라도 만족해야 함.)
  

### default
- 접근 제어자를 생략한 케이스를 뜻함
- 반드시 같은 패키지 여야함 
- 아무리 자손이어도 같은 패키지가 아니면 제외됨 (아무리 객체생성했어도 같은 패키지가 아니면 제외)
- 클래스 앞에 올 수 있음
- 멤버변수, 메서드, 생성자 메서드 앞에 올 수 있음


### private
- 멤버변수, 메서드, 생성자 메서드 앞에 올 수 있음
- private이 생성자 앞에 오면 `new 생성자명`꼴을 사용할 수 없음
- 인스턴스 멤버변수(static이 아닌변수는) private으로 설정
<br>=> 외부에서 접근해서 잘못 바꾸는것 방지
- getter 메서드로 읽을 수 있을 수 있음


## 활용 제어자

### static
- static 변수/ static 블럭 / static 메서드
- 메모리 영역을 고정한다
- 클래스가 로딩될 때 자동으로 사용가능한 상태가 됨
- 객체 생성과 상관없이 클래스명으로 접근할 수 있는 멤버임
- 멤버변수와 메서드, 블록에 정의가 가능함

### final
- 변수에 final을 붙이면 상수가됨
- 메서드에 final을 붙이면 오버라이드가 불가능한 메서드가 됨 (자식에서 오버라이딩 불가.)
- 클래스, 멤버변수, 메서드, 지역(매개)변수 앞에 올 수 있음
- final은 상속은 안되고 객체생성만 됨


### abstreact
- 추상적인, 미완성의
- final은 상속은 안되고 객체생성만 됨
- abstract은 객체생성은 안되고 상속이 됨
- 따라서 fianl과 abstract는 같이 설정할 수 없음
- 클래스, 메서드 앞에 올 수 있음 (변수 앞에는 올 수 없음)

#### abstract 메서드
- 메서드의 헤더만 정하고 코드 블록을 생략한 메서드
- 코드블록이 정의되지 않고 호출스택만 정해진 미완성 메서드
- abstract 메서드를 1개 이상 정의한 클래스는 반드시 abstract 클래스로 정의해야 함
- 자손에 의해 반드시 오버라이딩 해야하는 메서드 (어떻게 수행되는지는 자손마다 다르게 하겠다는 것)
<br> (fianl 메서드인 경우 오버라이딩이 불가. abstract는 반드시 오버라이딩 해야함)

#### abstract 클래스

- 미완성 클래스로서 객체생성은 불가능하고 상속으로만 사용가능한 클래스
- 0개 이상의 abstract 메서드가 존재할 수 있음 (내부에 꼭 abstract 메서드가 있어야한다는 제한이 없음)
- http 서블릿 (직접적으로 객체 생성할 일 없음.)
- 객체가 상황에 따라 수행코드가 달라져야 하는 메서드는 미완성 메서드로 해놓고 얘를 상속하는 자식마다 적당히 오버라이딩 하계끔 강제하기 위해 사용함

# 4.6 접근 제어자

- 멤버 또는 클래스에 사용되어 외부로부터의 접근을 제한함
- 접근 제어자가 사용될 수 있는 곳
  - 클래스
  - 멤버변수
  - 메서드
  - 생성자

# 4.7

# 4.8 생성자의 접근 제어자

- 일반적으로 생성자의 접근 제어자는 클래스의 접근 제어자와 일치함
- 생성자에 접근 제어자를 사용함으로써 인스턴스의 생성을 제한할 수 있음

## 생성자

- 객체변수에 값을 무조건 설정해야만 객체가 생성될 수 있도록 강제하는 방법
- 이름이 클래스명과 동일하고, 리턴 자료형을 정의하지 않는 메서드 
- 생성자는 new 키워드를 사용해서 객체가 생성될 때 호출됨
```java
new 클래스명 (입력인수, ...)
```

```java
/* 예제 */
class HouseDog extends Dog {
  HouseDog(String name) {
    this.setName(name);
  }
}

// HouseDog클래스에 만든 생성자는 문자열로된 입력값을 필요로함
// 따라서 new 키워드로 객체를 만들 때 문자열을 전달해야 함

HouseDog dog = new HouseDog("왈왈이");  // 생성자 호출시 문자열을 전달해야 함
HouseDog dog = new HouseDog();  // compile error (메인메서드에서 에러 발생)
```




# 6.1 추상클래스란?

- 클래스가 설계도라면 추상클래스는 '미완성 설계도'
- 메서드 선언부만 있고 몸통(구현부)이 없는 메서드
```java
abstract class Player{
    int currentPos;  
    
    Player(){  // 추상클래스도 생성자가 필요
        currentPos = 0;
    }
    
    abstract void play(int pos); // 추상메서드
    abstract void stop();  // 추상메서드 - 정의는 했으나, 수행코드를 아직 정해지 못한 메서드  
  
    // 오버로딩
  void play() {
      plsy(currentPos);  // 추상메서드를 사용할 수 있음
  }
}
```

- 추상클래스는 객체생성은 안되고 상속만됨
- 미완성 설계도이므로 인스턴스는 생성할 수 없음
- 추상클래스는 다른 클래스를 생성하는데 도움을 줌

# 6.2 추상메서드란?

- 선언부만 있고 구현부(몸통)가 없는 메서드
- 메서드가 호출되었을 때 수행되어야 하는 코드블럭이 없음

```java
// 기본 꼴
abstract 리턴타입 메서드명(); 

// 추상메서드 예시
abstract void play (int pos);
```

- 꼭 필요하지만 자손마다 다르게 구현될 것으로 예상될 경우 사용
- 오버라이딩했다 (자손에 맞게 ~)는 것은 ~
- 하나도 오버라이딩을 못하면 자손은 추상메서드에서 벗어날 수 없음.

# 6.3 추상클래스의 작성

## 추상클래스를 언제 도입할 것인가에 대한 판단
- 여러 클래스에 공통적으로 사용될 수 있는 추상클래스를 바로 작성
- 기존클래스의 공통 부분을 뽑아서 추상클래스를 만듦

```java
class Marine{  // 보병 
    int x,y;
    void move(int x, int y){ /* 지정된 위치로 이동 */}
  void stop() {/* 현재 위치에 정지 */}
  void stimPack() {/* 스팀팩 사용 */}
}

class Tank {
  int x, y;  // 현재위치

  void move(int x, int y) { /* 지정된 위치로 이동 */}

  void stop() {/* 현재 위치에 정지 */}

  void changeMode() {/* 공격모드를 변환 */}
}

class Dropship{
    int x,y;
  void move(int x, int y){ /* 지정된 위치로 이동 */}
  void stop() {/* 현재 위치에 정지 */}
  void load() {/* 선택된 대상을 태움 */}
  void unload() {/* 선택된 대상을 내림 */}
}
```

- 메서드의 매개변수 타입을 Object로 하면 얘네 3개 말고도 다른애들도 올 수 있음 (Object를 상속하는 객체라면 누구든 올 수 있음 - 문자열 객체, Date 객체 등)
- 얘네 3개만 오게하고 싶으면 공통 멤버를 빼서 얘네들만의 부모 클래스를 만드는게 좋다. (다행히도 얘네는 상속하고 있는 부모가 없다.) 
- 이 부모는 얘네를 묶는 역할일 뿐이지, 단독으로 사용할수는 없다
- Unit은 얘네를 단순히 하나로 묶을 목적이지 따로 Unit을 사용할 목적이 없으므로 추상 클래스로 작성하자
- 자손마다 수행코드가 달라져야하는 경우 원하는 만큼 추상형으로 정의
- 매개변수의 타입을 Unit형으로 하면 Unit 객체, Unit 자손의 객체만 올 수 있다. 하지만 Unit은 추상 클래스이므로 객체를 생성할 수 없음. 따라서 원하는 만큼 마린,탱크, 드랍쉽의 ~을 생성할 수 있음

```java
abstract class Unit
```


## 예제

- 객체 생성하려면 추상클래스이면 안됨
- 추상클래스도 부모로부터 물려받은 멤버는 내것처럼 사용 가능

```java
package day0315.course;

abstract class Shape {
	String color;

	abstract void draw();

	void setColor(String color) {
		this.color = color;
	}
}

class Circle2 extends Shape {
	void draw() {
		System.out.println(color + " 원을 그리는 기능");
	}
}

class Rectangle2 extends Shape {
	void draw() {
		System.out.println(color + " 사각형을 그리는 기능");
	}
}

class Triangle2 extends Shape {
	void draw() {
		System.out.println(color + " 삼각형을 그리는 기능");
	}
}

public class AbstractTest2 {
	public static void main(String args[]) {
		Shape s = new Circle2();
		s.setColor("파란색");
		printInfo(s);
		s = new Rectangle2();
		s.setColor("분홍색");
		printInfo(s);
		s = new Triangle2();
		s.setColor("연두색");
		printInfo(s);
	}

	static void printInfo(Shape obj) {
		obj.draw();
	}  // Shape을 상속하면 draw 메서드를 반드시 오버라이딩 해야 함
}

```

- 오버라이딩시 접근 제어자가 동일하거나 넓어져야 함.
- draw 메서드는 접근제어자가 default이므로 자식 클래스의 draw에 private을 붙이면 에러발생
  (상속받은 메서드를 오버라이딩 하는건데 접근권한을 축소시키면 안됨)


```java
package day0315.course;


abstract class Pet {
	public abstract void petSound();  // 추상메서드는 반드시 오버라이딩 해야 함 (접근 제어자가 public. 상속받은 얘들도 접근 제어자가 public이어야함. 접근 권한을 축소시키면 안됨)

	public void sleep() {
		System.out.println("Zzz");
	}  // 일반 메서드는 오버라이딩이 선택사항임
}
class Dog extends Pet{
	public void petSound() {
		System.out.println("멍멍!!");
	}   // petSound 오버라이딩
}
class Cat extends Pet{
	public void petSound() {
		System.out.println("야옹~~");
	}  // petSound 오버라이딩
}
public class PetTest {
	public static void main(String[] args) {
		actionPet(new Dog());
		actionPet(new Cat());		
	}	
	static void actionPet(Pet obj) {  // 매개변수 Pet형. Pet을 상속하고 있는 애라면 누구든 전달될 수 있다는 것. Pet은 멤버가 2개
		obj.petSound();   // Pet의 petSound는 미완성. 하지만 전달되는 애들은 오버라이딩 되어야 함 (그래야 객체 생성이 가능). 이자리에는 Pet이 전달하는 petSound를 제대로 구현하는 애들만 올 수 있음 (제대로 오버라이딩 했음을 약속)
	    // 자손이 객체 생성이 가능함 = 자손이 petSound와 같은 메서드를 제대로 오버라이딩한 것
		obj.sleep();	
	}
}

```


# [과제](../../mobile/MobileTest.java)

```java
package mobile;

abstract class Mobile{
    private String mobileName;
    private int batterySize;
    private String osType;

    public Mobile(){}
    public Mobile(String mobileName, int batterySize, String osType){
        this.mobileName = mobileName;
        this.batterySize = batterySize;
        this.osType = osType;
    }

    /* abstract method */
    public abstract void operate(int time);
    public abstract void charge(int time);

    /* getter & setter */
    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public int getBatterySize() {
        return batterySize;
    }

    public void setBatterySize(int batterySize) {
        this.batterySize = batterySize;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }
}

class Ltab extends Mobile{
    public Ltab(){};
    public Ltab(String mobileName, int batterySize, String osType){
        super(mobileName,batterySize,osType);
    };
    public void operate(int time){
        setBatterySize(getBatterySize()-10*time);
    };
    public void charge(int time){
        setBatterySize(getBatterySize()+10*time);
    };
}

class Otab extends Mobile{
    public Otab(){};
    public Otab(String mobileName, int batterySize, String osType){
        super(mobileName,batterySize,osType); // super 메서드를 통해 조상 생성자 처리
    };
    public void operate(int time){
        setBatterySize(getBatterySize()-12*time);
    };
    public void charge(int time){
        setBatterySize(getBatterySize()+8*time);
    };
}


public class MobileTest {
    public static void main(String[] args) {
        /* 객체 생성 */
        Mobile mobL = new Ltab("Ltab", 500, "ABC-01");
        Mobile mobO = new Otab("Otab", 1000, "XYZ-20");

        printTable();
        printMobile(mobL);
        printMobile(mobO);

        System.out.println("\n[ 10분 충전 ]");
        printTable();
        mobL.charge(10);
        printMobile(mobL);
        mobO.charge(10);
        printMobile(mobO);

        System.out.println("\n[ 5분 통화 ]");
        printTable();
        mobL.operate(5);
        printMobile(mobL);
        mobO.operate(5);
        printMobile(mobO);
    }

    /* 모바일 정보 출력 */
    public static void printMobile(Mobile mobile) { // 매개변수가 모바일형 (모바일의 자손을 전달하겠구나! 하고 예측 가능)
        System.out.printf(mobile.getMobileName() +"     " +mobile.getBatterySize() +"        " +mobile.getOsType()+"\n");
    }

    /**/
    public static void printTable(){
        System.out.printf("Mobile\t Battery \t OS\n");
        System.out.printf("----------------------------\n");
    }
}

```

- 이름이 이탤릭체
  - 추상클래스 혹은 추상 메서드임을 뜻함
- getter, setter의 getXXX, setXXX
  - 각 멤버변수들을 뜻함
- abstract
  - 활용 제어자 (혹은 일반 제어자)
- 일반적으로 접근 제어자를 먼저 작성하고 활용제어자를 이후에 작성함

- 메서드를 만들 떄에는 단일 책임 원칙
  - 메서드 하나당 하나의 기능을 수행하게끔 설계하는것이 좋다

- 객체 중 조상객체도 포함되어 있을 수 있는데, 오버라이딩한 것이 우선적으로 처리됨. 
항상 자손객체 영역부터 찾아가서 메서드를 불러오고 없으면 조상으로 올라감.

# 과제2

```java
package work;

abstract class Plane{
  private String planeName;
  private int fuelSize;

  /* 기본 생성자 */
  public Plane(){}   // create 표시 -> 생성자 메서드
  public Plane(String planeName, int fuelSize){
    this.planeName = planeName;
    this.fuelSize = fuelSize;
  }

  /* GETTER & SETTER */
  public void setPlaneName(String planeName) {
    this.planeName = planeName;
  }

  public int getFuelSize() {
    return fuelSize;
  }

  public void setFuelSize(int fuelSize) {
    this.fuelSize = fuelSize;
  }

  public String getPlaneName() {
    return planeName;
  }

  /* refuel -> 일반 메서드 */
  public void refuel(int fuel){
    fuelSize += fuel;
  }

  public abstract void flight(int distance);
}

class Airplane extends Plane{
  public Airplane(){};
  public Airplane(String planeName, int fuelSize){
    super(planeName,fuelSize);
  };

  @Override
  public void flight(int distance) {
    setFuelSize(getFuelSize()-3*distance);
  }
}

class Cargoplane extends Plane{
  public Cargoplane(){};
  public Cargoplane(String planeName, int fuelSize){
    super(planeName, fuelSize);
  };

  @Override
  public void flight(int distance) {
    setFuelSize(getFuelSize()-5*distance);
  }
}

public class PlaneTest {
  public static void main(String[] args) {
    /* 객체 생성 */
    Plane pl[] = new Plane[2];
    pl[0] = new Airplane("L747",1000);
    pl[1] = new Cargoplane("C40", 1000);

    printInfo(pl);

    System.out.println("\n\t[100 운항]");
    for (int i=0; i< pl.length; i++){
      pl[i].flight(100);
    }
//        pl[0].flight(100);
//        pl[1].flight(100);
    printInfo(pl);

    System.out.println("\n\t[200 주유]");
    for (int i=0; i< pl.length; i++){
      pl[i].refuel(200);
    }
//        pl[0].refuel(200);
//        pl[1].refuel(200);
    printInfo(pl);
  }

  public static void printInfo(Plane[] list){
    System.out.printf("\t%s \t\t %s\n", "Plane", "fuelSize");
    System.out.printf("----------------------------\n");
    for (Plane el: list){
      System.out.printf("\t%s \t\t %d\n", el.getPlaneName(), el.getFuelSize());
    }
//        System.out.printf("\t%s \t\t %d\n", list[0].getPlaneName(), list[0].getFuelSize());
//        System.out.printf("\t%s \t\t %d\n", list[1].getPlaneName(), list[1].getFuelSize());
  }
}

```

- 지역변수와 멤버변수가 이름이 같은데 구분해야 할 때 `this`사용
- private을 다룰 때 getter & setter를 이용할 것
- Plane은 추상 클래스 
  - 직접 객체 생성할 수 없음

# 런타임 클래스

- [자바11 DOC](https://docs.oracle.com/en/java/javase/11/docs/api/index.html)

- [java.base 모듈](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/module-summary.html)
- [java.lang 패키지](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/package-summary.html)
  - 자동으로 import 되는 가장 기본 패키지
  - 언제든지 가져다가 쓸 수 있음
  - java.lang에 소속된 인터페이스 리스트 ~ 클래스 리스트 등이 나옴
  
- Runtime 클래스
  - 생성자가 private형

- 생성자로 객체생성할 수 없고, 다른 방법으로 객체를 생성해야하는 API가 자바상에는 약 15%정도 존재

```java
package day0315.course;

import java.io.IOException;

public class RuntimeTest {
  public static void main(String[] args) throws IOException {
    Runtime r = Runtime.getRuntime();  // 팩토리 메서드 -> 객체를 만들어주는 메서드 -> 객체를 1번만 만들 수 있도록 설계되어 있음
    // 객체 생성시 우리가 일반적으로 알고있는 Runtime r = new Runtime(); 꼴로 생성할 수 x
    // constructor가 invisible (private 설정되어서 감춰진 것) (모든 클래스는 최소 1개의 생성자가 존재)
    // 따라서 생성자를 통해 객체생성을 할수는 없고 일반 메서드를 통해 객체 생성을 함.
    // Runtime 클래스 내의 static형은 getRuntime안해도 호출 가능

    Runtime r1 = Runtime.getRuntime();
    Runtime r2 = Runtime.getRuntime();

    System.out.println(r);
    System.out.println(r1);
    System.out.println(r2);
    r.exec("c:/windows/notepad.exe");  // 메모장 기동
  }
}
```

- 이 Runtime이 JVM임
- JVM에 대한 객체도 1개만 만들어지는게 맞다. 
- Runtime을 가지고 특별한 행위를 할 수 있다 => 메모장 기동 (JVM에게 부탁하는 것)
- 런타임 객체는 JVM에 대한 객체임. 
- 런타임 객체는 하나의 자바 프로그램이 수행되는 동안 하나의 객체만 생성되도록 설계 되어있음 
(생성자를 감추고 팩토리 메서드로 객체 생성을 하도록 만들어져있음)
- 참조형 변수를 출력하라고 하면 참조형 변수의 toString을 출력함 -> `클래스명@참조값` 꼴로 출력
- 런타임 객체는 하나만 만들어져서 얘만 리턴함. (싱글톤 패턴)
- 스프링에 의해 관리되는 자바 빈 객체도 기본적으로 싱글톤 패턴
- 자바 클래스들 중에는 싱글톤 패턴을 지원하는 클래스를 만들기 위해 생성자를 감추는 경우가 있다
- 이 경우 셍성자 메서드의 접근 제어자는 `private`이다
