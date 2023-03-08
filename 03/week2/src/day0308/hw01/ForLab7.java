package day0308.hw01;

public class ForLab7 {
    public static void main(String[] args) {
        final char STAR = '*';

        for (int col=7; col>=1; col--){
            for (int row=1; row<=col; row++){
                System.out.print(STAR);
            }
            System.out.println();
        }
    }
}
