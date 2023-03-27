# 03.27

# 일반적인 SQL 명령

## SELECT

- JDBC 구성시 executeUpdate 사용
  - return value: int형 (0이면 조건에 맞는 데이터가 없는 것)
    - 0이 아닐 경우 해당 숫자만큼 수정된 것임. -> 그에 맞는 메시지를 내보내야 함


- select는 executeQuery() 사용
  - return value: ResultSet


## DML

- Data Manuplation Language
- JDBC상 excuteUpdate()


- 종류
  - INSERT
  - DELETE
  - UPDATE

### INSERT

- INSERT시 예외가 발생하지 않으면 INSERT 성공. 예외 발생시 INSERT 실패한 것
- executeUpdate가 INSERT 예외처리시 크게 활용되지 않음

### DELETE

- WHERE 절을 주지 않으면 모든 데이터를 삭제
- WHERE 절을 주어서 조건에 알맞은 녀석들이 삭제되게 만들 수 있음

### UPDATE

- UPDATE는 SET과 함께 사용하기도 함

```java
package day16.course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class UpdateData {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement("update student set score = ? where name = ?");
				// set절: 변경하고 싶은 컬럼명 & 대입 연산자 및 변경할 값 지정
			 // 여러개의 컬럼을 한꺼번에 바꾸고 싶으면 set score =? , 컬럼명2 = 변경할 값 처럼 나열
				Scanner scan = new Scanner(System.in);){
			System.out.print("학생 이름을 입력하세요 : ");
		    String name = scan.nextLine();
			System.out.print("학생 점수를 입력하세요 : ");
			int score = Integer.parseInt(scan.nextLine());
			pstmt.setInt(1,  score);
		    pstmt.setString(2, name);
			int updateNum = pstmt.executeUpdate();
			// executeUpdate - 리턴값이 의미있게 쓰이는 경우가 많다
			// 학생 테이블 name - PK
			if (updateNum > 0) // 몇개의 행이 변경 되었을 경우
				System.out.println("student 테이블에서 " +updateNum + "행 변경 완료");
			else 
				System.out.println("변경 실패!!");
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} 
	}
}
```

## DDL

- JDBC상 excuteUpdate()

- 종류
  - CREATE TABLE
  - DROP TABLE
  - ALTER TABLE

### CREATE TABLE

- 새로운 테이블 생성

### DROP TABLE

- 테이블 삭제

### ALTER TABLE

- 테이블이 이미 만들어진 상태에서 테이블의 스키마를 바꿀 때 필요함

- 테이블 구조 변경 수행
  - 기존 컬럼 삭제
  - 기존 컬럼 타입 변경
  - 제약 조건 추가


- 하고자 하는 작업에 위배되는 경우 수행 불가
  - ALTER TABLE의 기능과 이미 들어있는 데이터들의 관계에 있어 ALTER TABLE하기 적합하지 않으면 안됨
  - 테이블 만들 때 PK를 생각하지 않았다가 중복 데이터가 이미 들어가 있는 경우 PK를 설정할 수 없음

# Model View Controller 구현 패턴

- MVC 패턴이라 함
- 웹 사이트 개발시 많이 사용하는 패턴
- 웹에서 주로 사용하는 MVC 패턴은 DB 연동시 필수적으로 사용됨
- 웹 프로그래밍 이전부터 있었던 패턴임 (UI 개발시 많이 사용하던 패턴) => 이후 웹에 접목
- 화면상 사용자에게 보여지는 기능 혹은 사용자가 프로그램을 이용하며 입출력하는 부분 , 프로그램 고유의 기능 (성적 처리, 급여 처리)등을 비즈니스 로직(서비스 로직)이라 하는데
이렇게 사용자와의 인터페이스를 담당하는 프로그램, 사용자가 원하는 기능을 구현하는 프로그램을 분리시켜서 개발함
- 실질적으로 기업체들이 어떤 업무 및 비즈니스용 애플리케이션 개발시 기능에 대한 구현 사항이 많다
  - 이러한 경우 인터페이스 부분에 대한 구현과 다양한 목적의 서비스 로직/ 비즈니스 로직 등을 나누어서 개발한다

- 스프링 프레임워크는 MVC 패턴으로 웹 사이트를 개발하게끔 구성되어있음
- DB연동 프로그램 개발시 MVC 패턴을 적용하면 유지보수성이 좋아짐

## Model


- 모델에 해당되는 것은 서비스 모델과 도메인 모델로 나뉨

### 서비스 모델

- DAO, VO, ENTITY는 서비스 로직이나 데이터 로직을 구현하지 않고 데이터값만 보관하는 역할을 해야 함


- DAO 객체 (Data Access Object)
  - 데이터 연동 코드를 담고 있는 객체
  - DB 연동 전담 객체
  - DB 연동을 전담하는 클래스 작명시 `~DAO`꼴로 작명
  - 뷰가 사용자로부터 입력받은 내용을 컨트롤러 혹은 모델에 넘길 때 하나하나 전달하기 보다는 전체를 묶어서 객체로 전달하는 것이 효율적 (이럴 떄 DAO 사용)


- VO
  - Value Object
  - `값`임 (readonly로만 사용가능)
  - 보관된 값을 읽는 용도로만 사용할 수 있음
  - 변경하는 기능이 있는 도메인 모델은 VO라고 해서는 안됨


- DTO
  - 값을 읽고 변경할 수 있음
  

- Entity
  - DB 테이블과 매핑되는 도메인 모델
  - JPA에서 엔티티를 사용함
  - DB 연동외의 특별한 역할은 없음



- 게시판 데이터
  - 게시판 작성자명
  - 게시판 글 내용
  - 게시판 글 작성 날짜
  - 이를 하나로 묶는 클래스가 도메인 모델
  


## View 


- 사용자 인터페이스
- 사용자와의 인터페이스를 담당하는 프로그램을 `뷰(View)`라 함 (사용자에게 친절하게 처리 결과를 나타냄)


## Controller

- DB에 대한 CRUD 작업을 필요로 할 때 컨트롤러를 통해 요청함
- 컨트롤러의 역할이 가끔 불분명할 수 있음 
  - 이때 컨트롤러를 날리고 뷰에서 DAO 연동하게끔 바로 설정하는 경우도 있음

<br>

# DAO

- DB 연동에 충실해야 함

# VO

- 데이터값을 보관하여서 전달하는 역할

# DTO

- 데이터값을 보관하여서 전달하는 역할


<br>


# 제네릭 타입

- 결정되지 않은 타입을 매개변수로 가지는 클래스와 인터페이스
- 선언부에 `<>` 부호가 붙고 그 사이에 타입 파라미터(매개변수)들이 위치함

```java
public class ClassName <A, B, ...> { ... }
public interface InterfaceName <A, B, ...> { ... }
```

- 타입 파라미터는 일반적으로 대문자 알파벳 한 글자로 표현함
- 외부에서 제네릭 타입을 사용하기 위해서는 타입 파라미터에 구체적인 타입을 지정함
<br> (지정하지 않으면 암묵적으로 Object 타입이 사용됨)


# 와일드카드 타입 파라미터

- 제네릭 타입을 매개값이나 리턴 타입으로 사용할 때 범위에 있는 모든 타입으로 대체할 수 있는 타입 파라미터
- `?` 기호로 표시함 (`?`를 통해 누구나 올 수 있게끔 만들어줌)
- API document상 와일드카드 타입 파라미터를 사용한 메서드들이 많다


- 예시

```
// 상속관계도
Person > Worker 
Person > Student > HighStudent & MiddleStudent
```


```java
리턴타입 메서드명 (제네릭타입<? extends Student> 변수) { ... }
// Student와 Student를 상속한 애들만(Student의 자손) 제네릭 타입의 파라미터로 적용        
        
리턴타입 메서드명 (제네릭타입<? super Worker> 변수) { ... }
// 어떤 클래스를 기준해서 해당 클래스타입을 포함한 조상만 오게 제한하고 싶을 때 super를 사용
// Worker와 Worker의 조상인 Person만 가능

        
리턴타입 메서드명 (제네릭타입<?> 변수) { ... }
// 
```

- 제네릭 타입
  - 클래스나 인터페이스가 만들어질 떄 클래스명 혹은 인터페이스명 뒤에 `<타입 파라미터>`가 적용된 것
  - AraayList, LinkedList 등이 해당됨 
  - 제네릭 타입을 매개변수 타입으로 지정할 때 `ArrayList<Friend>`, `ArrayList<String>`, `ArrayList<StudentDTO>`, `ArrayList<Integer>`등과 같이 객체 타입 생성 시점에서 어떤 타입인지를 정함
