package day4.hw;

public class TwoArrayLab5 {
    public static void main(String[] args) {
        int arr1[][] = new int[5][3];

        for (int i=0; i<arr1.length; i++){
            for (int j=0; j<arr1[i].length; j++){
                System.out.print(arr1[i][j] + "\t");
            }
            System.out.println();
        }

        for (int i=0; i<1; i++){
            int num = 1;
            for (int j=0; j<5; j++){
                arr1[j][i] += num;
                num++;
            }
        }

        for (int i=1; i<2; i++){
            int num =6;
            for (int j=1; j<4; j++){
                arr1[j][i] += num;
                num++;
            }
        }

        arr1[2][2] = 9;

        System.out.println();

        for (int i=0; i<arr1.length; i++){
            for (int j=0; j<arr1[i].length; j++){
                System.out.print(arr1[i][j]+ "\t");
            }
            System.out.println();
        }
    }
}
