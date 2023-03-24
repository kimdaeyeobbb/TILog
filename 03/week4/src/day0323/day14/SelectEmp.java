package day0323.day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectEmp {
	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		Connection conn = DriverManager.getConnection(url, user, passwd);

		System.out.println(conn.getClass().getName());  // 실제 리턴된 객체 확인

		Statement stmt = conn.createStatement(); // statement 객체 확인 (Statement는 인터페이스라 객체가 확인이 안되므로 자식 클래스의객체가 리턴됨)

		System.out.println(stmt.getClass().getName());

		ResultSet rs = stmt.executeQuery("select ename, job, format(sal, 0) sal, deptno  from emp");
		// emp 테이블로 부터 ename ~ deptno 컬럼을 꺼냄
		// sal만 format함수의 결과로 꺼냄 (format함수는 두번쨰 인자가 소수점 몇번쨰까지 나타낼 것인지를 지정. 0이면 소수점 이하는없음.)
		// format 함수 쓰면 1000단위마다 콤마. 숫자가 아닌 문자열이 됨.
		// format(sal, 0) sal 에서 뒤의 sal은 별칭

		System.out.println(rs.getClass().getName());

		/* 타이틀 출력 */
		System.out.printf("%10s%10s%10s%10s\n", "성명", "직무", "급여", "부서");
		System.out.println("  -----------------------------------------");

		/* 중요 */
		// rs에 담기는 resultSet 객체는 첫번째행 바로 전의 결과를 담고 있으므로 next를 호출해서 첫번쨰행으로 가야함
		// 또 next 호출해서 그 다믕행으로 계속해서 옮겨가야함. next 결과가 거짓이면 더 이상 옮겨갈 행이 없는 것
		while (rs.next()) {
				System.out.printf("%10s%10s%10s원%10d\n",
						/* select 절의 컬럼 순서에 따라서 추출해낼 수도 있음 */
						rs.getString("ename"), rs.getString("job"), 
//						rs.getString("1"), rs.getString("2"), // 위와 동일

						rs.getString("sal"), rs.getInt("deptno"));
//						rs.getString("3"), rs.getInt("4"));  // 위와 동일
		}
		rs.close();
		stmt.close();
		conn.close();
	}
}
