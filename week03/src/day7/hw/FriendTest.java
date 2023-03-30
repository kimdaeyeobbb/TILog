package day7.hw;

class Person{
    private String name;
    Person (String name){
        this.name = name;
    }

    public String getInfo(){
        return name;
    }
}

class Friend extends Person{
    private String phoneNum;
    private String email;

    Friend(String name, String phoneNum, String email){
        super(name);
        this.phoneNum = phoneNum;
        this.email = email;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " " + phoneNum + " " + email;
    }
}

public class FriendTest {
    public static void main(String[] args) {
        Friend fr[] = new Friend[5];  // Friend 클래스 타입의 배열 생성 (Friend 타입의 객체들을 저장)

        // 5개의 Friend 객체 생성
        fr[0] = new Friend("김하나", "010-111-1111", "hana@hanmail.net");
        fr[1] = new Friend("박두리", "010-222-2222", "two@hanmail.net");
        fr[2] = new Friend("이세찌", "010-333-3333", "three@hanmail.net");
        fr[3] = new Friend("정네찌", "010-444-4444", "four@hanmail.net");
        fr[4] = new Friend("송다섯", "010-555-5555", "five@hanmail.net");

        // 각 Friend 객체 정보를 getInfo() 메서드를 호출하여 실행결과와 같이 출력
        System.out.println("이름\t\t전화번호\t\t메일주소");
        for (int i=0; i<fr.length; i++){
            System.out.println(fr[i].getInfo());
        }
    }
}
