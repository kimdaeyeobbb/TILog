package day14.hw;

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
        // DB 서버에 접속
        // try 문 안에 넣어두면 try-catch가 끝나는 시점에 깨짐
        // 밖에다가 빼준 이유에는 효율성 강화
        // connection -> stattement -> sql 명령 수행

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
                // ResultSet 객체는 결과에 대한 버퍼 정보를 참조한 상태로 리턴됨
                // 서버에 select된 결과를보관하고 있는 버퍼
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