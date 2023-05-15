package jpamvcexam.mainview;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// 실질적으로 수행되는 애들은 하이버네이트에서 제공되는 이런저런 애들을 사용

public class HelloJpa2 {
    public static void main(String[] args) {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
        System.out.println("EntityManagerFactory 객체 : " + factory.getClass().getName());
        EntityManager em = factory.createEntityManager();   
        System.out.println("EntityManager 객체 : " + em.getClass().getName());
        em.close();
        factory.close();
    }
}
