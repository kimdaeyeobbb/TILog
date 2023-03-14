package day0314.hw01;
import day0310.hw01.MethodLab5;
//import java.util.Random;

class Multiplication {
    private int dan;
    private int number;
    Multiplication() {}
    Multiplication(int dan) {
        this.dan = dan;
    }
    Multiplication(int dan, int number){
        this.dan = dan;
        this.number = number;
    }
    void printPart() {
        if (number == 0) {
            for(int n=1; n <= 9; n++)
                System.out.print("\t"+dan + "*" + n+ "="+dan*n);
            System.out.println();
        } else {
            System.out.println(dan * number);
        }
    }
}

/* 상속 */
class GuGuDanExpr extends Multiplication{
    GuGuDanExpr(){

    }

    GuGuDanExpr(int dan){
        super(dan);
    }
    GuGuDanExpr(int dan, int number){
        super(dan,number);
    }


    public static void printAll(){
        for (int i=1; i<=9; i++){
            for (int j=1; j<=9; j++){
                System.out.printf("%d * %d = %d  " , i,j, i*j);
            }
            System.out.println();
        }
    }
}


public class GuGuDanApp {
    public static void main(String[] args) {
        // 파란색이 출력결과
//        Random random = new Random();
//        int dan = (random.nextInt(20)+1);
//        int number = (random.nextInt(20)+1);

        int dan = MethodLab5.getRandom(20);
        int number = MethodLab5.getRandom(20);

//        System.out.println(dan);
//        System.out.println(number);

        GuGuDanExpr ggde;

        if (dan<=9){
            if(number <= 9){
//                System.out.println("dan 9이하, number 9이하");
                ggde = new GuGuDanExpr(dan,number);
                System.out.printf("%d * %d = ",dan,number);
                ggde.printPart();
            } else{
//                System.out.println(" dan 9이하, number 10이상");
                ggde = new GuGuDanExpr(dan);
                System.out.printf("%d단 :", dan);
                ggde.printPart();
            }
        } else {
//            System.out.println("dan 10이상 ");
            GuGuDanExpr.printAll();
        }
    }
}
