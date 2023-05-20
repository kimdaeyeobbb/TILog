package com.example.springedu2;


// 새로운 엔티티 클래스가 등장하면 스프링 부트가 새로운 엔티티 클래스를 가지고 디비 테이블을 만들도록 하려면 application.properties를 수정해야함

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import springrest.exam.entity.Friend;
import springrest.exam.repository.FriendRepository;

import java.util.List;
import java.util.Optional;

@SpringBootTest   // 스프링 부트 테스트를 위한 환경을 구성함. 스프링 애플리케이션 컨텍스트를 로드하고 테스르를 실행하기 위해 사용됨.
public class FriendTest {

    @Autowired
    // friendRepository 빈은 주입받기 위한 의존성 주입 어노테이션
    // 스프링에 의해 만들어진 자바객체(bean)를 자동으로 주입시켜줌.
    // User entity로 CRUD가 가능해진 인터페이스의 객체(bean)를 주입시킴
    private FriendRepository friendRepository;
    @Test  // 테스트 메서드임을 선언하는 어노테이션
    @Transactional  // 테스트 메서드가 트랜잭션 내에서 실행되도록 지정함. 테스트 메서드의 실행 전후에 롤백되어 이전 상태로 되돌아감.
//    @Rollback(value = false) // create하고나서는 주석 처리
    public void createTest(){
        Friend friend1 = new Friend();
        friend1.setFname("고길동");
        friend1.setFage(40);

        Friend friend2 = new Friend();
        friend2.setFname("둘리");
        friend2.setFage(10);

        Friend friend3 = Friend.builder().fname("또치").fage(9).build();

        System.out.println("friedn1 : " + friend1);
        System.out.println("friedn2 : " + friend2);
        System.out.println("friedn3 : " + friend3);

        friendRepository.save(friend1);
        friendRepository.save(friend2);
        friendRepository.save(friend3);
    }

    @Test
    //@Transactional
    public void readTest(){
//        List<Friend> friendList = friendRepository.findAll();
//        friendList.stream().forEach(System.out::println);
        Optional<Friend> friend = friendRepository.findById(13);
        friend.ifPresent(selectedFriend -> System.out.println("선택된 친구: "+selectedFriend));
    }

    @Test
    @Transactional
    public void updateTest(){
        Optional<Friend> friend = friendRepository.findById(13);
        friend.ifPresent(selectedFriend -> {
            selectedFriend.setFname("고길동변화후");
            selectedFriend.setFage(25);
            friendRepository.save(selectedFriend);
            System.out.println("업데이트한 고길동: " +selectedFriend);
        });
        System.out.println("friend 업데이트: " +friend);
    }

    @Test
    @Transactional
    public void deleteTest(){
        Optional<Friend> friend = friendRepository.findById(13);
        friend.ifPresent(selectedFriend -> friendRepository.delete(selectedFriend));
//        System.out.println("삭제후 friend: "+ friend);
        List<Friend> friendList = friendRepository.findAll();
        friendList.stream().forEach(System.out::println);
    }
}