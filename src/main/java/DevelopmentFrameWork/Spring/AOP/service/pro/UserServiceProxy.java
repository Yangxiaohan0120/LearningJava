package DevelopmentFrameWork.Spring.AOP.service.pro;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Chris Yang
 * created 2022-07-18 20:58
 **/

// 静态代理是指必须手动擦黄健代理了爹代理模式使用方式
public class UserServiceProxy implements UserService {
    //持有委托类的对象
    private UserService userService;

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void createUser() {
        System.out.println("--------" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()) + "-----------");
        userService.createUser();
    }
}
