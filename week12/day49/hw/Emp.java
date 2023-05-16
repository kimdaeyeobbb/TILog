package jpamvcexam.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "emp")
public class Emp {

    @Id
    @Column(name = "EMPNO")
    private int empno;

    @Column(name = "ENAME")
    private String ename;

    @Column(name = "JOB")
    private String job;

    @Column(name = "MGR")
    private int mgr;

    @Column(name = "HIREDATE")
    private Date hiredate;

    @Column(name = "SAL")
    private int sal;

    @Column(name = "COMM")
    private int comm;

    @ManyToOne
    @JoinColumn(name = "DEPTNO")
    private Dept dept;

    public Emp(){}

    public Emp(int empno, String ename, String job, int mgr, Date hiredate, int sal, int comm, Dept dept) {
        super();
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.dept = dept;
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

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public int getComm() {
        return comm;
    }

    public void setComm(int comm) {
        this.comm = comm;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                ", comm=" + comm +
                ", dept=" + dept +
                '}';
    }
}
