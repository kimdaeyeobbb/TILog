package week08.day33.hw;

import org.springframework.stereotype.Component;

@Component("afternoonGreeting")
public class AfternoonGreetingImpl implements Greeting {
    @Override
    public void greet() {
        System.out.println("즐거운 오후되세요.");
    }
}
