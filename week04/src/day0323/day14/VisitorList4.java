package day0323.day14;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class VisitorList4 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		String sql = "SELECT id, name, DATE_FORMAT(writedate, '%Y년 %m월 %d일') writedate, memo FROM visitor";
		// 년월일만 삽입헀으므로 시분초는 00:00:00로 기재됨


		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				Statement stmt = conn.createStatement();			
				ResultSet rs = stmt.executeQuery(sql);) {
			// if문을 통해 이미 next했으므로 그다음행으로 넘어가고 그다음에 바로 while문을 쓰면 또 다음행으로 넘어가니까 첫번쨰행이 생략됨.
			// 따라서 do while문을 통해 첫번쨰행을 반드시 읽게끔 만들어줌.
			if(rs.next() ) {				
				do {
					System.out.print(rs.getString("id")+"\t");
					System.out.print(rs.getString("name")+"\t");
					System.out.print(rs.getString("writedate")+"\t");
					System.out.println(rs.getString("memo"));
				} while (rs.next());
			} else {
				System.out.println("추출된 행이 없숑!!");
			}			
		} catch (Exception e) {
			System.err.println("오류 발생 : " + e);
		} 
	}
}
