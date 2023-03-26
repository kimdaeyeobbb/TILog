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
