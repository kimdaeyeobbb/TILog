package com.example.springnews.repository;

import com.example.springnews.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NewsRepository extends JpaRepository<News, Integer> {
    // Integer -> 식별자값이 null일수도 있기 때문에 사용함.
    // null 식별자를 가지는 엔티티는 새로 생성된 엔티티로 간주됨
   // News 엔티티의 ID필드를 Integer 타입으로 선언한 것

    /* 뉴스글 작성 */
    // JpaRepository의 save()를 상속받아서 사용
    // 엔티티의 객체를 인자로 받아서 해당 엔티티를 데이터베이스에 저장하거나 업데이트 함
    // save()메서드 반환 타입 - 저장된 엔티티 or 업데이트된 엔티티를 반환

    /* 뉴스글 전체 읽기 */
    // JpaRepository의 findAll() 메서드를 상속 받아서 사용
    // DB에 저장된 모든 엔티티를 조회
    // 호출시 DB의 해당 엔티티 테이블의 모든 레코드를 검색 -> 검색된 각 레코드를 엔티티 객체로 변환하여 컬렉션에 추가 -> 변환된 엔티티의 컬렉션을 반환

    /* Id로 글 한개 읽기 */
//    public News findById(int id);

    /* 뉴스글 삭제 */
//    public void deleteById(int id);

    /* 뉴스글 변경 */
    // JpaRepository의 save()를 상속받아서 사용

    /* 뉴스글 내용에서 검색 */
    public List<News> findByContentContains(String keyword);

    /* 작성자 명으로 검색 */
    public List<News> findByWriter(String writer);

    /* id로 글 한개를 읽은 경우 cnt 변경 */
//    public void updateCntById(int id, int cnt);
}