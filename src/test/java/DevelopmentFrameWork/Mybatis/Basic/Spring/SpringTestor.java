package DevelopmentFrameWork.Mybatis.Basic.Spring;

import DevelopmentFrameWork.Spring.IoC.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author Chris Yang
 * created 2022-07-18 16:12
 **/

// 将Junit4的执行权交给Spring Test，在测试用例执行前自动初始化IoC容器
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SpringTestor {
    @Resource
    private UserService userService;

    @Test
    public void testUserService(){
        userService.createUser();
    }
}
