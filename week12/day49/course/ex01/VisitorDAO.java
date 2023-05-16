package jpamvcexam.model.dao;

import jpamvcexam.model.vo.Visitor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class VisitorDAO {

	private EntityManagerFactory factory;

	public VisitorDAO() {
		super();
		factory = Persistence.createEntityManagerFactory("emptest");  // 객체생성시 엔티티매니저 팩토리 객체를 생성
	}

	/* 각 기능을 수행할 떄마다 엔티티매니저객체를 열었다가 닫았다가 반복하고 있음 */

	public List<Visitor> listAll() {
		EntityManager em = factory.createEntityManager();

		// visitor 테이블의 전체 행 출력
		TypedQuery<Visitor> q = em.createQuery("select t from Visitor t", Visitor.class);
		List<Visitor> list = q.getResultList();
		em.close();
		return list;
	}

	public Visitor one(int id) {
		EntityManager em = factory.createEntityManager();
		Visitor vo = em.find(Visitor.class, id);  // find 메서드를 사용하여 특정 pk에 해당되는 글 하나만 가져옴
		em.close();
		return vo;
	}

	public List<Visitor> search(String keyword) {
		EntityManager em = factory.createEntityManager();
		TypedQuery<Visitor> q = em.createQuery("select t from Visitor t WHERE t.memo like :keyword", Visitor.class);
		q.setParameter("keyword", "%" + keyword + "%");   // name parameter 설정해줌
		List<Visitor> list = q.getResultList();
		em.close();
		return list;
	}

	public boolean insert(Visitor vo) {
		boolean result = true;
		EntityManager em = factory.createEntityManager();

		// 트랜잭션 처리
		try {
			em.getTransaction().begin();
			em.persist(vo);
			em.getTransaction().commit();   // 처리가 끝나면실제 db에 반영이 되도록 함
		} catch (Exception e) {   // 예외 발생시
			result = false;
		}
		em.close();
		return result;
	}

	public boolean delete(int id) {
		boolean result = true;
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			Visitor vo = em.find(Visitor.class, id);   // delete 할 엔티티 객체를 가져와서
			em.remove(vo);   // Remove -> 커밋될때 전달됨
			em.getTransaction().commit();
		} catch (Exception e) {
			result = false;
		}
		em.close();
		return result;
	}

	public boolean update(Visitor vo) {
		boolean result = true;
		EntityManager em = factory.createEntityManager();
		try {			// 트랜잭션이 시작된 상태에서 작업을 해주어야하는 dml명령어 중 하나
			em.getTransaction().begin();
			Visitor oldVo = em.find(Visitor.class, vo.getId());   // 수정할 엔티티 객체를 가져옴 (수정할 글에 대한 id를 가져옴 -> id를 가지고 글에 대한 엔티티 객체를 받아옴)
			System.out.println(oldVo.getName());

			// 수정은 setter 메서드로 바꿔주기만 하면 끝! (update 메서드 없음. 영속성 컨텍스트 객체가 항상 만들어진 엔티티 객체에 대해 가지고 있는 값을 캡쳐해서 보관하고 있음.)
			// 엔티티 객체를 위에서 받아왔으므로 영속성 엔티티 객체의 참조값을 가져와서 안의 엔티티 객체의 값을 바꿔줌. -> 비교해서 바뀌었다면 update명령어를 날림.
			// 엔티티 객체를 가져와서 값만 새로 설정하면 끝!. 이름을 바꾸고 싶으면 setname만 호출하면됨. 메모만 바꾸고 싶으면 setMemo()만 호출하면됨
			// 커밋헀을 때 db 서버에 update 명령어를 날려줌
			// 이것만으로 하이버네이트 db 하이엔드를 사용하지 않을 이유가 없다
			oldVo.setName(vo.getName());
			oldVo.setMemo(vo.getMemo());
			em.getTransaction().commit();
		} catch (Exception e) {
			result = false;
		}
		em.close();
		return result;
	}
	public void close() {
		if (factory != null)
			factory.close();
	}
}
