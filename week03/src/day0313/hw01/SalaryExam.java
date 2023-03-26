package day0313.hw01;

import day0310.hw01.MethodLab5;

class SalaryExpr {
    int bonus;

    SalaryExpr(){
        bonus = 0;
    }

    SalaryExpr(int bonus){
        this.bonus = bonus;
    }

    int getSalary(int grade){
        switch (grade){
            case 1:
                bonus += 100;
                break;
            case 2:
                bonus += 90;
                break;
            case 3:
                bonus += 80;
                break;
            case 4:
                bonus += 70;
                break;
            default:
                break;
        }
        return bonus;
    }
}

public class SalaryExam {
    public static void main(String[] args) {
        int month = MethodLab5.getRandom(12);
        int grade = MethodLab5.getRandom(4);

        if (month%2 == 0){
            SalaryExpr se = new SalaryExpr(100);
            System.out.printf("%d월 %d등급의 월급은 %d입니다.\n", month, grade, se.getSalary(grade));
        } else {
            SalaryExpr se = new SalaryExpr();
            System.out.printf("%d월 %d등급의 월급은 %d입니다.\n", month, grade, se.getSalary(grade));

        }
    }
}
