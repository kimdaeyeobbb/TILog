package jpamvcexam.model.dao;

import jpamvcexam.model.vo.Student;

import javax.persistence.*;
import java.util.List;

public class StudentDAO {
    private EntityManagerFactory factory;
    // jpa의 핵심 인터페이스. 데이터베이스와의 연결을 관리하고 jpa의 기능을 사용할 수 있게 해줌
    // 애플리케이션 전체에서 하나만 생성되며, 데이터베이스와의 연결을 설정하고 jpa의 영속성 컨텍스트(persistence context)를 생성함
    // 주로 애플리케이션의 시작 지점에서 한 번 생성되고, 애플리케이션의 라이프사이클동안 재사용됨
    // 보통 싱글톤 패턴이나 의존성 주입(dependency injection)프레임 워크를 통해 인스턴스를 관리함

    public StudentDAO(){
        super();
        factory = Persistence.createEntityManagerFactory("emptest");
        // emptest라는 이름의 persistence unit을 사용하여 엔티티매니저팩토리 객체 생성
        // 이를 사용하여 엔티티 매니저의 인스턴스를 생성하고 데이터베이스와의 상호작용을 수행할 수 있음
    }

    /* 각 기능을 수행할때마다 엔티티매니저 객체를 열었다/닫았다를 반복 */

    /* 1. 학생 정보 출력 */
    public List<Student> getAllStudent(){
        EntityManager em = factory.createEntityManager();

        /* student 테이블의 전체 행 출력 */
        TypedQuery<Student> q = em.createQuery("select t from Student t", Student.class);
        List<Student> list = q.getResultList();
        em.close();
        return list;  // 데이터가 없으면 비어있는 리스트를 리턴
    }

    /* 2. 학생 정보 입력 */
    public boolean insertStudent(Student entity){
        boolean result = true;
        EntityManager em = factory.createEntityManager();


        /* 트랜잭션 처리 */
        try{
            System.out.println("1. 엔티티: "+entity);
            em.getTransaction().begin(); // em객체의 트랜잭션 시작. 이후 데이터베이스 작업은 하나의 트랜잭션으로 묶임
            System.out.println("2. 엔티티: "+entity);

            em.persist(entity);   // em객체의 persist 메서드를 이용하여 entity 객체를 영속성 컨텍스트에 추가함. -> entity 객체는 데이터베이스에 삽입될 준비가 됨
            System.out.println("3. 엔티티: "+entity);

            em.getTransaction().commit();  // 트랜잭션을 커밋하여 데이터베이스에 변경 내용을 실제로 반영함. 이 시점에서 entity 객체의 정보가 데이터베이스에 반영됨
        } catch(Exception e){
            System.out.println("실패 엔티티: "+entity);
            result = false;
        }
        em.close();
        return result;
    }

    /* 3. 학생 정보 삭제 */
    public boolean deleteStudent(String name){
        boolean result = true;
        EntityManager em = factory.createEntityManager();
        // 엔티티 매니저는 jpa에서 엔티티와 관련된 작업을 할 때 사용됨
        try{
            em.getTransaction().begin();  // em 객체의 트랜잭션을 시작함
            Student entity = em.find(Student.class, name);  // delete할 엔티티 객체 가져와서
            em.remove(entity); // remove -> 커밋시 전달됨 -> 해당 핵성 정보가 데이터베이스에서 삭제 됨
            em.getTransaction().commit();  // 트랜잭션을 커밋하여 데이터베이스에 변경 내용을 실제로 반영함. 이 시점에서 학생 정보의 삭제가 완료됨.
        } catch (Exception e){  // db 삭제 작업시 실패한 경우
            result = false;
        }
        em.close();  // em 객체를 닫아서 리소스를 정리함
        return result;
    }

    /* 4. 학생 정보 수정 */
    public boolean updateStudent(Student entity){
        boolean result = true;
        EntityManager em = factory.createEntityManager();
        try{
            em.getTransaction().begin();
            Student student = em.find(Student.class, entity.getName());
            // 이름을 이용해 수정할 학생정보에 대한 엔티티 객체 가져옴

            student.setName(entity.getName());
            student.setScore(entity.getScore());
            em.getTransaction().commit();
        } catch (Exception e){
            result = false;
        }
        em.close();
        return result;
    }

    /* 5. 학생 점수 확인 */
    public Student getScore(String name){
        EntityManager em = factory.createEntityManager();
        try{
            em.getTransaction().begin();
            Student student = em.find(Student.class, name);
            // 이름을 기준으로 학생 정보를 조회하여 student 객체에 저장

            em.getTransaction().commit();
            em.close();
            return student;
        } catch (Exception e){  // 이름이 없는 경우
            e.printStackTrace();
            em.close();
            return null;
        }
    }

    /* 6. 종료 */
    public void close(){
        if(factory != null){
            factory.close();
        }
    }
}