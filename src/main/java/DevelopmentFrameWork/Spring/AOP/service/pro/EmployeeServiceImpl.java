package DevelopmentFrameWork.Spring.AOP.service.pro;

/**
 * @author Chris Yang
 * created 2022-07-18 21:33
 **/
public class EmployeeServiceImpl implements EmployeeService{
    @Override
    public void createEmployee() {
        System.out.println("实现创建Employee方法");
    }
}
