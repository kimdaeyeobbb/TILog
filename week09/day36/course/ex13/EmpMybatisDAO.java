package week09.day36.course.ex13;

import com.example.springedu.domain.PageDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  // 스프링에 DAO 클래스를 선언할 때 사용, 해당 클래스가 DB와 관련된 작업을 수행함을 나타냄
public class EmpMybatisDAO {
	@Autowired  // Sqlsession -> @Autowired 어노테이션을 사용하여 session 필드에 자동으로 주입되도록 함
	SqlSession session;	  // SqlSession: Mybatis에서 제공하는 인터페이스. DB에 대한 모든 작업을 수행하는 객체
	public int getAllDataNum() {		
		String statement = "testdb.countEmp";   // testdb라는 MyBatis
		int num = session.selectOne(statement);
		return num;
	}
	
	public List<EmpVO> listAll() {
		String statement = "testdb.selectEmp";
		List<EmpVO> list = session.selectList(statement);
		return list;
	}
	
	public List<EmpVO> listPart(PageDTO vo) {
		String statement = "testdb.partEmp";
		vo.setCountNum(vo.getEndNum()-vo.getStartNum()+1);
		List<EmpVO> list = session.selectList(statement, vo);
		return list;
	}
}
