package day0313.course;

class Student4 {
    /* 멤버 변수 */
    String name;
    int age;
    String subject;

    Student4(){
        this("듀크", 28, "스프링");  // this는 메서드.
        System.out.printf("호출");
    }

    Student4(String name, int age, String subject){
//        name = name;  // 가까운것이 우선임. 매개변수의 name에 name을 넣는것. 자기자신에게 갑읏 다시 넣는것임. 그러므로 의미가 없다.
        this.name = name;
        this.age = age;
        this.subject = subject;
    }

    void printStudentInfo(){
        System.out.printf("%s학생의 나이는 %d입니다.\n", name, age);
    }

    void study(){
        System.out.printf("%s학생은 %s과목을 학습합니다.\n" , name, subject);
    }

    void setSubject(String subject){
        this.subject = subject;  // 전달된 subject 의 정보로 현재 subject을 바꿔라.
    }
}

public class StudentTest4 {
    public static void main(String[] args) {
        /* 객체 생성 */
        Student4[] st = new Student4[4];
        st[0] = new Student4("둘리", 10, "HTML5");
        st[1] = new Student4("또치", 10, "CSS3");
        st[2] = new Student4("도우너", 10, "JavaScript");
        st[3] = new Student4();

        for (Student4 obj: st){
            System.out.println(obj);
            obj.printStudentInfo();
            obj.study();
        }

        st[3].setSubject("JPA");
        st[3].study();
    }
}