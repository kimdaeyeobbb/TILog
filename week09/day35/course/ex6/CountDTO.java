package week09.day35.course.ex6;
public class CountDTO {
	private int countNum;
	public CountDTO() {
		System.out.println("CountVO 객체 생성!!");
	}
	public int getCountNum() {
		return countNum;
	}
	public void setCountNum(int countNum) {
		// 기존값에 새로운 값을 누적
		this.countNum += countNum;
	}
}
