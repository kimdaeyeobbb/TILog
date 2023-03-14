# 클래스

## 6.1 객체 지향 프로그래밍

- S/W 개발시 부품에 해당하는 객체를 먼저 생성하고 이 객체들을 하나씩 조립해서 완성된 프로그램을 만드는 기법

### 객체

- 물리적으로 존재하거나 개념적인 것 중에서 다른 것과 식별 가능한 것<br>
-  (물리적) 자동차, 자전거, 책  <br>  (개념적) 학과, 강의, 주문
- 속성(필드)과 동작(메서드)으로 구성됨

### 객체 모델링

- 현실 세계의 객체를 S/W 객체로 설계하는 것
- 현실 세계의 객체의 대표 속성과 동작을 추려내어 S/W 객체의 속성(필드)과 동작(메서드)로 정의하는 과정

### 객체의 상호작용

- 객체는 메서드를 호출하여 다른 객체의 기능을 이용함(다른 객체와 상호작용하면서 동작) 
- 메서드의 호출을 통해 객체들은 데이터를 주고 받음
- 메서드의 리턴값을 호출한 곳에서 변수로 대입받아서 사용함
```java
int result = add(70,80); // return value를 int형 변수 result에 저장
```

### 객체간 관계

- 집합 관계
- 사용 관계
- 상속 관계
  - 부모와 자식 관계를 뜻함
  - 부모의 특징인 필드, 메서드를 물려 받는 것

### 객체 지향 프로그래밍의 특징

#### 1. 캡슐화

- 객체의 데이터(필드), 동작(메서드)를 하나로 묶고 실제 구현 내용을 감추는 것
- 따라서 외부 객체는 객체 내부의 구조를 알지 못함 (객체가 제공하는 필드와 메서드만 이용가능)
- 자바는 `접근 제한자`를 이용해서 캡슐화된 멤버를 노출시킬지 여부를 결정함

#### 2. 상속

- 부모 객체가 자신이 가지고 있는 필드와 메서드를 자식 객체에게 물려주어 자식 객체가 사용할 수 있도록 하는 것
- 상속의 이점
  - 코드의 재사용성을 높여줌 
    - 잘 개발된 부모 객체의 필드&매서드를 자식이 그대로 사용할 수 있음
  - 유지 보수 시간을 줄여줌
    - 부모 객체에서 필드와 메서드를 수정하면 수정된 것을 자식이 그대로 사용할 수 있음


#### 3. 다형성

- 사용 방법은 동일하지만 실행 결과가 다양하게 나오는 성질
- 자동차 바퀴부품를 무엇을 끼느냐에 따라 자동차 성능이 달라지듯, 프로그램을 구성하는 객체(부품)를 바꾸면 프로그램의 실행 성능이 다르게 나올 수 있음

## 6.2 객체와 클래스

### 클래스

- 객체를 생성하는 설계도

### 인스턴스

- 클래스로부터 생성된 객체
- `인스턴스화`: 클래스로부터 객체를 만드는 과정

## 6.3 클래스 선언 

- 객체 생성을 할 수 있는 설계도인 클래스를 작성하는 작업
- `클래스명은 소스 파일명과 동일` 해야함

```java
public class 클래스명{
    
}   // 클래스 선언
```

- 클래스명
  - 첫문자: 대문자(숫자 X)
  - 캐멀 스타일로 작성
  - 특수 문자 $,_ 포함 가능

- 하나의 소스 파일(*.java)내에 여러 개의 클래스를 선언할 수 있음
- 소스 파일(*.java)을  컴파일시 바이트코드 파일(.class)는 클래스를 선언한 수만큼 생김
- 단, 하나의 소스 파일(*.java)에 여러 개의 클래스를 선언하는 경우 소스 파일명과 동일한 클래스만 public class로 선언할 수 있음

## 6.4 객체 생성과 클래스 변수

```java
클래스 변수 = new 클래스();
```
- new 연산자 
  - 뒤에 생성자 호출 코드가 옴
  - 객체를 생성시킨 후 객체의 주소를 리턴함


![img.png](img.png)

- 스택 영역에 생성된 클래스 변수는 힙 영역에 생성된 객체를 참조함



### 클래스의 용도

```java
/* Student.java */
public class Student{
    
}

/* StudentExample.java */
public class StudentExample {
    public static void main(String[] args){
        Student s1 = new Student();
        System.out.println("s1 변수가 Student 객체 참조");
        
        Studetn s2 = new Student();
        System.out.println("s2 변수가  또다른 Student 객체 참조");
    }
}
```

#### 1. 라이브러리 클래스

- 실행할 수 없으며 다른 클래스에서 이용하는 클래스

- Student

#### 2. 실행 클래스

- 메서드를 가지고 있는 실행 가능한 클래스

- StudentExample

## 6.5 클래스의 구성 멤버


```java
public class ClassName{
    int fieldName; // 필드 선언
  
    ClassName();   // 생성자 선언
  
    int methodName(){}   // 메서드 선언
}
```

- 필드
  - 객체의 데이터가 저장되는 곳

- 생성자
  - new 연산자로 객체를 생성할 경우 객체의 초기화 역할을 담당함

- 메서드
  - 객체가 수행할 동작
  

## 6.6 필드 선언과 사용

- 필드
  - 객체의 데이터를 저장하는 역할

```java
public class Car{
    /* 고유 데이터를 저장하는 필드 선언 */
  String company;
  String model;
  String color;
  int maxSpeed;
  
  /* 상태 데이터를 저장하는 필드 선언 */
  int speed;  // 현재속도
  int rpm;   // 엔진회전 수
  
  /* 부품 데이터를 저장하는 필드 선언 */
  Body body;  // 차체
  Engine engine;  // 엔진
  Tire tire;   // 타이어
}
```


### 필드 선언

- 필드는 반드시 클래스 블록에서 선언되어야 함
- 필드명은 첫 문자를 소문자로 작성해야 한다.
- 필드명은 카멜 스타일로 작성하는 것이 관례이다

```java
public class Car{
    String model = "람보르기니";  // 고유 데이터 필드
  int speed = 300;  // 상태 데이터 필드
  boolean start = true;  //  상태 데이터 필드
  Tire tire = new Tire();  // 부품 객체 필드
}
```



```java
public class Car {
    /* 필드 선언 */
  String model;
  boolean start;
  int speed;
  
  /* 생성자에서 필드 사용 */
  Car() {
      speed = 50;
  }
  
  /* 메서드에서 사용 */
  void method(){
      speed = 70;
  }
  
}

public class CarEx{
  public static void main(String[] args) {
    Car myCar = new Car();  // Car 객체 생성

    /* Car 객체의 필드값 읽기 */
    System.out.println(myCar.model);
    System.out.println(myCar.start);
    System.out.println(myCar.speed);
  }
}
```

### 필드 사용

- 필드값을 읽고 변경하는 행위
- 클래스로부터 객체가 생성된 이후에 필드(객체의 속성)를 사용할 수 있음
- 필드(객체의 속성)는 객체 내부의 생성자와 메서드 내부에서 사용할 수 있음 (객체 외부에서도 접근해서 사용가능)
  - 객체 내부: 필드명을 읽고 변경할 수 있음
  - 외부 객체: 참조 변수와 점(.)연산자를 이용해서 필드를 읽고 변경할 수 있음
  
```java
public class Car {
  /* 필드 선언 */
  String company = "쌍용";
  String model = "티볼리";
  String color = "회색";
  int maxSpeed = 300;
  int speed;
}

public class CarEx{
  public static void main(String[] args) {
    Car myCar = new Car();  // Car 객체 생성

    /* Car 객체의 필드값 읽기 */
    System.out.println(myCar.company);
    System.out.println(myCar.model);
    System.out.println(myCar.color);
    System.out.println(myCar.maxSpeed);
    System.out.println(myCar.speed);
    
    /* Car 객체의 필드값 변경 */
    myCar.speed = 60;  // 외부에서 필드 사용
    System.out.println(myCar.speed);  // 변경된 필드값 - 속도
  }
}
```


## 6.7 생성자 선언 및 호출

```java
클래스 변수  = new 클래스();  // 생성자 호출
```

- new 연산자
  - 객체 생성을 한 다음 생성자를 호출해서 객체를 초기화함

- 생성자가 성공적으로 실행이 끝나면 new 연산자는 객체의 주소를 리턴함
  - 리턴한 주소는 변수에 대입되어 객체의 필드나 메서드에 접근할 때 사용됨

### 기본 생성자

- 모든 클래스는 생성자가 존재하며, 하나 이상의 생성자를 가짐
- 클래스에 생성자 선언이 없는 경우 컴파일러는 바이트코드 파일(*.class)에 자동으로 기본 생성자를 추가함

```java
/* 소스 파일(Car.java) */
public class Car{}

/* 바이트코드 파일 (Car.class) */
public class Car{
    public Car(){}   // 컴파일러에 의해 자동으로 추가됨
}

/* new 연산자 뒤에 기본 생성자 호출 */
Car myCar = new Car();
```

- 클래스가 public으로 선언된 경우
  - 기본 생성자에도 public이 붙음
  - public 없이 class로만 선언되는 경우, 기본 생성자에 public이 붙지 않음

- 단, 명시적으로 선언한 생성자가 있는 경우 컴파일러는 기본 생성자를 추가하지 않음<br>
  (생성자를 선언하는 이유는 객체를 다양하게 초기화하기 위함임)


### 생성자 선언

- 생성자
  - 리턴 타입이 없음
  - 클래스명과 동일
  - new 연산자로 생성자를 호출
  - 생성자의 매개변수는 생성자를 호출할 때 매개변수값을 생성자 블록 내부로 전달함

```java

// 매개변수로 매개값을 대입 받음
// 매개값을 매개변수로 대입 받기 위해서 생성자가 선언되어야 함
public class Car {
    /* 생성자 선언 */
    Car(String model, String color, int maxSpeed){}
}

public class CarEx {
  public static void main(String[] args) {
    // Car 생성자 호출
    Car myCar = new Car("티볼리", "회색", 250);

  }
}
```

- 위 예시에서는 클래스 내에 직접 선언한 생성자가 있으므로 컴파일러는 기본 생성자를 추가하지 않음

### 필드 초기화

```java
public class Korean{
    /* 필드 선언 */
    String nation = "대한민국";
    String name;
    String ssn;
    
    /* 생성자 선언 */
    public Korean(String n, String s){
        /* 초기화 -> 객체 속성의 초기값으로 사용 */
      // 한국인이라 하더라도 이름과 주민번호는 각각 다르므로 생성자에서 객체의 속성을 초기화
        name = n;
        ssn = s;
    }
}
```

- 객체마다 동일한 값을 가지고 있을 경우 
  - 필드 선언시 초기값을 대입하는 것이 좋다
- 객체마다 다른 값을 가져야 하는 경우
  - 생성자에서 필드(객체의 속성)를 초기화하는 것이 좋다


### 생성자 오버로딩

