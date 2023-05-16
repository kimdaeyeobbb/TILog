package jpamvcexam.mainview;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.persistence.*;

public class EmpDeptLab {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
        Scanner sc = new Scanner(System.in);

        Random random = new Random();
        boolean randomTF = random.nextBoolean();
        String jpql = "";

        if(randomTF){
            System.out.println("사원명을 입력하세요: ");
            String empName = sc.nextLine();
            jpql = "SELECT d.dname FROM Emp e JOIN e.dept d WHERE e.ename = :empname";
            TypedQuery<String> query = em.createQuery(jpql, String.class);
            query.setParameter("empname", empName);
            List<String> deptName = query.getResultList();
            if(!deptName.isEmpty()) {
                System.out.printf("%s님의 부서명은 %s입니다.\n", empName, deptName.get(0));
            } else {
                System.out.println("부서명을 찾을 수 없네요..ㅜㅜ");
            }

        } else {
            System.out.println("부서명을 입력하세요: ");
            String deptName = sc.nextLine();
            jpql = "SELECT e.ename FROM Emp e JOIN e.dept d WHERE d.dname = :deptname";
            TypedQuery<String> query = em.createQuery(jpql, String.class);
            query.setParameter("deptname", deptName);
            List<String> empName = query.getResultList();

            if(!empName.isEmpty()) {
                System.out.printf("%s 부서에 있는 직원들 이름입니다.\n", deptName);
                for (String emp: empName) {
                    System.out.println(emp);
                }
            } else{
                System.out.println("직원을 찾을 수 없네요..ㅜㅜ");
            }
        }
        sc.close();
        em.close();
        factory.close();
    }
}