package day0313.course.hw02;

import java.util.Scanner;

class GradeExpr{
    private int jumsu[];

    GradeExpr(int jumsu[]){
        this.jumsu = jumsu;
//        System.out.println("클래스 내부의 점수 : "+jumsu);
    }

    double getAverage(){
        return (double) getTotal()/jumsu.length;
    }

    int getTotal(){
        int sum = 0;
        for (int i=0; i<jumsu.length; i++){
            sum += jumsu[i];
        }
        return sum;
    }

    int getGoodScore(){
        int good = 0;
        for (int i=0; i< jumsu.length; i++){
            if (good<jumsu[i]){
                good = jumsu[i];
            }
        }
        return good;
    }

    int getBadScore(){
        int bad = 999;
        for (int i=0; i< jumsu.length; i++){
            if (bad>jumsu[i]){
                bad = jumsu[i];
            }
        }
        return bad;
    }
}

public class GradeTest {
    public static void main(String[] args) {
        System.out.print("점수들 : ");
        Scanner sc = new Scanner(System.in);
        int score1, score2, score3, score4;

        score1 = sc.nextInt();
        score2 = sc.nextInt();
        score3 = sc.nextInt();
        score4 = sc.nextInt();

        GradeExpr[] ge = new GradeExpr[4];
        ge[0] = new GradeExpr(new int[]{score1,score2,score3,score4});
        System.out.println("총점 : "+ge[0].getTotal());
        System.out.println("평균 : "+ge[0].getAverage());
        System.out.println("최고 점수 : " +ge[0].getGoodScore());
        System.out.println("최저 점수 : " +ge[0].getBadScore());
    }
}
