package day3.hw;

public class ForLab5 {
    public static void main(String[] args) {
        int randNum1 = (int)(Math.random()*8)+3;
        int randNum2 = (int)(Math.random()*3)+1;

        for (int n=1; n<=randNum1; n++){
            switch (randNum2){
                case 1:
                    System.out.print('*');
                    break;
                case 2:
                    System.out.print('$');
                    break;
                case 3:
                    System.out.print('#');
                    break;
            }
        }
    }
}
