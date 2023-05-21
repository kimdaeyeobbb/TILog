package springrest.exam.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springrest.exam.domain.Person;
import springrest.exam.domain.User;
import springrest.exam.exception.UserNotFoundException;
import springrest.exam.service.UserDaoService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController2 {
    private UserDaoService service;
    public UserController2(UserDaoService service){
        this.service=service;
    }

    @GetMapping("/h_users")
    public CollectionModel<User> retrieveAllUsers(){  // 유저 객체를 도메인으로 보관하는 컬렉션 모델
        List<User> list = service.findAll(); // 서비스 객체가 처믕 메모리에 로딩할떄 유저 객체를 미리 생성해놓고 사용할 수 있도록 함
        String[] images = {"dooly.jpg", "ddochi.jpg", "dauner.png"};
        for(int i=0; i < images.length; i++)
            list.get(i).add(Link.of("http://localhost:8088/images/"+images[i]));
        // 각 유저 객체마다 add해서 넣어주고 있음
        // 유저 객체가 add가 가능하다? -> 유저 객체가 representationModel을 상속하고 있기 때문에 가능한 것
        // User가 RepresentationModel<User>를 상속하므로 컬렉션 모델에서 편하게 데이터를 구성할 수 있음
        // 하지만 상속하더라도 User객체로서 기본기능은 동일하다

        CollectionModel<User> result = CollectionModel.of(list);
        return result;
    }

    /* 객체 생성을 또하게 되므로 위 처럼 수정해야함 */
//
//    @GetMapping("/h_users/{id}")
//    public EntityModel<User> retrieveUser(@PathVariable  int id){
//
//
//        User user = service.findOne(id);
//
//        if(user==null){
//            throw new UserNotFoundException(String.format("ID[%s] not found", id));
//        }
//        EntityModel<User> model = EntityModel.of(user);
//        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
//        model.add(linkTo.withRel("all-users"));
//        return model;
//    }


    @GetMapping("/h_users/{id}")
    public User retrieveUser(@PathVariable  int id){  // User 객체가 모델 객체가 될 수 있으므로 이렇게 수정할 것
        User user = service.findOne(id);

        if(user==null){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        user.add(linkTo.withRel("all-users-new"));
        return user;
    }



    @PostMapping("/h_users")
    public User createUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveUser(user.getId()));
        savedUser.add(linkTo.withRel("save_user"));  // save_user라는 이름으로 새로 입력된 데이터에 대한 링크가 제시됨
        return savedUser;
    }


    // Person이 represetationModel을 상속하고 있으므로 여기서는 엔티티 모델을 쓸 필요가 없다
    @GetMapping("/hateoastest1")
    public ResponseEntity<EntityModel<Person>> hateoasTest1() {
        Person p = new Person("길동", "고");
        EntityModel<Person> model = EntityModel.of(p)
                .add(linkTo(methodOn(getClass()).hateoasTest1()).withSelfRel())
                .add(linkTo(methodOn(UserController.class).retrieveAllUsers()).withRel("test1"))
                .add(Link.of("http://localhost:8088/ajaxHome", "test2"))
                .add(linkTo(methodOn(UserController.class).retrieveUser(2)).withRel("test3"));
        return ResponseEntity.ok().body(model);
    }
}
