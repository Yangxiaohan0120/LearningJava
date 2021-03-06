package DevelopmentFrameWork.Spring.IoC;

import DevelopmentFrameWork.Spring.IoC.Entity.Apple;
import DevelopmentFrameWork.Spring.IoC.Entity.Child;
import DevelopmentFrameWork.Spring.IoC.Entity.Company;
import DevelopmentFrameWork.Spring.IoC.Entity.Order;
import DevelopmentFrameWork.Spring.IoC.dao.UserDao;
import org.checkerframework.checker.units.qual.A;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Chris Yang
 * created 2022-07-17 16:48
 **/
public class SpringApplication {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        Apple sweetApple = context.getBean("sweetApple", Apple.class);
//        System.out.println(sweetApple.getTitle());
//
//        Apple sourApple = (Apple) context.getBean("sourApple");
//        System.out.println(sweetApple.getTitle());
//
//        Child lily = context.getBean("lily", Child.class);
//        lily.eat();
//        Child andy = context.getBean("andy", Child.class);
//        andy.eat();
//        Child luna = context.getBean("luna", Child.class);
//        luna.eat();
//
//        Apple apple = context.getBean("DevelopmentFrameWork.Spring.IoC.Entity.Apple", Apple.class);


//        Company company = context.getBean("company", Company.class);
//        System.out.println(company);
//
//        String[] beanNames = context.getBeanDefinitionNames();
//        for (String name : beanNames) {
//            System.out.println(name);
//        }

//        UserDao userDao1 = context.getBean("userDao", UserDao.class);
//        UserDao userDao2 = context.getBean("userDao", UserDao.class);
//        UserDao userDao3 = context.getBean("userDao", UserDao.class);

//        Order order1 = context.getBean("order1", Order.class);
//        order1.pay();
//
//
//        ((ClassPathXmlApplicationContext) context).registerShutdownHook();

        DevelopmentFrameWork.Spring.IoC.context.ApplicationContext context =  new DevelopmentFrameWork.Spring.IoC.context.ClassPathXmlApplicationContext();
        Apple apple = (Apple) context.getBean("sweetApple");
        System.out.println(apple);


    }
}
