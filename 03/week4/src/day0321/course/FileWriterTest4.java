package day0321.course;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class FileWriterTest4 {
	public static void main(String[] args) {
		String path = "C:/iotest";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		try (FileWriter writer = new FileWriter("C:/iotest/today.txt", true);
				PrintWriter out = new PrintWriter(writer);) {
			// PrintWriter - 원하는 포맷으로 출력하게 해줌. 단 append 모드로 파일을 여는것이 불가능.
			//  이 2개의 객체는 try-catch가 끝날 때 자동으로 close.

			LocalDate ld = LocalDate.now();
			// 현재시점을 기준으로 LocalDate를 만들어줌

			int yearNum = ld.getYear();
			int monthNum = ld.getMonthValue();
			int dateNum = ld.getDayOfMonth();
			DayOfWeek day = ld.getDayOfWeek();
			String korday = day.getDisplayName(TextStyle.FULL, Locale.KOREAN);

			out.printf("오늘은 %d년 %d월 %d일입니다.\r\n", yearNum, monthNum, dateNum);
			out.printf("오늘은 %s입니다.\r\n", korday);
			// printWriter 객체니까 printf를 이용해서 출력하는것을 볼 수 있음

			LocalDate myld = LocalDate.of(2022, 7, 17);


			DayOfWeek myday = myld.getDayOfWeek();
			String mykorday = myday.getDisplayName(TextStyle.FULL, Locale.KOREAN);
			out.printf("%s은 %s에 태어났습니다.%n", "XXX", mykorday);
			System.out.println("저장이 완료되었습니다.");

		} catch (Exception e) {
			System.out.println("파일에 저장하는 동안 오류가 발생했습니다.");
		}
	}
}