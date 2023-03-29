package day5.hw;

public class MethodLab2 {
    public static void main(String[] args) {
        pick('@',3);
        pick('%',4);
        pick('A',5);
    }

    static void pick(char chPicked, int numPicked){
        for (int i=0; i<numPicked; i++){
            for (int j=numPicked-i-1; j>=0; j--){
                System.out.print(" ");
            }
            for (int j=1; j<=i+1; j++){
                System.out.print(chPicked);
            }
            System.out.println();
        }
    }

}
