package DevelopmentFrameWork.Spring.AOP;

import DevelopmentFrameWork.Spring.AOP.service.pro.UserService;
import DevelopmentFrameWork.Spring.AOP.service.pro.UserServiceImpl;
import DevelopmentFrameWork.Spring.AOP.service.pro.UserServiceProxy;
import DevelopmentFrameWork.Spring.AOP.service.pro.UserServiceProxy1;

/**
 * @author Chris Yang
 * created 2022-07-18 20:57
 **/
public class Application {
    public static void main(String[] args) {
        UserService userService = new UserServiceProxy1(new UserServiceProxy(new UserServiceImpl()));
        userService.createUser();
    }
}
