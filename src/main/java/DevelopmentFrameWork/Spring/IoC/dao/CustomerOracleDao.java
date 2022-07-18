package DevelopmentFrameWork.Spring.IoC.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @author Chris Yang
 * created 2022-07-18 10:44
 **/

@Repository
//@Primary
public class CustomerOracleDao implements ICustomerDao{
    public CustomerOracleDao() {
        System.out.println("正在创建CustomerOracleDao" + this);
    }
}
