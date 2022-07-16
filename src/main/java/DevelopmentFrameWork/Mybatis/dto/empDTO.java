package DevelopmentFrameWork.Mybatis.dto;

import DevelopmentFrameWork.Mybatis.Entity.emp;

/**
 * @author Chris Yang
 * created 2022-07-15 16:01
 **/
public class empDTO {
    private DevelopmentFrameWork.Mybatis.Entity.emp emp = new emp();
    private String dname;
    private String test;

    public void setP(emp emp) {
        this.emp = emp;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public emp getP() {
        return emp;
    }

    public String getDname() {
        return dname;
    }

    public String getTest() {
        return test;
    }
}
