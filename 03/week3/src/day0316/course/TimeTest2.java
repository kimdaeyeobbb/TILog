package day0316.course;

public class TimeTest2 {
	public static void main(String[] args) {
		Time2 t = new Time2(12, 35, 30);
		System.out.println(t);
		t.setHour(30);
		System.out.println(t);
		t.setMinute(-10);
		System.out.println(t);
		t.setHour(t.getHour()+2);
		System.out.println(t);
	}
}

class Time2 {
	// 인스턴스 멤버변수를 외부에서 직접 접근하지 못하도록 private으로 설정
	// 일반적으로 static 변수는 접근 제한이 없도록 public으로 설정
	private int hour;
	private int minute;
	private int second;

	Time2(int hour, int minute, int second) {
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}

	// getter - 멤버변수의 값을 읽어감
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if (hour < 0 || hour > 23)
			return;
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if (minute < 0 || minute > 59)
			return;
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		if (second < 0 || second > 59)
			return;
		this.second = second;
	}

	public String toString() {
		return String.format("%d시 %d분 %d초", hour, minute, second);
	}
}