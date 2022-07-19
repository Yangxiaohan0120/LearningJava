package DevelopmentFrameWork.Spring.JDBC.Entity;

import java.util.Date;

/**
 * @author Chris Yang
 * created 2022-07-18 22:20
 **/
public class Employee {
    private Integer eno;
    private String ename;
    private Float salary;
    private String dname;
    private Date hiredate;

    public void setEno(Integer eno) {
        this.eno = eno;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Integer getEno() {
        return eno;
    }

    public String getEname() {
        return ename;
    }

    public Float getSalary() {
        return salary;
    }

    public String getDname() {
        return dname;
    }

    public Date getHiredate() {
        return hiredate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eno=" + eno +
                ", ename='" + ename + '\'' +
                ", salary=" + salary +
                ", dname='" + dname + '\'' +
                ", hiredate=" + hiredate +
                '}';
    }
}
