# Like 연산자

## %
 
- 0개 이상의 모든 ~
   
- A% -
    - A로 시작하는 문자
```sql
ename like 'A%'  -- A로 시작하는 문자 찾음  
```

```sql
ename like '%A' -- A로 끝나는
```

```sql
ename like '%A%' -- A를 포함하는
```


## _

```sql
ename like 'A_' -- A로 시작하면서 뒤에 문자 하나가 더 있는 것
ename like 'A__' -- A로 시작하면서 뒤에 문자 두개가 더 있는 것
```


```java
package day0324.day15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchEmp {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "jdbctest";
        String passwd = "jdbctest";
        Connection conn = DriverManager.getConnection(url, user, passwd);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select ename, job, sal, deptno  from emp where ename like '%T%'");
        // Like - 패턴 비교. 어떤 문자로 시작하거나 끝나거나 포함하는지를 체킹. 게시판 검색할 때 많이 사용.
        // 이름에 대문자 T가 포함된 사람을 찾음

        System.out.printf("%8s%8s%8s%4s\n", "성명", "직무", "급여", "부서");
        System.out.println("  -----------------------------------");
        while (rs.next()) {
            System.out.printf("%10s%12s%8d%4d\n",
                    rs.getString("ename"), rs.getString("job"),
                    rs.getInt("sal"), rs.getInt("deptno"));
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}

```


```java
package day0324.day15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectSalEmp {
  public static void main(String[] args) throws Exception {
    String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
    String user = "jdbctest";
    String passwd = "jdbctest";
    Connection conn = DriverManager.getConnection(url,user,passwd);
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT ename, concat(format(sal, 1),'달러') fsal FROM emp ORDER BY sal DESC");
    // concat - 두 인자를 하나로 결합
    // DB 시스템은 DB처리에 있어 우리보다 훨씬 빠르고 특화되어 있으므로 분류작업을 우리가 직접하기 보다 SQL에게 작업을 맡기는것이 낫다.
    // MYSQL - FORMAT을 통해 자리수 구별 
    // ORDER BY - 모든 DBMS에서 똑같음
    // 함수는 DBMS마다 동일하다는 보장이 없다

    System.out.printf("%-8s%-8s\n", "성명", "급여");
    System.out.println("  --------------------------");
    while (rs.next()) {
      System.out.printf("%-10s%-12s\n", rs.getString("ename"), rs.getString("fsal"));
    }
    rs.close();
    stmt.close();
    conn.close();
  }
}

```


# SelectWhereEmp

- EMP 테이블
```sql
mysql> select * from emp;
+-------+--------+-----------+------+------------+------+------+--------+
| EMPNO | ENAME  | JOB       | MGR  | HIREDATE   | SAL  | COMM | DEPTNO |
+-------+--------+-----------+------+------------+------+------+--------+
|  7369 | SMITH  | CLERK     | 7902 | 1980-12-17 |  800 | NULL |     20 |
|  7499 | ALLEN  | SALESMAN  | 7698 | 1981-02-20 | 1600 |  300 |     30 |
|  7521 | WARD   | SALESMAN  | 7698 | 1981-02-22 | 1250 |  200 |     30 |
|  7566 | JONES  | MANAGER   | 7839 | 1981-04-02 | 2975 |   30 |     20 |
|  7654 | MARTIN | SALESMAN  | 7698 | 1981-09-28 | 1250 |  300 |     30 |
|  7698 | BLAKE  | MANAGER   | 7839 | 1981-04-01 | 2850 | NULL |     30 |
|  7782 | CLARK  | MANAGER   | 7839 | 1981-06-01 | 2450 | NULL |     10 |
|  7788 | SCOTT  | ANALYST   | 7566 | 1982-10-09 | 3000 | NULL |     20 |
|  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | 3500 |     10 |
|  7844 | TURNER | SALESMAN  | 7698 | 1981-09-08 | 1500 |    0 |     30 |
|  7876 | ADAMS  | CLERK     | 7788 | 1983-01-12 | 1100 | NULL |   NULL |
|  7900 | JAMES  | CLERK     | 7698 | 1981-10-03 |  950 | NULL |     30 |
|  7902 | FORD   | ANALYST   | 7566 | 1981-10-03 | 3000 | NULL |     20 |
|  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300 | NULL |     10 |
+-------+--------+-----------+------+------------+------+------+--------+
```

- NULL은 아직 모름 (값이 없는 것)
- NULL과의 연산을 수행하면 결과는 NULL
- NULL은 등가비교할 수 없다
- NULL은 무한대이다.
- 0은 0이라는 값이 있는 것

- 커미션이 정해지지 않는 직원만 추출해보자

```java
package day0324.day15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectWhereEmp {
	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		Connection conn = DriverManager.getConnection(url, user, passwd);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT ename, sal, comm FROM emp WHERE comm is not null");
		// IS NULL, IS NOT NULL
		
		System.out.printf("%8s%8s%8s\n", "성명", "급여", "커미션");
		System.out.println("  -----------------------------------");
		while (rs.next()) {
			System.out.printf("%10s%10d%10d\n", rs.getString("ename"), rs.getInt("sal"), rs.getInt("comm"));
		}
		rs.close();
		stmt.close();
		conn.close();
	}
}

```


# SelectGroupEmp

```java
package day0324.day15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectGroupEmp {
	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		Connection conn = DriverManager.getConnection(url, user, passwd);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT ifnull(deptno,'미정') deptno, concat(count(*),'명') su FROM emp GROUP BY deptno");
		// deptno별로 그룹핑 - null그룹, 10번그룹, 20번그룹, 30번그룹 (집계함수를 사용하기 위해서 그룹핑을 한다.)
		// 본적으로 join은 inner join임
		// deptno가 null인 경우 미정으로 출력
		// count - 그룹단위 카운팅 (여기서는 deptno별로 그룹핑)
		

		System.out.printf("%8s%12s\n", "부서명", "근무하는 인원");
		System.out.println("  -------------------------------");
		while (rs.next()) {
			System.out.printf("%10s%12s\n", rs.getString("deptno"), rs.getString("su"));
		}
		rs.close();
		stmt.close();
		conn.close();
	}
}

```


# 테이블 2개 이용하기

```sql
mysql> select * from dept;
+--------+------------+----------+
| DEPTNO | DNAME      | LOC_CODE |
+--------+------------+----------+
|     10 | ACCOUNTING | A1       |
|     20 | RESEARCH   | B1       |
|     30 | SALES      | C1       |
|     40 | OPERATIONS | A1       |
|     50 | INSA       | NULL     |
+--------+------------+----------+
5 rows in set (0.00 sec)
```

- 직원이름과 부서이름을 같이 내보내보자
  - 2개의 테이블을 논리적으로 묶어보자 (join 이용)
  - 두 테이블이 모두 가지고 있는 deptno를 가지고 join 하자

```java
package day0324.day15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectJoinEmp {
  public static void main(String[] args) throws Exception {
    String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
    String user = "jdbctest";
    String passwd = "jdbctest";
    Connection conn = DriverManager.getConnection(url, user, passwd);
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT ename, dname FROM emp INNER JOIN dept USING (deptno)");// ANSI JOIN
    // 행 단위로 결합

    System.out.printf("%-8s%-8s\n", "성명", "부서명");
    System.out.println("-----------------------------------");
    while (rs.next()) {
      System.out.printf("%-10s%-12s\n", rs.getString("ename"), rs.getString("dname"));
    }
    rs.close();
    stmt.close();
    conn.close();
  }
}
```

# SelectSubqueryEmp

- 실무에서는 sql 명령어의 길이가 한 페이지를 차지하는 경우가 잦다.
- 여러행으로 select문 작성시 `+`로 

## 서브쿼리 vc join

- 최종 select할 결과가 두 테이블에 나눠져 있는 경우 (최종적으로 꺼낼 결과를 두 테이블에서 꺼내야하는 경우)join으로 해결
- 최종 select할 결과(최종적으로 꺼낼 결과가) 테이블 하나에서만 꺼내면 될 경우 서브쿼리를 이용

```java
package day0324.day15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectSubqueryEmp {
	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		Connection conn = DriverManager.getConnection(url, user, passwd);
		Statement stmt = conn.createStatement();
		Scanner scan = new Scanner(System.in);
		System.out.print("부서명을 입력하세요 : ");
		String departmentname = scan.nextLine();
		ResultSet rs = stmt.executeQuery("SELECT ename, job, sal, deptno  FROM emp "
				+ "WHERE deptno = (SELECT deptno FROM dept WHERE dname = '" + departmentname + "')");
		// 부서명에 알맞은 직원은 출력.
		// emp에는 부서번호는 있어도 부서명은 없음. 따라서 서브쿼리를 이용하자.


		if (rs.next()) {
			System.out.printf("%8s%8s%8s%4s\n", "성명", "직무", "급여", "부서");
			System.out.println("  -----------------------------------");
			do {
				System.out.printf("%10s%12s%8d%4d\n", rs.getString("ename"), rs.getString("job"), 
						rs.getInt("sal"), rs.getInt("deptno"));
			} while (rs.next());
		} else {
			System.out.println("\n추출되는 직원 정보가 없습니다.");
		}
		scan.close();
		rs.close();
		stmt.close();
		conn.close();
	}
}

```


# TableCreate

```sql
create table visitor(-- 테이블 생성

    -- 컬럼들의 사양 정의
    id int primary key auto_increment, -- 컬럼명 컬럼타입 제약조건. PK설정시 NOT NULL
    name varchar(15) not null,  -- 15바이트로 구성된 varchar (15문자 저장 가능. UTF-8에서 문자하나는 1바이트)
    -- UTF8에서 한글은 3바이트 (여기서 한글은 총 5글자 저장 가능)
    
    writedate datetime not null,  -- datetime: 날짜와 시간 모두를 저장
    memo varchar(100) not null  -- 영문기준 100자, 한글기준 33자
);
    
    
    
insert into visitor(name, writedate, memo) values('둘리', now(), '호이호이~~');  -- INSERT INTO 테이블명 VALUES(입력할 값들 나열)
-- 입력할 값들은 테이블이 가지는 컬럼 사양에 맞춰서 입력해야 함

insert into visitor(name, writedate, memo) values('또치', '2021-12-25', '난 타조라네^^');
insert into visitor(name, writedate, memo) values('둘리', '1990-8-20', '깐따삐아 별에서 왔어용');
-- 실제 컬럼은 4개지만 데이터를 3개만 넣으므로 컬럼명을 매칭 시켜주어야 함 (개수가 같으면 컬럼명 리스트 생략 가능)
-- INSERT 명령은 테이블 이름과 VALUES 사이에 INSERT할 컬럼에 대한 정보를 리스트로 주는 것이 기본임
-- MySQL 에서는 날짜표시할 떄 08과 8이 동일.

select * from visitor;

create table imgtest(
    id int primary key auto_increment,
    filename varchar(45) not null -- 영문기준 45자. 한글 기준 15자 저장
    imgcontent mediumblob not null  
        -- blob형 (Binary Large Object. DB테이블에 사이즈가 큰 이미지 등을 저장할 때 사용)
        -- 이진 파일이므로 명령어로 우리가 직접 이진 파일을 삽입할 수 없음. 프로그램을 이용할 것.
  );

create table meeting(
    
);
```

## executeQuery()

- 리턴값: ResultSet 객체 (select 명령의 실행결과를 참조)



## executeUpdate()

- 리턴값: int형
- 성공시 1이 리턴
- 리턴 값의 의미
  - 주어진 SQL 명령에 의해 테이블에서 변화된 행의 개수

### DML 

- INSERT
- DELETE
- UPDATE

#### DELETE

- 삭제된 행의 개수

#### UPDATE 

- 수정된 행의 개수

### DDL

- 

## 예제 코드

```java
package day0324.day15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreate {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		try {

			/* DB 연결 */
			String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
			String user = "jdbctest";
			String passwd = "jdbctest";
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("데이터베이스에 접속했습니다.");

			stmt = conn.createStatement();		// statement 객체 생성

			stmt.executeUpdate("create table student (name varchar(15) primary key, score int)");
// 학생 테이블 생성 (name, score. 두 개의 컬럼을 가지는 테이블)
			// select 명령어 수행시 executeQuery 메서드 사용 (DB 테이블의 데이터를 읽어올 때)
			// executeUpdate() 메서드 - 접속된 DB 서버에서 Query(SELECT 명령ㅇ)을 실행하려면 Statement 객체의 executeQuery() 메서드를 사용하여 INSERT, DELETE, UPDATE, CREATE TABLE, DROP TABLE 등의 SELECT 명령 이외의 명령을 실행할 때 사용


  System.out.println("student 테이블 생성");
} catch (SQLException se1) {
			System.out.println(se1);
} finally {
			try {
				stmt.close();
				conn.close();
} catch (SQLException se2) {
				System.out.println(se2.getMessage());
}
		}
	}
}

```

# InsertData1


```java
package day0324.day15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
			return;
		} 
		Connection conn = null;
		Statement stmt = null;
		try {
			String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
			String user = "jdbctest";
			String passwd = "jdbctest";
			conn = DriverManager.getConnection(url, user, passwd);	
			System.out.println("데이터베이스에 접속했습니다.");
			stmt = conn.createStatement();		
			stmt.executeUpdate("insert into student values ('둘리', 100)");
			stmt.executeUpdate("insert into student values ('또치', 90)");
			stmt.executeUpdate("insert into student values ('도우너', 95)");
			stmt.executeUpdate("insert into student values ('희동이', 80)");
			stmt.executeUpdate("insert into student values ('마이콜', 85)");
			stmt.executeUpdate("insert into student values ('고길동', 60)");
			stmt.executeUpdate("insert into student values ('짱구', 90)");
			stmt.executeUpdate("insert into student values ('짱아', 75)");
			System.out.println("student 테이블에 데이터 삽입 완료");						
		} catch (SQLException se1) {
			System.out.println(se1.getMessage());
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException se2) {
				System.out.println(se2.getMessage());
			}
		}
	}
}

```

- 결과 확인

```sql
mysql> select * from student;
+--------+-------+
| name   | score |
+--------+-------+
| 고길동 |    60 |
| 도우너 |    95 |
| 둘리   |   100 |
| 또치   |    90 |
| 마이콜 |    85 |
| 짱구   |    90 |
| 짱아   |    75 |
| 희동이 |    80 |
+--------+-------+
8 rows in set (0.00 sec)
```

- 여러번 데이터가 들어가지 않도록 이름을 PK로 설정
- 여러번 명령 수행시 다음과 같은 에러메시지 확인가능
```sql
Duplicate entry '둘리' for key 'student.PRIMARY'
```


# SelectData1

```java
package day0324.day15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectData1 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				Statement stmt = conn.createStatement()){
			ResultSet rs = stmt.executeQuery("select name, score from student");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"학생은 "+rs.getInt(2)+"점 입니다.");
			}	
			rs.close();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}

```


# InsertData2

```java
public class Ex{
  public static void main(String[] args) {
    Student stmt = conn.createStatement();

    int delNum = stmt.executeUpdate("delete from student where name = '둘리'");  
    // delete 명령 수행
  
    int updateNum = stmt.executeUpdate("update student set score = '0' where name='둘리'");
    // 점수 업데이트 
    //where 절을 안주면 모든 행에 대해 정보가 수정됨
    
    
    String name = scan.nextLine();
    int score = Integer.parseInt(scan.nextLine());
    Statement stmt = conn.createStatement();
    
    stmt.executeUpdate("insert into student values("+name+","+score+")");
    int delNum = stmt.executeUpdate("delete from student where name = "+name+"");  
    int updateNum = stmt.executeUpdate("update student set score = "+score+" where name = "+name");
  }
}
```

- statement는 수행시킬 sql 명령을 미리 다 완성해서 입력해야 함 (나중에 세팅할 수 없음)
- statement는 수행시킬 sql 명령이 고정된 내용이어야 함
- 이 경우 PreparedStatement를 이용해서 더 효율적으로 명령어 작성이 가능하다
- 동적으로 값을 설정해야하는 경우에 사용하면 좋다
- 

# PreparedStatement

- PreparedStatement의 팩토리 메서드는 Connection이 가지고 있음
- 수행할 sql 명령을 미리 준비시켜야 함
- 객체 생성시 미리 준비한 sql 명령만 수행할 수 있음
- 동일한 명령어를 값만 바꿔서 수행할 경우 (+)연산자를 쓰기보다 PreparedStatement를 사용하는 것이 좋다

```java
public class Ex{
  public static void main(String[] args) {
    PreparedStatement pstmt = conn.prepareStatement("insert into student values(?,?)");
// insert할 값을 +연산자로 엮지 않고 물음표 기호로 정의할 수 있다.
// (이때 insert 값이 아직 정해지지 않았다는 뜻)
// 동적으로 설정할 값의 개수만큼 물음표(?)를 표시할 것. insert할 값이 5개면 물음표를 5개 사용.
// 아직 물음표에 값을 넣은거지. 실행시킨게 아님.
    
    
    pstmt.setString(1, names);
    pstmt.setInt(2, score);
    pstmt.executeUpdate(); // 이떄 값이 실행됨. 여기서 값을 주면 에러남. 
  }
}
```


# InsertData2

```java
package day0324.day15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData2 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement("insert into student values (?, ?)");
				// ?,?  => 2개의 컬럼값을 동적으로 나중에 설정하겠다는 뜻

				Scanner scan = new Scanner(System.in);){
			while(true) {
				System.out.print("학생 이름을 입력하세요 : ");
				String name = scan.nextLine();
				System.out.print("학생 점수를 입력하세요 : ");
				int score = Integer.parseInt(scan.nextLine());
				pstmt.setString(1,  name); // 첫번쨰 물음표에는 name 세팅
				pstmt.setInt(2, score);  // 두번째 물음표에는 score 세팅
				pstmt.executeUpdate(); // 얘까지 호출해주어야 세팅된 내용이 반영됨 (executeUpdate을 호출 해주어야 테이블에 데이터가 들어감)
				System.out.println("student 테이블에 데이터 삽입 완료");
				System.out.print("계속 입력하겠습니까?(y/n)");
				String aws = scan.nextLine();
				if (aws.equalsIgnoreCase("y")) { // equalsIgnoreCase - 대소문자 구분하지 않음
					continue;
				} 
				System.out.println("student 테이블 데이터 삽입 작업 종료");
				break;
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} 
	}
}

```

- 결과확인

```java
package day0324.day15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectData1 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				Statement stmt = conn.createStatement()){
			ResultSet rs = stmt.executeQuery("select name, score from student");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"학생은 "+rs.getInt(2)+"점 입니다.");
			}	
			rs.close();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}

```


# SelectData2

# SelectData4

```java
package day0324.day15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class SelectData4 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement("select name from student where score >= ?");
				Scanner scan = new Scanner(System.in);){
		    System.out.print("학생의 점수를 입력하세요 : ");
		    int score = scan.nextInt();
		    pstmt.setInt(1, score);
			ResultSet rs = pstmt.executeQuery();			
			if(rs.next()) {
				ArrayList<String> students = new ArrayList<>();
				// 이미 next 한번했으므로 여기서는 do-while
				do {
					students.add(rs.getString("name"));
				} while (rs.next());
				System.out.print("점수가 " + score + "이상인 학생은 ");
				System.out.print(students); // arraylist 전달시 arraylist가 가진 값들을 대괄호와 함께 넘겨줌.
				System.out.println(" 입니다");
			} else 			
				 System.out.println("점수가 " + score + " 이상인 학생은 없습니다.");
			 System.out.println("수행 종료...");
			 rs.close();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}

```


# SelectData5

```java
package day0324.day15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectData5 {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement("select name, score from student where score>=  ? order by score desc");
				Scanner scan = new Scanner(System.in);){
		    System.out.print("점수를 입력하세요 : ");
		   int score = Integer.parseInt(scan.nextLine());
		    pstmt.setInt(1, score);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("[ 점수가 " + score + " 이상인 학생 이름(점수가 높은 순) ]");
				do {
					System.out.println(rs.getString("name") + " : " + rs.getInt("score"));
				} while(rs.next());
			} else 			
				 System.out.println("점수가 " + score + " 이상인 학생은 존재하지 않습니다.");
			 System.out.println("수행 종료...");
			 rs.close();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}

```

# InsertImage - 이미지 내용을 DB 테이블에 삽입하기

- 이미지를 DB 테이블에 넣을 수도, 이미지 이름만 넣을 수도 있다.

- 이미지 삽입

```java
package day0324.day15;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertImage {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
			return;
		} 
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				Scanner scan = new Scanner(System.in);
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO imgtest (filename, imgcontent) VALUES (?, ?)")){
			// imgtest 테이블에 inset
			// 테이블의 컬럼 중 filename, imgcontent 컬럼에 데이터를 넣겠다는 것. (id컬럼에는 데이터 안넣음. 자동적으로 증가하니까.)
			// VALUES - 첫번쨰 물음표: filename, 두번째 물음표: imgcontent 넣음
			System.out.print("저장할 이미지 파일명을 절대 패스로 입력하세요 : ");
			// 맥: 최상위 폴더부터. 윈도우:
			// c:/iotest/myimage/cuteone.jpg
			// 확장자까지 제대로 입력할 것

			String name = scan.nextLine();
			File imgFile = new File(name);
			if (imgFile.exists()) { // 이미지 파일이 존재한다면
				/* DB테이블에 집어넣음 */
				FileInputStream fin = new FileInputStream(imgFile);
				// 이미지는 바이트 스트림으로 설정해야함 (문자 스트림으로 설정하면 이미지가 다 깨짐)

				pstmt.setString(1, imgFile.getName());
				// getName -> 파일이름만 추출

				pstmt.setBinaryStream(2, fin, (int)imgFile.length());
				// setBinaryStream - byte형식으로 동작하는 스트림객체를 설정.
				// 두번쨰 물음표에 fin (FileInputStrea - 객체 생성시 파일을 읽기 모드로.)
				// 이미지니까 문자 스트림 X (이미지 다 꺠짐), 바이트 스트림을 써서 읽어와야 함.
				// length - 읽고자하는 이미지 파일의 사이즈(만큼 읽어서 세팅해달라는 것)

				pstmt.executeUpdate(); 
				System.out.println("이미지 삽입 성공");
			} else {
				System.out.println("[오류] 이미지가 존재하지 않음");
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}

```

- 이미지가 잘 들어갔는지 sql환경에서 확인

```sql
mysql> select filename from imgtest;
+-------------+
| filename    |
+-------------+
| cuteone.jpg |
+-------------+
1 row in set (0.00 sec)
```

- 파일명이 cuteone.jpg인 데이터에 대한 정보를 읽어오기

```sql
mysql> select * from imgtest where filename = 'cuteone.jpg';
+----+-------------+------------------------+
| id | filename    | imgcontent             |
+----+-------------+------------------------+
|  1 | cuteone.jpg | 0x                     |
+----+-------------+------------------------+
1 row in set (0.00 sec)
```

- 이미지 파일을 집어넣을 떄에는 statement (고정된 데이터만 작성가능)을 쓰면 안됨. 
- 반드시 preparedStatement 써야함.
- 이렇게 특정한 타입의 데이터를 집어넣을 경우 `preparedStatement`를 쓰고 `setBinaryStream`을 이용할 것

# SelectImage - 이미지 읽어오기


```java
package day0324.day15;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SelectImage {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
			return;
		}
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				Scanner scan = new Scanner(System.in);
				PreparedStatement pstmt = conn.prepareStatement("SELECT filename, imgcontent FROM imgtest WHERE filename = ?");) {
			System.out.print("읽으려는 이미지의 파일명을 입력하세요 : ");
			String name = scan.nextLine();
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				/* 새로 만들 파일의 이름 처리  & 이미지 파일의 내용을 읽어옴*/
				String imgName[] = rs.getString("filename").split("\\.");
				// split 호출시 delimeter 지정함.
				// 여기서는 점(.)을 기준으로해서 양쪽을 나눔
				// \을 이용해서 점의 고유의미를 없앰. 자바에서는 더블 인용 부호내에 백슬래쉬를 쓰려면 2번을 써야함. 따라서 \\.가 된것.
				// (\\을 통해 점(.)의 정규표현식에서의 고유의미를 없애고, 문자로서의 점으로 사용)
				// 

				File imgFile = new File("c:/Temp/"+imgName[0]+new Date().getTime()+"."+imgName[1]);
				// 현재 시스템 시간에 대한 timestamp값을 붙임 & 확장자 붙임

				/* 입출력 스트림 사용 & 바이트 스트림으로 읽어오게끔 만듦 */
				InputStream is = rs.getBinaryStream("imgcontent");
				// 직접 안주니까 읽어와야 함

				/* 읽어와서 파일에 저장 */
				FileOutputStream fos = new FileOutputStream(imgFile);
				byte[] b = new byte[2048];
				// 2048 바이트씩 읽어와서 write처리하기 위한 과정 (1바이트씩 읽어오면 시간이 오래걸리니까)
				int n;
				while ((n = is.read(b)) > 0) {
					fos.write(b, 0, n);
				}
				fos.close();
			} else {
				System.out.print(name + "이라는 파일명으로 저장된 이미지가 존재하지 않습니다. ");
			}
			System.out.println("이미지 읽기 성공");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

```

- 명령 수행 후 Temp 폴더에 잘 있는지 확인
- DB 테이블에 이미지와 같은 바이너리 값을 넣으려고 하면 컬럼을 바이너리형으로 작업할 수 있게 만들 것
