package springrest.exam.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springrest.exam.domain.User;
import springrest.exam.exception.UserNotFoundException;
import springrest.exam.service.UserDaoService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private UserDaoService service;
    public UserController(UserDaoService service){
        this.service=service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable  int id){
        User user = service.findOne(id);
        if(user==null){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
        return user;
    }

    @PostMapping("/users")  // post 방식일 경우에 @Valid @RequestBody가 정의되어있음
    // @Valid -> validation체크할게 있다는 뜻. 얘가 없으면 validation check를 수행하지 않음
    public void createUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = service.deleteById(id);  // 아이디에 해당되는 데이터를 삭제. 삭제된 객체가 리턴되도록 함.

        if(user==null){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
            // 예외 발생시켜서 문제가 있다는 것을 알림
            // Exception 패키지를 살펴볼 것
        }
    }
}
