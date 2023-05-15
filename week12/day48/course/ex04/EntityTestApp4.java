package jpamvcexam.mainview;

import jpamvcexam.model.entity.EntityTest;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class EntityTestApp4 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
        EntityTest et;
        em.getTransaction().begin();
        
        for(int i=51; i < 56; i++) {
        	et = new EntityTest();
        	et.setName("도우너"+i);
        	et.setAge(10+i);
        	et.setBirthday(LocalDateTime.now());
        	em.persist(et);
        }
        
        Scanner scan = new Scanner(System.in);
        System.out.println("엔터키.....");
        scan.nextLine();  
        TypedQuery<EntityTest> q = em.createQuery("select t from EntityTest t", EntityTest.class);
    	List<EntityTest> list = q.getResultList();
    	list.stream().forEach(System.out::println);
    	
    	for(int i=101; i < 106; i++) {
        	et = new EntityTest();
        	et.setName("또치"+i);
        	et.setAge(10+i);
        	et.setBirthday(LocalDateTime.now());
        	em.persist(et);
        }

    	System.out.println("엔터키.....");
        scan.nextLine();  
        em.flush();   // flush를 통해 실제 db에 반영이 되게 만듦

        q = em.createQuery("select t from EntityTest t", EntityTest.class);
        list = q.getResultList();
        list.stream().forEach(System.out::println);
        
        System.out.println("엔터키.....");
        scan.nextLine();  
        em.getTransaction().rollback();
        // rollback -> 이 트랜잭션 안에서 수행한 것들은 취소됨. (커밋까지 가야지 실제 db테이블에 반영됨)
        // 아무리 flush를헀더라도 마지막에 트랜잭션이 끝나는 상황에서 롤백을 하면 이때까지 버퍼에 쌓여있던것들이 모두 취소됨.
        // 따라서 또치와 도우너 정보는 Db테이블에 저장되지 않음.

        em.close();
        factory.close();
        scan.close();
	}
}