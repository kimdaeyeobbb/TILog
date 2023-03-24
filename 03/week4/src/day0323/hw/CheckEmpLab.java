package day0323.hw;

import java.sql.*;
import java.util.Scanner;

public class CheckEmpLab {
    public static void main(String[] args) {
        /* DB 서버에 접속 */
        String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "jdbctest";
        String passwd = "jdbctest";
        String sql = "SELECT ENAME,DATE_FORMAT(HIREDATE, '%Y년 %m월') HIREDATE, DEPTNO FROM emp";

        Scanner sc = new Scanner(System.in);
        String out ="";
        System.out.println("직원 이름 입력 (종료하려면 q입력): ");
        String empName = sc.next();
        System.out.println("empName: "+empName);
        out = empName;

        while(out != "q") {
                try (Connection conn = DriverManager.getConnection(url, user, passwd);
                           // Connection 객체 생성
                           Statement stmt = conn.createStatement();
                           //Statement 객체 생성
                           ResultSet rs = stmt.executeQuery(sql);) {
                    {
                        while(rs.next()) {
                            if(empName == rs.getString("ENAME")){
                                System.out.print(rs.getString("ENAME") + " 직원은 근무중입니다.\n");
                                System.out.print(rs.getString("HIREDATE") + "에 입사했고 현재 ");
                                System.out.print(rs.getString("DEPTNO") + "번 부서에서 근무하고 있습니다.\n\n");
                            }
                        }
                    }
//                        System.out.println(empName+ " 직원은 존재하지 않습니다.");
                }catch (Exception e) {
                    System.err.println("오류 발생 : " + e);
                } // 자동으로 마지막에 close됨
            }
    }
}