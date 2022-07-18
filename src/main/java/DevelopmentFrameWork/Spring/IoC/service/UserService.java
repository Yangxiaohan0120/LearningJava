package DevelopmentFrameWork.Spring.IoC.service;

import DevelopmentFrameWork.Spring.IoC.dao.UserDao;

/**
 * @author Chris Yang
 * created 2022-07-17 21:16
 **/
public class UserService {
    private UserDao userDao;

    public UserService() {
        System.out.println("UserService已创建：" + this);
    }

    public void setUserDao(UserDao userDao) {
        System.out.println("调用setUserDao:" + userDao);
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
