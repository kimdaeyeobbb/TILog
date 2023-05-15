package jpamvcexam.mainview;

import jpamvcexam.model.entity.EntityTest;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

// 집어넣고 싶은 내용을 담고있는 엔티티를 만들어서 Persist 호출 -> flush 혹은 commit을 해야 실제 db 테이블에 반영이 됨
public class EntityTestApp3 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
       	TypedQuery<EntityTest> q = em.createQuery("select t from EntityTest t", EntityTest.class);
    	List<EntityTest> list = q.getResultList();
    	list.stream().forEach(e -> System.out.println(e));      
        factory.close();
	}
}
