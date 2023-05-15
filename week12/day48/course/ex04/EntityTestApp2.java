package jpamvcexam.mainview;

import jpamvcexam.model.entity.EntityTest;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.Scanner;

public class EntityTestApp2 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
        EntityTest et;
        em.getTransaction().begin();
        
        for(int i=1; i < 6; i++) {
        	et = new EntityTest();   // 엔티티테스트 객체 5개 생성
        	et.setName("둘리"+i);  // 둘리 1~5
        	et.setAge(10+i);  // 나이 11~15
        	et.setBirthday(LocalDateTime.now());   // 현재시간 적용
        	em.persist(et);  // persist -> insert역할 수행
            // commit이 일어나지 않았으므로 실제 db테이블에 들어가는것이 아님. persist객체 안에만 들어간것.
        }

        System.out.println("엔터키.....");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        scan.close();
        em.getTransaction().commit();
        // 엔터키를 눌러야 커밋이 됨
        em.close();
        factory.close();
	}
}