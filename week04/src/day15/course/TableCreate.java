package day15.course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreate {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		try {

			/* DB 연결 */
			String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
			String user = "jdbctest";
			String passwd = "jdbctest";
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("데이터베이스에 접속했습니다.");

			stmt = conn.createStatement();		// statement 객체 생성

			stmt.executeUpdate("create table student (name varchar(15) primary key, score int)");
			// 학생 테이블 생성 (name, score. 두 개의 컬럼을 가지는 테이블)
			// select 명령어 수행시 executeQuery 메서드 사용 (DB 테이블의 데이터를 읽어올 때)
			// executeUpdate() 메서드 - 접속된 DB 서버에서 Query(SELECT 명령ㅇ)을 실행하려면 Statement 객체의 executeQuery() 메서드를 사용하여 INSERT, DELETE, UPDATE, CREATE TABLE, DROP TABLE 등의 SELECT 명령 이외의 명령을 실행할 때 사용


			System.out.println("student 테이블 생성");						
		} catch (SQLException se1) {
			System.out.println(se1);
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
