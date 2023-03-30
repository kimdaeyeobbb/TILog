# 과제 풀이

## FileOutLab

```java
package day0321.hw;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        if (!dir.exists()) {
            dir.mkdirs(); // 존재 X일시 -> 디렉토리 생성
        }

        try (FileWriter writer = new FileWriter("C:/Temp/event.txt", true);
             // closesuable인 객체 생성하는 문장만 올 수 있음
             PrintWriter out = new PrintWriter(writer);) {

            LocalDate myld1 = LocalDate.of(2023, 5, 5);
            DayOfWeek myday1 = myld1.getDayOfWeek();
            String mykorday1 = myday1.getDisplayName(TextStyle.FULL, Locale.KOREAN);
            out.printf("2023년 5월 5일은 %s입니다.\r\n", mykorday1);

            myld1 = LocalDate.of(2023, 6, 6);
            myday1 = myld1.getDayOfWeek();
            mykorday1 = myday1.getDisplayName(TextStyle.FULL, Locale.KOREAN);
            out.printf("2023년 6월 6일은 %s입니다.\r\n", mykorday1);

            System.out.println("저장이 완료되었습니다.");
        } catch (IOException ioe){
            System.out.println("파일에 저장하는 동안 오류가 발생했습니다.");
        }
    }
}
```


# CopyLab

```java

```

- EOF
  - EndOfFile

# CountLab

```java
package day0321.hw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CountLab {
    public static void main(String[] args) {
        File f = new File("C:\\Users\\kimdy\\Desktop\\DY\\Git\\dktechin_TIL\\03\\week4\\src\\day0321\\hw\\yesterday.txt");
        try {(Scanner scan = new Scanner(f)) {
                int cnt = 0;
                String sig;
                while(scan.hasNext()){
                    sig = scan.next();
                    System.out.println(sig);
                    if (sig.substring(0, sig.length() - 1).equals("yesterday") || sig.equals("yesterday")) {
                        cnt++;
                    }
                }
            System.out.println(cnt);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("yesterday.txt 파일을 찾을 수 없습니다.");
        }
    }
}

```