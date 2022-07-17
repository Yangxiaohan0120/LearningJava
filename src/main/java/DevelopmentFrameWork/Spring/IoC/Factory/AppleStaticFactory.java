package DevelopmentFrameWork.Spring.IoC.Factory;

import DevelopmentFrameWork.Spring.IoC.Entity.Apple;

/**
 * @author Chris Yang
 * created 2022-07-17 17:37
 **/
public class AppleStaticFactory {
    public static Apple createSweetApple(){
        // logger.info("");
        // 完成仅仅通过xml文件配置无法完成的一些功能，更加灵活
        Apple apple = new Apple();
        apple.setTitle("红富士");
        apple.setColor("红色");
        apple.setOrigin("欧洲");
        return apple;
    }
}
