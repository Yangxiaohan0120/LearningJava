package DevelopmentFrameWork.Spring.AOP.service.pro;

/**
 * @author Chris Yang
 * created 2022-07-18 20:58
 **/
public class UserServiceProxy1 implements UserService {
    //持有委托类的对象
    private UserService userService;

    public UserServiceProxy1(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void createUser() {
//        System.out.println("--------" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()) + "-----------");
        userService.createUser();
        System.out.println("==========后置扩展功能==========");
    }
}
