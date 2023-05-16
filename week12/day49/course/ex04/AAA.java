package jpamvcexam.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AAA {
	@Id
	int id;
	private String username;
	// 연관관계 매핑

	@ManyToOne
	private Team a;
	// Team이라는 엔티티 타입의 변수
	// 멤버변수의 성격은 또 다른 테이블인 Team을 참조하는 FK 참조
	// 엔티티 객체의 필드명 -> 얘가 참조하는 또 다른 객체의 PK가 뒤에 붙어 컬럼명을 형성할 수 있음
	// 테이블이 만들어 질때 이 규칙을 따라감

	public AAA() {
	}

	public AAA(String username, Team team) {
		super();
		this.username = username;
		a = team;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Team getA() {
		return a;
	}

	public void setA(Team team) {
		a = team;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", a=" + a + "]";
	}
}
