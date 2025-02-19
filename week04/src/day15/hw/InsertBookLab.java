package day15.hw;

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
            while(true){
                /* 도서명과 가격 입력받음 */
                System.out.println("도서명을 입력하세요 : ");
                String title = sc.nextLine();
                System.out.println("가격을 입럭하세요 : ");
                int price = Integer.parseInt(sc.nextLine());
                System.out.println("도서 분류에 대한 넘버를 입력하세요.");
                System.out.println("1. 프로그래밍 언어");
                System.out.println("2. 웹 프로그래밍");
                System.out.println("3. 빅데이터");
                System.out.println("4. 데이터베이스");
                System.out.println("5. 인프라");
                System.out.println("선택 (1~5) : ");
                String kind = "b0";
                kind += sc.nextLine();
                System.out.println("정보가 입력되었습니다.");

                /* 세팅 및 반영 */
                pstmt.setString(1,title);
                pstmt.setInt(2, price);
                pstmt.setString(3,kind);
                pstmt.executeUpdate();
                System.out.println("book 테이블에 데이터 삽입 완료");
                cnt++;
                System.out.println("계속 입력하시겠습니까? (y/n) ");
                String aws = sc.nextLine();
                if (aws.equalsIgnoreCase("n")){
                    System.out.println(cnt+"개의 데이터 입력 완료!");
                    System.out.println("book 테이블 데이터 삽입 작업 종료");
                    break;
                }
            }
        } catch (SQLException se){
            System.out.println(se.getMessage());
        }
    }
}
