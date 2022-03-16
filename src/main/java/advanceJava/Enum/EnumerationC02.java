package advanceJava.Enum;

/**
 * @author Chris Yang
 * created 2022-03-13 20:48
 **/
public class EnumerationC02 {
    public static void main(String[] args) {
        System.out.println(Season01.SPRING);
    }
}

// 自定义枚举类的实现
// 使用枚举关键字
// 1. 默认继承Enum类
// 2. 无参构造器调用，可省略实参列表和小括号
// 3. 使用逗号间隔，最后为分号
// 4. 枚举对象必须在枚举类的行首
enum Season02 {
    // 1. 使用关键字 enum 实现枚举类
    // 2. 直接使用 常量名（实参列表）
    // 3. 多个常量对象，以逗号隔开
    // 4. 常量对象在最前面

    SPRING("春天","温暖"),

    SUMMER("夏天","炎热"),

    AUTUMN("秋天","凉爽"),

    WINTER("冬天","寒冷");

    private String name;
    private String desc;

    // 1. 将构造器私有化，防止用户直接new
    // 2. 去掉setXX的方法，防止属性被修改
    // 3. Season内部直接创建固定的对象
    // 4. 优化：加入final一次加载完成
    private Season02(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season01{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
