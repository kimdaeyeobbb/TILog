package day3.hw;

public class ForLab9 {
    public static void main(String[] args) {
        int randNum = (int)(Math.random()*2)+1;

        switch (randNum){
            case 1:
                for (int dan=1; dan<=9; dan+=2){
                    for (int num=1; num<=9; num++){
                        System.out.print(dan + "x" + num + "=" + dan*num + "\t");
                    }
                    System.out.println();
                }
                break;
            case 2:
                for (int dan=2; dan<=8; dan+=2){
                    for (int num=1; num<=9; num++){
                        System.out.print(dan + "x" + num + "=" + dan*num + "\t");
                    }
                    System.out.println();
                }
                break;
        }
    }
}