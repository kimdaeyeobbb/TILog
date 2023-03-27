package day15.hw.review;
import java.sql.*;
import java.util.Scanner;

public class SelectBookLab {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "jdbctest";
        String passwd = "jdbctest";
        try(Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement stmt = conn.createStatement();
            Scanner sc = new Scanner(System.in);){
            while(true) {
                System.out.println("1. 모두 출력하기");
                System.out.println("2. 가격이 높은 순으로 출력하기");
                System.out.println("3. 20000 이상의 도서들만 출력하기 (3번 입력시 2만원 이상의 도서들만 출력)");
                System.out.println("4. 웹 프로그래밍 도서들만 출력하기");
                System.out.println("5. 데이터베이스와 인프라 도서들만 출력하기");
                System.out.println("6. 도서명에 '자바'를 포함하는 도서들만 출력하기");
                System.out.println("7. 분류별 도서 가격의 평균을 출력하기 (GROUP BY절 써서 평균구하기)");
                System.out.println("원하는 메뉴의 번호를 선택 : ");

                int num = Integer.parseInt(sc.nextLine());
                ResultSet rs;
                String sqlStr = "";
                switch (num) {
                    case 1:
                        sqlStr = "select id, title, format(price, 0), kind from book";
                        break;
                    case 2:
                        sqlStr = "select id, title, format(price, 0), kind from book order by price desc";
                        break;
                    case 3:
                        sqlStr = "select title, format(price, 0) from book where price >= 20000";
                        break;
                    case 4:
                        sqlStr = "select title, format(price, 0) from book where kind like '%b02%'";
                        break;
                    case 5:
                        sqlStr = "select title, format(price, 0) from book where kind like '%b04%' and like '%b05%'";
                        break;
                    case 6:
                        sqlStr = "select title, format(price, 0) from book where title like '%자바%'";
                        break;
                    case 7:
                        sqlStr = "select kind, format(avg(price), 0) from book group by kind";
                        break;
                }
                rs = stmt.executeQuery(sqlStr);
                String bookName = "";
                String bookNum = rs.getString(1);
                if(rs.next()) {
                    do {
                        if(num < 3){
                            System.out.println(rs.getString(1)+ " " + rs.getString(2) + " " + rs.getString(3) + "  " + rs.getString(4));
                        } else if (num <7){
                            System.out.println(rs.getString(1)+"의 가격은 "+rs.getString(2)+"원 입니다.");
                        } else {
                            if (bookNum.equals("b01")){
                                bookName = "프로그래밍 언어";
                            } else if (bookNum.equals("b02")){
                                bookName = "웹 프로그래밍";
                            } else if (bookNum.equals("b03")){
                                bookName = "빅데이터";
                            } else if (bookNum.equals("b04")){
                                bookName = "데이터베이스";
                            } else if (bookNum.equals("b05")){
                                bookName = "인프라";
                            }
                            System.out.println(bookName+" 도서들의 가격 평균은 "+rs.getString(2)+"원 입니다.");
                        }
                    } while (rs.next());
                } else {
                    System.out.println("찾으시는 책이 없습니다.");
                }

                System.out.println("계속 입력하시겠습니까? (n 입력시 종료) ");
                String aws = sc.nextLine();
                if(aws.equalsIgnoreCase("n")){
                    System.out.println("종료합니다.");
                    rs.close();
                    break;
                }
            }
        } catch (SQLException se){
            System.out.println(se.getMessage());
        }
    }
}