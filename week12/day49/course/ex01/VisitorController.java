package jpamvcexam.controller;

import jpamvcexam.model.dao.VisitorDAO;
import jpamvcexam.model.vo.Visitor;

import java.util.List;


// 하고자하는 작업을 dao에게 일을 시켜서 결과를 내보내는 것은 컨트롤러에서 함
// 프로젝트를 할 때에는 dao가 제공하는 여러가지 기능들과 관련된 메서드를 인터페이스로 만들어서 그 인터페이스를 컨트롤러가 사용하도록 만드는것이 확장성 측면에서 좋다
// 인터페이스를 통해서만 사용하게 되므로 dao가 바뀌더라도 컨트롤러는 손댈것이 없게 됨
// visitorDAO -> visitor와 관련한 인터페이스를 다음과 같이 구현 활 수 있음
// -> VisitorJdbcDAO, VisitorMybatisDAO, VisitorJpaDAO, VisitorXxxDAO
// 즉, 다른 객체가 정의하는 또 다른 객체를 정의할 떄에는 인터페이스를 만들어서 구현체를 정의하는 것이 확장성이 좋다.
public class VisitorController {  // 컨트롤러는 dao에 의존함
	private VisitorDAO dao;
	public VisitorController() {
		dao = new VisitorDAO();
	}
	public void listVisitor() {
		List<Visitor> list = dao.listAll();
		for(Visitor vo : list) {
			System.out.print(vo.getId()+"\t");
			System.out.print(vo.getName()+"\t");
			System.out.print(vo.getWriteDate()+"\t");
			System.out.println(vo.getMemo());
		}
	}

	public boolean oneVisitor(int id, boolean output) {
		Visitor vo = dao.one(id);
		boolean result = false;
		if(vo != null ) {
			result = true;
			if(output) {
				System.out.print(vo.getId()+"\t");
				System.out.print(vo.getName()+"\t");
				System.out.print(vo.getWriteDate()+"\t");
				System.out.println(vo.getMemo());
			}
		}
		return result;
	}
	public void searchVisitor(String keyword) {
		List<Visitor> list = dao.search(keyword);
		if (list.size() == 0)
			System.out.println(keyword + "를 포함한 글은 없네요~~");
		else
			for(Visitor vo : list) {
				System.out.print(vo.getId()+"\t");
				System.out.print(vo.getName()+"\t");
				System.out.print(vo.getWriteDate()+"\t");
				System.out.println(vo.getMemo());
			}
	}
	public void insertVisitor(String name, String memo) {
		Visitor vo = new Visitor();
		vo.setName(name);
		vo.setMemo(memo);
		System.out.println(vo);
		boolean result = dao.insert(vo);
		if (result)
			System.out.println(name +"님의 글이 성공적으로 저장했어요^^");
		else
			System.out.println(name +"님의 글 저장 작업을 실패했어요ㅜㅜ");
	}
	public void deleteVisitor(int id) {
		boolean result = dao.delete(id);
		if (result)
			System.out.println(id +"번 글을 성공적으로 삭제했어요^^");
		else
			System.out.println(id +"번 글이 존재하지 않아요ㅜㅜ");

	}
	public void updateVisitor(int id, String name, String memo) {
		Visitor vo = new Visitor();
		vo.setId(id);
		vo.setName(name);
		vo.setMemo(memo);
		boolean result = dao.update(vo);
		if (result)
			System.out.println(name +"님의 글이 성공적으로 수정했어요^^");
		else
			System.out.println(name +"님의 글 수정 작업을 실패했어요ㅜㅜ");
	}
	public void close() {
		dao.close();
	}
}
