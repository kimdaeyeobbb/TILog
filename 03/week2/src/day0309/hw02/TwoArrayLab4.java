package day0309.hw02;

public class TwoArrayLab4 {
    public static void main(String[] args) {

        int twoDimArr[][] ={
            {10,20,30,40,50},
            {5,10,15},
            {11,22,33,44},
            {9,8,7,6,5,4,3,2,1}
        };

        for (int i=0; i<twoDimArr.length; i++){
            int sum =0;
            for (int j=0; j<twoDimArr[i].length; j++){
                sum += twoDimArr[i][j];
            }
            System.out.printf("%d행의 합은 %d 입니다.\n", i+1 ,sum);
        }

    }
}
