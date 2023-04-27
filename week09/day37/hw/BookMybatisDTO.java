package com.example.springedu.dao;

import com.example.springedu.domain.BookDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  // 퍼시스턴트 레이어 -> DB나 파일같은 외부 I/O작업 처리
public class BookMybatisDAO {

    /* 1. 모두 출력하기 */
    @Autowired
    SqlSession session;
    public List<BookDTO> b1() {
        List<BookDTO>list = null;
        try{
            String statement = "lab1.exam1";
            list = session.selectList(statement);
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /* 2. 가격이 높은 순으로 출력하기 */
    public List<BookDTO> b2(){
        List<BookDTO> list = null;
        try{
            String statement = "lab1.exam2";
            list = session.selectList(statement);
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /* 3. 가격이 2만원 이상인 도서 출력하기 */
    public List<BookDTO> b3(){
        List<BookDTO> list = null;
        try{
            String statement = "lab1.exam3";
            list = session.selectList(statement);
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /* 4. 웹 프로그래밍 도서들만 출력하기 */
    public List<BookDTO> b4(){
        List<BookDTO> list = null;
        try{
            String statement = "lab1.exam4";
            list = session.selectList(statement);
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /* 5. 데이터베이스와 인프라 도서들만 출력하기 */
    public List<BookDTO> b5(){
        List<BookDTO> list = null;
        try{
            String statement = "lab1.exam5";
            list = session.selectList(statement);
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /* 6. 도서명에 어떤 단어를 포함하는 도서들만 출력하기 => 동적 파라미터 사용 */
    public List<BookDTO> b6(){
        List<BookDTO> list = null;
        try{
            String statement = "lab1.exam6";
            list = session.selectList(statement,"자바");
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<BookDTO> b7(){
        List<BookDTO> list = null;
        try{
            String statement = "lab1.exam6";
            list = session.selectList(statement,"스프링");
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /* 7. 분류별 도서 가격의 평균을 출력하기 */
    public List<BookDTO> b8(){
        List<BookDTO> list = null;
        try{
            String statement = "lab1.exam7";
            list = session.selectList(statement);
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
