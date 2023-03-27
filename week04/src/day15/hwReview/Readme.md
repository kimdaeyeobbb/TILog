# 0324 과제 리뷰

# CreateBookLab

```java
package day16.hw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateBookLab {
    public static void main(String[] args) {
        /* DB연결을 위한 변수 선언 */
        String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "jdbctest";
        String passwd = "jdbctest";


        try( /* DB 연결을 위한 객체 생성 - 클로저블을 추가상속해야함 */
                Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement stmt = conn.createStatement();){
            /* 테이블 구성 정보 */
            stmt.executeUpdate("create table book " +
                    "(id int primary key auto_increment not null " +
                    ",title varchar(90)" +
                    ", price int" +
                    ", kind char(3))");
            System.out.println("book 테이블 생성 완료!");
        } catch (SQLException sel){
            System.out.println("오류 발생! 에러 메시지: " +sel);
        }
    }
}

```

- 테이블 구성 정보를 행 단위로 구분하면 가독성이 좋음


# InsertBookLab

```java
package day16.hw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertBookLab {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "jdbctest";
        String passwd = "jdbctest";
        int cnt=0;
        try(Connection conn = DriverManager.getConnection(url, user, passwd);
            PreparedStatement pstmt = conn.prepareStatement("insert into book(title,price,kind) values (?,?,?)");
            Scanner sc = new Scanner(System.in);){
            start: while(true){    // 반복문에 start 라는 라벨을 붙임
                /* 도서명과 가격 입력받음 */
                System.out.print("도서명을 입력하세요 : ");
                String title = sc.nextLine();
                System.out.print("가격을 입럭하세요 : ");
                int price = Integer.parseInt(sc.nextLine());
                
                /* 도서 분류에 대한 숫자 입력 */
                System.out.println("도서 분류에 대한 숫자를 입력하세요.");
                System.out.println("1. 프로그래밍 언어");
                System.out.println("2. 웹 프로그래밍");
                System.out.println("3. 빅데이터");
                System.out.println("4. 데이터베이스");
                System.out.println("5. 인프라");
                System.out.println("선택 (1~5) : ");
                
                System.out.println("정보가 입력되었습니다.");

                int kind = sc.nextInt();
                sc.nextLine();  // 입력버퍼 청소
                if (kind > 5 || kind < 1){
                    System.out.println("잘못된 입력입니다. 도서명부터 다시 입력하세요");
                    continue;  // 다시 while문 위로 올라가도록 만듦 (도서명부터 다시 입력)
                }
                
                /* 세팅 및 반영 */
                pstmt.setString(1,title);
                pstmt.setInt(2, price);
                pstmt.setString(3, "b0"+String.valueOf(kind)); 
                pstmt.executeUpdate();
                System.out.println("\nbook 테이블에 데이터 삽입 완료");
                cnt++;
                while(true){
                    System.out.println("계속 입력하시겠습니까? (y/n) ");
                    String aws = sc.nextLine();
                    if (aws.equalsIgnoreCase("n")){
                        System.out.println(cnt+"개의 데이터 입력 완료!");
                        break start;  // start라는 라벨을 가지는 반복문을 끝냄
                    } else if (aws.equalsIgnoreCase("y")) {
                        System.out.println();
                        break;  // 이 while문만 끝냄
                    } else {
                        System.out.println("y와 n 둘 중 하나를 입력하세요");
                        System.out.println("y는 계쏙하고 n은 그만하기 입니다.");
                    }
                }
            }
        } catch (SQLException se){
            System.out.println("오류 발생 : "+se.getMessage());
            se.printStackTrace(); // 콜스택 정보 출력
        }  // try-catch 구문을 사용하였으므로 close는 자동으로 수행
    }
}

```

- ?의 내용으로 title,price,kind가 들어가게 만듦
- b01 ~ b05 
  - b0라는 문자열 결합과 int형인 kind를 결합하는 아이디어 재활용 가능

- executeUpdate()
  - 프로그램 구현시 굉장히 중요함
  - 구현하지 않으면 세팅만하고 실행을 하지 않는 꼴임!

- try-catch 구문을 사용하였으므로 close는 자동으로 수행
- printStackTrace()
  - 메서드 자체가 출력을 수행

## InsertBookLab 코드2

```java

```

- while문 안에서 변수 선언하기 보다 밖에 선언하는게 좋다
  - 반복문을 수행하는 동안 변수가 계속해서 생성된다면 쓸데없이 메모리를 소비하게 되는 것이기 떄문이다

- 하나의 행에 `\n`을 입력하기 보다 코드 자체를 분리시켜서 입력하는 것이 좋다
- switch문을 이용하기보다 숫자를 분리시키는 것이 좋다
- 마지막 case 절은 break문을 주지 않는 것이 깔끔하다(어차피 마지막 case절 수행 후 끝나기 때문)
- continue를 안써도 되는 상황에서 사용하는 것은 적절하지 않다


# SelectBookLab

```java

public class SelectBookLab {
  public static void main(String[] args) {
      
      
    case 3: case 4: case 5: case 6:
        String str1 = "select title"
  }
}
```

- preparedStatement
  - 미리 명령 등록
  - 각 sql 명령 가지고 객체를 여러개 생성해야 함
  - [공식문서](https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/PreparedStatement.html)


# SelectBookLab 코드2

```java

```


```java
Statement stmt = conn.createStatement();
```  
- 수행하는 명령어의 제한이 없음
- 7가지 경우가 모두 resultSet 객체가 생성되므로 미리 resultSet을 선언함
- executeQuery를 case문 내부에서 실행시킴
- 출력방식이 3개로 나뉨
- 해쉬맵 객체를 이용해서 실제로 보관되어있는 것을 key로 두었음
- 이 코드는 while문 끝에 break가 있으므로 1번만 출력하고 끝나는 문제가 있다. break를 else문에 넣어주어야 한다.
- resultSet 객체는 try-catch에 넣어주지 않으면 자동으로 close 되지 않음
- Connection 객체는 꼭 close 해주어야 함

# SelectBookLab 코드3

```java

```

- keep 변수가 Y인 동안 while문을 수행 (바뀌면 종료)
  - 무한루프를 돌다가 break를 걸어주는 것이 아님!

- 추출할 컬럼명을 *로 기재하지말고 하나하나 나열 할 것
- case문에 괄호를 기재할 필요는 없다
- 이 코드의 default문에는 continue가 필요함.
- NumberFormatException
  - 추가 예외처리를 함. 추후 고려해볼 것


# SelectBookLab 코드4

```java

```

# SelectBookLab 코드5

```java

```

- enum을 사용함
  - b01~b05에 대한 상수값 지정
  - 데이터값을 지정하지 않으면 상수명이 상수값이 됨

- 데이터 추출을 위해 returnKind 메서드의 정의함
- 수행할 sql 명령을 String형 배열로 정의함
  - 이것이 mybatis다 
    - 수행할 sql명령을 자바 코드에서 분리시키는 것 (여기서는 string형 배열로 만들어둠)
    - 주로 xml 문서로 작성해두고 읽어오는 것

- 사용자에게 메뉴를 내보내는 것이 없으므로 수정이 필요함
- 데이터가 어떻게 구성되어 있냐에 따라서 결과가 달라지므로 조건문에서 `rs.next()`를 계속 고려해주고 있음
- 모든 것이 다 거짓?
  - 추출된 것이 하나도 없으므로 정말 데이터가 없는지 `!rs.next()`를 이용해서 재차 확인함
  
- 여러개의 catch 블록으로 구현할 떄에는 조상에 대한 내용일 수록 하위에 위치시키고 자손을 상위에 위치시켜야함
  - 여기선 Exception이 모든 예외클래스의 최고 조상이므로 제일 마지막에 와야함


# MVCLAB 실습 요구사항

```
제출 소스명 : 소스26.zip
메일 제목 : JDBC실습4-XXX

[ JDBC 실습 4 ]

(필요한 데이터 입력은 view에서, 결과 출력은 controller에서 함)
4개의 클래스 중 DTO 먼저 (코딩은 사용되는 애부터 만든다!)
DTO -> DAO -> 컨트롤러 -> 뷰 순서대로 만들 것


(1) model 구현(패키지 : mvclab.model)
      -  student 테이블에 매핑되는 StudentDTO 클래스를 구현한다.
      -  StudentDAO 클래스를 구현한다.(DB 서버 접속은 day16.mvc.MySQLConnect 사용)

	boolean insertStudent(StudentDTO dto)
	List<StudentDTO> getAllStudent()
	int getScore(StudentDTO dto)
	boolean updateStudent(StudentDTO dto)
    boolean deleteStudent(StudentDTO dto)
  (boolean -> 리턴값이 성공적으로 나오면 true, 아니면 false. 리턴값이 0이면 입력된 학생이름이 잘못되었으므로 return false하고, 그에 대한 결과는 컨트롤러에서 출력.)


(2) controller 구현(패키지 : mvclab.controller)    
      - 구현 클래스명 : StudentController
      
      - 구현해야 하는 메서드
         void printAll()   -->  StudentDAO의 getAllStudent()를 호출하고 결과를 화면에 출력한다.
         (getAllStudent만 매개변수가 없음. 얘는 모든 학생 데이터를 리스트 객체에 담아서 리턴하고 출력은 컨트롤러에서 함.)
         
         void printScore(String name) --> StudentDAO의  getScore()를 호출하고
                                                     "XXX 학생의 점수는 XX 입니다"를 출력한다.
         void insert(String name, int score) --> StudentDAO의  insertStudent()를 호출한다.
                                                             리턴결과가 true 이면 "입력 성공"을 출력한다.
	  		                       리턴결과가 false 이면 "입력 실패"를 출력한다.
         void update(String name, int score) --> StudentDAO의  updateStudent()를 호출한다.
                                                             리턴결과가 true 이면 "XX 학생의 점수를 변경했습니다."을 출력한다.
	  		                       리턴결과가 false 이면 "XX 학생은 존재하지 않습니다."를 출력한다.
         void delete(String name) -------------> StudentDAO의  deleteStudent()를 호출한다.
                                                             리턴결과가 true 이면 "XX 학생의 데이터를 삭제했습니다."을 출력한다.
	  		                       리턴결과가 false 이면 "XX 학생은 존재하지 않습니다."를 출력한다.
  


(3) view 구현(패키지 : mvclab.view)    
      -  구현 클래스명 : StudentApp
          수행을 시작하면 다음 메시지를 출력한다.
      - 사용자 입력을 받는 기능 정도만 구현

	처리하려는 기능을 선택하세요.
	(1번 외 필요한 데이터는 view에서 입력받음)
	(ex. 2번 입력시 학생 정보에 대해 표준 입력받음)
	(student 컬럼은 학생이름(PK), 점수만 존재)
	(삭제시 학생이름을 입력받아서 점수 삭제(학생이름은 삭제불가), 수정시도 학생이름 받아서 수정)
	1. 학생 정보 출력 
	2. 학생 정보 입력
    3. 학생 정보 삭제
	4. 학생 정보 수정
	5. 학생 점수 확인
	6. 종료
	입력 :

    1을 입력하면 StudentController 의 printAll() 을 호출한다.
    2를 입력하면 학생의 이름과 점수를 표준입력받아서 StudentController 의 insert() 를 호출한다.
    3을 입력하면 삭제하려는 학생 이름을 입력받아 StudentController 의 delete() 를 호출한다. 	
	4를 입력하면 수정하려는 학생 이름과 점수를 입력받아 StudentController 의 update() 를 호출한다.
 	5를 입력하면 점수를 확인하고 싶은 학생의 이름을 입력받아 StudentController 의 printScore() 를 호출한다. 
	6을 입력하면 프로그램 수행으로 종료한다.

           모든 기능을 수행하고 결과를 출력한 다음에는 위의 메뉴를 재 출력하고 사용자 입력을 받는다.
         
 

소스 구현 순서 : DTO -> DAO -> Controller -> View
```