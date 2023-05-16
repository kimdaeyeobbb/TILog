package jpamvcexam.model.entity;

import javax.persistence.*;

@Entity
public class Member {
	@Id
	@Column(name = "MEMBER_ID")  // db테이블의 컬럼 지정
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	// 연관관계 매핑des

	@ManyToOne
	@JoinColumn(name = "TEAM_ID")  // 컬럼명을 TEAM_ID로 지정하여 컬럼 생성 (이름을 지정하지 않으면 필드명_참조하는 대산의pk에 대한 칼럼명으로 컬럼명을 지정해버림)
	// 내가 원하는대로 컬럼명을 지정하고 싶은 경우 @JoinColumn 사용
	private Team team;
	// team이라는 필드는 다른 엔티티에 대한 참조값을 가지게 되는 필드임을 뜻함
	// 참조하게 되는 또 다른 엔티티 객체의 타입으로 변수의 타입이 선언되어있음
	// Team 객체를 참조하게끔 Team으로 타입 지정


	public Member() {

	}

	public Member(String username, Team team) {
		super();
		this.username = username;
		this.team = team;
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

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", team=" + team + "]";
	}
}
