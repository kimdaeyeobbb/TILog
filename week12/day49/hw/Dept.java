package jpamvcexam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dept")
public class Dept {

    @Id
    @Column(name = "DEPTNO")
    private int deptno;

    @Column(name = "DNAME")
    private String dname;

    @Column(name = "LOC_CODE")
    private String locCode;

    public Dept(){}

    public Dept(int deptno, String dname, String locCode) {
        super();
        this.deptno = deptno;
        this.dname = dname;
        this.locCode = locCode;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLocCode() {
        return locCode;
    }

    public void setLocCode(String locCode) {
        this.locCode = locCode;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", locCode='" + locCode + '\'' +
                '}';
    }
}
