package day6.hw;

import java.util.Scanner;

class CalculatorExpr{
    private int num1;
    private int num2;

    CalculatorExpr(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    int getAddition(){
        return num1+num2;
    }

    int getSubtraction(){
        if(num1>=num2){
            return num1-num2;
        } else {
            return num2-num1;
        }
    }

    int getMultiplication(){
        return num1*num2;
    }

    double getDivision(){
        double result;
        if (num1 == 0){
            result = (double) num1/num2;
        } else if (num2 == 0){
            result = (double) num2/num1;
        } else {
            result = (double) num1/num2;
        }
        return result;
    }
}

public class CalculatorTest {
    public static void main(String[] args) {

        int beingPlay = 1;
        while (beingPlay != 0){
            Scanner sc = new Scanner(System.in);
            System.out.print("입력된 숫자 : ");
            int number1 = sc.nextInt();
            int number2 = sc.nextInt();
            if (beingPlay == 0){
                break;
            } else {
                CalculatorExpr ce = new CalculatorExpr(number1,number2);
                System.out.println("덧셈 : " +ce.getAddition());
                System.out.println("뺄셈 : " +ce.getSubtraction());
                System.out.println("곱셈 : " +ce.getMultiplication());
                System.out.println("나눗셈 : " +ce.getDivision());
            }
            System.out.print("계속 하시곘습니까? (종료 하며려면 0입력): ");
            beingPlay = sc.nextInt();
        }
    }
}