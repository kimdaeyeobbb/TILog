package jpamvcexam.mainview;

import jpamvcexam.model.entity.EntityTest;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class EntityTestApp5 {
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
        System.out.println("---------------------------");
    	System.out.println("마지막 엔티티 삭제");
//    	EntityTest finalData = em.find(EntityTest.class, 60);
        // 롤백헀더라도 이미 increment된것은 복귀되지 않음.
        // 60을 지우려고해도 지울애가 없음.

        EntityTest finalData = em.find(EntityTest.class, 19);  // 19를 지우기 위한 과정
        // 지우고 싶은 엔티티 객체를 받아와서 Remove 하면 됨
        // 실제 db테이블에는 remove하는 delete명령어가 자동으로 수행되는 것
        // 공지글에 번호를 붙이고 싶으면 그떄그때 붙여야지, id를 쓰면 안됨 (id는 각각의 데이터를 구분하는 숫자의 역할을 할뿐임.)

    	em.remove(finalData);
    	System.out.println("엔터키.....");
        scan.nextLine();  
        TypedQuery<EntityTest> q = em.createQuery("select t from EntityTest t", EntityTest.class);
    	List<EntityTest> list = q.getResultList();
    	list.stream().forEach(System.out::println);  
    	System.out.println("엔터키.....");
        scan.nextLine();     	
        em.getTransaction().commit();
        q = em.createQuery("select t from EntityTest t", EntityTest.class);
    	list = q.getResultList();
    	list.stream().forEach(System.out::println);
        em.close();       
        factory.close();
        scan.close();
	}
}
