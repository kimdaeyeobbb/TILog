package day16.course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableDrop {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		try {
			String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
			String user = "jdbctest";
			String passwd = "jdbctest";
			conn = DriverManager.getConnection(url, user, passwd);	
			System.out.println("데이터베이스에 접속했습니다.");
			stmt = conn.createStatement();		
			stmt.executeUpdate("drop table student");
			// 테이블 삭제
			// executeUpdate 이용
			// 테이블은 대부분 미리 만들어놓고 sql 문을 이용해서 CRUD 구현. 보통 drop table은 잘 사용하지 않음
			System.out.println("student 테이블 제거");
		} catch (SQLException se1) {
			System.out.println(se1.getMessage());
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException se2) {
				System.out.println(se2.getMessage());
			}
		}
	}
}
