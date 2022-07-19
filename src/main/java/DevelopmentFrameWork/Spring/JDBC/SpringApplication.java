package DevelopmentFrameWork.Spring.JDBC;

import DevelopmentFrameWork.Spring.JDBC.Entity.Employee;
import DevelopmentFrameWork.Spring.JDBC.dao.EmployeeDao;
import org.checkerframework.checker.units.qual.C;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Chris Yang
 * created 2022-07-19 13:33
 **/
public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-jdbc.xml");
        EmployeeDao employeeDao = context.getBean("employeeDao",EmployeeDao.class);
        Employee employee = employeeDao.findById(3308);
        System.out.println(employee);
    }
}
