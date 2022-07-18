package DevelopmentFrameWork.Spring.AOP;

import DevelopmentFrameWork.Spring.AOP.dao.UserAnnoDao;
import DevelopmentFrameWork.Spring.AOP.service.UserAnnoService;
import DevelopmentFrameWork.Spring.AOP.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Chris Yang
 * created 2022-07-18 16:45
 **/
public class SpringApplication {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-aop.xml");
//        UserService userService = context.getBean("userService", UserService.class);
//        userService.createUser();
//        userService.generateRandomPassword("MD5",16);

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-aopanno.xml");
        UserAnnoService userAnnoService = context.getBean("userAnnoService",UserAnnoService.class);
        userAnnoService.createUser();

    }
}
