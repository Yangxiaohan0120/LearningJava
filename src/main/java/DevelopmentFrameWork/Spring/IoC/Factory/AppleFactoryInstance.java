package DevelopmentFrameWork.Spring.IoC.Factory;

import DevelopmentFrameWork.Spring.IoC.Entity.Apple;

/**
 * @author Chris Yang
 * created 2022-07-17 17:41
 **/

// 工厂实例方法创建对象是指IoC容器对工厂进行实例化并调用对应的实例方法创建对象的过程。

public class AppleFactoryInstance {
    public Apple createSweetApple(){
        Apple apple = new Apple();
        apple.setTitle("红富士");
        apple.setColor("红色");
        apple.setOrigin("欧洲");
        return apple;
    }

}
