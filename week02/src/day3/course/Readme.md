# final

- final를 붙이면 상수(한번 초기화된 값은 바꿀 수 없는 변수)가 됨
- `final`은 `예약어(기능이 정해진 단어)` 임

## 상수

- 관례적으로 모두 대문자로 씀
- 어떤 명칭이 대문자로 쓰일 경우 상수라고 보면 됨

## 예약어인 final이 앞에 붙는 케이스

- 클래스 앞에 붙일 수 있음 (마지막 클래스라는 뜻)
- 메서드 앞에 붙일 수 있음 (마지막 메서드라는 뜻) 
<br> final이 붙으면
<br>상속할 수 없다
<br>메서드 오버라이딩 할 수 없다
<br>재정의 할 수 없다


- 변수 앞에 붙일 수 있음 (마지막 변수라는 뜻. 상수라는 뜻.)

<br>

#  for문

- 형태1
```java
for (초기식; 조건식; 증감식){
	반복수행문장
	
}
```


- 형태2
```java
for (;;) // 무한루프. while(true)와 동일
```



- 추가 참고사항 (Java5)
```java
for (변수선언 : 배열 또는 컬렉션객체){
	배열이나 컬렉션 객체가 가지고 있는 데이터 값들에 대한 반복수행문장
}
```


<br>

# while문

- for문과 달리 반복횟수가 중요하지 않음 
- 조건이 만족되면 끝내고, 만족되지 않으면 계속 함

```java
while(조건식){  // 조건식은 연산결과가 boolean이 되는 식을 써야함
	반복수행문장
}
수행문장 // error. 컴파일러가 여기까지 도달하지 않을것이라는 에러메시지를 내뿜음.
```

<br>

# continue & break

```java
package day0308.day3;

public class ContinueTest {

	public static void main(String[] args) {
		int num;
		while(true) {
			num = (int)(Math.random()*31);
			if (num == 0) {
				System.out.println("\n종료");
				break;
			}
			if (num > 26) {
				System.out.println('@');
				continue;
			}
			System.out.printf("%d(%c)", num, (char)(96+num));				
		}
	}
}
```

- continue는 다시 조건식으로 올라가는 애임
- break는 조건문을 빠져나가는 애임

<br>

# printfTest

- printf는 개행기능을 기본적으로 제공하지 않으므로 개행하고 싶을때에는 본인이 직접 개행기능을 넣어야 함

## Java5 이전 vs 이후

### Java5 이전

```java
int exprSum(int[] p);

// 전달하고자하는 데이터를 배열에 담아서 전달
// 전달하고 싶은 데이터의 개수만큼 배열에 담아서 전달
```

### Java5 이후

- 가변형 인자를 전달하는 방법
```java
int exprSum(int... p) 
// int형 데이터가 0개이상 올 수 있다는 것 (개수 제한 없음) 
// 이로인해 printf가 사용 가능해짐
```




## 예제

```java
package day0308.day3;
public class PrintfTest {
	public static void main(String[] args) {
		System.out.printf("테스트입니당%n");	// argument 1개임
		System.out.printf("테스트%d입니당\n",10);		// argument 2개
		System.out.printf("테스트입니당%n");
		System.out.printf("%d %x %o %c\n", 100, 100, 100, 100);  // 10진수, 16진수, 8진수, 문자
		System.out.printf("%d %1$x %1$o %1$c\n", 100);  
// 포맷문자열과 매칭되는 값이 개수가 안맞으나 에러가 발생하지 않음 -> 1$때문임
// 1$는 첫번째 argument값을 여기다가 매칭하라고 강제시킨것.
// 1$가 없으면 각각이 1$, 2$, 3$... 처럼 나아가서 몇번쨰 argument를 매칭할 것인지를 나타냄

		System.out.printf("0x%X 0x%x\n", (int)'가', (int)'각');
// int를 안쓰면 type mismatch error (가를 바꿀수 없다는 에러발생)

		System.out.printf("%c %c %c %c\n", '가', 'A', '!', '3');
		System.out.printf("%b\n", true);
// %b -> boolean. (binary 아님)

		System.out.printf("%f %e\n", 100.0, 100.0);
		System.out.printf("%.2f\n", 123.5678);
// 소수점이하 몇번쨰 자리까지 나타낼것인지를 뜻함.

		System.out.printf("|%s|\n", "자바");
// %s -> 문자열 데이터를 출력할 때 사용 (s: string)

		System.out.printf("|%10s|\n", "자바");
//%와 s 사이에 오는것 -> 이 포맷을 이용해서 출력할때 출력할 공간의 너비 
// 기본적으로는 오른쪽 정렬

		System.out.printf("|%-10s|\n", "자바");
// (-) 붙이면 왼쪽 정렬

		System.out.printf("%,d원\n", 1000000);			
// %와 d 사이에 ,를 넣으면 단위 구분자가 됨 (1000단위마다 ,를 찍어줌)

	}
}
```


- 포맷 문자열
    - %d 같이 %로 시작하는 문자
    - 포맷 문자열의 개수에 맞춰서 argument를 전달해야 함


- 16진수는 숫자와 함께 A~F까지의 알파벳도 함께 쓰인다
- 16진수는 나타낼 때에는 앞에 0x를 붙이는것이 관례이다


- `|` : 파이프 기호


- %와 d 사이에 `,`를 넣으면 단위 구분자가 됨 (1000단위마다 ,를 찍어줌)

<br>

# breakcontinueTest1

```java
package day0308.day3;
import java.util.Scanner;
public class BreakContinueTest1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num;
		int factNum;
		while(true) {
			System.out.print("양의 숫자를 입력하숑 : ");			
			num = input.nextInt();
			if (num > 0)
				System.out.println("입력된 숫자 --> "+num);
			else {
				System.out.println("양수를 입력하지 않아서 수행 종료!!");
				break;  // while문을 빠져나감 (for문이든, while문이든 해당 반복문 빠져나감0
			}	
			factNum = 1;
			for (int i=1; i <= num; i++)
				factNum *= i;
			System.out.println(num+"! --> "+factNum);
		}
		input.close();
// 써주지 않으면 error


		System.out.println("수행 끝!!");
	}	
}
```


## 예제 분석

```java
Scanner input = new Scanner(System.in);
```

- 입력을 기다리는 블로킹 상태 (input 블로킹)
- 입력될 떄 까지 무한정 기다림
- GUI가 아닌 텍스트 모드에 최적화된 API

```java
Scanner input = new Scanner();  // argument로 뭘 주냐에 따라 읽어들이는 것이 다름
```

```java
num = input.nextInt();   // 숫자 입력을 기다림. 여기서 숫자를 입력받음. 
```


- 자바는 System.out과 System.in이 가장 중요한 역할을 하는 API임

### System.in
    
- 표준 입력 장치(키보드)에 대한 기능을 처리

### System.out

- 표준 출력 장치(화면, 스크린)에 대한 기능을 처리
- 표준 출력 장치(화면, 스크린)로 출력해주는 기능을 가지고 있는 API

<br>

# 알아두면 좋은 개념

## formatter와 명시적 인덱스를 함께 사용하기

```java
/* Explicit argument indices may be used to re-order output.*/

formatter.format("%4$2s %3$2s %2$2s %1$2s", "a", "b", "c", "d")
// -> " d  c  b  a"
```


## formatter & 명시적 인덱스 예시2

```java
package day3;

public class ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("%2$d %1$d",1,1+64);  // 65 1
	}

}
```

- `%2$d`: 두번째 것을 decimal 형태로 출력


- `%1$d` : 첫번째 것을 decimal 형태로 출력

<br>

# 듀크 & 턱시


- 듀크 (자바의 마스코트)
  - [듀크 자바 마스코트 - Google Search](https://www.google.com/search?q=듀크+자바+마스코트&oq=듀크+자바+마스코트&aqs=chrome..69i57.3349j0j9&sourceid=chrome&ie=UTF-8)

- 턱시 (리눅스의 마스코트)
  - [리눅스 턱시 - Google Search](https://www.google.com/search?q=리눅스+턱시&source=lnms&tbm=isch&sa=X&ved=2ahUKEwju7NTm-cv9AhWfmlYBHTIABfUQ_AUoAXoECAEQAw&biw=939&bih=576&dpr=1.25)

