package day15.course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectSalEmp {
	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		Connection conn = DriverManager.getConnection(url,user,passwd);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT ename, concat(format(sal, 1),'달러') fsal FROM emp ORDER BY sal DESC");
		// concat - 두 인자를 하나로 결합
		// DB 시스템은 DB처리에 있어 우리보다 훨씬 빠르고 특화되어 있으므로 분류작업을 우리가 직접하기 보다 SQL에게 작업을 맡기는것이 낫다.
		// MYSQL - FORMAT을 통해 자리수 구별
		// ORDER BY - 모든 DBMS에서 똑같음
		// 함수는 DBMS마다 동일하다는 보장이 없다

		System.out.printf("%-8s%-8s\n", "성명", "급여");
		System.out.println("  --------------------------");
		while (rs.next()) {
			System.out.printf("%-10s%-12s\n", rs.getString("ename"), rs.getString("fsal"));
		}
		rs.close();
		stmt.close();
		conn.close();
	}
}
