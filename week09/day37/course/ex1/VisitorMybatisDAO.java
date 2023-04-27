package com.example.springedu.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.springedu.domain.VisitorDTO;
@Repository
public class VisitorMybatisDAO {	// 인터페이스를 사용하면 컨트롤러와 DAO간의 결합도를 낮출 수 있음
	// 인터페이스가 있으면 dao의 구현스펙을 인터페이스로 정의해놓고 implements해서 계속 사용할 수 있음
	// 인터페이스가 있으면 컨트롤로와 DAO간의 결합도가 낮아짐
	// 인터페이스에 호출되는 메서드의 스펙을 정희해놓고 구현은 클래스에서 하자.

	@Autowired
	SqlSession session;
	public List<VisitorDTO> list() {  // 마이바티스가 리스트 객체에 담아서 주므로 리스트 객체를 리턴하는게 제일 편함
		List<VisitorDTO> list = null;
		try {
			String statement = "resource.VisitorMapper.selectVisitor";
			list = session.selectList(statement);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;   // 마이바티스가 리스트 객체에 담아서 주므로 리스트 객체를 리턴하는게 제일 편함
	}

	public VisitorDTO one(int id) {
		VisitorDTO vo = null;
		try {
			String statement = "resource.VisitorMapper.selectVisitorOne";
			vo = session.selectOne(statement, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	public List<VisitorDTO> search(String keyword) {
		List<VisitorDTO> list = null;
		try {
			String statement = "resource.VisitorMapper.searchVisitor";
			list = session.selectList(statement, keyword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean insert(VisitorDTO visitor) {  // 두번쨰 인자로 전달해야하는 데이터를 전달해서 처리함
		boolean result = false; // 리턴값의 유형을 정하기 나름임
		try {
			String statement = "resource.VisitorMapper.insertVisitor";
			session.insert(statement, visitor);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;  // 리턴값의 유형을 정하기 나름임
	}

	public boolean delete(String id) { // 두번쨰 인자로 전달해야하는 데이터를 전달해서 처리함
		boolean result = false; // 리턴값의 유형을 정하기 나름임
		try {
			String statement = "resource.VisitorMapper.deleteVisitor";
			session.delete(statement, Integer.parseInt(id));
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result; // 리턴값의 유형을 정하기 나름임
	}

	public boolean update(VisitorDTO visitor) {  // 두번쨰 인자로 전달해야하는 데이터를 전달해서 처리함
		boolean result = false;  // 리턴값의 유형을 정하기 나름임
		try {
			String statement = "resource.VisitorMapper.updateVisitor";
			session.update(statement, visitor);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;  // 리턴값의 유형을 정하기 나름임
	}
}
