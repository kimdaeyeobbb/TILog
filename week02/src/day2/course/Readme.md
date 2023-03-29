# 3. 연산자

## 프로그램에 존재하는 API 사용하기 - [RandomTest.java](RandomTest.java)

- 자바에서의 프로그램이 시작되었다 
  - (자바 프로그램 수행을 시키라고 전달한) 자바 클래스에 전달되어있는 메인 메서드가 호출되었다고 보면 됨
  - (프로그램 시작시) 메인 메서드의 body 부분이 수행됨


- 프로그램은 기본적으로 순차적으로 수행됨
- 즉, 메인메서드가 호출되면 (수행되면) body안의 내용 중 첫행이 수행되고 다음줄로 넘어가면서 차례대로 하나하나 수행됨


- ;(세미콜론) 단위로 묶여있는 한 단위를 `수행문장(수행명령)`이라함
  - 자바의 경우, 하나의 수행문장은 하나의 세미콜론으로 구분되어야 함

    
### 프로그램에 존재하는 api를 사용기

#### Math.random
   
  - 난수를 추출해주는 api 
  - 자바가 내장하고 있는 Math 클래스의 random 메서드를 호출한 것
  - 실수형 데이터를 반환함
  - 얘가 반환하는 값은 0.0 ≤ 값 < 1.0 사이의 값 (0이상 1미만의 값)
  - 추출된 난수에 *6을해서 소수점 이하를 날리면 0부터 5사이의 난수가 됨. 
  - 여기에 +1을 해주면 1~6사이의 숫자를 얻을 수 있음. (주사위 숫자)


- int
    - 실수형 데이터를 정수화하면 소수점 이하는 잘림 (무조건 절삭)

<BR>

## 자바의 산술 이항 연산 규칙

### 1. int 타입보다 작은 타입인 char, short, byte 형은 int 타입으로 변환되어 연산이 수행됨

- boolean은 제외. boolean은 참/거짓 판별만 하고, 산술연산을 할 수 없으므로

```java
char + char // 연산결과 : int
short + short // 연산결과: int 
byte + byte // 연산결과: int
```


### 2. 두 항의 타입이 다를 때에는 값이 손실되지 않는 범위 내에서 하나의 타입으로 일치시켜서 연산을 수행함

- 즉, 값이 손실되지 않으려면 더 큰 범위로 옮겨가는 것이다!

```java
char + long // 연산결과: long
int + long // 연산결과: long
long + float // 연산결과: float -> long보다 4byte인 float가 더 큰 값을 저장할 수 있음 
double + float // 연산결과: double
```

<br>

## 대입 연산

```java
l-value = r-value
```

- l-value가 r-value보다 더 크다면 자동 형 변환이 일어남
- r-value가 더 크다면 연산자를 이용해서 강제 형 변환을 해주어야 함 


<br>


## 강제 형 변환 방법

```java
l-value = (l-value의 타입)r-value
```

-  int형으로 지정시 소수점이하는 잘림  

<br>

## 형 변환상 예외

- boolean 
  - 다른 언어는 boolean의 활용에 대해 유연성이 존재함.
  - 자바는 이와 달리 boolean에 대해 상당히 엄격함. 
  - 그 어떤 타입도 형 변환 연산자를 사용해서 형 변환을 하려고해도 boolean이 될 수 없다. 
  - 반대로 boolean 또한 그 어떤 다른 타입도 될 수 없다.


<br>


## 증감 연산자

### 단항 연산자

- 리터럴은 프로그램에서 사용되는 데이터 값이므로 값 변경이 불가능 하다
- 따라서 단항연산자의 대상항으로 사용할 수 없다

- 변수만 단항연산자의 대상이 된다



- 전위형
- 후위형

```java
++num
num++
--su
su--
```

```java
int result = ++num;  
// ++연산자를 다른 연산자보다 먼저 수행해라. num 변수의 값을 1증가시키고 대입

int result = num++;
// 현재 num변수를 대입하고 나서 나중에 1증가시키라는 뜻

System.out.println()
// 괄호안에 작성된 값을 화면에 내보내라는 기능

System.out.println(num);
// 현재 num 변수의값을 출력시켜라

System.out.println(++num):
// 현재 num 변수의 값을 1증가시키고 나서 출력

System.out.println(num++);
// num 변수를 출력하고나서 1증가시킴
```


<br>

## 조건 연산자 (삼항 연산자)


```java
조건식(연산결과가 boolean 타입인 식) ? 참일때 수행할 식 : 거짓일때 수행할 식
```

### 예제 - [OperTest5.java](./OperTest5.java)

- 어떤식의 결과를 두번 이상 사용할 예정이면 변수에 담고, 1번만 사용할 거면 변수에 담는것은 자율적으로 선택할 것


### 예제 - [OperTest8.java](./OperTest8.java)

- 아스키테이블을 보면 소문자 a는 10진수로 변환했을 때 97, d는 10진수 변환시 100임.

- System.out.println()은 전달된 값이 char값이면 문자열 형태로 출력 (int형을 전달받으면 숫자형으로 출력) 
- cv는 char형에 담아서 주었으므로 알파벳 d가 출력됨.

### 예제 - [OperTest11.java](./OperTest11.java)

- 문자열은 객체이다.
- 문자열 비교시 ==가 아닌 문자열 객체가 가지고 있는 equals라는 API를 사용함

### 예제 분석 - [OperTest12.java](./OperTest12.java)

- 논리 and 연산자는 앞의 항인 num > 100 이 false니까 뒤의 항을 수행하지 않음
```java
System.out.println(num > 100 && ++num == 101); // false
```

- 논리 or 연산자는 앞의 항인 num > 100이 false이더라도 뒤의 항을 수행함
<br>(논리 or는 앞의 식이 거짓이면 뒤의식을 수행. 참이면 뒤의식을 수행x)

```java
System.out.println(num > 100 || ++num == 101); // true
```

<br>


## 복합 대입 연산자

- 예제

```java
package day2;

public class OperTest13 {

	public static void main(String[] args) {
		int result = 0;		
		result += 10;
		System.out.println("result=" + result);		
		result -= 5;
		System.out.println("result=" + result);		
		result *= 3;
		System.out.println("result=" + result);		
		result /= 5;
		System.out.println("result=" + result);		
		result %= 3;
		System.out.println("result=" + result);	
	}

}
```



## 4. 조건문과 반복문

### 예제 - [IfTest7_1.java](./IfTest7_1.java)


- grade가 초기화되지 않을 수 있기 떄문에 에러가 발생


- 해결방법
  1. char grade =’F’로 미리 초기화
  2. else 블록 주석 해제

<br>

## 4.3 switch문


- switch의 식은 정해진 타입만 올 수 있다.
- 식을 통해 등가비교를 수행함
- 다른 어느 부분에도 속하지 않으면 default로 빠짐 (default는 else처럼 생략 가능)
- switch문으로 구현하는 모든것들은 if-else if로 구현이 가능함
- 비교해야하는 것이 많아지면 if-else 대신 swtich를 쓰는것이 효율적


- switch문을 가지고 제어처리를 할 수 있는 데이터타입은
  - int (byte, short, char → int보다 작으므로 int형으로 자동 형 변환이 되니까. 얘네도 사용가능)
  - String
  - enum


- swtich문은 기본적으로 비교값이 어떤값이냐에 따라 case절에 있는 모든 수행문장을 수행하면서 내려감


```java
switch (식) {
    case 비교값1 : 수행문장1;
    case 비교값2 : 수행문장2;
                    수행문장3;  // 수행문장이 2개이상일 수 있다
    case 비교값3 : 수행문장4;
    default: 수행문장5;
            수행문장6;
}
```


- 비교값1이면 수행문장1만 수행하게, 비교값2면 수행문장2만 수행하게.. 만들고 싶다면 break를 추가하자

```java
switch (식) {
    case 비교값1 : 수행문장1;
                    break;
    case 비교값2 : 수행문장2;
                    수행문장3;  // 수행문장이 2개이상일 수 있다
                    break;
    case 비교값3 : 수행문장4;
                    break;
//break - 현재 블록을 꺠뜨리고 나가라. 즉, 밑으로 내려가지 않고 switch문을 빠져나가는 것
    default: 수행문장5;
            수행문장6;
}
```

<br>

# 4. 자바의 제어문

## 4.2 조건 제어문

- if, switch

## 4.3 반복 제어문

- 데이터들의 그룹, 집합을 가지고 반복할때 사용

### for

```java
for (초기식; 조건식; 증감식){
	반복수행문장;
}
```

- 반복횟수를 이미 알고 있을 때 사용
- 배열이나 컬렉션과 같이 데이터들의 묶음으로 반복하고자할 때 사용


### while

- 어떠한 조건이 만족되는 동안 반복

### do-while

<br>

## 4.7 ~ 4.8 분기 제어문

### 4.7 break

  - 빠져나감
  - switch문, 반복문 안에서 사용할 수 있음
  - break는 loop나 switch에서 사용할 수 있음


### 4.8 continue 

- continue를 굳이 안써도 되는데 쓰는 상황인 `데드코드`에 유의할 것
