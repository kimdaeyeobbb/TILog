package springrest.exam.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.PagedModel.PageMetadata;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springrest.exam.domain.PersonModel;
import springrest.exam.domain.Person;
@RestController
public class RepresentationModelController {
    @GetMapping("/representation")
    public PersonModel representation()
    {
        PersonModel model = new PersonModel();  // 해당 도메인 객체뿐만 아니라 링크까지 추가하도록 처리
        model.setFirstName("길동");
        model.setLastName("고");
        model.add(Link.of("http://localhost:8088/entity"));
        model.add(Link.of("http://localhost:8088/collection"));

        return model;
    }

    @GetMapping("/entity")
    public EntityModel<Person> entity()
    {
        // Person은 도메인 객체이므로 링크정보를 add 할 수 없다 -> 따라서 엔티티 모델을 같이 사용해야한다.
        // -> 도메인 클래스 만들때 representationaMOdel을 상속하는게 나을것이다!
        // 여기서는 위와 달리 representational~을 상속하지 않으므로 EntityModel을 엔티티객체 생성해서 사용하여야 함
        Person person = new Person("길동", "고");
        EntityModel<Person> model = EntityModel.of(person);
        model.add(Link.of("http://localhost:8088/entity"));
        Link link = Link.of("http://localhost:8088/representation", IanaLinkRelations.NEXT);
        model.add(link.withRel("next"));

        return model;
    }

    @GetMapping("/collection1")
    public CollectionModel<Person> collection1()
    {
        Collection<Person> people = new java.util.ArrayList<>();
        people.add(new Person("길동", "고"));
        people.add(new Person("이콜", "마"));
        CollectionModel<Person> model = CollectionModel.of(people);

        Link oriLink = Link.of("http://localhost:8088/collection");
        Link firstLink = Link.of("http://localhost:8088/representation");
        Link secondLink = Link.of("http://localhost:8088/ajaxHome");
        model.add(oriLink.withSelfRel());
        model.add(firstLink.withRel("repre"));
        model.add(secondLink.withRel("ajax"));

        return model;
    }

    @GetMapping("/collection2")
    public ResponseEntity<List<PersonModel>> collection2()
    {
        List<PersonModel> list = new java.util.ArrayList<>();
        PersonModel pm1 = new PersonModel("길동", "고");   // 고길동과 마이콜에 대한 모델객체를 따로 생성 -> 한 덩어리의 응답이 올떄 한덩어리의 array가 됨
        PersonModel pm2 = new PersonModel("이콜", "마");
        pm1.add(Link.of("http://localhost:8088/entity"));
        pm2.add(Link.of("http://localhost:8088/representation", IanaLinkRelations.NEXT));
        list.add(pm1);
        list.add(pm2);
        return ResponseEntity.ok().body(list);
    }
}
