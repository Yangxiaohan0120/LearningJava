package advanceJava.Enum;

import javax.swing.*;

/**
 * @author Chris Yang
 * created 2022-03-13 21:12
 **/
public class EnumerationMethod {
    public static void main(String[] args) {
        // 使用Season02 举例方法
        Season02.AUTUMN.compareTo(Season02.SPRING);
        // 1. valueOf
        // 2. toString
        // 3. equals
        // 4. hashCode
        // 5. getDeclaringClass
        // 6. name
        // 7. ordinal
        // 8. compareTo
        // 9. clone

        // 1.
        System.out.println(Season02.valueOf("SPRING"));// 将字符串转换为枚举类型
        Season02 t = Season02.valueOf("AUTUMN");
        Season02 m = Season02.valueOf("AUTUMN");
        System.out.println(t == m); // true 其实都是AUTUMN对象
        System.out.println(Season02.values()[3]); // 隐藏起来的方法 , 返回一个数组，包含所有的枚举对象。
        for (Season02 season02:Season02.values()) { // 增强for循环
            System.out.println(season02);
        }
        // 2.
        System.out.println(Season02.SPRING.toString());
        // 3.
        System.out.println(Season02.SPRING.equals(Season02.AUTUMN));
        // 4.
        System.out.println(Season02.SUMMER.hashCode());
        // 5.
        System.out.println(Season02.WINTER.getDeclaringClass());
        // 6.
        System.out.println(Season02.SUMMER.name());
        // 7. 输出顺序（0 - index）
        System.out.println(Season02.SUMMER.ordinal());
        // 8. 根据index比较，index1 - index2
        System.out.println(Season02.SPRING.compareTo(Season02.AUTUMN));
        // 9.

    }
}
