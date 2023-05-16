package jpamvcexam.model.vo;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Visitor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;  // 자동증가하는 특성을 가지는 id
	private String name;
	@CreationTimestamp  // 이 칼럼은 멤버변수에 따로 값을 지정하지 않았을 경우 자동으로 현재시간 기준 날짜 데이터 생성. 얘가 주석으로 막혀있으면 writeDate에는 값을 생성하지 않음
	private java.sql.Date writeDate;
	private String memo;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public java.sql.Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(java.sql.Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Override
	public String toString() {
		return "VisitorVO [id=" + id + ", name=" + name + ", writeDate=" + writeDate + ", memo=" + memo + "]";
	}
}
