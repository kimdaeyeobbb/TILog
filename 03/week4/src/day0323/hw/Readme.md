# 과제1

```java
package day0323.hw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AnnonyInnerLab {
    public static void main(String[] args) {
        // 객체 생성
        ArrayList<Book> al = new ArrayList<>();

        // Book 객체 넣어줌
        al.add(new Book("자바의 정석","남궁성",27000));
        al.add(new Book("챗GPT","반병현",11700));
        al.add(new Book("스타트 스프링 부트","남가람",27000));
        al.add(new Book("Doit! 자바프로그래밍","박은중",22500));
        al.add(new Book("이것이 자바다","신용권,임경균",36000));

        for (Book el: al) {
            System.out.println(el.getBookInfo());
        }

        // 타입 파라미터로 Book을 안주면 자동으로 Object이 적용됨.
        Collections.sort(al, new Comparator<Book>() {
                    // anonymouse inner class 를 넣어줌
                    // Book 클래스는 Comparable을 추가 상속하지 않으므로 sort 호출하면서 해당 객체들을 비교하는 기준을 정의한 비교자 역할을 하는 객체를 같이 전달해야함
            // 이것을 자손으로 만들어서 전달함
            // Comparator의 자손을 만들 때 이름이 있는 자손을 만들어도 되지만 실습에서는 익명을 요구함
            // Comparator도 제네릭스가 적용됨.
            // 타입 파리미터를 객체의 클래스명인 Book으로 지정함
            // Comparator 객체 뒤에는 Book을 써주었으므로 Book객체를 비교함.
            // 이로인해 매개변수를 Book형으로 정의해야 함
                    @Override
                    public int compare(Book o1, Book o2) {
                        // 2개의 인자로 전달된 Book 객체
                       return o1.getPrice()-o2.getPrice();
                    }
            }
        );
        System.out.println("[소팅 후 ]");
        for (Book el: al){
            System.out.println(el.getBookInfo());
        }
    }
}

```

- 좋은 아이디어

```java
@Override
public int compare(Book o1, Book o2) {
    // 2개의 인자로 전달된 Book 객체
   return o1.getPrice()-o2.getPrice();
}
```

- sort
  - -1,0,1을 뽑아내는게 중요한게 아니라 음,양 판단을 위한것인데 그것 대신 두 인자의 차이값을 리턴함으로서 크기 비교를 할 수 있음.


## 참고자료

- [Comparator](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Collections.html#sort(java.util.List,java.util.Comparator))
- [추상메서드 오버라이딩](http://www.tcpschool.com/java/java_polymorphism_abstract)


# 과제2

```java
package day0323.hw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class SelectEmpLab {
  public static void main(String[] args) {
    /* DB 서버로 접속 */
    String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
    String user = "jdbctest";
    String passwd = "jdbctest";
    String sql;
    Random random = new Random();
    boolean randTF = random.nextBoolean();
//        System.out.println(randTF);

    if(randTF == true){
      sql = "SELECT ENAME, FORMAT(SAL, 0) SAL FROM emp";
      try(Connection conn = DriverManager.getConnection(url, user, passwd);
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery(sql);){
        if(rs.next()){
          do{
            System.out.print(rs.getString("ENAME")+"\t"+"직원의 월급은 ");
            System.out.print(rs.getString("SAL")+"달러입니다.\n");
          } while(rs.next());
        } else {
          System.out.println("추출된 행이 없음!");
        }
      }  catch (Exception e){
        System.out.println("오류 발생 : " + e);
      }
    } else {
      sql = "SELECT ENAME, DATE_FORMAT(HIREDATE, '%Y년 %m월 %d일') HIREDATE FROM emp ORDER BY HIREDATE";
      try(Connection conn = DriverManager.getConnection(url, user, passwd);
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery(sql);){
        if(rs.next()){
          do{
            System.out.print(rs.getString("ENAME")+"\t"+"직원은 ");
            System.out.print(rs.getString("HIREDATE")+"에 입사하였습니다.\n");
          } while(rs.next());
        } else {
          System.out.println("추출된 행이 없음!");
        }
      }  catch (Exception e){
        System.out.println("오류 발생 : " + e);
      }
    }
  }
}

```


- 답안

```java
package day0323.hw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class SelectEmpLab {
    public static void main(String[] args) {
        /* DB 서버로 접속 */
        String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "jdbctest";
        String passwd = "jdbctest";

        String sql = "SELECT ENAME, DATE_FORMAT(HIREDATE, '%Y년 %m월 %d일') HIREDATE, FORMAT(SAL,0) SAL FROM emp";
        boolean randTF = new Random().nextBoolean();
        
        if(randTF == true){
            sql = "SELECT ENAME, FORMAT(SAL, 0) SAL FROM emp";
            try(Connection conn = DriverManager.getConnection(url, user, passwd);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {
              if (rs.next()) {
                if (randTF) {
                  do {
                    System.out.print(rs.getString("ENAME") + "\t" + "직원의 월급은 ");
                    System.out.print(rs.getString("SAL") + "달러입니다.\n");
                  } while (rs.next());
                }
              } else {
                do {
                  System.out.print(rs.getString("ENAME") + "\t" + "직원은 ");
                  System.out.print(rs.getString("HIREDATE") + "에 입사하였습니다.\n");
                } while (rs.next());
              }
            }else {
                    System.out.println("추출된 행이 없음!");
                }
            }  catch (Exception e){
                System.out.println("오류 발생 : " + e);
            }
        }
    }
}

```

- getConnection
  - static형
  - 내부적으로 connection 객체를 반환받음

- sql Exception 하나로 통일 되어 있음

<br>

```sql
DriverManager.getConnection(url, user, passwd);
```

- 실제 리턴되는 것은 Connection의 객체
- Connection 객체가 성공적으로 리턴되면 DB서버에 정상적으로 접속 되었다는 것

```sql
Statement stmt = conn.createStatement();
```

- statement 또한 인터페이스임

- executeUpdate는 리턴값이 int형
  - 행의 조건을 판단.
  - 삭제하려면 삭제한 행의 개수 리턴
  - 수정하겠다고 하면 수정한 행의 개수 리턴
  - 주어진 리턴조건에 의해 결정된 행의 갯수
  - insert는 무조건 1개 (insert시 한 행만큼의 변화가 생기므로)

## 2번문제

```sql
package day0323.hw;

import java.sql.*;
import java.util.Scanner;

public class CheckEmpLab {
    public static void main(String[] args) throws SQLException{
        // 입력 생성
        String input;

        /* DB 서버에 접속 */
        String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "jdbctest";
        String passwd = "jdbctest";
        String sql;
        Connection conn = DriverManager.getConnection(url, user, passwd); // Connection 객체 생성


        while(true){
            System.out.println("직원의 이름을 입력하세요 >> ");
            Scanner sc = new Scanner(System.in);
            input = sc.next();
            sql = "SELECT ENAME,DATE_FORMAT(HIREDATE, '%Y년 %m월') HIREDATE, DEPTNO FROM emp WHERE ENAME = \"" + input+ "\"";
            // 문자열 데이터로 사용되게끔 더블인용부호 사용
            // \" 쓰거나 ' 쓰는게 좋음 (더블인용부호 안에서 단일 인용부호를 쓰면 문자열로 인식)

            try (Statement stmt = conn.createStatement();
                //Statement 객체 생성
                ResultSet rs = stmt.executeQuery(sql);) {
                // ResultSet은 size가 없음. 사이즈를 알고싶으면 우리가 직접 추출된 행을 세어야 함
                {
                    if (rs.next()) {
                        // emp 테이블은 unique -> 데이터가 꺼내지면 하나만 꺼내짐. 아니면 안꺼내짐.
                        System.out.print(rs.getString("ENAME") + " 직원은 근무중입니다.\n");
                        System.out.print(rs.getString("HIREDATE") + "에 입사했고 현재 ");
                        System.out.print(rs.getString("DEPTNO") + "번 부서에서 근무하고 있습니다.\n\n");
                    } else {
                        System.out.println(input + "직원은 근무하지 않습니다.");
                        }
                    System.out.println("계속 검토하시겠습니까 >> (no)");
                    input = sc.next();
                    if(input.equals("no")){
                        break;
                    }
                    }
            }catch (Exception e) {
                System.err.println("오류 발생 : " + e);
            }
        }
    }
}
```