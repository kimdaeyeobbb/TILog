package week12.day48.course.ex01;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp")  // 매핑되는 테이블명이 emp테이블 (
public class EmpVO {
	@Id
	private int empno;  // pk. null이 될 수 없음
	private String ename;
	private String job;
	private String mgr;
	private java.sql.Date  hiredate;
	private int sal;  // null이 될 수 없음. 따라서 기본형을 써도 됨
	private Integer comm;
	// int와 Interger로 구분한 이유..?
	// null이 가능한 컬럼은 기본형이면 안됨.
	// comm -> 부서가 배정되지 않을수도 있으므로 null일 수 있음 -> 따라서 객체형이어야 함

	private Integer deptno;
	
	public String getMgr() {
		return mgr;
	}

	public void setMgr(String mgr) {
		this.mgr = mgr;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public java.sql.Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(java.sql.Date  hiredate) {
		this.hiredate = hiredate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "EmpVO [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate=" + hiredate
				+ ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}	
}
