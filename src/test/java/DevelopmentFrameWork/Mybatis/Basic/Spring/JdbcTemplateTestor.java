package DevelopmentFrameWork.Mybatis.Basic.Spring;

import DevelopmentFrameWork.Spring.JDBC.Entity.Employee;
import DevelopmentFrameWork.Spring.JDBC.dao.EmployeeDao;
import DevelopmentFrameWork.Spring.JDBC.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-07-19 14:04
 **/

// Junit 交给 Spring进行执行
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:applicationContext-jdbc.xml"})
@ContextConfiguration(locations = {"classpath:applicationContext-jdbcanno.xml"})
public class JdbcTemplateTestor {
    @Resource
    private EmployeeDao employeeDao;

    @Resource
    private EmployeeService employeeService;


    @Test
    public void testFindById() {
        Employee employee = employeeDao.findById(3308);
        System.out.println(employee);
    }

    @Test
    public void testFindByDname() {
        System.out.println(employeeDao.findByDname("研发部"));
    }

    @Test
    public void testFindMapByDname() {
        System.out.println(employeeDao.findMapByDname("研发部"));
    }

    @Test
    public void testInsert() {
        Employee employee = new Employee();
        employee.setEno(8888);
        employee.setEname("赵六");
        employee.setSalary(6666f);
        employee.setDname("研发部");
        employee.setHiredate(new Date());
        employeeDao.insert(employee);
    }

    @Test
    public void testUpdate() {
        Employee employee = employeeDao.findById(8888);
        employee.setSalary(employee.getSalary() + 1000);
        int count = employeeDao.update(employee);
        System.out.println(count);
    }

    @Test
    public void testDelete() {
        int count = employeeDao.delete(8888);
        System.out.println(count);
    }

    @Test
    public void testBatchInsert() {
        employeeService.batchImport();
        System.out.println("批量导入成功");
    }

    @Test
    public void testImportJob() {
        employeeService.startImportJob();
    }

}
