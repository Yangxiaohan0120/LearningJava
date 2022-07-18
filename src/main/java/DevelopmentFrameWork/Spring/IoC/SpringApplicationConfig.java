package DevelopmentFrameWork.Spring.IoC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Chris Yang
 * created 2022-07-18 11:14
 **/
public class SpringApplicationConfig {
    public static void main(String[] args) {
        // 基于注解实现IoC容器的初始化
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        String[] ids = context.getBeanDefinitionNames();
        for(String id : ids){
            System.out.println(id + ":" + context.getBean(id));
        }
    }
}
