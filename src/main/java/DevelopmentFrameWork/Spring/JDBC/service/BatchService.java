package DevelopmentFrameWork.Spring.JDBC.service;

import DevelopmentFrameWork.Spring.JDBC.Entity.Employee;
import DevelopmentFrameWork.Spring.JDBC.dao.EmployeeDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Chris Yang
 * created 2022-07-19 15:48
 **/
@Service
public class BatchService {

    @Resource
    private EmployeeDao employeeDao;

    public void importJob1(){
        for (int i = 1; i <= 10; i++) {
            Employee employee = new Employee();
            employee.setEno(8000 + i);
            employee.setEname("研发部员工" + i);
            employee.setSalary(4000f);
            employee.setDname("研发部");
            employee.setHiredate(new Date());
            employeeDao.insert(employee);
        }
    }

    public void importJob2(){
        for (int i = 1; i <= 10; i++) {
            Employee employee = new Employee();
            employee.setEno(9000 + i);
            employee.setEname("市场部门员工" + i);
            employee.setSalary(4500f);
            employee.setDname("市场部");
            employee.setHiredate(new Date());
            employeeDao.insert(employee);
        }
    }



    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
