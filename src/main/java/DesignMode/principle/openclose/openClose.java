package DesignMode.principle.openclose;

/**
 * @author Chris Yang
 * created 2022-05-24 16:21
 **/
public class openClose {
    public static void main(String[] args) {
        Course iCourse = new JavaDiscountCourse(96, "Java从零到企业级电商开发", 348d);
        JavaDiscountCourse javaCourse = (JavaDiscountCourse) iCourse;
        System.out.println("课程ID:" + javaCourse.getID() + " 课程名称:" + javaCourse.getName() + " 课程原价:" + javaCourse.getPrice() + " 课程折后价格:" + javaCourse.getDiscountPrice() + "元");

    }
}

interface Course{
    int getID();
    String getName();
    double getPrice();
}

class JavaCourse implements Course{
    private int ID;
    private String name;
    private double price;

    public JavaCourse(int ID, String name, double price) {
        this.ID = ID;
        this.name = name;
        this.price = price;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

class JavaDiscountCourse extends JavaCourse{

    public JavaDiscountCourse(int ID, String name, double price) {
        super(ID, name, price);
    }

    public double getDiscountPrice(){
        return super.getPrice()*0.08;
    }
}
