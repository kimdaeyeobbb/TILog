package day12.course;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StandardInput3 {
    public static void main(String[] args) throws Exception{
        System.out.print("입력 : ");
        InputStreamReader isr = new InputStreamReader(System.in);
        // 바이트스트림을 문자스트림으로 바꿔줌
        // System.in : 바이트 스트림 객체 (표준 출력 장치를 가리키게 끔 자바 프로그램이 시작할 때 자동으로 초기화되는 객체)

        BufferedReader br = new BufferedReader(isr);
        String str = br.readLine();
        // readline: 사용자가 입력한 한 행을 읽어들임

        System.out.println("입력된 문자 : " + str);
    }
}