# Interface

- 어떤 인터페이스를 상속해야하는 경우, 모두 오버라이딩 하지 않아도 에러가 안날 수 있다.
- 이 경우는 default 메서드가 조상에게 있었던 것이다. (자손에 의해 오버라이딩이 선택적으로 적용될 수 있음)
- 필요한 경우 언제든지 그냥 호출할 수 있는 static 메서드와 자손에 의해 상속을 선택적으로 할 수 있는 defautl 메서드를 추가할 수 있도록 유연한 인터페이스 구성을 하도록 자바가 확장되었따.


- 자식에서 미완성 메서드는 무조건 오버라이딩을 해주어야 함

```java
package day0317.course;

interface InterCalculator {

	int add(int x, int y); //  얘는 미완성이므로 자손이 오버라이딩 해야함

	int sub(int x, int y); //  얘는 미완성이므로 자손이 오버라이딩 해야함

	default int mul(int x, int y) { 
		return x * y;
	}
	
	static void print() {		 // 부모것과 자식것이 구분되므로 오버라이딩 하는것이 의미없음 
        System.out.println("사칙 연산 처리");
    }
}

class Calculator implements InterCalculator {

	@Override
	public int add(int x, int y) {
		return x + y;
	}

	@Override
	public int sub(int x, int y) {
		return x - y;
	}
	
	/*@Override
    public int mul(int x, int y) {  // 오버라이딩을 해도그만, 안해도 그만임. 주석풀어도 에러나지 않음
        System.out.println(x + "와 " + y + "를 곱합니다.");
        return x * y;
    }*/
	
	public int div(int x, int y) { // 자식에서 추가함
		if (y != 0)
			return x/y;
		return 0;
	}
}

public interface InterfaceTest3 {
	public static void main(String[] args) {
		InterCalculator cal = new Calculator();
		// 인터페이스도 다형성 적용 - 자손 객체를 조상 인터페이스 변수에 담아서 사용할 수 있음
		// 자식 클래스 객체 - new Calculator();의 Calculator();
		
		System.out.println("5 * 3 = " + cal.mul(5, 3));
		System.out.println("5 + 3 = " + cal.add(5, 3));
		System.out.println("5 - 3 = " + cal.sub(5, 3));
		System.out.println("5 - 3 = " + ((Calculator)cal).div(5, 3));
		InterCalculator.print();		
	}
}

```


## case1

- 엘지TV와 삼성TV는 호출스택이 다르다.


## case2

- 유지보수의 용이성을 위해 TV 인테페이스 추가함
- 호출되는 메서드의 스펙(메서드명, 리턴값의 사양 등)을 ~
- 인터페이스 내에 TV 객체라면 이러한 기능을 갖춰야해! 라며 스펙을 정의함
- TV가 제시한 미완성 메서드를 각각의 기능에 알맞게 LgTX와 SamsungTv에서 오버라이딩 함.
- 해당 인터페이스의 타입으로 참조하도록 만듦.
- 각 객체 tv는 서로에게 의존적이지 않게 됨. (각각 메서드를 호출해서 기능을 수행할 수 있게 됨)
- 아쉬운 점
  - 유저가 삼성티비, 엘지티비로 처리할 수 있도로 객체생성하는 부분도 수정을 해주어야 함
  - case3에서 이를 보완

<br>

# 예외 처리

## 오류 유형

1. 컴파일 오류
   - 주로 구문에 위배된 구형을 했을 때 발생
   - 
2. 실행 오류
   - 실행 파알이 있다는 것은 컴파일 오류는 없다는 ㅓㄳ
   - 에러 (Error)
     - 자바 프로그램이 실행하는 동안 JVM영역에서 발생된 오류
     - 심각한오류
     - 에러 발생시 JVM이 ~
     - OutOf~
     - 스택오버플로우 에러
     - OS의 오류에 해당됨
   - 예외
     - 자바 프고로그램이 실행되는 동안 자바 프로그램 영역에서 발생하는 오류
     - 가벼운 오류
     - 예외에 대한 대처코드를 구현하여 적용할 수 있다.
     - 항상 발생하는 것은 아니며, 발생할수도/하지 않을수도 있다
     - 예외 발생시 메모리상에 예외객체가 생성된 것 (사고 객체가 생성된 것)
     - 예외처리를 사용해서 해결
     - 예외처리 종류
       - 런타임 예외 (발생원인이 프로그램 내부에 있음)
         - 발생할 수도 있는 에러에 대한 처리코드 구현이 선택적 (구현하지 않는 경우 JVM이 대신해줌)
       - 일반혜외 (발생원인이 프로그램 외부에 있음)
         - 발생할 수도 있는 에외에 대한 처리코드 구현이 필수

# 예외처리 구문 관련 키워드
- 
## 적극적인 예외처리
- try
- catch
- finally

## ? 
- throw

## 소극적인 예외처리
- throws
  

## throws절

- 예외가 발생할 수 있음을 알림
- 경우에 따라 Interrupted Exception이 발생할 수 있음
- thorws절 뒤의 예외클래스가 런타임클래스이면 신경쓰지 않아도 됨
- throws절의 90% 정도는 일반예외임
- 조상중에 런타임 Exception이있는지 아닌지에 따라서 일반 예외인지 런타임예외인지를 파악할 수 있음
- 일반 예외는 예외처리가 필수읾. (예외처리를 하지 않으면 호출할 수 없음)
- [참고자료](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Thread.html)

- 모든 예외 클래스들의 고통 조상은 Exception임
- 자바에서는 Error 클래스도 있음 (에러가 발생하는 것돋)

- 예외발생시 나를 호출한 애한테 넘김
- 

## try - catch

```java
class EX{
    public static void main(String[] args) {
        try{
            // 예외가 발생할 수도 있는 코드
        } catch (처리하려는예외클래스타입의변수선언) {
            // 예외발생시 try블록 수행한 다음 catch 블록을 수행
        } catch (처리하려는예외클래스타입의변수선언){
            
        } finally {
            // fianlly는 선택사항. 작성시 하나만 써야하며 생략할 수 있음.
            // 예외 발생여부와 관계없이 수행하려는 코드 
        }
    }
}
```

# ExceptionTest2 (try - catch)

- runtime exception
  - 예외처리를 해도되고 안해도됨

```java
package day0317.course;
public class ExceptionTest2 {
	public static void main(String[] args){
		System.out.println("수행시작");
		try {
			int num1 = Integer.parseInt(args[0]);
			// 인자로  넘겨준것이 아무것도 없으므로
			// 여기서 ArrayIndexOutOfBoundsException 발생

			int num2 = Integer.parseInt(args[1]);
			int result = num1/num2;
			System.out.println("연산 결과 : "+result);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("프로그램 아규먼트를 2 개 전달하세요!!");
		} catch (ArithmeticException e) {
		 System.out.println(e.getMessage());
			System.out.println("두번째 프로그램 아규먼트는 0이 아닌 값을 전달하세요!!");
			return;   // 프로그램이 끝남. JVM에게로 돌아감. 어떤상황이든 finally를 수행하고 리턴함.
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("프로그램 아규먼트로 숫자를 전달하세요!!");
		}  finally {
			System.out.println("항상 수행!!");
		}
		System.out.println("수행종료");  // return문 떄문에 얘는 실행되지 않을수도 있다
	}
}
```

- 인자로 1과 0을 준 경우
```java
package day0317.course;
public class ExceptionTest2 {
	public static void main(String[] args){
		System.out.println("수행시작");
		try {
			int num1 = Integer.parseInt(args[0]);
			// 인자로  넘겨준것이 아무것도 없으므로
			// 여기서 ArrayIndexOutOfBoundsException 발생
          // 이떄 더이상 try구문 수행하지 않고 바로 catch 블록으로 넘어감

			int num2 = Integer.parseInt(args[1]);
			int result = num1/num2;
			System.out.println("연산 결과 : "+result);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("프로그램 아규먼트를 2 개 전달하세요!!");
		} catch (ArithmeticException e) {
		 System.out.println(e.getMessage());
			System.out.println("두번째 프로그램 아규먼트는 0이 아닌 값을 전달하세요!!");
			return;   // 프로그램이 끝남. JVM에게로 돌아감. 어떤상황이든 finally를 수행하고 리턴함.
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("프로그램 아규먼트로 숫자를 전달하세요!!");
		}  finally {
			System.out.println("항상 수행!!");
		}
		System.out.println("수행종료");  // return문 떄문에 얘는 실행되지 않을수도 있다
	}
}
```
- 자바든 어떤 숫자든 0으로 나누면 Arithmetic Exception이 발생. 아리스매틱 익셉션 객체를 받을 수 있는 catch 블록을 찾아감. 아리스매틱 객체를 처리할 수 있는 catch블록임.
- 무조건 순서대로 첫 catch블록부터 잧아가서 Arithmetic Exception 객체를 받을 수 있는지 물어봄. 못받으면 건너뜀. 그리고 그 다음 캐치블록으로가서 똑같은 동작 수행함.
- e.getMessage
  - 에러메시지를 꺼내줌. 
  - Arithmetic Exception발생시 `/by zero`처럼 에러메시지 던져줌
  - Arithmetic Exception에 대한 객체정보를 e에게 줌

- 수행 결과
```java
수행시작
/ by zero
두번째 프로그램 아규먼트는 0이 아닌 값을 전달하세요!!
항상 수행!!
```

- 인자가 10 abc인 경우

```java
수행시작
프로그램 아규먼트로 숫자를 전달하세요!!
항상 수행!!
수행종료
java.lang.NumberFormatException: For input string: "abc"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
	at java.base/java.lang.Integer.parseInt(Integer.java:652)
	at java.base/java.lang.Integer.parseInt(Integer.java:770)
	at day0317.course.ExceptionTest2.main(ExceptionTest2.java:10)
```
- 밑에서부터 위로 읽는것이 맞다.
- 이 콜스택정보를 통해 최소한 몇행에서 에러가 났는지를 알 수 있다 (C언어는 얘를 못받아서 디버거를 통해서 찾아다님)

- Exception
  - 모든 예외클래스의 조상

- ArrayaIndexOutOfBoundsException형만 잡을 수 있는 블록
```java
catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("프로그램 아규먼트를 2 개 전달하세요!!");
		}
```

- 다형성 이용 예시 (에러 발생 코드)
```java
package day0317.course;
public class ExceptionTest2 {
  public static void main(String[] args){
    System.out.println("수행시작");
    try {
      int num1 = Integer.parseInt(args[0]);
      // 인자로  넘겨준것이 아무것도 없으므로
      // 여기서 ArrayIndexOutOfBoundsException 발생

      int num2 = Integer.parseInt(args[1]);
      int result = num1/num2;
      System.out.println("연산 결과 : "+result);
    } catch(Exception e){
      System.out.println("예외발생");
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("프로그램 아규먼트를 2 개 전달하세요!!");
    } catch (ArithmeticException e) {
      System.out.println(e.getMessage());
      System.out.println("두번째 프로그램 아규먼트는 0이 아닌 값을 전달하세요!!");
      return;   // 프로그램이 끝남. JVM에게로 돌아감. 어떤상황이든 finally를 수행하고 리턴함.
    } catch (NumberFormatException e) {
      e.printStackTrace();
      System.out.println("프로그램 아규먼트로 숫자를 전달하세요!!");
    }  finally {
      System.out.println("항상 수행!!");
    }
    System.out.println("수행종료");  // return문 떄문에 얘는 실행되지 않을수도 있다
  }
}
```

- 위의코드는 에라가 발생함. 이를 수정하면 다음과 같음
  - 제일 조상인 `Exception e`부분을 catch중 가장 아래에 위치시키자. 
  - catch블록은 위에서부터 처리함. 자손 예외클래스에 대한 catch블록일수록 위에작성하고 조상 예외클래스에 대한 catch 블록일수록 아래에 작성하는것이 좋다.

```java
package day0317.course;
public class ExceptionTest2 {
	public static void main(String[] args){
		System.out.println("수행시작");
		try {
			int num1 = Integer.parseInt(args[0]);
			// 인자로  넘겨준것이 아무것도 없으므로
			// 여기서 ArrayIndexOutOfBoundsException 발생

			int num2 = Integer.parseInt(args[1]);
			int result = num1/num2;
			System.out.println("연산 결과 : "+result);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("프로그램 아규먼트를 2 개 전달하세요!!");
		} catch (ArithmeticException e) {
		 System.out.println(e.getMessage());
			System.out.println("두번째 프로그램 아규먼트는 0이 아닌 값을 전달하세요!!");
			return;   // 프로그램이 끝남. JVM에게로 돌아감. 어떤상황이든 finally를 수행하고 리턴함.
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("프로그램 아규먼트로 숫자를 전달하세요!!");
		}  catch(Exception e){
			System.out.println("예외발생");
		} finally {
			System.out.println("항상 수행!!");
		}
		System.out.println("수행종료");  // return문 떄문에 얘는 실행되지 않을수도 있다
	}
}
```

- printStackTrace
  - 예외의 상세내용 출력

# 예외 직접 발생시키기

## throw

- 예외를 발생시키는 문장
- 예외를 알리는 역할을 함
- 해당 메서드가 에러를 발생할 수 있음을 알려야 함
- 메서드의 throw절을 통해 에러가 발생할 수 있음을 알려주지 않으면 예외처리를 할 수 없음

```java
throw (지정할)예외객체
```

```java
/* IOException 클래스를 이용해서 객체 생성하는 식 */

throw new IOException("존재하지 않음")  
// 생성자를 통해 에러메시지를 초기화
// new: 객체를 주기위해 사용

```


## throws

- 예외가 발생할 수 있음을 알리는 문장
- 예외를 알리고(발생시키고) 넘기는 역할을 함
- `try-catch` 대신 throws를 이용해서 나를 호출한 애한테 예외를 넘길 수 있음

## 예외 클래스 만들기

- Exception을 상속해서 직접 예외 클래스를 만들 수도 있다

```java
package day0317.course;
import java.util.Random;

class TestException extends Exception {
	// 멤버 - 생성자 하나 가지고 있음
	// 얘는 객체 생성시 메시지 전달을 반드시 해야함 (최소한 null문자열처럼 비어있는 문자열이라도 전달해야 함)
	TestException(String message){
		super(message);
	}
}

public class ExceptionTest3 {
	// 콜스택에 main -> a -> b -> c 순서대로 올라감
	public static void main(String[] args)  {
		System.out.println("main()수행시작");
		a();
		System.out.println("main()수행종료");
	}
	static void a()  {
		System.out.println("a()수행시작");
		try {
			b();
		} catch (TestException e){	
			System.out.println("오류 발생 : "+e.getMessage());
		}
		System.out.println("a()수행종료");
	}
	static void b() throws TestException {
		System.out.println("b()수행시작");
		c();
		System.out.println("b()수행종료");
	}
	static void c() throws TestException {  // throws가 없으면 에러 발생
		System.out.println("c()수행시작");
		boolean flag = new Random().nextBoolean();
		if(flag){
			throw new TestException("<<:::::테스트로 예외발생시킴:::::>>"); 
            // 개발자 입맛대로 에러메시지 구현
		}else {
			System.out.println("ㅋㅋㅋㅋ");
		}	
		System.out.println("c()수행종료");
	}	
}
```

- 콜스택에 main -> a -> b -> c 순서대로 올라감
- 메인 메서드 수행이 끝나면 자바프로그램은 정상적으로 종료됨
- 에러메시지는 구현하는 사람이 원하는 대로 초기화하면 됨 

### TestException

- c의 조상중에 얘에대한 예외처리를 해주는것이 필수이다.
- b에서는 소극적이지만 나름대로 TestException에 대한 예외처리를 해주었다
  (throws는 소극적인 예외처리.)
- 만약 b옆에 throws TestException을 붙여주지 않으면 에러가 남
- `throws`는 예외를 발생시킴 (에러를 알림) + 에러를 처리함
- b메서드는 c메서드를 호출하면서 처리해야할 예외처리를 b에서 직접하지 않고 b메서드를 호출하는 메서드에 넘김 (throws TestException)
  (얘가 try-catch를 통해 직접적인 예외처치를 하지 않았으므로 b메서드를 호출하는 곳에서 try-catch를 통한 예외처리를 해주어야 함)

- a메서드에서 try-catch를 통해 TestException에 대한 예외처리를 함
