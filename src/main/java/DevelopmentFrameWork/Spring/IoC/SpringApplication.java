package DevelopmentFrameWork.Spring.IoC;

import DevelopmentFrameWork.Spring.IoC.Entity.Apple;
import DevelopmentFrameWork.Spring.IoC.Entity.Child;
import org.checkerframework.checker.units.qual.A;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Chris Yang
 * created 2022-07-17 16:48
 **/
public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Apple sweetApple = context.getBean("sweetApple", Apple.class);
        System.out.println(sweetApple.getTitle());

        Apple sourApple = (Apple) context.getBean("sourApple");
        System.out.println(sweetApple.getTitle());

        Child lily = context.getBean("Lily", Child.class);
        lily.eat();
        Child andy = context.getBean("Andy", Child.class);
        andy.eat();
        Child luna = context.getBean("Luna", Child.class);
        luna.eat();

        Apple apple = context.getBean("DevelopmentFrameWork.Spring.IoC.Entity.Apple", Apple.class);

    }
}
