# 자바의 메서드

- 자주 사용되는 프로그램 코드를 정의하는 단위

- 자바에서는 함수를 지원하지 않고 메서드를 지원함.
- 함수는 단독으로 사용할 수 있음 vs 메서드는 객체를 통해서 사용할 수 있음
- 익명객체를 이용한 람다함수라는 애는 뒤늦게 포함됨.

- 자바의 api도 다 메서드임
<br>(System.out.println은 화면에 내보내 주는 메서드임)

## main()

- main 이라는 특수 메서드는 `자바 프로그램에서 수행의 시작점의 역할`을 함

- JVM에게 자바 클래스를 넘겨주면서 실행해달라고하면 내부에는 반드시 main 메서드가 있어야 함.
<br>(JVM이 실행할 때 main메서드를 가장 먼저 찾음)

- 리턴값이 없으므로 void로 지정

### main()에 public을 붙이는 이유

- 어디서든, 누구든지 호출할 수 있게 만들기 위함

### public static void main의 static

-  메모리의 영역을 고정시킴

<br>

# 메서드 생성 방법

## 1. (어떤 기능을 수행하는 메서드인지)기능에 따라서 메서드 명을 정함
- 메서드명은 소문자로 시작 (생성자 메서드 제외.)


## 2. 메서드를 정할 때 매개변수, 리턴값 등을 미리 정해야 함



- 매개변수
  - 메서드가 호출될 때(자바상 메서드 사용은 메서드를 호출하는 것) 데이터를 전달받는 변수 
  - 매개변수는 메서드 오버로딩을 지원함
    
 
- argument: 메서드가 호출할 때 전달하는 데이터 (실질적으로 전달되는 데이터)
  - 인자로 `식,리터럴 등`이 올 수 있음


```java
System.out.printf("%d %d %c %f",sum, sum*10, 'A', Math.random() );  
// printf를 호출하면서 전달하는 argument들은 5개임.
// printf - 첫번째 인자는 반드시 문자열이어야 함. (나머지는 원하는 대로.)
```

<br>



# 메서드 정의

```java
[제어자] 리턴값 타입 메서드명([매개변수 선언]){  // 여기까지가 메서드 헤더
	수행문장;
	[return 리턴값];
}
```

- 메서드 정의시 제일앞에 제어자가 올 수 있고, 리턴값의 타입이 올 수 있다. 그리고 메서드 명이 옴. 메서드명 뒤에는 소활호를 붙여야 함

- 메서드는 만들 떄에든, 호출할 때에는 모두 소괄호를 붙여야 함.
<br>(소괄호 내에 필요한만큼의 매개변수를 선언)

- 수행문장이 있든 없든 블록지정은 필수임

- 일반 메서드는 반드시 코드 블럭이 있어야 함.

- 우리가 만들게 되는 메서드는 main 메서드인데, main 메서드가 static이다보니 테스트하는 메서드들도 static을 붙여주어야 편하게 테스트할 수 있다.

<br>

# 메서드 사용

- 메서드의 기능이 필요할 때 호출이라는 방법으로 사용함

- js같은 언어는 메서드들을 일반적인 값처럼 사용가능 (자바는 이처럼 사용할 수 없고, 필요할때 메서드를 호출만 함)

```java
메서드명([arguments])  // 호출만 한 것
변수 = 메서드명([arguments]); 
// 대입 연산자의 r-value로 호출식을 사용할 수 있음
// 리턴값이 있는 메서드만 이렇게 사용할 수 있음 (리턴값이 없으면 error 발생)
```

<br>

# mainmethod1

```java
public static void main(String[] args){

}
```

- args라는 변수명은 마음대로 바꿔도 됨

```java
package day5.course;

public class MethodTest1 {
    public static void main(String[] args) {
        System.out.println("main() 수행시작");
        printMyName();
        System.out.println(1);
        printMyName();
        System.out.println(2);
        printMyName();
        System.out.println(3);
        System.out.println("main() 수행종료");
    }

    static void printMyName() {
        System.out.println("유니코");
        return;
    }
}
```

- 두 메서드 중 메인메서드가 먼저 실행됨.

- 자바 프로그램에 있어 클래스는 기본단위임.

- 클래스 내부에 원하는 만큼의 메서드를 정의할 수 있음

- 메인 메서드가 static이 아니면 안됨.

- 우리가 오늘 만드는 메서드들은 static을 붙일것 (다음부터는 안붙여도 됨)

- 리턴값이 없다면 메서드 앞에오는 타입대로 메서드를 리턴함.

<br>

# 에러 발생 코드

```java
package day5.course;

public class MethodTest1 {
    public static void main(String[] args) {
        System.out.println("main() 수행시작");
        printMyName();
        System.out.println(1);
        printMyName();
        System.out.println(2);
        printMyName();
        System.out.println(3);
        System.out.println("main() 수행종료");
    }

    static void printMyName() {
        System.out.println("유니코");
        return 100; // 앞에서 void라고 써주었는데 (없다고) 리턴값을만들어 주었으므로.
    }
}
```

- printMyName은 호출만 할 수 있는 케이스임
- return은 호출한곳으로 되돌아가라는 뜻.

- 메인 메서드는 JVM이 호출해줌

- 메인 메서드의 수행내용이 다 끝나면 호출한애에게 되돌아가므로 JVM으로 되돌아감. 이후에 자밮 ㅡ로그램이 정상 종료됨



```java
package day5.course;

public class MethodTest2 {
    public static void main(String[] args) {
        System.out.println("main() 수행시작");
        printMyName(10);
        System.out.println("main() 수행종료");
    }

    static void printMyName(int num) {
        for (int i = 1; i <= num; i++)
            System.out.println("유니코");
    }
}
```

- 출력하고 싶은 만큼 aurgument 전달

(메서드릃 한번만 출력하고 끝내는 것 방지)

```java
package day5.course;

public class MethodTest3 {
    public static void main(String[] args) {
        System.out.println("main() 수행시작");
        printMyName(1, '#');
        System.out.println("--------------");
        printMyName(3, '*');
        System.out.println("--------------");
        printMyName(2, '@');
        System.out.println("--------------");
        printMyName((int) 3.14, '%');
        System.out.println("main() 수행종료");
    }

    static void printMyName(int num, char deco) {
        for (int i = 1; i <= num; i++)
            System.out.println(deco + "유니코" + deco);
    }
}
```

- 매개변수가 2개

- 호출시 매개변수에 알맞게 인자를 전달해야 함 (순서도 맞아야 함)

<br>

# MethodTest4

```java
package day5.course;

public class MethodTest4 {
    public static void main(String[] args) {
        System.out.println("main() 수행시작");
        printMyName(3, '*');
        printMyNameStr("듀크", '$');
        printMyNameStr("듀크", '$');
        printMyNameStr("듀크", '$');
        printMyNameStr("턱시", '!');
        System.out.println("main() 수행종료");
    }

    static void printMyName(int num, char deco) {
        for (int i = 1; i <= num; i++)
            System.out.println(deco + "유니코" + deco);
    }

    static void printMyNameStr(String name, char deco) {
        System.out.println(deco + name + deco);
    }
}
```

- 자바는 메서드 오버로딩을 지원함

<br>

# 메서드 오버로딩

```java
package day5.course;

public class MethodTest4_1 {
    public static void main(String[] args) {
        System.out.println("main() 수행시작");
        printMyName(3, '*');
        printMyName("듀크", '$');
        printMyName("듀크", '$');
        printMyName("듀크", '$');
        printMyName("턱시", '!');
        System.out.println("main() 수행종료");
    }

    static void printMyName(int num, char deco) {
        for (int i = 1; i <= num; i++)
            System.out.println(deco + "유니코" + deco);
    }

    static void printMyName(String name, char deco) {
        System.out.println(deco + name + deco);
    }
}
```

- 같은 공간 (같은 클래스, 같은 조상을 가진 클래스) 내에 동일한 이름의 메서드를 여러 개 정의하는 것

- 반드시 반드시 매개변수 사양은 달라야 함.

- 두 메서드명은 동일하지만 타입이 다름.

- 오버로딩의 장점 
  - 메서드 명을 각각 정해주지않고 그대로 적어주면 됨.



```java
package day5.course;

public class MethodTest4_1 {
    public static void main(String[] args) {
        System.out.println("main() 수행시작");
        printMyName(3, '*');
        printMyName("듀크", '$');
        printMyName("듀크", '$');
        printMyName("듀크", '$');
        printMyName("턱시", '!');
        System.out.println("main() 수행종료");
    }

    static void printMyName(int num, char deco) {
        for (int i = 1; i <= num; i++)
            System.out.println(deco + "유니코" + deco);
    }

    static void printMyName(String name, char deco) {
        System.out.println(deco + name + deco);
    }

    static void printMyName
}
```

```java
package day5.course;

public class MethodTest5 {
    public static void main(String[] args) {
        System.out.println("main() 수행시작");
        int result = operate(10, 20);
        System.out.println("호출 결과1 : " + result);
        System.out.println("호출 결과2 : " + operate(100, 200));
        int result2 = operate(11, 22) % 2;
        if (result2 == 0)
            System.out.println("호출 결과3 짝수");
        else
            System.out.println("호출 결과3 홀수");
        System.out.println("호출 결과4 : " + operate(100, 200, 300));
        System.out.println(getName());
        System.out.println("*" + getName() + "*");
        System.out.println("main() 수행종료");
#}

    static int operate(int num1, int num2) { // 메서드 오버로딩
        return num1 + num2;
    }

    static int operate(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }

    static String getName() {
        return "김정현";
    }
}
```

```java
package day5.course;

public class MethodTest5 {
    public static void main(String[] args) {
        System.out.println("main() 수행시작");
        int result = operate(10, 20);
        System.out.println("호출 결과1 : " + result);
        System.out.println("호출 결과2 : " + operate(100, 200));
        int result2 = operate(11, 22) % 2;
        if (result2 == 0)
            System.out.println("호출 결과3 짝수");
        else
            System.out.println("호출 결과3 홀수");
        System.out.println("호출 결과4 : " + operate(100, 200, 300));
        System.out.println(getName());
        System.out.println("*" + getName() + "*");
        System.out.println("main() 수행종료");
    }

    static int operate(int num1, int num2) { // 메서드 오버로딩
        return num1 + num2;
    }

    static int operate(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }

    static String getName() {
        return "김정현";
    }
}
```

- 리턴값을 여러개 전달하고 싶은 경우 배열을 사용한다.

<br>

# 에러나는 예시

```java
package day5.course;

public class MethodTest5 {
    public static void main(String[] args) {
        System.out.println("main() 수행시작");
        int result = operate(10, 20);
        System.out.println("호출 결과1 : " + result);
        System.out.println("호출 결과2 : " + operate(100, 200));
        int result2 = operate(11, 22) % 2;
        if (result2 == 0)
            System.out.println("호출 결과3 짝수");
        else
            System.out.println("호출 결과3 홀수");
        System.out.println("호출 결과4 : " + operate(100, 200, 300));
        System.out.println(getName());
        System.out.println("*" + getName() + "*");
        System.out.println("main() 수행종료");
    }

    static int operate(int num1, int num2) { // 메서드 오버로딩
        return num1 + num2;
    }

    static int operate(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }

    static String getName() {
        return "김정현";
    }
}
```

### r-value

r-value (값으로 사용. 대입 연산자의 오른쪽에 사용)로 ㅅ ㅏ용하려면 리턴값이 있는 메서드만 r-value로 사용할 수 있음

특정 연산자의 피연산자로 사용

리턴결과를 여러번 사용할 거면 메서드를 변수에 넣기

메서드 호출은 비용이 드는 작업임 (호출되는 메서드에 갔다오는 비용이 든다.)

따라서 한 번 호출햇 ㅓ처리할 수 있다면 여러번 호출하는 것보다 한번만 호출해서 사용할 수 있도록 변수에 메서드를 넣을 수 있음

<br>

## MethodLab3

```java
package day5.hw01;

public class MethodLab3 {
    public static void main(String[] args) {
        boolean answer1 = isEven(10);
        System.out.printf("%d은 %s 입니다.", 10, answer1 ? "짝수" : "홀수");
        System.out.println();

        boolean answer2 = isEven(13);
        System.out.printf("%d은 %s 입니다.", 13, answer2 ? "짝수" : "홀수");
    }

    static boolean isEven(int num) {
        boolean result = (num % 2 == 0) ? true : false;
        return result;
    }
}
```

리턴값을 2번이상 사용할 경우에는 변수에 담을 것. 아니면 변수에 담지 말것

<br>

## MethodLab4

```java
package day5.hw01;

public class MethodLab4 {
    public static void main(String[] args) {
        int num1 = 0, num2 = 0, difference = 0;
        for (int i = 0; i < 5; i++) {
            num1 = (int) (Math.random() * 30) + 1;
            num2 = (int) (Math.random() * 30) + 1;
            difference = compareValue(num1, num2);
            System.out.printf("%d 와 %d 의 차는 %d 입니다.\n", num1, num2, difference);
        }
    }

    static int compareValue(int x, int y) {
        if (x == y) {
            return 0;
        } else {
            return Math.abs(x - y);
        }
    }
}
```

- for문 대신 while문을 사용할 경우 while문을 제어할 변수는 while문 밖에 선언하고, 내부에서 제어변수에 대한 조작을 가해야 함.

- 반복문 안에서 변수를 선언하는 것은 적합한지 고민을 해볼 것. (메모리 낭비의 우려가 있음)
<br> => 미리 선언해놓고 재사용하는게 좋다.

<br>


## MethodLab5

```java
public static void main(String[] args){
	for (int i=0; i
}

public static int getRandom(int n){
	return (int)(Math.random()*(n)+1);
}

public static int getRandom(int n1, int n2){
	int biggerNum = 0;
	int smallerNum = 0;

	if (n1 > n2){
		biggerNum = n1;
		smallerNum = n
	} else if (n1 < n2){
		biggerNum = n2;
		smallerNum = n1;
	} else {
		biggerNum = n1;
		smallerNum = n1;
	}
	return (int)(Math.random()*(n2-n1+1))+n2;
}
```

public 을 붙여야만 다른 패키지에서도 해당 메서드를 호출할 수 있다.

<br> 

## MethodLab2

```java
package day5.hw01;

public class MethodLab2 {
    public static void main(String[] args) {
        pick('@', 3);
        pick('%', 4);
        pick('A', 5);
    }

    static void pick(char chPicked, int numPicked) {
        for (int i = 0; i < numPicked; i++) {
            for (int j = numPicked - i - 1; j >= 0; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i + 1; j++) {
                System.out.print(chPicked);
            }
            System.out.println();
        }
    }

}
```

- 문자마다 너비가 다를 수 있다 → 이로인해 결과가 다르게 보일 수 있다.

- `~체`로 끝나는 애들이 고정너비를 지님 (ex. 돋움체)

- 폰트이름에 @가 들어간 애들
<br> => 한글이 옆으로 나옴 (우리눈에 보이는것의 반대로 보임. 90도로 회전되어서 나옴. 따라서 얘네는 쓰는게 아님!)

- 메서드를 정의할 때 메서드의 매개변수 사양은 기본형도 됨.

- 기본형은 실제 값을 다루는 타입임.

<br>

# 5. 참조 타입

# 기본형

byte (1byte)

short (2byte)

char (2byte)

int (4byte)

long (8byte)

float (4byte)

double (8byte)

boolean (1byte)

어떤 타입이냐에 따라 할당되는 크기가 달라짐

컴퓨터상 사이즈를 재는 기본단위가 byte

char빼고 모두 signed → 양/음의 값 모두를 저장할 수 있음

<br>

# 참조형

참조값을 저장하여 참조되는 대상을 다루는 타입

참조형은 결국 객채형이다

객체를 참조하는 타입이라는 뜻이다.

자바에서 배열은 객체다.

자바의 참조값은 4byte임

(참조값: 메모리상 각각의 객체가 만들어지고 나서 각각의 객체를 구분하기 위해 사용되는 논리적인 주소임. 물리적인 주소가 아님)

다른 메모리공간을 가리키는 용도의 변수이므로 ‘참조형’이라고 함

매개변수는 어떤 타입이든 사용할 수 있음

```java
// 메서드의 매개변수와 타입을 뭐로 지정하느냐는 개발자 마음임

m1 (int p1, int p2);

m2 (int[] p);  
// m2는 기본형 타입은 담을 수 없고 배열에 담아서 주라는 의미.
```

<br>

# 가변형

Java5에서 추가됨

```java
m3(int... p)   
// ...은 매개변수에만 사용가능
// ...을 쓰면 int 데이터 0개이상. 이라는 뜻임
// m3() , m3(1,2,3), m3(10), m3(new int[] {10,20,30}) 등 모두 가능.
// 완전히 가변형이므로 배열또한 전달 가능함
```

가변형 인자 하나만 갖는 메서드가 아니라 char형 데이터 1개 받고, 뒤에서는 원하는 만큼의 데이터 개수를 받을 수 있게끔 지정할 수 있음

```java
m4(char ch, int... p)

printf(String s, Object... o)
//printf는 실제로 이렇게 구성되어있다.
// 문자열 하나만 주고도 호출할 수 있고, 문자열 내에 포맷문자를 몇개 주느냐에 따라서
// Object... -> 어떤 타입의 데이터든 가능하다.는 뜻. 다형성을 공부하면 이해가 쉬움

m5(int... p, char ch)
// 허용하지 않음.
// 가변형 인자는 단독으로 쓰거나 뒤에 와야함.
// 그렇지 않으면 어디까지가 가변형인자인지 구분할 수 없음.
// 파이썬에서도 가변형 인자는 뒤에 와야함
```

<br>

# MethodTest6

```java
package day5.course;

public class MethodTest6 {
    public static void main(String[] args) {
        System.out.println("main() 수행시작");
        System.out.println(add(10, 100));
        System.out.println(add(10, 20, 30));
        int nums[] = {10, 20, 30, 40};
        //System.out.println("nums의 값 : "+nums);
        System.out.println(add(nums));
        System.out.println(add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println(add(new int[5]));
        System.out.println("main() 수행종료");
    }

    // 메서드 오버로딩
    static int add(int p1, int p2) {
        return p1 + p2;
    }

    static int add(int p1, int p2, int p3) {
        return p1 + p2 + p3;
    }

    static int add(int[] p) {
        //System.out.println("p의 값 : "+p);
        int sum = 0;
        for (int i = 0; i < p.length; i++)
            sum += p[i];
        return sum;
    }
}
```

System.out.println은 10개로 오버로딩 되어있음

System.out.print는 9개로 오버로딩 되어있음.

<br>

## MethodTest6_1

```java
package day5.course;

public class MethodTest6 {
    public static void main(String[] args) {
        System.out.println("main() 수행시작");
        System.out.println(add(10, 100));
        System.out.println(add(10, 20, 30));
        int nums[] = {10, 20, 30, 40};
        //System.out.println("nums의 값 : "+nums);
        System.out.println(add(nums));
        System.out.println(add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println(add(new int[5]));
        System.out.println("main() 수행종료");
    }

    // 메서드 오버로딩
    static int add(int p1, int p2) {
        return p1 + p2;
    }

    static int add(int p1, int p2, int p3) {
        return p1 + p2 + p3;
    }

    static int add(int[] p) {
        //System.out.println("p의 값 : "+p);
        int sum = 0;
        for (int i = 0; i < p.length; i++)
            sum += p[i];
        return sum;
    }
}
```

매개변수는 지역변수임.

메서드 호출시 방이 생성되고 메서드가 사라지면 사라짐.

매개변수도 배열을 같이 참조하게됨 (메서드가 호출되어 내부 로직을 수행하는 동안만.)

여기서는 nums와 p변수 모두 10,20,30,40을 담고있는 배열을 참조함.

이후에 p는 참조를 하지못하고 nums만이 얘를 참조하게 됨.

## MethodTest6_1

```java
package day5.course;

public class MethodTest6_1 {
    public static void main(String[] args) {
        System.out.println("main() 수행시작");
        System.out.println(add(10, 100));
        System.out.println(add(10, 20, 30));
        System.out.println(add(new int[]{10, 20, 30, 40}));
        System.out.println(add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println(add());
        System.out.println(add(10, 20, 30, 40, 50));
        System.out.println(add(11, 22, 33, 44, 55, 66, 77, 88, 99));
        System.out.println("main() 수행종료");
    }

    /*static int add(int p1, int p2) {
        return p1+p2;
    }
    static int add(int p1, int p2, int p3) {
        return p1+p2+p3;
    }*/
	/*static int add(int[] p) {
		int sum = 0;
		for(int i=0; i < p.length; i++)
			sum += p[i];
		return sum;
	}*/
    static int add(int... p) {   // Java 5 부터 가변아규먼트 구문 추가
        int sum = 0;
        for (int i = 0; i < p.length; i++)
            sum += p[i];
        return sum;
    }
}
```

매개변수가 2,3개 있는 것을 주석 풀고 실행해도 에러나지 않음. 이 경우 매개변수가 개수가 적은것이 우선적으로 호출됨.

여기서 배열이 매개변수로 들어간것을 주석해제하면 에러 발생.

이것 이외에는 모두 …을 매개변수로하는것이 호출됨.

가변형 매개변수를 가지는 메서드를 호출하는것과 배열을 매개변수로 가지는 메서드를 호출하려고하면 에러발생 (같은것으로 보기 때문임)

…은 내부에서 배열처럼 쓰기 때문임. 배열을 받는것과 기능적으로 똑같이 구현됨.

단, 배열은 배열만 받지만 …은 데이터 하나하나도 받고 배열도 받고 모든 형태의 데이터를 다 받는것임

..을 받는 매개변수와 배열을 받는 매개변수는 같이 정의할 수 없음에 유의할것!

<br>

## MethodTest7

```java
package day5.course;

public class MethodTest6 {
    public static void main() {
        System.out.println("main() 수행시작");
        System.out.println(add(10, 100));
        System.out.println(add(10, 20, 30));
        int nums[] = {10, 20, 30, 40};
        //System.out.println("nums의 값 : "+nums);
        System.out.println(add(nums));
        System.out.println(add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println(add(new int[5]));
        System.out.println("main() 수행종료");
    }

    // 메서드 오버로딩
    static int add(int p1, int p2) {
        return p1 + p2;
    }

    static int add(int p1, int p2, int p3) {
        return p1 + p2 + p3;
    }

    static int add(int[] p) {
        //System.out.println("p의 값 : "+p);
        int sum = 0;
        for (int i = 0; i < p.length; i++)
            sum += p[i];
        return sum;
    }
}
```

- 메인메서드는 왜 String[] args를 매개변수로 받을까?

얘를 빼면 메인메서드가 없다는 에러가 발생함.

메인 메서드내에서 얘를 사용하든 안하든 반드시 선언은 하고 있어야 함.

변수명은 바꾸어도 되지만 대부분 args를 그대로 사용한다.

<br>

# 메인 메서드의 매개변수인 args는 어떤 용도로 사용될까?

리눅스 배울 때 copy명령어 배웠죠. (cp)

```bash
cp a.txt b.txt # a.txt를 읽어서 b.txt로 복사해라
```

cp라는 시스템을 실행하라는것.

cp에게 a.txt를 읽어서 b.txt로 복사해줘. 라고 cp라는 프로그램에것

```bash
cat a.txt   # a.txt의 내용을 화면에 내보내줘
```

얘네들을 명령행 argument (Command Line Argument)라고 함

자바 프로그램이 수행을 시작할 때, 원래는 `java 클래스명 a.txt` 처럼 입력함 (a.txt를 command line argument라 함)

웹에서는 얘를 쓸일이 없음.

자바 프로그램을 단독으로 실행시키거나 애플리케이션 시스템을 실행시킬 떄에나 의미가 있음.

이거를 전달받는 매개변수가 메인메서드의 매개변수이다.

String[] args

→ 자바가 정해놓기를 데이터를 문자열로 전달되게 만들어놓음.

new int[0]

→ element가 없는 배열

→ length가 0이 됨


아무것도 데이터를 넣지않고 메인메서드 호출시

→ jvm은 메인메서드를 호출할 때 argument를 비어있는 string형 배열을 전달함

<br>

# MethodTest7_1

```java
package day5.course;

public class MethodTest7_1 {
    public static void main(String[] args) {
        String result = "";
        for (int i = 0; i < args.length; i++)
            result = result + args[i];
        System.out.println(result);
    }
}
```

```java
package day5.course;

public class MethodTest7_2 {
    public static void main(String[] args) {
        int result = 0;
        for (int i = 0; i < args.length; i++)
            result = result + Integer.parseInt(args[i]);
        System.out.println(result);
    }
}
```

전달된 내용을 숫자로 바꿔줌.

우리가 전달하려는 것은 하나도 없음.

```java
package day5.course;

public class MethodTest8 {
    public static void main(String[] args) {
        System.out.println("main() 수행시작");
        char[] returnValue = getName(true);
        System.out.println(returnValue);
        System.out.println("main() 수행종료");
    }

    static char[] getName(boolean type) {
        char ary[];
        if (type)
            ary = new char[]{'J', 'A', 'V', 'A'};
        else
            ary = new char[]{'P', 'Y', 'T', 'H', 'O', 'N'};
        return ary;
    }
}
```

리턴값은 배열을 매개변수 타입으로 전달받음

메서드 호출시 배열객체를 리턴해줌

System.out.println은 char을 특별 취급해서 주소값이 아닌 객체의 내용을 출력해줌.

리턴값을 받을 때 같은 char 타입의 배열에다가 받아야 함

<br>

## MethodTest9

```java
package day5.course;

public class MethodTest9 {
    public static void main(String[] args) {
        int p1[] = {20, 10, 14, 30};
        System.out.println("p1 변수의 값 : " + p1);
        printArray(p1);
        int[] result = updateArray1(p1);
        printArray(result);
        printArray(p1);
        System.out.println("-------------------");
        updateArray2(p1);
        printArray(p1);
    }

    static void printArray(int[] p2) {
        for (int d : p2)
            System.out.printf("%d ", d);
        System.out.printf("\n");
    }

    static int[] updateArray1(int[] p2) {
        System.out.println("p2 변수의 값 : " + p2);
        int[] result = new int[p2.length];
        for (int i = 0; i < result.length; i++)
            result[i] = p2[i] * 2;
        return result;
    }

    static void updateArray2(int[] p3) {
        System.out.println("p3 변수의 값 : " + p3);
        for (int i = 0; i < p3.length; i++)
            p3[i] = p3[i] * 2;
    }

}
```

updateArray2

updateArray3는 return 값이 없음.

메서드가 호출될 떄 메모리의 방이 생성됨. 메서드 수행이 끝나면 해당 매개변수에 대한 메모리의 방은 사라짐.

<br> 

## MethodTest10

```java
package day5.course;

public class MethodTest10 {

    public static void main(String[] args) {
        int[][] nums = new int[5][3];
        int num = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++)
                System.out.print(nums[i][j] + "\t");
            System.out.println();
        }
        System.out.println();
        for (int j = 0; j < 3; j++) {
            for (int i = j; i < 5 - j; i++)
                nums[i][j] = num++;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++)
                System.out.print(nums[i][j] + "\t");
            System.out.println();
        }
    }
}
```

지난 과제내용이므로 주의깊게 봐둘것

위 내용을 메서드로 구현한것이 아래의 코드임

<br>

## MethodTest10_1

```java
package day5.course;

public class MethodTest10_1 {

    public static void main(String[] args) {
        int[][] nums = new int[5][3];
        int num = 1;

        printTwoArray(nums);

        System.out.println();
        for (int j = 0; j < 3; j++) {
            for (int i = j; i < 5 - j; i++)
                nums[i][j] = num++;
        }

        printTwoArray(nums);
    }

    static void printTwoArray(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++)
                System.out.print(nums[i][j] + "\t");
            System.out.println();
        }
    }
}
```