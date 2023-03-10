package day0309.hw02;

public class TwoArrayLab2 {
    public static void main(String[] args) {
        char[][] chArr = {
                {'B','C','A','A'},
                {'C','C','B','B'},
                {'D','A','A','D'}
        };

        int intArr[] = new int[4];

        for (int i=0; i<chArr.length; i++){
            for (int j=0; j<chArr[i].length; j++){
                if (chArr[i][j] == 'A'){
                    intArr[0]++;
                } else if (chArr[i][j] == 'B'){
                    intArr[1]++;
                } else if (chArr[i][j] == 'C'){
                    intArr[2]++;
                } else if (chArr[i][j] == 'D'){
                    intArr[3]++;
                }
            }
        }

        int num = 65;
        for (int i=0; i< intArr.length; i++){
            System.out.printf("%c 는 %d개 입니다.\n", num,intArr[i]);
            num++;
        }
    }
}