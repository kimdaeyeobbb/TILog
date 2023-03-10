package day0310.hw01;

import java.text.DecimalFormat;

public class MethodLab1 {
    public static void main(String[] args) {
        System.out.printf("우리 자바교재명은 <");
        printTitle();
        System.out.printf(">입니다.\n");

        /* 금액 변환 */
        int howMuch = getPrice();
        DecimalFormat dc = new DecimalFormat("##,###");
        String ch = dc.format(howMuch);
        System.out.printf("\t가격은 %s원입니다.",ch);
    }
    static void printTitle(){
        System.out.print("이것이 자바다");
        return;
    }

    static int getPrice(){
        return 36000;
    }
}
