package jpamvcexam.mainview;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

// 추출된 데이터가 없을 때 예외 발생이 아닌 '팀을 찾을수가 없네요'를 출력되도록 만들기

public class MemberTeamTest4_1 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
        Scanner scan = new Scanner(System.in);
        System.out.print("멤버명을 입력하세요 : ");
        String inputName = scan.nextLine();
        scan.close();
             
        String jpql = "select t.teamName from Member m join m.team t where m.username = :un";
        // 조인을 할 때 반드시 참조키를 가지고 있는 엔티티가 기준 엔터키가 되어야 함
        // 참조키를 member가 가지고 있으므로 얘가 먼저 나와야 함
        // 멤버가 속해있는 팀이름을 찾고자 하는 구문

        TypedQuery<String> q = em.createQuery(jpql, String.class);
        q.setParameter("un", inputName);

        List <String> teamName = q.getResultList();
        System.out.println("팀이름: "+ teamName);
        try{

            System.out.printf("%s님의 팀명은 %s입니다...\n", inputName, teamName);
        } catch (Exception e){
            e.printStackTrace();
            System.out.print("팀을 찾을 수 없네요..ㅜㅜ ");
        }


        em.close();
        factory.close();
	}
}
