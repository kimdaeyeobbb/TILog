package day14.hw.course;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class VisitorList {
	public static void main(String[] args) throws Exception {
		// 나를 호출한 애한테 예외처리를 넘김 (소극적 예외처리)
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		Connection conn = DriverManager.getConnection(url,user,passwd);
		Statement stmt = conn.createStatement();
		String sql = "SELECT id, name, writedate, memo FROM visitor";
		// where 절이 없으므로 모든 행을 다 꺼내오겠다는 뜻
		// id대신 1, name 대신 2, writedate 대신 3, memo 대신 4를 써도 됨

		ResultSet rs = stmt.executeQuery(sql);		
		while(rs.next()) {
			System.out.print(rs.getString("id")+"\t");
			System.out.print(rs.getString("name")+"\t");
			System.out.print(rs.getString("writedate")+"\t");
			System.out.println(rs.getString("memo"));
		}	
		rs.close();
		stmt.close();
		conn.close();
	}
}




