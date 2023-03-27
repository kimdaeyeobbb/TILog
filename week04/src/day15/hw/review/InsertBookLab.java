package day15.hw.review;

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