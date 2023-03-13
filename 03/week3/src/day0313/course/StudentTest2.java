package day0313.course;

// Student는 public class일 수 없음 (퍼블릭은 접근제어잦. 이렇게되면 누구나 얘를 가져다 쓸 수 있게 되는것)
// 중요한 것은 public class는 클래스명과 솟스명이 동일해야 함
class Student2 {
    /* 멤버 변수 */
    String name;
    int age;
    String subject;


    void printStudentInfo(){
        System.out.printf("%s학생의 나이는 %d입니다.\n", name, age);
    }

    void study(){
        System.out.printf("%s학생은 %s과목을 학습합니다.\n" , name, subject);
    }
}

public class StudentTest2 {
    public static void main(String[] args) {
        /* 객체 생성 */
        Student st1 = new Student();
        Student st2 = new Student();

        System.out.println("st1이 참조하는 객체정보: "+st1);
        System.out.println("st2가 참조하는 객체정보: "+st2);

        st1.printStudentInfo();
        st1.study();

        st1.name = "둘리";
        st1.age = 10;
        st1.subject = "HTML5";

        st1.printStudentInfo();
        st1.study();

        st2.name = "또치";
        st2.age = 10;
        st2.subject = "CSS3";

        st2.printStudentInfo();
        st2.study();

        st2 = st1;  // 둘다 둘리 객체를 참조하게 됨
        System.out.println("st1이 참조하는 객체정보: "+st1);
        System.out.println("st2가 참조하는 객체정보: "+st2);
    }
}
