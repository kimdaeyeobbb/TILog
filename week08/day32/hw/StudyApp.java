package week08.day32.hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudyApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        System.out.println("*********** 스프링 컨테이너(IoC 컨테이너) 초기화 작업 끝 **********\n");


        Student info = (Student)context.getBean("st1");
        System.out.println(info.getName()+"는 "+ info.getMyHomework().getHomeworkName()+"를 학습합니다.");

        info = (Student)context.getBean("st2");
        System.out.println(info.getName()+"는 "+ info.getMyHomework().getHomeworkName()+"를 학습합니다.");

        info = (Student)context.getBean("st3");
        System.out.println(info.getName()+"는 "+ info.getMyHomework().getHomeworkName()+"를 학습합니다.");

        ((ClassPathXmlApplicationContext)context).close();
    }
}
