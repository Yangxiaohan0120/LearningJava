package DevelopmentFrameWork.Spring.IoC;


import DevelopmentFrameWork.Spring.IoC.service.CustomerService;
import DevelopmentFrameWork.Spring.IoC.service.DepartmentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Chris Yang
 * created 2022-07-18 10:24
 **/
public class SpringApplicationAnnotation {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-annotation.xml");

//        String[] ids = context.getBeanDefinitionNames();
//        System.out.println(ids.length);
//        for(String id : ids){
//            System.out.println(id + ":" + context.getBean(id));
//        }

        CustomerService customerService = context.getBean("customerService",CustomerService.class);
        System.out.println(customerService.getcDao());

//        DepartmentService departmentService = context.getBean("departmentService",DepartmentService.class);
//        System.out.println(departmentService.getcDao());
    }
}
