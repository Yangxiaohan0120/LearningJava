package DevelopmentFrameWork.Spring.AOP.dao;

import org.springframework.stereotype.Repository;

/**
 * 用户表Dao
 */

@Repository
public class UserAnnoDao {
    public void insert(){
        System.out.println("新增用户数据");
    }
}
