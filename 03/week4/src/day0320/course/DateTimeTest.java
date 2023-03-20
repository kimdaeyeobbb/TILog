package day0320.course;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
// util 패키지 - 잡다한 기능. 다양한 기능의 패키지가 모여있음. 유용한 애들임.

public class DateTimeTest {

	public static void main(String[] args) throws Exception {
		Date d = new Date();
		System.out.println(d.toString());
		System.out.println(d.getTime());  // 1970년 1월 1일을 기준으로 해서 흐른시간 리턴

		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc.get(GregorianCalendar.DAY_OF_WEEK));   // 23.03.20 월 기준 - 2 (자바는 일요일이 1)
		gc = new GregorianCalendar(2023, 2, 31);// 0이 1월 11은 12월
		System.out.println(gc.get(GregorianCalendar.DAY_OF_WEEK));

		System.out.println(timeToStrDate(new Date().getTime()));
		System.out.println(parseStrDate("2019년 01월 01일"));

		LocalDate currentDate = LocalDate.now();
		LocalDate targetDate = LocalDate.of(2023, 7, 26);  // 교육 종료일
		System.out.println(currentDate.getDayOfWeek());

		// 한국어를 기준으로 요일 정보를 추출
		System.out.println(currentDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN));
		System.out.println(currentDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));		
		System.out.println(targetDate.getDayOfWeek());
		System.out.println(targetDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN));
		System.out.println(targetDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));
		
		LocalTime currentTime = LocalTime.now();
		LocalTime targetTime = LocalTime.of(9, 10, 20);
		System.out.println(currentTime);
		System.out.println(targetTime);

		LocalDateTime currentDateTime = LocalDateTime.now();   // 웹 프로그래밍 할 때 많이 사용
		LocalDateTime targetDateTime = LocalDateTime.of(2023, 12, 25, 12, 30);
		// 오버로딩 되어있으므로 초까지 기재해도 됨

		System.out.println(currentDateTime);
		System.out.println(targetDateTime);
	}

	public static String timeToStrDate(long time) {
		DateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");  // munite과의 구분하기 위해서 월은 MM을 사용
		return formatter.format(time);
	}

	public static Date parseStrDate(String strDate) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일");
		return formatter.parse(strDate);
	}

}
