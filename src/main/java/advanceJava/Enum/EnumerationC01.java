package advanceJava.Enum;

/**
 * @author Chris Yang
 * @create 2022-03-13 20:38
 **/
public class EnumerationC01 {
    public static void main(String[] args) {
        System.out.println(Season01.SPRING);
    }
}

// 自定义枚举类的实现
class Season01{
    private String name;
    private String desc;

    // 定义了四个常量；
    public static final Season01 SPRING = new Season01("春天", "温暖");
    public static final Season01 SUMMER = new Season01("夏天", "炎热");
    public static final Season01 AUTUMN = new Season01("秋天", "凉爽");
    public static final Season01 WINTER = new Season01("冬天", "寒冷");

    // 1. 将构造器私有化，防止用户直接new
    // 2. 去掉setXX的方法，防止属性被修改
    // 3. Season内部直接创建固定的对象
    // 4. 优化：加入final一次加载完成
    private Season01(String name, String desc) {
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
