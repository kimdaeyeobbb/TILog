package week07.day30.hw;

// private 타입 멤버변수 – hour, minute
// 생성자와 getter
public class TimeVO {
    // getter만 있는것이 VO
    // getter와 setter 모두가 있는 것이 DTO
    private int hour;
    private int minute;

    public TimeVO(int hour, int minute){
        super();
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }
    public int getMinute() {
        return minute;
    }

}
