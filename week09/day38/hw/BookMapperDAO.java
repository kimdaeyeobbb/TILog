package com.example.springedu.dao;

import com.example.springedu.domain.BookDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface BookMapperDAO {

    /* 1. 모두 출력하기 */
    @Select("select * from book")
    public List<BookDTO> b1();


    /* 2. 가격이 높은 순으로 출력하기 */
    @Select("select id, title, price, kind from book order by price desc")
    public List<BookDTO> b2();


    /* 3. 가격이 2만원 이상인 도서 출력하기 */
    @Select("select id, title, price, kind from book where price >= 20000")
    public List<BookDTO> b3();

    /* 4. 웹 프로그래밍 도서들만 출력하기 *///    }
    @Select("select id, title, price, kind from book where kind like '%b02%'")
    public List<BookDTO> b4();

    /* 5. 데이터베이스와 인프라 도서들만 출력하기 */
    @Select("select id,title,price,kind from book where kind = \"b04\" or \"b05\"")
    public List<BookDTO> b5();

    /* 6. 도서명에 어떤 단어를 포함하는 도서들만 출력하기 => 동적 파라미터 사용 */
    @Select("select id, title, price, kind from book where title like concat('%',#{title},'%')")
    public List<BookDTO> b6(String title);

    /* 7. 분류별 도서 가격의 평균을 출력하기 */
    @Select("select TRUNCATE(avg(price),0) as price, kind from book group by kind")
    public List<BookDTO> b8();

    /* INSERT 추가 구현 */
    @Insert("insert into book(title, price, kind) values (#{title}, #{price}, #{kind})")
    public boolean insert(BookDTO bookDTO);
}

