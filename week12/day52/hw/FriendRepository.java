package springrest.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springrest.exam.entity.Friend;

import java.util.List;
import java.util.Optional;

public interface FriendRepository extends JpaRepository <Friend, Integer>{
    // 인터페이스에 Friend entity로 CRUD가 가능하도록 만듦

    // JpaRepository -> 기본적인 CRUD가 가능하도록 만들어주는 스프링부트에 제공해주는 인터페이스. entity 클래스와 primary key의 타입이 들어감.
    /* CRUD가 가능해야함 */
    List<Friend> findByFname(String fname);
}
