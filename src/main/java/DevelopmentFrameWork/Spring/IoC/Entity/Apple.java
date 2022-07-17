package DevelopmentFrameWork.Spring.IoC.Entity;

/**
 * @author Chris Yang
 * created 2022-07-17 16:29
 **/
public class Apple {
    private String title;
    private String color;
    private String origin;

    private Float price;

    public Apple() {
        System.out.println("无参的构造函数");
    }

    public Apple(String title, String color, String origin, Float price) {
        this.title = title;
        this.color = color;
        this.origin = origin;
        this.price = price;
    }

    public Apple(String title, String color, String origin) {
        System.out.println("有参的构造函数");
        this.title = title;
        this.color = color;
        this.origin = origin;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTitle() {
        return title;
    }

    public String getColor() {
        return color;
    }

    public String getOrigin() {
        return origin;
    }
}
