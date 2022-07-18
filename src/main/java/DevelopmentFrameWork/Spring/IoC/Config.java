package DevelopmentFrameWork.Spring.IoC;

import DevelopmentFrameWork.Spring.IoC.controller.CustomerController;
import DevelopmentFrameWork.Spring.IoC.dao.CustomerDao;
import DevelopmentFrameWork.Spring.IoC.service.CustomerService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author Chris Yang
 * created 2022-07-18 11:11
 **/

@Configuration //当前是配置类，替代xml
@ComponentScan(basePackages = "DevelopmentFrameWork.Spring.IoC")
public class Config {

    @Bean //利用方法创建对象，将方法返回对象放入容器，beanId = 方法名
    public CustomerDao customerDao() {
        CustomerDao customerDao = new CustomerDao();
        System.out.println("Config====已创建" + customerDao);
        return customerDao;
    }

    @Bean
    public CustomerService customerService(CustomerDao customerDao) {
        CustomerService customerService = new CustomerService();
        System.out.println("Config====已创建" + customerService);
        customerService.setcDao(customerDao);
        System.out.println("Config====调用setcDao" + customerDao);
        return customerService;
    }

    @Bean
    @Scope("prototype")
    public CustomerController customerController(CustomerService customerService){
        CustomerController customerController = new CustomerController();
        System.out.println("Config====已创建" + customerController);
        customerController.setcService(customerService);
        System.out.println("Config====调用setcService" + customerService);
        return customerController;
    }
}

