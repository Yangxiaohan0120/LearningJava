package DevelopmentFrameWork.Mybatis.Entity;

/**
 * @author Chris Yang
 * created 2022-07-16 13:52
 **/
public class habbit {
    private Integer Index;
    private Integer empno;
    private String habbit;

    private emp Emp;

    public emp getEmp() {
        return Emp;
    }

    public void setEmp(emp Emp) {
        this.Emp = Emp;
    }

    public void setIndex(Integer index) {
        Index = index;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public void setHabbit(String habbit) {
        this.habbit = habbit;
    }

    public Integer getIndex() {
        return Index;
    }

    public Integer getEmpno() {
        return empno;
    }

    public String getHabbit() {
        return habbit;
    }
}
