package springrest.exam.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springrest.exam.entity.Friend;
import springrest.exam.repository.FriendRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j   // 로깅을 위해 lombok을 사용하겠다는 것
@RestController  // 이 클래스가 RESTful API를 처리하는 컨트롤러임을 뜻함
@RequestMapping("/friends")   // /friend 경로로 들어오는 요청을 이 컨트롤러가 처리한다는 것을 뜻함
@RequiredArgsConstructor
public class FriendController {   // /friend 경로에 대한 API를 제공하는 컨트롤러
    // 각 메서드는 요구사항에 맞게 HTTP 요청을 처리하고, 적절한 상태 코드와 함께 응답을 반환함
    @Autowired
    private FriendRepository friendRepository;

    /* GET - 친구 데이터의 전체 리스트를 JSON 형식으로 리턴하는 메서드를 구현 */
    @GetMapping
    public ResponseEntity<List<Friend>> getAllFriends(){
        // ResponseEntity: 스프링 프레임워크에서 HTTP 응답을 나타내는 클래스, 클라이언트에게 전송할 응답 데이터와 응답 상태 코드를 포함

        List<Friend> friendList = friendRepository.findAll();
        ResponseEntity<List<Friend>> entity = new ResponseEntity<>(friendList, HttpStatus.OK);
        // ResponseEntity 객체 생성시 응답으로 전달할 데이터와 해당 데이터의 상태 코드를 지정함
        // friendList: 응답으로 전송할 친구 데이터 리스트
        // HttpStatus.OK : 응답의 상태코드. HttpStatus.OK는 HTTP 200 OK를 뜻함.

        return entity;
        // 엔티티 객체는 해당 응답을 클라이언트에게 반환함
    }

    @GetMapping("/id/{id}")
    // URI를 이용해서 파라미터를 처리
    //   /friend/{id}로 GET 요청이 들어오면 그 id에 해당하는 친구 데이터를 JSON 형식으로 반환함
    public ResponseEntity getFriendById(@PathVariable int id){
        Optional<Friend> friend = friendRepository.findById(id);
        ResponseEntity entity;
        if (friend.isPresent()) {
            entity = new ResponseEntity<>(friend.get(), HttpStatus.OK);
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("BAD_ID",  id+"");
            entity = new ResponseEntity(headers, HttpStatus.NOT_FOUND);
        }
        return entity;
    }

    @GetMapping("/name/{name}")
    public ResponseEntity getFriendByName(@PathVariable String name) {
        List<Friend>  friend = friendRepository.findByFname(name);
        System.out.println("친구이름으로 정보 찾기: "+friend);
        ResponseEntity entity;
        if(!friend.isEmpty()){
            entity = new ResponseEntity<>(friend, HttpStatus.OK);
            System.out.println("친구 이름이 있을 때의 entity: "+entity);
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("BAD_NAME",  name);
            entity = new ResponseEntity(headers, HttpStatus.NOT_FOUND);
            System.out.println("친구 이름이 없을 떄의 엔티티: "+entity);
        }
        return entity;
    }

    @PostMapping
    @Transactional
    public ResponseEntity createFriend(@RequestBody Friend jsonFriend) {
        try{
            friendRepository.save(jsonFriend);
            return ResponseEntity.status(HttpStatus.CREATED).body("성공적으로 생성하였습니다.");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("생성에 실패하였습니다");
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateFriend(@RequestBody Friend jsonFriend) {
     Optional <Friend> friend =  friendRepository.findById(jsonFriend.getId());  // 해당 아이디에 대한 정보를 friend 객체에 넣음
     if(friend.isPresent()){
        friend.get().setFname(jsonFriend.getFname());
        friend.get().setFage(jsonFriend.getFage());
        return ResponseEntity.status(HttpStatus.RESET_CONTENT).body("수정에 성공했습니다");
     }else {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("수정에 실패하였습니다");
     }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFriend(@PathVariable int id) {
        Optional<Friend> friend = friendRepository.findById(id);
        if (friend.isPresent()) {
            friendRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.RESET_CONTENT).body("성공적으로 삭제했습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("삭제에 실패했습니다.");
        }
    }
}