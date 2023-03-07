package day0307.hw02;

public class OperAndLab {
    public static void main(String[] args) {
        int grade = (int)(Math.random()*6)+1;
//        System.out.println(grade);
        if (1 <= grade && grade <= 3){
            System.out.printf("%d 학년은 저학년입니다.", grade);
        } else if (4 <= grade && grade <= 6){
            System.out.printf("%d 학년은 고학년입니다.", grade);
        }
    }
}
