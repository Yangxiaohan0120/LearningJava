package advanceJava.Enum;

/**
 * @author Chris Yang
 * created 2022-03-13 20:28
 **/
public class Enumeration01 {
    public static void main(String[] args) {
        Season spring = new Season("春天", "温暖");
        Season summer = new Season("夏天", "炎热");
        Season autumn = new Season("秋天", "凉爽");
        Season winter = new Season("冬天", "寒冷");

        // 为了体现固定的值，使用枚举类型。
    }
}

class Season{
    private String name;
    private String desc;

    public Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}