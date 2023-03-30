package day6.hw;

class Member{
    /* 멤버변수 */
    String name;   // 이름
    String account;   // 계정
    String passwd;   // 암호
    int birthyear;   // 생년

    void printMemberInfo(){
        System.out.printf("%s(%s,%s,%d)\n", name,account,passwd,birthyear);
    }
}

public class MemberTest {
    public static void main(String[] args) {
        Member memb1 = new Member();
        Member memb2 = new Member();
        Member memb3 = new Member();

        memb1.name = "김나라";
        memb1.account = "kim1";
        memb1.passwd = "1234";
        memb1.birthyear = 19941201;

        memb2.name = "이나라";
        memb2.account = "lee1";
        memb2.passwd = "1234";
        memb2.birthyear = 19961103;

        memb3.name = "박나라";
        memb3.account = "park1";
        memb3.passwd = "1234";
        memb3.birthyear = 19991201;

        System.out.print("회원1 :");
        memb1.printMemberInfo();

        System.out.print("회원2 :");
        memb2.printMemberInfo();

        System.out.print("회원3 :");
        memb3.printMemberInfo();
    }
}
