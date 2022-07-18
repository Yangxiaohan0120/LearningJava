package DevelopmentFrameWork.Spring.AOP.dao;

import org.springframework.stereotype.Repository;

/**
 * 员工表Dao
 */

@Repository
public class EmployeeAnnoDao {
    public void insert(){
        System.out.println("新增员工数据");
    }
}
