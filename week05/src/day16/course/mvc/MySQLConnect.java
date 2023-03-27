package day16.course.mvc;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnect {
	/* DB서버에 대한 접속 - CRUD수행시 DB 서버에 대한 연결은 필수 */
	public static Connection connect() {
		Connection conn = null;
		try {		
			String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
			String user = "jdbctest";
			String passwd = "jdbctest";
			conn = DriverManager.getConnection(url, user, passwd);						
		} catch (Exception e) {
			System.out.println("MYSQL 연결 실패");
			System.out.print("사유 : " + e.getMessage());
		}
		return conn;
	}
	public static void close(Connection conn) {
		try {
			if (conn != null) 
				conn.close();
		} catch (Exception e) {
			System.out.println("MYSQL 닫기 실패");
			System.out.print("사유 : " + e.getMessage());
		}
	}
}