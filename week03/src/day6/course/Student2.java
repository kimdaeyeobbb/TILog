package day6.course;

import java.io.Serializable;

public class Student2 implements Serializable {
    private static final long serialVersionUID = 1L;
    // 시리얼 버전 uid가 일치하면 멤버변수 사양이 맞기 않더라도 일치하는 애들은 넣어주기 위한 것.
    // 작렬화해서 저장할 떄의 클래스 멤버와 저장된걸 꺼내서 가져올 떄의 클래스 멤버가 같기만 하면 됨.

    /* 멤버 변수 */
    String name;
    int age;
    String subject;

    public Student2(String name, int age, String subject){
        this.name = name;
        this.age = age;
        this.subject = subject;
    }

    public void printStudentInfo(){
        System.out.printf("%s학생의 나이는 %d입니다.\n", name, age);
    }

    public void study(){
        System.out.printf("%s학생은 %s과목을 학습합니다.\n" , name, subject);
    }
}