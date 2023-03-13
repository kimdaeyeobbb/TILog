package day0313.course;

class Student3 {
    /* 멤버 변수 */
    String name;
    int age;
    String subject;

    // 생성자 - 인자를 전달하지 않아도 되는 놈 생성
    Student3(){
        name = "듀크";  // this.name = "듀크"도 가능. this를 안써도 될때에는 생략하는게 좋다
        age = 28;
        subject = "스프링";
    }

    Student3(String name, int age, String subject){
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
}

public class StudentTest3 {
    public static void main(String[] args) {
        /* 객체 생성 */
        Student3 st1 = new Student3("뚤리", 10, "HTML5");
        Student3 st2 = new Student3("또치",  10, "CSS3");
        Student3 st3 = new Student3();

        System.out.println("st1이 참조하는 객체정보: "+st1);
        System.out.println("st2가 참조하는 객체정보: "+st2);
        System.out.println("st3가 참조하는 객체정보: "+st3);

        st1.printStudentInfo();
        st1.study();

        st2.printStudentInfo();
        st2.study();

        st3.printStudentInfo();
        st3.study();

    }
}
