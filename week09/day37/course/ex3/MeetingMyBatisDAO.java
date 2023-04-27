package com.example.springedu.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springedu.domain.MeetingDTO;
import com.example.springedu.domain.ReplyVO;
@Repository
public class MeetingMyBatisDAO {
	@Autowired
	SqlSession session = null;
	public List<MeetingDTO> listM(){
		String statement = "resource.MeetingMapper.selectMeeting";
		List<MeetingDTO> list = session.selectList(statement);
		return list;
	}

//	public MeetingDTO oneM(){
//		String statement = "resource.MeetingMapper.selectOneMeeting";
//		MeetingDTO vo = session.selectOne(statement);
//		return vo;
//	}

	public List<MeetingDTO> searchM1(String keyword){
		String statement = "resource.MeetingMapper.searchMeetingK";
		List<MeetingDTO> list = session.selectList(statement, keyword);
		return list;
	}


	//	인자로 전달된 name에 해당되는 대상을 만나는 글만 꺼내겠다는 것
	public List<MeetingDTO> searchM2(String name){
		String statement = "resource.MeetingMapper.searchMeetingN";   // id값이 searchMeetingN으로 정의되어 있을 것임
		List<MeetingDTO> list = session.selectList(statement, name);
		return list;
	}

	public boolean insertM(MeetingDTO vo) {
		boolean result = true;
		String statement = "resource.MeetingMapper.insertMeeting";  //이를 정의하고 있는 태그의 id값을 사용하고 있음
		if(session.insert(statement, vo) != 1)  // insert 메서드를 호출
			// executeUpdate라는 함수를 호출 -> 리턴값이 숫자 -> 숫자는 변화된 행의 개수를 뜻함 -> insert는 행의 변화개수가 1 -> 1이 리턴
			// 리턴값이 1이 아니면 변화가 제대로 이루어지지 않은 것
			// mybatis는 JDBC를 사용하는 것임 (내부적으로 알아서 사용해줌)
			result = false;
		return result;
	}

	public boolean deleteM(int id) {
		boolean result = true;
		String statement = "resource.MeetingMapper.deleteMeeting";
		if(session.delete(statement, id) != 1)   // delte 수행시 결과는 1또는 1이 아님 -> 1이면 delete가 제대로 수행된 것 (1이 아니면 delete가 제대로 이루어지지 않은 것)
			// 여러 행(이나 여러개의 글)을 삭제하는 경우 지금처럼 1로 비교하면 안됨
			result = false;
		return result;
	}

	public boolean updateM(MeetingDTO vo) {
		boolean result = true;
		String statement = "resource.MeetingMapper.updateMeeting";
		if(session.update(statement, vo) != 1)
			result = false;
		return result;
	}

	public List<ReplyVO> listReply(int refid) {  // 댓글 내용 읽어옴
		String statement = "resource.MeetingMapper.replySelectMeeting";
		List<ReplyVO> list = session.selectList(statement, refid);  // 메인글의 아이디를 받아서 두번쨰 인자로 넣어줌
		return list;
	}

	public boolean insertReply(ReplyVO vo) {
		boolean result=true;
		String statement = "resource.MeetingMapper.replyInsertMeeting";
		if(session.insert(statement, vo) != 1)   // 리턴값이 1이면 댓글 작성이 제대로 된것 (1이 아니면 댓글이 제대로 작성되지 않은 것)
			result = false;
		return result;
	}
}
