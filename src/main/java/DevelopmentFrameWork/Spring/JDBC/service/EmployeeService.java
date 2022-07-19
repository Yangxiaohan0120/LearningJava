package DevelopmentFrameWork.Spring.JDBC.service;

import DevelopmentFrameWork.Spring.JDBC.Entity.Employee;
import DevelopmentFrameWork.Spring.JDBC.dao.EmployeeDao;
import org.apache.ibatis.transaction.Transaction;
import org.omg.SendingContext.RunTime;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;
import javax.management.relation.RoleUnresolved;
import java.util.Date;

/**
 * @author Chris Yang
 * created 2022-07-19 14:45
 **/
@Service
// 声明式事务的核心注解
// 放在类上，将声明式事务配置应用于当前类所有方法，默认事务传播为REQUIRED
@Transactional
public class EmployeeService {

    @Resource
    private EmployeeDao employeeDao;
//    private DataSourceTransactionManager transactionManager;

    @Resource
    private BatchService batchService;

    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public Employee findById(Integer eno){
        return employeeDao.findById(eno);
    }

    public void batchImport(){
        // 定义了事物默认的标准配置
//        TransactionDefinition definition = new DefaultTransactionDefinition();
        // 开始一个事务，返回事务状态，事务状态说明当前事务的执行阶段
//        TransactionStatus status = transactionManager.getTransaction(definition);

//        try {
            for (int i = 1; i <= 10; i++) {
//                if(i == 3){
//                    throw new RuntimeException("意料之外的异常");
//                }
                Employee employee = new Employee();
                employee.setEno(8000 + i);
                employee.setEname("员工" + i);
                employee.setSalary(4000f);
                employee.setDname("市场部");
                employee.setHiredate(new Date());
                employeeDao.insert(employee);
            }
            // 提交事务
//            transactionManager.commit(status);
//        }catch (RuntimeException e) {
//             回滚事务
//            transactionManager.rollback(status);
//            throw e;
//        }
    }

    public void startImportJob(){
        batchService.importJob1();
        batchService.importJob2();
    }

    public BatchService getBatchService() {
        return batchService;
    }

    public void setBatchService(BatchService batchService) {
        this.batchService = batchService;
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

//    public DataSourceTransactionManager getTransactionManager() {
//        return transactionManager;
//    }
//
//    public void setTransactionManager(DataSourceTransactionManager transactionManager) {
//        this.transactionManager = transactionManager;
//    }
}
