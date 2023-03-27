package day15.course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchEmp {
	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		Connection conn = DriverManager.getConnection(url, user, passwd);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select ename, job, sal, deptno  from emp where ename like '%T%'");
		// Like - 패턴 비교. 어떤 문자로 시작하거나 끝나거나 포함하는지를 체킹. 게시판 검색할 때 많이 사용.
		// 이름에 대문자 T가 포함된 사람을 찾음

		System.out.printf("%8s%8s%8s%4s\n", "성명", "직무", "급여", "부서");
		System.out.println("  -----------------------------------");
		while (rs.next()) {
				System.out.printf("%10s%12s%8d%4d\n", 
						rs.getString("ename"), rs.getString("job"), 
						rs.getInt("sal"), rs.getInt("deptno"));
		}
		rs.close();
		stmt.close();
		conn.close();
	}
}
