package day0308.hw01;

public class ForLab6 {
    public static void main(String[] args) {
        final char CH1 = '&';
        int randNum = (int)(Math.random()*6)+5;

        for (int n=1; n<=randNum; n++){
            for (int count=1; count <=n; count++){
                System.out.print(CH1);
            }
            System.out.println();
        }
    }
}
