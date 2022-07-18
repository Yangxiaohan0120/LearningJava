package DevelopmentFrameWork.Spring.AOP.service;


import DevelopmentFrameWork.Spring.AOP.dao.UserAnnoDao;
import DevelopmentFrameWork.Spring.AOP.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户服务
 */

@Service
public class UserAnnoService {
    @Resource
    private UserAnnoDao userDao;

    public void createUser(){
//        if(1==1){
//            throw new RuntimeException("用户已存在");
//        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("执行创建用户业务逻辑");
        userDao.insert();
    }

    public String generateRandomPassword(String type , Integer length){
        System.out.println("按" + type + "方式生成"+ length  + "位随机密码");
        return "Zxcquei1";
    }

    public UserAnnoDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserAnnoDao userDao) {
        this.userDao = userDao;
    }
}
