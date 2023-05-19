package com.example.springedu2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import springrest.exam.domain.Message;

@SpringBootTest
public class MessageTest {

    @Test
    public void test(){
        Message m1 = new Message("aa", "bb", "cc");
        System.out.println(m1);

        Message m2 = new Message();
        System.out.println(m2);

//        Message m3 = new Message("aa", "bb");
        Message m3 = new Message("aa", "bb", null);
        Message m4 = Message.builder().msg1("aa").msg2("bb").build();
        // 전달하고자하는 인자에 해당되는 메서드만 호출하여 값을 생성할 수 있음.

//        Message.  // . 뒤에 오는것 직접 홗인. build는 lombok이 제공

        System.out.println(m4);
    }
}
