package day16.course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class DeleteData1 {
	public static void main(String[] args) {
		// JDBC 드라이버가 6 이후가 아닌 이전에 만들어졌을 경우 getConnection 만으로 드라이버를 못찾음.
		// 따라서 이와 같이 try-catch를 이용해서 드라이버를 찾는 과정이 필요함
		/* 드라이버를 찾는 과정 */
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
			return;
		} 
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC"; // 이 정보를 가지고 이미 로딩이 끝난 드라이버를 찾아서 DB서버에 로딩함
		String user = "jdbctest";
		String passwd = "jdbctest";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);  // 초기화가 끝난 드라이버를 인식
				PreparedStatement pstmt = conn.prepareStatement("delete from student where name = ?");
			 // 학생 이름을 주면 삭제

			 Scanner scan = new Scanner(System.in);){
			System.out.print("학생 이름을 입력하세요 : ");
		    String name = scan.nextLine();
			pstmt.setString(1, name);
			int delNum = pstmt.executeUpdate();
			// 리턴값이 executeUpdate 수행
			// 이름이 없는 친구를 삭제하면 0행 삭제
			System.out.println("student 테이블에서 " + delNum + "행 삭제 완료");						
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} 
	}
}
