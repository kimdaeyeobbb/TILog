package springrest.exam.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Message {
    private String message1;
    private String message2;
    private String message3;
    @Builder  // lombok이 제공. 이 사양에 맞춰서 빌드 기능의 메서드를 자동으로 추가해달라는 것.ㅐ
    // 객체 생성시 그 클래스가 가진 팩토리 메서드로
    public Message(String msg1, String msg2, String msg3) {
        this.message1 = msg1;
        this.message2 = msg2;
        this.message3 = msg3;
        System.out.println("@Builder 가 설정된 생성자 호출");
    }
}
