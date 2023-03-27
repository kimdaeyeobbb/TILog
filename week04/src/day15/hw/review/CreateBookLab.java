package day15.hw.review;


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