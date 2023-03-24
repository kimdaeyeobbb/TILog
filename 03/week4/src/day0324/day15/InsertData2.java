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
