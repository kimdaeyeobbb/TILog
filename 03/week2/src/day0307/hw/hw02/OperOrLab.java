package day0307.hw.hw02;

public class OperOrLab {
    public static void main(String[] args) {
        int grade = (int)(Math.random()*6)+1;
//        System.out.println(grade);
        if (grade == 1 || grade == 2 || grade == 3){
            System.out.printf("%d 학년은 저학년입니다.", grade);
        } else if (grade == 4 || grade == 5 || grade == 6){
            System.out.printf("%d 학년은 고학년입니다.", grade);
        }
    }
}
