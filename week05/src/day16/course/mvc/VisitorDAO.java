package day16.course.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VisitorDAO {
	// 실제 메서드 작명시 DAO라 명명하면 안됨
	public boolean c(Scanner scan) {
		boolean result = false;
		Connection conn = MySQLConnect.connect();
		// Connect 클래스의 메서드 호출해서 DB서버 연결작업

		try (PreparedStatement pstmt = conn
				.prepareStatement("insert into visitor (name, writedate, memo) values (?, now(), ?)")) {
			// now: 작성 시점이 현재시점이 되도록 함 (굳이 사용자에게 작성시점을 입력받을 필요가 없다)
			while (true) {
				System.out.print("작성자 이름을 입력하세요 : ");
				String name = scan.nextLine();
				System.out.print("글의 내용을 입력하세요 : ");
				String memo = scan.nextLine();
				pstmt.setString(1, name);
				pstmt.setString(2, memo);
				pstmt.executeUpdate();
				System.out.println("visitor 테이블에 데이터 삽입 완료");
				System.out.print("계속 입력하겠습니까?(y/n) ");
				String aws = scan.nextLine();
				if (aws.equalsIgnoreCase("y")) {
					continue;
				}
				break;
			}
			result = true;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		MySQLConnect.close(conn);
		return result;
	}

	public List<VisitorDTO> r() {
		Connection conn = MySQLConnect.connect();
		List<VisitorDTO> vlist = null;
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(
					"select id, name, date_format(writedate, '%Y년 %m월 %d일') writedate, memo from visitor order by writedate desc");
			// 작성자명과 작성 내용 받아서 처리
			// select 수행시 resultset 객체가 리턴됨
			// JDBC API는 DAO에서만 사용해야 역할 분담이 됨
			vlist = new ArrayList<VisitorDTO>();
			while (rs.next()) {
				VisitorDTO vo = new VisitorDTO();  // VisitorDTO 객체 생성
				/* SETTER 메서드 사용 */
				// SELECT 된 행의 개수만큼
				vo.setId(rs.getInt("id"));
				vo.setName(rs.getString("name"));
				vo.setWriteDate(rs.getString("writedate"));
				vo.setMemo(rs.getString("memo"));
				vlist.add(vo);
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		MySQLConnect.close(conn);
		return vlist;  // r이 리턴한 arrayList 객체를 가지고 요소를 하나하나 꺼내서 화면에 출력하면 됨
	}
	public boolean u(Scanner scan, int id) {
		boolean result = false;
		Connection conn = MySQLConnect.connect();
		try (PreparedStatement pstmt = conn.prepareStatement("update visitor set name = ?,  memo = ? where id = ?")) {
			System.out.print("수정할 작성자 이름을 입력하세요 : ");
			String name = scan.nextLine();
			System.out.print("수정할 글의 내용을 입력하세요 : ");
			String memo = scan.nextLine();
			pstmt.setString(1, name);
			pstmt.setString(2, memo);
			pstmt.setInt(3, id);
			pstmt.executeUpdate();		
			result = true;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		MySQLConnect.close(conn);
		return result;
	}

	public boolean d(int id) {
		boolean result = false;
		Connection conn = MySQLConnect.connect();
		try (PreparedStatement pstmt = conn.prepareStatement("delete from visitor where id = ?")) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			result = true;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		MySQLConnect.close(conn);
		return result;
	}
}
