package day12.hw;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class FileOutLab {
    public static void main(String[] args) {
        String path = "C:/Temp";
        File dir = new File(path);
        /* 디렉토리 존재여부 확인 */
        if(!dir.exists()){
            dir.mkdirs(); // 존재 X일시 -> 디렉토리 생성
        }

        try(FileWriter writer = new FileWriter("C:/Temp/event.txt", true);
            PrintWriter out = new PrintWriter(writer);){

            LocalDate myld1 = LocalDate.of(2023,5,5);
            DayOfWeek myday1 = myld1.getDayOfWeek();
            String mykorday1 = myday1.getDisplayName(TextStyle.FULL, Locale.KOREAN);
            out.printf("2023년 5월 5일은 %s입니다.\r\n", mykorday1);

            myld1 = LocalDate.of(2023,6,6);
            myday1 = myld1.getDayOfWeek();
            mykorday1 = myday1.getDisplayName(TextStyle.FULL, Locale.KOREAN);
            out.printf("2023년 6월 6일은 %s입니다.\r\n", mykorday1);

            System.out.println("저장이 완료되었습니다.");
        } catch (Exception e){
            System.out.println("파일에 저장하는 동안 오류가 발생했습니다.");
        }
    }
}