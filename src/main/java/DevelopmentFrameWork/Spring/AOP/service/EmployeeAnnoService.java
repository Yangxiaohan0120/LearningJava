package DevelopmentFrameWork.Spring.AOP.service;

import DevelopmentFrameWork.Spring.AOP.dao.EmployeeAnnoDao;
import DevelopmentFrameWork.Spring.AOP.dao.EmployeeDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 员工服务
 */

@Service
public class EmployeeAnnoService {

    @Resource
    private EmployeeAnnoDao employeeDao;

    public void entry() {
        System.out.println("执行员工入职业务逻辑");
        employeeDao.insert();
    }

    public EmployeeAnnoDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeAnnoDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
