package DevelopmentFrameWork.Spring.IoC.dao;

/**
 * @author Chris Yang
 * created 2022-07-17 21:11
 **/
public class UserDao {
    public UserDao() {
        System.out.println("userDao已创建" + this);
    }

    public void insert(){
        System.out.println("插入一条用户的数据");
    }
}
