package DevelopmentFrameWork.Spring.IoC.dao;

import org.springframework.stereotype.Repository;

/**
 * @author Chris Yang
 * created 2022-07-18 10:22
 **/

// 组件类型注解默认beanId为类名首字母小写
// beanId - customerDao
@Repository
public class CustomerDao implements ICustomerDao{
    public CustomerDao() {
        System.out.println("正在创建cDao");
    }
}
