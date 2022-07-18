package DevelopmentFrameWork.Spring.AOP.service.pro;

/**
 * @author Chris Yang
 * created 2022-07-18 20:56
 **/
public class UserServiceImpl implements UserService{
    @Override
    public void createUser() {
        System.out.println("执行创建用户业务逻辑");
    }
}
