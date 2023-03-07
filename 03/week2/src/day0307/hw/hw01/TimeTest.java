package day0307.hw01;

public class TimeTest {
    public static void main(String[] args) {
        int time = 32150;
        int hour = time/3600;
        int minute = (time-hour*3600)/60;
        int second = time-hour*3600-minute*60;
        System.out.printf("%d시간 %d분 %d초", hour,minute, second);
    }
}
