package day0309.hw02;

public class TwoArrayLab3 {
    public static void main(String[] args) {
        int twoDimArr[][] = {
            {5,2,1,0,2,3,6},
            {4,3,2,1,1,0,5},
            {3,1,2,1,3,1,3},
            {4,3,1,0,4,2,7}
        };

        /* 일별 게임시간 */
        int dailyArr[] = new int[7];
        String dayArr[] = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};

        for (int i=0; i<twoDimArr[0].length; i++){
            for (int j=0; j< twoDimArr.length; j++){
                dailyArr[i] += twoDimArr[j][i];
            }
        }

        for (int i=0; i<dailyArr.length; i++){
            System.out.println(dayArr[i] + " : " + dailyArr[i] + "시간");
        }

        System.out.println();
        System.out.println("주별 게임 시간 합");
        System.out.println();

        /* 주간별 게임시간 */
        int weeklyArr[] = new int[4];
        for (int i=0; i<twoDimArr.length; i++){
            for (int j=0; j<twoDimArr[i].length; j++){
                weeklyArr[i] += twoDimArr[i][j];
            }
        }

        for (int i=0; i<weeklyArr.length; i++){
            System.out.printf("%d주차 : %d시간\n", (i+1),weeklyArr[i]);
        }
    }
}
