package jpamvcexam.mainview;

import jpamvcexam.model.vo.Book;
import jpamvcexam.model.vo.EmpVO;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JPASelectBookLab {
    public static void hr(){
        for (int i=1; i<100; i++){
            System.out.println("-");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
        EntityManager em = factory.createEntityManager();

        // em을 사용하여 데이터베이스와 상호작용 (엔티티 조회 및 저장)
       Scanner sc = new Scanner(System.in);
       TypedQuery typedQuery;
       List<Book> bookList;
       Book findById;
       Query query;

       List<Object[]> objects;  // object 배열을 담는 리스트 객체
        Random random = new Random();
        label: while(true){
            System.out.println("\n1. 모두 출력하기");
            System.out.println("2. 가격이 높은 순으로 출력하기");
            System.out.println("3. 20000원 이상의 도서들만 출력하기");
            System.out.println("4. id가 3번인 도서 출력하기");
            System.out.println("5. 도서명에 '자바' 또는 '스프링'을 포함하는 도서들만 출력하기");
            System.out.println("6. 분류별 도서 가격의 합을 출력하기");
            System.out.println("7. 종료\n");
            System.out.println("원하는 메뉴의 번호를 선택 : ");
            int num = sc.nextInt();
            switch (num){
                case 1:
                    typedQuery = em.createQuery("select b from Book b", Book.class);
                    bookList = typedQuery.getResultList();
                    for (Book book: bookList){
                        System.out.println(book);
                    }
                    break;
                case 2:
                    typedQuery = em.createQuery("select b from Book b order by b.price desc", Book.class);
                    bookList = typedQuery.getResultList();
                    for (Book book: bookList){
                        System.out.println(book);
                    }
                    break;
                case 3:
                    typedQuery = em.createQuery("select b from Book b WHERE b.price >= 20000", Book.class);
                    bookList = typedQuery.getResultList();
                    for (Book book: bookList){
                        System.out.println(book);
                    }
                    break;
                case 4:
                    findById = em.find(Book.class, 3);
                    if(findById != null){
                        System.out.println(findById);
                    } else {
                        System.out.println("id가 3인 도서는 없습니다.");
                    }
                    break;
                case 5:
                    typedQuery = em.createQuery("select b from Book b where b.title like :title", Book.class);
                    if(random.nextBoolean()){
                        typedQuery.setParameter("title", "%자바%");

                    } else {
                        typedQuery.setParameter("title", "%스프링%");
                    }
                    bookList = typedQuery.getResultList();
                    for (Book b : bookList){
                        System.out.println(b);
                    }
                    break;
                case 6:
                    query = em.createQuery("select b.kind, sum(b.price) from Book b group by b.kind");
                    objects = query.getResultList();
                    for(Object[] o : objects){
                        System.out.println("분류코드 " + o[0] +"의 가격 총합"+ ": "+ o[1]);
                    }
                    break;
                case 7:
                    System.out.println("프로그램을 종료합니다.");
                    break label;
                default:
                    System.out.println("1~7 사이의 정수를 입력하세요\n");
                    continue;
            }
            System.out.println();
        }

        /* 엔티티매니저 -> 작업이 완료되면 반드시 닫아야 함 */
        sc.close();
        em.close();
        factory.close();
    }
}
