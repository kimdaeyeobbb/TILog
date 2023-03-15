package day0315.course;

public class Member {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* 멤버변수 선언 */
    private String name;
    private int age;

    // getter : 현재의 값을 읽어 감. 매개변수 생략. 리턴값의 유형은
    // 멤버변수가 10개면 getter, setter도 각각 10개씩 존재 (읽어가는 기능만 필요한 경우 getter만 만들어도 됨)
    // 추상메서드를 Ltab, Otab 모두에서 상속받아서 오버라이딩 할 것

}
