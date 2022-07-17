package DevelopmentFrameWork.Spring.IoC;

import DevelopmentFrameWork.Spring.IoC.Entity.Apple;
import DevelopmentFrameWork.Spring.IoC.Entity.Child;

/**
 * @author Chris Yang
 * created 2022-07-17 16:32
 **/
public class Application {

    // 对象硬关联
    // 对象数量不可定
    // 对象内容不可改

    public static void main(String[] args) {
        Apple apple1 = new Apple("红富士","红色","欧洲");
        Apple apple2 = new Apple("青苹果","绿色","中亚");
        Apple apple3 = new Apple("金帅","黄色","中国");

        Child lily = new Child("Lily",apple1);
        Child andy = new Child("Andy",apple2);
        Child luna = new Child("Luna",apple3);

        lily.eat();
        andy.eat();
        luna.eat();
    }
}
