package springrest.exam.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

// 유저 객체 안에는 데이터가 5개 (id, name, ...) -> 얘네를 JSON으로 바꿔서 클라이언트에게 서비스할 때 password, ssn필드는 제외하라는 것
@JsonIgnoreProperties(value={"password","ssn"}) //클래스 블록에 추가
public class User extends RepresentationModel<User> {  // User가 RepresentationModel<User>를 상속하므로 컬렉션 모델에서 편하게 데이터를 구성할 수 있음
    private Integer id;

    // min=2 -> 이름을 1글자 입력하면 validation에서 처리되므로  message = "이름은 2글자 이상 입력해주세요." 클라이언트에게 가 응답됨
    @Size(min=2, message = "이름은 2글자 이상 입력해주세요.")
    private String name;


    // 현재를 기준으로 하여 과거 시간만 입력할 수 있음
    // 과거 시간 이외의 시간을 입력하면  message = "과거 시간을 입력해주세요."가 클라이언트에게 응답됨
    @Past(message = "과거 시간을 입력해주세요.")
    private Date joinDate;

    private String password;
    private String ssn;
}
