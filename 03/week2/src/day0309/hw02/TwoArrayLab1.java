package day0309.hw02;

public class TwoArrayLab1 {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        int num = 10;
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[i].length; j++){
                arr[i][j] = num;
                num += 2;
            }
        }

        System.out.println("1행 1열의 데이터 : " + arr[0][0]);
        System.out.println("3행 4열의 데이터 : " + arr[2][3]);
        System.out.println("행의 갯수 : " + arr.length);
        System.out.println("열의 갯수 : " + arr[0].length);
        System.out.print("3행의 데이터들 :");
        for (int i=2; i<3; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(" " + arr[i][j]);
            }
        }
        System.out.print("\n2열의 데이터들 :");
        for(int i=0; i<arr.length; i++){
            for (int j=1; j<2; j++){
                System.out.print(" " + arr[i][j]);
            }
        }

        System.out.print("\n왼쪽 대각선 데이터들 :");
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[i].length; j++){
                if(i == j){
                    System.out.print(" " + arr[i][j]);
                }
            }
        }

        System.out.print("\n오른쪽 대각선 데이터들 :");
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[i].length; j++){
                if(i+j == arr.length-1){
                    System.out.print(" " + arr[i][j]);
                }
            }
        }
    }
}
