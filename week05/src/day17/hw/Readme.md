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

