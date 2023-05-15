package jpamvcexam.mainview;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class HelloJpa1 {
    public static void main(String[] args) {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");  // 엔티티매니저 팩토리 객체 생성
    	System.out.println("EntityManagerFactory 객체 : " + factory.getClass().getName());    	
        factory.close();
    }
}
