package com.example.springnews;

import com.example.springnews.repository.NewsRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.example.springnews.model.News;

import java.util.List;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)   // 내장 DB(H2)사용을 제외
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
public class JPA_NewsRepositoryTest {

    @Autowired
    private NewsRepository newsRepository;

    @Test
    void list(){
        List<News> list = newsRepository.findAll();
        // News 테이블의 모든 내용을 가져오라는 것
        // findAll은 리스트 객체를 리턴

        list.stream().forEach(System.out::println);
    }
}
