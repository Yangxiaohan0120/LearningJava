package DevelopmentFrameWork.Spring.IoC.service;

import DevelopmentFrameWork.Spring.IoC.dao.CustomerDao;
import DevelopmentFrameWork.Spring.IoC.dao.ICustomerDao;
import DevelopmentFrameWork.Spring.IoC.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author Chris Yang
 * created 2022-07-18 10:28
 **/

@Service
@Scope("prototype")
public class CustomerService {

    @Value("${metaData}")
    private String metaData;


    public CustomerService() {
        System.out.println("正在创建CustomerService");
    }

    @PostConstruct
    public void init(){
        System.out.println("metaData:" + metaData );
        System.out.println("初始化");
    }

    // 装配注解在属性上，不执行set方法，会使用反射机制将属性自动改为public，并进行赋值
    private ICustomerDao cDao;

//    @Autowired
    // 装配注解在set方法上，自动按类型/名称 set方法参数注入
    public void setcDao(ICustomerDao cDao) {
        System.out.println("SetcDao: " + cDao);
        this.cDao = cDao;
    }

    public ICustomerDao getcDao() {
        return cDao;
    }
}

