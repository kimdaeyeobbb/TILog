package week08.day33.hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;

public class GreetingTest {
    public static void main(String[] args) {
        /* ApplicationContext 객체 생성 => 스프링 컨테이너 초기화 */
        ApplicationContext context = new ClassPathXmlApplicationContext("exam3.xml");
        System.out.println("********* 스프링 컨테이너 초기화 작업 종료 **********");

        Greeting GreetingBean;

        LocalDateTime checkTime = (LocalDateTime) context.getBean("localDateTime");

        int nowTime = checkTime.getHour();
        System.out.println("지금시간 : "+nowTime);

        if (nowTime>=6 && nowTime <12){
            GreetingBean = (Greeting) context.getBean("morningGreeting", MorningGreetingImpl.class);
        } else if(nowTime >=12 && nowTime < 17){
            GreetingBean = (Greeting) context.getBean("afternoonGreeting", AfternoonGreetingImpl.class);
        } else if (nowTime >= 17 && nowTime < 22){
            GreetingBean = (Greeting) context.getBean("eveningGreeting", EveningGreetingImpl.class);
        } else {
            GreetingBean = (Greeting) context.getBean("nightGreeting", NightGreetingImpl.class);
        }

        GreetingBean.greet();
        ((ClassPathXmlApplicationContext)context).close();
    }
}