package day15.hw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateBookLab {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try{
            /* DB연결 */
            String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
            String user = "jdbctest";
            String passwd = "jdbctest";
            conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("데이터베이스에 접속했습니다.");
            stmt = conn.createStatement();  // Statement 객체 생성

            stmt.executeUpdate("create table book (id int primary key auto_increment not null ,title varchar(90), price int, kind char(3))");
            System.out.println("book 테이블 생성 완료!");
        } catch (SQLException sel){
            System.out.println("오류 발생! 에러 메시지: " +sel);
        } finally{
            try{
                stmt.close();
                conn.close();
            } catch (SQLException se2){
                System.out.println("오류 발생! 에러 메시지: " + se2.getMessage());
            }
        }
    }
}
