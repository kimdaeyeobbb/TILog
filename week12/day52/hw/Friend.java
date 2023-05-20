package springrest.exam.entity;

// 어노테이션이 스프링 부트에 의해 처리가 되도록 스프링 부트 앱이 기동될떄 이 패키지 폴더를 스캔하도록 패키지 폴더 정보를 추가해주어야 함

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Friend {
    @Id  // entity의 Primary Key를 지정하는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // GeneratedValue -> PK에 대한 생성 전략을 지정하는 어노테이션. id 어노테이션과 함꼐 엔티티의 PK에 적용될 수 있음
    // GenerationType.IDENTITY -> DB상 ID칼럼을 사용해서 엔티티에 기본 키를 지정해야함을 뜻함
    private int id;

    private String fname;

    private Integer fage;

    @Builder  // 직접 객체 생성할 일이 있으면 builder.id.get~꼴로 사용할 수 있게 만듦
    public Friend(int id, String fname, Integer fage){
        this.id = id;
        this.fname = fname;
        this.fage = fage;
        System.out.println("@Builder가 설정된 생성자 호출");
    }
}