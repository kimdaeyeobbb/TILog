package springrest.exam.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springrest.exam.domain.ComicActor;
import springrest.exam.domain.ComicActorModel;
import java.util.Arrays;

@RestController
public class HateoasRestController {

    @GetMapping("/all")
    public CollectionModel<ComicActorModel> allActor() {
        ComicActorModel model1 = new ComicActorModel("둘리").add(Link.of("http://localhost:8088/dooly"));

        ComicActorModel model2 = new ComicActorModel();
        model2.setName("또치");
        model2.add(Link.of("http://localhost:8088/ddochi"));

        ComicActorModel model3 = new ComicActorModel();
        model3.setName("도우너");
        model3.add(Link.of("http://localhost:8088/dauner"));

        System.out.println(CollectionModel.of(Arrays.asList(model1, model2, model3)));
        return CollectionModel.of(Arrays.asList(model1, model2, model3));
    }

    @GetMapping("/dooly")
    public ResponseEntity<ComicActor> getDooly(){
        ComicActor dooly = new ComicActor("둘리", "쌍문동", "dooly.jpg");
        return new ResponseEntity<>(dooly, HttpStatus.OK);
    }

    @GetMapping("/ddochi")
    public ResponseEntity<ComicActor> getDdochi() {
        ComicActor ddochi = new ComicActor("또치", "아프리카", "ddochi.jpg");
        return new ResponseEntity<>(ddochi, HttpStatus.OK);
    }
    @GetMapping("/dauner")
    public ResponseEntity<ComicActor> getDauner() {
        ComicActor dauner = new ComicActor("도우너", "깐따삐아", "dauner.png");
        return new ResponseEntity<>(dauner, HttpStatus.OK);
    }

}

