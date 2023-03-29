# 실습1

```
제출 소스명 : 소스27.zip
메일 제목 : 자바API실습6-XXX


구현 클래스명 : ThreadLab

다음의 기능을 수행하는 프로그램을 구현하여 제출한다.

main 스레드 : 자식 스레드 4개를 기동하고 수행이 끝날 때까지 대기하다가 
              "MAIN 수행 종료" 를 마지막에 출력하고 끝낸다.

자식 스레드 1 : 알파벳 대문자 A 부터 L 을 2초에 한 번씩 출력한다.
자식 스레드 2 : 알파벳 소문자 a 부터 h 를 3초에 한 번씩 출력한다.
자식 스레드 3 : 1 부터 30 까지 1초에 한 번씩 출력한다.
자식 스레드 4 : "JAVA"라는 문자열을 10번 5초에 한 번씩 출력한다.

모든 출력은 행 단위로 출력한다.
스레드 클래스명은 임의로 한다.

```


# 정답코드1

- 스레드 클래스를 적게 생성해서 구현해보자!

```java

```

- run()메서드는 throws로 예외처리할 수 없으므로 try-catch로 예외처리해야함


# 정답코드2

```java

```

- runnable 구현 
  - 실제 스레드 클래스가 아니므로 스레드 클래스의 객체는 생성해주어야 함
  - 이때 공급자역할을 하는 클래스 객체를 생성자를 통해 전달함


# 정답코드3

```java
enum TaskType{
    UPPER_CASE, LOWER_CASE, NUMBER, JAVA
}

public class TaskRunner implements Runnable{
    private final TaskType taskType; // 한번 값을 설정하면 바꿀일이 없으므로 final 설정
    
    // enum 내 1개만 받도록 만듦
    public TaskRunner(TaskType taskType){
        this.taskType = taskType;
    }
    
    @Override
    public void run(){
        switch (taskType){
            case UPPER_CASE:
                for(char c = 'A'; c<='L'; c++){
                    System.out.println(c);
                }
        }
    }
}
```

- 스레드 클래스 1개로 구현
  - 단, 객체는 4개 생성해야 함
  - 기동시키고 싶은 스레드의 개수만큼 스레드 객체를 만들어야함
  - 하나의 스레드객체는 한번의 start만 가능함

- Runnable이 아닌 Thread클래스를 상속하더라도 Thread 클래스 하나만으로 여러번 객체를 만들어서 과제를 수행할 수 있다


<br>

# 실습2

```
제출 소스명 : 소스28.zip
메일 제목 : 자바API실습7-XXX


구현 클래스명 : 제시된 패키지의 소스들을 수정하고 패키지를 압축하여 제출한다.
                   (소스는 3개)

소스를 보고 람다식으로 변경 가능하다고 판단되는 부분은 변경하여 제출한다. 소스 3개 모두~~~

```

## 기존코드

### AnnonyInnerLab.java

```java
package day17.hw.lamdalab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import day6.Book;
public class AnnonyInnerLab {
	public static void main(String[] args) {
		ArrayList<Book> al = new ArrayList<>();
		al.add(new Book("자바의 정석", "남궁성", 27000));
		al.add(new Book("챗GPT", "반병현", 11700));
		al.add(new Book("스타트 스프링 부트", "남가람", 27000));
		al.add(new Book("Doit! 자바프로그래밍", "박은중", 22500));
		al.add(new Book("이것이 자바다", "신용권,임경균", 36000));

		for (Book el : al) {
			System.out.println(el.getBookInfo());
		}

		Collections.sort(al, new Comparator<Book>() {
				@Override
				public int compare(Book o1, Book o2) {
						return o1.getPrice() - o2.getPrice();					
				}
			}
		);
		System.out.println("[소팅 후 ]");
		for (Book el : al) {
			System.out.println(el.getBookInfo());
		}
	}
}

```


### DrawableTest.java

```java
package day17.hw.lamdalab;

import java.util.Random;

interface Drawable {
	void draw();
}

public class DrawableTest {
	public static void main(String[] args) {
		Random rand = new Random();
		int num = rand.nextInt(3);
		Drawable d = null;
		if (num == 0)
			d = () -> System.out.println("사각형을 그립니다.");
		else if (num == 1)
			d = () -> System.out.println("원을 그립니다.");
		else if (num == 2)
			d = () -> System.out.println("마름모를 그립니다.");
		output(d);
	}

	public static void output(Drawable d) {
		System.out.println("전달된 객체의 클래스명 : " + d.getClass().getName());
		d.draw();
	}
}

```


### ThreadEx01.java

```java
package day17.hw.lamdalab;

class ThreadEx01 {
	public static void main(String args[]) {
		ThreadEx1_1 t1 = new ThreadEx1_1();

		Runnable r = new ThreadEx1_2();
		Thread t2 = new Thread(r); // 생성자 Thread(Runnable target)

		t1.start();
		t2.start();
	}
}

class ThreadEx1_1 extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(getName()); // 조상인 Thread의 getName()을 호출
		}
	}
}

class ThreadEx1_2 implements Runnable {
	public void run() {
		for (int i = 0; i < 5; i++) {
			// Thread.currentThread() - 현재 실행중인 Thread를 반환한다.
			System.out.println(Thread.currentThread().getName());
		}
	}
}

```


<br>

## 정답 코드

### DrawableTest.java

- 기존 코드

```java
import java.util.Random;

// 함수형 인터페이스
// 인터페이스도 컴파일시 클래스 파일이 만들어짐
interface  Drawable{
    void draw();
}

class Rect implements Drawable{
    /* 얘를 람다식으로 대신할 수 있음 */
    public void draw(){
      System.out.println("사각형을 그립니다.");
      // 이 body를 가지는 람다식을 만들어주면 됨
    }
}

class Circle implements Drawable{
    public void draw(){
      System.out.println("원을 그립니다.");
    }
}

class Diamond implements Drawble{
    public void draw(){
      System.out.println("마름모를 그립니다.");
    }
}

public class DrawableTest{
    public static void main(String[] args){
        Random rand = new Random();
        int num = rand.nextInt(3);
        Drawable d = null;
        if(num == 0){
            
        } else if(num == 1){
            
        } else if (num == 2){
            
        }
    }
}
```


- 람다식으로 바꾼 코드
```java
package day17.hw.lamdalab;

import java.util.Random;

interface Drawable {
	void draw();
}

public class DrawableTest {
	public static void main(String[] args) {
		Random rand = new Random();
		int num = rand.nextInt(3);
		Drawable d = null;
		if (num == 0)
			d = () -> System.out.println("사각형을 그립니다.");
		else if (num == 1)
			d = () -> System.out.println("원을 그립니다.");
		else if (num == 2)
			d = () -> System.out.println("마름모를 그립니다.");
		output(d);
	}

	public static void output(Drawable d) {
		System.out.println("전달된 객체의 클래스명 : " + d.getClass().getName());
		d.draw();
	}
}

```

- 객체가 필요한 부분에 람다식을 구현할 것
- 해당 객체는 인터페이스의 객체이며 추상 메서드를 1개만 가지고 있는 경우에 람다식으로 바꿀 수 있음
- 인터페이스도 컴파일시 클래스 파일이 만들어짐 (인터페이스도 특별한 형태의 클래스라 보면 됨)
- 람다식은 컴파일시 클래스 파일이 만들어지는 것이 아님
- 람다식은 익명 객체로 취급할 뿐임

### AnonyInnerLab.java

```java
package day17.hw.lamdalab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import day14.hw.Book;


public class AnnonyInnerLab {
	public static void main(String[] args) {
		ArrayList<Book> al = new ArrayList<>();
		al.add(new Book("자바의 정석", "남궁성", 27000));
		al.add(new Book("챗GPT", "반병현", 11700));
		al.add(new Book("스타트 스프링 부트", "남가람", 27000));
		al.add(new Book("Doit! 자바프로그래밍", "박은중", 22500));
		al.add(new Book("이것이 자바다", "신용권,임경균", 36000));

		for (Book el : al) {
			System.out.println(el.getBookInfo());
		}

		Collections.sort(al, (o1, o2) -> o1.getPrice()-o2.getPrice());

		System.out.println("[소팅 후 ]");
		for (Book el : al) {
			System.out.println(el.getBookInfo());
		}
	}
}

```

- new Comparator<Book>
  - Comparator는 제네릭 타입의 인터페이스

- [Comparator 참고자료](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Comparator.html)
- 구현해야되는 메서드가 매개변수 2개 리턴값 1개임 
- 매개변수에 Book이라는 타입을 지정해도 되고 지정하지 않아도 됨

- 자주 필요하다고 판단되면 이름있는 클래스로 만들고, 그게 아니라면 이름없이 구현해도 됨


### ThreadEx01.java

```java
package day17.hw.lamdalab;

class ThreadEx01 {
	public static void main(String args[]) {
//		Thread t1 = new Thread(() -> {
//			for (int i=0; i<5; i++){
//				System.out.println(Thread.currentThread().getName());
//			}
//		});
//
//		Runnable r = () -> {
//			for (int i=0; i<5; i++){
//				System.out.println(Thread.currentThread().getName());
//			}
//		};
//
//		Thread t2 = new Thread(r);
//        
        
        ThreadEx1)1 t1 = new ThreadEx1_1();
        Thread t2 = new Thread(() -> {
            for (int i=0; i<5; i++){
              System.out.println(Thread.currentThread().getName());
            }
        })

		t1.start();
		t2.start();
	}
}
```

- run메서드는 매개변수와 리턴값이 없음