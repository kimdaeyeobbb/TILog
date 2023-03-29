# 배열

- 같은 타입의 변수를 하나의 묶음으로 다루는 것

```java
/* 변수 사용*/
int score = 0, score=0, score3=0, score4=0, score5=0;

/* 배열 사용 */
int[] score = new int[5];   //  5개의 int 값을 저장할 수 있는 배열을 생성함 
```


## 배열의 특징


- 많은 양의 값(데이터)을 다룰 때 유용하다


- 배열의 각 요소는 서로 연속적이다


- 메모리에 데이터의 개수만큼 변수를 선언하는것은 변수의 개수가 많아지면 굉장히 불편하고 반복문을 쓰기가 불편하다 (변수명이 다 다르기 떄문이다)
  <br> => 따라서 데이터의 개수가 많아질수록 변수보다는 배열을 만들어서 사용하는게 좋다


- 대부분의 프로그래밍 언어는 배열을 내장하고 있다. (대부분 비슷한 형태를 띔)


## 변수냐 배열이냐

- 변수인 경우(리터럴이 아닌경우) 방을 만들어서 데이터를 담아야 함
- 변수를 사용하면 각각의 변수방이 따로 만들어짐

```java
/* 변수 사용*/
int score = 0, score=0, score3=0, score4=0, score5=0;
```

<br>

- 변수 여러개를 만드는 대신 배열을 이용함

```java
/* 배열 사용 */
int[] score = new int[5];   //  5개의 int 값을 저장할 수 있는 배열을 생성함
```

- 어떤 타입 (int, float등)의 데이터를 이용하느냐에 따라서 방의 사이즈가 달라짐
- 연속적으로 방이 잡힌 후 각각의 방을 찾아갈 때 인덱싱을 이용함

- 데이터량이 늘어날수록 변수보다는 배열을 쓰는것이 유리하다

<br>

# 배열의 생성 방법

## 1. 배열의 크기를 지정해서 배열을 생성하기

- `new` 라는 예약어를 사용 (객자바상에서 체 생성시 사용하는 구문)

```java
new 데이터타입[크기]  

new int[10];   // 10개의 int형 데이터를 다룰 수 잇는 데이터 객체 (10개의 방을 갖는 배열)
// 메모리상 10개의 방에는 int형 데이터가 들어감. 
// 배열은 어떤 타입이냐에 따라서 초기화되는 값이 달라짐
new boolean[5];   // boolean형 데이터 5개를 다룰 수 있는 배열
new char[26];  // 문자형 데이터 26개를 다룰 수 있는 배열 
```

- 한번 만들어진 방의 개수는 바꿀 수 없음
- 따라서 어쩔 수 없이 늘려야하면 더 큰 배열을 만들어서 이전 배열이 가지고 있는 데이터들을 모두 이사시켜야함. 
- 이러한 일이 빈번하게 일어나는 프로그램을 만드는 경우 `Linked List, Hash set`(링크드 리스트, 해시셋) 등을 사용하는 것이 좋다

## 2. 값을 가지고 배열을 생성하기

- 크기만 가지고 배열을 만들면 배열이 몇개의 element를 다룰 수 있는 배열인지를 결정함.
- 어떤 값들로 각각의 element들이 구성이 될지 아는 상황인 경우 값을 지정해서 배열을 생성할 수 있다

```java
/* 방법 1*/
{ 값1, 값2, 값3, ... }   // 기존의 C언어에서 넘어온 구문
// 배열 변수 선언을 공시할 떄만 사용가능 (제한적으로 사용)

/* 방법2 - 권장되는 방법*/
new 타입[]{값1, 값2, 값3, ...}  
// 방법1과 달리 언제든지 쓸 수 있다.
```

```java
/* 방법1 */
{1,2,3,4,5}
{'a','b','c'}

/* 방법2 */
new int[] {1,2,3,4,5};
new char[] {'a','b','c'};
```



- 우리가 배열을 생성하면 객체로 취급하며
배열내에 여러개의 데이터를 넣고, 필요할 때마다 꺼내서 쓰겠다는 것이다

- 배열을 사용할 때에는 변수에 배열을 담아서 사용한다.


<br>


# 배열 변수 선언 방법


- 배열의 내부에 여러 변수를 담아놓고 쓸 거면 배열을 변수에 담아서 사용해야함.

- 배열을 담아서 어떤 메서드에 전달하겠어.라고하면 생성해서 주면 끝이다


```java
타입[] 변수명;     
int[] nums;   
// int num;으로 선언시 int형 데이터값 하나만 저장할 수 있으나 배열 변수로 선언시
// 배열 객체를 담을 수 있게 됨

char[] characters; // 빈 괄호가 없으면 일반변수임

```

- 배열 객체는 독립적으로 공간이 할당되고, nums가 해당 배열을 가리키게 끔 참조값을 nums에게 넘겨줌

- 여기서 주소는 c언어의 주소(메모리상 물리적 주소)와는 다른 객체를 구분하는 논리적인 주소일 뿐임.

- 배열 변수는 누군가를 가리키는(참조하는) 변수이며 참조용이다

- 값을 보관하는 변수는 기본형임

<br>

# 배열의 사용 방법

```java
int[] nums = new int[10];
// nums에게는 배열의 참조값이 들어감
```

```java
int[] nums = new int[10];
nums.length;   // 1) 10 - 참조하게 되는 배열 객체의 크기 
nums[숫자인덱스];  // 2) 0~nums.length-1 까지의 값만 사용해야 함
```

#### 자바에서의 `.`이란?

- 연산자 (멤버연산자→ 참조하게 되는 멤버의 연산자를 사용)
- 구분자 (패키지 구분자 → )

#### 인덱스는 왜 0부터 시작했을까?

- C언어을 만든 개발자에게 물어봐야함. (C언어는 물리적 주소를 핸들링함. 따라서 이후에 나온 모든 언어들은 0부터 인덱싱)
- 자바에서 인덱스 범위를 넘어서면 쓰레기값이 출력되는 것이 아닌 인덱싱 에러가 발생함

## 예제

```java
package day0309.courese;

public class ArrayTest1 {
	public static void main(String[] args) {
		int[] score = new int[5];
		System.out.println(score);
		System.out.println(score.length);
		
		for (int i=0; i < score.length; i++)
			System.out.println(score[i]);
		
		for(int i=0; i < score.length; i++)
            score[i] = (i+1)*100;
		
		for (int i=0; i < score.length; i++)
			System.out.println(score[i]);
	}
}
```

- 배열을 다룰 떄에는 while문 대신 for문을 사용하는 것이 좋음

<br>

## enhanced for (for each)

```java
package day0309.courese;

public class ArrayTest1_1 {
	public static void main(String[] args) {
		int[] score = new int[5];
		System.out.println(score);
		System.out.println(score.length);
		
		for (int e : score)
			System.out.println(e);		

		// enhanced for문을 사용하지 못하는 부분
		for(int i=0; i < score.length; i++)
            score[i] = (i+1)*100;
		
		for (int e : score)
			System.out.println(e);
	}
}
```

- `:` 뒤에는 배열객체, 콜렉션 객체만 옴. 아무객체나 올 수는 없음.


- 객체가 가지고 있는 변수에 대한 변수 선언을 : 앞에 해주어야 함 . (int e : score 의 `int e`)


- 이때의 변수는 어떤 이름을 써도 좋지만 i보다는 e를 쓰는것을 권장함. (i는 index의 의미가 크다.)

- for each는 내부 로직을 수정할 수 없으므로 (앞에서 부터 하나하나 읽어서 처리하므로.) 수정을 하고싶을 경우 tranditional for (for문)를 사용해야 함

<br>


# ArrayTest2

```java
package day0309.courese;

public class ArrayTest2 {

	public static void main(String[] args) {
		int score[] = new int[5];		
		System.out.println(score);
		
		for (int i=0; i < score.length; i++)
			System.out.println(score[i]);
	
		int[] score1 = new int[]{100, 200, 300, 400};		
		System.out.println(score1);
		
		for (int i=0; i < score1.length; i++)
			System.out.println(score1[i]);
		
		int[] score2 = {1000, 2000};	// 배열변수 선언을 함께 하는 경우에만 가능	
		System.out.println(score2);
		for (int i=0; i < score2.length; i++)
			System.out.println(score2[i]);
		
		score2 = new int[]{11, 22, 33, 44, 55};  
// 이 시점부터 다른 객체인 {11,22,33,44,55}를 참조
// score2가 더이상 앞선 {1000,2000}을 참조하지않음
// 이 순간 {1000,2000} 은 사용할 수 없는 개체가 되어 가비지가됨 
// 가비지는 jvm이 관리함

		System.out.println(score2);  
// 위의 score2와 참조값이 달라질것임 (참조 대상이 다르므로)
		for (int i=0; i < score2.length; i++)
			System.out.println(score2[i]);		
	}
}
```

score1

- 4개의 요소(element)를 갖는 배열

score2

- 2개의 요소(element)를 갖는 배열

배열 변수 선언이 되어 있는 상태에서 새로운 배열을 생성하기 위해서 아래와 같이 사용하면 안됨.

```java
int[] score2;
score2 = {11,22,33,44,55};  // 이렇게 쓰면 안됨. 
score2 = new int{11,22,33,44,55}; 
// 이렇게 써야함. 어떤 타입의 배열인지 명시해야함
// 배열 생성식 붙이고 값 나열하기.
```

<br>

# ArrayTest3

```java
package day0309.courese;

public class ArrayTest3 {
	public static void main(String[] args) {
		boolean a1[] = new boolean[10];
		int a2[] = new int[5];
		long a3[] = new long[20];
		double a4[] = new double[3];
		
		System.out.println(a1);
		System.out.println(a1.length);
		
		System.out.println(a2);
		System.out.println(a2.length);
		
		System.out.println(a3);
		System.out.println(a3.length);
		
		System.out.println(a4);
		System.out.println(a4.length);
		
		a2 = new int[100];
		System.out.println(a2);
		System.out.println(a2.length);
		
	}
}
```

- 어떤 타입의 배열이냐에 따라 어떤 타입의 변수를 담아야하는지가 달라짐

```java
boolean a1[] = new boolean[10];
```

- 빈 괄호를 변수명 뒤에 줘도 됨

```java
boolean a1[] = new boolean[10];
System.out.println(a1);   //  [Z@5594a1b5
```

- @앞에는 이 배열 객체가 어떤 타입의 배열 객체인지에 대한 값이 나옴
- boolean형은 `[Z`로 등장

- `가비지` : 아무도 참조하지 않는 객체


<br>

# 토막상식

- C로 만든 프로그램을 OS가 직접 실행시킴

- 실행파일은 OS에따라서 내부 구조가 다르다

- 윈도우즈 OS에서 개발한 C는 윈도우에서만 실행이 가능함

- OS에 알맞은 실행구조를 가진 실행파일을 만들어준느 언어이기 때문이다.

- 자바는 OS와는 무관한 자바만의 실행파일이 만들어짐

- C/C++로 생성된 파일은 바이너리 파일(2진파일)이라고 함

- 자바 실행파일 byte code 파일이라고 함 (byte code로 구성됨. → os와는 무관하다)

- 자바 실행파일이 어느 os에서든 실행되도록 JVM이라는 인터프리터가 필요함
<br>(자바는 컴파일 & 인터프리터언어라고 함)


<br>

# 자바 파일

```java
xxxx.java -> javac를 거쳐서 -> xxxx.class를 생성 // .class는 자바 실행파일임
```

- `.java` : java 소스파일

- 이클립스는 실행파일을 같은 디렉토리가 아닌 src 하위의 자바소스파일만 보관하고, bin이라는 폴더 내에 똑같은 패키지으 ㅣ폴더구조가 존재하고 이 하위에 class 파일이 존재함 → .class 파일이 자바 실행파일임.

- `.class`는 byte code file이므로 파일을 열어보면 파일이 꺠져보이는 부분이 존재. (자바만의 실행 구조이므로 실행시키는 용도이지, 열어서 보는 용도는 아님)


- `.class`: 자바의 실행파일

- `javac` : 컴파일한다. 라고 함


- 이클립스, 인텔리제이 등은 개발자가 편하라고 자동으로 컴파일 해줌


- 이클립스, 인텔리제이 에서는 저장하고 나면 컴파일됨 (실행할 떄 컴파일 되는것이 아님)


<br>

# 자바파일2

```java
xxxx.java -> 컴파일 (javac) -> xxxx.class -> 실행(java) -> 
```

- 컴파일이 끝나고 나서 에러가 없으면 실행 파일(xxx.class)이 잘 만들어짐

- 실행시 자바라는 명령어를 통해 실행됨. 이 명령들은 jdk가 가지고 있는 명령들임 (`javac`, `java`)

- 파이썬은 컴파일 과정이 없으므로 완벽한 인터프리터언어임

- 자바는 컴파일 앤드 인터프리터 언어임

- 인터프리터 언어보다는 수행성능이 좋음. 파이썬 보다는 자바가 빠르다.

- 파이썬도 이를 보완하기 위해 네이티브 코드등을 사용하나 구조적 한계가 있음.

- 자바는 1차적으로 컴파일을 한번거침. 컴파일을 거친 결과를 가지고 실행하므로 빠른구조가 될 수 밖에 없다.

- 자바(xxxx.java)와 클래스명(xxxx.class)을 줘서 실행시킴.


<br>



# 자바의 2차원 배열

- 자바의 2차원 배열 저장형식은 array of array이다.

```java
new double[60]; // 60개의 요소를 갖는 1차원 배열

new double[5][12] // 5행 12열의 구조를 갖는 2차원 배열
```


## 2차원 배열 예시

```java
int[][] arr = new int[2][3];
// 1차원 배열의 참조값에 대한 배열이 생김
// 각 행마다의 열의값을 가지고 있는 1차원 배열이 추가로 생기는 것임 (열의 배열이라 함.) 
```

2차원 배열 변수가 참조하는 것은 행의 배열을 참조함 (열의 배열을 참조하지 않음)

`2차원배열.length`

- 행의 길이와 동일

- 각 행마다 열의 배열을 원하는 크기만큼 지정할 수 있다

```java
int [][] score = new int(5)[];
score[0] = new int[4];
score[1] = new int[3];
score[2] = new int[2];
score[3] = new int[3];
score[4] = new int[3];
```

<br>

# 2차원 배열의 생성

```java
new 타입[행의크기][열의크기];
{{첫번째 행의 데이터들}, {두번째 행의 데이터들}, {세번째 행의 데이터들}};
// 내부의 중괄호 개수가 행의 크기를 결정

/* 행의크기만 지정하고 열의 크기는 생략해도 됨 - 가변 배열*/
new 타입[행의크기][]
```

<br>

# 2차원 배열 변수

```java
타입[][]변수명;
타입 변수명[][];
타입[] 변수명[];
```

```java
변수명[행의인덱스][]
```


<br>

## TwoArrayTest1

```java
package day0309.courese;

public class TwoArrayTest1 {
	public static void main(String[] args) {
		int[][] two = new int[2][10];
		System.out.println(two);
		System.out.println(two[0]);
		System.out.println(two[0][0]);	
		System.out.println(two.length);
		System.out.println(two[0].length);
		
		for(int row=0;row < two.length;row++) {
			for(int col=0; col < two[row].length; col++)  // 각 행의 열의개수만큼 반복
				System.out.print(two[row][col]+" ");
			System.out.println();
		}
	}
}
```

- 2차원 배열 `two`에는 행의 배열의 참조값이 들어감

- `two[0]`에는 열의 배열의 참조값이 들어감

<br>

## TwoArrayTest2

```java
package day0309.courese;

public class TwoArrayTest2 {
	public static void main(String[] args) {
		int[] a1 = new int[10];
		char a2[] = {'가', '나', '다'};
		double a3[] = new double[5];
		System.out.println(a1.length + " : "+a2.length + " : " + a3.length);
		System.out.println(a1);		
		System.out.println(a2);  
// System.out.println -> char형 배열만 특별히 취급
// char형 배열의 element값들은 하나로 묶어서 출력 (나머지는 객체로 취급)
// 자바 개발 당시 개발자가 이렇게 설정함. 

		System.out.println(a3);
		System.out.println(a1[0]);		
		System.out.println(a2[0]);
		System.out.println(a3[0]);
		System.out.println();
		
		int[][] a4 = new int[5][12];
		System.out.println(a4);
		System.out.println(a4[0]);
		System.out.println(a4[1]);
		System.out.println(a4[2]);
		System.out.println(a4[3]);
		System.out.println(a4[4]);
		System.out.println();
		System.out.println(a4.length); 
		System.out.println(a4[0].length); 
		System.out.println(a4[1].length);
		System.out.println(a4[2].length);
		System.out.println(a4[3].length);
		System.out.println(a4[4].length);	
	}
}
```

<br>

## TwoArrayTest3

```java
package day0309.courese;

public class TwoArrayTest3 {
	public static void main(String[] args) {
		int[][] twoA = { {1,2,3}, 
				         {4,5,6}, 
				         {7,8,9}, 
				         {0,0,0} };		
		System.out.println(twoA); // 행의 배열의 참조값
		System.out.println(twoA[0]); // 첫 번째 행이 참조하는 열의 배열의 참조값
		System.out.println(twoA[0][0]); // 1행 1열의 값
		
		for(int row=0; row < twoA.length; row++) {
			for(int col=0; col < twoA[row].length; col++) {
				System.out.print(twoA[row][col]+"\t");
			}
			System.out.println();
		}		
	}
}
```

<br>

# TwoArrayTest4

```java
package day0309.courese;
public class TwoArrayTest4 {
	public static void main(String[] args) {
		int nums[][] = {
				         { 10, 20, 30},
				         { 11, 21, 31, 41},
				         { 12, 22}						
		               };
		int sum = 0;
		for(int i=0; i < nums.length; i++) 
			for(int j=0; j < nums[i].length; j++)
				sum += nums[i][j];
		System.out.println("전체 데이터의 합 : "+sum);
		
		int sumRow=0, sumCol=0;
		// 마지막 행의 데이터만 합산하여 sumRow에 저장
		for(int col=0; col < nums[2].length; col++)
			sumRow += nums[2][col];
		// 두번째 열의 데이터만 합산하여 sumCol에 저장
		for(int row=0; row < nums.length; row++)
			sumCol += nums[row][1];
		
		System.out.println("마지막 행 데이터의 합 : "+sumRow);
		System.out.println("두번째 열 데이터의 합 : "+sumCol);
	}
}
```

- 알고리즘 문제 대부분은 2차원 배열임

- 행의 개수와 열의 개수가 같으면 대각선을 논할 수 있음

<br>


# TwoArrayTest5

```java
package day0309.courese;
public class TwoArrayTest5 {
	public static void main(String[] args) {
		 int[][] emp = new int[5][];
	     emp[0] = new int[10];
	     emp[1] = new int[20];
	     emp[2] = new int[50];
	     emp[3] = new int[10];
	     emp[4] = new int[30];
	     
	     for(int row=0; row < emp.length; row++) {
	    	 for(int col=0; col < emp[row].length; col++)
	    		 System.out.print(emp[row][col] + " ");
	    	 System.out.println();
	     }
	}
}
```

- 2차원 배열 만들 때 행의크기는 주고 열의 크기는 비워놓을 수 있다