package day0321.course;

import java.io.InputStreamReader;

public class StandardInput2 {
    public static void main(String[] args) throws Exception{
        System.out.print("입력 : ");
        InputStreamReader isr = new InputStreamReader(System.in);
        // 바이트스트림을 문자스트림으로 바꿔줌
        // System.in : 바이트 스트림 객체

        char munja = (char) isr.read();
        System.out.println("입력된 문자 : " + munja);
    }
}